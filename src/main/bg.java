package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.*;

public class bg extends mj
{

    public int a(int i, int j)
    {
        if(i == 1)
            return ly.aw.a(i, j);
        else
            return super.a(i, j);
    }

    private boolean a(cn cn1, int i, int j, int k, boolean flag)
    {
        if(flag)
            b.add(((Object) (new np(i, j, k, cn1.c))));
        int l = 0;
        for(int i1 = 0; i1 < b.size(); i1++)
        {
            np np1 = (np)b.get(i1);
            if(np1.a == i && np1.b == j && np1.c == k && ++l >= 8)
                return true;
        }

        return false;
    }

    protected bg(int i, int j, boolean flag)
    {
        super(i, j);
        a = false;
        a = flag;
        b(true);
    }

    public int a()
    {
        return 2;
    }

    public void e(cn cn1, int i, int j, int k)
    {
        if(cn1.e(i, j, k) == 0)
            super.e(cn1, i, j, k);
        if(a)
        {
            cn1.g(i, j - 1, k, bc);
            cn1.g(i, j + 1, k, bc);
            cn1.g(i - 1, j, k, bc);
            cn1.g(i + 1, j, k, bc);
            cn1.g(i, j, k - 1, bc);
            cn1.g(i, j, k + 1, bc);
        }
    }

    public void b(cn cn1, int i, int j, int k)
    {
        if(a)
        {
            cn1.g(i, j - 1, k, bc);
            cn1.g(i, j + 1, k, bc);
            cn1.g(i - 1, j, k, bc);
            cn1.g(i + 1, j, k, bc);
            cn1.g(i, j, k - 1, bc);
            cn1.g(i, j, k + 1, bc);
        }
    }

    public boolean b(nm nm1, int i, int j, int k, int l)
    {
        if(!a)
            return false;
        int i1 = nm1.e(i, j, k);
        if(i1 == 5 && l == 1)
            return false;
        if(i1 == 3 && l == 3)
            return false;
        if(i1 == 4 && l == 2)
            return false;
        if(i1 == 1 && l == 5)
            return false;
        return i1 != 2 || l != 4;
    }

    private boolean h(cn cn1, int i, int j, int k)
    {
        int l = cn1.e(i, j, k);
        if(l == 5 && cn1.k(i, j - 1, k, 0))
            return true;
        if(l == 3 && cn1.k(i, j, k - 1, 2))
            return true;
        if(l == 4 && cn1.k(i, j, k + 1, 3))
            return true;
        if(l == 1 && cn1.k(i - 1, j, k, 4))
            return true;
        return l == 2 && cn1.k(i + 1, j, k, 5);
    }

    public void a(cn cn1, int i, int j, int k, Random random)
    {
        boolean flag = h(cn1, i, j, k);
        for(; b.size() > 0 && cn1.c - ((np)b.get(0)).d > 100L; b.remove(0));
        if(a)
        {
            if(flag)
            {
                cn1.b(i, j, k, ly.aQ.bc, cn1.e(i, j, k));
                if(a(cn1, i, j, k, true))
                {
                    cn1.a((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, "random.fizz", 0.5F, 2.6F + (cn1.n.nextFloat() - cn1.n.nextFloat()) * 0.8F);
                    for(int l = 0; l < 5; l++)
                    {
                        double d1 = (double)i + random.nextDouble() * 0.59999999999999998D + 0.20000000000000001D;
                        double d2 = (double)j + random.nextDouble() * 0.59999999999999998D + 0.20000000000000001D;
                        double d3 = (double)k + random.nextDouble() * 0.59999999999999998D + 0.20000000000000001D;
                        cn1.a("smoke", d1, d2, d3, 0.0D, 0.0D, 0.0D);
                    }

                }
            }
        } else
        if(!flag && !a(cn1, i, j, k, false))
            cn1.b(i, j, k, ly.aR.bc, cn1.e(i, j, k));
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        super.a(cn1, i, j, k, l);
        cn1.h(i, j, k, bc);
    }

    public boolean c(cn cn1, int i, int j, int k, int l)
    {
        if(l == 0)
            return b(((nm) (cn1)), i, j, k, l);
        else
            return false;
    }

    public int a(int i, Random random)
    {
        return ly.aR.bc;
    }

    public boolean d()
    {
        return true;
    }

    public void b(cn cn1, int i, int j, int k, Random random)
    {
        if(!a)
            return;
        int l = cn1.e(i, j, k);
        double d1 = (double)((float)i + 0.5F) + (double)(random.nextFloat() - 0.5F) * 0.20000000000000001D;
        double d2 = (double)((float)j + 0.7F) + (double)(random.nextFloat() - 0.5F) * 0.20000000000000001D;
        double d3 = (double)((float)k + 0.5F) + (double)(random.nextFloat() - 0.5F) * 0.20000000000000001D;
        double d4 = 0.2199999988079071D;
        double d5 = 0.27000001072883606D;
        if(l == 1)
            cn1.a("reddust", d1 - d5, d2 + d4, d3, 0.0D, 0.0D, 0.0D);
        else
        if(l == 2)
            cn1.a("reddust", d1 + d5, d2 + d4, d3, 0.0D, 0.0D, 0.0D);
        else
        if(l == 3)
            cn1.a("reddust", d1, d2 + d4, d3 - d5, 0.0D, 0.0D, 0.0D);
        else
        if(l == 4)
            cn1.a("reddust", d1, d2 + d4, d3 + d5, 0.0D, 0.0D, 0.0D);
        else
            cn1.a("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
    }

    private boolean a;
    private static List b = new ArrayList();

}
