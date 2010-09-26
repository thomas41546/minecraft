package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class br extends ly
{

    protected br(int i, int j)
    {
        super(i, j, gb.n);
    }

    public cf d(cn cn1, int i, int j, int k)
    {
        int l = cn1.e(i, j, k);
        float f1 = 0.125F;
        if(l == 2)
            a(0.0F, 0.0F, 1.0F - f1, 1.0F, 1.0F, 1.0F);
        if(l == 3)
            a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f1);
        if(l == 4)
            a(1.0F - f1, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if(l == 5)
            a(0.0F, 0.0F, 0.0F, f1, 1.0F, 1.0F);
        return super.d(cn1, i, j, k);
    }

    public cf f(cn cn1, int i, int j, int k)
    {
        int l = cn1.e(i, j, k);
        float f1 = 0.125F;
        if(l == 2)
            a(0.0F, 0.0F, 1.0F - f1, 1.0F, 1.0F, 1.0F);
        if(l == 3)
            a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f1);
        if(l == 4)
            a(1.0F - f1, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if(l == 5)
            a(0.0F, 0.0F, 0.0F, f1, 1.0F, 1.0F);
        return super.f(cn1, i, j, k);
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
        return 8;
    }

    public boolean a(cn cn1, int i, int j, int k)
    {
        if(cn1.g(i - 1, j, k))
            return true;
        if(cn1.g(i + 1, j, k))
            return true;
        if(cn1.g(i, j, k - 1))
            return true;
        return cn1.g(i, j, k + 1);
    }

    public void d(cn cn1, int i, int j, int k, int l)
    {
        int i1 = cn1.e(i, j, k);
        if((i1 == 0 || l == 2) && cn1.g(i, j, k + 1))
            i1 = 2;
        if((i1 == 0 || l == 3) && cn1.g(i, j, k - 1))
            i1 = 3;
        if((i1 == 0 || l == 4) && cn1.g(i + 1, j, k))
            i1 = 4;
        if((i1 == 0 || l == 5) && cn1.g(i - 1, j, k))
            i1 = 5;
        cn1.b(i, j, k, i1);
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        int i1 = cn1.e(i, j, k);
        boolean flag = false;
        if(i1 == 2 && cn1.g(i, j, k + 1))
            flag = true;
        if(i1 == 3 && cn1.g(i, j, k - 1))
            flag = true;
        if(i1 == 4 && cn1.g(i + 1, j, k))
            flag = true;
        if(i1 == 5 && cn1.g(i - 1, j, k))
            flag = true;
        if(!flag)
        {
            b_(cn1, i, j, k, i1);
            cn1.d(i, j, k, 0);
        }
        super.a(cn1, i, j, k, l);
    }

    public int a(Random random)
    {
        return 1;
    }
}
