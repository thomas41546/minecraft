package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class eq extends dn
{

    public eq(fo fo, float f)
    {
        super(fo, f);
    }

    public void a(mz mz1, double d1, double d2, double d3, 
            float f, float f1)
    {
        super.a(((ge) (mz1)), d1, d2, d3, f, f1);
    }

    protected float a(mz mz1, float f)
    {
        float f1 = mz1.e + (mz1.b - mz1.e) * f;
        float f2 = mz1.d + (mz1.c - mz1.d) * f;
        return (eo.a(f1) + 1.0F) * f2;
    }

    protected volatile float d(ge ge, float f)
    {
        return a((mz)ge, f);
    }

    public volatile void a(ge ge, double d1, double d2, double d3, 
            float f, float f1)
    {
        a((mz)ge, d1, d2, d3, f, f1);
    }

    public volatile void a(kh kh, double d1, double d2, double d3, 
            float f, float f1)
    {
        a((mz)kh, d1, d2, d3, f, f1);
    }
}
