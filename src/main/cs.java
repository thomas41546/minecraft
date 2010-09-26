package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class cs extends ly
{

    protected cs(int i)
    {
        super(i, gb.c);
        bb = 59;
    }

    public int a(int i)
    {
        if(i == 1)
            return bb - 16;
        if(i == 0)
            return ly.y.a(0);
        if(i == 2 || i == 4)
            return bb + 1;
        else
            return bb;
    }

    public boolean a(cn cn, int i, int j, int k, dm dm1)
    {
        dm1.l();
        return true;
    }
}
