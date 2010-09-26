package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;

public class m extends fn
{

    public m()
    {
    }

    public m(int i, ev aev[])
    {
        a = i;
        b = new ev[aev.length];
        for(int j = 0; j < b.length; j++)
            b[j] = aev[j] != null ? aev[j].e() : null;

    }

    public void a(DataInputStream datainputstream)
    {
        a = datainputstream.readInt();
        short word0 = datainputstream.readShort();
        b = new ev[word0];
        for(int i = 0; i < word0; i++)
        {
            short word1 = datainputstream.readShort();
            if(word1 >= 0)
            {
                byte byte0 = datainputstream.readByte();
                short word2 = datainputstream.readShort();
                b[i] = new ev(((int) (word1)), ((int) (byte0)), ((int) (word2)));
            }
        }

    }

    public void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b.length);
        for(int i = 0; i < b.length; i++)
            if(b[i] == null)
            {
                dataoutputstream.writeShort(-1);
            } else
            {
                dataoutputstream.writeShort(((int) ((short)b[i].c)));
                dataoutputstream.writeByte(((int) ((byte)b[i].a)));
                dataoutputstream.writeShort(((int) ((short)b[i].d)));
            }

    }

    public void a(lb lb1)
    {
        lb1.a(this);
    }

    public int a()
    {
        return 6 + b.length * 5;
    }

    public int a;
    public ev b[];
}
