package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class ny extends fn
{

    public ny()
    {
        j = true;
    }

    public ny(int i, int j, int k, ic ic1)
    {
        this.j = true;
        a = i;
        b = j;
        c = k;
        e = new hm();
        ic1.b(e);
        try
        {
            d = x.a(e);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
        b = ((int) (datainputstream.readShort()));
        c = datainputstream.readInt();
        int i = datainputstream.readShort() & 0xffff;
        d = new byte[i];
        datainputstream.readFully(d);
        e = x.a(d);
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeShort(((int) ((short)d.length)));
        dataoutputstream.write(d);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return d.length + 2 + 10;
    }

    public int a;
    public int b;
    public int c;
    public byte d[];
    public hm e;
}
