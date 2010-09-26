package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class ff extends kh
{

    public ff(cn cn1)
    {
        super(cn1);
        b = 0;
    }

    public ff(cn cn1, float f, float f1, float f2, int j)
    {
        super(cn1);
        b = 0;
        a = j;
        ad = true;
        a(0.98F, 0.98F);
        aB = aD / 2.0F;
        a(f, f1, f2);
        an = 0.0D;
        ao = 0.0D;
        ap = 0.0D;
        aG = false;
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
        if(a == 0)
        {
            F();
            return;
        }
        ah = ak;
        ai = al;
        aj = am;
        b++;
        ao -= 0.039999999105930328D;
        c(an, ao, ap);
        an *= 0.98000001907348633D;
        ao *= 0.98000001907348633D;
        ap *= 0.98000001907348633D;
        int j = eo.b(ak);
        int k = eo.b(al);
        int l = eo.b(am);
        if(ag.a(j, k, l) == a)
            ag.d(j, k, l, 0);
        if(av)
        {
            an *= 0.69999998807907104D;
            ap *= 0.69999998807907104D;
            ao *= -0.5D;
            F();
            if(!ag.a(a, j, k, l, true) || !ag.d(j, k, l, a))
                b(a, 1);
        } else
        if(b > 100)
        {
            b(a, 1);
            F();
        }
    }

    protected void a(hm hm1)
    {
        hm1.a("Tile", (byte)a);
    }

    protected void b(hm hm1)
    {
        a = hm1.c("Tile") & 0xff;
    }

    public float h_()
    {
        return 0.0F;
    }

    public cn i()
    {
        return ag;
    }

    public int a;
    public int b;
}
