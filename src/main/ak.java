package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public abstract class ak
{

    public ak()
    {
        d = ((fo) (new cr()));
        e = new bc();
        b = 0.0F;
        c = 1.0F;
    }

    public abstract void a(kh kh1, double d1, double d2, double d3, 
            float f, float f1);

    protected void a(String s)
    {
        ey ey1 = a.e;
        ey1.b(ey1.a(s));
    }

    protected void a(String s, String s1)
    {
        ey ey1 = a.e;
        ey1.b(ey1.a(s, s1));
    }

    private void a(kh kh1, double d1, double d2, double d3, 
            float f)
    {
        GL11.glDisable(2896);
        int i = ly.as.bb;
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        float f1 = (float)j / 256F;
        float f2 = ((float)j + 15.99F) / 256F;
        float f3 = (float)k / 256F;
        float f4 = ((float)k + 15.99F) / 256F;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d1, (float)d2, (float)d3);
        float f5 = kh1.aC * 1.4F;
        GL11.glScalef(f5, f5, f5);
        a("/terrain.png");
        ho ho1 = ho.a;
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.0F;
        float f9 = kh1.aD / kh1.aC;
        GL11.glRotatef(-a.i, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0.0F, 0.4F + (float)(int)f9 * 0.02F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        ho1.b();
        while(f9 > 0.0F) 
        {
            ho1.a(f6 - f7, 0.0F - f8, 0.0D, f2, f4);
            ho1.a(0.0F - f7, 0.0F - f8, 0.0D, f1, f4);
            ho1.a(0.0F - f7, 1.4F - f8, 0.0D, f1, f3);
            ho1.a(f6 - f7, 1.4F - f8, 0.0D, f2, f3);
            f9--;
            f8--;
            f6 *= 0.9F;
            GL11.glTranslatef(0.0F, 0.0F, -0.04F);
        }
        ho1.a();
        GL11.glPopMatrix();
        GL11.glEnable(2896);
    }

    private void c(kh kh1, double d1, double d2, double d3, 
            float f, float f1)
    {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        ey ey1 = a.e;
        ey1.b(ey1.a("%%/shadow.png"));
        cn cn1 = b();
        GL11.glDepthMask(false);
        float f2 = b;
        double d4 = kh1.aI + (kh1.ak - kh1.aI) * (double)f1;
        double d5 = kh1.aJ + (kh1.al - kh1.aJ) * (double)f1 + (double)kh1.h_();
        double d6 = kh1.aK + (kh1.am - kh1.aK) * (double)f1;
        int i = eo.b(d4 - (double)f2);
        int j = eo.b(d4 + (double)f2);
        int k = eo.b(d5 - (double)f2);
        int l = eo.b(d5);
        int i1 = eo.b(d6 - (double)f2);
        int j1 = eo.b(d6 + (double)f2);
        double d7 = d1 - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        ho ho1 = ho.a;
        ho1.b();
        for(int k1 = i; k1 <= j; k1++)
        {
            for(int l1 = k; l1 <= l; l1++)
            {
                for(int i2 = i1; i2 <= j1; i2++)
                {
                    int j2 = cn1.a(k1, l1 - 1, i2);
                    if(j2 > 0 && cn1.j(k1, l1, i2) > 3)
                        a(ly.n[j2], d1, d2 + (double)kh1.h_(), d3, k1, l1, i2, f, f2, d7, d8 + (double)kh1.h_(), d9);
                }

            }

        }

        ho1.a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
    }

    private cn b()
    {
        return a.g;
    }

    private void a(ly ly1, double d1, double d2, double d3, 
            int i, int j, int k, float f, float f1, double d4, 
            double d5, double d6)
    {
        ho ho1 = ho.a;
        if(!ly1.c())
            return;
        double d7 = ((double)f - (d2 - ((double)j + d5)) / 2D) * 0.5D * (double)b().c(i, j, k);
        if(d7 < 0.0D)
            return;
        if(d7 > 1.0D)
            d7 = 1.0D;
        ho1.a(1.0F, 1.0F, 1.0F, (float)d7);
        double d8 = (double)i + ly1.bf + d4;
        double d9 = (double)i + ly1.bi + d4;
        double d10 = (double)j + ly1.bg + d5 + 0.015625D;
        double d11 = (double)k + ly1.bh + d6;
        double d12 = (double)k + ly1.bk + d6;
        float f2 = (float)((d1 - d8) / 2D / (double)f1 + 0.5D);
        float f3 = (float)((d1 - d9) / 2D / (double)f1 + 0.5D);
        float f4 = (float)((d3 - d11) / 2D / (double)f1 + 0.5D);
        float f5 = (float)((d3 - d12) / 2D / (double)f1 + 0.5D);
        ho1.a(d8, d10, d11, f2, f4);
        ho1.a(d8, d10, d12, f2, f5);
        ho1.a(d9, d10, d12, f3, f5);
        ho1.a(d9, d10, d11, f3, f4);
    }

    public static void a(cf cf1, double d1, double d2, double d3)
    {
        GL11.glDisable(3553);
        ho ho1 = ho.a;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        ho1.b();
        ho1.b(d1, d2, d3);
        ho1.b(0.0F, 0.0F, -1F);
        ho1.a(cf1.a, cf1.e, cf1.c);
        ho1.a(cf1.d, cf1.e, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.c);
        ho1.a(cf1.a, cf1.b, cf1.c);
        ho1.b(0.0F, 0.0F, 1.0F);
        ho1.a(cf1.a, cf1.b, cf1.f);
        ho1.a(cf1.d, cf1.b, cf1.f);
        ho1.a(cf1.d, cf1.e, cf1.f);
        ho1.a(cf1.a, cf1.e, cf1.f);
        ho1.b(0.0F, -1F, 0.0F);
        ho1.a(cf1.a, cf1.b, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.f);
        ho1.a(cf1.a, cf1.b, cf1.f);
        ho1.b(0.0F, 1.0F, 0.0F);
        ho1.a(cf1.a, cf1.e, cf1.f);
        ho1.a(cf1.d, cf1.e, cf1.f);
        ho1.a(cf1.d, cf1.e, cf1.c);
        ho1.a(cf1.a, cf1.e, cf1.c);
        ho1.b(-1F, 0.0F, 0.0F);
        ho1.a(cf1.a, cf1.b, cf1.f);
        ho1.a(cf1.a, cf1.e, cf1.f);
        ho1.a(cf1.a, cf1.e, cf1.c);
        ho1.a(cf1.a, cf1.b, cf1.c);
        ho1.b(1.0F, 0.0F, 0.0F);
        ho1.a(cf1.d, cf1.b, cf1.c);
        ho1.a(cf1.d, cf1.e, cf1.c);
        ho1.a(cf1.d, cf1.e, cf1.f);
        ho1.a(cf1.d, cf1.b, cf1.f);
        ho1.b(0.0D, 0.0D, 0.0D);
        ho1.a();
        GL11.glEnable(3553);
    }

    public static void a(cf cf1)
    {
        ho ho1 = ho.a;
        ho1.b();
        ho1.a(cf1.a, cf1.e, cf1.c);
        ho1.a(cf1.d, cf1.e, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.c);
        ho1.a(cf1.a, cf1.b, cf1.c);
        ho1.a(cf1.a, cf1.b, cf1.f);
        ho1.a(cf1.d, cf1.b, cf1.f);
        ho1.a(cf1.d, cf1.e, cf1.f);
        ho1.a(cf1.a, cf1.e, cf1.f);
        ho1.a(cf1.a, cf1.b, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.f);
        ho1.a(cf1.a, cf1.b, cf1.f);
        ho1.a(cf1.a, cf1.e, cf1.f);
        ho1.a(cf1.d, cf1.e, cf1.f);
        ho1.a(cf1.d, cf1.e, cf1.c);
        ho1.a(cf1.a, cf1.e, cf1.c);
        ho1.a(cf1.a, cf1.b, cf1.f);
        ho1.a(cf1.a, cf1.e, cf1.f);
        ho1.a(cf1.a, cf1.e, cf1.c);
        ho1.a(cf1.a, cf1.b, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.c);
        ho1.a(cf1.d, cf1.e, cf1.c);
        ho1.a(cf1.d, cf1.e, cf1.f);
        ho1.a(cf1.d, cf1.b, cf1.f);
        ho1.a();
    }

    public void a(kx kx1)
    {
        a = kx1;
    }

    public void b(kh kh1, double d1, double d2, double d3, 
            float f, float f1)
    {
        if(a.k.i && b > 0.0F)
        {
            double d4 = a.a(kh1.ak, kh1.al, kh1.am);
            float f2 = (float)((1.0D - d4 / 256D) * (double)c);
            if(f2 > 0.0F)
                c(kh1, d1, d2, d3, f2, f1);
        }
        if(kh1.aT > 0)
            a(kh1, d1, d2, d3, f1);
    }

    public kd a()
    {
        return a.a();
    }

    protected kx a;
    private fo d;
    private bc e;
    protected float b;
    protected float c;
}
