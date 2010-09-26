package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class mb extends dq
{

    public mb(cn cn1)
    {
        super(cn1);
        u = "/mob/zombie.png";
        aa = 0.5F;
        e = 5;
    }

    public void j()
    {
        if(ag.b())
        {
            float f = a(1.0F);
            if(f > 0.5F && ag.i(eo.b(ak), eo.b(al), eo.b(am)) && aQ.nextFloat() * 30F < (f - 0.4F) * 2.0F)
                aT = 300;
        }
        super.j();
    }

    protected String c()
    {
        return "mob.zombie";
    }

    protected String d()
    {
        return "mob.zombiehurt";
    }

    protected String e()
    {
        return "mob.zombiedeath";
    }

    protected int g()
    {
        return di.J.aS;
    }
}
