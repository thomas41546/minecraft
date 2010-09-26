package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class ne extends el
{

    public ne()
    {
    }

    public ne(String s)
    {
        a = s;
        if(s == null)
            throw new IllegalArgumentException("Empty string not allowed");
        else
            return;
    }

    void a(DataOutput dataoutput)
    {
        dataoutput.writeUTF(a);
    }

    void a(DataInput datainput)
    {
        a = datainput.readUTF();
    }

    public byte a()
    {
        return 8;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(a).toString();
    }

    public String a;
}
