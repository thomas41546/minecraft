package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class nn extends ik
{

    public nn(int i)
    {
        a = i;
    }

    public boolean a(cn cn1, Random random, int i, int j, int k)
    {
        if(cn1.a(i, j + 1, k) != ly.u.bc)
            return false;
        if(cn1.a(i, j - 1, k) != ly.u.bc)
            return false;
        if(cn1.a(i, j, k) != 0 && cn1.a(i, j, k) != ly.u.bc)
            return false;
        int l = 0;
        if(cn1.a(i - 1, j, k) == ly.u.bc)
            l++;
        if(cn1.a(i + 1, j, k) == ly.u.bc)
            l++;
        if(cn1.a(i, j, k - 1) == ly.u.bc)
            l++;
        if(cn1.a(i, j, k + 1) == ly.u.bc)
            l++;
        int i1 = 0;
        if(cn1.a(i - 1, j, k) == 0)
            i1++;
        if(cn1.a(i + 1, j, k) == 0)
            i1++;
        if(cn1.a(i, j, k - 1) == 0)
            i1++;
        if(cn1.a(i, j, k + 1) == 0)
            i1++;
        if(l == 3 && i1 == 1)
            cn1.d(i, j, k, a);
        return true;
    }

    private int a;
}
