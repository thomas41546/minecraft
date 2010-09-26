package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class bo extends ag
{

    public bo(cn cn)
    {
        super(cn);
        a = false;
        u = "/mob/sheep.png";
        a(0.9F, 1.3F);
    }

    public boolean a(kh kh, int i)
    {
        if(!a && (kh instanceof ge))
        {
            a = true;
            int j = 1 + aQ.nextInt(3);
            for(int k = 0; k < j; k++)
            {
                dx dx1 = a(ly.ac.bc, 1, 1.0F);
                dx1.ao += aQ.nextFloat() * 0.05F;
                dx1.an += (aQ.nextFloat() - aQ.nextFloat()) * 0.1F;
                dx1.ap += (aQ.nextFloat() - aQ.nextFloat()) * 0.1F;
            }

        }
        return super.a(kh, i);
    }

    public void a(hm hm1)
    {
        super.a(hm1);
        hm1.a("Sheared", a);
    }

    public void b(hm hm1)
    {
        super.b(hm1);
        a = hm1.m("Sheared");
    }

    protected String c()
    {
        return "mob.sheep";
    }

    protected String d()
    {
        return "mob.sheep";
    }

    protected String e()
    {
        return "mob.sheep";
    }

    public boolean a;
}
