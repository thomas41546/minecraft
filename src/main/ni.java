package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


class ni extends Thread
{

    ni(ii ii1, String s)
    {
        a = ii1;
        super(s);
    }

    public void run()
    {
        synchronized(ii.a)
        {
            ii.b++;
        }
        for(; ii.a(a) && !ii.b(a); ii.c(a));
        synchronized(ii.a)
        {
            ii.b--;
        }
        break MISSING_BLOCK_LABEL_115;
        Exception exception2;
        exception2;
        synchronized(ii.a)
        {
            ii.b--;
        }
        throw exception2;
    }

    final ii a;
}
