package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class kv extends fo
{

    public kv()
    {
        byte byte0 = 16;
        a = new ip(0, 0);
        a.a(-2F, -6F, -2F, 4, 6, 3, 0.0F);
        a.a(0.0F, -1 + byte0, -4F);
        g = new ip(14, 0);
        g.a(-2F, -4F, -4F, 4, 2, 2, 0.0F);
        g.a(0.0F, -1 + byte0, -4F);
        h = new ip(14, 4);
        h.a(-1F, -2F, -3F, 2, 2, 2, 0.0F);
        h.a(0.0F, -1 + byte0, -4F);
        b = new ip(0, 9);
        b.a(-3F, -4F, -3F, 6, 8, 6, 0.0F);
        b.a(0.0F, 0 + byte0, 0.0F);
        c = new ip(26, 0);
        c.a(-1F, 0.0F, -3F, 3, 5, 3);
        c.a(-2F, 3 + byte0, 1.0F);
        d = new ip(26, 0);
        d.a(-1F, 0.0F, -3F, 3, 5, 3);
        d.a(1.0F, 3 + byte0, 1.0F);
        e = new ip(24, 13);
        e.a(0.0F, 0.0F, -3F, 1, 4, 6);
        e.a(-4F, -3 + byte0, 0.0F);
        f = new ip(24, 13);
        f.a(-1F, 0.0F, -3F, 1, 4, 6);
        f.a(4F, -3 + byte0, 0.0F);
    }

    public void b(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        a(f1, f2, f3, f4, f5, f6);
        a.a(f6);
        g.a(f6);
        h.a(f6);
        b.a(f6);
        c.a(f6);
        d.a(f6);
        e.a(f6);
        f.a(f6);
    }

    public void a(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        a.d = -(f5 / 57.29578F);
        a.e = f4 / 57.29578F;
        g.d = a.d;
        g.e = a.e;
        h.d = a.d;
        h.e = a.e;
        b.d = 1.570796F;
        c.d = eo.b(f1 * 0.6662F) * 1.4F * f2;
        d.d = eo.b(f1 * 0.6662F + 3.141593F) * 1.4F * f2;
        e.f = f3;
        f.f = -f3;
    }

    public ip a;
    public ip b;
    public ip c;
    public ip d;
    public ip e;
    public ip f;
    public ip g;
    public ip h;
}
