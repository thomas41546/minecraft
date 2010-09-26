package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class eh extends fn
{

    public eh()
    {
    }

    public eh(boolean flag)
    {
        g = flag;
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public void a(DataInputStream datainputstream)
    {
        g = datainputstream.read() != 0;
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.write(g ? 1 : 0);
    }

    public int a()
    {
        return 1;
    }

    public double a;
    public double b;
    public double c;
    public double d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public boolean i;
}
