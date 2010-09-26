package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class hf extends fn
{

    public hf()
    {
    }

    public hf(kh kh1, int i)
    {
        a = kh1.ab;
        b = i;
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
        b = ((int) (datainputstream.readByte()));
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeByte(b);
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
}
