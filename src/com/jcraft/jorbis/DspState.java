// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;


// Referenced classes of package com.jcraft.jorbis:
//            Block, CodeBook, FuncMapping, Info, 
//            InfoMode, Mdct, Util

public class DspState
{

    public DspState()
    {
        transform = new Object[2][];
        window = new float[2][][][][];
        window[0] = new float[2][][][];
        window[0][0] = new float[2][][];
        window[0][1] = new float[2][][];
        window[0][0][0] = new float[2][];
        window[0][0][1] = new float[2][];
        window[0][1][0] = new float[2][];
        window[0][1][1] = new float[2][];
        window[1] = new float[2][][][];
        window[1][0] = new float[2][][];
        window[1][1] = new float[2][][];
        window[1][0][0] = new float[2][];
        window[1][0][1] = new float[2][];
        window[1][1][0] = new float[2][];
        window[1][1][1] = new float[2][];
    }

    static float[] window(int i, int j, int k, int l)
    {
        float af[] = new float[j];
        switch(i)
        {
        case 0: // '\0'
            int i1 = j / 4 - k / 2;
            int j1 = j - j / 4 - l / 2;
            for(int k1 = 0; k1 < k; k1++)
            {
                float f = (float)(((((double)k1 + 0.5D) / (double)k) * 3.1415927410125732D) / 2D);
                f = (float)Math.sin(f);
                f *= f;
                f = (float)((double)f * 1.5707963705062866D);
                f = (float)Math.sin(f);
                af[k1 + i1] = f;
            }

            for(int l1 = i1 + k; l1 < j1; l1++)
                af[l1] = 1.0F;

            for(int i2 = 0; i2 < l; i2++)
            {
                float f1 = (float)(((((double)(l - i2) - 0.5D) / (double)l) * 3.1415927410125732D) / 2D);
                f1 = (float)Math.sin(f1);
                f1 *= f1;
                f1 = (float)((double)f1 * 1.5707963705062866D);
                f1 = (float)Math.sin(f1);
                af[i2 + j1] = f1;
            }

            break;

        default:
            return null;
        }
        return af;
    }

    int init(Info info, boolean flag)
    {
        vi = info;
        modebits = Util.ilog2(info.modes);
        transform[0] = new Object[1];
        transform[1] = new Object[1];
        transform[0][0] = ((Object) (new Mdct()));
        transform[1][0] = ((Object) (new Mdct()));
        ((Mdct)transform[0][0]).init(info.blocksizes[0]);
        ((Mdct)transform[1][0]).init(info.blocksizes[1]);
        window[0][0][0] = new float[1][];
        window[0][0][1] = window[0][0][0];
        window[0][1][0] = window[0][0][0];
        window[0][1][1] = window[0][0][0];
        window[1][0][0] = new float[1][];
        window[1][0][1] = new float[1][];
        window[1][1][0] = new float[1][];
        window[1][1][1] = new float[1][];
        for(int i = 0; i < 1; i++)
        {
            window[0][0][0][i] = window(i, info.blocksizes[0], info.blocksizes[0] / 2, info.blocksizes[0] / 2);
            window[1][0][0][i] = window(i, info.blocksizes[1], info.blocksizes[0] / 2, info.blocksizes[0] / 2);
            window[1][0][1][i] = window(i, info.blocksizes[1], info.blocksizes[0] / 2, info.blocksizes[1] / 2);
            window[1][1][0][i] = window(i, info.blocksizes[1], info.blocksizes[1] / 2, info.blocksizes[0] / 2);
            window[1][1][1][i] = window(i, info.blocksizes[1], info.blocksizes[1] / 2, info.blocksizes[1] / 2);
        }

        fullbooks = new CodeBook[info.books];
        for(int j = 0; j < info.books; j++)
        {
            fullbooks[j] = new CodeBook();
            fullbooks[j].init_decode(info.book_param[j]);
        }

        pcm_storage = 8192;
        pcm = new float[info.channels][];
        for(int k = 0; k < info.channels; k++)
            pcm[k] = new float[pcm_storage];

        lW = 0;
        W = 0;
        centerW = info.blocksizes[1] / 2;
        pcm_current = centerW;
        mode = new Object[info.modes];
        for(int l = 0; l < info.modes; l++)
        {
            int i1 = info.mode_param[l].mapping;
            int j1 = info.map_type[i1];
            mode[l] = FuncMapping.mapping_P[j1].look(this, info.mode_param[l], info.map_param[i1]);
        }

        return 0;
    }

