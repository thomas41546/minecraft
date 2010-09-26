package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class gn extends el
{

    public gn()
    {
    }

    public gn(long l)
    {
        a = l;
    }

    void a(DataOutput dataoutput)
    {
        dataoutput.writeLong(a);
    }

    void a(DataInput datainput)
    {
        a = datainput.readLong();
    }

    public byte a()
    {
        return 4;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(a).toString();
    }

    public long a;
}
