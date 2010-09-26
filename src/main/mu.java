package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class mu
{

    public mu(int i)
    {
        a = new byte[i >> 1];
    }

    public mu(byte abyte0[])
    {
        a = abyte0;
    }

    public int a(int i, int j, int k)
    {
        int l = i << 11 | k << 7 | j;
        int i1 = l >> 1;
        int j1 = l & 1;
        if(j1 == 0)
            return a[i1] & 0xf;
        else
            return a[i1] >> 4 & 0xf;
    }

    public void a(int i, int j, int k, int l)
    {
        int i1 = i << 11 | k << 7 | j;
        int j1 = i1 >> 1;
        int k1 = i1 & 1;
        if(k1 == 0)
            a[j1] = (byte)(a[j1] & 0xf0 | l & 0xf);
        else
            a[j1] = (byte)(a[j1] & 0xf | (l & 0xf) << 4);
    }

    public boolean a()
    {
        return a != null;
    }

    public final byte a[];
}
