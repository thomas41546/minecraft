package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class mv extends ag
{

    public mv(cn cn)
    {
        super(cn);
        a = false;
        u = "/mob/pig.png";
        a(0.9F, 0.9F);
        a = false;
    }

    public void a(hm hm1)
    {
        super.a(hm1);
        hm1.a("Saddle", a);
    }

    public void b(hm hm1)
    {
        super.b(hm1);
        a = hm1.m("Saddle");
    }

    protected String c()
    {
        return "mob.pig";
    }

    protected String d()
    {
        return "mob.pig";
    }

    protected String e()
    {
        return "mob.pigdeath";
    }

    public boolean a(dm dm1)
    {
        if(a)
        {
            dm1.g(((kh) (this)));
            return true;
        } else
        {
            return false;
        }
    }

    protected int g()
    {
        return di.ao.aS;
    }

    public boolean a;
}
