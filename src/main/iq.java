package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.GLU;

public class iq
{

    public iq(Minecraft minecraft)
    {
        i = 0.0F;
        k = null;
        l = System.currentTimeMillis();
        m = new Random();
        b = 0;
        c = 0;
        d = df.d(16);
        h = minecraft;
        a = new jh(minecraft);
    }

    public void a()
    {
        n = o;
        float f1 = h.e.c(eo.b(h.g.ak), eo.b(h.g.al), eo.b(h.g.am));
        float f2 = (float)(3 - h.y.e) / 3F;
        float f3 = f1 * (1.0F - f2) + f2;
        o += (f3 - o) * 0.1F;
        j++;
        a.a();
        if(h.J)
            c();
    }

    public void a(float f1)
    {
        if(h.g == null)
            return;
        double d1 = h.b.b();
        h.x = h.g.a(d1, f1);
        double d2 = d1;
        aj aj1 = h.g.e(f1);
        if(h.x != null)
            d2 = h.x.f.c(aj1);
        if(h.b instanceof il)
        {
            d2 = d1 = 32D;
        } else
        {
            if(d2 > 3D)
                d2 = 3D;
            d1 = d2;
        }
        aj aj2 = h.g.f(f1);
        aj aj3 = aj1.c(aj2.a * d1, aj2.b * d1, aj2.c * d1);
        k = null;
        List list = h.e.b(((kh) (h.g)), h.g.au.a(aj2.a * d1, aj2.b * d1, aj2.c * d1));
        double d3 = 0.0D;
        for(int i1 = 0; i1 < list.size(); i1++)
        {
            kh kh1 = (kh)list.get(i1);
            if(!kh1.c_())
                continue;
            float f2 = 0.1F;
            cf cf1 = kh1.au.b(f2, f2, f2);
            mf mf1 = cf1.a(aj1, aj3);
            if(mf1 == null)
                continue;
            double d4 = aj1.c(mf1.f);
            if(d4 < d3 || d3 == 0.0D)
            {
                k = kh1;
                d3 = d4;
            }
        }

        if(k != null && !(h.b instanceof il))
            h.x = new mf(k);
    }

    private float d(float f1)
    {
        bi bi1 = h.g;
        float f2 = 70F;
        if(((dm) (bi1)).a(gb.f))
            f2 = 60F;
        if(((dm) (bi1)).E <= 0)
        {
            float f3 = (float)((dm) (bi1)).J + f1;
            f2 /= (1.0F - 500F / (f3 + 500F)) * 2.0F + 1.0F;
        }
        return f2;
    }

