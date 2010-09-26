package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.minecraft.client.Minecraft;

public final class fp extends WindowAdapter
{

    public fp(Minecraft minecraft, Thread thread)
    {
        a = minecraft;
        b = thread;
        super();
    }

    public void windowClosing(WindowEvent windowevent)
    {
        a.d();
        try
        {
            b.join();
        }
        catch(InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        System.exit(0);
    }

    final Minecraft a;
    final Thread b;
}
