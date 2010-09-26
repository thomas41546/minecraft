package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class gj extends ak
{

    public gj()
    {
    }

    public void a(kh kh1, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        a(kh1.au, d - kh1.aI, d1 - kh1.aJ, d2 - kh1.aK);
        GL11.glPopMatrix();
    }
}
