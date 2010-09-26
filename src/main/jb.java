package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class jb extends nq
{

    public jb(cn cn, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(cn, d, d1, d2, d3, d4, d5);
        an = an * 0.0099999997764825821D + d3;
        ao = ao * 0.0099999997764825821D + d4;
        ap = ap * 0.0099999997764825821D + d5;
        d += (aQ.nextFloat() - aQ.nextFloat()) * 0.05F;
        d1 += (aQ.nextFloat() - aQ.nextFloat()) * 0.05F;
        d2 += (aQ.nextFloat() - aQ.nextFloat()) * 0.05F;
        a = g;
        i = j = k = 1.0F;
        f = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D)) + 4;
        aN = true;
        b = 48;
    }

    public void a(ho ho, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = ((float)e + f) / (float)this.f;
        g = a * (1.0F - f6 * f6 * 0.5F);
        super.a(ho, f, f1, f2, f3, f4, f5);
    }

    public float a(float f)
    {
        float f1 = ((float)e + f) / (float)this.f;
        if(f1 < 0.0F)
            f1 = 0.0F;
        if(f1 > 1.0F)
            f1 = 1.0F;
        float f2 = super.a(f);
        return f2 * f1 + (1.0F - f1);
    }

    public void e_()
    {
        ah = ak;
        ai = al;
        aj = am;
        if(e++ >= f)
            F();
        c(an, ao, ap);
        an *= 0.95999997854232788D;
        ao *= 0.95999997854232788D;
        ap *= 0.95999997854232788D;
        if(av)
        {
            an *= 0.69999998807907104D;
            ap *= 0.69999998807907104D;
        }
    }

    private float a;
}
