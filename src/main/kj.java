package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class kj extends fn
{

    public kj()
    {
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
        e = ((int) (datainputstream.readByte()));
        b = datainputstream.readInt();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeByte(e);
        dataoutputstream.writeInt(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 17;
    }

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
}
