package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Comparator;

public class fb
    implements Comparator
{

    public fb(kh kh)
    {
        a = kh;
    }

    public int a(bn bn1, bn bn2)
    {
        return bn1.a(a) >= bn2.a(a) ? 1 : -1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return a((bn)obj, (bn)obj1);
    }

    private kh a;
}
