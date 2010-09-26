package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class lu extends lm
{

    public lu(Minecraft minecraft)
    {
        e = ((java.util.List) (new ArrayList()));
        f = new Random();
        a = null;
        h = 0;
        i = "";
        j = 0;
        c = 1.0F;
        g = minecraft;
    }

    public void a(float f1, boolean flag, int k, int l)
    {
        iy iy1 = new iy(g.c, g.d);
        int i1 = iy1.a();
        int j1 = iy1.b();
        kd kd1 = g.o;
        g.r.b();
        GL11.glEnable(3042);
        if(g.y.i)
            a(g.g.a(f1), i1, j1);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBindTexture(3553, g.n.a("/gui/gui.png"));
        eu eu1 = g.g.b;
        this.k = -90F;
        b(i1 / 2 - 91, j1 - 22, 0, 0, 182, 22);
        b((i1 / 2 - 91 - 1) + eu1.d * 20, j1 - 22 - 1, 0, 22, 24, 22);
        GL11.glBindTexture(3553, g.n.a("/gui/icons.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(775, 769);
        b(i1 / 2 - 7, j1 / 2 - 7, 0, 0, 16, 16);
        GL11.glDisable(3042);
        boolean flag1 = (g.g.aW / 3) % 2 == 1;
        if(g.g.aW < 10)
            flag1 = false;
        int k1 = g.g.E;
        int l1 = g.g.F;
        f.setSeed(h * 0x4c627);
        if(g.b.d())
        {
            int i2 = g.g.m();
            for(int k2 = 0; k2 < 10; k2++)
            {
                int l3 = j1 - 32;
                if(i2 > 0)
                {
                    int j5 = (i1 / 2 + 91) - k2 * 8 - 9;
                    if(k2 * 2 + 1 < i2)
                        b(j5, l3, 34, 9, 9, 9);
                    if(k2 * 2 + 1 == i2)
                        b(j5, l3, 25, 9, 9, 9);
                    if(k2 * 2 + 1 > i2)
                        b(j5, l3, 16, 9, 9, 9);
                }
                int k5 = 0;
                if(flag1)
                    k5 = 1;
                int i6 = (i1 / 2 - 91) + k2 * 8;
                if(k1 <= 4)
                    l3 += f.nextInt(2);
                b(i6, l3, 16 + k5 * 9, 0, 9, 9);
                if(flag1)
                {
                    if(k2 * 2 + 1 < l1)
                        b(i6, l3, 70, 0, 9, 9);
                    if(k2 * 2 + 1 == l1)
                        b(i6, l3, 79, 0, 9, 9);
                }
                if(k2 * 2 + 1 < k1)
                    b(i6, l3, 52, 0, 9, 9);
                if(k2 * 2 + 1 == k1)
                    b(i6, l3, 61, 0, 9, 9);
            }

            if(g.g.a(gb.f))
            {
                int i3 = (int)Math.ceil(((double)(g.g.aX - 2) * 10D) / 300D);
                int i4 = (int)Math.ceil(((double)g.g.aX * 10D) / 300D) - i3;
                for(int l5 = 0; l5 < i3 + i4; l5++)
                    if(l5 < i3)
                        b((i1 / 2 - 91) + l5 * 8, j1 - 32 - 9, 16, 18, 9, 9);
                    else
                        b((i1 / 2 - 91) + l5 * 8, j1 - 32 - 9, 25, 18, 9, 9);

            }
        }
        GL11.glDisable(3042);
        GL11.glEnable(32826);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
        i.b();
        GL11.glPopMatrix();
        for(int j2 = 0; j2 < 9; j2++)
        {
            int j3 = (i1 / 2 - 90) + j2 * 20 + 2;
            int j4 = j1 - 16 - 3;
            a(j2, j3, j4, f1);
        }

        i.a();
        GL11.glDisable(32826);
        if(Keyboard.isKeyDown(61))
        {
            kd1.a((new StringBuilder()).append("Minecraft Alpha v1.1.2 (").append(g.G).append(")").toString(), 2, 2, 0xffffff);
            kd1.a(g.l(), 2, 12, 0xffffff);
            kd1.a(g.m(), 2, 22, 0xffffff);
            kd1.a(g.n(), 2, 32, 0xffffff);
            long l2 = Runtime.getRuntime().maxMemory();
            long l4 = Runtime.getRuntime().totalMemory();
            long l6 = Runtime.getRuntime().freeMemory();
            long l7 = l4 - l6;
            String s = (new StringBuilder()).append("Used memory: ").append((l7 * 100L) / l2).append("% (").append(l7 / 1024L / 1024L).append("MB) of ").append(l2 / 1024L / 1024L).append("MB").toString();
            b(kd1, s, i1 - kd1.a(s) - 2, 2, 0xe0e0e0);
            s = (new StringBuilder()).append("Allocated memory: ").append((l4 * 100L) / l2).append("% (").append(l4 / 1024L / 1024L).append("MB)").toString();
            b(kd1, s, i1 - kd1.a(s) - 2, 12, 0xe0e0e0);
        } else
        {
            kd1.a("Minecraft Alpha v1.1.2", 2, 2, 0xffffff);
        }
        if(j > 0)
        {
            float f2 = (float)j - f1;
            int k3 = (int)((f2 * 256F) / 20F);
            if(k3 > 255)
                k3 = 255;
            if(k3 > 0)
            {
                GL11.glPushMatrix();
                GL11.glTranslatef(i1 / 2, j1 - 48, 0.0F);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                int k4 = Color.HSBtoRGB(f2 / 50F, 0.7F, 0.6F) & 0xffffff;
                kd1.b(i, -kd1.a(i) / 2, -4, k4 + (k3 << 24));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
        }
        byte byte0 = 10;
        boolean flag2 = false;
        if(g.p instanceof de)
        {
            byte0 = 20;
            flag2 = true;
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, j1 - 48, 0.0F);
        for(int i5 = 0; i5 < e.size() && i5 < byte0; i5++)
        {
            if(((ko)e.get(i5)).b >= 200 && !flag2)
                continue;
            double d1 = (double)((ko)e.get(i5)).b / 200D;
            d1 = 1.0D - d1;
            d1 *= 10D;
            if(d1 < 0.0D)
                d1 = 0.0D;
            if(d1 > 1.0D)
                d1 = 1.0D;
            d1 *= d1;
            int j6 = (int)(255D * d1);
            if(flag2)
                j6 = 255;
            if(j6 > 0)
            {
                byte byte1 = 2;
                int k6 = -i5 * 9;
                String s1 = ((ko)e.get(i5)).a;
                a(((int) (byte1)), k6 - 1, byte1 + 320, k6 + 8, j6 / 2 << 24);
                GL11.glEnable(3042);
                kd1.a(s1, ((int) (byte1)), k6, 0xffffff + (j6 << 24));
            }
        }

        GL11.glPopMatrix();
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    private void a(float f1, int k, int l)
    {
        f1 = 1.0F - f1;
        if(f1 < 0.0F)
            f1 = 0.0F;
        if(f1 > 1.0F)
            f1 = 1.0F;
        c += ((float) ((double)(f1 - c) * 0.01D));
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(0, 769);
        GL11.glColor4f(c, c, c, 1.0F);
        GL11.glBindTexture(3553, g.n.a("/misc/vignette.png"));
        ho ho1 = ho.a;
        ho1.b();
        ho1.a(0.0D, l, -90D, 0.0D, 1.0D);
        ho1.a(k, l, -90D, 1.0D, 1.0D);
        ho1.a(k, 0.0D, -90D, 1.0D, 0.0D);
        ho1.a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        ho1.a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBlendFunc(770, 771);
    }

    private void a(int k, int l, int i1, float f1)
    {
        ev ev1 = g.g.b.a[k];
        if(ev1 == null)
            return;
        float f2 = (float)ev1.b - f1;
        if(f2 > 0.0F)
        {
            GL11.glPushMatrix();
            float f3 = 1.0F + f2 / 5F;
            GL11.glTranslatef(l + 8, i1 + 12, 0.0F);
            GL11.glScalef(1.0F / f3, (f3 + 1.0F) / 2.0F, 1.0F);
            GL11.glTranslatef(-(l + 8), -(i1 + 12), 0.0F);
        }
        d.a(g.o, g.n, ev1, l, i1);
        if(f2 > 0.0F)
            GL11.glPopMatrix();
        d.b(g.o, g.n, ev1, l, i1);
    }

    public void a()
    {
        if(j > 0)
            j--;
        h++;
        for(int k = 0; k < e.size(); k++)
            ((ko)e.get(k)).b++;

    }

    public void a(String s)
    {
        int k;
        for(; g.o.a(s) > 320; s = s.substring(k))
        {
            for(k = 1; k < s.length() && g.o.a(s.substring(0, k + 1)) <= 320; k++);
            a(s.substring(0, k));
        }

        e.add(0, ((Object) (new ko(s))));
        for(; e.size() > 50; e.remove(e.size() - 1));
    }

    public void b(String s)
    {
        i = (new StringBuilder()).append("Now playing: ").append(s).toString();
        j = 60;
    }

    private static ab d = new ab();
    private java.util.List e;
    private Random f;
    private Minecraft g;
    public String a;
    private int h;
    private String i;
    private int j;
    public float b;
    float c;

}
