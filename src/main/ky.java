package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class ky extends mq
{

    protected ky(int i, int j)
    {
        super(i, j);
        float f = 0.2F;
        a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    protected boolean b(int i)
    {
        return ly.p[i];
    }

    public boolean g(cn cn1, int i, int j, int k)
    {
        return cn1.j(i, j, k) <= 13 && b(cn1.a(i, j - 1, k));
    }
}
