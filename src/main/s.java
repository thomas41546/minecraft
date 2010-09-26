package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class s extends eh
{

    public s()
    {
        h = true;
    }

    public s(double d, double d1, double d2, double d3, boolean flag)
    {
        a = d;
        b = d1;
        this.d = d2;
        c = d3;
        g = flag;
        h = true;
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readDouble();
        b = datainputstream.readDouble();
        d = datainputstream.readDouble();
        c = datainputstream.readDouble();
        super.a(datainputstream);
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeDouble(a);
        dataoutputstream.writeDouble(b);
        dataoutputstream.writeDouble(d);
        dataoutputstream.writeDouble(c);
        super.a(dataoutputstream);
    }

    public int a()
    {
        return 33;
    }
}
