package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class mh extends eh
{

    public mh()
    {
        i = true;
    }

    public mh(float f, float f1, boolean flag)
    {
        e = f;
        this.f = f1;
        g = flag;
        i = true;
    }

    public void a(DataInputStream datainputstream)
    {
        e = datainputstream.readFloat();
        f = datainputstream.readFloat();
        super.a(datainputstream);
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeFloat(e);
        dataoutputstream.writeFloat(f);
        super.a(dataoutputstream);
    }

    public int a()
    {
        return 9;
    }
}
