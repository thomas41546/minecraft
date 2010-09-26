package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


final class fa extends Enum
{

    public static fa[] values()
    {
        return (fa[])((fa []) (f)).clone();
    }

    public static fa valueOf(String s)
    {
        return (fa)Enum.valueOf(fa, s);
    }

    private fa(String s, int i)
    {
        super(s, i);
    }

    public static final fa a;
    public static final fa b;
    public static final fa c;
    public static final fa d;
    public static final fa e;
    private static final fa f[];

    static 
    {
        a = new fa("linux", 0);
        b = new fa("solaris", 1);
        c = new fa("windows", 2);
        d = new fa("macos", 3);
        e = new fa("unknown", 4);
        f = (new fa[] {
            a, b, c, d, e
        });
    }
}
