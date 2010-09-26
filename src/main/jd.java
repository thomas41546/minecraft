package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class jd extends kh
{

    public jd(cn cn1)
    {
        super(cn1);
        a = 0;
        ad = true;
        a(0.98F, 0.98F);
        aB = aD / 2.0F;
    }

    public jd(cn cn1, float f, float f1, float f2)
    {
        this(cn1);
        a(f, f1, f2);
        float f3 = (float)(Math.random() * 3.1415927410125732D * 2D);
        an = -eo.a((f3 * 3.141593F) / 180F) * 0.02F;
        ao = 0.20000000298023224D;
        ap = -eo.b((f3 * 3.141593F) / 180F) * 0.02F;
        aG = false;
        a = 80;
        ah = f;
        ai = f1;
        aj = f2;
    }

    public boolean c_()
    {
        return !aA;
    }

    public void e_()
    {
        ah = ak;
        ai = al;
        aj = am;
        ao -= 0.039999999105930328D;
        c(an, ao, ap);
        an *= 0.98000001907348633D;
        ao *= 0.98000001907348633D;
        ap *= 0.98000001907348633D;
        if(av)
        {
            an *= 0.69999998807907104D;
            ap *= 0.69999998807907104D;
            ao *= -0.5D;
        }
        if(a-- <= 0)
        {
            F();
            i();
        } else
        {
            ag.a("smoke", ak, al + 0.5D, am, 0.0D, 0.0D, 0.0D);
        }
    }

    private void i()
    {
        float f = 4F;
        ag.a(((kh) (null)), ak, al, am, f);
    }

    protected void a(hm hm1)
    {
        hm1.a("Fuse", (byte)a);
    }

    protected void b(hm hm1)
    {
        a = ((int) (hm1.c("Fuse")));
    }

    public float h_()
    {
        return 0.0F;
    }

    public int a;
}
