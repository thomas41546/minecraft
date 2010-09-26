package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class jw extends di
{

    public jw(int i)
    {
        super(i);
        aT = 1;
        aU = 64;
    }

    public void b(ev ev1, ge ge)
    {
        if(ge instanceof mv)
        {
            mv mv1 = (mv)ge;
            if(!mv1.a)
            {
                mv1.a = true;
                ev1.a--;
            }
        }
    }

    public void a(ev ev1, ge ge)
    {
        b(ev1, ge);
    }
}
