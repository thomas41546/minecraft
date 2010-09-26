package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class jl extends fn
{

    public jl()
    {
    }

    public jl(kh kh1)
    {
        a = kh1.ab;
        b = eo.b(kh1.ak * 32D);
        c = eo.b(kh1.al * 32D);
        d = eo.b(kh1.am * 32D);
        e = (byte)(int)((kh1.aq * 256F) / 360F);
        f = (byte)(int)((kh1.ar * 256F) / 360F);
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
        b = datainputstream.readInt();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
        e = (byte)datainputstream.read();
        f = (byte)datainputstream.read();
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeInt(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.write(((int) (e)));
        dataoutputstream.write(((int) (f)));
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 34;
    }

    public int a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public byte f;
}
