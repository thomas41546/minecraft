package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class bv
{

    public bv(int i, int j, int ai[], ev ev1)
    {
        a = ev1.c;
        b = i;
        c = j;
        d = ai;
        e = ev1;
    }

    public boolean a(int ai[])
    {
        for(int i = 0; i <= 3 - b; i++)
        {
            for(int j = 0; j <= 3 - c; j++)
            {
                if(a(ai, i, j, true))
                    return true;
                if(a(ai, i, j, false))
                    return true;
            }

        }

        return false;
    }

    private boolean a(int ai[], int i, int j, boolean flag)
    {
        for(int k = 0; k < 3; k++)
        {
            for(int l = 0; l < 3; l++)
            {
                int i1 = k - i;
                int j1 = l - j;
                int k1 = -1;
                if(i1 >= 0 && j1 >= 0 && i1 < b && j1 < c)
                    if(flag)
                        k1 = d[(b - i1 - 1) + j1 * b];
                    else
                        k1 = d[i1 + j1 * b];
                if(ai[k + l * 3] != k1)
                    return false;
            }

        }

        return true;
    }

    public ev b(int ai[])
    {
        return new ev(e.c, e.a);
    }

    public int a()
    {
        return b * c;
    }

    private int b;
    private int c;
    private int d[];
    private ev e;
    public final int a;
}
