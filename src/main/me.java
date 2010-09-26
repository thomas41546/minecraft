package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class me extends di
{

    public me(int i)
    {
        super(i);
        aT = 1;
    }

    public ev a(ev ev1, cn cn1, dm dm1)
    {
        float f = 1.0F;
        float f1 = dm1.at + (dm1.ar - dm1.at) * f;
        float f2 = dm1.as + (dm1.aq - dm1.as) * f;
        double d = dm1.ah + (dm1.ak - dm1.ah) * (double)f;
        double d1 = dm1.ai + (dm1.al - dm1.ai) * (double)f;
        double d2 = dm1.aj + (dm1.am - dm1.aj) * (double)f;
        aj aj1 = aj.b(d, d1, d2);
        float f3 = eo.b(-f2 * 0.01745329F - 3.141593F);
        float f4 = eo.a(-f2 * 0.01745329F - 3.141593F);
        float f5 = -eo.b(-f1 * 0.01745329F);
        float f6 = eo.a(-f1 * 0.01745329F);
        float f7 = f4 * f5;
        float f8 = f6;
        float f9 = f3 * f5;
        double d3 = 5D;
        aj aj2 = aj1.c((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
        mf mf1 = cn1.a(aj1, aj2, true);
        if(mf1 == null)
            return ev1;
        if(mf1.a == 0)
        {
            int i = mf1.b;
            int j = mf1.c;
            int k = mf1.d;
            cn1.a(((kh) (new dc(cn1, (float)i + 0.5F, (float)j + 1.5F, (float)k + 0.5F))));
            ev1.a--;
        }
        return ev1;
    }
}
