package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class gw extends ly
{

    public gw(int i, int j)
    {
        super(i, j, gb.d);
    }

    public int a(int i, Random random)
    {
        if(bc == ly.J.bc)
            return di.k.aS;
        if(bc == ly.ax.bc)
            return di.l.aS;
        else
            return bc;
    }

    public int a(Random random)
    {
        return 1;
    }
}
