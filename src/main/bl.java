package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class bl
{

    public bl(a aa[])
    {
        b = aa;
        a = aa.length;
    }

    public void a()
    {
        c++;
    }

    public boolean b()
    {
        return c >= b.length;
    }

    public aj a(kh kh1)
    {
        double d = (double)b[c].a + (double)(int)(kh1.aC + 1.0F) * 0.5D;
        double d1 = b[c].b;
        double d2 = (double)b[c].c + (double)(int)(kh1.aC + 1.0F) * 0.5D;
        return aj.b(d, d1, d2);
    }

    private final a b[];
    public final int a;
    private int c;
}
