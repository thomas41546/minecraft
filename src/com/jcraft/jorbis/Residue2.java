// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;


// Referenced classes of package com.jcraft.jorbis:
//            Residue0, Block

class Residue2 extends Residue0
{

    Residue2()
    {
    }

    int inverse(Block block, Object obj, float af[][], int ai[], int i)
    {
        int j = 0;
        for(j = 0; j < i && ai[j] == 0; j++);
        if(j == i)
            return 0;
        else
            return _2inverse(block, obj, af, i);
    }
}
