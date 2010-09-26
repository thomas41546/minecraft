package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class dz extends fn
{

    public dz()
    {
    }

    public dz(int i, int j)
    {
        a = i;
        b = j;
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
        b = ((int) (datainputstream.readShort()));
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 6;
    }

    public int a;
    public int b;
}
