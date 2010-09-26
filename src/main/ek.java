package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class ek extends ge
{

    public ek(cn cn1)
    {
        super(cn1);
        g = false;
    }

    protected void b_()
    {
        g = false;
        float f1 = 16F;
        if(f == null)
        {
            f = i();
            if(f != null)
                a = ag.a(((kh) (this)), f, f1);
        } else
        if(!f.B())
        {
            f = null;
        } else
        {
            float f2 = f.d(((kh) (this)));
            if(c(f))
                a(f, f2);
        }
        if(!g && f != null && (a == null || aQ.nextInt(20) == 0))
            a = ag.a(((kh) (this)), f, f1);
        else
        if(a == null && aQ.nextInt(80) == 0 || aQ.nextInt(80) == 0)
        {
            boolean flag = false;
            int k = -1;
            int l = -1;
            int i1 = -1;
            float f3 = -99999F;
            for(int j1 = 0; j1 < 10; j1++)
            {
                int k1 = eo.b((ak + (double)aQ.nextInt(13)) - 6D);
                int l1 = eo.b((al + (double)aQ.nextInt(7)) - 3D);
                int i2 = eo.b((am + (double)aQ.nextInt(13)) - 6D);
                float f4 = a(k1, l1, i2);
                if(f4 > f3)
                {
                    f3 = f4;
                    k = k1;
                    l = l1;
                    i1 = i2;
                    flag = true;
                }
            }

            if(flag)
                a = ag.a(((kh) (this)), k, l, i1, 10F);
        }
        int j = eo.b(au.b);
        boolean flag1 = g_();
        boolean flag2 = G();
        ar = 0.0F;
        if(a == null || aQ.nextInt(100) == 0)
        {
            super.b_();
            a = null;
            return;
        }
        aj aj1 = a.a(((kh) (this)));
        for(double d = aC * 2.0F; aj1 != null && aj1.d(ak, aj1.b, am) < d * d;)
        {
            a.a();
            if(a.b())
            {
                aj1 = null;
                a = null;
            } else
            {
                aj1 = a.a(((kh) (this)));
            }
        }

        Y = false;
        if(aj1 != null)
        {
            double d1 = aj1.a - ak;
            double d2 = aj1.c - am;
            double d3 = aj1.b - (double)j;
            float f5 = (float)((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - 90F;
            float f6 = f5 - aq;
            W = aa;
            for(; f6 < -180F; f6 += 360F);
            for(; f6 >= 180F; f6 -= 360F);
            if(f6 > 30F)
                f6 = 30F;
            if(f6 < -30F)
                f6 = -30F;
            aq += f6;
            if(g && f != null)
            {
                double d4 = f.ak - ak;
                double d5 = f.am - am;
                float f8 = aq;
                aq = (float)((Math.atan2(d5, d4) * 180D) / 3.1415927410125732D) - 90F;
                float f7 = (((f8 - aq) + 90F) * 3.141593F) / 180F;
                V = -eo.a(f7) * W * 1.0F;
                W = eo.b(f7) * W * 1.0F;
            }
            if(d3 > 0.0D)
                Y = true;
        }
        if(f != null)
            b(f, 30F);
        if(aw)
            Y = true;
        if(aQ.nextFloat() < 0.8F && (flag1 || flag2))
            Y = true;
    }

    protected void a(kh kh1, float f1)
    {
    }

    protected float a(int j, int k, int l)
    {
        return 0.0F;
    }

    protected kh i()
    {
        return null;
    }

    public boolean a()
    {
        int j = eo.b(ak);
        int k = eo.b(au.b);
        int l = eo.b(am);
        return super.a() && a(j, k, l) >= 0.0F;
    }

    private bl a;
    protected kh f;
    protected boolean g;
}
