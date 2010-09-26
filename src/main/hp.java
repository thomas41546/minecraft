package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class hp extends fn
{

    public hp()
    {
    }

    public hp(String s, String s1, int i)
    {
        b = s;
        c = s1;
        a = i;
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
        b = datainputstream.readUTF();
        c = datainputstream.readUTF();
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeUTF(b);
        dataoutputstream.writeUTF(c);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 4 + b.length() + c.length() + 4;
    }

    public int a;
    public String b;
    public String c;
}
