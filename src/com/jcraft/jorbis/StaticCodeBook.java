// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;
import eo;

// Referenced classes of package com.jcraft.jorbis:
//            Util

class StaticCodeBook
{

    StaticCodeBook()
    {
    }

    int pack(Buffer buffer)
    {
        boolean flag = false;
        buffer.write(0x564342, 24);
        buffer.write(dim, 16);
        buffer.write(entries, 24);
        int i;
        for(i = 1; i < entries && lengthlist[i] >= lengthlist[i - 1]; i++);
        if(i == entries)
            flag = true;
        if(flag)
        {
            int k1 = 0;
            buffer.write(1, 1);
            buffer.write(lengthlist[0] - 1, 5);
            int j;
            for(j = 1; j < entries; j++)
            {
                int i2 = lengthlist[j];
                int j2 = lengthlist[j - 1];
                if(i2 <= j2)
                    continue;
                for(int k2 = j2; k2 < i2; k2++)
                {
                    buffer.write(j - k1, Util.ilog(entries - k1));
                    k1 = j;
                }

            }

            buffer.write(j - k1, Util.ilog(entries - k1));
        } else
        {
            buffer.write(0, 1);
            int k;
            for(k = 0; k < entries && lengthlist[k] != 0; k++);
            if(k == entries)
            {
                buffer.write(0, 1);
                for(int l = 0; l < entries; l++)
                    buffer.write(lengthlist[l] - 1, 5);

            } else
            {
                buffer.write(1, 1);
                for(int i1 = 0; i1 < entries; i1++)
                    if(lengthlist[i1] == 0)
                    {
                        buffer.write(0, 1);
                    } else
                    {
                        buffer.write(1, 1);
                        buffer.write(lengthlist[i1] - 1, 5);
                    }

            }
        }
        buffer.write(maptype, 4);
        switch(maptype)
        {
        default:
            return -1;

        case 1: // '\001'
        case 2: // '\002'
            if(quantlist == null)
                return -1;
            buffer.write(q_min, 32);
            buffer.write(q_delta, 32);
            buffer.write(q_quant - 1, 4);
            buffer.write(q_sequencep, 1);
            int l1 = 0;
            switch(maptype)
            {
            case 1: // '\001'
                l1 = maptype1_quantvals();
                break;

            case 2: // '\002'
                l1 = entries * dim;
                break;
            }
            for(int j1 = 0; j1 < l1; j1++)
                buffer.write(Math.abs(quantlist[j1]), q_quant);

            // fall through

        case 0: // '\0'
            return 0;
        }
    }

    int unpack(Buffer buffer)
    {
        if(buffer.read(24) != 0x564342)
        {
            clear();
            return -1;
        }
        dim = buffer.read(16);
        entries = buffer.read(24);
        if(entries == -1)
        {
            clear();
            return -1;
        }
        switch(buffer.read(1))
        {
        case 0: // '\0'
            lengthlist = new int[entries];
            if(buffer.read(1) != 0)
            {
                for(int i = 0; i < entries; i++)
                    if(buffer.read(1) != 0)
                    {
                        int i1 = buffer.read(5);
                        if(i1 == -1)
                        {
                            clear();
                            return -1;
                        }
                        lengthlist[i] = i1 + 1;
                    } else
                    {
                        lengthlist[i] = 0;
                    }

            } else
            {
                for(int j = 0; j < entries; j++)
                {
                    int j1 = buffer.read(5);
                    if(j1 == -1)
                    {
                        clear();
                        return -1;
                    }
                    lengthlist[j] = j1 + 1;
                }

            }
            break;

        case 1: // '\001'
            int k1 = buffer.read(5) + 1;
            lengthlist = new int[entries];
            for(int k = 0; k < entries;)
            {
                int i2 = buffer.read(Util.ilog(entries - k));
                if(i2 == -1)
                {
                    clear();
                    return -1;
                }
                for(int j2 = 0; j2 < i2;)
                {
                    lengthlist[k] = k1;
                    j2++;
                    k++;
                }

                k1++;
            }

            break;

        default:
            return -1;
        }
        switch(maptype = buffer.read(4))
        {
        default:
            clear();
            return -1;

        case 1: // '\001'
        case 2: // '\002'
            q_min = buffer.read(32);
            q_delta = buffer.read(32);
            q_quant = buffer.read(4) + 1;
            q_sequencep = buffer.read(1);
            int l1 = 0;
            switch(maptype)
            {
            case 1: // '\001'
                l1 = maptype1_quantvals();
                break;

            case 2: // '\002'
                l1 = entries * dim;
                break;
            }
            quantlist = new int[l1];
            for(int l = 0; l < l1; l++)
                quantlist[l] = buffer.read(q_quant);

            if(quantlist[l1 - 1] == -1)
            {
                clear();
                return -1;
            }
            // fall through

        case 0: // '\0'
            return 0;
        }
    }

