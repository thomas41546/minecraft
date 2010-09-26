package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;

public class ja extends bh
{

    public ja(bh bh1, String s, String s1, int k)
    {
        a = bh1;
        h = s;
        i = s1;
        j = k;
    }

    public void a()
    {
        e.add(((Object) (new o(0, (c / 2 - 155) + 0, d / 6 + 96, "Yes"))));
        e.add(((Object) (new o(1, (c / 2 - 155) + 160, d / 6 + 96, "No"))));
    }

    protected void a(fk fk1)
    {
        a.a(fk1.f == 0, j);
    }

    public void a(int k, int l, float f)
    {
        i();
        a(g, h, c / 2, 70, 0xffffff);
        a(g, i, c / 2, 90, 0xffffff);
        super.a(k, l, f);
    }

    private bh a;
    private String h;
    private String i;
    private int j;
}
