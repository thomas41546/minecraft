// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;

// Referenced classes of package com.jcraft.jorbis:
//            StaticCodeBook, Util

class CodeBook
{

    CodeBook()
    {
        c = new StaticCodeBook();
        t = new int[15];
    }

    int encode(int i, Buffer buffer)
    {
        buffer.write(codelist[i], c.lengthlist[i]);
        return c.lengthlist[i];
    }

    int errorv(float af[])
    {
        int i = best(af, 1);
        for(int j = 0; j < dim; j++)
            af[j] = valuelist[i * dim + j];

        return i;
    }

    int encodev(int i, float af[], Buffer buffer)
    {
        for(int j = 0; j < dim; j++)
            af[j] = valuelist[i * dim + j];

        return encode(i, buffer);
    }

    int encodevs(float af[], Buffer buffer, int i, int j)
    {
        int k = besterror(af, i, j);
        return encode(k, buffer);
    }

    synchronized int decodevs_add(float af[], int i, Buffer buffer, int j)
    {
        int k = j / dim;
        if(t.length < k)
            t = new int[k];
        for(int i1 = 0; i1 < k; i1++)
        {
            int l = decode(buffer);
            if(l == -1)
                return -1;
            t[i1] = l * dim;
        }

        int j1 = 0;
        for(int l1 = 0; j1 < dim; l1 += k)
        {
            for(int k1 = 0; k1 < k; k1++)
                af[i + l1 + k1] += valuelist[t[k1] + j1];

            j1++;
        }

        return 0;
    }

