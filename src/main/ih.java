package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;

public final class ih extends Enum
{

    public static ih[] values()
    {
        return (ih[])((ih []) (f)).clone();
    }

    public static ih valueOf(String s)
    {
        return (ih)Enum.valueOf(ih, s);
    }

    private ih(String s, int i)
    {
        super(s, i);
    }

    public static final ih a;
    public static final ih b;
    public static final ih c;
    public static final ih d;
    public static final ih e;
    private static final ih f[];

    static 
    {
        a = new ih("linux", 0);
        b = new ih("solaris", 1);
        c = new ih("windows", 2);
        d = new ih("macos", 3);
        e = new ih("unknown", 4);
        f = (new ih[] {
            a, b, c, d, e
        });
    }
}
