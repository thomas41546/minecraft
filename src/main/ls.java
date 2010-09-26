package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class ls extends el
{

    public ls()
    {
    }

    public ls(short word0)
    {
        a = word0;
    }

    void a(DataOutput dataoutput)
    {
        dataoutput.writeShort(((int) (a)));
    }

    void a(DataInput datainput)
    {
        a = datainput.readShort();
    }

    public byte a()
    {
        return 2;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(((int) (a))).toString();
    }

    public short a;
}
