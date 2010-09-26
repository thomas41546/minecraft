package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class my extends ly
{

    protected my(int i)
    {
        super(i, gb.b);
        bb = 3;
        b(true);
    }

    public int a(nm nm1, int i, int j, int k, int l)
    {
        if(l == 1)
            return 0;
        if(l == 0)
            return 2;
        gb gb1 = nm1.f(i, j + 1, k);
        return gb1 != gb.s && gb1 != gb.t ? 3 : 68;
    }

    public void a(cn cn1, int i, int j, int k, Random random)
    {
        if(cn1.j(i, j + 1, k) < 4 && cn1.f(i, j + 1, k).b())
        {
            if(random.nextInt(4) != 0)
                return;
            cn1.d(i, j, k, ly.w.bc);
        } else
        if(cn1.j(i, j + 1, k) >= 9)
        {
            int l = (i + random.nextInt(3)) - 1;
            int i1 = (j + random.nextInt(5)) - 3;
            int j1 = (k + random.nextInt(3)) - 1;
            if(cn1.a(l, i1, j1) == ly.w.bc && cn1.j(l, i1 + 1, j1) >= 4 && !cn1.f(l, i1 + 1, j1).b())
                cn1.d(l, i1, j1, ly.v.bc);
        }
    }

    public int a(int i, Random random)
    {
        return ly.w.a(0, random);
    }
}
