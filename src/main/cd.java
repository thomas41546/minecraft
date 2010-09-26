package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class cd extends nq
{

    public cd(cn cn1, kh kh1, kh kh2, float f)
    {
        super(cn1, kh1.ak, kh1.al, kh1.am, kh1.an, kh1.ao, kh1.ap);
        p = 0;
        q = 0;
        a = kh1;
        o = kh2;
        q = 3;
        r = f;
    }

    public void a(ho ho, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = ((float)p + f) / (float)q;
        f6 *= f6;
        double d = a.ak;
        double d1 = a.al;
        double d2 = a.am;
        double d3 = o.aI + (o.ak - o.aI) * (double)f;
        double d4 = o.aJ + (o.al - o.aJ) * (double)f + (double)r;
        double d5 = o.aK + (o.am - o.aK) * (double)f;
        double d6 = d + (d3 - d) * (double)f6;
        double d7 = d1 + (d4 - d1) * (double)f6;
        double d8 = d2 + (d5 - d2) * (double)f6;
        int i = eo.b(d6);
        int j = eo.b(d7 + (double)(aB / 2.0F));
        int k = eo.b(d8);
        float f7 = ag.c(i, j, k);
        d6 -= l;
        d7 -= m;
        d8 -= n;
        GL11.glColor4f(f7, f7, f7, 1.0F);
        kx.a.a(a, (float)d6, (float)d7, (float)d8, a.aq, f);
    }

    public void e_()
    {
        p++;
        if(p == q)
            F();
    }

    public int c()
    {
        return 3;
    }

    private kh a;
    private kh o;
    private int p;
    private int q;
    private float r;
}
