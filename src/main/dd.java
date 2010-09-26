package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class dd extends dq
{

    public dd(cn cn1)
    {
        super(cn1);
        c = 30;
        d = -1;
        u = "/mob/creeper.png";
    }

    public void a(hm hm)
    {
        super.a(hm);
    }

    public void b(hm hm)
    {
        super.b(hm);
    }

    protected void b_()
    {
        b = a;
        if(a > 0 && d < 0)
            a--;
        if(d >= 0)
            d = 2;
        super.b_();
        if(d != 1)
            d = -1;
    }

    protected String d()
    {
        return "mob.creeper";
    }

    protected String e()
    {
        return "mob.creeperdeath";
    }

    public void b(kh kh)
    {
        super.b(kh);
        if(kh instanceof cw)
            b(di.aQ.aS + aQ.nextInt(2), 1);
    }

    protected void a(kh kh, float f)
    {
        if(d <= 0 && f < 3F || d > 0 && f < 7F)
        {
            if(a == 0)
                ag.a(((kh) (this)), "random.fuse", 1.0F, 0.5F);
            d = 1;
            a++;
            if(a == c)
            {
                ag.a(((kh) (this)), ak, al, am, 3F);
                F();
            }
            g = true;
        }
    }

    public float b(float f)
    {
        return ((float)b + (float)(a - b) * f) / (float)(c - 2);
    }

    protected int g()
    {
        return di.K.aS;
    }

    int a;
    int b;
    int c;
    int d;
}
