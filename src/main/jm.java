package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class jm extends ly
{

    protected jm(int i, int j)
    {
        super(i, gb.i);
        bb = j;
        float f1 = 0.375F;
        a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 1.0F, 0.5F + f1);
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

    public boolean a(cn cn1, int i, int j, int k)
    {
        int l = cn1.a(i, j - 1, k);
        if(l == bc)
            return true;
        if(l != ly.v.bc && l != ly.w.bc)
            return false;
        if(cn1.f(i - 1, j - 1, k) == gb.f)
            return true;
        if(cn1.f(i + 1, j - 1, k) == gb.f)
            return true;
        if(cn1.f(i, j - 1, k - 1) == gb.f)
            return true;
        return cn1.f(i, j - 1, k + 1) == gb.f;
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        h(cn1, i, j, k);
    }

    protected final void h(cn cn1, int i, int j, int k)
    {
        if(!g(cn1, i, j, k))
        {
            b_(cn1, i, j, k, cn1.e(i, j, k));
            cn1.d(i, j, k, 0);
        }
    }

    public boolean g(cn cn1, int i, int j, int k)
    {
        return a(cn1, i, j, k);
    }

    public cf d(cn cn1, int i, int j, int k)
    {
        return null;
    }

    public int a(int i, Random random)
    {
        return di.aH.aS;
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
        return 1;
    }
}
