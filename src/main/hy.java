package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class hy extends ly
{

    protected hy(int i, int j)
    {
        super(i, j, gb.u);
        b(true);
    }

    public void a(cn cn1, int i, int j, int k, Random random)
    {
        if(cn1.a(i, j + 1, k) == 0)
        {
            int l;
            for(l = 1; cn1.a(i, j - l, k) == bc; l++);
            if(l < 3)
            {
                int i1 = cn1.e(i, j, k);
                if(i1 == 15)
                {
                    cn1.d(i, j + 1, k, bc);
                    cn1.b(i, j, k, 0);
                } else
                {
                    cn1.b(i, j, k, i1 + 1);
                }
            }
        }
    }

    public cf d(cn cn1, int i, int j, int k)
    {
        float f1 = 0.0625F;
        return cf.b((float)i + f1, j, (float)k + f1, (float)(i + 1) - f1, (float)(j + 1) - f1, (float)(k + 1) - f1);
    }

    public cf f(cn cn1, int i, int j, int k)
    {
        float f1 = 0.0625F;
        return cf.b((float)i + f1, j, (float)k + f1, (float)(i + 1) - f1, j + 1, (float)(k + 1) - f1);
    }

    public int a(int i)
    {
        if(i == 1)
            return bb - 1;
        if(i == 0)
            return bb + 1;
        else
            return bb;
    }

    public boolean c()
    {
        return false;
    }

    public boolean b()
    {
        return false;
    }

    public int f()
    {
        return 13;
    }

    public boolean a(cn cn1, int i, int j, int k)
    {
        if(!super.a(cn1, i, j, k))
            return false;
        else
            return g(cn1, i, j, k);
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        if(!g(cn1, i, j, k))
        {
            b_(cn1, i, j, k, cn1.e(i, j, k));
            cn1.d(i, j, k, 0);
        }
    }

    public boolean g(cn cn1, int i, int j, int k)
    {
        if(cn1.f(i - 1, j, k).a())
            return false;
        if(cn1.f(i + 1, j, k).a())
            return false;
        if(cn1.f(i, j, k - 1).a())
            return false;
        if(cn1.f(i, j, k + 1).a())
        {
            return false;
        } else
        {
            int l = cn1.a(i, j - 1, k);
            return l == ly.aW.bc || l == ly.F.bc;
        }
    }

    public void b(cn cn1, int i, int j, int k, kh kh1)
    {
        kh1.a(((kh) (null)), 1);
    }
}
