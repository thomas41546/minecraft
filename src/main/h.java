package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.Canvas;
import net.minecraft.client.MinecraftApplet;

public class h extends Canvas
{

    public h(MinecraftApplet minecraftapplet)
    {
        a = minecraftapplet;
        super();
    }

    public synchronized void addNotify()
    {
        super.addNotify();
        a.a();
    }

    public synchronized void removeNotify()
    {
        a.b();
        super.removeNotify();
    }

    final MinecraftApplet a;
}
