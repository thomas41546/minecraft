package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class bz extends fn
{

    public bz()
    {
        j = true;
    }

    public void a(DataInputStream datainputstream)
    {
        Exception exception;
        a = datainputstream.readInt();
        b = ((int) (datainputstream.readShort()));
        c = datainputstream.readInt();
        d = datainputstream.read() + 1;
        e = datainputstream.read() + 1;
        f = datainputstream.read() + 1;
        int i = datainputstream.readInt();
        byte abyte0[] = new byte[i];
        datainputstream.readFully(abyte0);
        g = new byte[(d * e * f * 5) / 2];
        Inflater inflater = new Inflater();
        inflater.setInput(abyte0);
        try
        {
            inflater.inflate(g);
        }
        catch(DataFormatException dataformatexception)
        {
            throw new IOException("Bad compressed data format");
        }
        finally
        {
            inflater.end();
        }
        inflater.end();
        break MISSING_BLOCK_LABEL_147;
        throw exception;
    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.write(d - 1);
        dataoutputstream.write(e - 1);
        dataoutputstream.write(f - 1);
        dataoutputstream.writeInt(h);
        dataoutputstream.write(g, 0, h);
    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 17 + h;
    }

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public byte g[];
    private int h;
}
