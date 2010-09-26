package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class gd extends lv
{

    public gd(fr fr1)
    {
        f = new boolean[10];
        g = fr1;
    }

    public void a(int i, boolean flag)
    {
        byte byte0 = -1;
        if(i == g.j.b)
            byte0 = 0;
        if(i == g.l.b)
            byte0 = 1;
        if(i == g.k.b)
            byte0 = 2;
        if(i == g.m.b)
            byte0 = 3;
        if(i == g.n.b)
            byte0 = 4;
        if(i == g.s.b)
            byte0 = 5;
        if(byte0 >= 0)
            f[byte0] = flag;
    }

    public void a()
    {
        for(int i = 0; i < 10; i++)
            f[i] = false;

    }

    public void a(dm dm)
    {
        a = 0.0F;
        b = 0.0F;
        if(f[0])
            b++;
        if(f[1])
            b--;
        if(f[2])
            a++;
        if(f[3])
            a--;
        d = f[4];
        e = f[5];
        if(e)
        {
            a *= 0.29999999999999999D;
            b *= 0.29999999999999999D;
        }
    }

    private boolean f[];
    private fr g;
}
