package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class dy extends el
{

    public dy()
    {
    }

    public dy(byte abyte0[])
    {
        a = abyte0;
    }

    void a(DataOutput dataoutput)
    {
        dataoutput.writeInt(a.length);
        dataoutput.write(a);
    }

    void a(DataInput datainput)
    {
        int i = datainput.readInt();
        a = new byte[i];
        datainput.readFully(a);
    }

    public byte a()
    {
        return 7;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[").append(a.length).append(" bytes]").toString();
    }

    public byte a[];
}
