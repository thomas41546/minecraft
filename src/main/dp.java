package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class dp extends nq
{

    public dp(cn cn, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(cn, d, d1, d2, d3, d4, d5);
        an = d3 + (double)((float)(Math.random() * 2D - 1.0D) * 0.05F);
        ao = d4 + (double)((float)(Math.random() * 2D - 1.0D) * 0.05F);
        ap = d5 + (double)((float)(Math.random() * 2D - 1.0D) * 0.05F);
        i = j = k = aQ.nextFloat() * 0.3F + 0.7F;
        g = aQ.nextFloat() * aQ.nextFloat() * 6F + 1.0F;
        f = (int)(16D / ((double)aQ.nextFloat() * 0.80000000000000004D + 0.20000000000000001D)) + 2;
    }

    public void a(ho ho, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.a(ho, f, f1, f2, f3, f4, f5);
    }

    public void e_()
    {
        ah = ak;
        ai = al;
        aj = am;
        if(e++ >= f)
            F();
        b = 7 - (e * 8) / f;
        ao += 0.0040000000000000001D;
        c(an, ao, ap);
        an *= 0.89999997615814209D;
        ao *= 0.89999997615814209D;
        ap *= 0.89999997615814209D;
        if(av)
        {
            an *= 0.69999998807907104D;
            ap *= 0.69999998807907104D;
        }
    }
}
