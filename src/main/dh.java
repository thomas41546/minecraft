package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class dh extends ly
{

    public dh(int i, int j)
    {
        super(i, j, gb.m);
    }

    public void e(cn cn1, int i, int j, int k)
    {
        cn1.h(i, j, k, bc);
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        cn1.h(i, j, k, bc);
    }

    public void a(cn cn1, int i, int j, int k, Random random)
    {
        h(cn1, i, j, k);
    }

    private void h(cn cn1, int i, int j, int k)
    {
        int l = i;
        int i1 = j;
        int j1 = k;
        if(a_(cn1, l, i1 - 1, j1) && i1 >= 0)
        {
            ff ff1 = new ff(cn1, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, bc);
            if(a)
                while(!ff1.aA) 
                    ff1.e_();
            else
                cn1.a(((kh) (ff1)));
        }
    }

    public int a()
    {
        return 3;
    }

    public static boolean a_(cn cn1, int i, int j, int k)
    {
        int l = cn1.a(i, j, k);
        if(l == 0)
            return true;
        if(l == ly.as.bc)
            return true;
        gb gb1 = ly.n[l].bn;
        if(gb1 == gb.f)
            return true;
        return gb1 == gb.g;
    }

    public static boolean a = false;

}
