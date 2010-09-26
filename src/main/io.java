package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class io extends el
{

    public io()
    {
    }

    public io(int i)
    {
        a = i;
    }

    void a(DataOutput dataoutput)
    {
        dataoutput.writeInt(a);
    }

    void a(DataInput datainput)
    {
        a = datainput.readInt();
    }

    public byte a()
    {
        return 3;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(a).toString();
    }

    public int a;
}
