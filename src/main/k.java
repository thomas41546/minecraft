package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

class k extends az
{

    k(ia ia1, int i, Class class1, Class aclass[])
    {
        a = ia1;
        super(i, class1, aclass);
    }

    protected mt a(cn cn1, int i, int j)
    {
        int l = i + cn1.n.nextInt(16);
        int i1 = cn1.n.nextInt(cn1.n.nextInt(120) + 8);
        int j1 = j + cn1.n.nextInt(16);
        return new mt(l, i1, j1);
    }

    final ia a;
}
