package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;

public class hq
{

    public hq(Minecraft minecraft)
    {
        b = false;
        a = minecraft;
    }

    public void a(cn cn1)
    {
    }

    public void a(int i, int j, int k, int l)
    {
        b(i, j, k, l);
    }

    public boolean b(int i, int j, int k, int l)
    {
        a.h.a(i, j, k);
        cn cn1 = a.e;
        ly ly1 = ly.n[cn1.a(i, j, k)];
        int i1 = cn1.e(i, j, k);
        boolean flag = cn1.d(i, j, k, 0);
        if(ly1 != null && flag)
        {
            a.A.b(ly1.bl.a(), (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, (ly1.bl.b() + 1.0F) / 2.0F, ly1.bl.c() * 0.8F);
            ly1.b(cn1, i, j, k, i1);
        }
        return flag;
    }

    public void c(int i, int j, int k, int l)
    {
    }

    public void a()
    {
    }

    public void a(float f)
    {
    }

    public float b()
    {
        return 5F;
    }

    public void a(dm dm)
    {
    }

    public void c()
    {
    }

    public boolean d()
    {
        return true;
    }

    public void b(dm dm)
    {
    }

    public boolean a(dm dm, cn cn1, ev ev1, int i, int j, int k, int l)
    {
        int i1 = cn1.a(i, j, k);
        if(i1 > 0 && ly.n[i1].a(cn1, i, j, k, dm))
            return true;
        if(ev1 == null)
            return false;
        else
            return ev1.a(dm, cn1, i, j, k, l);
    }

    public dm b(cn cn1)
    {
        return ((dm) (new bi(a, cn1, a.i)));
    }

    protected final Minecraft a;
    public boolean b;
}
