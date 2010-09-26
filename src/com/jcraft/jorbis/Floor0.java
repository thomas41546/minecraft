// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;
import eo;

// Referenced classes of package com.jcraft.jorbis:
//            FuncFloor, Block, CodeBook, DspState, 
//            Info, InfoMode, Lpc, Lsp, 
//            Util

class Floor0 extends FuncFloor
{

    Floor0()
    {
        lsp = null;
    }

    void pack(Object obj, Buffer buffer)
    {
        InfoFloor0 infofloor0 = (InfoFloor0)obj;
        buffer.write(infofloor0.order, 8);
        buffer.write(infofloor0.rate, 16);
        buffer.write(infofloor0.barkmap, 16);
        buffer.write(infofloor0.ampbits, 6);
        buffer.write(infofloor0.ampdB, 8);
        buffer.write(infofloor0.numbooks - 1, 4);
        for(int i = 0; i < infofloor0.numbooks; i++)
            buffer.write(infofloor0.books[i], 8);

    }

    Object unpack(Info info, Buffer buffer)
    {
        InfoFloor0 infofloor0 = new InfoFloor0();
        infofloor0.order = buffer.read(8);
        infofloor0.rate = buffer.read(16);
        infofloor0.barkmap = buffer.read(16);
        infofloor0.ampbits = buffer.read(6);
        infofloor0.ampdB = buffer.read(8);
        infofloor0.numbooks = buffer.read(4) + 1;
        if(infofloor0.order < 1 || infofloor0.rate < 1 || infofloor0.barkmap < 1 || infofloor0.numbooks < 1)
            return ((Object) (null));
        for(int i = 0; i < infofloor0.numbooks; i++)
        {
            infofloor0.books[i] = buffer.read(8);
            if(infofloor0.books[i] < 0 || infofloor0.books[i] >= info.books)
                return ((Object) (null));
        }

        return ((Object) (infofloor0));
    }

    Object look(DspState dspstate, InfoMode infomode, Object obj)
    {
        Info info = dspstate.vi;
        InfoFloor0 infofloor0 = (InfoFloor0)obj;
        LookFloor0 lookfloor0 = new LookFloor0();
        lookfloor0.m = infofloor0.order;
        lookfloor0.n = info.blocksizes[infomode.blockflag] / 2;
        lookfloor0.ln = infofloor0.barkmap;
        lookfloor0.vi = infofloor0;
        lookfloor0.lpclook.init(lookfloor0.ln, lookfloor0.m);
        float f = (float)lookfloor0.ln / toBARK((float)((double)infofloor0.rate / 2D));
        lookfloor0.linearmap = new int[lookfloor0.n];
        for(int i = 0; i < lookfloor0.n; i++)
        {
            int j = eo.d(toBARK((float)(((double)infofloor0.rate / 2D / (double)lookfloor0.n) * (double)i)) * f);
            if(j >= lookfloor0.ln)
                j = lookfloor0.ln;
            lookfloor0.linearmap[i] = j;
        }

        return ((Object) (lookfloor0));
    }

    static float toBARK(float f)
    {
        return (float)(13.1D * Math.atan(0.00073999999999999999D * (double)f) + 2.2400000000000002D * Math.atan((double)(f * f) * 1.85E-008D) + 0.0001D * (double)f);
    }

    Object state(Object obj)
    {
        EchstateFloor0 echstatefloor0 = new EchstateFloor0();
        InfoFloor0 infofloor0 = (InfoFloor0)obj;
        echstatefloor0.codewords = new int[infofloor0.order];
        echstatefloor0.curve = new float[infofloor0.barkmap];
        echstatefloor0.frameno = -1L;
        return ((Object) (echstatefloor0));
    }

    void free_info(Object obj)
    {
    }

    void free_look(Object obj)
    {
    }

    void free_state(Object obj)
    {
    }

    int forward(Block block, Object obj, float af[], float af1[], Object obj1)
    {
        return 0;
    }

    int inverse(Block block, Object obj, float af[])
    {
        LookFloor0 lookfloor0;
        InfoFloor0 infofloor0;
        float f;
        int k;
        lookfloor0 = (LookFloor0)obj;
        infofloor0 = lookfloor0.vi;
        int i = block.opb.read(infofloor0.ampbits);
        if(i <= 0)
            break MISSING_BLOCK_LABEL_389;
        int j = (1 << infofloor0.ampbits) - 1;
        f = ((float)i / (float)j) * (float)infofloor0.ampdB;
        k = block.opb.read(Util.ilog(infofloor0.numbooks));
        if(k == -1 || k >= infofloor0.numbooks)
            break MISSING_BLOCK_LABEL_389;
        Floor0 floor0 = this;
        JVM INSTR monitorenter ;
        CodeBook codebook;
        float f1;
        int j1;
        if(lsp == null || lsp.length < lookfloor0.m)
        {
            lsp = new float[lookfloor0.m];
        } else
        {
            for(int l = 0; l < lookfloor0.m; l++)
                lsp[l] = 0.0F;

        }
        codebook = block.vd.fullbooks[infofloor0.books[k]];
        f1 = 0.0F;
        for(int i1 = 0; i1 < lookfloor0.m; i1++)
            af[i1] = 0.0F;

        j1 = 0;
_L1:
        if(j1 >= lookfloor0.m)
            break MISSING_BLOCK_LABEL_279;
        if(codebook.decodevs(lsp, j1, block.opb, 1, -1) != -1)
            break MISSING_BLOCK_LABEL_266;
        for(int l1 = 0; l1 < lookfloor0.n; l1++)
            af[l1] = 0.0F;

        return 0;
        j1 += codebook.dim;
          goto _L1
        for(int k1 = 0; k1 < lookfloor0.m;)
        {
            for(int i2 = 0; i2 < codebook.dim;)
            {
                lsp[k1] += f1;
                i2++;
                k1++;
            }

            f1 = lsp[k1 - 1];
        }

        Lsp.lsp_to_curve(af, lookfloor0.linearmap, lookfloor0.n, lookfloor0.ln, lsp, lookfloor0.m, f, infofloor0.ampdB);
        1;
        floor0;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
        return 0;
    }

