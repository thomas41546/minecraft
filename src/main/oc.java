package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import java.util.Random;

public class oc extends kh
    implements gh
{

    public oc(cn cn1)
    {
        super(cn1);
        h = new ev[36];
        a = 0;
        b = 0;
        c = 1;
        i = false;
        ad = true;
        a(0.98F, 0.7F);
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

    public oc(cn cn1, double d1, double d2, double d3, 
            int i1)
    {
        this(cn1);
        a(d1, d2 + (double)aB, d3);
        an = 0.0D;
        ao = 0.0D;
        ap = 0.0D;
        ah = d1;
        ai = d2;
        aj = d3;
        d = i1;
    }

    public double h()
    {
        return (double)aD * 0.0D - 0.30000001192092896D;
    }

    public boolean a(kh kh1, int i1)
    {
        c = -c;
        b = 10;
        a += i1 * 10;
        if(a > 40)
        {
            a(di.ax.aS, 1, 0.0F);
            if(d == 1)
                a(ly.av.bc, 1, 0.0F);
            else
            if(d == 2)
                a(ly.aC.bc, 1, 0.0F);
            F();
        }
        return true;
    }

    public boolean c_()
    {
        return !aA;
    }

    public void F()
    {
label0:
        for(int i1 = 0; i1 < c(); i1++)
        {
            ev ev1 = c(i1);
            if(ev1 == null)
                continue;
            float f1 = aQ.nextFloat() * 0.8F + 0.1F;
            float f2 = aQ.nextFloat() * 0.8F + 0.1F;
            float f3 = aQ.nextFloat() * 0.8F + 0.1F;
            do
            {
                if(ev1.a <= 0)
                    continue label0;
                int j1 = aQ.nextInt(21) + 10;
                if(j1 > ev1.a)
                    j1 = ev1.a;
                ev1.a -= j1;
                dx dx1 = new dx(ag, ak + (double)f1, al + (double)f2, am + (double)f3, new ev(ev1.c, j1, ev1.d));
                float f4 = 0.05F;
                dx1.an = (float)aQ.nextGaussian() * f4;
                dx1.ao = (float)aQ.nextGaussian() * f4 + 0.2F;
                dx1.ap = (float)aQ.nextGaussian() * f4;
                ag.a(((kh) (dx1)));
            } while(true);
        }

        super.F();
    }

    public void e_()
    {
        if(ag.y)
        {
            if(k > 0)
            {
                double d1 = ak + (l - ak) / (double)k;
                double d2 = al + (m - al) / (double)k;
                double d4 = am + (n - am) / (double)k;
                double d5;
                for(d5 = o - (double)aq; d5 < -180D; d5 += 360D);
                for(; d5 >= 180D; d5 -= 360D);
                aq += ((float) (d5 / (double)k));
                ar += ((float) ((p - (double)ar) / (double)k));
                k--;
                a(d1, d2, d4);
                c(aq, ar);
            } else
            {
                a(ak, al, am);
                c(aq, ar);
            }
            return;
        }
        if(b > 0)
            b--;
        if(a > 0)
            a--;
        ah = ak;
        this.ai = al;
        aj = am;
        ao -= 0.039999999105930328D;
        int i1 = eo.b(ak);
        int j1 = eo.b(al);
        int k1 = eo.b(am);
        if(ag.a(i1, j1 - 1, k1) == ly.aH.bc)
            j1--;
        double d3 = 0.40000000000000002D;
        boolean flag = false;
        double d6 = 0.0078125D;
        if(ag.a(i1, j1, k1) == ly.aH.bc)
        {
            aj aj1 = g(ak, al, am);
            int l1 = ag.e(i1, j1, k1);
            al = j1;
            if(l1 >= 2 && l1 <= 5)
                al = j1 + 1;
            if(l1 == 2)
                an -= d6;
            if(l1 == 3)
                an += d6;
            if(l1 == 4)
                ap += d6;
            if(l1 == 5)
                ap -= d6;
            int ai[][] = j[l1];
            double d9 = ai[1][0] - ai[0][0];
            double d11 = ai[1][2] - ai[0][2];
            double d12 = Math.sqrt(d9 * d9 + d11 * d11);
            double d13 = an * d9 + ap * d11;
            if(d13 < 0.0D)
            {
                d9 = -d9;
                d11 = -d11;
            }
            double d14 = Math.sqrt(an * an + ap * ap);
            an = (d14 * d9) / d12;
            ap = (d14 * d11) / d12;
            double d17 = 0.0D;
            double d18 = (double)i1 + 0.5D + (double)ai[0][0] * 0.5D;
            double d19 = (double)k1 + 0.5D + (double)ai[0][2] * 0.5D;
            double d20 = (double)i1 + 0.5D + (double)ai[1][0] * 0.5D;
            double d21 = (double)k1 + 0.5D + (double)ai[1][2] * 0.5D;
            d9 = d20 - d18;
            d11 = d21 - d19;
            if(d9 == 0.0D)
            {
                ak = (double)i1 + 0.5D;
                d17 = am - (double)k1;
            } else
            if(d11 == 0.0D)
            {
                am = (double)k1 + 0.5D;
                d17 = ak - (double)i1;
            } else
            {
                double d22 = ak - d18;
                double d24 = am - d19;
                double d26 = (d22 * d9 + d24 * d11) * 2D;
                d17 = d26;
            }
            ak = d18 + d9 * d17;
            am = d19 + d11 * d17;
            a(ak, al + (double)aB, am);
            double d23 = an;
            double d25 = ap;
            if(ae != null)
            {
                d23 *= 0.75D;
                d25 *= 0.75D;
            }
            if(d23 < -d3)
                d23 = -d3;
            if(d23 > d3)
                d23 = d3;
            if(d25 < -d3)
                d25 = -d3;
            if(d25 > d3)
                d25 = d3;
            c(d23, 0.0D, d25);
            if(ai[0][1] != 0 && eo.b(ak) - i1 == ai[0][0] && eo.b(am) - k1 == ai[0][2])
                a(ak, al + (double)ai[0][1], am);
            else
            if(ai[1][1] != 0 && eo.b(ak) - i1 == ai[1][0] && eo.b(am) - k1 == ai[1][2])
                a(ak, al + (double)ai[1][1], am);
            if(ae != null)
            {
                an *= 0.99699997901916504D;
                ao *= 0.0D;
                ap *= 0.99699997901916504D;
            } else
            {
                if(d == 2)
                {
                    double d27 = eo.a(f * f + g * g);
                    if(d27 > 0.01D)
                    {
                        flag = true;
                        f /= d27;
                        g /= d27;
                        double d29 = 0.040000000000000001D;
                        an *= 0.80000001192092896D;
                        ao *= 0.0D;
                        ap *= 0.80000001192092896D;
                        an += f * d29;
                        ap += g * d29;
                    } else
                    {
                        an *= 0.89999997615814209D;
                        ao *= 0.0D;
                        ap *= 0.89999997615814209D;
                    }
                }
                an *= 0.95999997854232788D;
                ao *= 0.0D;
                ap *= 0.95999997854232788D;
            }
            aj aj2 = g(ak, al, am);
            if(aj2 != null && aj1 != null)
            {
                double d28 = (aj1.b - aj2.b) * 0.050000000000000003D;
                double d15 = Math.sqrt(an * an + ap * ap);
                if(d15 > 0.0D)
                {
                    an = (an / d15) * (d15 + d28);
                    ap = (ap / d15) * (d15 + d28);
                }
                a(ak, aj2.b, am);
            }
            int j2 = eo.b(ak);
            int k2 = eo.b(am);
            if(j2 != i1 || k2 != k1)
            {
                double d16 = Math.sqrt(an * an + ap * ap);
                an = d16 * (double)(j2 - i1);
                ap = d16 * (double)(k2 - k1);
            }
            if(d == 2)
            {
                double d30 = eo.a(f * f + g * g);
                if(d30 > 0.01D && an * an + ap * ap > 0.001D)
                {
                    f /= d30;
                    g /= d30;
                    if(f * an + g * ap < 0.0D)
                    {
                        f = 0.0D;
                        g = 0.0D;
                    } else
                    {
                        f = an;
                        g = ap;
                    }
                }
            }
        } else
        {
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
            if(!av)
            {
                an *= 0.94999998807907104D;
                ao *= 0.94999998807907104D;
                ap *= 0.94999998807907104D;
            }
        }
        ar = 0.0F;
        double d7 = ah - ak;
        double d8 = aj - am;
        if(d7 * d7 + d8 * d8 > 0.001D)
        {
            aq = (float)((Math.atan2(d8, d7) * 180D) / 3.1415926535897931D);
            if(i)
                aq += 180F;
        }
        double d10;
        for(d10 = aq - as; d10 >= 180D; d10 -= 360D);
        for(; d10 < -180D; d10 += 360D);
        if(d10 < -170D || d10 >= 170D)
        {
            aq += 180F;
            i = !i;
        }
        c(aq, ar);
        List list = ag.b(((kh) (this)), au.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        if(list != null && list.size() > 0)
        {
            for(int i2 = 0; i2 < list.size(); i2++)
            {
                kh kh1 = (kh)list.get(i2);
                if(kh1 != ae && kh1.d_() && (kh1 instanceof oc))
                    kh1.f(((kh) (this)));
            }

        }
        if(ae != null && ae.aA)
            ae = null;
        if(flag && aQ.nextInt(4) == 0)
        {
            e--;
            if(e < 0)
                f = g = 0.0D;
            ag.a("largesmoke", ak, al + 0.80000000000000004D, am, 0.0D, 0.0D, 0.0D);
        }
    }

    public aj a(double d1, double d2, double d3, double d4)
    {
        int i1 = eo.b(d1);
        int j1 = eo.b(d2);
        int k1 = eo.b(d3);
        if(ag.a(i1, j1 - 1, k1) == ly.aH.bc)
            j1--;
        if(ag.a(i1, j1, k1) == ly.aH.bc)
        {
            int l1 = ag.e(i1, j1, k1);
            d2 = j1;
            if(l1 >= 2 && l1 <= 5)
                d2 = j1 + 1;
            int ai[][] = j[l1];
            double d5 = ai[1][0] - ai[0][0];
            double d6 = ai[1][2] - ai[0][2];
            double d7 = Math.sqrt(d5 * d5 + d6 * d6);
            d5 /= d7;
            d6 /= d7;
            d1 += d5 * d4;
            d3 += d6 * d4;
            if(ai[0][1] != 0 && eo.b(d1) - i1 == ai[0][0] && eo.b(d3) - k1 == ai[0][2])
                d2 += ai[0][1];
            else
            if(ai[1][1] != 0 && eo.b(d1) - i1 == ai[1][0] && eo.b(d3) - k1 == ai[1][2])
                d2 += ai[1][1];
            return g(d1, d2, d3);
        } else
        {
            return null;
        }
    }

    public aj g(double d1, double d2, double d3)
    {
        int i1 = eo.b(d1);
        int j1 = eo.b(d2);
        int k1 = eo.b(d3);
        if(ag.a(i1, j1 - 1, k1) == ly.aH.bc)
            j1--;
        if(ag.a(i1, j1, k1) == ly.aH.bc)
        {
            int l1 = ag.e(i1, j1, k1);
            d2 = j1;
            if(l1 >= 2 && l1 <= 5)
                d2 = j1 + 1;
            int ai[][] = j[l1];
            double d4 = 0.0D;
            double d5 = (double)i1 + 0.5D + (double)ai[0][0] * 0.5D;
            double d6 = (double)j1 + 0.5D + (double)ai[0][1] * 0.5D;
            double d7 = (double)k1 + 0.5D + (double)ai[0][2] * 0.5D;
            double d8 = (double)i1 + 0.5D + (double)ai[1][0] * 0.5D;
            double d9 = (double)j1 + 0.5D + (double)ai[1][1] * 0.5D;
            double d10 = (double)k1 + 0.5D + (double)ai[1][2] * 0.5D;
            double d11 = d8 - d5;
            double d12 = (d9 - d6) * 2D;
            double d13 = d10 - d7;
            if(d11 == 0.0D)
            {
                d1 = (double)i1 + 0.5D;
                d4 = d3 - (double)k1;
            } else
            if(d13 == 0.0D)
            {
                d3 = (double)k1 + 0.5D;
                d4 = d1 - (double)i1;
            } else
            {
                double d14 = d1 - d5;
                double d15 = d3 - d7;
                double d16 = (d14 * d11 + d15 * d13) * 2D;
                d4 = d16;
            }
            d1 = d5 + d11 * d4;
            d2 = d6 + d12 * d4;
            d3 = d7 + d13 * d4;
            if(d12 < 0.0D)
                d2++;
            if(d12 > 0.0D)
                d2 += 0.5D;
            return aj.b(d1, d2, d3);
        } else
        {
            return null;
        }
    }

    protected void a(hm hm1)
    {
        hm1.a("Type", d);
        if(d == 2)
        {
            hm1.a("PushX", f);
            hm1.a("PushZ", g);
            hm1.a("Fuel", (short)e);
        } else
        if(d == 1)
        {
            ki ki1 = new ki();
            for(int i1 = 0; i1 < h.length; i1++)
                if(h[i1] != null)
                {
                    hm hm2 = new hm();
                    hm2.a("Slot", (byte)i1);
                    h[i1].a(hm2);
                    ki1.a(((el) (hm2)));
                }

            hm1.a("Items", ((el) (ki1)));
        }
    }

    protected void b(hm hm1)
    {
        d = hm1.e("Type");
        if(d == 2)
        {
            f = hm1.h("PushX");
            g = hm1.h("PushZ");
            e = ((int) (hm1.d("Fuel")));
        } else
        if(d == 1)
        {
            ki ki1 = hm1.l("Items");
            h = new ev[c()];
            for(int i1 = 0; i1 < ki1.c(); i1++)
            {
                hm hm2 = (hm)ki1.a(i1);
                int j1 = hm2.c("Slot") & 0xff;
                if(j1 >= 0 && j1 < h.length)
                    h[j1] = new ev(hm2);
            }

        }
    }

    public float h_()
    {
        return 0.0F;
    }

    public void f(kh kh1)
    {
        if(kh1 == ae)
            return;
        if((kh1 instanceof ge) && !(kh1 instanceof dm) && d == 0 && an * an + ap * ap > 0.01D && ae == null && kh1.af == null)
            kh1.g(((kh) (this)));
        double d1 = kh1.ak - ak;
        double d2 = kh1.am - am;
        double d3 = d1 * d1 + d2 * d2;
        if(d3 >= 9.9999997473787516E-005D)
        {
            d3 = eo.a(d3);
            d1 /= d3;
            d2 /= d3;
            double d4 = 1.0D / d3;
            if(d4 > 1.0D)
                d4 = 1.0D;
            d1 *= d4;
            d2 *= d4;
            d1 *= 0.10000000149011612D;
            d2 *= 0.10000000149011612D;
            d1 *= 1.0F - aO;
            d2 *= 1.0F - aO;
            d1 *= 0.5D;
            d2 *= 0.5D;
            if(kh1 instanceof oc)
            {
                double d5 = kh1.an + an;
                double d6 = kh1.ap + ap;
                if(((oc)kh1).d == 2 && d != 2)
                {
                    an *= 0.20000000298023224D;
                    ap *= 0.20000000298023224D;
                    f(kh1.an - d1, 0.0D, kh1.ap - d2);
                    kh1.an *= 0.69999998807907104D;
                    kh1.ap *= 0.69999998807907104D;
                } else
                if(((oc)kh1).d != 2 && d == 2)
                {
                    kh1.an *= 0.20000000298023224D;
                    kh1.ap *= 0.20000000298023224D;
                    kh1.f(an + d1, 0.0D, ap + d2);
                    an *= 0.69999998807907104D;
                    ap *= 0.69999998807907104D;
                } else
                {
                    d5 /= 2D;
                    d6 /= 2D;
                    an *= 0.20000000298023224D;
                    ap *= 0.20000000298023224D;
                    f(d5 - d1, 0.0D, d6 - d2);
                    kh1.an *= 0.20000000298023224D;
                    kh1.ap *= 0.20000000298023224D;
                    kh1.f(d5 + d1, 0.0D, d6 + d2);
                }
            } else
            {
                f(-d1, 0.0D, -d2);
                kh1.f(d1 / 4D, 0.0D, d2 / 4D);
            }
        }
    }

    public int c()
    {
        return 27;
    }

    public ev c(int i1)
    {
        return h[i1];
    }

    public ev a(int i1, int j1)
    {
        if(h[i1] != null)
        {
            if(h[i1].a <= j1)
            {
                ev ev1 = h[i1];
                h[i1] = null;
                return ev1;
            }
            ev ev2 = h[i1].a(j1);
            if(h[i1].a == 0)
                h[i1] = null;
            return ev2;
        } else
        {
            return null;
        }
    }

    public void a(int i1, ev ev1)
    {
        h[i1] = ev1;
        if(ev1 != null && ev1.a > e())
            ev1.a = e();
    }

    public String d()
    {
        return "Minecart";
    }

    public int e()
    {
        return 64;
    }

    public void j_()
    {
    }

    public boolean a(dm dm1)
    {
        if(d == 0)
            dm1.g(((kh) (this)));
        else
        if(d == 1)
            dm1.a(((gh) (this)));
        else
        if(d == 2)
        {
            ev ev1 = dm1.b.a();
            if(ev1 != null && ev1.c == di.k.aS)
            {
                if(--ev1.a == 0)
                    dm1.b.a(dm1.b.d, ((ev) (null)));
                e += 1200;
            }
            f = ak - dm1.ak;
            g = am - dm1.am;
        }
        return true;
    }

    public void a(double d1, double d2, double d3, float f1, 
            float f2, int i1)
    {
        l = d1;
        m = d2;
        n = d3;
        o = f1;
        p = f2;
        k = i1;
    }

    private ev h[];
    public int a;
    public int b;
    public int c;
    private boolean i;
    public int d;
    public int e;
    public double f;
    public double g;
    private static final int j[][][] = {
        {
            {
                0, 0, -1
            }, {
                0, 0, 1
            }
        }, {
            {
                -1, 0, 0
            }, {
                1, 0, 0
            }
        }, {
            {
                -1, -1, 0
            }, {
                1, 0, 0
            }
        }, {
            {
                -1, 0, 0
            }, {
                1, -1, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                0, -1, 1
            }
        }, {
            {
                0, -1, -1
            }, {
                0, 0, 1
            }
        }, {
            {
                0, 0, 1
            }, {
                1, 0, 0
            }
        }, {
            {
                0, 0, 1
            }, {
                -1, 0, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                -1, 0, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                1, 0, 0
            }
        }
    };
    private int k;
    private double l;
    private double m;
    private double n;
    private double o;
    private double p;

}
