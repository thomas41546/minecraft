package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import java.util.Random;

public class ge extends kh
{

    public ge(cn cn1)
    {
        super(cn1);
        j = 20;
        n = 0.0F;
        o = 0.0F;
        t = true;
        u = "/char.png";
        v = true;
        w = 0.0F;
        x = null;
        y = 1.0F;
        z = 0;
        A = 0.0F;
        B = false;
        I = 0.0F;
        J = 0;
        K = 0;
        N = false;
        O = -1;
        P = (float)(Math.random() * 0.89999997615814209D + 0.10000000149011612D);
        T = 0.0F;
        U = 0;
        Y = false;
        Z = 0.0F;
        aa = 0.7F;
        i = 0;
        E = 10;
        ad = true;
        m = (float)(Math.random() + 1.0D) * 0.01F;
        a(ak, al, am);
        k = (float)Math.random() * 12398F;
        aq = (float)(Math.random() * 3.1415927410125732D * 2D);
        l = 1.0F;
        aM = 0.5F;
    }

    protected boolean c(kh kh1)
    {
        return ag.a(aj.b(ak, al + (double)s(), am), aj.b(kh1.ak, kh1.al + (double)kh1.s(), kh1.am)) == null;
    }

    public String x()
    {
        return u;
    }

    public boolean c_()
    {
        return !aA;
    }

    public boolean d_()
    {
        return !aA;
    }

    protected float s()
    {
        return aD * 0.85F;
    }

    public int b()
    {
        return 80;
    }

    public void y()
    {
        C = D;
        super.y();
        if(aQ.nextInt(1000) < a++)
        {
            a = -b();
            String s1 = c();
            if(s1 != null)
                ag.a(((kh) (this)), s1, f(), (aQ.nextFloat() - aQ.nextFloat()) * 0.2F + 1.0F);
        }
        if(B() && I())
            a(((kh) (null)), 1);
        if(B() && a(gb.f))
        {
            aX--;
            if(aX == -20)
            {
                aX = 0;
                for(int i1 = 0; i1 < 8; i1++)
                {
                    float f1 = aQ.nextFloat() - aQ.nextFloat();
                    float f2 = aQ.nextFloat() - aQ.nextFloat();
                    float f3 = aQ.nextFloat() - aQ.nextFloat();
                    ag.a("bubble", ak + (double)f1, al + (double)f2, am + (double)f3, an, ao, ap);
                }

                a(((kh) (null)), 2);
            }
            aT = 0;
        } else
        {
            aX = aU;
        }
        L = M;
        if(K > 0)
            K--;
        if(G > 0)
            G--;
        if(aW > 0)
            aW--;
        if(E <= 0)
        {
            J++;
            if(J > 20)
            {
                D();
                F();
                for(int j1 = 0; j1 < 20; j1++)
                {
                    double d1 = aQ.nextGaussian() * 0.02D;
                    double d2 = aQ.nextGaussian() * 0.02D;
                    double d3 = aQ.nextGaussian() * 0.02D;
                    ag.a("explode", (ak + (double)(aQ.nextFloat() * aC * 2.0F)) - (double)aC, al + (double)(aQ.nextFloat() * aD), (am + (double)(aQ.nextFloat() * aC * 2.0F)) - (double)aC, d1, d2, d3);
                }

            }
        }
        s = r;
        o = n;
        as = aq;
        at = ar;
    }

    public void z()
    {
        for(int i1 = 0; i1 < 20; i1++)
        {
            double d1 = aQ.nextGaussian() * 0.02D;
            double d2 = aQ.nextGaussian() * 0.02D;
            double d3 = aQ.nextGaussian() * 0.02D;
            double d4 = 10D;
            ag.a("explode", (ak + (double)(aQ.nextFloat() * aC * 2.0F)) - (double)aC - d1 * d4, (al + (double)(aQ.nextFloat() * aD)) - d2 * d4, (am + (double)(aQ.nextFloat() * aC * 2.0F)) - (double)aC - d3 * d4, d1, d2, d3);
        }

    }

    public void p()
    {
        super.p();
        p = q;
        q = 0.0F;
    }

    public void a(double d1, double d2, double d3, float f1, 
            float f2, int i1)
    {
        aB = 0.0F;
        c = d1;
        d = d2;
        e = d3;
        f = f1;
        g = f2;
        b = i1;
    }

