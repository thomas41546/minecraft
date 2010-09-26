// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;

// Referenced classes of package com.jcraft.jorbis:
//            FuncMapping, Block, DspState, FuncFloor, 
//            FuncResidue, FuncTime, Info, InfoMode, 
//            Mdct, Util

class Mapping0 extends FuncMapping
{

    Mapping0()
    {
        pcmbundle = (float[][])null;
        zerobundle = null;
        nonzero = null;
        floormemo = null;
    }

    void free_info(Object obj)
    {
    }

    void free_look(Object obj)
    {
    }

    Object look(DspState dspstate, InfoMode infomode, Object obj)
    {
        Info info = dspstate.vi;
        LookMapping0 lookmapping0 = new LookMapping0();
        InfoMapping0 infomapping0 = lookmapping0.map = (InfoMapping0)obj;
        lookmapping0.mode = infomode;
        lookmapping0.time_look = new Object[infomapping0.submaps];
        lookmapping0.floor_look = new Object[infomapping0.submaps];
        lookmapping0.residue_look = new Object[infomapping0.submaps];
        lookmapping0.time_func = new FuncTime[infomapping0.submaps];
        lookmapping0.floor_func = new FuncFloor[infomapping0.submaps];
        lookmapping0.residue_func = new FuncResidue[infomapping0.submaps];
        for(int i = 0; i < infomapping0.submaps; i++)
        {
            int j = infomapping0.timesubmap[i];
            int k = infomapping0.floorsubmap[i];
            int l = infomapping0.residuesubmap[i];
            lookmapping0.time_func[i] = FuncTime.time_P[info.time_type[j]];
            lookmapping0.time_look[i] = lookmapping0.time_func[i].look(dspstate, infomode, info.time_param[j]);
            lookmapping0.floor_func[i] = FuncFloor.floor_P[info.floor_type[k]];
            lookmapping0.floor_look[i] = lookmapping0.floor_func[i].look(dspstate, infomode, info.floor_param[k]);
            lookmapping0.residue_func[i] = FuncResidue.residue_P[info.residue_type[l]];
            lookmapping0.residue_look[i] = lookmapping0.residue_func[i].look(dspstate, infomode, info.residue_param[l]);
        }

        if(info.psys != 0)
            if(dspstate.analysisp == 0);
        lookmapping0.ch = info.channels;
        return ((Object) (lookmapping0));
    }

    void pack(Info info, Object obj, Buffer buffer)
    {
        InfoMapping0 infomapping0 = (InfoMapping0)obj;
        if(infomapping0.submaps > 1)
        {
            buffer.write(1, 1);
            buffer.write(infomapping0.submaps - 1, 4);
        } else
        {
            buffer.write(0, 1);
        }
        if(infomapping0.coupling_steps > 0)
        {
            buffer.write(1, 1);
            buffer.write(infomapping0.coupling_steps - 1, 8);
            for(int i = 0; i < infomapping0.coupling_steps; i++)
            {
                buffer.write(infomapping0.coupling_mag[i], Util.ilog2(info.channels));
                buffer.write(infomapping0.coupling_ang[i], Util.ilog2(info.channels));
            }

        } else
        {
            buffer.write(0, 1);
        }
        buffer.write(0, 2);
        if(infomapping0.submaps > 1)
        {
            for(int j = 0; j < info.channels; j++)
                buffer.write(infomapping0.chmuxlist[j], 4);

        }
        for(int k = 0; k < infomapping0.submaps; k++)
        {
            buffer.write(infomapping0.timesubmap[k], 8);
            buffer.write(infomapping0.floorsubmap[k], 8);
            buffer.write(infomapping0.residuesubmap[k], 8);
        }

    }

    Object unpack(Info info, Buffer buffer)
    {
        InfoMapping0 infomapping0 = new InfoMapping0();
        if(buffer.read(1) != 0)
            infomapping0.submaps = buffer.read(4) + 1;
        else
            infomapping0.submaps = 1;
        if(buffer.read(1) != 0)
        {
            infomapping0.coupling_steps = buffer.read(8) + 1;
            for(int i = 0; i < infomapping0.coupling_steps; i++)
            {
                int l = infomapping0.coupling_mag[i] = buffer.read(Util.ilog2(info.channels));
                int i1 = infomapping0.coupling_ang[i] = buffer.read(Util.ilog2(info.channels));
                if(l < 0 || i1 < 0 || l == i1 || l >= info.channels || i1 >= info.channels)
                {
                    infomapping0.free();
                    return ((Object) (null));
                }
            }

        }
        if(buffer.read(2) > 0)
        {
            infomapping0.free();
            return ((Object) (null));
        }
        if(infomapping0.submaps > 1)
        {
            for(int j = 0; j < info.channels; j++)
            {
                infomapping0.chmuxlist[j] = buffer.read(4);
                if(infomapping0.chmuxlist[j] >= infomapping0.submaps)
                {
                    infomapping0.free();
                    return ((Object) (null));
                }
            }

        }
        for(int k = 0; k < infomapping0.submaps; k++)
        {
            infomapping0.timesubmap[k] = buffer.read(8);
            if(infomapping0.timesubmap[k] >= info.times)
            {
                infomapping0.free();
                return ((Object) (null));
            }
            infomapping0.floorsubmap[k] = buffer.read(8);
            if(infomapping0.floorsubmap[k] >= info.floors)
            {
                infomapping0.free();
                return ((Object) (null));
            }
            infomapping0.residuesubmap[k] = buffer.read(8);
            if(infomapping0.residuesubmap[k] >= info.residues)
            {
                infomapping0.free();
                return ((Object) (null));
            }
        }

        return ((Object) (infomapping0));
    }

