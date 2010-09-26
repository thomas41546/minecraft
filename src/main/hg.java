package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class hg extends fo
{

    public hg(int j, float f1)
    {
        d = new ip(0, 0);
        d.a(-4F, -4F, -8F, 8, 8, 8, f1);
        d.a(0.0F, 18 - j, -6F);
        e = new ip(28, 8);
        e.a(-5F, -10F, -7F, 10, 16, 8, f1);
        e.a(0.0F, 17 - j, 2.0F);
        f = new ip(0, 16);
        f.a(-2F, 0.0F, -2F, 4, j, 4, f1);
        f.a(-3F, 24 - j, 7F);
        g = new ip(0, 16);
        g.a(-2F, 0.0F, -2F, 4, j, 4, f1);
        g.a(3F, 24 - j, 7F);
        h = new ip(0, 16);
        h.a(-2F, 0.0F, -2F, 4, j, 4, f1);
        h.a(-3F, 24 - j, -5F);
        i = new ip(0, 16);
        i.a(-2F, 0.0F, -2F, 4, j, 4, f1);
        i.a(3F, 24 - j, -5F);
    }

    public void b(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        a(f1, f2, f3, f4, f5, f6);
        d.a(f6);
        e.a(f6);
        f.a(f6);
        g.a(f6);
        h.a(f6);
        i.a(f6);
    }

    public void a(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        d.d = -(f5 / 57.29578F);
        d.e = f4 / 57.29578F;
        e.d = 1.570796F;
        f.d = eo.b(f1 * 0.6662F) * 1.4F * f2;
        g.d = eo.b(f1 * 0.6662F + 3.141593F) * 1.4F * f2;
        h.d = eo.b(f1 * 0.6662F + 3.141593F) * 1.4F * f2;
        i.d = eo.b(f1 * 0.6662F) * 1.4F * f2;
    }

    public ip d;
    public ip e;
    public ip f;
    public ip g;
    public ip h;
    public ip i;
}
