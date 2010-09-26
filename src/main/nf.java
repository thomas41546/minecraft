package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class nf extends nq
{

    public nf(cn cn1, double d, double d1, double d2)
    {
        super(cn1, d, d1, d2, 0.0D, 0.0D, 0.0D);
        an *= 0.30000001192092896D;
        ao = (float)Math.random() * 0.2F + 0.1F;
        ap *= 0.30000001192092896D;
        i = 1.0F;
        j = 1.0F;
        k = 1.0F;
        b = 19 + aQ.nextInt(4);
        a(0.01F, 0.01F);
        h = 0.06F;
        f = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
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
        ao -= h;
        c(an, ao, ap);
        an *= 0.98000001907348633D;
        ao *= 0.98000001907348633D;
        ap *= 0.98000001907348633D;
        if(f-- <= 0)
            F();
        if(av)
        {
            if(Math.random() < 0.5D)
                F();
            an *= 0.69999998807907104D;
            ap *= 0.69999998807907104D;
        }
        gb gb1 = ag.f(eo.b(ak), eo.b(al), eo.b(am));
        if(gb1.d() || gb1.a())
        {
            double d = (float)(eo.b(al) + 1) - jp.b(ag.e(eo.b(ak), eo.b(al), eo.b(am)));
            if(al < d)
                F();
        }
    }
}
