package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class bu extends dn
{

    public bu()
    {
        super(((fo) (new cr(0.0F))), 0.5F);
        f = (cr)d;
        g = new cr(1.0F);
        h = new cr(0.5F);
    }

    protected boolean a(dm dm1, int j)
    {
        ev ev1 = dm1.b.d(3 - j);
        if(ev1 != null)
        {
            di di1 = ev1.a();
            if(di1 instanceof mr)
            {
                mr mr1 = (mr)di1;
                a((new StringBuilder()).append("/armor/").append(i[mr1.aZ]).append("_").append(j != 2 ? 1 : 2).append(".png").toString());
                cr cr1 = j != 2 ? g : h;
                cr1.a.h = j == 0;
                cr1.b.h = j == 0;
                cr1.c.h = j == 1 || j == 2;
                cr1.d.h = j == 1;
                cr1.e.h = j == 1;
                cr1.f.h = j == 2 || j == 3;
                cr1.g.h = j == 2 || j == 3;
                a(((fo) (cr1)));
                return true;
            }
        }
        return false;
    }

    public void a(dm dm1, double d, double d1, double d2, 
            float f1, float f2)
    {
        ev ev1 = dm1.b.a();
        g.i = h.i = f.i = ev1 != null;
        g.j = h.j = f.j = dm1.o();
        super.a(((ge) (dm1)), d, d1 - (double)dm1.aB, d2, f1, f2);
        g.j = h.j = f.j = false;
        g.i = h.i = f.i = false;
        kd kd1 = a();
        float f3 = 1.6F;
        float f4 = 0.01666667F * f3;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.0F, (float)d1 + 2.3F, (float)d2);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-a.i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(a.j, 1.0F, 0.0F, 0.0F);
        float f5 = dm1.d(((kh) (a.h)));
        f4 = (float)((double)f4 * (Math.sqrt(f5) / 2D));
        GL11.glScalef(-f4, -f4, f4);
        String s = dm1.i;
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        ho ho1 = ho.a;
        GL11.glDisable(3553);
        ho1.b();
        int j = kd1.a(s) / 2;
        ho1.a(0.0F, 0.0F, 0.0F, 0.25F);
        ho1.a(-j - 1, -1D, 0.0D);
        ho1.a(-j - 1, 8D, 0.0D);
        ho1.a(j + 1, 8D, 0.0D);
        ho1.a(j + 1, -1D, 0.0D);
        ho1.a();
        GL11.glEnable(3553);
        kd1.b(s, -kd1.a(s) / 2, 0, 0x20ffffff);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        kd1.b(s, -kd1.a(s) / 2, 0, -1);
        GL11.glEnable(2896);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    protected void a(dm dm1, float f1)
    {
        ev ev1 = dm1.b.a();
        if(ev1 != null)
        {
            GL11.glPushMatrix();
            f.d.b(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            if(ev1.c < 256 && bc.a(ly.n[ev1.c].f()))
            {
                float f2 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f2 *= 0.75F;
                GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f2, -f2, f2);
            } else
            if(di.c[ev1.c].a())
            {
                float f3 = 0.625F;
                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(f3, -f3, f3);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else
            {
                float f4 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f4, f4, f4);
                GL11.glRotatef(60F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);
            }
            a.f.a(ev1);
            GL11.glPopMatrix();
        }
    }

    protected void b(dm dm1, float f1)
    {
        float f2 = 0.9375F;
        GL11.glScalef(f2, f2, f2);
    }

    public void b()
    {
        f.k = 0.0F;
        f.a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        f.d.a(0.0625F);
    }

    protected volatile void a(ge ge, float f1)
    {
        b((dm)ge, f1);
    }

    protected volatile boolean a(ge ge, int j)
    {
        return a((dm)ge, j);
    }

    protected volatile void b(ge ge, float f1)
    {
        a((dm)ge, f1);
    }

    public volatile void a(ge ge, double d, double d1, double d2, 
            float f1, float f2)
    {
        a((dm)ge, d, d1, d2, f1, f2);
    }

    public volatile void a(kh kh, double d, double d1, double d2, 
            float f1, float f2)
    {
        a((dm)kh, d, d1, d2, f1, f2);
    }

    private cr f;
    private cr g;
    private cr h;
    private static final String i[] = {
        "cloth", "chain", "iron", "diamond", "gold"
    };

}
