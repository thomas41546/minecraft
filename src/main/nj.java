package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;

public class nj extends hq
{

    public nj(Minecraft minecraft, gy gy1)
    {
        super(minecraft);
        c = -1;
        d = -1;
        e = -1;
        f = 0.0F;
        g = 0.0F;
        h = 0.0F;
        i = 0;
        j = false;
        l = 0;
        k = gy1;
    }

    public void a(dm dm1)
    {
        dm1.aq = -180F;
    }

    public boolean b(int i1, int j1, int k1, int l1)
    {
        k.a(((fn) (new fg(3, i1, j1, k1, l1))));
        int i2 = a.e.a(i1, j1, k1);
        int j2 = a.e.e(i1, j1, k1);
        boolean flag = super.b(i1, j1, k1, l1);
        ev ev1 = a.g.t();
        if(ev1 != null)
        {
            ev1.a(i2, i1, j1, k1);
            if(ev1.a == 0)
            {
                ev1.a(((dm) (a.g)));
                a.g.u();
            }
        }
        if(flag && a.g.b(ly.n[i2]))
            ly.n[i2].b_(a.e, i1, j1, k1, j2);
        return flag;
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        j = true;
        k.a(((fn) (new fg(0, i1, j1, k1, l1))));
        int i2 = a.e.a(i1, j1, k1);
        if(i2 > 0 && f == 0.0F)
            ly.n[i2].b(a.e, i1, j1, k1, ((dm) (a.g)));
        if(i2 > 0 && ly.n[i2].a(((dm) (a.g))) >= 1.0F)
            b(i1, j1, k1, l1);
    }

    public void a()
    {
        if(!j)
        {
            return;
        } else
        {
            j = false;
            k.a(((fn) (new fg(2, 0, 0, 0, 0))));
            f = 0.0F;
            i = 0;
            return;
        }
    }

    public void c(int i1, int j1, int k1, int l1)
    {
        j = true;
        e();
        k.a(((fn) (new fg(1, i1, j1, k1, l1))));
        if(i > 0)
        {
            i--;
            return;
        }
        if(i1 == c && j1 == d && k1 == e)
        {
            int i2 = a.e.a(i1, j1, k1);
            if(i2 == 0)
                return;
            ly ly1 = ly.n[i2];
            f += ly1.a(((dm) (a.g)));
            if(h % 4F == 0.0F && ly1 != null)
                a.A.b(ly1.bl.d(), (float)i1 + 0.5F, (float)j1 + 0.5F, (float)k1 + 0.5F, (ly1.bl.b() + 1.0F) / 8F, ly1.bl.c() * 0.5F);
            h++;
            if(f >= 1.0F)
            {
                b(i1, j1, k1, l1);
                f = 0.0F;
                g = 0.0F;
                h = 0.0F;
                i = 5;
            }
        } else
        {
            f = 0.0F;
            g = 0.0F;
            h = 0.0F;
            c = i1;
            d = j1;
            e = k1;
        }
    }

    public void a(float f1)
    {
        if(f <= 0.0F)
        {
            a.u.b = 0.0F;
            a.f.i = 0.0F;
        } else
        {
            float f2 = g + (f - g) * f1;
            a.u.b = f2;
            a.f.i = f2;
        }
    }

    public float b()
    {
        return 4F;
    }

    public void a(cn cn1)
    {
        super.a(cn1);
    }

    public void c()
    {
        e();
        g = f;
    }

    private void e()
    {
        ev ev1 = a.g.b.a();
        int i1 = 0;
        if(ev1 != null)
            i1 = ev1.c;
        if(i1 != l)
        {
            l = i1;
            k.a(((fn) (new dz(0, l))));
        }
    }

    public boolean a(dm dm1, cn cn1, ev ev1, int i1, int j1, int k1, int l1)
    {
        e();
        k.a(((fn) (new do(ev1 == null ? -1 : ev1.c, i1, j1, k1, l1))));
        return super.a(dm1, cn1, ev1, i1, j1, k1, l1);
    }

    public dm b(cn cn1)
    {
        return ((dm) (new la(a, cn1, a.i, k)));
    }

    private int c;
    private int d;
    private int e;
    private float f;
    private float g;
    private float h;
    private int i;
    private boolean j;
    private gy k;
    private int l;
}
