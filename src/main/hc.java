package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


final class hc
{

    public hc(int i, int j)
    {
        a = i;
        b = j;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof hc)
        {
            hc hc1 = (hc)obj;
            return a == hc1.a && b == hc1.b;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return a << 16 ^ b;
    }

    public final int a;
    public final int b;
}
