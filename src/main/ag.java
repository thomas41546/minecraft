package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public abstract class ag extends ek
{

    public ag(cn cn1)
    {
        super(cn1);
    }

    protected float a(int i, int j, int k)
    {
        if(ag.a(i, j - 1, k) == ly.v.bc)
            return 10F;
        else
            return ag.c(i, j, k) - 0.5F;
    }

    public void a(hm hm)
    {
        super.a(hm);
    }

    public void b(hm hm)
    {
        super.b(hm);
    }

    public boolean a()
    {
        int i = eo.b(ak);
        int j = eo.b(au.b);
        int k = eo.b(am);
        return ag.a(i, j - 1, k) == ly.v.bc && ag.j(i, j, k) > 8 && super.a();
    }

    public int b()
    {
        return 120;
    }
}
