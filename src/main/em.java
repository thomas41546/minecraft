package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class em extends fo
{

    public em()
    {
        float f1 = 0.0F;
        int i = 4;
        a = new ip(0, 0);
        a.a(-4F, -8F, -4F, 8, 8, 8, f1);
        a.a(0.0F, i, 0.0F);
        b = new ip(32, 0);
        b.a(-4F, -8F, -4F, 8, 8, 8, f1 + 0.5F);
        b.a(0.0F, i, 0.0F);
        c = new ip(16, 16);
        c.a(-4F, 0.0F, -2F, 8, 12, 4, f1);
        c.a(0.0F, i, 0.0F);
        d = new ip(0, 16);
        d.a(-2F, 0.0F, -2F, 4, 6, 4, f1);
        d.a(-2F, 12 + i, 4F);
        e = new ip(0, 16);
        e.a(-2F, 0.0F, -2F, 4, 6, 4, f1);
        e.a(2.0F, 12 + i, 4F);
        f = new ip(0, 16);
        f.a(-2F, 0.0F, -2F, 4, 6, 4, f1);
        f.a(-2F, 12 + i, -4F);
        g = new ip(0, 16);
        g.a(-2F, 0.0F, -2F, 4, 6, 4, f1);
        g.a(2.0F, 12 + i, -4F);
    }

    public void b(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        a(f1, f2, f3, f4, f5, f6);
        a.a(f6);
        c.a(f6);
        d.a(f6);
        e.a(f6);
        f.a(f6);
        g.a(f6);
    }

    public void a(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        a.e = f4 / 57.29578F;
        a.d = f5 / 57.29578F;
        d.d = eo.b(f1 * 0.6662F) * 1.4F * f2;
        e.d = eo.b(f1 * 0.6662F + 3.141593F) * 1.4F * f2;
        f.d = eo.b(f1 * 0.6662F + 3.141593F) * 1.4F * f2;
        g.d = eo.b(f1 * 0.6662F) * 1.4F * f2;
    }

    public ip a;
    public ip b;
    public ip c;
    public ip d;
    public ip e;
    public ip f;
    public ip g;
}
