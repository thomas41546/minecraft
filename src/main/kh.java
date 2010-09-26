package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import java.util.Random;

public abstract class kh
{

    public kh(cn cn1)
    {
        ab = a++;
        ac = 1.0D;
        ad = false;
        av = false;
        ay = false;
        az = true;
        aA = false;
        aB = 0.0F;
        aC = 0.6F;
        aD = 1.8F;
        aE = 0.0F;
        aF = 0.0F;
        aG = true;
        aH = 0.0F;
        b = 1;
        aL = 0.0F;
        aM = 0.0F;
        aN = false;
        aO = 0.0F;
        aP = false;
        aQ = new Random();
        aR = 0;
        aS = 1;
        aT = 0;
        aU = 300;
        aV = false;
        aW = 0;
        aX = 300;
        c = true;
        aZ = false;
        ag = cn1;
        a(0.0D, 0.0D, 0.0D);
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof kh)
            return ((kh)obj).ab == ab;
        else
            return false;
    }

    public int hashCode()
    {
        return ab;
    }

    protected void q()
    {
        if(ag == null)
            return;
        do
        {
            if(al <= 0.0D)
                break;
            a(ak, al, am);
            if(ag.a(this, au).size() == 0)
                break;
            al++;
        } while(true);
        an = ao = ap = 0.0D;
        ar = 0.0F;
    }

    public void F()
    {
        aA = true;
    }

    protected void a(float f1, float f2)
    {
        aC = f1;
        aD = f2;
    }

    protected void c(float f1, float f2)
    {
        aq = f1;
        ar = f2;
    }

    public void a(double d1, double d2, double d3)
    {
        ak = d1;
        al = d2;
        am = d3;
        float f1 = aC / 2.0F;
        float f2 = aD;
        au.c(d1 - (double)f1, (d2 - (double)aB) + (double)aL, d3 - (double)f1, d1 + (double)f1, (d2 - (double)aB) + (double)aL + (double)f2, d3 + (double)f1);
    }

    public void d(float f1, float f2)
    {
        float f3 = ar;
        float f4 = aq;
        aq += ((float) ((double)f1 * 0.14999999999999999D));
        ar -= ((float) ((double)f2 * 0.14999999999999999D));
        if(ar < -90F)
            ar = -90F;
        if(ar > 90F)
            ar = 90F;
        at += ar - f3;
        as += aq - f4;
    }

    public void e_()
    {
        y();
    }

    public void y()
    {
        if(af != null && af.aA)
            af = null;
        aR++;
        aE = aF;
        ah = ak;
        ai = al;
        aj = am;
        at = ar;
        as = aq;
        if(g_())
        {
            if(!aV && !c)
            {
                float f1 = eo.a(an * an * 0.20000000298023224D + ao * ao + ap * ap * 0.20000000298023224D) * 0.2F;
                if(f1 > 1.0F)
                    f1 = 1.0F;
                ag.a(this, "random.splash", f1, 1.0F + (aQ.nextFloat() - aQ.nextFloat()) * 0.4F);
                float f2 = eo.b(au.b);
                for(int i = 0; (float)i < 1.0F + aC * 20F; i++)
                {
                    float f3 = (aQ.nextFloat() * 2.0F - 1.0F) * aC;
                    float f5 = (aQ.nextFloat() * 2.0F - 1.0F) * aC;
                    ag.a("bubble", ak + (double)f3, f2 + 1.0F, am + (double)f5, an, ao - (double)(aQ.nextFloat() * 0.2F), ap);
                }

                for(int j = 0; (float)j < 1.0F + aC * 20F; j++)
                {
                    float f4 = (aQ.nextFloat() * 2.0F - 1.0F) * aC;
                    float f6 = (aQ.nextFloat() * 2.0F - 1.0F) * aC;
                    ag.a("splash", ak + (double)f4, f2 + 1.0F, am + (double)f6, an, ao, ap);
                }

            }
            aH = 0.0F;
            aV = true;
            aT = 0;
        } else
        {
            aV = false;
        }
        if(aT > 0)
        {
            if(aT % 20 == 0)
                a(((kh) (null)), 1);
            aT--;
        }
        if(G())
        {
            a(((kh) (null)), 10);
            aT = 600;
        }
        if(al < -64D)
            E();
        c = false;
    }

    protected void E()
    {
        F();
    }

    public boolean b(double d1, double d2, double d3)
    {
        cf cf1 = au.c(d1, d2, d3);
        List list = ag.a(this, cf1);
        if(list.size() > 0)
            return false;
        return !ag.b(cf1);
    }

    public void c(double d1, double d2, double d3)
    {
        if(aN)
        {
            au.d(d1, d2, d3);
            ak = (au.a + au.d) / 2D;
            al = (au.b + (double)aB) - (double)aL;
            am = (au.c + au.f) / 2D;
            return;
        }
        double d4 = ak;
        double d5 = am;
        double d6 = d1;
        double d7 = d2;
        double d8 = d3;
        cf cf1 = au.c();
        boolean flag = av && o();
        if(flag)
        {
            double d9 = 0.050000000000000003D;
            for(; d1 != 0.0D && ag.a(this, au.c(d1, -1D, 0.0D)).size() == 0; d6 = d1)
            {
                if(d1 < d9 && d1 >= -d9)
                {
                    d1 = 0.0D;
                    continue;
                }
                if(d1 > 0.0D)
                    d1 -= d9;
                else
                    d1 += d9;
            }

            for(; d3 != 0.0D && ag.a(this, au.c(0.0D, -1D, d3)).size() == 0; d8 = d3)
            {
                if(d3 < d9 && d3 >= -d9)
                {
                    d3 = 0.0D;
                    continue;
                }
                if(d3 > 0.0D)
                    d3 -= d9;
                else
                    d3 += d9;
            }

        }
        List list = ag.a(this, au.a(d1, d2, d3));
        for(int i = 0; i < list.size(); i++)
            d2 = ((cf)list.get(i)).b(au, d2);

        au.d(0.0D, d2, 0.0D);
        if(!az && d7 != d2)
            d1 = d2 = d3 = 0.0D;
        boolean flag1 = av || d7 != d2 && d7 < 0.0D;
        for(int j = 0; j < list.size(); j++)
            d1 = ((cf)list.get(j)).a(au, d1);

        au.d(d1, 0.0D, 0.0D);
        if(!az && d6 != d1)
            d1 = d2 = d3 = 0.0D;
        for(int k = 0; k < list.size(); k++)
            d3 = ((cf)list.get(k)).c(au, d3);

        au.d(0.0D, 0.0D, d3);
        if(!az && d8 != d3)
            d1 = d2 = d3 = 0.0D;
        if(aM > 0.0F && flag1 && aL < 0.05F && (d6 != d1 || d8 != d3))
        {
            double d10 = d1;
            double d12 = d2;
            double d14 = d3;
            d1 = d6;
            d2 = aM;
            d3 = d8;
            cf cf2 = au.c();
            au.b(cf1);
            List list1 = ag.a(this, au.a(d1, d2, d3));
            for(int j2 = 0; j2 < list1.size(); j2++)
                d2 = ((cf)list1.get(j2)).b(au, d2);

            au.d(0.0D, d2, 0.0D);
            if(!az && d7 != d2)
                d1 = d2 = d3 = 0.0D;
            for(int k2 = 0; k2 < list1.size(); k2++)
                d1 = ((cf)list1.get(k2)).a(au, d1);

            au.d(d1, 0.0D, 0.0D);
            if(!az && d6 != d1)
                d1 = d2 = d3 = 0.0D;
            for(int l2 = 0; l2 < list1.size(); l2++)
                d3 = ((cf)list1.get(l2)).c(au, d3);

            au.d(0.0D, 0.0D, d3);
            if(!az && d8 != d3)
                d1 = d2 = d3 = 0.0D;
            if(d10 * d10 + d14 * d14 >= d1 * d1 + d3 * d3)
            {
                d1 = d10;
                d2 = d12;
                d3 = d14;
                au.b(cf2);
            } else
            {
                aL += 0.5D;
            }
        }
        ak = (au.a + au.d) / 2D;
        al = (au.b + (double)aB) - (double)aL;
        am = (au.c + au.f) / 2D;
        aw = d6 != d1 || d8 != d3;
        ax = d7 != d2;
        av = d7 != d2 && d7 < 0.0D;
        ay = aw || ax;
        if(av)
        {
            if(aH > 0.0F)
            {
                c(aH);
                aH = 0.0F;
            }
        } else
        if(d2 < 0.0D)
            aH -= ((float) (d2));
        if(d6 != d1)
            an = 0.0D;
        if(d7 != d2)
            ao = 0.0D;
        if(d8 != d3)
            ap = 0.0D;
        double d11 = ak - d4;
        double d13 = am - d5;
        aF += ((float) ((double)eo.a(d11 * d11 + d13 * d13) * 0.59999999999999998D));
        if(aG && !flag)
        {
            int l = eo.b(ak);
            int j1 = eo.b(al - 0.20000000298023224D - (double)aB);
            int l1 = eo.b(am);
            int i3 = ag.a(l, j1, l1);
            if(aF > (float)b && i3 > 0)
            {
                b++;
                bb bb1 = ly.n[i3].bl;
                if(ag.a(l, j1 + 1, l1) == ly.aT.bc)
                {
                    bb1 = ly.aT.bl;
                    ag.a(this, bb1.d(), bb1.b() * 0.15F, bb1.c());
                } else
                if(!ly.n[i3].bn.d())
                    ag.a(this, bb1.d(), bb1.b() * 0.15F, bb1.c());
                ly.n[i3].a(ag, l, j1, l1, this);
            }
        }
        int i1 = eo.b(au.a);
        int k1 = eo.b(au.b);
        int i2 = eo.b(au.c);
        int j3 = eo.b(au.d);
        int k3 = eo.b(au.e);
        int l3 = eo.b(au.f);
        for(int i4 = i1; i4 <= j3; i4++)
        {
            for(int j4 = k1; j4 <= k3; j4++)
            {
                for(int k4 = i2; k4 <= l3; k4++)
                {
                    int l4 = ag.a(i4, j4, k4);
                    if(l4 > 0)
                        ly.n[l4].b(ag, i4, j4, k4, this);
                }

            }

        }

        aL *= 0.4F;
        boolean flag2 = g_();
        if(ag.c(au))
        {
            a(1);
            if(!flag2)
            {
                aT++;
                if(aT == 0)
                    aT = 300;
            }
        } else
        if(aT <= 0)
            aT = -aS;
        if(flag2 && aT > 0)
        {
            ag.a(this, "random.fizz", 0.7F, 1.6F + (aQ.nextFloat() - aQ.nextFloat()) * 0.4F);
            aT = -aS;
        }
    }

    public boolean o()
    {
        return false;
    }

    public cf f_()
    {
        return null;
    }

    protected void a(int i)
    {
        a(((kh) (null)), i);
    }

    protected void c(float f1)
    {
    }

    public boolean g_()
    {
        return ag.a(au.b(0.0D, -0.40000000596046448D, 0.0D), gb.f, this);
    }

    public boolean a(gb gb1)
    {
        double d1 = al + (double)s();
        int i = eo.b(ak);
        int j = eo.d(eo.b(d1));
        int k = eo.b(am);
        int l = ag.a(i, j, k);
        if(l != 0 && ly.n[l].bn == gb1)
        {
            float f1 = jp.b(ag.e(i, j, k)) - 0.1111111F;
            float f2 = (float)(j + 1) - f1;
            return d1 < (double)f2;
        } else
        {
            return false;
        }
    }

    protected float s()
    {
        return 0.0F;
    }

    public boolean G()
    {
        return ag.a(au.b(0.0D, -0.40000000596046448D, 0.0D), gb.g);
    }

    public void a(float f1, float f2, float f3)
    {
        float f4 = eo.c(f1 * f1 + f2 * f2);
        if(f4 < 0.01F)
            return;
        if(f4 < 1.0F)
            f4 = 1.0F;
        f4 = f3 / f4;
        f1 *= f4;
        f2 *= f4;
        float f5 = eo.a((aq * 3.141593F) / 180F);
        float f6 = eo.b((aq * 3.141593F) / 180F);
        an += f1 * f6 - f2 * f5;
        ap += f2 * f6 + f1 * f5;
    }

    public float a(float f1)
    {
        int i = eo.b(ak);
        double d1 = (au.e - au.b) * 0.66000000000000003D;
        int j = eo.b((al - (double)aB) + d1);
        int k = eo.b(am);
        return ag.c(i, j, k);
    }

    public void a(cn cn1)
    {
        ag = cn1;
    }

    public void b(double d1, double d2, double d3, float f1, 
            float f2)
    {
        ah = ak = d1;
        ai = al = d2;
        aj = am = d3;
        aq = f1;
        ar = f2;
        aL = 0.0F;
        double d4 = as - f1;
        if(d4 < -180D)
            as += 360F;
        if(d4 >= 180D)
            as -= 360F;
        a(ak, al, am);
    }

    public void c(double d1, double d2, double d3, float f1, 
            float f2)
    {
        ah = ak = d1;
        ai = al = d2 + (double)aB;
        aj = am = d3;
        aq = f1;
        ar = f2;
        a(ak, al, am);
    }

    public float d(kh kh1)
    {
        float f1 = (float)(ak - kh1.ak);
        float f2 = (float)(al - kh1.al);
        float f3 = (float)(am - kh1.am);
        return eo.c(f1 * f1 + f2 * f2 + f3 * f3);
    }

    public double d(double d1, double d2, double d3)
    {
        double d4 = ak - d1;
        double d5 = al - d2;
        double d6 = am - d3;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double e(double d1, double d2, double d3)
    {
        double d4 = ak - d1;
        double d5 = al - d2;
        double d6 = am - d3;
        return (double)eo.a(d4 * d4 + d5 * d5 + d6 * d6);
    }

    public double e(kh kh1)
    {
        double d1 = ak - kh1.ak;
        double d2 = al - kh1.al;
        double d3 = am - kh1.am;
        return d1 * d1 + d2 * d2 + d3 * d3;
    }

    public void b(dm dm)
    {
    }

    public void f(kh kh1)
    {
        if(kh1.ae == this || kh1.af == this)
            return;
        double d1 = kh1.ak - ak;
        double d2 = kh1.am - am;
        double d3 = eo.a(d1, d2);
        if(d3 >= 0.0099999997764825821D)
        {
            d3 = eo.a(d3);
            d1 /= d3;
            d2 /= d3;
            double d4 = 1.0D / d3;
            if(d4 > 1.0D)
                d4 = 1.0D;
            d1 *= d4;
            d2 *= d4;
            d1 *= 0.05000000074505806D;
            d2 *= 0.05000000074505806D;
            d1 *= 1.0F - aO;
            d2 *= 1.0F - aO;
            f(-d1, 0.0D, -d2);
            kh1.f(d1, 0.0D, d2);
        }
    }

    public void f(double d1, double d2, double d3)
    {
        an += d1;
        ao += d2;
        ap += d3;
    }

    public boolean a(kh kh1, int i)
    {
        return false;
    }

    public boolean c_()
    {
        return false;
    }

    public boolean d_()
    {
        return false;
    }

    public void b(kh kh1, int i)
    {
    }

    public boolean a(aj aj1)
    {
        double d1 = ak - aj1.a;
        double d2 = al - aj1.b;
        double d3 = am - aj1.c;
        double d4 = d1 * d1 + d2 * d2 + d3 * d3;
        return a(d4);
    }

    public boolean a(double d1)
    {
        double d2 = au.b();
        d2 *= 64D * ac;
        return d1 < d2 * d2;
    }

    public String x()
    {
        return null;
    }

    public boolean c(hm hm1)
    {
        String s1 = H();
        if(aA || s1 == null)
        {
            return false;
        } else
        {
            hm1.a("id", s1);
            d(hm1);
            return true;
        }
    }

    public void d(hm hm1)
    {
        hm1.a("Pos", ((el) (a(new double[] {
            ak, al, am
        }))));
        hm1.a("Motion", ((el) (a(new double[] {
            an, ao, ap
        }))));
        hm1.a("Rotation", ((el) (a(new float[] {
            aq, ar
        }))));
        hm1.a("FallDistance", aH);
        hm1.a("Fire", (short)aT);
        hm1.a("Air", (short)aX);
        hm1.a("OnGround", av);
        a(hm1);
    }

    public void e(hm hm1)
    {
        ki ki1 = hm1.l("Pos");
        ki ki2 = hm1.l("Motion");
        ki ki3 = hm1.l("Rotation");
        a(0.0D, 0.0D, 0.0D);
        an = ((kr)ki2.a(0)).a;
        ao = ((kr)ki2.a(1)).a;
        ap = ((kr)ki2.a(2)).a;
        ah = aI = ak = ((kr)ki1.a(0)).a;
        ai = aJ = al = ((kr)ki1.a(1)).a;
        aj = aK = am = ((kr)ki1.a(2)).a;
        as = aq = ((f)ki3.a(0)).a;
        at = ar = ((f)ki3.a(1)).a;
        aH = hm1.g("FallDistance");
        aT = ((int) (hm1.d("Fire")));
        aX = ((int) (hm1.d("Air")));
        av = hm1.m("OnGround");
        a(ak, al, am);
        b(hm1);
    }

    protected final String H()
    {
        return ew.b(this);
    }

    protected abstract void b(hm hm1);

    protected abstract void a(hm hm1);

    protected transient ki a(double ad1[])
    {
        ki ki1 = new ki();
        double ad2[] = ad1;
        int i = ad2.length;
        for(int j = 0; j < i; j++)
        {
            double d1 = ad2[j];
            ki1.a(((el) (new kr(d1))));
        }

        return ki1;
    }

    protected transient ki a(float af1[])
    {
        ki ki1 = new ki();
        float af2[] = af1;
        int i = af2.length;
        for(int j = 0; j < i; j++)
        {
            float f1 = af2[j];
            ki1.a(((el) (new f(f1))));
        }

        return ki1;
    }

    public float h_()
    {
        return aD / 2.0F;
    }

    public dx b(int i, int j)
    {
        return a(i, j, 0.0F);
    }

    public dx a(int i, int j, float f1)
    {
        dx dx1 = new dx(ag, ak, al + (double)f1, am, new ev(i, j));
        dx1.c = 10;
        ag.a(((kh) (dx1)));
        return dx1;
    }

    public boolean B()
    {
        return !aA;
    }

    public boolean I()
    {
        int i = eo.b(ak);
        int j = eo.b(al + (double)s());
        int k = eo.b(am);
        return ag.g(i, j, k);
    }

    public boolean a(dm dm)
    {
        return false;
    }

    public cf b_(kh kh1)
    {
        return null;
    }

    public void p()
    {
        if(af.aA)
        {
            af = null;
            return;
        }
        an = 0.0D;
        ao = 0.0D;
        ap = 0.0D;
        e_();
        af.i_();
        e += af.aq - af.as;
        d += af.ar - af.at;
        for(; e >= 180D; e -= 360D);
        for(; e < -180D; e += 360D);
        for(; d >= 180D; d -= 360D);
        for(; d < -180D; d += 360D);
        double d1 = e * 0.5D;
        double d2 = d * 0.5D;
        float f1 = 10F;
        if(d1 > (double)f1)
            d1 = f1;
        if(d1 < (double)(-f1))
            d1 = -f1;
        if(d2 > (double)f1)
            d2 = f1;
        if(d2 < (double)(-f1))
            d2 = -f1;
        e -= d1;
        d -= d2;
        aq += ((float) (d1));
        ar += ((float) (d2));
    }

    protected void i_()
    {
        ae.a(ak, al + h() + ae.v(), am);
    }

    public double v()
    {
        return (double)aB;
    }

    public double h()
    {
        return (double)aD * 0.75D;
    }

    public void g(kh kh1)
    {
        d = 0.0D;
        e = 0.0D;
        if(af == kh1)
        {
            af.ae = null;
            af = null;
            c(kh1.ak, kh1.au.b + (double)kh1.aD, kh1.am, aq, ar);
            return;
        }
        if(af != null)
            af.ae = null;
        if(kh1.ae != null)
            kh1.ae.af = null;
        af = kh1;
        kh1.ae = this;
    }

    public void a(double d1, double d2, double d3, float f1, 
            float f2, int i)
    {
        a(d1, d2, d3);
        c(f1, f2);
    }

    private static int a = 0;
    public int ab;
    public double ac;
    public boolean ad;
    public kh ae;
    public kh af;
    protected cn ag;
    public double ah;
    public double ai;
    public double aj;
    public double ak;
    public double al;
    public double am;
    public double an;
    public double ao;
    public double ap;
    public float aq;
    public float ar;
    public float as;
    public float at;
    public final cf au = cf.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
    public boolean av;
    public boolean aw;
    public boolean ax;
    public boolean ay;
    public boolean az;
    public boolean aA;
    public float aB;
    public float aC;
    public float aD;
    public float aE;
    public float aF;
    protected boolean aG;
    protected float aH;
    private int b;
    public double aI;
    public double aJ;
    public double aK;
    public float aL;
    public float aM;
    public boolean aN;
    public float aO;
    public boolean aP;
    protected Random aQ;
    public int aR;
    public int aS;
    public int aT;
    protected int aU;
    protected boolean aV;
    public int aW;
    public int aX;
    private boolean c;
    public String aY;
    private double d;
    private double e;
    public boolean aZ;
    public int ba;
    public int bb;
    public int bc;
    public int bd;
    public int be;
    public int bf;

}
