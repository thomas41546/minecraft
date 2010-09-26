package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class cw extends dq
{

    public cw(cn cn1)
    {
        super(cn1);
        u = "/mob/skeleton.png";
    }

    protected String c()
    {
        return "mob.skeleton";
    }

    protected String d()
    {
        return "mob.skeletonhurt";
    }

    protected String e()
    {
        return "mob.skeletonhurt";
    }

    public void j()
    {
        if(ag.b())
        {
            float f = a(1.0F);
            if(f > 0.5F && ag.i(eo.b(ak), eo.b(al), eo.b(am)) && aQ.nextFloat() * 30F < (f - 0.4F) * 2.0F)
                aT = 300;
        }
        super.j();
    }

    protected void a(kh kh1, float f)
    {
        if(f < 10F)
        {
            double d1 = kh1.ak - ak;
            double d2 = kh1.am - am;
            if(K == 0)
            {
                kg kg1 = new kg(ag, ((ge) (this)));
                kg1.al += 1.3999999761581421D;
                double d3 = kh1.al - 0.20000000298023224D - kg1.al;
                float f1 = eo.a(d1 * d1 + d2 * d2) * 0.2F;
                ag.a(((kh) (this)), "random.bow", 1.0F, 1.0F / (aQ.nextFloat() * 0.4F + 0.8F));
                ag.a(((kh) (kg1)));
                kg1.a(d1, d3 + (double)f1, d2, 0.6F, 12F);
                K = 30;
            }
            aq = (float)((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - 90F;
            g = true;
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
        return di.j.aS;
    }
}
