package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class z
{

    public z(int i)
    {
        a = new byte[1024];
        c = false;
        d = 0;
        e = 1;
        f = 0;
        b = i;
    }

    public void a()
    {
    }

    public void a(ey ey1)
    {
        if(f == 0)
            GL11.glBindTexture(3553, ey1.a("/terrain.png"));
        else
        if(f == 1)
            GL11.glBindTexture(3553, ey1.a("/gui/items.png"));
    }

    public byte a[];
    public int b;
    public boolean c;
    public int d;
    public int e;
    public int f;
}
