package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class ix extends el
{

    public ix()
    {
    }

    public ix(byte byte0)
    {
        a = byte0;
    }

    void a(DataOutput dataoutput)
    {
        dataoutput.writeByte(((int) (a)));
    }

    void a(DataInput datainput)
    {
        a = datainput.readByte();
    }

    public byte a()
    {
        return 1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(((int) (a))).toString();
    }

    public byte a;
}
