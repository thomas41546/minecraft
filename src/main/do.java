// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class do extends fn
{

    public do()
    {
    }

    public do(int i, int j, int k, int l, int i1)
    {
        a = i;
        b = j;
        c = k;
        d = l;
        e = i1;
    }

    public void a(DataInputStream datainputstream)
    {
        a = ((int) (datainputstream.readShort()));
        b = datainputstream.readInt();
        c = datainputstream.read();
        d = datainputstream.readInt();
        e = datainputstream.read();
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeShort(a);
        dataoutputstream.writeInt(b);
        dataoutputstream.write(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.write(e);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 12;
    }

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
}
