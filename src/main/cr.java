package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class cr extends fo
{

    public cr()
    {
        this(0.0F);
    }

    public cr(float f1)
    {
        this(f1, 0.0F);
    }

    public cr(float f1, float f2)
    {
        h = false;
        i = false;
        j = false;
        a = new ip(0, 0);
        a.a(-4F, -8F, -4F, 8, 8, 8, f1);
        a.a(0.0F, 0.0F + f2, 0.0F);
        b = new ip(32, 0);
        b.a(-4F, -8F, -4F, 8, 8, 8, f1 + 0.5F);
        b.a(0.0F, 0.0F + f2, 0.0F);
        c = new ip(16, 16);
        c.a(-4F, 0.0F, -2F, 8, 12, 4, f1);
        c.a(0.0F, 0.0F + f2, 0.0F);
        d = new ip(40, 16);
        d.a(-3F, -2F, -2F, 4, 12, 4, f1);
        d.a(-5F, 2.0F + f2, 0.0F);
        e = new ip(40, 16);
        e.g = true;
        e.a(-1F, -2F, -2F, 4, 12, 4, f1);
        e.a(5F, 2.0F + f2, 0.0F);
        f = new ip(0, 16);
        f.a(-2F, 0.0F, -2F, 4, 12, 4, f1);
        f.a(-2F, 12F + f2, 0.0F);
        g = new ip(0, 16);
        g.g = true;
        g.a(-2F, 0.0F, -2F, 4, 12, 4, f1);
        g.a(2.0F, 12F + f2, 0.0F);
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
        b.a(f6);
    }

    public void a(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        a.e = f4 / 57.29578F;
        a.d = f5 / 57.29578F;
        b.e = a.e;
        b.d = a.d;
        d.d = eo.b(f1 * 0.6662F + 3.141593F) * 2.0F * f2 * 0.5F;
        e.d = eo.b(f1 * 0.6662F) * 2.0F * f2 * 0.5F;
        d.f = 0.0F;
        e.f = 0.0F;
        f.d = eo.b(f1 * 0.6662F) * 1.4F * f2;
        g.d = eo.b(f1 * 0.6662F + 3.141593F) * 1.4F * f2;
        f.e = 0.0F;
        g.e = 0.0F;
        if(l)
        {
            d.d += -0.6283185F;
            e.d += -0.6283185F;
            f.d = -1.256637F;
            g.d = -1.256637F;
            f.e = 0.3141593F;
            g.e = -0.3141593F;
        }
        if(h)
            e.d = e.d * 0.5F - 0.3141593F;
        if(i)
            d.d = d.d * 0.5F - 0.3141593F;
        d.e = 0.0F;
        e.e = 0.0F;
        if(k > -9990F)
        {
            float f7 = k;
            c.e = eo.a(eo.c(f7) * 3.141593F * 2.0F) * 0.2F;
            d.c = eo.a(c.e) * 5F;
            d.a = -eo.b(c.e) * 5F;
            e.c = -eo.a(c.e) * 5F;
            e.a = eo.b(c.e) * 5F;
            d.e += c.e;
            e.e += c.e;
            e.d += c.e;
            f7 = 1.0F - k;
            f7 *= f7;
            f7 *= f7;
            f7 = 1.0F - f7;
            float f8 = eo.a(f7 * 3.141593F);
            float f9 = eo.a(k * 3.141593F) * -(a.d - 0.7F) * 0.75F;
            d.d -= ((float) ((double)f8 * 1.2D + (double)f9));
            d.e += c.e * 2.0F;
            d.f = eo.a(k * 3.141593F) * -0.4F;
        }
        if(j)
        {
            c.d = 0.5F;
            f.d -= 0.0F;
            g.d -= 0.0F;
            d.d += 0.4F;
            e.d += 0.4F;
            f.c = 4F;
            g.c = 4F;
            f.b = 9F;
            g.b = 9F;
            a.b = 1.0F;
        } else
        {
            c.d = 0.0F;
            f.c = 0.0F;
            g.c = 0.0F;
            f.b = 12F;
            g.b = 12F;
            a.b = 0.0F;
        }
        d.f += eo.b(f3 * 0.09F) * 0.05F + 0.05F;
        e.f -= eo.b(f3 * 0.09F) * 0.05F + 0.05F;
        d.d += eo.a(f3 * 0.067F) * 0.05F;
        e.d -= eo.a(f3 * 0.067F) * 0.05F;
    }

    public ip a;
    public ip b;
    public ip c;
    public ip d;
    public ip e;
    public ip f;
    public ip g;
    public boolean h;
    public boolean i;
    public boolean j;
}