    public int synthesis_init(Info info)
    {
        init(info, false);
        pcm_returned = centerW;
        centerW -= info.blocksizes[W] / 4 + info.blocksizes[lW] / 4;
        granulepos = -1L;
        sequence = -1L;
        return 0;
    }

    DspState(Info info)
    {
        this();
        init(info, false);
        pcm_returned = centerW;
        centerW -= info.blocksizes[W] / 4 + info.blocksizes[lW] / 4;
        granulepos = -1L;
        sequence = -1L;
    }

    public int synthesis_blockin(Block block)
    {
        if(centerW > vi.blocksizes[1] / 2 && pcm_returned > 8192)
        {
            int i = centerW - vi.blocksizes[1] / 2;
            i = pcm_returned >= i ? i : pcm_returned;
            pcm_current -= i;
            centerW -= i;
            pcm_returned -= i;
            if(i != 0)
            {
                for(int k = 0; k < vi.channels; k++)
                    System.arraycopy(((Object) (pcm[k])), i, ((Object) (pcm[k])), 0, pcm_current);

            }
        }
        lW = W;
        W = block.W;
        nW = -1;
        glue_bits += block.glue_bits;
        time_bits += block.time_bits;
        floor_bits += block.floor_bits;
        res_bits += block.res_bits;
        if(sequence + 1L != block.sequence)
            granulepos = -1L;
        sequence = block.sequence;
        int j = vi.blocksizes[W];
        int l = centerW + vi.blocksizes[lW] / 4 + j / 4;
        int i1 = l - j / 2;
        int j1 = i1 + j;
        int k1 = 0;
        int l1 = 0;
        if(j1 > pcm_storage)
        {
            pcm_storage = j1 + vi.blocksizes[1];
            for(int i2 = 0; i2 < vi.channels; i2++)
            {
                float af[] = new float[pcm_storage];
                System.arraycopy(((Object) (pcm[i2])), 0, ((Object) (af)), 0, pcm[i2].length);
                pcm[i2] = af;
            }

        }
        switch(W)
        {
        case 0: // '\0'
            k1 = 0;
            l1 = vi.blocksizes[0] / 2;
            break;

        case 1: // '\001'
            k1 = vi.blocksizes[1] / 4 - vi.blocksizes[lW] / 4;
            l1 = k1 + vi.blocksizes[lW] / 2;
            break;
        }
        for(int j2 = 0; j2 < vi.channels; j2++)
        {
            int k2 = i1;
            int l2 = 0;
            for(l2 = k1; l2 < l1; l2++)
                pcm[j2][k2 + l2] += block.pcm[j2][l2];

            for(; l2 < j; l2++)
                pcm[j2][k2 + l2] = block.pcm[j2][l2];

        }

        if(granulepos == -1L)
        {
            granulepos = block.granulepos;
        } else
        {
            granulepos += l - centerW;
            if(block.granulepos != -1L && granulepos != block.granulepos)
            {
                if(granulepos > block.granulepos && block.eofflag != 0)
                    l = (int)((long)l - (granulepos - block.granulepos));
                granulepos = block.granulepos;
            }
        }
        centerW = l;
        pcm_current = j1;
        if(block.eofflag != 0)
            eofflag = 1;
        return 0;
    }

    public int synthesis_pcmout(float af[][][], int ai[])
    {
        if(pcm_returned < centerW)
        {
            if(af != null)
            {
                for(int i = 0; i < vi.channels; i++)
                    ai[i] = pcm_returned;

                af[0] = pcm;
            }
            return centerW - pcm_returned;
        } else
        {
            return 0;
        }
    }

    public int synthesis_read(int i)
    {
        if(i != 0 && pcm_returned + i > centerW)
        {
            return -1;
        } else
        {
            pcm_returned += i;
            return 0;
        }
    }

    public void clear()
    {
    }

    static final float M_PI = 3.141593F;
    static final int VI_TRANSFORMB = 1;
    static final int VI_WINDOWB = 1;
    int analysisp;
    Info vi;
    int modebits;
    float pcm[][];
    int pcm_storage;
    int pcm_current;
    int pcm_returned;
    float multipliers[];
    int envelope_storage;
    int envelope_current;
    int eofflag;
    int lW;
    int W;
    int nW;
    int centerW;
    long granulepos;
    long sequence;
    long glue_bits;
    long time_bits;
    long floor_bits;
    long res_bits;
    float window[][][][][];
    Object transform[][];
    CodeBook fullbooks[];
    Object mode[];
    byte header[];
    byte header1[];
    byte header2[];
}
