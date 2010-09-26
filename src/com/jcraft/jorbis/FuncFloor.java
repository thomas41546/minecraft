// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;

// Referenced classes of package com.jcraft.jorbis:
//            Floor0, Floor1, Info, DspState, 
//            InfoMode, Block

abstract class FuncFloor
{

    FuncFloor()
    {
    }

    abstract void pack(Object obj, Buffer buffer);

    abstract Object unpack(Info info, Buffer buffer);

    abstract Object look(DspState dspstate, InfoMode infomode, Object obj);

    abstract void free_info(Object obj);

    abstract void free_look(Object obj);

    abstract void free_state(Object obj);

    abstract int forward(Block block, Object obj, float af[], float af1[], Object obj1);

    abstract Object inverse1(Block block, Object obj, Object obj1);

    abstract int inverse2(Block block, Object obj, Object obj1, float af[]);

    public static FuncFloor floor_P[] = {
        new Floor0(), new Floor1()
    };

}
