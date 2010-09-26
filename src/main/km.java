package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.ArrayList;
import java.util.Random;

public class km extends ly
{

    protected km(int k, ly ly1)
    {
        super(k, ly1.bb, ly1.bn);
        a = ly1;
        c(ly1.bd);
        b(ly1.be / 3F);
        a(ly1.bl);
    }

    public boolean b()
    {
        return false;
    }

    public boolean c()
    {
        return false;
    }

    public int f()
    {
        return 10;
    }

    public boolean c(nm nm, int k, int l, int i1, int j1)
    {
        return super.c(nm, k, l, i1, j1);
    }

    public void a(cn cn1, int k, int l, int i1, cf cf, ArrayList arraylist)
    {
        int j1 = cn1.e(k, l, i1);
        if(j1 == 0)
        {
            a(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.a(cn1, k, l, i1, cf, arraylist);
            a(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.a(cn1, k, l, i1, cf, arraylist);
        } else
        if(j1 == 1)
        {
            a(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.a(cn1, k, l, i1, cf, arraylist);
            a(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.a(cn1, k, l, i1, cf, arraylist);
        } else
        if(j1 == 2)
        {
            a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.a(cn1, k, l, i1, cf, arraylist);
            a(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.a(cn1, k, l, i1, cf, arraylist);
        } else
        if(j1 == 3)
        {
            a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.a(cn1, k, l, i1, cf, arraylist);
            a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.a(cn1, k, l, i1, cf, arraylist);
        }
        a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void a(cn cn1, int k, int l, int i1, int j1)
    {
        if(cn1.y)
            return;
        if(cn1.f(k, l + 1, i1).a())
        {
            cn1.d(k, l, i1, a.bc);
        } else
        {
            h(cn1, k, l, i1);
            h(cn1, k + 1, l - 1, i1);
            h(cn1, k - 1, l - 1, i1);
            h(cn1, k, l - 1, i1 - 1);
            h(cn1, k, l - 1, i1 + 1);
            h(cn1, k + 1, l + 1, i1);
            h(cn1, k - 1, l + 1, i1);
            h(cn1, k, l + 1, i1 - 1);
            h(cn1, k, l + 1, i1 + 1);
        }
        a.a(cn1, k, l, i1, j1);
    }

    private void h(cn cn1, int k, int l, int i1)
    {
        if(!j(cn1, k, l, i1))
            return;
        byte byte0 = -1;
        if(j(cn1, k + 1, l + 1, i1))
            byte0 = 0;
        if(j(cn1, k - 1, l + 1, i1))
            byte0 = 1;
        if(j(cn1, k, l + 1, i1 + 1))
            byte0 = 2;
        if(j(cn1, k, l + 1, i1 - 1))
            byte0 = 3;
        if(byte0 < 0)
        {
            if(i(cn1, k + 1, l, i1) && !i(cn1, k - 1, l, i1))
                byte0 = 0;
            if(i(cn1, k - 1, l, i1) && !i(cn1, k + 1, l, i1))
                byte0 = 1;
            if(i(cn1, k, l, i1 + 1) && !i(cn1, k, l, i1 - 1))
                byte0 = 2;
            if(i(cn1, k, l, i1 - 1) && !i(cn1, k, l, i1 + 1))
                byte0 = 3;
        }
        if(byte0 < 0)
        {
            if(j(cn1, k - 1, l - 1, i1))
                byte0 = 0;
            if(j(cn1, k + 1, l - 1, i1))
                byte0 = 1;
            if(j(cn1, k, l - 1, i1 - 1))
                byte0 = 2;
            if(j(cn1, k, l - 1, i1 + 1))
                byte0 = 3;
        }
        if(byte0 >= 0)
            cn1.b(k, l, i1, ((int) (byte0)));
    }

    private boolean i(cn cn1, int k, int l, int i1)
    {
        return cn1.f(k, l, i1).a();
    }

    private boolean j(cn cn1, int k, int l, int i1)
    {
        int j1 = cn1.a(k, l, i1);
        if(j1 == 0)
            return false;
        else
            return ly.n[j1].f() == 10;
    }

    public void b(cn cn1, int k, int l, int i1, Random random)
    {
        a.b(cn1, k, l, i1, random);
    }

    public void b(cn cn1, int k, int l, int i1, dm dm)
    {
        a.b(cn1, k, l, i1, dm);
    }

    public void b(cn cn1, int k, int l, int i1, int j1)
    {
        a.b(cn1, k, l, i1, j1);
    }

    public float c(nm nm, int k, int l, int i1)
    {
        return a.c(nm, k, l, i1);
    }

    public float a(kh kh)
    {
        return a.a(kh);
    }

    public int g()
    {
        return a.g();
    }

    public int a(int k, Random random)
    {
        return a.a(k, random);
    }

    public int a(Random random)
    {
        return a.a(random);
    }

    public int a(int k, int l)
    {
        return a.a(k, l);
    }

    public int a(int k)
    {
        return a.a(k);
    }

    public int a(nm nm, int k, int l, int i1, int j1)
    {
        return a.a(nm, k, l, i1, j1);
    }

    public int a()
    {
        return a.a();
    }

    public cf f(cn cn1, int k, int l, int i1)
    {
        return a.f(cn1, k, l, i1);
    }

    public void a(cn cn1, int k, int l, int i1, kh kh, aj aj)
    {
        a.a(cn1, k, l, i1, kh, aj);
    }

    public boolean h()
    {
        return a.h();
    }

    public boolean a(int k, boolean flag)
    {
        return a.a(k, flag);
    }

    public boolean a(cn cn1, int k, int l, int i1)
    {
        return a.a(cn1, k, l, i1);
    }

    public void e(cn cn1, int k, int l, int i1)
    {
        a(cn1, k, l, i1, 0);
        a.e(cn1, k, l, i1);
    }

    public void b(cn cn1, int k, int l, int i1)
    {
        a.b(cn1, k, l, i1);
    }

    public void a(cn cn1, int k, int l, int i1, int j1, float f1)
    {
        a.a(cn1, k, l, i1, j1, f1);
    }

    public void b_(cn cn1, int k, int l, int i1, int j1)
    {
        a.b_(cn1, k, l, i1, j1);
    }

    public void a(cn cn1, int k, int l, int i1, kh kh)
    {
        a.a(cn1, k, l, i1, kh);
    }

    public void a(cn cn1, int k, int l, int i1, Random random)
    {
        a.a(cn1, k, l, i1, random);
    }

    public boolean a(cn cn1, int k, int l, int i1, dm dm)
    {
        return a.a(cn1, k, l, i1, dm);
    }

    public void c(cn cn1, int k, int l, int i1)
    {
        a.c(cn1, k, l, i1);
    }

    private ly a;
}
