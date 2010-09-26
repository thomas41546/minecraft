package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class kl
    implements oe
{

    public kl()
    {
        a = j.a();
    }

    public void a(double d1, double d2, double d3)
    {
        b = d1;
        c = d2;
        d = d3;
    }

    public boolean a(double d1, double d2, double d3, double d4, double d5, double d6)
    {
        return a.a(d1 - b, d2 - c, d3 - d, d4 - b, d5 - c, d6 - d);
    }

    public boolean a(cf cf1)
    {
        return a(cf1.a, cf1.b, cf1.c, cf1.d, cf1.e, cf1.f);
    }

    private bt a;
    private double b;
    private double c;
    private double d;
}