    int decodev_add(float af[], int i, Buffer buffer, int j)
    {
        if(dim <= 8) goto _L2; else goto _L1
_L1:
        for(int k = 0; k < j;)
        {
            int k1 = decode(buffer);
            if(k1 == -1)
                return -1;
            int i2 = k1 * dim;
            int i1 = 0;
            while(i1 < dim) 
                af[i + k++] += valuelist[i2 + i1++];
        }

          goto _L3
_L2:
        int l = 0;
_L5:
        if(l < j)
        {
            int l1 = decode(buffer);
            if(l1 == -1)
                return -1;
            int j2 = l1 * dim;
            int j1 = 0;
            switch(dim)
            {
            case 8: // '\b'
                af[i + l++] += valuelist[j2 + j1++];
                // fall through

            case 7: // '\007'
                af[i + l++] += valuelist[j2 + j1++];
                // fall through

            case 6: // '\006'
                af[i + l++] += valuelist[j2 + j1++];
                // fall through

            case 5: // '\005'
                af[i + l++] += valuelist[j2 + j1++];
                // fall through

            case 4: // '\004'
                af[i + l++] += valuelist[j2 + j1++];
                // fall through

            case 3: // '\003'
                af[i + l++] += valuelist[j2 + j1++];
                // fall through

            case 2: // '\002'
                af[i + l++] += valuelist[j2 + j1++];
                // fall through

            case 1: // '\001'
                af[i + l++] += valuelist[j2 + j1++];
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
_L3:
        return 0;
        if(true) goto _L5; else goto _L4
_L4:
    }

    int decodev_set(float af[], int i, Buffer buffer, int j)
    {
        for(int k = 0; k < j;)
        {
            int i1 = decode(buffer);
            if(i1 == -1)
                return -1;
            int j1 = i1 * dim;
            int l = 0;
            while(l < dim) 
                af[i + k++] = valuelist[j1 + l++];
        }

        return 0;
    }

    int decodevv_add(float af[][], int i, int j, Buffer buffer, int k)
    {
        int k1 = 0;
        for(int l = i / j; l < (i + k) / j;)
        {
            int j1 = decode(buffer);
            if(j1 == -1)
                return -1;
            int l1 = j1 * dim;
            int i1 = 0;
            while(i1 < dim) 
            {
                af[k1++][l] += valuelist[l1 + i1];
                if(k1 == j)
                {
                    k1 = 0;
                    l++;
                }
                i1++;
            }
        }

        return 0;
    }

    int decode(Buffer buffer)
    {
        int i = 0;
        DecodeAux decodeaux = decode_tree;
        int j = buffer.look(decodeaux.tabn);
        if(j >= 0)
        {
            i = decodeaux.tab[j];
            buffer.adv(decodeaux.tabl[j]);
            if(i <= 0)
                return -i;
        }
        do
            switch(buffer.read1())
            {
            case 0: // '\0'
                i = decodeaux.ptr0[i];
                break;

            case 1: // '\001'
                i = decodeaux.ptr1[i];
                break;

            case -1: 
            default:
                return -1;
            }
        while(i > 0);
        return -i;
    }

    int decodevs(float af[], int i, Buffer buffer, int j, int k)
    {
        int l = decode(buffer);
        if(l == -1)
            return -1;
        switch(k)
        {
        default:
            break;

        case -1: 
            int i1 = 0;
            for(int l1 = 0; i1 < dim; l1 += j)
            {
                af[i + l1] = valuelist[l * dim + i1];
                i1++;
            }

            break;

        case 0: // '\0'
            int j1 = 0;
            for(int i2 = 0; j1 < dim; i2 += j)
            {
                af[i + i2] += valuelist[l * dim + j1];
                j1++;
            }

            break;

        case 1: // '\001'
            int k1 = 0;
            for(int j2 = 0; k1 < dim; j2 += j)
            {
                af[i + j2] *= valuelist[l * dim + k1];
                k1++;
            }

            break;
        }
        return l;
    }

    int best(float af[], int i)
    {
        int j = -1;
        float f = 0.0F;
        int k = 0;
        for(int l = 0; l < entries; l++)
        {
            if(c.lengthlist[l] > 0)
            {
                float f1 = dist(dim, valuelist, k, af, i);
                if(j == -1 || f1 < f)
                {
                    f = f1;
                    j = l;
                }
            }
            k += dim;
        }

        return j;
    }

    int besterror(float af[], int i, int j)
    {
        int k = best(af, i);
label0:
        switch(j)
        {
        default:
            break;

        case 0: // '\0'
            int l = 0;
            for(int j1 = 0; l < dim; j1 += i)
            {
                af[j1] -= valuelist[k * dim + l];
                l++;
            }

            break;

        case 1: // '\001'
            int i1 = 0;
            int k1 = 0;
            do
            {
                if(i1 >= dim)
                    break label0;
                float f = valuelist[k * dim + i1];
                if(f == 0.0F)
                    af[k1] = 0.0F;
                else
                    af[k1] /= f;
                i1++;
                k1 += i;
            } while(true);
        }
        return k;
    }

    void clear()
    {
    }

    private static float dist(int i, float af[], int j, float af1[], int k)
    {
        float f = 0.0F;
        for(int l = 0; l < i; l++)
        {
            float f1 = af[j + l] - af1[l * k];
            f += f1 * f1;
        }

        return f;
    }

    int init_decode(StaticCodeBook staticcodebook)
    {
        c = staticcodebook;
        entries = staticcodebook.entries;
        dim = staticcodebook.dim;
        valuelist = staticcodebook.unquantize();
        decode_tree = make_decode_tree();
        if(decode_tree == null)
        {
            clear();
            return -1;
        } else
        {
            return 0;
        }
    }

    static int[] make_words(int ai[], int i)
    {
        int ai1[] = new int[33];
        int ai2[] = new int[i];
        for(int j = 0; j < i; j++)
        {
            int l = ai[j];
            if(l <= 0)
                continue;
            int j1 = ai1[l];
            if(l < 32 && j1 >>> l != 0)
                return null;
            ai2[j] = j1;
            int l1 = l;
            do
            {
                if(l1 <= 0)
                    break;
                if((ai1[l1] & 1) != 0)
                {
                    if(l1 == 1)
                        ai1[1]++;
                    else
                        ai1[l1] = ai1[l1 - 1] << 1;
                    break;
                }
                ai1[l1]++;
                l1--;
            } while(true);
            for(int i2 = l + 1; i2 < 33 && ai1[i2] >>> 1 == j1; i2++)
            {
                j1 = ai1[i2];
                ai1[i2] = ai1[i2 - 1] << 1;
            }

        }

        for(int k = 0; k < i; k++)
        {
            int i1 = 0;
            for(int k1 = 0; k1 < ai[k]; k1++)
            {
                i1 <<= 1;
                i1 |= ai2[k] >>> k1 & 1;
            }

            ai2[k] = i1;
        }

        return ai2;
    }

    DecodeAux make_decode_tree()
    {
        int i = 0;
        DecodeAux decodeaux = new DecodeAux();
        int ai[] = decodeaux.ptr0 = new int[entries * 2];
        int ai1[] = decodeaux.ptr1 = new int[entries * 2];
        int ai2[] = make_words(c.lengthlist, c.entries);
        if(ai2 == null)
            return null;
        decodeaux.aux = entries * 2;
        for(int j = 0; j < entries; j++)
        {
            if(c.lengthlist[j] <= 0)
                continue;
            int l = 0;
            int j1;
            for(j1 = 0; j1 < c.lengthlist[j] - 1; j1++)
            {
                int l1 = ai2[j] >>> j1 & 1;
                if(l1 == 0)
                {
                    if(ai[l] == 0)
                        ai[l] = ++i;
                    l = ai[l];
                    continue;
                }
                if(ai1[l] == 0)
                    ai1[l] = ++i;
                l = ai1[l];
            }

            if((ai2[j] >>> j1 & 1) == 0)
                ai[l] = -j;
            else
                ai1[l] = -j;
        }

        decodeaux.tabn = Util.ilog(entries) - 4;
        if(decodeaux.tabn < 5)
            decodeaux.tabn = 5;
        int k = 1 << decodeaux.tabn;
        decodeaux.tab = new int[k];
        decodeaux.tabl = new int[k];
        for(int i1 = 0; i1 < k; i1++)
        {
            int k1 = 0;
            int i2 = 0;
            for(i2 = 0; i2 < decodeaux.tabn && (k1 > 0 || i2 == 0); i2++)
                if((i1 & 1 << i2) != 0)
                    k1 = ai1[k1];
                else
                    k1 = ai[k1];

            decodeaux.tab[i1] = k1;
            decodeaux.tabl[i1] = i2;
        }

        return decodeaux;
    }

    int dim;
    int entries;
    StaticCodeBook c;
    float valuelist[];
    int codelist[];
    DecodeAux decode_tree;
    private int t[];

    private class DecodeAux
    {

        int tab[];
        int tabl[];
        int tabn;
        int ptr0[];
        int ptr1[];
        int aux;
        final CodeBook this$0;

        DecodeAux()
        {
            this$0 = CodeBook.this;
            super();
        }
    }

}
