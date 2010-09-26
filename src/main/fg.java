package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class fg extends fn
{

    public fg()
    {
    }

    public fg(int i, int j, int k, int l, int i1)
    {
        e = i;
        a = j;
        b = k;
        c = l;
        d = i1;
    }

    public void a(DataInputStream datainputstream)
    {
        e = datainputstream.read();
        a = datainputstream.readInt();
        b = datainputstream.read();
        c = datainputstream.readInt();
        d = datainputstream.read();
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.write(e);
        dataoutputstream.writeInt(a);
        dataoutputstream.write(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.write(d);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 11;
    }

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
}
