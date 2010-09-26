package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class is extends lq
{

    public is()
    {
        g = true;
    }

    public void a(DataInputStream datainputstream)
    {
        super.a(datainputstream);
        b = datainputstream.readByte();
        c = datainputstream.readByte();
        d = datainputstream.readByte();
        e = datainputstream.readByte();
        f = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream)
    {
        super.a(dataoutputstream);
        dataoutputstream.writeByte(((int) (b)));
        dataoutputstream.writeByte(((int) (c)));
        dataoutputstream.writeByte(((int) (d)));
        dataoutputstream.writeByte(((int) (e)));
        dataoutputstream.writeByte(((int) (f)));
    }

    public int a()
    {
        return 9;
    }
}
