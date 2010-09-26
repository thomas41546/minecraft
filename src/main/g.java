package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

public class g extends Minecraft
{

    public g(MinecraftApplet minecraftapplet, Component component, Canvas canvas, MinecraftApplet minecraftapplet1, int i, int j, boolean flag)
    {
        a = minecraftapplet;
        super(component, canvas, minecraftapplet1, i, j, flag);
    }

    public void a(go go)
    {
        a.removeAll();
        a.setLayout(((java.awt.LayoutManager) (new BorderLayout())));
        a.add(((Component) (new aq(go))), "Center");
        a.validate();
    }

    final MinecraftApplet a;
}
