package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class cy
{

    public cy()
    {
        a = 8;
        b = new Random();
    }

    public void a(nw nw, cn cn1, int i, int j, byte abyte0[])
    {
        int k = a;
        b.setSeed(cn1.u);
        long l = (b.nextLong() / 2L) * 2L + 1L;
        long l1 = (b.nextLong() / 2L) * 2L + 1L;
        for(int i1 = i - k; i1 <= i + k; i1++)
        {
            for(int j1 = j - k; j1 <= j + k; j1++)
            {
                b.setSeed((long)i1 * l + (long)j1 * l1 ^ cn1.u);
                a(cn1, i1, j1, i, j, abyte0);
            }

        }

    }

    protected void a(cn cn1, int i, int j, int k, int l, byte abyte0[])
    {
    }

    protected int a;
    protected Random b;
}
