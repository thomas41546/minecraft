package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

public final class fm extends Minecraft
{

    public fm(Component component, Canvas canvas, MinecraftApplet minecraftapplet, int i, int j, boolean flag, Frame frame)
    {
        a = frame;
        super(component, canvas, minecraftapplet, i, j, flag);
    }

    public void a(go go)
    {
        a.removeAll();
        a.add(((Component) (new aq(go))), "Center");
        a.validate();
    }

    final Frame a;
}
