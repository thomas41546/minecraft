package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class an extends mm
{

    public an(ee ee, gh gh1, gh gh2, int i, int j, int k)
    {
        super(ee, gh2, i, j, k);
        c = gh1;
    }

    public boolean a(ev ev)
    {
        return false;
    }

    public void a()
    {
        for(int i = 0; i < c.c(); i++)
            if(c.c(i) != null)
                c.a(i, 1);

    }

    private final gh c;
}
