package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class jg extends di
{

    public jg(int i)
    {
        super(i);
        aT = 1;
    }

    public ev a(ev ev, cn cn1, dm dm1)
    {
        if(dm1.b.b(di.j.aS))
        {
            cn1.a(((kh) (dm1)), "random.bow", 1.0F, 1.0F / (b.nextFloat() * 0.4F + 0.8F));
            cn1.a(((kh) (new kg(cn1, ((ge) (dm1))))));
        }
        return ev;
    }
}
