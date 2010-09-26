package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


class lj extends mm
{

    lj(lo lo1, ee ee, gh gh, int i, int j, int k, int l)
    {
        d = lo1;
        c = l;
        super(ee, gh, i, j, k);
    }

    public boolean a(ev ev1)
    {
        if(ev1.a() instanceof mr)
            return ((mr)ev1.a()).aX == c;
        else
            return false;
    }

    public int c()
    {
        return 15 + c * 16;
    }

    final int c;
    final lo d;
}
