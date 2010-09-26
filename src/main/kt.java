package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class kt extends ak
{

    public kt()
    {
        b = 0.5F;
        d = ((fo) (new hj()));
    }

    public void a(oc oc1, double d1, double d2, double d3, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        double d4 = oc1.aI + (oc1.ak - oc1.aI) * (double)f1;
        double d5 = oc1.aJ + (oc1.al - oc1.aJ) * (double)f1;
        double d6 = oc1.aK + (oc1.am - oc1.aK) * (double)f1;
        double d7 = 0.30000001192092896D;
        aj aj1 = oc1.g(d4, d5, d6);
        float f2 = oc1.at + (oc1.ar - oc1.at) * f1;
        if(aj1 != null)
        {
            aj aj2 = oc1.a(d4, d5, d6, d7);
            aj aj3 = oc1.a(d4, d5, d6, -d7);
            if(aj2 == null)
                aj2 = aj1;
            if(aj3 == null)
                aj3 = aj1;
            d1 += aj1.a - d4;
            d2 += (aj2.b + aj3.b) / 2D - d5;
            d3 += aj1.c - d6;
            aj aj4 = aj3.c(-aj2.a, -aj2.b, -aj2.c);
            if(aj4.c() != 0.0D)
            {
                aj4 = aj4.b();
                f = (float)((Math.atan2(aj4.c, aj4.a) * 180D) / 3.1415926535897931D);
                f2 = (float)(Math.atan(aj4.b) * 73D);
            }
        }
        GL11.glTranslatef((float)d1, (float)d2, (float)d3);
        GL11.glRotatef(180F - f, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-f2, 0.0F, 0.0F, 1.0F);
        float f3 = (float)oc1.b - f1;
        float f4 = (float)oc1.a - f1;
        if(f4 < 0.0F)
            f4 = 0.0F;
        if(f3 > 0.0F)
            GL11.glRotatef(((eo.a(f3) * f3 * f4) / 10F) * (float)oc1.c, 1.0F, 0.0F, 0.0F);
        if(oc1.d != 0)
        {
            a("/terrain.png");
            float f5 = 0.75F;
            GL11.glScalef(f5, f5, f5);
            GL11.glTranslatef(0.0F, 0.3125F, 0.0F);
            GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
            if(oc1.d == 1)
                (new bc()).a(ly.av);
            else
            if(oc1.d == 2)
                (new bc()).a(ly.aC);
            GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.3125F, 0.0F);
            GL11.glScalef(1.0F / f5, 1.0F / f5, 1.0F / f5);
        }
        a("/item/cart.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        d.b(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public volatile void a(kh kh, double d1, double d2, double d3, 
            float f, float f1)
    {
        a((oc)kh, d1, d2, d3, f, f1);
    }

    protected fo d;
}
