// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package net.minecraft.isom;

import ad;
import java.applet.Applet;
import java.awt.BorderLayout;

public class IsomPreviewApplet extends Applet
{

    public IsomPreviewApplet()
    {
        a = new ad();
        setLayout(((java.awt.LayoutManager) (new BorderLayout())));
        add(((java.awt.Component) (a)), "Center");
    }

    public void start()
    {
        a.b();
    }

    public void stop()
    {
        a.c();
    }

    private ad a;
}
