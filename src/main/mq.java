package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class mq extends ly
{

    protected mq(int i, int j)
    {
        super(i, gb.i);
        bb = j;
        b(true);
        float f1 = 0.2F;
        a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f1 * 3F, 0.5F + f1);
    }

    public boolean a(cn cn1, int i, int j, int k)
    {
        return b(cn1.a(i, j - 1, k));
    }

    protected boolean b(int i)
    {
        return i == ly.v.bc || i == ly.w.bc || i == ly.aB.bc;
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        super.a(cn1, i, j, k, l);
        h(cn1, i, j, k);
    }

    public void a(cn cn1, int i, int j, int k, Random random)
    {
        h(cn1, i, j, k);
    }

    protected final void h(cn cn1, int i, int j, int k)
    {
        if(!g(cn1, i, j, k))
        {
            b_(cn1, i, j, k, cn1.e(i, j, k));
            cn1.d(i, j, k, 0);
        }
    }

    public boolean g(cn cn1, int i, int j, int k)
    {
        return (cn1.j(i, j, k) >= 8 || cn1.i(i, j, k)) && b(cn1.a(i, j - 1, k));
    }

    public cf d(cn cn1, int i, int j, int k)
    {
        return null;
    }

    public boolean b()
    {
        return false;
    }

    public boolean c()
    {
        return false;
    }

    public int f()
    {
        return 1;
    }
}
