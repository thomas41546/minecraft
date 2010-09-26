package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class mm extends dk
{

    public mm(ee ee1, gh gh, int i, int j, int k)
    {
        super(gh, i);
        c = ee1;
        e = j;
        f = k;
    }

    public boolean a(int i, int j)
    {
        int k = (c.c - c.a) / 2;
        int l = (c.d - c.h) / 2;
        i -= k;
        j -= l;
        return i >= e - 1 && i < e + 16 + 1 && j >= f - 1 && j < f + 16 + 1;
    }

    private final ee c;
    public final int e;
    public final int f;
}
