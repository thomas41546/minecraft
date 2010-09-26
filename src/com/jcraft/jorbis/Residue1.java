// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;


// Referenced classes of package com.jcraft.jorbis:
//            Residue0, Block

class Residue1 extends Residue0
{

    Residue1()
    {
    }

    int inverse(Block block, Object obj, float af[][], int ai[], int i)
    {
        int j = 0;
        for(int k = 0; k < i; k++)
            if(ai[k] != 0)
                af[j++] = af[k];

        if(j != 0)
            return _01inverse(block, obj, af, j, 1);
        else
            return 0;
    }
}
