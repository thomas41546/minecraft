package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.PrintStream;
import net.minecraft.client.Minecraft;

public class la extends bi
{

    public la(Minecraft minecraft, cn cn, dl dl, gy gy1)
    {
        super(minecraft, cn, dl);
        bh = 0;
        bo = new eu(((dm) (null)));
        bg = gy1;
    }

    public void e_()
    {
        super.e_();
        J();
    }

    public void n()
    {
        J();
    }

    public void J()
    {
        if(bh++ == 20)
        {
            if(!b.a(bo))
            {
                bg.a(((fn) (new m(-1, b.a))));
                bg.a(((fn) (new m(-2, b.c))));
                bg.a(((fn) (new m(-3, b.b))));
                bo = b.i();
            }
            bh = 0;
        }
        double d = ak - bi;
        double d1 = au.b - bj;
        double d2 = al - bk;
        double d3 = am - bl;
        double d4 = aq - bm;
        double d5 = ar - bn;
        boolean flag = d1 != 0.0D || d2 != 0.0D || d != 0.0D || d3 != 0.0D;
        boolean flag1 = d4 != 0.0D || d5 != 0.0D;
        if(flag && flag1)
            bg.a(((fn) (new ch(ak, au.b, al, am, aq, ar, av))));
        else
        if(flag)
            bg.a(((fn) (new s(ak, au.b, al, am, av))));
        else
        if(flag1)
            bg.a(((fn) (new mh(aq, ar, av))));
        else
            bg.a(((fn) (new eh(av))));
        if(flag)
        {
            bi = ak;
            bj = au.b;
            bk = al;
            bl = am;
        }
        if(flag1)
        {
            bm = aq;
            bn = ar;
        }
    }

    protected void a(dx dx1)
    {
        System.out.println("Dropping?");
        ha ha1 = new ha(dx1);
        bg.a(((fn) (ha1)));
        dx1.ak = (double)ha1.b / 32D;
        dx1.al = (double)ha1.c / 32D;
        dx1.am = (double)ha1.d / 32D;
        dx1.an = (double)ha1.e / 128D;
        dx1.ao = (double)ha1.f / 128D;
        dx1.ap = (double)ha1.g / 128D;
    }

    public void a(String s1)
    {
        bg.a(((fn) (new ij(s1))));
    }

    public void w()
    {
        super.w();
        bg.a(((fn) (new hf(((kh) (this)), 1))));
    }

    private gy bg;
    private int bh;
    private double bi;
    private double bj;
    private double bk;
    private double bl;
    private float bm;
    private float bn;
    private eu bo;
}
