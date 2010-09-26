package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public final class js extends Enum
{

    public static js[] values()
    {
        return (js[])((js []) (d)).clone();
    }

    public static js valueOf(String s)
    {
        return (js)Enum.valueOf(js, s);
    }

    private js(String s, int i)
    {
        super(s, i);
    }

    public static final js a;
    public static final js b;
    public static final js c;
    private static final js d[];

    static 
    {
        a = new js("everything", 0);
        b = new js("mobs", 1);
        c = new js("players", 2);
        d = (new js[] {
            a, b, c
        });
    }
}
