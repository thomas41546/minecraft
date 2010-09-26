package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;
import org.lwjgl.opengl.GL11;

public class bw extends ak
{

    public bw()
    {
        d = new Random();
    }

    public void a(jc jc1, double d1, double d2, double d3, 
            float f, float f1)
    {
        d.setSeed(187L);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d1, (float)d2, (float)d3);
        GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
        GL11.glEnable(32826);
        a("/art/kz.png");
        er er1 = jc1.b;
        float f2 = 0.0625F;
        GL11.glScalef(f2, f2, f2);
        a(jc1, er1.z, er1.A, er1.B, er1.C);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void a(jc jc1, int i, int j, int k, int l)
    {
        float f = (float)(-i) / 2.0F;
        float f1 = (float)(-j) / 2.0F;
        float f2 = -0.5F;
        float f3 = 0.5F;
        for(int i1 = 0; i1 < i / 16; i1++)
        {
            for(int j1 = 0; j1 < j / 16; j1++)
            {
                float f4 = f + (float)((i1 + 1) * 16);
                float f5 = f + (float)(i1 * 16);
                float f6 = f1 + (float)((j1 + 1) * 16);
                float f7 = f1 + (float)(j1 * 16);
                a(jc1, (f4 + f5) / 2.0F, (f6 + f7) / 2.0F);
                float f8 = (float)((k + i) - i1 * 16) / 256F;
                float f9 = (float)((k + i) - (i1 + 1) * 16) / 256F;
                float f10 = (float)((l + j) - j1 * 16) / 256F;
                float f11 = (float)((l + j) - (j1 + 1) * 16) / 256F;
                float f12 = 0.75F;
                float f13 = 0.8125F;
                float f14 = 0.0F;
                float f15 = 0.0625F;
                float f16 = 0.75F;
                float f17 = 0.8125F;
                float f18 = 0.001953125F;
                float f19 = 0.001953125F;
                float f20 = 0.7519531F;
                float f21 = 0.7519531F;
                float f22 = 0.0F;
                float f23 = 0.0625F;
                ho ho1 = ho.a;
                ho1.b();
                ho1.b(0.0F, 0.0F, -1F);
                ho1.a(f4, f7, f2, f9, f10);
                ho1.a(f5, f7, f2, f8, f10);
                ho1.a(f5, f6, f2, f8, f11);
                ho1.a(f4, f6, f2, f9, f11);
                ho1.b(0.0F, 0.0F, 1.0F);
                ho1.a(f4, f6, f3, f12, f14);
                ho1.a(f5, f6, f3, f13, f14);
                ho1.a(f5, f7, f3, f13, f15);
                ho1.a(f4, f7, f3, f12, f15);
                ho1.b(0.0F, -1F, 0.0F);
                ho1.a(f4, f6, f2, f16, f18);
                ho1.a(f5, f6, f2, f17, f18);
                ho1.a(f5, f6, f3, f17, f19);
                ho1.a(f4, f6, f3, f16, f19);
                ho1.b(0.0F, 1.0F, 0.0F);
                ho1.a(f4, f7, f3, f16, f18);
                ho1.a(f5, f7, f3, f17, f18);
                ho1.a(f5, f7, f2, f17, f19);
                ho1.a(f4, f7, f2, f16, f19);
                ho1.b(-1F, 0.0F, 0.0F);
                ho1.a(f4, f6, f3, f21, f22);
                ho1.a(f4, f7, f3, f21, f23);
                ho1.a(f4, f7, f2, f20, f23);
                ho1.a(f4, f6, f2, f20, f22);
                ho1.b(1.0F, 0.0F, 0.0F);
                ho1.a(f5, f6, f2, f21, f22);
                ho1.a(f5, f7, f2, f21, f23);
                ho1.a(f5, f7, f3, f20, f23);
                ho1.a(f5, f6, f3, f20, f22);
                ho1.a();
            }

        }

    }

    private void a(jc jc1, float f, float f1)
    {
        int i = eo.b(jc1.ak);
        int j = eo.b(jc1.al + (double)(f1 / 16F));
        int k = eo.b(jc1.am);
        if(jc1.a == 0)
            i = eo.b(jc1.ak + (double)(f / 16F));
        if(jc1.a == 1)
            k = eo.b(jc1.am - (double)(f / 16F));
        if(jc1.a == 2)
            i = eo.b(jc1.ak - (double)(f / 16F));
        if(jc1.a == 3)
            k = eo.b(jc1.am + (double)(f / 16F));
        float f2 = a.g.c(i, j, k);
        GL11.glColor3f(f2, f2, f2);
    }

    public volatile void a(kh kh, double d1, double d2, double d3, 
            float f, float f1)
    {
        a((jc)kh, d1, d2, d3, f, f1);
    }

    private Random d;
}
