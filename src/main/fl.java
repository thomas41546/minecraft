package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;

public class fl extends Thread
{

    public fl(Minecraft minecraft, String s)
    {
        a = minecraft;
        super(s);
        setDaemon(true);
        start();
    }

    public void run()
    {
        while(a.F) 
            try
            {
                Thread.sleep(0x7fffffffL);
            }
            catch(InterruptedException interruptedexception) { }
    }

    final Minecraft a;
}
