package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public final class by extends Enum
{

    public static by[] values()
    {
        return (by[])((by []) (d)).clone();
    }

    public static by valueOf(String s)
    {
        return (by)Enum.valueOf(by, s);
    }

    private by(String s, int i, int j)
    {
        super(s, i);
        c = j;
    }

    public static final by a;
    public static final by b;
    public final int c;
    private static final by d[];

    static 
    {
        a = new by("Sky", 0, 15);
        b = new by("Block", 1, 0);
        d = (new by[] {
            a, b
        });
    }
}
