package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class ed
{

    public ed(float f, float f1, float f2, float f3, float f4)
    {
        this(aj.a(f, f1, f2), f3, f4);
    }

    public ed a(float f, float f1)
    {
        return new ed(this, f, f1);
    }

    public ed(ed ed1, float f, float f1)
    {
        a = ed1.a;
        b = f;
        c = f1;
    }

    public ed(aj aj1, float f, float f1)
    {
        a = aj1;
        b = f;
        c = f1;
    }

    public aj a;
    public float b;
    public float c;
}
