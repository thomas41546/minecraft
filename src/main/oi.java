package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class oi extends ly
{

    public oi(int i, boolean flag)
    {
        super(i, 6, gb.d);
        a = flag;
        if(!flag)
            a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        d(255);
    }

    public int a(int i)
    {
        return i > 1 ? 5 : 6;
    }

    public boolean b()
    {
        return a;
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        if(this != ly.al)
            return;
        else
            return;
    }

    public void e(cn cn1, int i, int j, int k)
    {
        if(this != ly.al)
            super.e(cn1, i, j, k);
        int l = cn1.a(i, j - 1, k);
        if(l == al.bc)
        {
            cn1.d(i, j, k, 0);
            cn1.d(i, j - 1, k, ly.ak.bc);
        }
    }

    public int a(int i, Random random)
    {
        return ly.al.bc;
    }

    public boolean c()
    {
        return a;
    }

    public boolean c(nm nm1, int i, int j, int k, int l)
    {
        if(this != ly.al)
            super.c(nm1, i, j, k, l);
        if(l == 1)
            return true;
        if(!super.c(nm1, i, j, k, l))
            return false;
        if(l == 0)
            return true;
        else
            return nm1.a(i, j, k) != bc;
    }

    private boolean a;
}
