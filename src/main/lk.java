package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.File;

class lk extends cn
{

    lk(ad ad1, File file, String s)
    {
        z = ad1;
        super(file, s);
    }

    protected aw a(File file)
    {
        return ((aw) (new ck(((cn) (this)), ((af) (new le(file, false))))));
    }

    final ad z;
}
