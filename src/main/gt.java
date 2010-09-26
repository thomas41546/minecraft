package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class gt extends fn
{

    public gt()
    {
    }

    public gt(String s)
    {
        a = s;
    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readUTF();
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeUTF(a);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 4 + a.length() + 4;
    }

    public String a;
}
