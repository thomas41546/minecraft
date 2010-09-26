package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class ld extends fn
{

    public ld()
    {
    }

    public void a(DataInputStream datainputstream)
    {
        a = ((int) (datainputstream.readShort()));
        b = ((int) (datainputstream.readByte()));
        c = ((int) (datainputstream.readShort()));
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeShort(a);
        dataoutputstream.writeByte(b);
        dataoutputstream.writeShort(c);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 5;
    }

    public int a;
    public int b;
    public int c;
}
