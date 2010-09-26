package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.PrintStream;

public class nt extends dm
{

    public nt(cn cn, String s)
    {
        super(cn);
        a = 0.0F;
        i = s;
        aB = 0.0F;
        aM = 0.0F;
        if(s != null && s.length() > 0)
        {
            aY = (new StringBuilder()).append("http://www.minecraft.net/skin/").append(s).append(".png").toString();
            System.out.println((new StringBuilder()).append("Loading texture ").append(aY).toString());
        }
        aN = true;
        ac = 10D;
    }

    public boolean a(kh kh, int i)
    {
        return true;
    }

    public void a(double d, double d1, double d2, float f, 
            float f1, int i)
    {
        aB = 0.0F;
        bh = d;
        bi = d1;
        bj = d2;
        bk = f;
        bl = f1;
        bg = i;
    }

    public void e_()
    {
        super.e_();
        Q = R;
        double d = ak - ah;
        double d1 = am - aj;
        float f = eo.a(d * d + d1 * d1) * 4F;
        if(f > 1.0F)
            f = 1.0F;
        R += (f - R) * 0.4F;
        S += R;
    }

    public float h_()
    {
        return 0.0F;
    }

    public void j()
    {
        super.b_();
        if(bg > 0)
        {
            double d = ak + (bh - ak) / (double)bg;
            double d1 = al + (bi - al) / (double)bg;
            double d2 = am + (bj - am) / (double)bg;
            double d3;
            for(d3 = bk - (double)aq; d3 < -180D; d3 += 360D);
            for(; d3 >= 180D; d3 -= 360D);
            aq += ((float) (d3 / (double)bg));
            ar += ((float) ((bl - (double)ar) / (double)bg));
            bg--;
            a(d, d1, d2);
            c(aq, ar);
        }
        e = this.f;
        float f = eo.a(an * an + ap * ap);
        float f1 = (float)Math.atan(-ao * 0.20000000298023224D) * 15F;
        if(f > 0.1F)
            f = 0.1F;
        if(!av || E <= 0)
            f = 0.0F;
        if(av || E <= 0)
            f1 = 0.0F;
        this.f += (f - this.f) * 0.4F;
        M += (f1 - M) * 0.8F;
    }

    private int bg;
    private double bh;
    private double bi;
    private double bj;
    private double bk;
    private double bl;
    float a;
}
