package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class mi extends ly
{

    protected mi(int j)
    {
        super(j, gb.b);
        bb = 87;
        b(true);
        a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        d(255);
    }

    public cf d(cn cn1, int j, int k, int l)
    {
        return cf.b(j + 0, k + 0, l + 0, j + 1, k + 1, l + 1);
    }

    public boolean b()
    {
        return false;
    }

    public boolean c()
    {
        return false;
    }

    public int a(int j, int k)
    {
        if(j == 1 && k > 0)
            return bb - 1;
        if(j == 1)
            return bb;
        else
            return 2;
    }

    public void a(cn cn1, int j, int k, int l, Random random)
    {
        if(random.nextInt(5) == 0)
            if(i(cn1, j, k, l))
            {
                cn1.b(j, k, l, 7);
            } else
            {
                int i1 = cn1.e(j, k, l);
                if(i1 > 0)
                    cn1.b(j, k, l, i1 - 1);
                else
                if(!h(cn1, j, k, l))
                    cn1.d(j, k, l, ly.w.bc);
            }
    }

    public void a(cn cn1, int j, int k, int l, kh kh)
    {
        if(cn1.n.nextInt(4) == 0)
            cn1.d(j, k, l, ly.w.bc);
    }

    private boolean h(cn cn1, int j, int k, int l)
    {
        int i1 = 0;
        for(int j1 = j - i1; j1 <= j + i1; j1++)
        {
            for(int k1 = l - i1; k1 <= l + i1; k1++)
                if(cn1.a(j1, k + 1, k1) == ly.aA.bc)
                    return true;

        }

        return false;
    }

    private boolean i(cn cn1, int j, int k, int l)
    {
        for(int i1 = j - 4; i1 <= j + 4; i1++)
        {
            for(int j1 = k; j1 <= k + 1; j1++)
            {
                for(int k1 = l - 4; k1 <= l + 4; k1++)
                    if(cn1.f(i1, j1, k1) == gb.f)
                        return true;

            }

        }

        return false;
    }

    public void a(cn cn1, int j, int k, int l, int i1)
    {
        super.a(cn1, j, k, l, i1);
        gb gb1 = cn1.f(j, k + 1, l);
        if(gb1.a())
            cn1.d(j, k, l, ly.w.bc);
    }

    public int a(int j, Random random)
    {
        return ly.w.a(0, random);
    }
}
