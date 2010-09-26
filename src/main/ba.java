package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class ba extends nq
{

    public ba(cn cn1, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(cn1, d, d1, d2, d3, d4, d5);
        i = 1.0F;
        j = 1.0F;
        k = 1.0F;
        b = 32;
        a(0.02F, 0.02F);
        g = g * (aQ.nextFloat() * 0.6F + 0.2F);
        an = d3 * 0.20000000298023224D + (double)((float)(Math.random() * 2D - 1.0D) * 0.02F);
        ao = d4 * 0.20000000298023224D + (double)((float)(Math.random() * 2D - 1.0D) * 0.02F);
        ap = d5 * 0.20000000298023224D + (double)((float)(Math.random() * 2D - 1.0D) * 0.02F);
        f = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
    }

    public void e_()
    {
        ah = ak;
        ai = al;
        aj = am;
        ao += 0.002D;
        c(an, ao, ap);
        an *= 0.85000002384185791D;
        ao *= 0.85000002384185791D;
        ap *= 0.85000002384185791D;
        if(ag.f(eo.b(ak), eo.b(al), eo.b(am)) != gb.f)
            F();
        if(f-- <= 0)
            F();
    }
}
