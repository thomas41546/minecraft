package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class he extends fc
{

    public he(int i, int j)
    {
        super(i, j, gb.r, false);
        bo = 0.98F;
        b(true);
    }

    public int g()
    {
        return 1;
    }

    public boolean c(nm nm, int i, int j, int k, int l)
    {
        return super.c(nm, i, j, k, 1 - l);
    }

    public void b(cn cn1, int i, int j, int k)
    {
        gb gb1 = cn1.f(i, j - 1, k);
        if(gb1.c() || gb1.d())
            cn1.d(i, j, k, ly.B.bc);
    }

    public int a(Random random)
    {
        return 0;
    }

    public void a(cn cn1, int i, int j, int k, Random random)
    {
        if(cn1.a(by.b, i, j, k) > 11 - ly.r[bc])
        {
            b_(cn1, i, j, k, cn1.e(i, j, k));
            cn1.d(i, j, k, ly.C.bc);
        }
    }
}
