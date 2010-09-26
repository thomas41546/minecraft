package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class mj extends ly
{

    protected mj(int i, int j)
    {
        super(i, j, gb.n);
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

    public int f()
    {
        return 2;
    }

    public boolean a(cn cn1, int i, int j, int k)
    {
        if(cn1.g(i - 1, j, k))
            return true;
        if(cn1.g(i + 1, j, k))
            return true;
        if(cn1.g(i, j, k - 1))
            return true;
        if(cn1.g(i, j, k + 1))
            return true;
        return cn1.g(i, j - 1, k);
    }

    public void d(cn cn1, int i, int j, int k, int l)
    {
        int i1 = cn1.e(i, j, k);
        if(l == 1 && cn1.g(i, j - 1, k))
            i1 = 5;
        if(l == 2 && cn1.g(i, j, k + 1))
            i1 = 4;
        if(l == 3 && cn1.g(i, j, k - 1))
            i1 = 3;
        if(l == 4 && cn1.g(i + 1, j, k))
            i1 = 2;
        if(l == 5 && cn1.g(i - 1, j, k))
            i1 = 1;
        cn1.b(i, j, k, i1);
    }

    public void a(cn cn1, int i, int j, int k, Random random)
    {
        super.a(cn1, i, j, k, random);
        if(cn1.e(i, j, k) == 0)
            e(cn1, i, j, k);
    }

    public void e(cn cn1, int i, int j, int k)
    {
        if(cn1.g(i - 1, j, k))
            cn1.b(i, j, k, 1);
        else
        if(cn1.g(i + 1, j, k))
            cn1.b(i, j, k, 2);
        else
        if(cn1.g(i, j, k - 1))
            cn1.b(i, j, k, 3);
        else
        if(cn1.g(i, j, k + 1))
            cn1.b(i, j, k, 4);
        else
        if(cn1.g(i, j - 1, k))
            cn1.b(i, j, k, 5);
        h(cn1, i, j, k);
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        if(h(cn1, i, j, k))
        {
            int i1 = cn1.e(i, j, k);
            boolean flag = false;
            if(!cn1.g(i - 1, j, k) && i1 == 1)
                flag = true;
            if(!cn1.g(i + 1, j, k) && i1 == 2)
                flag = true;
            if(!cn1.g(i, j, k - 1) && i1 == 3)
                flag = true;
            if(!cn1.g(i, j, k + 1) && i1 == 4)
                flag = true;
            if(!cn1.g(i, j - 1, k) && i1 == 5)
                flag = true;
            if(flag)
            {
                b_(cn1, i, j, k, cn1.e(i, j, k));
                cn1.d(i, j, k, 0);
            }
        }
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

    public mf a(cn cn1, int i, int j, int k, aj aj, aj aj1)
    {
        int l = cn1.e(i, j, k) & 7;
        float f1 = 0.15F;
        if(l == 1)
            a(0.0F, 0.2F, 0.5F - f1, f1 * 2.0F, 0.8F, 0.5F + f1);
        else
        if(l == 2)
            a(1.0F - f1 * 2.0F, 0.2F, 0.5F - f1, 1.0F, 0.8F, 0.5F + f1);
        else
        if(l == 3)
            a(0.5F - f1, 0.2F, 0.0F, 0.5F + f1, 0.8F, f1 * 2.0F);
        else
        if(l == 4)
        {
            a(0.5F - f1, 0.2F, 1.0F - f1 * 2.0F, 0.5F + f1, 0.8F, 1.0F);
        } else
        {
            float f2 = 0.1F;
            a(0.5F - f2, 0.0F, 0.5F - f2, 0.5F + f2, 0.6F, 0.5F + f2);
        }
        return super.a(cn1, i, j, k, aj, aj1);
    }

    public void b(cn cn1, int i, int j, int k, Random random)
    {
        int l = cn1.e(i, j, k);
        double d1 = (float)i + 0.5F;
        double d2 = (float)j + 0.7F;
        double d3 = (float)k + 0.5F;
        double d4 = 0.2199999988079071D;
        double d5 = 0.27000001072883606D;
        if(l == 1)
        {
            cn1.a("smoke", d1 - d5, d2 + d4, d3, 0.0D, 0.0D, 0.0D);
            cn1.a("flame", d1 - d5, d2 + d4, d3, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 2)
        {
            cn1.a("smoke", d1 + d5, d2 + d4, d3, 0.0D, 0.0D, 0.0D);
            cn1.a("flame", d1 + d5, d2 + d4, d3, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 3)
        {
            cn1.a("smoke", d1, d2 + d4, d3 - d5, 0.0D, 0.0D, 0.0D);
            cn1.a("flame", d1, d2 + d4, d3 - d5, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 4)
        {
            cn1.a("smoke", d1, d2 + d4, d3 + d5, 0.0D, 0.0D, 0.0D);
            cn1.a("flame", d1, d2 + d4, d3 + d5, 0.0D, 0.0D, 0.0D);
        } else
        {
            cn1.a("smoke", d1, d2, d3, 0.0D, 0.0D, 0.0D);
            cn1.a("flame", d1, d2, d3, 0.0D, 0.0D, 0.0D);
        }
    }
}
