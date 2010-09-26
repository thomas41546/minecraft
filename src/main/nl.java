package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class nl extends nq
{

    public nl(cn cn, double d, double d1, double d2)
    {
        this(cn, d, d1, d2, 1.0F);
    }

    public nl(cn cn, double d, double d1, double d2, 
            float f)
    {
        super(cn, d, d1, d2, 0.0D, 0.0D, 0.0D);
        an *= 0.10000000149011612D;
        ao *= 0.10000000149011612D;
        ap *= 0.10000000149011612D;
        i = j = k = (float)(Math.random() * 0.30000001192092896D);
        g *= 0.75F;
        g *= f;
        a = g;
        this.f = (int)(8D / (Math.random() * 0.80000000000000004D + 0.20000000000000001D));
        this.f *= ((int) (f));
        aN = false;
    }

    public void a(ho ho, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = (((float)e + f) / (float)this.f) * 32F;
        if(f6 < 0.0F)
            f6 = 0.0F;
        if(f6 > 1.0F)
            f6 = 1.0F;
        g = a * f6;
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
        if(al == ai)
        {
            an *= 1.1000000000000001D;
            ap *= 1.1000000000000001D;
        }
        an *= 0.95999997854232788D;
        ao *= 0.95999997854232788D;
        ap *= 0.95999997854232788D;
        if(av)
        {
            an *= 0.69999998807907104D;
            ap *= 0.69999998807907104D;
        }
    }

    float a;
}
