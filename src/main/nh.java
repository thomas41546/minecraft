package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


class nh extends Thread
{

    nh(ii ii1)
    {
        a = ii1;
        super();
    }

    public void run()
    {
        try
        {
            Thread.sleep(5000L);
            if(ii.e(a).isAlive())
                try
                {
                    ii.e(a).stop();
                }
                catch(Throwable throwable) { }
            if(ii.f(a).isAlive())
                try
                {
                    ii.f(a).stop();
                }
                catch(Throwable throwable1) { }
        }
        catch(InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }

    final ii a;
}
