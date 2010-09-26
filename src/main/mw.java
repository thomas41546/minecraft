package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class mw
    implements gh
{

    public mw()
    {
        a = new ev[1];
    }

    public int c()
    {
        return 1;
    }

    public ev c(int i)
    {
        return a[i];
    }

    public String d()
    {
        return "Result";
    }

    public ev a(int i, int j)
    {
        if(a[i] != null)
        {
            ev ev1 = a[i];
            a[i] = null;
            return ev1;
        } else
        {
            return null;
        }
    }

    public void a(int i, ev ev1)
    {
        a[i] = ev1;
    }

    public int e()
    {
        return 64;
    }

    public void j_()
    {
    }

    private ev a[];
}
