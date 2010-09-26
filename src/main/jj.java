package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.image.BufferedImage;

public class jj
{

    public jj(cn cn, int i, int j)
    {
        e = false;
        f = false;
        g = 0;
        h = false;
        b = cn;
        a(i, j);
    }

    public void a(int i, int j)
    {
        e = false;
        c = i;
        d = j;
        g = 0;
        h = false;
    }

    public void a(cn cn, int i, int j)
    {
        b = cn;
        a(i, j);
    }

    public BufferedImage a;
    public cn b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;
    public boolean h;
}
