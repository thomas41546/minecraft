package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.IOException;

public class ft
    implements aw
{

    public ft(cn cn1, af af1, aw aw1)
    {
        f = new ga[1024];
        a = 0xc4653601;
        b = 0xc4653601;
        c = new ga(cn1, new byte[32768], 0, 0);
        c.q = true;
        c.p = true;
        g = cn1;
        e = af1;
        d = aw1;
    }

    public boolean a(int i, int j)
    {
        if(i == a && j == b && h != null)
        {
            return true;
        } else
        {
            int k = i & 0x1f;
            int l = j & 0x1f;
            int i1 = k + l * 32;
            return f[i1] != null && (f[i1] == c || f[i1].a(i, j));
        }
    }

    public ga b(int i, int j)
    {
        if(i == a && j == b && h != null)
            return h;
        int k = i & 0x1f;
        int l = j & 0x1f;
        int i1 = k + l * 32;
        if(!a(i, j))
        {
            if(f[i1] != null)
            {
                f[i1].e();
                b(f[i1]);
                a(f[i1]);
            }
            ga ga1 = c(i, j);
            if(ga1 == null)
                if(d == null)
                    ga1 = c;
                else
                    ga1 = d.b(i, j);
            f[i1] = ga1;
            if(f[i1] != null)
                f[i1].d();
            if(!f[i1].n && a(i + 1, j + 1) && a(i, j + 1) && a(i + 1, j))
                a(((aw) (this)), i, j);
            if(a(i - 1, j) && !b(i - 1, j).n && a(i - 1, j + 1) && a(i, j + 1) && a(i - 1, j))
                a(((aw) (this)), i - 1, j);
            if(a(i, j - 1) && !b(i, j - 1).n && a(i + 1, j - 1) && a(i, j - 1) && a(i + 1, j))
                a(((aw) (this)), i, j - 1);
            if(a(i - 1, j - 1) && !b(i - 1, j - 1).n && a(i - 1, j - 1) && a(i, j - 1) && a(i - 1, j))
                a(((aw) (this)), i - 1, j - 1);
        }
        a = i;
        b = j;
        h = f[i1];
        return f[i1];
    }

    private ga c(int i, int j)
    {
        if(e == null)
            return null;
        ga ga1;
        ga1 = e.a(g, i, j);
        if(ga1 != null)
            ga1.s = g.c;
        return ga1;
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    private void a(ga ga1)
    {
        if(e == null)
            return;
        try
        {
            e.b(g, ga1);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void b(ga ga1)
    {
        if(e == null)
            return;
        try
        {
            ga1.s = g.c;
            e.a(g, ga1);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void a(aw aw1, int i, int j)
    {
        ga ga1 = b(i, j);
        if(!ga1.n)
        {
            ga1.n = true;
            if(d != null)
            {
                d.a(aw1, i, j);
                ga1.f();
            }
        }
    }

    public boolean a(boolean flag, nu nu1)
    {
        int i = 0;
        int j = 0;
        if(nu1 != null)
        {
            for(int k = 0; k < f.length; k++)
                if(f[k] != null && f[k].a(flag))
                    j++;

        }
        int l = 0;
        for(int i1 = 0; i1 < f.length; i1++)
        {
            if(f[i1] == null)
                continue;
            if(flag && !f[i1].p)
                a(f[i1]);
            if(!f[i1].a(flag))
                continue;
            b(f[i1]);
            f[i1].o = false;
            if(++i == 2 && !flag)
                return false;
            if(nu1 != null && ++l % 10 == 0)
                nu1.a((l * 100) / j);
        }

        if(flag)
        {
            if(e == null)
                return true;
            e.b();
        }
        return true;
    }

    public boolean a()
    {
        if(e != null)
            e.a();
        return d.a();
    }

    public boolean b()
    {
        return true;
    }

    private ga c;
    private aw d;
    private af e;
    private ga f[];
    private cn g;
    int a;
    int b;
    private ga h;
}
