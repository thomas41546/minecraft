package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class fd extends ly
{

    protected fd(int i, int j)
    {
        super(i, j, gb.s);
        a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        b(true);
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

    public boolean a(cn cn1, int i, int j, int k)
    {
        int l = cn1.a(i, j - 1, k);
        if(l == 0 || !ly.n[l].b())
            return false;
        else
            return cn1.f(i, j - 1, k).c();
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        h(cn1, i, j, k);
    }

    private boolean h(cn cn1, int i, int j, int k)
    {
        if(!a(cn1, i, j, k))
        {
            b_(cn1, i, j, k, cn1.e(i, j, k));
            cn1.d(i, j, k, 0);
            return false;
        } else
        {
            return true;
        }
    }

    public void a_(cn cn1, int i, int j, int k, int l)
    {
        int i1 = di.aB.aS;
        float f = 0.7F;
        double d1 = (double)(cn1.n.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d2 = (double)(cn1.n.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d3 = (double)(cn1.n.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        dx dx1 = new dx(cn1, (double)i + d1, (double)j + d2, (double)k + d3, new ev(i1));
        dx1.c = 10;
        cn1.a(((kh) (dx1)));
        cn1.d(i, j, k, 0);
    }

    public int a(int i, Random random)
    {
        return di.aB.aS;
    }

    public int a(Random random)
    {
        return 0;
    }

    public void a(cn cn1, int i, int j, int k, Random random)
    {
        if(cn1.a(by.b, i, j, k) > 11)
        {
            b_(cn1, i, j, k, cn1.e(i, j, k));
            cn1.d(i, j, k, 0);
        }
    }

    public boolean c(nm nm1, int i, int j, int k, int l)
    {
        gb gb1 = nm1.f(i, j, k);
        if(l == 1)
            return true;
        if(gb1 == bn)
            return false;
        else
            return super.c(nm1, i, j, k, l);
    }
}
