package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class ol
{

    public ol(int i, int j)
    {
        a = i;
        b = j;
    }

    public int hashCode()
    {
        return a << 8 | b;
    }

    public boolean equals(Object obj)
    {
        ol ol1 = (ol)obj;
        return ol1.a == a && ol1.b == b;
    }

    public int a;
    public int b;
}
