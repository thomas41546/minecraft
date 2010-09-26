package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class cq extends nq
{

    public cq(cn cn1, double d, double d1, double d2)
    {
        super(cn1, d, d1, d2, 0.0D, 0.0D, 0.0D);
        an *= 0.80000001192092896D;
        ao *= 0.80000001192092896D;
        ap *= 0.80000001192092896D;
        ao = aQ.nextFloat() * 0.4F + 0.05F;
        i = j = k = 1.0F;
        g *= aQ.nextFloat() * 2.0F + 0.2F;
        a = g;
        f = (int)(16D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
        aN = false;
        b = 49;
    }

    public float a(float f)
    {
        return 1.0F;
    }

    public void a(ho ho, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = ((float)e + f) / (float)this.f;
        g = a * (1.0F - f6 * f6);
        super.a(ho, f, f1, f2, f3, f4, f5);
    }

    public void e_()
    {
        ah = ak;
        ai = al;
        aj = am;
        if(e++ >= this.f)
            F();
        float f = (float)e / (float)this.f;
        if(aQ.nextFloat() > f)
            ag.a("smoke", ak, al, am, an, ao, ap);
        ao -= 0.029999999999999999D;
        c(an, ao, ap);
        an *= 0.99900001287460327D;
        ao *= 0.99900001287460327D;
        ap *= 0.99900001287460327D;
        if(av)
        {
            an *= 0.69999998807907104D;
            ap *= 0.69999998807907104D;
        }
    }

    private float a;
}
