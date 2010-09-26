package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;

public class ia extends hq
{

    public ia(Minecraft minecraft)
    {
        super(minecraft);
        c = -1;
        d = -1;
        e = -1;
        f = 0.0F;
        g = 0.0F;
        h = 0.0F;
        i = 0;
        j = ((az) (new k(this, 200, co, new Class[] {
            mb, cw, dd, ax, ma
        })));
        k = new az(15, ag, new Class[] {
            bo, mv, am, mz
        });
    }

    public void a(dm dm1)
    {
        dm1.aq = -180F;
    }

    public boolean b(int l, int i1, int j1, int k1)
    {
        int l1 = a.e.a(l, i1, j1);
        int i2 = a.e.e(l, i1, j1);
        boolean flag = super.b(l, i1, j1, k1);
        ev ev1 = a.g.t();
        boolean flag1 = a.g.b(ly.n[l1]);
        if(ev1 != null)
        {
            ev1.a(l1, l, i1, j1);
            if(ev1.a == 0)
            {
                ev1.a(((dm) (a.g)));
                a.g.u();
            }
        }
        if(flag && flag1)
            ly.n[l1].a_(a.e, l, i1, j1, i2);
        return flag;
    }

    public void a(int l, int i1, int j1, int k1)
    {
        int l1 = a.e.a(l, i1, j1);
        if(l1 > 0 && f == 0.0F)
            ly.n[l1].b(a.e, l, i1, j1, ((dm) (a.g)));
        if(l1 > 0 && ly.n[l1].a(((dm) (a.g))) >= 1.0F)
            b(l, i1, j1, k1);
    }

    public void a()
    {
        f = 0.0F;
        i = 0;
    }

    public void c(int l, int i1, int j1, int k1)
    {
        if(i > 0)
        {
            i--;
            return;
        }
        if(l == c && i1 == d && j1 == e)
        {
            int l1 = a.e.a(l, i1, j1);
            if(l1 == 0)
                return;
            ly ly1 = ly.n[l1];
            f += ly1.a(((dm) (a.g)));
            if(h % 4F == 0.0F && ly1 != null)
                a.A.b(ly1.bl.d(), (float)l + 0.5F, (float)i1 + 0.5F, (float)j1 + 0.5F, (ly1.bl.b() + 1.0F) / 8F, ly1.bl.c() * 0.5F);
            h++;
            if(f >= 1.0F)
            {
                b(l, i1, j1, k1);
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
            c = l;
            d = i1;
            e = j1;
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
        g = f;
        j.a(a.e);
        k.a(a.e);
        a.A.c();
    }

    private int c;
    private int d;
    private int e;
    private float f;
    private float g;
    private float h;
    private int i;
    private az j;
    private az k;
}
