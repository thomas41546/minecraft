package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class cp extends ak
{

    public cp()
    {
        b = 0.5F;
        d = ((fo) (new cl()));
    }

    public void a(dc dc1, double d1, double d2, double d3, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d1, (float)d2, (float)d3);
        GL11.glRotatef(180F - f, 0.0F, 1.0F, 0.0F);
        float f2 = (float)dc1.b - f1;
        float f3 = (float)dc1.a - f1;
        if(f3 < 0.0F)
            f3 = 0.0F;
        if(f2 > 0.0F)
            GL11.glRotatef(((eo.a(f2) * f2 * f3) / 10F) * (float)dc1.c, 1.0F, 0.0F, 0.0F);
        a("/terrain.png");
        float f4 = 0.75F;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        a("/item/boat.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        d.b(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public volatile void a(kh kh, double d1, double d2, double d3, 
            float f, float f1)
    {
        a((dc)kh, d1, d2, d3, f, f1);
    }

    protected fo d;
}
