package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class dx extends kh
{

    public dx(cn cn1, double d1, double d2, double d3, 
            ev ev1)
    {
        super(cn1);
        b = 0;
        f = 5;
        d = (float)(Math.random() * 3.1415926535897931D * 2D);
        a(0.25F, 0.25F);
        aB = aD / 2.0F;
        a(d1, d2, d3);
        a = ev1;
        aq = (float)(Math.random() * 360D);
        an = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D);
        ao = 0.20000000298023224D;
        ap = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D);
        aG = false;
    }

    public dx(cn cn1)
    {
        super(cn1);
        b = 0;
        f = 5;
        d = (float)(Math.random() * 3.1415926535897931D * 2D);
        a(0.25F, 0.25F);
        aB = aD / 2.0F;
    }

    public void e_()
    {
        super.e_();
        if(c > 0)
            c--;
        ah = ak;
        ai = al;
        aj = am;
        ao -= 0.039999999105930328D;
        if(ag.f(eo.b(ak), eo.b(al), eo.b(am)) == gb.g)
        {
            ao = 0.20000000298023224D;
            an = (aQ.nextFloat() - aQ.nextFloat()) * 0.2F;
            ap = (aQ.nextFloat() - aQ.nextFloat()) * 0.2F;
            ag.a(((kh) (this)), "random.fizz", 0.4F, 2.0F + aQ.nextFloat() * 0.4F);
        }
        g(ak, al, am);
        g_();
        c(an, ao, ap);
        float f1 = 0.98F;
        if(av)
        {
            f1 = 0.5880001F;
            int i = ag.a(eo.b(ak), eo.b(au.b) - 1, eo.b(am));
            if(i > 0)
                f1 = ly.n[i].bo * 0.98F;
        }
        an *= f1;
        ao *= 0.98000001907348633D;
        ap *= f1;
        if(av)
            ao *= -0.5D;
        e++;
        b++;
        if(b >= 6000)
            F();
    }

    public boolean g_()
    {
        return ag.a(au, gb.f, ((kh) (this)));
    }

    private boolean g(double d1, double d2, double d3)
    {
        int i = eo.b(d1);
        int j = eo.b(d2);
        int k = eo.b(d3);
        double d4 = d1 - (double)i;
        double d5 = d2 - (double)j;
        double d6 = d3 - (double)k;
        if(ly.p[ag.a(i, j, k)])
        {
            boolean flag = !ly.p[ag.a(i - 1, j, k)];
            boolean flag1 = !ly.p[ag.a(i + 1, j, k)];
            boolean flag2 = !ly.p[ag.a(i, j - 1, k)];
            boolean flag3 = !ly.p[ag.a(i, j + 1, k)];
            boolean flag4 = !ly.p[ag.a(i, j, k - 1)];
            boolean flag5 = !ly.p[ag.a(i, j, k + 1)];
            byte byte0 = -1;
            double d7 = 9999D;
            if(flag && d4 < d7)
            {
                d7 = d4;
                byte0 = 0;
            }
            if(flag1 && 1.0D - d4 < d7)
            {
                d7 = 1.0D - d4;
                byte0 = 1;
            }
            if(flag2 && d5 < d7)
            {
                d7 = d5;
                byte0 = 2;
            }
            if(flag3 && 1.0D - d5 < d7)
            {
                d7 = 1.0D - d5;
                byte0 = 3;
            }
            if(flag4 && d6 < d7)
            {
                d7 = d6;
                byte0 = 4;
            }
            if(flag5 && 1.0D - d6 < d7)
            {
                double d8 = 1.0D - d6;
                byte0 = 5;
            }
            float f1 = aQ.nextFloat() * 0.2F + 0.1F;
            if(byte0 == 0)
                an = -f1;
            if(byte0 == 1)
                an = f1;
            if(byte0 == 2)
                ao = -f1;
            if(byte0 == 3)
                ao = f1;
            if(byte0 == 4)
                ap = -f1;
            if(byte0 == 5)
                ap = f1;
        }
        return false;
    }

    protected void a(int i)
    {
        a(((kh) (null)), i);
    }

    public boolean a(kh kh1, int i)
    {
        f -= i;
        if(f <= 0)
            F();
        return false;
    }

    public void a(hm hm1)
    {
        hm1.a("Health", (byte)f);
        hm1.a("Age", (short)b);
        hm1.a("Item", a.a(new hm()));
    }

    public void b(hm hm1)
    {
        f = hm1.d("Health") & 0xff;
        b = ((int) (hm1.d("Age")));
        hm hm2 = hm1.k("Item");
        a = new ev(hm2);
    }

    public void b(dm dm1)
    {
        if(ag.y)
            return;
        int i = a.a;
        if(c == 0 && dm1.b.a(a))
        {
            ag.a(((kh) (this)), "random.pop", 0.2F, ((aQ.nextFloat() - aQ.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            dm1.a_(((kh) (this)), i);
            F();
        }
    }

    public ev a;
    private int e;
    public int b;
    public int c;
    private int f;
    public float d;
}