    private int maptype1_quantvals()
    {
        int i = eo.b(Math.pow(entries, 1.0D / (double)dim));
        do
        {
            int j = 1;
            int k = 1;
            for(int l = 0; l < dim; l++)
            {
                j *= i;
                k *= i + 1;
            }

            if(j <= entries && k > entries)
                return i;
            if(j > entries)
                i--;
            else
                i++;
        } while(true);
    }

    void clear()
    {
    }

    float[] unquantize()
    {
        if(maptype == 1 || maptype == 2)
        {
            float f = float32_unpack(q_min);
            float f1 = float32_unpack(q_delta);
            float af[] = new float[entries * dim];
label0:
            switch(maptype)
            {
            default:
                break;

            case 1: // '\001'
                int i = maptype1_quantvals();
                for(int j = 0; j < entries; j++)
                {
                    float f2 = 0.0F;
                    int l = 1;
                    for(int j1 = 0; j1 < dim; j1++)
                    {
                        int k1 = (j / l) % i;
                        float f5 = quantlist[k1];
                        f5 = Math.abs(f5) * f1 + f + f2;
                        if(q_sequencep != 0)
                            f2 = f5;
                        af[j * dim + j1] = f5;
                        l *= i;
                    }

                }

                break;

            case 2: // '\002'
                int k = 0;
                do
                {
                    if(k >= entries)
                        break label0;
                    float f3 = 0.0F;
                    for(int i1 = 0; i1 < dim; i1++)
                    {
                        float f4 = quantlist[k * dim + i1];
                        f4 = Math.abs(f4) * f1 + f + f3;
                        if(q_sequencep != 0)
                            f3 = f4;
                        af[k * dim + i1] = f4;
                    }

                    k++;
                } while(true);
            }
            return af;
        } else
        {
            return null;
        }
    }

    static long float32_pack(float f)
    {
        int i = 0;
        if(f < 0.0F)
        {
            i = 0x80000000;
            f = -f;
        }
        int j = eo.b(Math.log(f) / Math.log(2D));
        int k = (int)Math.rint(Math.pow(f, 20 - j));
        j = j + 768 << 21;
        return (long)(i | j | k);
    }

    static float float32_unpack(int i)
    {
        float f = i & 0x1fffff;
        float f1 = (i & 0x7fe00000) >>> 21;
        if((i & 0x80000000) != 0)
            f = -f;
        return ldexp(f, (int)f1 - 20 - 768);
    }

    static float ldexp(float f, int i)
    {
        return (float)((double)f * Math.pow(2D, i));
    }

    int dim;
    int entries;
    int lengthlist[];
    int maptype;
    int q_min;
    int q_delta;
    int q_quant;
    int q_sequencep;
    int quantlist[];
    static final int VQ_FEXP = 10;
    static final int VQ_FMAN = 21;
    static final int VQ_FEXP_BIAS = 768;
}
