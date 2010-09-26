package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class lq extends fn
{

    public lq()
    {
        g = false;
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 4;
    }

    public int a;
    public byte b;
    public byte c;
    public byte d;
    public byte e;
    public byte f;
    public boolean g;
}
