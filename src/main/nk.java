package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


class nk extends Thread
{

    nk(ii ii1, String s)
    {
        a = ii1;
        super(s);
    }

    public void run()
    {
        synchronized(ii.a)
        {
            ii.c++;
        }
        for(; ii.a(a); ii.d(a));
        synchronized(ii.a)
        {
            ii.c--;
        }
        break MISSING_BLOCK_LABEL_105;
        Exception exception2;
        exception2;
        synchronized(ii.a)
        {
            ii.c--;
        }
        throw exception2;
    }

    final ii a;
}
