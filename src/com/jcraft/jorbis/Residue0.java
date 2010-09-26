// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;

// Referenced classes of package com.jcraft.jorbis:
//            FuncResidue, Block, CodeBook, DspState, 
//            Info, InfoMode, Util

class Residue0 extends FuncResidue
{

    Residue0()
    {
    }

    void pack(Object obj, Buffer buffer)
    {
        InfoResidue0 inforesidue0 = (InfoResidue0)obj;
        int i = 0;
        buffer.write(inforesidue0.begin, 24);
        buffer.write(inforesidue0.end, 24);
        buffer.write(inforesidue0.grouping - 1, 24);
        buffer.write(inforesidue0.partitions - 1, 6);
        buffer.write(inforesidue0.groupbook, 8);
        for(int j = 0; j < inforesidue0.partitions; j++)
        {
            int l = inforesidue0.secondstages[j];
            if(Util.ilog(l) > 3)
            {
                buffer.write(l, 3);
                buffer.write(1, 1);
                buffer.write(l >>> 3, 5);
            } else
            {
                buffer.write(l, 4);
            }
            i += Util.icount(l);
        }

        for(int k = 0; k < i; k++)
            buffer.write(inforesidue0.booklist[k], 8);

    }

    Object unpack(Info info, Buffer buffer)
    {
        int i = 0;
        InfoResidue0 inforesidue0 = new InfoResidue0();
        inforesidue0.begin = buffer.read(24);
        inforesidue0.end = buffer.read(24);
        inforesidue0.grouping = buffer.read(24) + 1;
        inforesidue0.partitions = buffer.read(6) + 1;
        inforesidue0.groupbook = buffer.read(8);
        for(int j = 0; j < inforesidue0.partitions; j++)
        {
            int i1 = buffer.read(3);
            if(buffer.read(1) != 0)
                i1 |= buffer.read(5) << 3;
            inforesidue0.secondstages[j] = i1;
            i += Util.icount(i1);
        }

        for(int k = 0; k < i; k++)
            inforesidue0.booklist[k] = buffer.read(8);

        if(inforesidue0.groupbook >= info.books)
        {
            free_info(((Object) (inforesidue0)));
            return ((Object) (null));
        }
        for(int l = 0; l < i; l++)
            if(inforesidue0.booklist[l] >= info.books)
            {
                free_info(((Object) (inforesidue0)));
                return ((Object) (null));
            }

        return ((Object) (inforesidue0));
    }

    Object look(DspState dspstate, InfoMode infomode, Object obj)
    {
        InfoResidue0 inforesidue0 = (InfoResidue0)obj;
        LookResidue0 lookresidue0 = new LookResidue0();
        int i = 0;
        int k = 0;
        lookresidue0.info = inforesidue0;
        lookresidue0.map = infomode.mapping;
        lookresidue0.parts = inforesidue0.partitions;
        lookresidue0.fullbooks = dspstate.fullbooks;
        lookresidue0.phrasebook = dspstate.fullbooks[inforesidue0.groupbook];
        int j = lookresidue0.phrasebook.dim;
        lookresidue0.partbooks = new int[lookresidue0.parts][];
        for(int l = 0; l < lookresidue0.parts; l++)
        {
            int j1 = inforesidue0.secondstages[l];
            int l1 = Util.ilog(j1);
            if(l1 == 0)
                continue;
            if(l1 > k)
                k = l1;
            lookresidue0.partbooks[l] = new int[l1];
            for(int j2 = 0; j2 < l1; j2++)
                if((j1 & 1 << j2) != 0)
                    lookresidue0.partbooks[l][j2] = inforesidue0.booklist[i++];

        }

        lookresidue0.partvals = (int)Math.rint(Math.pow(lookresidue0.parts, j));
        lookresidue0.stages = k;
        lookresidue0.decodemap = new int[lookresidue0.partvals][];
        for(int i1 = 0; i1 < lookresidue0.partvals; i1++)
        {
            int k1 = i1;
            int i2 = lookresidue0.partvals / lookresidue0.parts;
            lookresidue0.decodemap[i1] = new int[j];
            for(int k2 = 0; k2 < j; k2++)
            {
                int l2 = k1 / i2;
                k1 -= l2 * i2;
                i2 /= lookresidue0.parts;
                lookresidue0.decodemap[i1][k2] = l2;
            }

        }

        return ((Object) (lookresidue0));
    }

    void free_info(Object obj)
    {
    }

    void free_look(Object obj)
    {
    }

