package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class nz extends dn
{

    public nz(fo fo, float f1, float f2)
    {
        super(fo, f1 * f2);
        f = f2;
    }

    protected void a(hl hl1, float f1)
    {
        GL11.glScalef(f, f, f);
    }

    protected volatile void a(ge ge, float f1)
    {
        a((hl)ge, f1);
    }

    private float f;
}
