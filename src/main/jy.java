package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class jy extends fo
{

    public jy()
    {
        float f1 = 0.0F;
        int k = 15;
        a = new ip(32, 4);
        a.a(-4F, -4F, -8F, 8, 8, 8, f1);
        a.a(0.0F, 0 + k, -3F);
        b = new ip(0, 0);
        b.a(-3F, -3F, -3F, 6, 6, 6, f1);
        b.a(0.0F, k, 0.0F);
        c = new ip(0, 12);
        c.a(-5F, -4F, -6F, 10, 8, 12, f1);
        c.a(0.0F, 0 + k, 9F);
        d = new ip(18, 0);
        d.a(-15F, -1F, -1F, 16, 2, 2, f1);
        d.a(-4F, 0 + k, 2.0F);
        e = new ip(18, 0);
        e.a(-1F, -1F, -1F, 16, 2, 2, f1);
        e.a(4F, 0 + k, 2.0F);
        f = new ip(18, 0);
        f.a(-15F, -1F, -1F, 16, 2, 2, f1);
        f.a(-4F, 0 + k, 1.0F);
        g = new ip(18, 0);
        g.a(-1F, -1F, -1F, 16, 2, 2, f1);
        g.a(4F, 0 + k, 1.0F);
        h = new ip(18, 0);
        h.a(-15F, -1F, -1F, 16, 2, 2, f1);
        h.a(-4F, 0 + k, 0.0F);
        i = new ip(18, 0);
        i.a(-1F, -1F, -1F, 16, 2, 2, f1);
        i.a(4F, 0 + k, 0.0F);
        j = new ip(18, 0);
        j.a(-15F, -1F, -1F, 16, 2, 2, f1);
        j.a(-4F, 0 + k, -1F);
        m = new ip(18, 0);
        m.a(-1F, -1F, -1F, 16, 2, 2, f1);
        m.a(4F, 0 + k, -1F);
    }

    public void b(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        a(f1, f2, f3, f4, f5, f6);
        a.a(f6);
        b.a(f6);
        c.a(f6);
        d.a(f6);
        e.a(f6);
        f.a(f6);
        g.a(f6);
        h.a(f6);
        i.a(f6);
        j.a(f6);
        m.a(f6);
    }

    public void a(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        a.e = f4 / 57.29578F;
        a.d = f5 / 57.29578F;
        float f7 = 0.7853982F;
        d.f = -f7;
        e.f = f7;
        f.f = -f7 * 0.74F;
        g.f = f7 * 0.74F;
        h.f = -f7 * 0.74F;
        i.f = f7 * 0.74F;
        j.f = -f7;
        m.f = f7;
        float f8 = 0F;
        float f9 = 0.3926991F;
        d.e = f9 * 2.0F + f8;
        e.e = -f9 * 2.0F - f8;
        f.e = f9 * 1.0F + f8;
        g.e = -f9 * 1.0F - f8;
        h.e = -f9 * 1.0F + f8;
        i.e = f9 * 1.0F - f8;
        j.e = -f9 * 2.0F + f8;
        m.e = f9 * 2.0F - f8;
        float f10 = -(eo.b(f1 * 0.6662F * 2.0F + 0.0F) * 0.4F) * f2;
        float f11 = -(eo.b(f1 * 0.6662F * 2.0F + 3.141593F) * 0.4F) * f2;
        float f12 = -(eo.b(f1 * 0.6662F * 2.0F + 1.570796F) * 0.4F) * f2;
        float f13 = -(eo.b(f1 * 0.6662F * 2.0F + 4.712389F) * 0.4F) * f2;
        float f14 = Math.abs(eo.a(f1 * 0.6662F + 0.0F) * 0.4F) * f2;
        float f15 = Math.abs(eo.a(f1 * 0.6662F + 3.141593F) * 0.4F) * f2;
        float f16 = Math.abs(eo.a(f1 * 0.6662F + 1.570796F) * 0.4F) * f2;
        float f17 = Math.abs(eo.a(f1 * 0.6662F + 4.712389F) * 0.4F) * f2;
        d.e += f10;
        e.e += -f10;
        f.e += f11;
        g.e += -f11;
        h.e += f12;
        i.e += -f12;
        j.e += f13;
        m.e += -f13;
        d.f += f14;
        e.f += -f14;
        f.f += f15;
        g.f += -f15;
        h.f += f16;
        i.f += -f16;
        j.f += f17;
        m.f += -f17;
    }

    public ip a;
    public ip b;
    public ip c;
    public ip d;
    public ip e;
    public ip f;
    public ip g;
    public ip h;
    public ip i;
    public ip j;
    public ip m;
}
