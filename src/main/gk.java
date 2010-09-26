package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class gk extends ak
{

    public gk()
    {
    }

    public void a(kg kg1, double d, double d1, double d2, 
            float f, float f1)
    {
        a("/item/arrows.png");
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef((kg1.as + (kg1.aq - kg1.as) * f1) - 90F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(kg1.at + (kg1.ar - kg1.at) * f1, 0.0F, 0.0F, 1.0F);
        ho ho1 = ho.a;
        int i = 0;
        float f2 = 0.0F;
        float f3 = 0.5F;
        float f4 = (float)(0 + i * 10) / 32F;
        float f5 = (float)(5 + i * 10) / 32F;
        float f6 = 0.0F;
        float f7 = 0.15625F;
        float f8 = (float)(5 + i * 10) / 32F;
        float f9 = (float)(10 + i * 10) / 32F;
        float f10 = 0.05625F;
        GL11.glEnable(32826);
        float f11 = (float)kg1.a - f1;
        if(f11 > 0.0F)
        {
            float f12 = -eo.a(f11 * 3F) * f11;
            GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
        }
        GL11.glRotatef(45F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(f10, f10, f10);
        GL11.glTranslatef(-4F, 0.0F, 0.0F);
        GL11.glNormal3f(f10, 0.0F, 0.0F);
        ho1.b();
        ho1.a(-7D, -2D, -2D, f6, f8);
        ho1.a(-7D, -2D, 2D, f7, f8);
        ho1.a(-7D, 2D, 2D, f7, f9);
        ho1.a(-7D, 2D, -2D, f6, f9);
        ho1.a();
        GL11.glNormal3f(-f10, 0.0F, 0.0F);
        ho1.b();
        ho1.a(-7D, 2D, -2D, f6, f8);
        ho1.a(-7D, 2D, 2D, f7, f8);
        ho1.a(-7D, -2D, 2D, f7, f9);
        ho1.a(-7D, -2D, -2D, f6, f9);
        ho1.a();
        for(int j = 0; j < 4; j++)
        {
            GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, f10);
            ho1.b();
            ho1.a(-8D, -2D, 0.0D, f2, f4);
            ho1.a(8D, -2D, 0.0D, f3, f4);
            ho1.a(8D, 2D, 0.0D, f3, f5);
            ho1.a(-8D, 2D, 0.0D, f2, f5);
            ho1.a();
        }

        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public volatile void a(kh kh, double d, double d1, double d2, 
            float f, float f1)
    {
        a((kg)kh, d, d1, d2, f, f1);
    }
}
