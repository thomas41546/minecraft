package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class q extends ly
{

    public q(int i, int j)
    {
        super(i, j, gb.p);
    }

    public int a(int i)
    {
        if(i == 0)
            return bb + 2;
        if(i == 1)
            return bb + 1;
        else
            return bb;
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        if(l > 0 && ly.n[l].d() && cn1.o(i, j, k))
        {
            b(cn1, i, j, k, 0);
            cn1.d(i, j, k, 0);
        }
    }

    public int a(Random random)
    {
        return 0;
    }

    public void c(cn cn1, int i, int j, int k)
    {
        jd jd1 = new jd(cn1, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
        jd1.a = cn1.n.nextInt(jd1.a / 4) + jd1.a / 8;
        cn1.a(((kh) (jd1)));
    }

    public void b(cn cn1, int i, int j, int k, int l)
    {
        jd jd1 = new jd(cn1, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
        cn1.a(((kh) (jd1)));
        cn1.a(((kh) (jd1)), "random.fuse", 1.0F, 1.0F);
    }
}
