// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;


class Util
{

    Util()
    {
    }

    static int ilog(int i)
    {
        int j = 0;
        for(; i != 0; i >>>= 1)
            j++;

        return j;
    }

    static int ilog2(int i)
    {
        int j = 0;
        for(; i > 1; i >>>= 1)
            j++;

        return j;
    }

    static int icount(int i)
    {
        int j = 0;
        for(; i != 0; i >>>= 1)
            j += i & 1;

        return j;
    }
}
