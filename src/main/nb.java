package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.Canvas;
import java.awt.Dimension;

class nb extends Canvas
{

    public nb(int i)
    {
        setPreferredSize(new Dimension(i, i));
        setMinimumSize(new Dimension(i, i));
    }
}
