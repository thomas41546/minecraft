package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class iy
{

    public iy(int i, int j)
    {
        b = i;
        c = j;
        for(a = 1; b / (a + 1) >= 320 && c / (a + 1) >= 240; a++);
        b = b / a;
        c = c / a;
    }

    public int a()
    {
        return b;
    }

    public int b()
    {
        return c;
    }

    private int b;
    private int c;
    public int a;
}