    synchronized int inverse(Block block, Object obj)
    {
        DspState dspstate = block.vd;
        Info info = dspstate.vi;
        LookMapping0 lookmapping0 = (LookMapping0)obj;
        InfoMapping0 infomapping0 = lookmapping0.map;
        InfoMode infomode = lookmapping0.mode;
        int i = block.pcmend = info.blocksizes[block.W];
        float af[] = dspstate.window[block.W][block.lW][block.nW][infomode.windowtype];
        if(pcmbundle == null || pcmbundle.length < info.channels)
        {
            pcmbundle = new float[info.channels][];
            nonzero = new int[info.channels];
            zerobundle = new int[info.channels];
            floormemo = new Object[info.channels];
        }
        for(int j = 0; j < info.channels; j++)
        {
            float af1[] = block.pcm[j];
            int j2 = infomapping0.chmuxlist[j];
            floormemo[j] = lookmapping0.floor_func[j2].inverse1(block, lookmapping0.floor_look[j2], floormemo[j]);
            if(floormemo[j] != null)
                nonzero[j] = 1;
            else
                nonzero[j] = 0;
            for(int k3 = 0; k3 < i / 2; k3++)
                af1[k3] = 0.0F;

        }

        for(int k = 0; k < infomapping0.coupling_steps; k++)
            if(nonzero[infomapping0.coupling_mag[k]] != 0 || nonzero[infomapping0.coupling_ang[k]] != 0)
            {
                nonzero[infomapping0.coupling_mag[k]] = 1;
                nonzero[infomapping0.coupling_ang[k]] = 1;
            }

        for(int l = 0; l < infomapping0.submaps; l++)
        {
            int i2 = 0;
            for(int k2 = 0; k2 < info.channels; k2++)
            {
                if(infomapping0.chmuxlist[k2] != l)
                    continue;
                if(nonzero[k2] != 0)
                    zerobundle[i2] = 1;
                else
                    zerobundle[i2] = 0;
                pcmbundle[i2++] = block.pcm[k2];
            }

            lookmapping0.residue_func[l].inverse(block, lookmapping0.residue_look[l], pcmbundle, zerobundle, i2);
        }

        for(int i1 = infomapping0.coupling_steps - 1; i1 >= 0; i1--)
        {
            float af2[] = block.pcm[infomapping0.coupling_mag[i1]];
            float af6[] = block.pcm[infomapping0.coupling_ang[i1]];
            for(int l3 = 0; l3 < i / 2; l3++)
            {
                float f = af2[l3];
                float f1 = af6[l3];
                if(f > 0.0F)
                {
                    if(f1 > 0.0F)
                    {
                        af2[l3] = f;
                        af6[l3] = f - f1;
                    } else
                    {
                        af6[l3] = f;
                        af2[l3] = f + f1;
                    }
                    continue;
                }
                if(f1 > 0.0F)
                {
                    af2[l3] = f;
                    af6[l3] = f + f1;
                } else
                {
                    af6[l3] = f;
                    af2[l3] = f - f1;
                }
            }

        }

        for(int j1 = 0; j1 < info.channels; j1++)
        {
            float af3[] = block.pcm[j1];
            int l2 = infomapping0.chmuxlist[j1];
            lookmapping0.floor_func[l2].inverse2(block, lookmapping0.floor_look[l2], floormemo[j1], af3);
        }

        for(int k1 = 0; k1 < info.channels; k1++)
        {
            float af4[] = block.pcm[k1];
            ((Mdct)dspstate.transform[block.W][0]).backward(af4, af4);
        }

        for(int l1 = 0; l1 < info.channels; l1++)
        {
            float af5[] = block.pcm[l1];
            if(nonzero[l1] != 0)
            {
                for(int i3 = 0; i3 < i; i3++)
                    af5[i3] *= af[i3];

                continue;
            }
            for(int j3 = 0; j3 < i; j3++)
                af5[j3] = 0.0F;

        }

        return 0;
    }

    static int seq = 0;
    float pcmbundle[][];
    int zerobundle[];
    int nonzero[];
    Object floormemo[];


    private class LookMapping0
    {

        InfoMode mode;
        InfoMapping0 map;
        Object time_look[];
        Object floor_look[];
        Object floor_state[];
        Object residue_look[];
        PsyLook psy_look[];
        FuncTime time_func[];
        FuncFloor floor_func[];
        FuncResidue residue_func[];
        int ch;
        float decay[][];
        int lastframe;
        final Mapping0 this$0;

        LookMapping0()
        {
            this$0 = Mapping0.this;
            super();
        }
    }


    private class InfoMapping0
    {

        void free()
        {
            chmuxlist = null;
            timesubmap = null;
            floorsubmap = null;
            residuesubmap = null;
            psysubmap = null;
            coupling_mag = null;
            coupling_ang = null;
        }

        int submaps;
        int chmuxlist[];
        int timesubmap[];
        int floorsubmap[];
        int residuesubmap[];
        int psysubmap[];
        int coupling_steps;
        int coupling_mag[];
        int coupling_ang[];
        final Mapping0 this$0;

        InfoMapping0()
        {
            this$0 = Mapping0.this;
            super();
            chmuxlist = new int[256];
            timesubmap = new int[16];
            floorsubmap = new int[16];
            residuesubmap = new int[16];
            psysubmap = new int[16];
            coupling_mag = new int[256];
            coupling_ang = new int[256];
        }
    }

}
