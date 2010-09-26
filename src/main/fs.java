package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Comparator;

class fs
    implements Comparator
{

    fs(dw dw1)
    {
        a = dw1;
        super();
    }

    public int a(bv bv1, bv bv2)
    {
        if(bv2.a() < bv1.a())
            return -1;
        return bv2.a() <= bv1.a() ? 0 : 1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return a((bv)obj, (bv)obj1);
    }

    final dw a;
}
