package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class ma extends ge
    implements co
{

    public ma(cn cn1)
    {
        super(cn1);
        d = 0;
        c = 1;
        u = "/mob/slime.png";
        c = 1 << aQ.nextInt(3);
        aB = 0.0F;
        d = aQ.nextInt(20) + 10;
        c(c);
    }

    public void c(int i)
    {
        c = i;
        a(0.6F * (float)i, 0.6F * (float)i);
        E = i * i;
        a(ak, al, am);
    }

    public void a(hm hm1)
    {
        super.a(hm1);
        hm1.a("Size", c - 1);
    }

    public void b(hm hm1)
    {
        super.b(hm1);
        c = hm1.e("Size") + 1;
    }

    public void e_()
    {
        b = a;
        boolean flag = av;
        super.e_();
        if(av && !flag)
        {
            for(int i = 0; i < c * 8; i++)
            {
                float f1 = aQ.nextFloat() * 3.141593F * 2.0F;
                float f2 = aQ.nextFloat() * 0.5F + 0.5F;
                float f3 = eo.a(f1) * (float)c * 0.5F * f2;
                float f4 = eo.b(f1) * (float)c * 0.5F * f2;
                ag.a("slime", ak + (double)f3, au.b, am + (double)f4, 0.0D, 0.0D, 0.0D);
            }

            if(c > 2)
                ag.a(((kh) (this)), "mob.slime", f(), ((aQ.nextFloat() - aQ.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            a = -0.5F;
        }
        a = a * 0.6F;
    }

    protected void b_()
    {
        dm dm1 = ag.a(((kh) (this)), 16D);
        if(dm1 != null)
            b(((kh) (dm1)), 10F);
        if(av && d-- <= 0)
        {
            d = aQ.nextInt(20) + 10;
            if(dm1 != null)
                d /= 3;
            Y = true;
            if(c > 1)
                ag.a(((kh) (this)), "mob.slime", f(), ((aQ.nextFloat() - aQ.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            a = 1.0F;
            V = 1.0F - aQ.nextFloat() * 2.0F;
            W = 1 * c;
        } else
        {
            Y = false;
            if(av)
                V = W = 0.0F;
        }
    }

    public void F()
    {
        if(c > 1 && E == 0)
        {
            for(int i = 0; i < 4; i++)
            {
                float f1 = (((float)(i % 2) - 0.5F) * (float)c) / 4F;
                float f2 = (((float)(i / 2) - 0.5F) * (float)c) / 4F;
                ma ma1 = new ma(ag);
                ma1.c(c / 2);
                ma1.c(ak + (double)f1, al + 0.5D, am + (double)f2, aQ.nextFloat() * 360F, 0.0F);
                ag.a(((kh) (ma1)));
            }

        }
        super.F();
    }

    public void b(dm dm1)
    {
        if(c > 1 && c(((kh) (dm1))) && (double)d(((kh) (dm1))) < 0.59999999999999998D * (double)c && dm1.a(((kh) (this)), c))
            ag.a(((kh) (this)), "mob.slimeattack", 1.0F, (aQ.nextFloat() - aQ.nextFloat()) * 0.2F + 1.0F);
    }

    protected String d()
    {
        return "mob.slime";
    }

    protected String e()
    {
        return "mob.slime";
    }

    protected int g()
    {
        if(c == 1)
            return di.aK.aS;
        else
            return 0;
    }

    public boolean a()
    {
        ga ga1 = ag.a(eo.b(ak), eo.b(al));
        return (c == 1 || ag.l > 0) && aQ.nextInt(10) == 0 && ga1.a(0x3ad8025fL).nextInt(10) == 0 && al < 16D;
    }

    protected float f()
    {
        return 0.6F;
    }

    public float a;
    public float b;
    private int d;
    public int c;
}
