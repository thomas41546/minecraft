package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class kp extends lq
{

    public kp()
    {
    }

    public void a(DataInputStream datainputstream)
    {
        super.a(datainputstream);
        b = datainputstream.readByte();
        c = datainputstream.readByte();
        d = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream)
    {
        super.a(dataoutputstream);
        dataoutputstream.writeByte(((int) (b)));
        dataoutputstream.writeByte(((int) (c)));
        dataoutputstream.writeByte(((int) (d)));
    }

    public int a()
    {
        return 7;
    }
}
