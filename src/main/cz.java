package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class cz
{

    public cz(nm nm1)
    {
        b = new fx();
        c = new fi();
        d = new a[32];
        a = nm1;
    }

    public bl a(kh kh1, kh kh2, float f)
    {
        return a(kh1, kh2.ak, kh2.au.b, kh2.am, f);
    }

    public bl a(kh kh1, int i, int j, int k, float f)
    {
        return a(kh1, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, f);
    }

    private bl a(kh kh1, double d1, double d2, double d3, 
            float f)
    {
        b.a();
        c.a();
        a a1 = a(eo.b(kh1.au.a), eo.b(kh1.au.b), eo.b(kh1.au.c));
        a a2 = a(eo.b(d1 - (double)(kh1.aC / 2.0F)), eo.b(d2), eo.b(d3 - (double)(kh1.aC / 2.0F)));
        a a3 = new a(eo.d(kh1.aC + 1.0F), eo.d(kh1.aD + 1.0F), eo.d(kh1.aC + 1.0F));
        bl bl1 = a(kh1, a1, a2, a3, f);
        return bl1;
    }

    private bl a(kh kh1, a a1, a a2, a a3, float f)
    {
        a1.f = 0.0F;
        a1.g = a1.a(a2);
        a1.h = a1.g;
        b.a();
        b.a(a1);
        a a4 = a1;
        while(!b.c()) 
        {
            a a5 = b.b();
            if(a5.d == a2.d)
                return a(a1, a2);
            if(a5.a(a2) < a4.a(a2))
                a4 = a5;
            a5.j = true;
            int i = b(kh1, a5, a3, a2, f);
            int j = 0;
            while(j < i) 
            {
                a a6 = d[j];
                float f1 = a5.f + a5.a(a6);
                if(!a6.a() || f1 < a6.f)
                {
                    a6.i = a5;
                    a6.f = f1;
                    a6.g = a6.a(a2);
                    if(a6.a())
                    {
                        b.a(a6, a6.f + a6.g);
                    } else
                    {
                        a6.h = a6.f + a6.g;
                        b.a(a6);
                    }
                }
                j++;
            }
        }
        if(a4 == a1)
            return null;
        else
            return a(a1, a4);
    }

    private int b(kh kh1, a a1, a a2, a a3, float f)
    {
        int i = 0;
        int j = 0;
        if(a(kh1, a1.a, a1.b + 1, a1.c, a2) > 0)
            j = 1;
        a a4 = a(kh1, a1.a, a1.b, a1.c + 1, a2, j);
        a a5 = a(kh1, a1.a - 1, a1.b, a1.c, a2, j);
        a a6 = a(kh1, a1.a + 1, a1.b, a1.c, a2, j);
        a a7 = a(kh1, a1.a, a1.b, a1.c - 1, a2, j);
        if(a4 != null && !a4.j && a4.a(a3) < f)
            d[i++] = a4;
        if(a5 != null && !a5.j && a5.a(a3) < f)
            d[i++] = a5;
        if(a6 != null && !a6.j && a6.a(a3) < f)
            d[i++] = a6;
        if(a7 != null && !a7.j && a7.a(a3) < f)
            d[i++] = a7;
        return i;
    }

    private a a(kh kh1, int i, int j, int k, a a1, int l)
    {
        a a2 = null;
        if(a(kh1, i, j, k, a1) > 0)
            a2 = a(i, j, k);
        if(a2 == null && a(kh1, i, j + l, k, a1) > 0)
        {
            a2 = a(i, j + l, k);
            j += l;
        }
        if(a2 != null)
        {
            int i1 = 0;
            for(int j1 = 0; j > 0 && (j1 = a(kh1, i, j - 1, k, a1)) > 0; j--)
            {
                if(j1 < 0)
                    return null;
                if(++i1 >= 4)
                    return null;
            }

            if(j > 0)
                a2 = a(i, j, k);
        }
        return a2;
    }

    private final a a(int i, int j, int k)
    {
        int l = i | j << 10 | k << 20;
        a a1 = (a)c.a(l);
        if(a1 == null)
        {
            a1 = new a(i, j, k);
            c.a(l, ((Object) (a1)));
        }
        return a1;
    }

    private int a(kh kh1, int i, int j, int k, a a1)
    {
        for(int l = i; l < i + a1.a; l++)
        {
            for(int i1 = j; i1 < j + a1.b; i1++)
            {
                for(int j1 = k; j1 < k + a1.c; j1++)
                {
                    gb gb1 = a.f(i, j, k);
                    if(gb1.c())
                        return 0;
                    if(gb1 == gb.f || gb1 == gb.g)
                        return -1;
                }

            }

        }

        return 1;
    }

    private bl a(a a1, a a2)
    {
        int i = 1;
        for(a a3 = a2; a3.i != null; a3 = a3.i)
            i++;

        a aa[] = new a[i];
        a a4 = a2;
        for(aa[--i] = a4; a4.i != null; aa[--i] = a4)
            a4 = a4.i;

        return new bl(aa);
    }

    private nm a;
    private fx b;
    private fi c;
    private a d[];
}
