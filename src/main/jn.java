package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class jn extends di
{

    public jn(int i, int j)
    {
        super(i);
        a = j;
    }

    public boolean a(ev ev1, dm dm, cn cn1, int i, int j, int k, int l)
    {
        if(l != 1)
            return false;
        int i1 = cn1.a(i, j, k);
        if(i1 == ly.aB.bc)
        {
            cn1.d(i, j + 1, k, a);
            ev1.a--;
            return true;
        } else
        {
            return false;
        }
    }

    private int a;
}
