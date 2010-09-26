package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


class lh extends Thread
{

    lh(ad ad1)
    {
        a = ad1;
        super();
    }

    public void run()
    {
        while(ad.a(a)) 
        {
            a.d();
            try
            {
                Thread.sleep(1L);
            }
            catch(Exception exception) { }
        }
    }

    final ad a;
}
