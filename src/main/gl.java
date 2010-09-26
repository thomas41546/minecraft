package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Comparator;

public class gl
    implements Comparator
{

    public gl(dm dm)
    {
        a = dm;
    }

    public int a(bn bn1, bn bn2)
    {
        boolean flag = bn1.o;
        boolean flag1 = bn2.o;
        if(flag && !flag1)
            return 1;
        if(flag1 && !flag)
            return -1;
        else
            return bn1.a(((kh) (a))) >= bn2.a(((kh) (a))) ? -1 : 1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return a((bn)obj, (bn)obj1);
    }

    private dm a;
}
