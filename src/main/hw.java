package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class hw extends ak
{

    public hw()
    {
        d = new bc();
        b = 0.5F;
    }

    public void a(jd jd1, double d1, double d2, double d3, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d1, (float)d2, (float)d3);
        if(((float)jd1.a - f1) + 1.0F < 10F)
        {
            float f2 = 1.0F - (((float)jd1.a - f1) + 1.0F) / 10F;
            if(f2 < 0.0F)
                f2 = 0.0F;
            if(f2 > 1.0F)
                f2 = 1.0F;
            f2 *= f2;
            f2 *= f2;
            float f4 = 1.0F + f2 * 0.3F;
            GL11.glScalef(f4, f4, f4);
        }
        float f3 = (1.0F - (((float)jd1.a - f1) + 1.0F) / 100F) * 0.8F;
        a("/terrain.png");
        d.a(ly.an);
        if((jd1.a / 5) % 2 == 0)
        {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 772);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f3);
            d.a(ly.an);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
        GL11.glPopMatrix();
    }

    public volatile void a(kh kh, double d1, double d2, double d3, 
            float f, float f1)
    {
        a((jd)kh, d1, d2, d3, f, f1);
    }

    private bc d;
}
