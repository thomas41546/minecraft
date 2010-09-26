package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class ka extends fn
{

    public ka()
    {
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
        b = datainputstream.readInt();
        c = datainputstream.read() != 0;
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeInt(b);
        dataoutputstream.write(c ? 1 : 0);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 9;
    }

    public int a;
    public int b;
    public boolean c;
}
