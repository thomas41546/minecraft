// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;

// Referenced classes of package com.jcraft.jorbis:
//            Mapping0, Info, DspState, InfoMode, 
//            Block

abstract class FuncMapping
{

    FuncMapping()
    {
    }

    abstract void pack(Info info, Object obj, Buffer buffer);

    abstract Object unpack(Info info, Buffer buffer);

    abstract Object look(DspState dspstate, InfoMode infomode, Object obj);

    abstract void free_info(Object obj);

    abstract void free_look(Object obj);

    abstract int inverse(Block block, Object obj);

    public static FuncMapping mapping_P[] = {
        new Mapping0()
    };

}
