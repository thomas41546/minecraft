package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class ei extends ak
{

    public ei()
    {
    }

    public void a(ao ao1, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glEnable(32826);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        int i = di.aB.a(((ev) (null)));
        a("/gui/items.png");
        ho ho1 = ho.a;
        float f2 = (float)((i % 16) * 16 + 0) / 256F;
        float f3 = (float)((i % 16) * 16 + 16) / 256F;
        float f4 = (float)((i / 16) * 16 + 0) / 256F;
        float f5 = (float)((i / 16) * 16 + 16) / 256F;
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.25F;
        GL11.glRotatef(180F - a.i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-a.j, 1.0F, 0.0F, 0.0F);
        ho1.b();
        ho1.b(0.0F, 1.0F, 0.0F);
        ho1.a(0.0F - f7, 0.0F - f8, 0.0D, f2, f5);
        ho1.a(f6 - f7, 0.0F - f8, 0.0D, f3, f5);
        ho1.a(f6 - f7, 1.0F - f8, 0.0D, f3, f4);
        ho1.a(0.0F - f7, 1.0F - f8, 0.0D, f2, f4);
        ho1.a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public volatile void a(kh kh, double d, double d1, double d2, 
            float f, float f1)
    {
        a((ao)kh, d, d1, d2, f, f1);
    }
}