    public void e_()
    {
        super.e_();
        j();
        double d1 = ak - ah;
        double d2 = am - aj;
        float f1 = eo.a(d1 * d1 + d2 * d2);
        float f2 = n;
        float f3 = 0.0F;
        p = q;
        float f4 = 0.0F;
        if(f1 > 0.05F)
        {
            f4 = 1.0F;
            f3 = f1 * 3F;
            f2 = ((float)Math.atan2(d2, d1) * 180F) / 3.141593F - 90F;
        }
        if(D > 0.0F)
            f2 = aq;
        if(!av)
            f4 = 0.0F;
        q = q + (f4 - q) * 0.3F;
        float f5;
        for(f5 = f2 - n; f5 < -180F; f5 += 360F);
        for(; f5 >= 180F; f5 -= 360F);
        n += f5 * 0.3F;
        float f6;
        for(f6 = aq - n; f6 < -180F; f6 += 360F);
        for(; f6 >= 180F; f6 -= 360F);
        boolean flag = f6 < -90F || f6 >= 90F;
        if(f6 < -75F)
            f6 = -75F;
        if(f6 >= 75F)
            f6 = 75F;
        n = aq - f6;
        if(f6 * f6 > 2500F)
            n += f6 * 0.2F;
        if(flag)
            f3 *= -1F;
        for(; aq - as < -180F; as -= 360F);
        for(; aq - as >= 180F; as += 360F);
        for(; n - o < -180F; o -= 360F);
        for(; n - o >= 180F; o += 360F);
        for(; ar - at < -180F; at -= 360F);
        for(; ar - at >= 180F; at += 360F);
        r += f3;
    }

    protected void a(float f1, float f2)
    {
        super.a(f1, f2);
    }

    public void b(int i1)
    {
        if(E <= 0)
            return;
        E += i1;
        if(E > 20)
            E = 20;
        aW = j / 2;
    }