    Object inverse1(Block block, Object obj, Object obj1)
    {
        LookFloor0 lookfloor0 = (LookFloor0)obj;
        InfoFloor0 infofloor0 = lookfloor0.vi;
        float af[] = null;
        if(obj1 instanceof float[])
            af = (float[])(float[])obj1;
        int i = block.opb.read(infofloor0.ampbits);
        if(i > 0)
        {
            int j = (1 << infofloor0.ampbits) - 1;
            float f = ((float)i / (float)j) * (float)infofloor0.ampdB;
            int k = block.opb.read(Util.ilog(infofloor0.numbooks));
            if(k != -1 && k < infofloor0.numbooks)
            {
                CodeBook codebook = block.vd.fullbooks[infofloor0.books[k]];
                float f1 = 0.0F;
                if(af == null || af.length < lookfloor0.m + 1)
                {
                    af = new float[lookfloor0.m + 1];
                } else
                {
                    for(int l = 0; l < af.length; l++)
                        af[l] = 0.0F;

                }
                for(int i1 = 0; i1 < lookfloor0.m; i1 += codebook.dim)
                    if(codebook.decodev_set(af, i1, block.opb, codebook.dim) == -1)
                        return ((Object) (null));

                for(int j1 = 0; j1 < lookfloor0.m;)
                {
                    for(int k1 = 0; k1 < codebook.dim;)
                    {
                        af[j1] += f1;
                        k1++;
                        j1++;
                    }

                    f1 = af[j1 - 1];
                }

                af[lookfloor0.m] = f;
                return ((Object) (af));
            }
        }
        return ((Object) (null));
    }

    int inverse2(Block block, Object obj, Object obj1, float af[])
    {
        LookFloor0 lookfloor0 = (LookFloor0)obj;
        InfoFloor0 infofloor0 = lookfloor0.vi;
        if(obj1 != null)
        {
            float af1[] = (float[])(float[])obj1;
            float f = af1[lookfloor0.m];
            Lsp.lsp_to_curve(af, lookfloor0.linearmap, lookfloor0.n, lookfloor0.ln, af1, lookfloor0.m, f, infofloor0.ampdB);
            return 1;
        }
        for(int i = 0; i < lookfloor0.n; i++)
            af[i] = 0.0F;

        return 0;
    }

    static float fromdB(float f)
    {
        return (float)Math.exp((double)f * 0.11512925D);
    }

    static void lsp_to_lpc(float af[], float af1[], int i)
    {
        int j1 = i / 2;
        float af2[] = new float[j1];
        float af3[] = new float[j1];
        float af4[] = new float[j1 + 1];
        float af5[] = new float[j1 + 1];
        float af6[] = new float[j1];
        float af7[] = new float[j1];
        for(int j = 0; j < j1; j++)
        {
            af2[j] = (float)(-2D * Math.cos(af[j * 2]));
            af3[j] = (float)(-2D * Math.cos(af[j * 2 + 1]));
        }

        int l;
        for(l = 0; l < j1; l++)
        {
            af4[l] = 0.0F;
            af5[l] = 1.0F;
            af6[l] = 0.0F;
            af7[l] = 1.0F;
        }

        af5[l] = 1.0F;
        af4[l] = 1.0F;
        for(int k = 1; k < i + 1; k++)
        {
            float f1;
            float f = f1 = 0.0F;
            int i1;
            for(i1 = 0; i1 < j1; i1++)
            {
                float f2 = af2[i1] * af5[i1] + af4[i1];
                af4[i1] = af5[i1];
                af5[i1] = f;
                f += f2;
                f2 = af3[i1] * af7[i1] + af6[i1];
                af6[i1] = af7[i1];
                af7[i1] = f1;
                f1 += f2;
            }

            af1[k - 1] = ((f + af5[i1] + f1) - af4[i1]) / 2.0F;
            af5[i1] = f;
            af4[i1] = f1;
        }

    }

    static void lpc_to_curve(float af[], float af1[], float f, LookFloor0 lookfloor0, String s, int i)
    {
        float af2[] = new float[Math.max(lookfloor0.ln * 2, lookfloor0.m * 2 + 2)];
        if(f == 0.0F)
        {
            for(int j = 0; j < lookfloor0.n; j++)
                af[j] = 0.0F;

            return;
        }
        lookfloor0.lpclook.lpc_to_curve(af2, af1, f);
        for(int k = 0; k < lookfloor0.n; k++)
            af[k] = af2[lookfloor0.linearmap[k]];

    }

    float lsp[];

    private class InfoFloor0
    {

        int order;
        int rate;
        int barkmap;
        int ampbits;
        int ampdB;
        int numbooks;
        int books[];
        final Floor0 this$0;

        InfoFloor0()
        {
            this$0 = Floor0.this;
            super();
            books = new int[16];
        }
    }


    private class LookFloor0
    {

        int n;
        int ln;
        int m;
        int linearmap[];
        InfoFloor0 vi;
        Lpc lpclook;
        final Floor0 this$0;

        LookFloor0()
        {
            this$0 = Floor0.this;
            super();
            lpclook = new Lpc();
        }
    }


    private class EchstateFloor0
    {

        int codewords[];
        float curve[];
        long frameno;
        long codes;
        final Floor0 this$0;

        EchstateFloor0()
        {
            this$0 = Floor0.this;
            super();
        }
    }

}
