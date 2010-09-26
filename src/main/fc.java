package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class fc extends ly
{

    protected fc(int i, int j, gb gb, boolean flag)
    {
        super(i, j, gb);
        a = flag;
    }

    public boolean b()
    {
        return false;
    }

    public boolean c(nm nm1, int i, int j, int k, int l)
    {
        int i1 = nm1.a(i, j, k);
        if(!a && i1 == bc)
            return false;
        else
            return super.c(nm1, i, j, k, l);
    }

    private boolean a;
}
