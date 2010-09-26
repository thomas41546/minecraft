package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class iu extends di
{

    public iu(int i, int j)
    {
        super(i);
        aT = 1;
        aU = 32 << j;
        if(j == 3)
            aU *= 4;
        a = 4 + j * 2;
    }

    public float a(ev ev1, ly ly)
    {
        return 1.5F;
    }

    public void a(ev ev1, ge ge)
    {
        ev1.b(1);
    }

    public void a(ev ev1, int i, int j, int k, int l)
    {
        ev1.b(2);
    }

    public int a(kh kh)
    {
        return a;
    }

    public boolean a()
    {
        return true;
    }

    private int a;
}
