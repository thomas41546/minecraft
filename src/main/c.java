package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class c extends ly
{

    public c(int i, int j)
    {
        super(i, gb.e);
        bb = j;
    }

    public int a(int i)
    {
        if(i == 1)
            return bb - 16;
        if(i == 0)
            return bb + 16;
        else
            return bb;
    }
}
