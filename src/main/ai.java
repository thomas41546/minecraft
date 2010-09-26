package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class ai extends ly
{

    public ai(int j, int k, boolean flag)
    {
        super(j, k, gb.d);
        if(flag)
            b(true);
        a = flag;
    }

    public int a()
    {
        return 30;
    }

    public void b(cn cn1, int j, int k, int l, dm dm)
    {
        h(cn1, j, k, l);
        super.b(cn1, j, k, l, dm);
    }

    public void a(cn cn1, int j, int k, int l, kh kh)
    {
        h(cn1, j, k, l);
        super.a(cn1, j, k, l, kh);
    }

    public boolean a(cn cn1, int j, int k, int l, dm dm)
    {
        h(cn1, j, k, l);
        return super.a(cn1, j, k, l, dm);
    }

    private void h(cn cn1, int j, int k, int l)
    {
        i(cn1, j, k, l);
        if(bc == ly.aO.bc)
            cn1.d(j, k, l, ly.aP.bc);
    }

    public void a(cn cn1, int j, int k, int l, Random random)
    {
        if(bc == ly.aP.bc)
            cn1.d(j, k, l, ly.aO.bc);
    }

    public int a(int j, Random random)
    {
        return di.aA.aS;
    }

    public int a(Random random)
    {
        return 4 + random.nextInt(2);
    }

    public void b(cn cn1, int j, int k, int l, Random random)
    {
        if(a)
            i(cn1, j, k, l);
    }

    private void i(cn cn1, int j, int k, int l)
    {
        Random random = cn1.n;
        double d = 0.0625D;
        for(int i1 = 0; i1 < 6; i1++)
        {
            double d1 = (float)j + random.nextFloat();
            double d2 = (float)k + random.nextFloat();
            double d3 = (float)l + random.nextFloat();
            if(i1 == 0 && !cn1.g(j, k + 1, l))
                d2 = (double)(k + 1) + d;
            if(i1 == 1 && !cn1.g(j, k - 1, l))
                d2 = (double)(k + 0) - d;
            if(i1 == 2 && !cn1.g(j, k, l + 1))
                d3 = (double)(l + 1) + d;
            if(i1 == 3 && !cn1.g(j, k, l - 1))
                d3 = (double)(l + 0) - d;
            if(i1 == 4 && !cn1.g(j + 1, k, l))
                d1 = (double)(j + 1) + d;
            if(i1 == 5 && !cn1.g(j - 1, k, l))
                d1 = (double)(j + 0) - d;
            if(d1 < (double)j || d1 > (double)(j + 1) || d2 < 0.0D || d2 > (double)(k + 1) || d3 < (double)l || d3 > (double)(l + 1))
                cn1.a("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
        }

    }

    private boolean a;
}
