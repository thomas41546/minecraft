package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class iz extends hi
{

    protected iz(int j, int k)
    {
        super(j, k, gb.h, false);
        c = 0;
        b = k;
        b(true);
    }

    public void a(cn cn1, int j, int k, int l, int i1)
    {
        c = 0;
        h(cn1, j, k, l);
        super.a(cn1, j, k, l, i1);
    }

    public void f(cn cn1, int j, int k, int l, int i1)
    {
        if(cn1.a(j, k, l) != bc)
            return;
        int j1 = cn1.e(j, k, l);
        if(j1 == 0 || j1 != i1 - 1)
        {
            return;
        } else
        {
            h(cn1, j, k, l);
            return;
        }
    }

    public void h(cn cn1, int j, int k, int l)
    {
        if(c++ >= 100)
            return;
        int i1 = ((int) (cn1.f(j, k - 1, l).a() ? 16 : 0));
        int j1 = cn1.e(j, k, l);
        if(j1 == 0)
        {
            j1 = 1;
            cn1.b(j, k, l, 1);
        }
        i1 = g(cn1, j, k - 1, l, i1);
        i1 = g(cn1, j, k, l - 1, i1);
        i1 = g(cn1, j, k, l + 1, i1);
        i1 = g(cn1, j - 1, k, l, i1);
        i1 = g(cn1, j + 1, k, l, i1);
        int k1 = i1 - 1;
        if(k1 < 10)
            k1 = 1;
        if(k1 != j1)
        {
            cn1.b(j, k, l, k1);
            f(cn1, j, k - 1, l, j1);
            f(cn1, j, k + 1, l, j1);
            f(cn1, j, k, l - 1, j1);
            f(cn1, j, k, l + 1, j1);
            f(cn1, j - 1, k, l, j1);
            f(cn1, j + 1, k, l, j1);
        }
    }

    private int g(cn cn1, int j, int k, int l, int i1)
    {
        int j1 = cn1.a(j, k, l);
        if(j1 == ly.K.bc)
            return 16;
        if(j1 == bc)
        {
            int k1 = cn1.e(j, k, l);
            if(k1 != 0 && k1 > i1)
                return k1;
        }
        return i1;
    }

    public void a(cn cn1, int j, int k, int l, Random random)
    {
        int i1 = cn1.e(j, k, l);
        if(i1 == 0)
        {
            c = 0;
            h(cn1, j, k, l);
        } else
        if(i1 == 1)
            i(cn1, j, k, l);
        else
        if(random.nextInt(10) == 0)
            h(cn1, j, k, l);
    }

    private void i(cn cn1, int j, int k, int l)
    {
        b_(cn1, j, k, l, cn1.e(j, k, l));
        cn1.d(j, k, l, 0);
    }

    public int a(Random random)
    {
        return random.nextInt(20) != 0 ? 0 : 1;
    }

    public int a(int j, Random random)
    {
        return ly.z.bc;
    }

    public boolean b()
    {
        return !a;
    }

    public void a(boolean flag)
    {
        a = flag;
        bb = b + (flag ? 0 : 1);
    }

    public void a(cn cn1, int j, int k, int l, kh kh)
    {
        super.a(cn1, j, k, l, kh);
    }

    private int b;
    private int c;
}
