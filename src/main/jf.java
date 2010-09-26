package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class jf
    implements Comparable
{

    public jf(int i, int j, int k, int l)
    {
        g = f++;
        a = i;
        b = j;
        c = k;
        d = l;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof jf)
        {
            jf jf1 = (jf)obj;
            return a == jf1.a && b == jf1.b && c == jf1.c && d == jf1.d;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return (a * 128 * 1024 + c * 128 + b) * 256 + d;
    }

    public jf a(long l)
    {
        e = l;
        return this;
    }

    public int a(jf jf1)
    {
        if(e < jf1.e)
            return -1;
        if(e > jf1.e)
            return 1;
        if(g < jf1.g)
            return -1;
        return g <= jf1.g ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return a((jf)obj);
    }

    private static long f = 0L;
    public int a;
    public int b;
    public int c;
    public int d;
    public long e;
    private long g;

}
