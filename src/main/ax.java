package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class ax extends dq
{

    public ax(cn cn1)
    {
        super(cn1);
        u = "/mob/spider.png";
        a(1.4F, 0.9F);
        aa = 0.8F;
    }

    public double h()
    {
        return (double)aD * 0.75D - 0.5D;
    }

    protected kh i()
    {
        float f = a(1.0F);
        if(f < 0.5F)
        {
            double d1 = 16D;
            return ((kh) (ag.a(((kh) (this)), d1)));
        } else
        {
            return null;
        }
    }

    protected String c()
    {
        return "mob.spider";
    }

    protected String d()
    {
        return "mob.spider";
    }

    protected String e()
    {
        return "mob.spiderdeath";
    }

    protected void a(kh kh1, float f)
    {
        float f1 = a(1.0F);
        if(f1 > 0.5F && aQ.nextInt(100) == 0)
        {
            this.f = null;
            return;
        }
        if(f > 2.0F && f < 6F && aQ.nextInt(10) == 0)
        {
            if(av)
            {
                double d1 = kh1.ak - ak;
                double d2 = kh1.am - am;
                float f2 = eo.a(d1 * d1 + d2 * d2);
                an = (d1 / (double)f2) * 0.5D * 0.80000001192092896D + an * 0.20000000298023224D;
                ap = (d2 / (double)f2) * 0.5D * 0.80000001192092896D + ap * 0.20000000298023224D;
                ao = 0.40000000596046448D;
            }
        } else
        {
            super.a(kh1, f);
        }
    }

    public void a(hm hm)
    {
        super.a(hm);
    }

    public void b(hm hm)
    {
        super.b(hm);
    }

    protected int g()
    {
        return di.I.aS;
    }
}
