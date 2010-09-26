package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class hh extends fo
{

    public hh(int i)
    {
        a = new ip(0, i);
        a.a(-4F, 16F, -4F, 8, 8, 8);
        if(i > 0)
        {
            a = new ip(0, i);
            a.a(-3F, 17F, -3F, 6, 6, 6);
            b = new ip(32, 0);
            b.a(-3.25F, 18F, -3.5F, 2, 2, 2);
            c = new ip(32, 4);
            c.a(1.25F, 18F, -3.5F, 2, 2, 2);
            d = new ip(32, 8);
            d.a(0.0F, 21F, -3.5F, 1, 1, 1);
        }
    }

    public void a(float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

    public void b(float f, float f1, float f2, float f3, float f4, float f5)
    {
        a(f, f1, f2, f3, f4, f5);
        a.a(f5);
        if(b != null)
        {
            b.a(f5);
            c.a(f5);
            d.a(f5);
        }
    }

    ip a;
    ip b;
    ip c;
    ip d;
}
