package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import java.util.Random;

public class dc extends kh
{

    public dc(cn cn1)
    {
        super(cn1);
        a = 0;
        b = 0;
        c = 1;
        ad = true;
        a(1.5F, 0.6F);
        aB = aD / 2.0F;
        aG = false;
    }

    public cf b_(kh kh1)
    {
        return kh1.au;
    }

    public cf f_()
    {
        return au;
    }

    public boolean d_()
    {
        return true;
    }

    public dc(cn cn1, double d, double d1, double d2)
    {
        this(cn1);
        a(d, d1 + (double)aB, d2);
        an = 0.0D;
        ao = 0.0D;
        ap = 0.0D;
        ah = d;
        ai = d1;
        aj = d2;
    }

    public double h()
    {
        return (double)aD * 0.0D - 0.30000001192092896D;
    }

    public boolean a(kh kh1, int i)
    {
        c = -c;
        b = 10;
        a += i * 10;
        if(a > 40)
        {
            for(int j = 0; j < 3; j++)
                a(ly.y.bc, 1, 0.0F);

            for(int k = 0; k < 2; k++)
                a(di.B.aS, 1, 0.0F);

            F();
        }
        return true;
    }

    public boolean c_()
    {
        return !aA;
    }

    public void e_()
    {
        super.e_();
        if(b > 0)
            b--;
        if(a > 0)
            a--;
        ah = ak;
        ai = al;
        aj = am;
        int i = 5;
        double d = 0.0D;
        for(int j = 0; j < i; j++)
        {
            double d2 = (au.b + ((au.e - au.b) * (double)(j + 0)) / (double)i) - 0.125D;
            double d4 = (au.b + ((au.e - au.b) * (double)(j + 1)) / (double)i) - 0.125D;
            cf cf1 = cf.b(au.a, d2, au.c, au.d, d4, au.f);
            if(ag.b(cf1, gb.f))
                d += 1.0D / (double)i;
        }

        double d1 = d * 2D - 1.0D;
        ao += 0.039999999105930328D * d1;
        if(ae != null)
        {
            an += ae.an * 0.20000000000000001D;
            ap += ae.ap * 0.20000000000000001D;
        }
        double d3 = 0.40000000000000002D;
        if(an < -d3)
            an = -d3;
        if(an > d3)
            an = d3;
        if(ap < -d3)
            ap = -d3;
        if(ap > d3)
            ap = d3;
        if(av)
        {
            an *= 0.5D;
            ao *= 0.5D;
            ap *= 0.5D;
        }
        c(an, ao, ap);
        double d5 = Math.sqrt(an * an + ap * ap);
        if(d5 > 0.14999999999999999D)
        {
            double d6 = Math.cos(((double)aq * 3.1415926535897931D) / 180D);
            double d8 = Math.sin(((double)aq * 3.1415926535897931D) / 180D);
            for(int i1 = 0; (double)i1 < 1.0D + d5 * 60D; i1++)
            {
                double d11 = aQ.nextFloat() * 2.0F - 1.0F;
                double d13 = (double)(aQ.nextInt(2) * 2 - 1) * 0.69999999999999996D;
                if(aQ.nextBoolean())
                {
                    double d14 = (ak - d6 * d11 * 0.80000000000000004D) + d8 * d13;
                    double d16 = am - d8 * d11 * 0.80000000000000004D - d6 * d13;
                    ag.a("splash", d14, al - 0.125D, d16, an, ao, ap);
                } else
                {
                    double d15 = ak + d6 + d8 * d11 * 0.69999999999999996D;
                    double d17 = (am + d8) - d6 * d11 * 0.69999999999999996D;
                    ag.a("splash", d15, al - 0.125D, d17, an, ao, ap);
                }
            }

        }
        if(aw && d5 > 0.14999999999999999D)
        {
            F();
            for(int k = 0; k < 3; k++)
                a(ly.y.bc, 1, 0.0F);

            for(int l = 0; l < 2; l++)
                a(di.B.aS, 1, 0.0F);

        } else
        {
            an *= 0.99000000953674316D;
            ao *= 0.94999998807907104D;
            ap *= 0.99000000953674316D;
        }
        ar = 0.0F;
        double d7 = aq;
        double d9 = ah - ak;
        double d10 = aj - am;
        if(d9 * d9 + d10 * d10 > 0.001D)
            d7 = (float)((Math.atan2(d10, d9) * 180D) / 3.1415926535897931D);
        double d12;
        for(d12 = d7 - (double)aq; d12 >= 180D; d12 -= 360D);
        for(; d12 < -180D; d12 += 360D);
        if(d12 > 20D)
            d12 = 20D;
        if(d12 < -20D)
            d12 = -20D;
        aq += ((float) (d12));
        c(aq, ar);
        List list = ag.b(((kh) (this)), au.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        if(list != null && list.size() > 0)
        {
            for(int j1 = 0; j1 < list.size(); j1++)
            {
                kh kh1 = (kh)list.get(j1);
                if(kh1 != ae && kh1.d_() && (kh1 instanceof dc))
                    kh1.f(((kh) (this)));
            }

        }
        if(ae != null && ae.aA)
            ae = null;
    }

    protected void i_()
    {
        double d = Math.cos(((double)aq * 3.1415926535897931D) / 180D) * 0.40000000000000002D;
        double d1 = Math.sin(((double)aq * 3.1415926535897931D) / 180D) * 0.40000000000000002D;
        ae.a(ak + d, al + h() + ae.v(), am + d1);
    }

    protected void a(hm hm)
    {
    }

    protected void b(hm hm)
    {
    }

    public float h_()
    {
        return 0.0F;
    }

    public boolean a(dm dm1)
    {
        dm1.g(((kh) (this)));
        return true;
    }

    public int a;
    public int b;
    public int c;
}
