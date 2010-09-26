package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public final class ev
{

    public ev(ly ly1)
    {
        this(ly1, 1);
    }

    public ev(ly ly1, int i)
    {
        this(ly1.bc, i);
    }

    public ev(di di1)
    {
        this(di1, 1);
    }

    public ev(di di1, int i)
    {
        this(di1.aS, i);
    }

    public ev(int i)
    {
        this(i, 1);
    }

    public ev(int i, int j)
    {
        a = 0;
        c = i;
        a = j;
    }

    public ev(int i, int j, int k)
    {
        a = 0;
        c = i;
        a = j;
        d = k;
    }

    public ev(hm hm1)
    {
        a = 0;
        b(hm1);
    }

    public ev a(int i)
    {
        a -= i;
        return new ev(c, i, d);
    }

    public di a()
    {
        return di.c[c];
    }

    public int b()
    {
        return a().a(this);
    }

    public boolean a(dm dm, cn cn, int i, int j, int k, int l)
    {
        return a().a(this, dm, cn, i, j, k, l);
    }

    public float a(ly ly1)
    {
        return a().a(this, ly1);
    }

    public ev a(cn cn, dm dm)
    {
        return a().a(this, cn, dm);
    }

    public hm a(hm hm1)
    {
        hm1.a("id", (short)c);
        hm1.a("Count", (byte)a);
        hm1.a("Damage", (short)d);
        return hm1;
    }

    public void b(hm hm1)
    {
        c = ((int) (hm1.d("id")));
        a = ((int) (hm1.c("Count")));
        d = ((int) (hm1.d("Damage")));
    }

    public int c()
    {
        return a().b();
    }

    public int d()
    {
        return di.c[c].c();
    }

    public void b(int i)
    {
        d += i;
        if(d > d())
        {
            a--;
            if(a < 0)
                a = 0;
            d = 0;
        }
    }

    public void a(ge ge)
    {
        di.c[c].a(this, ge);
    }

    public void a(int i, int j, int k, int l)
    {
        di.c[c].a(this, i, j, k, l);
    }

    public int a(kh kh)
    {
        return di.c[c].a(kh);
    }

    public boolean b(ly ly1)
    {
        return di.c[c].a(ly1);
    }

    public void a(dm dm)
    {
    }

    public void b(ge ge)
    {
        di.c[c].b(this, ge);
    }

    public ev e()
    {
        return new ev(c, a, d);
    }

    public int a;
    public int b;
    public int c;
    public int d;
}
