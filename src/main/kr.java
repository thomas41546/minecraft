package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class kr extends el
{

    public kr()
    {
    }

    public kr(double d)
    {
        a = d;
    }

    void a(DataOutput dataoutput)
    {
        dataoutput.writeDouble(a);
    }

    void a(DataInput datainput)
    {
        a = datainput.readDouble();
    }

    public byte a()
    {
        return 6;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(a).toString();
    }

    public double a;
}
