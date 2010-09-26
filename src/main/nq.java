package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class nq extends kh
{

    public nq(cn cn, double d1, double d2, double d3, 
            double d4, double d5, double d6)
    {
        super(cn);
        e = 0;
        f = 0;
        a(0.2F, 0.2F);
        aB = aD / 2.0F;
        a(d1, d2, d3);
        i = j = k = 1.0F;
        an = d4 + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        ao = d5 + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        ap = d6 + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        float f1 = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
        float f2 = eo.a(an * an + ao * ao + ap * ap);
        an = (an / (double)f2) * (double)f1 * 0.40000000596046448D;
        ao = (ao / (double)f2) * (double)f1 * 0.40000000596046448D + 0.10000000149011612D;
        ap = (ap / (double)f2) * (double)f1 * 0.40000000596046448D;
        c = aQ.nextFloat() * 3F;
        d = aQ.nextFloat() * 3F;
        g = (aQ.nextFloat() * 0.5F + 0.5F) * 2.0F;
        f = (int)(4F / (aQ.nextFloat() * 0.9F + 0.1F));
        e = 0;
        aG = false;
    }

    public nq b(float f1)
    {
        an *= f1;
        ao = (ao - 0.10000000149011612D) * (double)f1 + 0.10000000149011612D;
        ap *= f1;
        return this;
    }

    public nq d(float f1)
    {
        a(0.2F * f1, 0.2F * f1);
        g *= f1;
        return this;
    }

    public void e_()
    {
        ah = ak;
        ai = al;
        aj = am;
        if(e++ >= f)
            F();
        ao -= 0.040000000000000001D * (double)h;
        c(an, ao, ap);
        an *= 0.98000001907348633D;
        ao *= 0.98000001907348633D;
        ap *= 0.98000001907348633D;
        if(av)
        {
            an *= 0.69999998807907104D;
            ap *= 0.69999998807907104D;
        }
    }

    public void a(ho ho1, float f1, float f2, float f3, float f4, float f5, float f6)
    {
        float f7 = (float)(b % 16) / 16F;
        float f8 = f7 + 0.0624375F;
        float f9 = (float)(b / 16) / 16F;
        float f10 = f9 + 0.0624375F;
        float f11 = 0.1F * g;
        float f12 = (float)((ah + (ak - ah) * (double)f1) - l);
        float f13 = (float)((ai + (al - ai) * (double)f1) - m);
        float f14 = (float)((aj + (am - aj) * (double)f1) - n);
        float f15 = a(f1);
        ho1.a(i * f15, j * f15, k * f15);
        ho1.a(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f7, f10);
        ho1.a((f12 - f2 * f11) + f5 * f11, f13 + f3 * f11, (f14 - f4 * f11) + f6 * f11, f7, f9);
        ho1.a(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f8, f9);
        ho1.a((f12 + f2 * f11) - f5 * f11, f13 - f3 * f11, (f14 + f4 * f11) - f6 * f11, f8, f10);
    }

    public int c()
    {
        return 0;
    }

    public void a(hm hm)
    {
    }

    public void b(hm hm)
    {
    }

    protected int b;
    protected float c;
    protected float d;
    protected int e;
    protected int f;
    protected float g;
    protected float h;
    protected float i;
    protected float j;
    protected float k;
    public static double l;
    public static double m;
    public static double n;
}
