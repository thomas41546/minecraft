package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import java.util.Random;

public class dm extends ge
{

    public dm(cn cn1)
    {
        super(cn1);
        b = new eu(this);
        c = 0;
        d = 0;
        g = false;
        h = 0;
        a = 0;
        aB = 1.62F;
        c((double)cn1.o + 0.5D, cn1.p + 1, (double)cn1.q + 0.5D, 0.0F, 0.0F);
        E = 20;
        x = "humanoid";
        w = 180F;
        aS = 20;
        u = "/char.png";
    }

    public void p()
    {
        super.p();
        e = f;
        f = 0.0F;
    }

    public void q()
    {
        aB = 1.62F;
        a(0.6F, 1.8F);
        super.q();
        E = 20;
        J = 0;
    }

    protected void b_()
    {
        if(g)
        {
            h++;
            if(h == 8)
            {
                h = 0;
                g = false;
            }
        } else
        {
            h = 0;
        }
        D = (float)h / 8F;
    }

    public void j()
    {
        if(ag.l == 0 && E < 20 && (aR % 20) * 4 == 0)
            b(1);
        b.b();
        e = f;
        super.j();
        float f1 = eo.a(an * an + ap * ap);
        float f2 = (float)Math.atan(-ao * 0.20000000298023224D) * 15F;
        if(f1 > 0.1F)
            f1 = 0.1F;
        if(!av || E <= 0)
            f1 = 0.0F;
        if(av || E <= 0)
            f2 = 0.0F;
        f += (f1 - f) * 0.4F;
        M += (f2 - M) * 0.8F;
        if(E > 0)
        {
            List list = ag.b(((kh) (this)), au.b(1.0D, 0.0D, 1.0D));
            if(list != null)
            {
                for(int k = 0; k < list.size(); k++)
                    h((kh)list.get(k));

            }
        }
    }

    private void h(kh kh1)
    {
        kh1.b(this);
    }

    public int r()
    {
        return d;
    }

    public void b(kh kh1)
    {
        a(0.2F, 0.2F);
        a(ak, al, am);
        ao = 0.10000000149011612D;
        if(i.equals("Notch"))
            a(new ev(di.h, 1), true);
        b.g();
        if(kh1 != null)
        {
            an = -eo.b(((I + aq) * 3.141593F) / 180F) * 0.1F;
            ap = -eo.a(((I + aq) * 3.141593F) / 180F) * 0.1F;
        } else
        {
            an = ap = 0.0D;
        }
        aB = 0.1F;
    }

    public void b(kh kh1, int k)
    {
        d += k;
    }

    public void a(ev ev1)
    {
        a(ev1, false);
    }

    public void a(ev ev1, boolean flag)
    {
        if(ev1 == null)
            return;
        dx dx1 = new dx(ag, ak, (al - 0.30000001192092896D) + (double)s(), am, ev1);
        dx1.c = 40;
        float f1 = 0.1F;
        if(flag)
        {
            float f3 = aQ.nextFloat() * 0.5F;
            float f5 = aQ.nextFloat() * 3.141593F * 2.0F;
            dx1.an = -eo.a(f5) * f3;
            dx1.ap = eo.b(f5) * f3;
            dx1.ao = 0.20000000298023224D;
        } else
        {
            float f2 = 0.3F;
            dx1.an = -eo.a((aq / 180F) * 3.141593F) * eo.b((ar / 180F) * 3.141593F) * f2;
            dx1.ap = eo.b((aq / 180F) * 3.141593F) * eo.b((ar / 180F) * 3.141593F) * f2;
            dx1.ao = -eo.a((ar / 180F) * 3.141593F) * f2 + 0.1F;
            f2 = 0.02F;
            float f4 = aQ.nextFloat() * 3.141593F * 2.0F;
            f2 *= aQ.nextFloat();
            dx1.an += Math.cos(f4) * (double)f2;
            dx1.ao += (aQ.nextFloat() - aQ.nextFloat()) * 0.1F;
            dx1.ap += Math.sin(f4) * (double)f2;
        }
        a(dx1);
    }

    protected void a(dx dx1)
    {
        ag.a(((kh) (dx1)));
    }

    public float a(ly ly)
    {
        float f1 = b.a(ly);
        if(a(gb.f))
            f1 /= 5F;
        if(!av)
            f1 /= 5F;
        return f1;
    }

    public boolean b(ly ly)
    {
        return b.b(ly);
    }

    public void b(hm hm1)
    {
        super.b(hm1);
        ki ki1 = hm1.l("Inventory");
        b.b(ki1);
    }

    public void a(hm hm1)
    {
        super.a(hm1);
        hm1.a("Inventory", ((el) (b.a(new ki()))));
    }

    public void a(gh gh)
    {
    }

    public void l()
    {
    }

    public void a_(kh kh1, int k)
    {
    }

    protected float s()
    {
        return 0.12F;
    }

    public boolean a(kh kh1, int k)
    {
        U = 0;
        if(E <= 0)
            return false;
        if((float)aW > (float)j / 2.0F)
            return false;
        if((kh1 instanceof dq) || (kh1 instanceof kg))
        {
            if(ag.l == 0)
                k = 0;
            if(ag.l == 1)
                k = k / 3 + 1;
            if(ag.l == 3)
                k = (k * 3) / 2;
        }
        int i1 = 25 - b.f();
        int j1 = k * i1 + a;
        b.e(k);
        k = j1 / 25;
        a = j1 % 25;
        if(k == 0)
            return false;
        else
            return super.a(kh1, k);
    }

    public void a(ke ke)
    {
    }

    public void a(ob ob)
    {
    }

    public void a_(kh kh1)
    {
    }

    public ev t()
    {
        return b.a();
    }

    public void u()
    {
        b.a(b.d, ((ev) (null)));
    }

    public double v()
    {
        return (double)(aB - 0.5F);
    }

    public void w()
    {
        h = -1;
        g = true;
    }

    public eu b;
    public byte c;
    public int d;
    public float e;
    public float f;
    public boolean g;
    public int h;
    public String i;
    private int a;
}
