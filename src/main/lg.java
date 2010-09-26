package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class lg extends di
{

    protected lg(int i, String s)
    {
        super(i);
        a = s;
        aT = 1;
    }

    public boolean a(ev ev1, dm dm, cn cn1, int i, int j, int k, int l)
    {
        if(cn1.a(i, j, k) == ly.aZ.bc && cn1.e(i, j, k) == 0)
        {
            cn1.b(i, j, k, (aS - di.aQ.aS) + 1);
            cn1.a(a, i, j, k);
            ev1.a--;
            return true;
        } else
        {
            return false;
        }
    }

    private String a;
}
