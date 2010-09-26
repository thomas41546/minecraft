package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class bp extends di
{

    public bp(int i)
    {
        super(i);
        aT = 16;
    }

    public ev a(ev ev1, cn cn1, dm dm)
    {
        ev1.a--;
        cn1.a(((kh) (dm)), "random.bow", 0.5F, 0.4F / (b.nextFloat() * 0.4F + 0.8F));
        cn1.a(((kh) (new ao(cn1, ((ge) (dm))))));
        return ev1;
    }
}
