package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class dj extends ak
{

    public dj()
    {
        d = new bc();
        b = 0.5F;
    }

    public void a(ff ff1, double d1, double d2, double d3, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d1, (float)d2, (float)d3);
        a("/terrain.png");
        ly ly1 = ly.n[ff1.a];
        cn cn = ff1.i();
        GL11.glDisable(2896);
        d.a(ly1, cn, eo.b(ff1.ak), eo.b(ff1.al), eo.b(ff1.am));
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }

    public volatile void a(kh kh, double d1, double d2, double d3, 
            float f, float f1)
    {
        a((ff)kh, d1, d2, d3, f, f1);
    }

    private bc d;
}
