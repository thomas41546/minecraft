package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class eu
    implements gh
{

    public eu(dm dm1)
    {
        a = new ev[37];
        b = new ev[4];
        c = new ev[4];
        d = 0;
        f = false;
        g = dm1;
    }

    public ev a()
    {
        return a[d];
    }

    private int f(int k)
    {
        for(int l = 0; l < a.length; l++)
            if(a[l] != null && a[l].c == k)
                return l;

        return -1;
    }

    private int g(int k)
    {
        for(int l = 0; l < a.length; l++)
            if(a[l] != null && a[l].c == k && a[l].a < a[l].c() && a[l].a < e())
                return l;

        return -1;
    }

    private int j()
    {
        for(int k = 0; k < a.length; k++)
            if(a[k] == null)
                return k;

        return -1;
    }

    public void a(int k, boolean flag)
    {
        int l = f(k);
        if(l >= 0 && l < 9)
        {
            d = l;
            return;
        } else
        {
            return;
        }
    }

    public void a(int k)
    {
        if(k > 0)
            k = 1;
        if(k < 0)
            k = -1;
        for(d -= k; d < 0; d += 9);
        for(; d >= 9; d -= 9);
    }

    private int b(int k, int l)
    {
        int i1 = g(k);
        if(i1 < 0)
            i1 = j();
        if(i1 < 0)
            return l;
        if(a[i1] == null)
            a[i1] = new ev(k, 0);
        int j1 = l;
        if(j1 > a[i1].c() - a[i1].a)
            j1 = a[i1].c() - a[i1].a;
        if(j1 > e() - a[i1].a)
            j1 = e() - a[i1].a;
        if(j1 == 0)
        {
            return l;
        } else
        {
            l -= j1;
            a[i1].a += j1;
            a[i1].b = 5;
            return l;
        }
    }

    public void b()
    {
        for(int k = 0; k < a.length; k++)
            if(a[k] != null && a[k].b > 0)
                a[k].b--;

    }

    public boolean b(int k)
    {
        int l = f(k);
        if(l < 0)
            return false;
        if(--a[l].a <= 0)
            a[l] = null;
        return true;
    }

    public boolean a(ev ev1)
    {
        if(ev1.d == 0)
        {
            ev1.a = b(ev1.c, ev1.a);
            if(ev1.a == 0)
                return true;
        }
        int k = j();
        if(k >= 0)
        {
            a[k] = ev1;
            a[k].b = 5;
            return true;
        } else
        {
            return false;
        }
    }

    public ev a(int k, int l)
    {
        ev aev[] = a;
        if(k >= a.length)
        {
            aev = b;
            k -= a.length;
        }
        if(aev[k] != null)
        {
            if(aev[k].a <= l)
            {
                ev ev1 = aev[k];
                aev[k] = null;
                return ev1;
            }
            ev ev2 = aev[k].a(l);
            if(aev[k].a == 0)
                aev[k] = null;
            return ev2;
        } else
        {
            return null;
        }
    }

    public void a(int k, ev ev1)
    {
        ev aev[] = a;
        if(k >= aev.length)
        {
            k -= aev.length;
            aev = b;
        }
        if(k >= aev.length)
        {
            k -= aev.length;
            aev = c;
        }
        aev[k] = ev1;
    }

    public float a(ly ly1)
    {
        float f1 = 1.0F;
        if(a[d] != null)
            f1 *= a[d].a(ly1);
        return f1;
    }

    public ki a(ki ki1)
    {
        for(int k = 0; k < a.length; k++)
            if(a[k] != null)
            {
                hm hm1 = new hm();
                hm1.a("Slot", (byte)k);
                a[k].a(hm1);
                ki1.a(((el) (hm1)));
            }

        for(int l = 0; l < b.length; l++)
            if(b[l] != null)
            {
                hm hm2 = new hm();
                hm2.a("Slot", (byte)(l + 100));
                b[l].a(hm2);
                ki1.a(((el) (hm2)));
            }

        for(int i1 = 0; i1 < c.length; i1++)
            if(c[i1] != null)
            {
                hm hm3 = new hm();
                hm3.a("Slot", (byte)(i1 + 80));
                c[i1].a(hm3);
                ki1.a(((el) (hm3)));
            }

        return ki1;
    }

    public void b(ki ki1)
    {
        a = new ev[36];
        b = new ev[4];
        c = new ev[4];
        for(int k = 0; k < ki1.c(); k++)
        {
            hm hm1 = (hm)ki1.a(k);
            int l = hm1.c("Slot") & 0xff;
            if(l >= 0 && l < a.length)
                a[l] = new ev(hm1);
            if(l >= 80 && l < c.length + 80)
                c[l - 80] = new ev(hm1);
            if(l >= 100 && l < b.length + 100)
                b[l - 100] = new ev(hm1);
        }

    }

    public int c()
    {
        return a.length + 4;
    }

    public ev c(int k)
    {
        ev aev[] = a;
        if(k >= aev.length)
        {
            k -= aev.length;
            aev = b;
        }
        if(k >= aev.length)
        {
            k -= aev.length;
            aev = c;
        }
        return aev[k];
    }

    public String d()
    {
        return "Inventory";
    }

    public int e()
    {
        return 64;
    }

    public int a(kh kh)
    {
        ev ev1 = c(d);
        if(ev1 != null)
            return ev1.a(kh);
        else
            return 1;
    }

    public boolean b(ly ly1)
    {
        if(ly1.bn != gb.d && ly1.bn != gb.e && ly1.bn != gb.t && ly1.bn != gb.s)
            return true;
        ev ev1 = c(d);
        if(ev1 != null)
            return ev1.b(ly1);
        else
            return false;
    }

    public ev d(int k)
    {
        return b[k];
    }

    public int f()
    {
        int k = 0;
        int l = 0;
        int i1 = 0;
        for(int j1 = 0; j1 < b.length; j1++)
            if(b[j1] != null && (b[j1].a() instanceof mr))
            {
                int k1 = b[j1].d();
                int l1 = b[j1].d;
                int i2 = k1 - l1;
                l += i2;
                i1 += k1;
                int j2 = ((mr)b[j1].a()).aY;
                k += j2;
            }

        if(i1 == 0)
            return 0;
        else
            return ((k - 1) * l) / i1 + 1;
    }

    public void e(int k)
    {
        for(int l = 0; l < b.length; l++)
        {
            if(b[l] == null || !(b[l].a() instanceof mr))
                continue;
            b[l].b(k);
            if(b[l].a == 0)
            {
                b[l].a(g);
                b[l] = null;
            }
        }

    }

    public void g()
    {
        for(int k = 0; k < a.length; k++)
            if(a[k] != null)
            {
                g.a(a[k], true);
                a[k] = null;
            }

        for(int l = 0; l < b.length; l++)
            if(b[l] != null)
            {
                g.a(b[l], true);
                b[l] = null;
            }

    }

    public void j_()
    {
        f = true;
    }

    public boolean a(eu eu1)
    {
        for(int k = 0; k < a.length; k++)
            if(!a(eu1.a[k], a[k]))
                return false;

        for(int l = 0; l < b.length; l++)
            if(!a(eu1.b[l], b[l]))
                return false;

        for(int i1 = 0; i1 < c.length; i1++)
            if(!a(eu1.c[i1], c[i1]))
                return false;

        return true;
    }

    private boolean a(ev ev1, ev ev2)
    {
        if(ev1 == null && ev2 == null)
            return true;
        if(ev1 == null || ev2 == null)
            return false;
        else
            return ev1.c == ev2.c && ev1.a == ev2.a && ev1.d == ev2.d;
    }

    public eu i()
    {
        eu eu1 = new eu(((dm) (null)));
        for(int k = 0; k < a.length; k++)
            eu1.a[k] = a[k] == null ? null : a[k].e();

        for(int l = 0; l < b.length; l++)
            eu1.b[l] = b[l] == null ? null : b[l].e();

        for(int i1 = 0; i1 < c.length; i1++)
            eu1.c[i1] = c[i1] == null ? null : c[i1].e();

        return eu1;
    }

    public ev a[];
    public ev b[];
    public ev c[];
    public int d;
    private dm g;
    public ev e;
    public boolean f;
}
