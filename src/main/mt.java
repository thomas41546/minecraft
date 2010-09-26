package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class mt
{

    public mt(int i, int j, int k)
    {
        a = i;
        b = j;
        c = k;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof mt)
        {
            mt mt1 = (mt)obj;
            return mt1.a == a && mt1.b == b && mt1.c == c;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return a * 0x88f9fa + b * 0xef88b + c;
    }

    public final int a;
    public final int b;
    public final int c;
}
