// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;

// Referenced classes of package com.jcraft.jorbis:
//            Time0, Info, DspState, InfoMode, 
//            Block

abstract class FuncTime
{

    FuncTime()
    {
    }

    abstract void pack(Object obj, Buffer buffer);

    abstract Object unpack(Info info, Buffer buffer);

    abstract Object look(DspState dspstate, InfoMode infomode, Object obj);

    abstract void free_info(Object obj);

    abstract void free_look(Object obj);

    abstract int inverse(Block block, Object obj, float af[], float af1[]);

    public static FuncTime time_P[] = {
        new Time0()
    };

}