    private void e(float f1)
    {
        bi bi1 = h.g;
        float f2 = (float)((dm) (bi1)).G - f1;
        if(((dm) (bi1)).E <= 0)
        {
            float f3 = (float)((dm) (bi1)).J + f1;
            GL11.glRotatef(40F - 8000F / (f3 + 200F), 0.0F, 0.0F, 1.0F);
        }
        if(f2 < 0.0F)
        {
            return;
        } else
        {
            f2 /= ((dm) (bi1)).H;
            f2 = eo.a(f2 * f2 * f2 * f2 * 3.141593F);
            float f4 = ((dm) (bi1)).I;
            GL11.glRotatef(-f4, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f2 * 14F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(f4, 0.0F, 1.0F, 0.0F);
            return;
        }
    }

    private void f(float f1)
    {
        if(h.y.x)
        {
            return;
        } else
        {
            bi bi1 = h.g;
            float f2 = ((dm) (bi1)).aF - ((dm) (bi1)).aE;
            float f3 = ((dm) (bi1)).aF + f2 * f1;
            float f4 = ((dm) (bi1)).e + (((dm) (bi1)).f - ((dm) (bi1)).e) * f1;
            float f5 = ((dm) (bi1)).L + (((dm) (bi1)).M - ((dm) (bi1)).L) * f1;
            GL11.glTranslatef(eo.a(f3 * 3.141593F) * f4 * 0.5F, -Math.abs(eo.b(f3 * 3.141593F) * f4), 0.0F);
            GL11.glRotatef(eo.a(f3 * 3.141593F) * f4 * 3F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(Math.abs(eo.b(f3 * 3.141593F + 0.2F) * f4) * 5F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(f5, 1.0F, 0.0F, 0.0F);
            return;
        }
    }

    private void g(float f1)
    {
        bi bi1 = h.g;
        double d1 = ((dm) (bi1)).ah + (((dm) (bi1)).ak - ((dm) (bi1)).ah) * (double)f1;
        double d2 = ((dm) (bi1)).ai + (((dm) (bi1)).al - ((dm) (bi1)).ai) * (double)f1;
        double d3 = ((dm) (bi1)).aj + (((dm) (bi1)).am - ((dm) (bi1)).aj) * (double)f1;
        if(h.y.x)
        {
            double d4 = 4D;
            float f2 = ((dm) (bi1)).aq;
            float f3 = ((dm) (bi1)).ar;
            double d5 = (double)(-eo.a((f2 / 180F) * 3.141593F) * eo.b((f3 / 180F) * 3.141593F)) * d4;
            double d6 = (double)(eo.b((f2 / 180F) * 3.141593F) * eo.b((f3 / 180F) * 3.141593F)) * d4;
            double d7 = (double)(-eo.a((f3 / 180F) * 3.141593F)) * d4;
            for(int i1 = 0; i1 < 8; i1++)
            {
                float f4 = (i1 & 1) * 2 - 1;
                float f5 = (i1 >> 1 & 1) * 2 - 1;
                float f6 = (i1 >> 2 & 1) * 2 - 1;
                f4 *= 0.1F;
                f5 *= 0.1F;
                f6 *= 0.1F;
                mf mf1 = h.e.a(aj.b(d1 + (double)f4, d2 + (double)f5, d3 + (double)f6), aj.b((d1 - d5) + (double)f4 + (double)f6, (d2 - d7) + (double)f5, (d3 - d6) + (double)f6));
                if(mf1 == null)
                    continue;
                double d8 = mf1.f.c(aj.b(d1, d2, d3));
                if(d8 < d4)
                    d4 = d8;
            }

            GL11.glRotatef(((dm) (bi1)).ar - f3, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(((dm) (bi1)).aq - f2, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, 0.0F, (float)(-d4));
            GL11.glRotatef(f2 - ((dm) (bi1)).aq, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(f3 - ((dm) (bi1)).ar, 1.0F, 0.0F, 0.0F);
        } else
        {
            GL11.glTranslatef(0.0F, 0.0F, -0.1F);
        }
        GL11.glRotatef(((dm) (bi1)).at + (((dm) (bi1)).ar - ((dm) (bi1)).at) * f1, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(((dm) (bi1)).as + (((dm) (bi1)).aq - ((dm) (bi1)).as) * f1 + 180F, 0.0F, 1.0F, 0.0F);
    }

    private void a(float f1, int i1)
    {
        i = 256 >> h.y.e;
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        float f2 = 0.07F;
        if(h.y.g)
            GL11.glTranslatef((float)(-(i1 * 2 - 1)) * f2, 0.0F, 0.0F);
        GLU.gluPerspective(d(f1), (float)h.c / (float)h.d, 0.05F, i);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        if(h.y.g)
            GL11.glTranslatef((float)(i1 * 2 - 1) * 0.1F, 0.0F, 0.0F);
        e(f1);
        if(h.y.f)
            f(f1);
        g(f1);
    }

    private void b(float f1, int i1)
    {
        GL11.glLoadIdentity();
        if(h.y.g)
            GL11.glTranslatef((float)(i1 * 2 - 1) * 0.1F, 0.0F, 0.0F);
        GL11.glPushMatrix();
        e(f1);
        if(h.y.f)
            f(f1);
        if(!h.y.x)
            a.a(f1);
        GL11.glPopMatrix();
        if(!h.y.x)
        {
            a.b(f1);
            e(f1);
        }
        if(h.y.f)
            f(f1);
    }

    public void b(float f1)
    {
        if(!Display.isActive())
        {
            if(System.currentTimeMillis() - l > 500L)
                h.g();
        } else
        {
            l = System.currentTimeMillis();
        }
        if(h.I)
        {
            h.B.c();
            float f2 = h.y.c * 0.6F + 0.2F;
            float f3 = f2 * f2 * f2 * 8F;
            float f4 = (float)h.B.a * f3;
            float f5 = (float)h.B.b * f3;
            int l1 = 1;
            if(h.y.d)
                l1 = -1;
            h.g.d(f4, f5 * (float)l1);
        }
        if(h.v)
            return;
        iy iy1 = new iy(h.c, h.d);
        int i1 = iy1.a();
        int j1 = iy1.b();
        int k1 = (Mouse.getX() * i1) / h.c;
        int i2 = j1 - (Mouse.getY() * j1) / h.d - 1;
        if(h.e != null)
        {
            c(f1);
            h.u.a(f1, h.p != null, k1, i2);
        } else
        {
            GL11.glViewport(0, 0, h.c, h.d);
            GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
            GL11.glClear(16640);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            b();
        }
        if(h.p != null)
        {
            GL11.glClear(256);
            h.p.a(k1, i2, f1);
        }
    }

    public void c(float f1)
    {
        a(f1);
        bi bi1 = h.g;
        e e1 = h.f;
        bq bq1 = h.h;
        double d1 = ((dm) (bi1)).aI + (((dm) (bi1)).ak - ((dm) (bi1)).aI) * (double)f1;
        double d2 = ((dm) (bi1)).aJ + (((dm) (bi1)).al - ((dm) (bi1)).aJ) * (double)f1;
        double d3 = ((dm) (bi1)).aK + (((dm) (bi1)).am - ((dm) (bi1)).aK) * (double)f1;
        for(int i1 = 0; i1 < 2; i1++)
        {
            if(h.y.g)
                if(i1 == 0)
                    GL11.glColorMask(false, true, true, false);
                else
                    GL11.glColorMask(true, false, false, false);
            GL11.glViewport(0, 0, h.c, h.d);
            i(f1);
            GL11.glClear(16640);
            GL11.glEnable(2884);
            a(f1, i1);
            j.a();
            if(h.y.e < 2)
            {
                a(-1);
                e1.a(f1);
            }
            GL11.glEnable(2912);
            a(1);
            kl kl1 = new kl();
            ((oe) (kl1)).a(d1, d2, d3);
            h.f.a(((oe) (kl1)), f1);
            h.f.a(((dm) (bi1)), false);
            a(0);
            GL11.glEnable(2912);
            GL11.glBindTexture(3553, h.n.a("/terrain.png"));
            i.a();
            e1.a(((dm) (bi1)), 0, f1);
            i.b();
            e1.a(((dm) (bi1)).e(f1), ((oe) (kl1)), f1);
            bq1.b(((kh) (bi1)), f1);
            i.a();
            a(0);
            bq1.a(((kh) (bi1)), f1);
            if(h.x != null && ((dm) (bi1)).a(gb.f))
            {
                GL11.glDisable(3008);
                e1.a(((dm) (bi1)), h.x, 0, ((dm) (bi1)).b.a(), f1);
                e1.b(((dm) (bi1)), h.x, 0, ((dm) (bi1)).b.a(), f1);
                GL11.glEnable(3008);
            }
            GL11.glBlendFunc(770, 771);
            a(0);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            GL11.glBindTexture(3553, h.n.a("/terrain.png"));
            if(h.y.i)
            {
                GL11.glColorMask(false, false, false, false);
                int j1 = e1.a(((dm) (bi1)), 1, f1);
                GL11.glColorMask(true, true, true, true);
                if(h.y.g)
                    if(i1 == 0)
                        GL11.glColorMask(false, true, true, false);
                    else
                        GL11.glColorMask(true, false, false, false);
                if(j1 > 0)
                    e1.a(1, f1);
            } else
            {
                e1.a(((dm) (bi1)), 1, f1);
            }
            GL11.glDepthMask(true);
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            if(h.x != null && !((dm) (bi1)).a(gb.f))
            {
                GL11.glDisable(3008);
                e1.a(((dm) (bi1)), h.x, 0, ((dm) (bi1)).b.a(), f1);
                e1.b(((dm) (bi1)), h.x, 0, ((dm) (bi1)).b.a(), f1);
                GL11.glEnable(3008);
            }
            GL11.glDisable(2912);
            if(h.e.d)
                h(f1);
            if(k == null);
            a(0);
            GL11.glEnable(2912);
            e1.b(f1);
            GL11.glDisable(2912);
            a(1);
            GL11.glClear(256);
            b(f1, i1);
            if(!h.y.g)
                return;
        }

        GL11.glColorMask(true, true, true, false);
    }

    private void c()
    {
        if(!h.y.i)
            return;
        bi bi1 = h.g;
        cn cn1 = h.e;
        int i1 = eo.b(((dm) (bi1)).ak);
        int j1 = eo.b(((dm) (bi1)).al);
        int k1 = eo.b(((dm) (bi1)).am);
        byte byte0 = 16;
        for(int l1 = 0; l1 < 150; l1++)
        {
            int i2 = (i1 + m.nextInt(((int) (byte0)))) - m.nextInt(((int) (byte0)));
            int j2 = (k1 + m.nextInt(((int) (byte0)))) - m.nextInt(((int) (byte0)));
            int k2 = cn1.e(i2, j2);
            int l2 = cn1.a(i2, k2 - 1, j2);
            if(k2 > j1 + byte0 || k2 < j1 - byte0)
                continue;
            float f1 = m.nextFloat();
            float f2 = m.nextFloat();
            if(l2 > 0)
                h.h.a(((nq) (new nf(cn1, (float)i2 + f1, (double)((float)k2 + 0.1F) - ly.n[l2].bg, (float)j2 + f2))));
        }

    }

    private void h(float f1)
    {
        bi bi1 = h.g;
        cn cn1 = h.e;
        int i1 = eo.b(((dm) (bi1)).ak);
        int j1 = eo.b(((dm) (bi1)).al);
        int k1 = eo.b(((dm) (bi1)).am);
        ho ho1 = ho.a;
        GL11.glDisable(2884);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glBindTexture(3553, h.n.a("/snow.png"));
        double d1 = ((dm) (bi1)).aI + (((dm) (bi1)).ak - ((dm) (bi1)).aI) * (double)f1;
        double d2 = ((dm) (bi1)).aJ + (((dm) (bi1)).al - ((dm) (bi1)).aJ) * (double)f1;
        double d3 = ((dm) (bi1)).aK + (((dm) (bi1)).am - ((dm) (bi1)).aK) * (double)f1;
        int l1 = 5;
        if(h.y.i)
            l1 = 10;
        for(int i2 = i1 - l1; i2 <= i1 + l1; i2++)
        {
            for(int j2 = k1 - l1; j2 <= k1 + l1; j2++)
            {
                int k2 = cn1.d(i2, j2);
                if(k2 < 0)
                    k2 = 0;
                int l2 = j1 - l1;
                int i3 = j1 + l1;
                if(l2 < k2)
                    l2 = k2;
                if(i3 < k2)
                    i3 = k2;
                float f2 = 2.0F;
                if(l2 != i3)
                {
                    m.setSeed(i2 * i2 * 3121 + i2 * 0x2b24abb + j2 * j2 * 0x66397 + j2 * 13761);
                    float f3 = (float)j + f1;
                    float f4 = ((float)(j & 0x1ff) + f1) / 512F;
                    float f5 = m.nextFloat() + f3 * 0.01F * (float)m.nextGaussian();
                    float f6 = m.nextFloat() + f3 * (float)m.nextGaussian() * 0.001F;
                    double d4 = (double)((float)i2 + 0.5F) - ((dm) (bi1)).ak;
                    double d5 = (double)((float)j2 + 0.5F) - ((dm) (bi1)).am;
                    float f7 = eo.a(d4 * d4 + d5 * d5) / (float)l1;
                    ho1.b();
                    float f8 = cn1.c(i2, 128, j2);
                    GL11.glColor4f(f8, f8, f8, (1.0F - f7 * f7) * 0.7F);
                    ho1.b(-d1 * 1.0D, -d2 * 1.0D, -d3 * 1.0D);
                    ho1.a(i2 + 0, l2, j2 + 0, 0.0F * f2 + f5, ((float)l2 * f2) / 8F + f4 * f2 + f6);
                    ho1.a(i2 + 1, l2, j2 + 1, 1.0F * f2 + f5, ((float)l2 * f2) / 8F + f4 * f2 + f6);
                    ho1.a(i2 + 1, i3, j2 + 1, 1.0F * f2 + f5, ((float)i3 * f2) / 8F + f4 * f2 + f6);
                    ho1.a(i2 + 0, i3, j2 + 0, 0.0F * f2 + f5, ((float)i3 * f2) / 8F + f4 * f2 + f6);
                    ho1.a(i2 + 0, l2, j2 + 1, 0.0F * f2 + f5, ((float)l2 * f2) / 8F + f4 * f2 + f6);
                    ho1.a(i2 + 1, l2, j2 + 0, 1.0F * f2 + f5, ((float)l2 * f2) / 8F + f4 * f2 + f6);
                    ho1.a(i2 + 1, i3, j2 + 0, 1.0F * f2 + f5, ((float)i3 * f2) / 8F + f4 * f2 + f6);
                    ho1.a(i2 + 0, i3, j2 + 1, 0.0F * f2 + f5, ((float)i3 * f2) / 8F + f4 * f2 + f6);
                    ho1.b(0.0D, 0.0D, 0.0D);
                    ho1.a();
                }
            }

        }

        GL11.glEnable(2884);
        GL11.glDisable(3042);
    }

    public void b()
    {
        iy iy1 = new iy(h.c, h.d);
        int i1 = iy1.a();
        int j1 = iy1.b();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, i1, j1, 0.0D, 1000D, 3000D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000F);
    }

    private void i(float f1)
    {
        cn cn1 = h.e;
        bi bi1 = h.g;
        float f2 = 1.0F / (float)(4 - h.y.e);
        f2 = 1.0F - (float)Math.pow(f2, 0.25D);
        aj aj1 = cn1.b(f1);
        float f3 = (float)aj1.a;
        float f4 = (float)aj1.b;
        float f5 = (float)aj1.c;
        aj aj2 = cn1.e(f1);
        e = (float)aj2.a;
        f = (float)aj2.b;
        g = (float)aj2.c;
        e += (f3 - e) * f2;
        f += (f4 - f) * f2;
        g += (f5 - g) * f2;
        if(((dm) (bi1)).a(gb.f))
        {
            e = 0.02F;
            f = 0.02F;
            g = 0.2F;
        } else
        if(((dm) (bi1)).a(gb.g))
        {
            e = 0.6F;
            f = 0.1F;
            g = 0.0F;
        }
        float f6 = n + (o - n) * f1;
        e *= f6;
        f *= f6;
        g *= f6;
        if(h.y.g)
        {
            float f7 = (e * 30F + f * 59F + g * 11F) / 100F;
            float f8 = (e * 30F + f * 70F) / 100F;
            float f9 = (e * 30F + g * 70F) / 100F;
            e = f7;
            f = f8;
            g = f9;
        }
        GL11.glClearColor(e, f, g, 0.0F);
    }

    private void a(int i1)
    {
        bi bi1 = h.g;
        GL11.glFog(2918, a(e, f, g, 1.0F));
        GL11.glNormal3f(0.0F, -1F, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if(((dm) (bi1)).a(gb.f))
        {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.1F);
            float f1 = 0.4F;
            float f3 = 0.4F;
            float f5 = 0.9F;
            if(h.y.g)
            {
                float f7 = (f1 * 30F + f3 * 59F + f5 * 11F) / 100F;
                float f9 = (f1 * 30F + f3 * 70F) / 100F;
                float f11 = (f1 * 30F + f5 * 70F) / 100F;
                f1 = f7;
                f3 = f9;
                f5 = f11;
            }
        } else
        if(((dm) (bi1)).a(gb.g))
        {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 2.0F);
            float f2 = 0.4F;
            float f4 = 0.3F;
            float f6 = 0.3F;
            if(h.y.g)
            {
                float f8 = (f2 * 30F + f4 * 59F + f6 * 11F) / 100F;
                float f10 = (f2 * 30F + f4 * 70F) / 100F;
                float f12 = (f2 * 30F + f6 * 70F) / 100F;
                f2 = f8;
                f4 = f10;
                f6 = f12;
            }
        } else
        {
            GL11.glFogi(2917, 9729);
            GL11.glFogf(2915, i * 0.25F);
            GL11.glFogf(2916, i);
            if(i1 < 0)
            {
                GL11.glFogf(2915, 0.0F);
                GL11.glFogf(2916, i * 0.8F);
            }
            if(GLContext.getCapabilities().GL_NV_fog_distance)
                GL11.glFogi(34138, 34139);
        }
        GL11.glEnable(2903);
        GL11.glColorMaterial(1028, 4608);
    }

    private FloatBuffer a(float f1, float f2, float f3, float f4)
    {
        d.clear();
        d.put(f1).put(f2).put(f3).put(f4);
        d.flip();
        return d;
    }

    private Minecraft h;
    private float i;
    public jh a;
    private int j;
    private kh k;
    private long l;
    private Random m;
    volatile int b;
    volatile int c;
    FloatBuffer d;
    float e;
    float f;
    float g;
    private float n;
    private float o;
}
