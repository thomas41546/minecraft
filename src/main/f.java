package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class f extends el
{

    public f()
    {
    }

    public f(float f1)
    {
        a = f1;
    }

    void a(DataOutput dataoutput)
    {
        dataoutput.writeFloat(a);
    }

    void a(DataInput datainput)
    {
        a = datainput.readFloat();
    }

    public byte a()
    {
        return 5;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(a).toString();
    }

    public float a;
}
