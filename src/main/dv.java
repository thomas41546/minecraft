package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class dv extends hg
{

    public dv()
    {
        super(12, 0.0F);
        d = new ip(0, 0);
        d.a(-4F, -4F, -6F, 8, 8, 6, 0.0F);
        d.a(0.0F, 4F, -8F);
        b = new ip(22, 0);
        b.a(-5F, -5F, -4F, 1, 3, 1, 0.0F);
        b.a(0.0F, 3F, -7F);
        c = new ip(22, 0);
        c.a(4F, -5F, -4F, 1, 3, 1, 0.0F);
        c.a(0.0F, 3F, -7F);
        a = new ip(52, 0);
        a.a(-2F, -3F, 0.0F, 4, 6, 2, 0.0F);
        a.a(0.0F, 14F, 6F);
        a.d = 1.570796F;
        e = new ip(18, 4);
        e.a(-6F, -10F, -7F, 12, 18, 10, 0.0F);
        e.a(0.0F, 5F, 2.0F);
        f.a--;
        g.a++;
        f.c += 0.0F;
        g.c += 0.0F;
        h.a--;
        i.a++;
        h.c--;
        i.c--;
    }

    public void b(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.b(f, f1, f2, f3, f4, f5);
        b.a(f5);
        c.a(f5);
        a.a(f5);
    }

    public void a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.a(f, f1, f2, f3, f4, f5);
        b.e = d.e;
        b.d = d.d;
        c.e = d.e;
        c.d = d.d;
    }

    ip a;
    ip b;
    ip c;
}
