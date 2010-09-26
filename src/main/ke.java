package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class ke extends ic
    implements gh
{

    public ke()
    {
        a = new ev[3];
        b = 0;
        c = 0;
        d = 0;
    }

    public int c()
    {
        return a.length;
    }

    public ev c(int k)
    {
        return a[k];
    }

    public ev a(int k, int l)
    {
        if(a[k] != null)
        {
            if(a[k].a <= l)
            {
                ev ev1 = a[k];
                a[k] = null;
                return ev1;
            }
            ev ev2 = a[k].a(l);
            if(a[k].a == 0)
                a[k] = null;
            return ev2;
        } else
        {
            return null;
        }
    }

    public void a(int k, ev ev1)
    {
        a[k] = ev1;
        if(ev1 != null && ev1.a > e())
            ev1.a = e();
    }

    public String d()
    {
        return "Chest";
    }

    public void a(hm hm1)
    {
        super.a(hm1);
        ki ki1 = hm1.l("Items");
        a = new ev[c()];
        for(int k = 0; k < ki1.c(); k++)
        {
            hm hm2 = (hm)ki1.a(k);
            byte byte0 = hm2.c("Slot");
            if(byte0 >= 0 && byte0 < a.length)
                a[byte0] = new ev(hm2);
        }

        b = ((int) (hm1.d("BurnTime")));
        d = ((int) (hm1.d("CookTime")));
        c = a(a[1]);
    }

    public void b(hm hm1)
    {
        super.b(hm1);
        hm1.a("BurnTime", (short)b);
        hm1.a("CookTime", (short)d);
        ki ki1 = new ki();
        for(int k = 0; k < a.length; k++)
            if(a[k] != null)
            {
                hm hm2 = new hm();
                hm2.a("Slot", (byte)k);
                a[k].a(hm2);
                ki1.a(((el) (hm2)));
            }

        hm1.a("Items", ((el) (ki1)));
    }

    public int e()
    {
        return 64;
    }

    public int a(int k)
    {
        return (d * k) / 200;
    }

    public int b(int k)
    {
        if(c == 0)
            c = 200;
        return (b * k) / c;
    }

    public boolean a()
    {
        return b > 0;
    }

    public void b()
    {
        boolean flag = b > 0;
        boolean flag1 = false;
        if(b > 0)
            b--;
        if(!e.y)
        {
            if(b == 0 && j())
            {
                c = b = a(a[1]);
                if(b > 0)
                {
                    flag1 = true;
                    if(a[1] != null)
                    {
                        a[1].a--;
                        if(a[1].a == 0)
                            a[1] = null;
                    }
                }
            }
            if(a() && j())
            {
                d++;
                if(d == 200)
                {
                    d = 0;
                    i();
                    flag1 = true;
                }
            } else
            {
                d = 0;
            }
            if(flag != (b > 0))
            {
                flag1 = true;
                ku.a(b > 0, e, f, g, h);
            }
        }
        if(flag1)
            j_();
    }

    private boolean j()
    {
        if(a[0] == null)
            return false;
        int k = d(a[0].a().aS);
        if(k < 0)
            return false;
        if(a[2] == null)
            return true;
        if(a[2].c != k)
            return false;
        if(a[2].a < e() && a[2].a < a[2].c())
            return true;
        return a[2].a < di.c[k].b();
    }

    public void i()
    {
        if(!j())
            return;
        int k = d(a[0].a().aS);
        if(a[2] == null)
            a[2] = new ev(k, 1);
        else
        if(a[2].c == k)
            a[2].a++;
        a[0].a--;
        if(a[0].a <= 0)
            a[0] = null;
    }

    private int d(int k)
    {
        if(k == ly.I.bc)
            return di.m.aS;
        if(k == ly.H.bc)
            return di.n.aS;
        if(k == ly.ax.bc)
            return di.l.aS;
        if(k == ly.F.bc)
            return ly.N.bc;
        if(k == di.ao.aS)
            return di.ap.aS;
        if(k == ly.x.bc)
            return ly.u.bc;
        if(k == di.aG.aS)
            return di.aF.aS;
        else
            return -1;
    }

    private int a(ev ev1)
    {
        if(ev1 == null)
            return 0;
        int k = ev1.a().aS;
        if(k < 256 && ly.n[k].bn == gb.c)
            return 300;
        if(k == di.B.aS)
            return 100;
        if(k == di.k.aS)
            return 1600;
        return k != di.aw.aS ? 0 : 20000;
    }

    private ev a[];
    private int b;
    private int c;
    private int d;
}
