package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;
import org.lwjgl.opengl.GL11;

public class ab extends ak
{

    public ab()
    {
        d = new bc();
        e = new Random();
        b = 0.15F;
        c = 0.75F;
    }

    public void a(dx dx1, double d1, double d2, double d3, 
            float f, float f1)
    {
        e.setSeed(187L);
        ev ev1 = dx1.a;
        GL11.glPushMatrix();
        float f2 = eo.a(((float)dx1.b + f1) / 10F + dx1.d) * 0.1F + 0.1F;
        float f3 = (((float)dx1.b + f1) / 20F + dx1.d) * 57.29578F;
        byte byte0 = 1;
        if(dx1.a.a > 1)
            byte0 = 2;
        if(dx1.a.a > 5)
            byte0 = 3;
        if(dx1.a.a > 20)
            byte0 = 4;
        GL11.glTranslatef((float)d1, (float)d2 + f2, (float)d3);
        GL11.glEnable(32826);
        if(ev1.c < 256 && bc.a(ly.n[ev1.c].f()))
        {
            GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);
            a("/terrain.png");
            float f4 = 0.25F;
            if(!ly.n[ev1.c].c() && ev1.c != ly.al.bc)
                f4 = 0.5F;
            GL11.glScalef(f4, f4, f4);
            for(int j = 0; j < byte0; j++)
            {
                GL11.glPushMatrix();
                if(j > 0)
                {
                    float f5 = ((e.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    float f7 = ((e.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    float f9 = ((e.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    GL11.glTranslatef(f5, f7, f9);
                }
                d.a(ly.n[ev1.c]);
                GL11.glPopMatrix();
            }

        } else
        {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            int i = ev1.b();
            if(ev1.c < 256)
                a("/terrain.png");
            else
                a("/gui/items.png");
            ho ho1 = ho.a;
            float f6 = (float)((i % 16) * 16 + 0) / 256F;
            float f8 = (float)((i % 16) * 16 + 16) / 256F;
            float f10 = (float)((i / 16) * 16 + 0) / 256F;
            float f11 = (float)((i / 16) * 16 + 16) / 256F;
            float f12 = 1.0F;
            float f13 = 0.5F;
            float f14 = 0.25F;
            for(int k = 0; k < byte0; k++)
            {
                GL11.glPushMatrix();
                if(k > 0)
                {
                    float f15 = (e.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f16 = (e.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f17 = (e.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    GL11.glTranslatef(f15, f16, f17);
                }
                GL11.glRotatef(180F - a.i, 0.0F, 1.0F, 0.0F);
                ho1.b();
                ho1.b(0.0F, 1.0F, 0.0F);
                ho1.a(0.0F - f13, 0.0F - f14, 0.0D, f6, f11);
                ho1.a(f12 - f13, 0.0F - f14, 0.0D, f8, f11);
                ho1.a(f12 - f13, 1.0F - f14, 0.0D, f8, f10);
                ho1.a(0.0F - f13, 1.0F - f14, 0.0D, f6, f10);
                ho1.a();
                GL11.glPopMatrix();
            }

        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public void a(kd kd1, ey ey1, ev ev1, int i, int j)
    {
        if(ev1 == null)
            return;
        if(ev1.c < 256 && bc.a(ly.n[ev1.c].f()))
        {
            int k = ev1.c;
            ey1.b(ey1.a("/terrain.png"));
            ly ly1 = ly.n[k];
            GL11.glPushMatrix();
            GL11.glTranslatef(i - 2, j + 3, 0.0F);
            GL11.glScalef(10F, 10F, 10F);
            GL11.glTranslatef(1.0F, 0.5F, 8F);
            GL11.glRotatef(210F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            d.a(ly1);
            GL11.glPopMatrix();
        } else
        if(ev1.b() >= 0)
        {
            GL11.glDisable(2896);
            if(ev1.c < 256)
                ey1.b(ey1.a("/terrain.png"));
            else
                ey1.b(ey1.a("/gui/items.png"));
            a(i, j, (ev1.b() % 16) * 16, (ev1.b() / 16) * 16, 16, 16);
            GL11.glEnable(2896);
        }
        GL11.glEnable(2884);
    }

    public void b(kd kd1, ey ey1, ev ev1, int i, int j)
    {
        if(ev1 == null)
            return;
        if(ev1.a > 1)
        {
            String s = (new StringBuilder()).append("").append(ev1.a).toString();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            kd1.a(s, (i + 19) - 2 - kd1.a(s), j + 6 + 3, 0xffffff);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
        }
        if(ev1.d > 0)
        {
            int k = 13 - (ev1.d * 13) / ev1.d();
            int l = 255 - (ev1.d * 255) / ev1.d();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glDisable(3553);
            ho ho1 = ho.a;
            int i1 = 255 - l << 16 | l << 8;
            int j1 = (255 - l) / 4 << 16 | 0x3f00;
            a(ho1, i + 2, j + 13, 13, 2, 0);
            a(ho1, i + 2, j + 13, 12, 1, j1);
            a(ho1, i + 2, j + 13, k, 1, i1);
            GL11.glEnable(3553);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    private void a(ho ho1, int i, int j, int k, int l, int i1)
    {
        ho1.b();
        ho1.b(i1);
        ho1.a(i + 0, j + 0, 0.0D);
        ho1.a(i + 0, j + l, 0.0D);
        ho1.a(i + k, j + l, 0.0D);
        ho1.a(i + k, j + 0, 0.0D);
        ho1.a();
    }

    public void a(int i, int j, int k, int l, int i1, int j1)
    {
        float f = 0.0F;
        float f1 = 0.00390625F;
        float f2 = 0.00390625F;
        ho ho1 = ho.a;
        ho1.b();
        ho1.a(i + 0, j + j1, f, (float)(k + 0) * f1, (float)(l + j1) * f2);
        ho1.a(i + i1, j + j1, f, (float)(k + i1) * f1, (float)(l + j1) * f2);
        ho1.a(i + i1, j + 0, f, (float)(k + i1) * f1, (float)(l + 0) * f2);
        ho1.a(i + 0, j + 0, f, (float)(k + 0) * f1, (float)(l + 0) * f2);
        ho1.a();
    }

    public volatile void a(kh kh, double d1, double d2, double d3, 
            float f, float f1)
    {
        a((dx)kh, d1, d2, d3, f, f1);
    }

    private bc d;
    private Random e;
}