    public boolean a(kh kh1, int i1)
    {
        if(ag.y)
            i1 = 0;
        U = 0;
        if(E <= 0)
            return false;
        R = 1.5F;
        if((float)aW > (float)j / 2.0F)
        {
            if(F - i1 >= E)
                return false;
            E = F - i1;
        } else
        {
            F = E;
            aW = j;
            E -= i1;
            G = H = 10;
        }
        I = 0.0F;
        if(kh1 != null)
        {
            double d1 = kh1.ak - ak;
            double d2;
            for(d2 = kh1.am - am; d1 * d1 + d2 * d2 < 0.0001D; d2 = (Math.random() - Math.random()) * 0.01D)
                d1 = (Math.random() - Math.random()) * 0.01D;

            I = (float)((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - aq;
            a(kh1, i1, d1, d2);
        } else
        {
            I = (int)(Math.random() * 2D) * 180;
        }
        if(E <= 0)
        {
            ag.a(((kh) (this)), e(), f(), (aQ.nextFloat() - aQ.nextFloat()) * 0.2F + 1.0F);
            b(kh1);
        } else
        {
            ag.a(((kh) (this)), d(), f(), (aQ.nextFloat() - aQ.nextFloat()) * 0.2F + 1.0F);
        }
        return true;
    }

    protected float f()
    {
        return 1.0F;
    }

    protected String c()
    {
        return null;
    }

    protected String d()
    {
        return "random.hurt";
    }

    protected String e()
    {
        return "random.hurt";
    }

    public void a(kh kh1, int i1, double d1, double d2)
    {
        float f1 = eo.a(d1 * d1 + d2 * d2);
        float f2 = 0.4F;
        an /= 2D;
        ao /= 2D;
        ap /= 2D;
        an -= (d1 / (double)f1) * (double)f2;
        ao += 0.40000000596046448D;
        ap -= (d2 / (double)f1) * (double)f2;
        if(ao > 0.40000000596046448D)
            ao = 0.40000000596046448D;
    }

    public void b(kh kh1)
    {
        if(z > 0 && kh1 != null)
            kh1.b(((kh) (this)), z);
        N = true;
        int i1 = g();
        if(i1 > 0)
        {
            int j1 = aQ.nextInt(3);
            for(int k1 = 0; k1 < j1; k1++)
                b(i1, 1);

        }
    }

    protected int g()
    {
        return 0;
    }

    protected void c(float f1)
    {
        int i1 = (int)Math.ceil(f1 - 3F);
        if(i1 > 0)
        {
            a(((kh) (null)), i1);
            int j1 = ag.a(eo.b(ak), eo.b(al - 0.20000000298023224D - (double)aB), eo.b(am));
            if(j1 > 0)
            {
                bb bb1 = ly.n[j1].bl;
                ag.a(((kh) (this)), bb1.d(), bb1.b() * 0.5F, bb1.c() * 0.75F);
            }
        }
    }

    public void b(float f1, float f2)
    {
        if(g_())
        {
            double d1 = al;
            a(f1, f2, 0.02F);
            c(an, ao, ap);
            an *= 0.80000001192092896D;
            ao *= 0.80000001192092896D;
            ap *= 0.80000001192092896D;
            ao -= 0.02D;
            if(aw && b(an, ((ao + 0.60000002384185791D) - al) + d1, ap))
                ao = 0.30000001192092896D;
        } else
        if(G())
        {
            double d2 = al;
            a(f1, f2, 0.02F);
            c(an, ao, ap);
            an *= 0.5D;
            ao *= 0.5D;
            ap *= 0.5D;
            ao -= 0.02D;
            if(aw && b(an, ((ao + 0.60000002384185791D) - al) + d2, ap))
                ao = 0.30000001192092896D;
        } else
        {
            float f3 = 0.91F;
            if(av)
            {
                f3 = 0.5460001F;
                int i1 = ag.a(eo.b(ak), eo.b(au.b) - 1, eo.b(am));
                if(i1 > 0)
                    f3 = ly.n[i1].bo * 0.91F;
            }
            float f4 = 0.1627714F / (f3 * f3 * f3);
            a(f1, f2, av ? 0.1F * f4 : 0.02F);
            f3 = 0.91F;
            if(av)
            {
                f3 = 0.5460001F;
                int j1 = ag.a(eo.b(ak), eo.b(au.b) - 1, eo.b(am));
                if(j1 > 0)
                    f3 = ly.n[j1].bo * 0.91F;
            }
            if(A())
            {
                aH = 0.0F;
                if(ao < -0.14999999999999999D)
                    ao = -0.14999999999999999D;
            }
            c(an, ao, ap);
            if(aw && A())
                ao = 0.20000000000000001D;
            ao -= 0.080000000000000002D;
            ao *= 0.98000001907348633D;
            an *= f3;
            ap *= f3;
        }
        Q = R;
        double d3 = ak - ah;
        double d4 = am - aj;
        float f5 = eo.a(d3 * d3 + d4 * d4) * 4F;
        if(f5 > 1.0F)
            f5 = 1.0F;
        R += (f5 - R) * 0.4F;
        S += R;
    }

    public boolean A()
    {
        int i1 = eo.b(ak);
        int j1 = eo.b(au.b);
        int k1 = eo.b(am);
        return ag.a(i1, j1, k1) == ly.aG.bc || ag.a(i1, j1 + 1, k1) == ly.aG.bc;
    }

    public void a(hm hm1)
    {
        hm1.a("Health", (short)E);
        hm1.a("HurtTime", (short)G);
        hm1.a("DeathTime", (short)J);
        hm1.a("AttackTime", (short)K);
    }

    public void b(hm hm1)
    {
        E = ((int) (hm1.d("Health")));
        if(!hm1.b("Health"))
            E = 10;
        G = ((int) (hm1.d("HurtTime")));
        J = ((int) (hm1.d("DeathTime")));
        K = ((int) (hm1.d("AttackTime")));
    }

    public boolean B()
    {
        return !aA && E > 0;
    }

    public void j()
    {
        if(b > 0)
        {
            double d1 = ak + (c - ak) / (double)b;
            double d2 = al + (d - al) / (double)b;
            double d3 = am + (e - am) / (double)b;
            double d4;
            for(d4 = f - (double)aq; d4 < -180D; d4 += 360D);
            for(; d4 >= 180D; d4 -= 360D);
            aq += ((float) (d4 / (double)b));
            ar += ((float) ((g - (double)ar) / (double)b));
            b--;
            a(d1, d2, d3);
            c(aq, ar);
        }
        if(E <= 0)
        {
            Y = false;
            V = 0.0F;
            W = 0.0F;
            X = 0.0F;
        } else
        if(!B)
            b_();
        boolean flag = g_();
        boolean flag1 = G();
        if(Y)
            if(flag)
                ao += 0.039999999105930328D;
            else
            if(flag1)
                ao += 0.039999999105930328D;
            else
            if(av)
                C();
        V *= 0.98F;
        W *= 0.98F;
        X *= 0.9F;
        b(V, W);
        List list = ag.b(((kh) (this)), au.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        if(list != null && list.size() > 0)
        {
            for(int i1 = 0; i1 < list.size(); i1++)
            {
                kh kh1 = (kh)list.get(i1);
                if(kh1.d_())
                    kh1.f(((kh) (this)));
            }

        }
    }

    protected void C()
    {
        ao = 0.41999998688697815D;
    }

    protected void b_()
    {
        U++;
        dm dm = ag.a(((kh) (this)), -1D);
        if(dm != null)
        {
            double d1 = ((kh) (dm)).ak - ak;
            double d2 = ((kh) (dm)).al - al;
            double d3 = ((kh) (dm)).am - am;
            double d4 = d1 * d1 + d2 * d2 + d3 * d3;
            if(d4 > 16384D)
                F();
            if(U > 600 && aQ.nextInt(800) == 0)
                if(d4 < 1024D)
                    U = 0;
                else
                    F();
        }
        V = 0.0F;
        W = 0.0F;
        float f1 = 8F;
        if(aQ.nextFloat() < 0.02F)
        {
            dm dm1 = ag.a(((kh) (this)), f1);
            if(dm1 != null)
            {
                h = ((kh) (dm1));
                i = 10 + aQ.nextInt(20);
            } else
            {
                X = (aQ.nextFloat() - 0.5F) * 20F;
            }
        }
        if(h != null)
        {
            b(h, 10F);
            if(i-- <= 0 || h.aA || h.e(((kh) (this))) > (double)(f1 * f1))
                h = null;
        } else
        {
            if(aQ.nextFloat() < 0.05F)
                X = (aQ.nextFloat() - 0.5F) * 20F;
            aq += X;
            ar = Z;
        }
        boolean flag = g_();
        boolean flag1 = G();
        if(flag || flag1)
            Y = aQ.nextFloat() < 0.8F;
    }

    public void b(kh kh1, float f1)
    {
        double d1 = kh1.ak - ak;
        double d3 = kh1.am - am;
        double d2;
        if(kh1 instanceof ge)
        {
            ge ge1 = (ge)kh1;
            d2 = (ge1.al + (double)ge1.s()) - (al + (double)s());
        } else
        {
            d2 = (kh1.au.b + kh1.au.e) / 2D - (al + (double)s());
        }
        double d4 = eo.a(d1 * d1 + d3 * d3);
        float f2 = (float)((Math.atan2(d3, d1) * 180D) / 3.1415927410125732D) - 90F;
        float f3 = (float)((Math.atan2(d2, d4) * 180D) / 3.1415927410125732D);
        ar = b(ar, f3, f1);
        aq = b(aq, f2, f1);
    }

    private float b(float f1, float f2, float f3)
    {
        float f4;
        for(f4 = f2 - f1; f4 < -180F; f4 += 360F);
        for(; f4 >= 180F; f4 -= 360F);
        if(f4 > f3)
            f4 = f3;
        if(f4 < -f3)
            f4 = -f3;
        return f1 + f4;
    }

    public void D()
    {
    }

    public boolean a()
    {
        return ag.a(au) && ag.a(((kh) (this)), au).size() == 0 && !ag.b(au);
    }

    protected void E()
    {
        a(((kh) (null)), 4);
    }

    public float d(float f1)
    {
        float f2 = D - C;
        if(f2 < 0.0F)
            f2++;
        return C + f2 * f1;
    }

    public aj e(float f1)
    {
        if(f1 == 1.0F)
        {
            return aj.b(ak, al, am);
        } else
        {
            double d1 = ah + (ak - ah) * (double)f1;
            double d2 = ai + (al - ai) * (double)f1;
            double d3 = aj + (am - aj) * (double)f1;
            return aj.b(d1, d2, d3);
        }
    }

    public aj f(float f1)
    {
        if(f1 == 1.0F)
        {
            float f2 = eo.b(-aq * 0.01745329F - 3.141593F);
            float f4 = eo.a(-aq * 0.01745329F - 3.141593F);
            float f6 = -eo.b(-ar * 0.01745329F);
            float f8 = eo.a(-ar * 0.01745329F);
            return aj.b(f4 * f6, f8, f2 * f6);
        } else
        {
            float f3 = at + (ar - at) * f1;
            float f5 = as + (aq - as) * f1;
            float f7 = eo.b(-f5 * 0.01745329F - 3.141593F);
            float f9 = eo.a(-f5 * 0.01745329F - 3.141593F);
            float f10 = -eo.b(-f3 * 0.01745329F);
            float f11 = eo.a(-f3 * 0.01745329F);
            return aj.b(f9 * f10, f11, f7 * f10);
        }
    }

    public mf a(double d1, float f1)
    {
        aj aj1 = e(f1);
        aj aj2 = f(f1);
        aj aj3 = aj1.c(aj2.a * d1, aj2.b * d1, aj2.c * d1);
        return ag.a(aj1, aj3);
    }

    public int j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    protected float p;
    protected float q;
    protected float r;
    protected float s;
    protected boolean t;
    protected String u;
    protected boolean v;
    protected float w;
    protected String x;
    protected float y;
    protected int z;
    protected float A;
    public boolean B;
    public float C;
    public float D;
    public int E;
    public int F;
    private int a;
    public int G;
    public int H;
    public float I;
    public int J;
    public int K;
    public float L;
    public float M;
    protected boolean N;
    public int O;
    public float P;
    public float Q;
    public float R;
    public float S;
    private int b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    float T;
    protected int U;
    protected float V;
    protected float W;
    protected float X;
    protected boolean Y;
    protected float Z;
    protected float aa;
    private kh h;
    private int i;
}
