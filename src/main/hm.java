package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;
import java.util.*;

public class hm extends el
{

    public hm()
    {
        a = ((Map) (new HashMap()));
    }

    void a(DataOutput dataoutput)
    {
        el el1;
        for(Iterator iterator = a.values().iterator(); iterator.hasNext(); el.a(el1, dataoutput))
            el1 = (el)iterator.next();

        dataoutput.writeByte(0);
    }

    void a(DataInput datainput)
    {
        a.clear();
        el el1;
        for(; (el1 = el.b(datainput)).a() != 0; a.put(((Object) (el1.b())), ((Object) (el1))));
    }

    public byte a()
    {
        return 10;
    }

    public void a(String s, el el1)
    {
        a.put(((Object) (s)), ((Object) (el1.a(s))));
    }

    public void a(String s, byte byte0)
    {
        a.put(((Object) (s)), ((Object) ((new ix(byte0)).a(s))));
    }

    public void a(String s, short word0)
    {
        a.put(((Object) (s)), ((Object) ((new ls(word0)).a(s))));
    }

    public void a(String s, int i1)
    {
        a.put(((Object) (s)), ((Object) ((new io(i1)).a(s))));
    }

    public void a(String s, long l1)
    {
        a.put(((Object) (s)), ((Object) ((new gn(l1)).a(s))));
    }

    public void a(String s, float f1)
    {
        a.put(((Object) (s)), ((Object) ((new f(f1)).a(s))));
    }

    public void a(String s, double d1)
    {
        a.put(((Object) (s)), ((Object) ((new kr(d1)).a(s))));
    }

    public void a(String s, String s1)
    {
        a.put(((Object) (s)), ((Object) ((new ne(s1)).a(s))));
    }

    public void a(String s, byte abyte0[])
    {
        a.put(((Object) (s)), ((Object) ((new dy(abyte0)).a(s))));
    }

    public void a(String s, hm hm1)
    {
        a.put(((Object) (s)), ((Object) (hm1.a(s))));
    }

    public void a(String s, boolean flag)
    {
        a(s, ((byte)(flag ? 1 : 0)));
    }

    public boolean b(String s)
    {
        return a.containsKey(((Object) (s)));
    }

    public byte c(String s)
    {
        if(!a.containsKey(((Object) (s))))
            return 0;
        else
            return ((ix)a.get(((Object) (s)))).a;
    }

    public short d(String s)
    {
        if(!a.containsKey(((Object) (s))))
            return 0;
        else
            return ((ls)a.get(((Object) (s)))).a;
    }

    public int e(String s)
    {
        if(!a.containsKey(((Object) (s))))
            return 0;
        else
            return ((io)a.get(((Object) (s)))).a;
    }

    public long f(String s)
    {
        if(!a.containsKey(((Object) (s))))
            return 0L;
        else
            return ((gn)a.get(((Object) (s)))).a;
    }

    public float g(String s)
    {
        if(!a.containsKey(((Object) (s))))
            return 0.0F;
        else
            return ((f)a.get(((Object) (s)))).a;
    }

    public double h(String s)
    {
        if(!a.containsKey(((Object) (s))))
            return 0.0D;
        else
            return ((kr)a.get(((Object) (s)))).a;
    }

    public String i(String s)
    {
        if(!a.containsKey(((Object) (s))))
            return "";
        else
            return ((ne)a.get(((Object) (s)))).a;
    }

    public byte[] j(String s)
    {
        if(!a.containsKey(((Object) (s))))
            return new byte[0];
        else
            return ((dy)a.get(((Object) (s)))).a;
    }

    public hm k(String s)
    {
        if(!a.containsKey(((Object) (s))))
            return new hm();
        else
            return (hm)a.get(((Object) (s)));
    }

    public ki l(String s)
    {
        if(!a.containsKey(((Object) (s))))
            return new ki();
        else
            return (ki)a.get(((Object) (s)));
    }

    public boolean m(String s)
    {
        return c(s) != 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(a.size()).append(" entries").toString();
    }

    private Map a;
}
