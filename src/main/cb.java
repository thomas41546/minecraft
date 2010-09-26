package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class cb extends cr
{

    public cb()
    {
    }

    public void a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.a(f, f1, f2, f3, f4, f5);
        float f6 = eo.a(k * 3.141593F);
        float f7 = eo.a((1.0F - (1.0F - k) * (1.0F - k)) * 3.141593F);
        d.f = 0.0F;
        e.f = 0.0F;
        d.e = -(0.1F - f6 * 0.6F);
        e.e = 0.1F - f6 * 0.6F;
        d.d = -1.570796F;
        e.d = -1.570796F;
        d.d -= f6 * 1.2F - f7 * 0.4F;
        e.d -= f6 * 1.2F - f7 * 0.4F;
        d.f += eo.b(f2 * 0.09F) * 0.05F + 0.05F;
        e.f -= eo.b(f2 * 0.09F) * 0.05F + 0.05F;
        d.d += eo.a(f2 * 0.067F) * 0.05F;
        e.d -= eo.a(f2 * 0.067F) * 0.05F;
    }
}
