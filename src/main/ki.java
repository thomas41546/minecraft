package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ki extends el
{

    public ki()
    {
        a = ((List) (new ArrayList()));
    }

    void a(DataOutput dataoutput)
    {
        if(a.size() > 0)
            b = ((el)a.get(0)).a();
        else
            b = 1;
        dataoutput.writeByte(((int) (b)));
        dataoutput.writeInt(a.size());
        for(int i = 0; i < a.size(); i++)
            ((el)a.get(i)).a(dataoutput);

    }

    void a(DataInput datainput)
    {
        b = datainput.readByte();
        int i = datainput.readInt();
        a = ((List) (new ArrayList()));
        for(int j = 0; j < i; j++)
        {
            el el1 = el.a(b);
            el1.a(datainput);
            a.add(((Object) (el1)));
        }

    }

    public byte a()
    {
        return 9;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(a.size()).append(" entries of type ").append(el.b(b)).toString();
    }

    public void a(el el1)
    {
        b = el1.a();
        a.add(((Object) (el1)));
    }

    public el a(int i)
    {
        return (el)a.get(i);
    }

    public int c()
    {
        return a.size();
    }

    private List a;
    private byte b;
}
