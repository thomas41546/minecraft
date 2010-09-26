package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class na extends fn
{

    public na()
    {
        j = true;
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
        b = datainputstream.readInt();
        f = datainputstream.readShort() & 0xffff;
        c = new short[f];
        d = new byte[f];
        e = new byte[f];
        for(int i = 0; i < f; i++)
            c[i] = datainputstream.readShort();

        datainputstream.readFully(d);
        datainputstream.readFully(e);
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeInt(b);
        dataoutputstream.writeShort(((int) ((short)f)));
        for(int i = 0; i < f; i++)
            dataoutputstream.writeShort(((int) (c[i])));

        dataoutputstream.write(d);
        dataoutputstream.write(e);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 10 + f * 4;
    }

    public int a;
    public int b;
    public short c[];
    public byte d[];
    public byte e[];
    public int f;
}