    static synchronized int _01inverse(Block block, Object obj, float af[][], int i, int j)
    {
        LookResidue0 lookresidue0 = (LookResidue0)obj;
        InfoResidue0 inforesidue0 = lookresidue0.info;
        int j2 = inforesidue0.grouping;
        int k2 = lookresidue0.phrasebook.dim;
        int l2 = inforesidue0.end - inforesidue0.begin;
        int i3 = l2 / j2;
        int j3 = ((i3 + k2) - 1) / k2;
        if(_01inverse_partword.length < i)
            _01inverse_partword = new int[i][][];
        for(int l = 0; l < i; l++)
            if(_01inverse_partword[l] == null || _01inverse_partword[l].length < j3)
                _01inverse_partword[l] = new int[j3][];

        for(int i2 = 0; i2 < lookresidue0.stages; i2++)
        {
            int k = 0;
            for(int l1 = 0; k < i3; l1++)
            {
                if(i2 == 0)
                {
                    for(int i1 = 0; i1 < i; i1++)
                    {
                        int k3 = lookresidue0.phrasebook.decode(block.opb);
                        if(k3 == -1)
                            return 0;
                        _01inverse_partword[i1][l1] = lookresidue0.decodemap[k3];
                        if(_01inverse_partword[i1][l1] == null)
                            return 0;
                    }

                }
                for(int k1 = 0; k1 < k2 && k < i3; k++)
                {
                    for(int j1 = 0; j1 < i; j1++)
                    {
                        int l3 = inforesidue0.begin + k * j2;
                        int i4 = _01inverse_partword[j1][l1][k1];
                        if((inforesidue0.secondstages[i4] & 1 << i2) == 0)
                            continue;
                        CodeBook codebook = lookresidue0.fullbooks[lookresidue0.partbooks[i4][i2]];
                        if(codebook == null)
                            continue;
                        if(j == 0)
                        {
                            if(codebook.decodevs_add(af[j1], l3, block.opb, j2) == -1)
                                return 0;
                            continue;
                        }
                        if(j == 1 && codebook.decodev_add(af[j1], l3, block.opb, j2) == -1)
                            return 0;
                    }

                    k1++;
                }

            }

        }

        return 0;
    }

    static synchronized int _2inverse(Block block, Object obj, float af[][], int i)
    {
        LookResidue0 lookresidue0 = (LookResidue0)obj;
        InfoResidue0 inforesidue0 = lookresidue0.info;
        int j1 = inforesidue0.grouping;
        int k1 = lookresidue0.phrasebook.dim;
        int l1 = inforesidue0.end - inforesidue0.begin;
        int i2 = l1 / j1;
        int j2 = ((i2 + k1) - 1) / k1;
        if(_2inverse_partword == null || _2inverse_partword.length < j2)
            _2inverse_partword = new int[j2][];
        for(int i1 = 0; i1 < lookresidue0.stages; i1++)
        {
            int j = 0;
            for(int l = 0; j < i2; l++)
            {
                if(i1 == 0)
                {
                    int k2 = lookresidue0.phrasebook.decode(block.opb);
                    if(k2 == -1)
                        return 0;
                    _2inverse_partword[l] = lookresidue0.decodemap[k2];
                    if(_2inverse_partword[l] == null)
                        return 0;
                }
                for(int k = 0; k < k1 && j < i2; j++)
                {
                    int l2 = inforesidue0.begin + j * j1;
                    int i3 = _2inverse_partword[l][k];
                    if((inforesidue0.secondstages[i3] & 1 << i1) != 0)
                    {
                        CodeBook codebook = lookresidue0.fullbooks[lookresidue0.partbooks[i3][i1]];
                        if(codebook != null && codebook.decodevv_add(af, l2, i, block.opb, j1) == -1)
                            return 0;
                    }
                    k++;
                }

            }

        }

        return 0;
    }

    int inverse(Block block, Object obj, float af[][], int ai[], int i)
    {
        int j = 0;
        for(int k = 0; k < i; k++)
            if(ai[k] != 0)
                af[j++] = af[k];

        if(j != 0)
            return _01inverse(block, obj, af, j, 0);
        else
            return 0;
    }

    private static int _01inverse_partword[][][] = new int[2][][];
    static int _2inverse_partword[][] = (int[][])null;


    private class InfoResidue0
    {

        int begin;
        int end;
        int grouping;
        int partitions;
        int groupbook;
        int secondstages[];
        int booklist[];
        float entmax[];
        float ampmax[];
        int subgrp[];
        int blimit[];
        final Residue0 this$0;

        InfoResidue0()
        {
            this$0 = Residue0.this;
            super();
            secondstages = new int[64];
            booklist = new int[256];
            entmax = new float[64];
            ampmax = new float[64];
            subgrp = new int[64];
            blimit = new int[64];
        }
    }


    private class LookResidue0
    {

        InfoResidue0 info;
        int map;
        int parts;
        int stages;
        CodeBook fullbooks[];
        CodeBook phrasebook;
        int partbooks[][];
        int partvals;
        int decodemap[][];
        int postbits;
        int phrasebits;
        int frames;
        final Residue0 this$0;

        LookResidue0()
        {
            this$0 = Residue0.this;
            super();
        }
    }

}
