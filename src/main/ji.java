package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class ji extends fn
{

    public ji()
    {
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
        b = datainputstream.readInt();
        c = datainputstream.readInt();
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeInt(b);
        dataoutputstream.writeInt(c);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 12;
    }

    public int a;
    public int b;
    public int c;
}
