package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class dq extends ek
    implements co
{

    public dq(cn cn1)
    {
        super(cn1);
        e = 2;
        E = 20;
    }

    public void j()
    {
        float f = a(1.0F);
        if(f > 0.5F)
            U += 2;
        super.j();
    }

    public void e_()
    {
        super.e_();
        if(ag.l == 0)
            F();
    }

    protected kh i()
    {
        dm dm = ag.a(((kh) (this)), 16D);
        if(dm != null && c(((kh) (dm))))
            return ((kh) (dm));
        else
            return null;
    }

    public boolean a(kh kh1, int k)
    {
        if(super.a(kh1, k))
        {
            if(ae == kh1 || af == kh1)
                return true;
            if(kh1 != this)
                f = kh1;
            return true;
        } else
        {
            return false;
        }
    }

    protected void a(kh kh1, float f)
    {
        if((double)f < 2.5D && kh1.au.e > au.b && kh1.au.b < au.e)
        {
            K = 20;
            kh1.a(((kh) (this)), e);
        }
    }

    protected float a(int k, int l, int i1)
    {
        return 0.5F - ag.c(k, l, i1);
    }

    public void a(hm hm)
    {
        super.a(hm);
    }

    public void b(hm hm)
    {
        super.b(hm);
    }

    public boolean a()
    {
        int k = eo.b(ak);
        int l = eo.b(au.b);
        int i1 = eo.b(am);
        if(ag.a(by.a, k, l, i1) > aQ.nextInt(32))
        {
            return false;
        } else
        {
            int j1 = ag.j(k, l, i1);
            return j1 <= aQ.nextInt(8) && super.a();
        }
    }

    protected int e;
}
