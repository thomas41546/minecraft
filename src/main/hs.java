package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class hs
    implements gh
{

    public hs(String s, gh gh1, gh gh2)
    {
        a = s;
        b = gh1;
        c = gh2;
    }

    public int c()
    {
        return b.c() + c.c();
    }

    public String d()
    {
        return a;
    }

    public ev c(int i)
    {
        if(i >= b.c())
            return c.c(i - b.c());
        else
            return b.c(i);
    }

    public ev a(int i, int j)
    {
        if(i >= b.c())
            return c.a(i - b.c(), j);
        else
            return b.a(i, j);
    }

    public void a(int i, ev ev)
    {
        if(i >= b.c())
            c.a(i - b.c(), ev);
        else
            b.a(i, ev);
    }

    public int e()
    {
        return b.e();
    }

    public void j_()
    {
        b.j_();
        c.j_();
    }

    private String a;
    private gh b;
    private gh c;
}
