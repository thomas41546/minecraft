package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class lm
{

    public lm()
    {
        k = 0.0F;
    }

    protected void a(int i, int j, int l, int i1, int j1)
    {
        float f = (float)(j1 >> 24 & 0xff) / 255F;
        float f1 = (float)(j1 >> 16 & 0xff) / 255F;
        float f2 = (float)(j1 >> 8 & 0xff) / 255F;
        float f3 = (float)(j1 & 0xff) / 255F;
        ho ho1 = ho.a;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        ho1.b();
        ho1.a(i, i1, 0.0D);
        ho1.a(l, i1, 0.0D);
        ho1.a(l, j, 0.0D);
        ho1.a(i, j, 0.0D);
        ho1.a();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    protected void a(int i, int j, int l, int i1, int j1, int k1)
    {
        float f = (float)(j1 >> 24 & 0xff) / 255F;
        float f1 = (float)(j1 >> 16 & 0xff) / 255F;
        float f2 = (float)(j1 >> 8 & 0xff) / 255F;
        float f3 = (float)(j1 & 0xff) / 255F;
        float f4 = (float)(k1 >> 24 & 0xff) / 255F;
        float f5 = (float)(k1 >> 16 & 0xff) / 255F;
        float f6 = (float)(k1 >> 8 & 0xff) / 255F;
        float f7 = (float)(k1 & 0xff) / 255F;
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        ho ho1 = ho.a;
        ho1.b();
        ho1.a(f1, f2, f3, f);
        ho1.a(l, j, 0.0D);
        ho1.a(i, j, 0.0D);
        ho1.a(f5, f6, f7, f4);
        ho1.a(i, i1, 0.0D);
        ho1.a(l, i1, 0.0D);
        ho1.a();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    public void a(kd kd1, String s, int i, int j, int l)
    {
        kd1.a(s, i - kd1.a(s) / 2, j, l);
    }

    public void b(kd kd1, String s, int i, int j, int l)
    {
        kd1.a(s, i, j, l);
    }

    public void b(int i, int j, int l, int i1, int j1, int k1)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        ho ho1 = ho.a;
        ho1.b();
        ho1.a(i + 0, j + k1, k, (float)(l + 0) * f, (float)(i1 + k1) * f1);
        ho1.a(i + j1, j + k1, k, (float)(l + j1) * f, (float)(i1 + k1) * f1);
        ho1.a(i + j1, j + 0, k, (float)(l + j1) * f, (float)(i1 + 0) * f1);
        ho1.a(i + 0, j + 0, k, (float)(l + 0) * f, (float)(i1 + 0) * f1);
        ho1.a();
    }

    protected float k;
}
