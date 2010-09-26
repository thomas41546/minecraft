// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;

// Referenced classes of package com.jcraft.jorbis:
//            Residue0, Residue1, Residue2, Info, 
//            DspState, InfoMode, Block

abstract class FuncResidue
{

    FuncResidue()
    {
    }

    abstract void pack(Object obj, Buffer buffer);

    abstract Object unpack(Info info, Buffer buffer);

    abstract Object look(DspState dspstate, InfoMode infomode, Object obj);

    abstract void free_info(Object obj);

    abstract void free_look(Object obj);

    abstract int inverse(Block block, Object obj, float af[][], int ai[], int i);

    public static FuncResidue residue_P[] = {
        new Residue0(), new Residue1(), new Residue2()
    };

}
