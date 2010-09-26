package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class am extends ag
{

    public am(cn cn)
    {
        super(cn);
        a = false;
        u = "/mob/cow.png";
        a(0.9F, 1.3F);
    }

    public void a(hm hm)
    {
        super.a(hm);
    }

    public void b(hm hm)
    {
        super.b(hm);
    }

    protected String c()
    {
        return "mob.cow";
    }

    protected String d()
    {
        return "mob.cowhurt";
    }

    protected String e()
    {
        return "mob.cowhurt";
    }

    protected float f()
    {
        return 0.4F;
    }

    protected int g()
    {
        return di.aD.aS;
    }

    public boolean a(dm dm1)
    {
        ev ev1 = dm1.b.a();
        if(ev1 != null && ev1.c == di.au.aS)
        {
            dm1.b.a(dm1.b.d, new ev(di.aE));
            return true;
        } else
        {
            return false;
        }
    }

    public boolean a;
}
