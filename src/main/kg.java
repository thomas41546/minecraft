package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import java.util.Random;

public class kg extends kh
{

    public kg(cn cn1)
    {
        super(cn1);
        b = -1;
        c = -1;
        d = -1;
        e = 0;
        f = false;
        a = 0;
        i = 0;
        a(0.5F, 0.5F);
    }

    public kg(cn cn1, ge ge1)
    {
        super(cn1);
        b = -1;
        c = -1;
        d = -1;
        e = 0;
        f = false;
        a = 0;
        i = 0;
        g = ge1;
        a(0.5F, 0.5F);
        c(ge1.ak, ge1.al, ge1.am, ge1.aq, ge1.ar);
        ak -= eo.b((aq / 180F) * 3.141593F) * 0.16F;
        al -= 0.10000000149011612D;
        am -= eo.a((aq / 180F) * 3.141593F) * 0.16F;
        a(ak, al, am);
        aB = 0.0F;
        an = -eo.a((aq / 180F) * 3.141593F) * eo.b((ar / 180F) * 3.141593F);
        ap = eo.b((aq / 180F) * 3.141593F) * eo.b((ar / 180F) * 3.141593F);
        ao = -eo.a((ar / 180F) * 3.141593F);
        a(an, ao, ap, 1.5F, 1.0F);
    }

    public void a(double d1, double d2, double d3, float f1, 
            float f2)
    {
        float f3 = eo.a(d1 * d1 + d2 * d2 + d3 * d3);
        d1 /= f3;
        d2 /= f3;
        d3 /= f3;
        d1 += aQ.nextGaussian() * 0.0074999998323619366D * (double)f2;
        d2 += aQ.nextGaussian() * 0.0074999998323619366D * (double)f2;
        d3 += aQ.nextGaussian() * 0.0074999998323619366D * (double)f2;
        d1 *= f1;
        d2 *= f1;
        d3 *= f1;
        an = d1;
        ao = d2;
        ap = d3;
        float f4 = eo.a(d1 * d1 + d3 * d3);
        as = aq = (float)((Math.atan2(d1, d3) * 180D) / 3.1415927410125732D);
        at = ar = (float)((Math.atan2(d2, f4) * 180D) / 3.1415927410125732D);
        h = 0;
    }

    public void e_()
    {
        super.e_();
        if(a > 0)
            a--;
        if(f)
        {
            int j = ag.a(b, c, d);
            if(j != e)
            {
                f = false;
                an *= aQ.nextFloat() * 0.2F;
                ao *= aQ.nextFloat() * 0.2F;
                ap *= aQ.nextFloat() * 0.2F;
                h = 0;
                i = 0;
            } else
            {
                h++;
                if(h == 1200)
                    F();
                return;
            }
        } else
        {
            i++;
        }
        aj aj1 = aj.b(ak, al, am);
        aj aj2 = aj.b(ak + an, al + ao, am + ap);
        mf mf1 = ag.a(aj1, aj2);
        aj1 = aj.b(ak, al, am);
        aj2 = aj.b(ak + an, al + ao, am + ap);
        if(mf1 != null)
            aj2 = aj.b(mf1.f.a, mf1.f.b, mf1.f.c);
        kh kh1 = null;
        List list = ag.b(((kh) (this)), au.a(an, ao, ap).b(1.0D, 1.0D, 1.0D));
        double d1 = 0.0D;
        for(int k = 0; k < list.size(); k++)
        {
            kh kh2 = (kh)list.get(k);
            if(!kh2.c_() || kh2 == g && i < 5)
                continue;
            float f4 = 0.3F;
            cf cf1 = kh2.au.b(f4, f4, f4);
            mf mf2 = cf1.a(aj1, aj2);
            if(mf2 == null)
                continue;
            double d2 = aj1.c(mf2.f);
            if(d2 < d1 || d1 == 0.0D)
            {
                kh1 = kh2;
                d1 = d2;
            }
        }

        if(kh1 != null)
            mf1 = new mf(kh1);
        if(mf1 != null)
            if(mf1.g != null)
            {
                if(mf1.g.a(((kh) (g)), 4))
                {
                    ag.a(((kh) (this)), "random.drr", 1.0F, 1.2F / (aQ.nextFloat() * 0.2F + 0.9F));
                    F();
                } else
                {
                    an *= -0.10000000149011612D;
                    ao *= -0.10000000149011612D;
                    ap *= -0.10000000149011612D;
                    aq += 180F;
                    as += 180F;
                    i = 0;
                }
            } else
            {
                b = mf1.b;
                c = mf1.c;
                d = mf1.d;
                e = ag.a(b, c, d);
                an = (float)(mf1.f.a - ak);
                ao = (float)(mf1.f.b - al);
                ap = (float)(mf1.f.c - am);
                float f1 = eo.a(an * an + ao * ao + ap * ap);
                ak -= (an / (double)f1) * 0.05000000074505806D;
                al -= (ao / (double)f1) * 0.05000000074505806D;
                am -= (ap / (double)f1) * 0.05000000074505806D;
                ag.a(((kh) (this)), "random.drr", 1.0F, 1.2F / (aQ.nextFloat() * 0.2F + 0.9F));
                f = true;
                a = 7;
            }
        ak += an;
        al += ao;
        am += ap;
        float f2 = eo.a(an * an + ap * ap);
        aq = (float)((Math.atan2(an, ap) * 180D) / 3.1415927410125732D);
        for(ar = (float)((Math.atan2(ao, f2) * 180D) / 3.1415927410125732D); ar - at < -180F; at -= 360F);
        for(; ar - at >= 180F; at += 360F);
        for(; aq - as < -180F; as -= 360F);
        for(; aq - as >= 180F; as += 360F);
        ar = at + (ar - at) * 0.2F;
        aq = as + (aq - as) * 0.2F;
        float f3 = 0.99F;
        float f5 = 0.03F;
        if(g_())
        {
            for(int l = 0; l < 4; l++)
            {
                float f6 = 0.25F;
                ag.a("bubble", ak - an * (double)f6, al - ao * (double)f6, am - ap * (double)f6, an, ao, ap);
            }

            f3 = 0.8F;
        }
        an *= f3;
        ao *= f3;
        ap *= f3;
        ao -= f5;
        a(ak, al, am);
    }

    public void a(hm hm1)
    {
        hm1.a("xTile", (short)b);
        hm1.a("yTile", (short)c);
        hm1.a("zTile", (short)d);
        hm1.a("inTile", (byte)e);
        hm1.a("shake", (byte)a);
        hm1.a("inGround", (byte)(f ? 1 : 0));
    }

    public void b(hm hm1)
    {
        b = ((int) (hm1.d("xTile")));
        c = ((int) (hm1.d("yTile")));
        d = ((int) (hm1.d("zTile")));
        e = hm1.c("inTile") & 0xff;
        a = hm1.c("shake") & 0xff;
        f = hm1.c("inGround") == 1;
    }

    public void b(dm dm1)
    {
        if(f && g == dm1 && a <= 0 && dm1.b.a(new ev(di.j.aS, 1)))
        {
            ag.a(((kh) (this)), "random.pop", 0.2F, ((aQ.nextFloat() - aQ.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            dm1.a_(((kh) (this)), 1);
            F();
        }
    }

    public float h_()
    {
        return 0.0F;
    }

    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    public int a;
    private ge g;
    private int h;
    private int i;
}
