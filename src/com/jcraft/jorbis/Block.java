// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;
import com.jcraft.jogg.Packet;

// Referenced classes of package com.jcraft.jorbis:
//            DspState, FuncMapping, Info, InfoMode

public class Block
{

    public Block(DspState dspstate)
    {
        pcm = new float[0][];
        opb = new Buffer();
        vd = dspstate;
        if(dspstate.analysisp != 0)
            opb.writeinit();
    }

    public void init(DspState dspstate)
    {
        vd = dspstate;
    }

    public int clear()
    {
        if(vd != null && vd.analysisp != 0)
            opb.writeclear();
        return 0;
    }

    public int synthesis(Packet packet)
    {
        Info info = vd.vi;
        opb.readinit(packet.packet_base, packet.packet, packet.bytes);
        if(opb.read(1) != 0)
            return -1;
        int i = opb.read(vd.modebits);
        if(i == -1)
            return -1;
        mode = i;
        W = info.mode_param[mode].blockflag;
        if(W != 0)
        {
            lW = opb.read(1);
            nW = opb.read(1);
            if(nW == -1)
                return -1;
        } else
        {
            lW = 0;
            nW = 0;
        }
        granulepos = packet.granulepos;
        sequence = packet.packetno - 3L;
        eofflag = packet.e_o_s;
        pcmend = info.blocksizes[W];
        if(pcm.length < info.channels)
            pcm = new float[info.channels][];
        for(int j = 0; j < info.channels; j++)
        {
            if(pcm[j] == null || pcm[j].length < pcmend)
            {
                pcm[j] = new float[pcmend];
                continue;
            }
            for(int l = 0; l < pcmend; l++)
                pcm[j][l] = 0.0F;

        }

        int k = info.map_type[info.mode_param[mode].mapping];
        return FuncMapping.mapping_P[k].inverse(this, vd.mode[mode]);
    }

    float pcm[][];
    Buffer opb;
    int lW;
    int W;
    int nW;
    int pcmend;
    int mode;
    int eofflag;
    long granulepos;
    long sequence;
    DspState vd;
    int glue_bits;
    int time_bits;
    int floor_bits;
    int res_bits;
}
