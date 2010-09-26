package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public abstract class ee extends bh
{

    public ee()
    {
        a = 176;
        h = 166;
        i = ((List) (new ArrayList()));
    }

    public void a(int k, int l, float f)
    {
        i();
        int i1 = (c - a) / 2;
        int j1 = (d - h) / 2;
        a(f);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
        i.b();
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(i1, j1, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(32826);
        for(int k1 = 0; k1 < i.size(); k1++)
        {
            mm mm1 = (mm)i.get(k1);
            a(mm1);
            if(mm1.a(k, l))
            {
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                int l1 = mm1.e;
                int i2 = mm1.f;
                a(l1, i2, l1 + 16, i2 + 16, 0x80ffffff, 0x80ffffff);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
            }
        }

        eu eu1 = b.g.b;
        if(eu1.e != null)
        {
            GL11.glTranslatef(0.0F, 0.0F, 32F);
            j.a(g, b.n, eu1.e, k - i1 - 8, l - j1 - 8);
            j.b(g, b.n, eu1.e, k - i1 - 8, l - j1 - 8);
        }
        GL11.glDisable(32826);
        i.a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        j();
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GL11.glPopMatrix();
    }

    protected void j()
    {
    }

    protected abstract void a(float f);

    private void a(mm mm1)
    {
        gh gh1 = mm1.b;
        int k = mm1.a;
        int l = mm1.e;
        int i1 = mm1.f;
        ev ev1 = gh1.c(k);
        if(ev1 == null)
        {
            int j1 = mm1.c();
            if(j1 >= 0)
            {
                GL11.glDisable(2896);
                b.n.b(b.n.a("/gui/items.png"));
                b(l, i1, (j1 % 16) * 16, (j1 / 16) * 16, 16, 16);
                GL11.glEnable(2896);
                return;
            }
        }
        j.a(g, b.n, ev1, l, i1);
        j.b(g, b.n, ev1, l, i1);
    }

    private dk a(int k, int l)
    {
        for(int i1 = 0; i1 < i.size(); i1++)
        {
            mm mm1 = (mm)i.get(i1);
            if(mm1.a(k, l))
                return ((dk) (mm1));
        }

        return null;
    }

    protected void a(int k, int l, int i1)
    {
        if(i1 == 0 || i1 == 1)
        {
            dk dk1 = a(k, l);
            eu eu1 = b.g.b;
            if(dk1 != null)
            {
                ev ev1 = dk1.b();
                if(ev1 != null || eu1.e != null)
                    if(ev1 != null && eu1.e == null)
                    {
                        int k1 = i1 != 0 ? (ev1.a + 1) / 2 : ev1.a;
                        eu1.e = dk1.b.a(dk1.a, k1);
                        if(ev1.a == 0)
                            dk1.b(((ev) (null)));
                        dk1.a();
                    } else
                    if(ev1 == null && eu1.e != null && dk1.a(eu1.e))
                    {
                        int l1 = i1 != 0 ? 1 : eu1.e.a;
                        if(l1 > dk1.b.e())
                            l1 = dk1.b.e();
                        dk1.b(eu1.e.a(l1));
                        if(eu1.e.a == 0)
                            eu1.e = null;
                    } else
                    if(ev1 != null && eu1.e != null)
                        if(dk1.a(eu1.e))
                        {
                            if(ev1.c != eu1.e.c)
                            {
                                if(eu1.e.a <= dk1.b.e())
                                {
                                    ev ev2 = ev1;
                                    dk1.b(eu1.e);
                                    eu1.e = ev2;
                                }
                            } else
                            if(ev1.c == eu1.e.c)
                                if(i1 == 0)
                                {
                                    int i2 = eu1.e.a;
                                    if(i2 > dk1.b.e() - ev1.a)
                                        i2 = dk1.b.e() - ev1.a;
                                    if(i2 > eu1.e.c() - ev1.a)
                                        i2 = eu1.e.c() - ev1.a;
                                    eu1.e.a(i2);
                                    if(eu1.e.a == 0)
                                        eu1.e = null;
                                    ev1.a += i2;
                                } else
                                if(i1 == 1)
                                {
                                    int j2 = 1;
                                    if(j2 > dk1.b.e() - ev1.a)
                                        j2 = dk1.b.e() - ev1.a;
                                    if(j2 > eu1.e.c() - ev1.a)
                                        j2 = eu1.e.c() - ev1.a;
                                    eu1.e.a(j2);
                                    if(eu1.e.a == 0)
                                        eu1.e = null;
                                    ev1.a += j2;
                                }
                        } else
                        if(ev1.c == eu1.e.c && eu1.e.c() > 1)
                        {
                            int k2 = ev1.a;
                            if(k2 > 0 && k2 + eu1.e.a <= eu1.e.c())
                            {
                                eu1.e.a += k2;
                                ev1.a(k2);
                                if(ev1.a == 0)
                                    dk1.b(((ev) (null)));
                                dk1.a();
                            }
                        }
                dk1.d();
            } else
            if(eu1.e != null)
            {
                int j1 = (c - a) / 2;
                int l2 = (d - h) / 2;
                if(k < j1 || l < l2 || k >= j1 + a || l >= l2 + a)
                {
                    bi bi1 = b.g;
                    if(i1 == 0)
                    {
                        ((dm) (bi1)).a(eu1.e);
                        eu1.e = null;
                    }
                    if(i1 == 1)
                    {
                        ((dm) (bi1)).a(eu1.e.a(1));
                        if(eu1.e.a == 0)
                            eu1.e = null;
                    }
                }
            }
        }
    }

    protected void b(int k, int l, int i1)
    {
        if(i1 != 0);
    }

    protected void a(char c, int k)
    {
        if(k == 1 || k == b.y.o.b)
            b.a(((bh) (null)));
    }

    public void h()
    {
        eu eu1 = b.g.b;
        if(eu1.e != null)
        {
            b.g.a(eu1.e);
            eu1.e = null;
        }
    }

    public boolean b()
    {
        return false;
    }

    private static ab j = new ab();
    protected int a;
    protected int h;
    protected List i;

}
