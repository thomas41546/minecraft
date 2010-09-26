package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.File;
import java.util.*;

public class gs extends cn
{

    public gs(gy gy1)
    {
        super("MpServer");
        z = new LinkedList();
        C = false;
        D = new fi();
        E = ((Set) (new HashSet()));
        F = ((Set) (new HashSet()));
        A = gy1;
        o = 8;
        p = 64;
        q = 8;
    }

    public void g()
    {
        c++;
        int i = a(1.0F);
        if(i != e)
        {
            e = i;
            for(int j = 0; j < s.size(); j++)
                ((im)s.get(j)).e();

        }
        for(int l = 0; l < 10 && !F.isEmpty(); l++)
        {
            kh kh1 = (kh)F.iterator().next();
            a(kh1);
        }

        A.a();
        for(int i1 = 0; i1 < z.size(); i1++)
        {
            lc lc1 = (lc)z.get(i1);
            if(--lc1.d == 0)
            {
                super.a(lc1.a, lc1.b, lc1.c, lc1.e, lc1.f);
                super.h(lc1.a, lc1.b, lc1.c);
                z.remove(i1--);
            }
        }

    }

    public void c(int i, int j, int l, int i1, int j1, int k1)
    {
        for(int l1 = 0; l1 < z.size(); l1++)
        {
            lc lc1 = (lc)z.get(l1);
            if(lc1.a >= i && lc1.b >= j && lc1.c >= l && lc1.a <= i1 && lc1.b <= j1 && lc1.c <= k1)
                z.remove(l1--);
        }

    }

    protected aw a(File file)
    {
        B = new lz(((cn) (this)));
        return ((aw) (B));
    }

    public void a()
    {
        o = 8;
        p = 64;
        q = 8;
    }

    protected void h()
    {
    }

    public void h(int i, int j, int l, int i1)
    {
    }

    public boolean a(boolean flag)
    {
        return false;
    }

    public void a(int i, int j, boolean flag)
    {
        if(flag)
            B.d(i, j);
        else
            B.c(i, j);
        if(!flag)
            b(i * 16, 0, j * 16, i * 16 + 15, 128, j * 16 + 15);
    }

    public boolean a(kh kh1)
    {
        boolean flag = super.a(kh1);
        if(kh1 instanceof bi)
            E.add(((Object) (kh1)));
        return flag;
    }

    public void d(kh kh1)
    {
        super.d(kh1);
        if(kh1 instanceof bi)
            E.remove(((Object) (kh1)));
    }

    protected void b(kh kh1)
    {
        super.b(kh1);
        if(F.contains(((Object) (kh1))))
            F.remove(((Object) (kh1)));
    }

    protected void c(kh kh1)
    {
        super.c(kh1);
        if(E.contains(((Object) (kh1))))
            F.add(((Object) (kh1)));
    }

    public void a(int i, kh kh1)
    {
        E.add(((Object) (kh1)));
        if(!a(kh1))
            F.add(((Object) (kh1)));
        D.a(i, ((Object) (kh1)));
    }

    public kh b(int i)
    {
        return (kh)D.a(i);
    }

    public kh c(int i)
    {
        kh kh1 = (kh)D.b(i);
        if(kh1 != null)
        {
            E.remove(((Object) (kh1)));
            d(kh1);
        }
        return kh1;
    }

    public boolean c(int i, int j, int l, int i1)
    {
        int j1 = a(i, j, l);
        int k1 = e(i, j, l);
        if(super.c(i, j, l, i1))
        {
            z.add(((Object) (new lc(this, i, j, l, j1, k1))));
            return true;
        } else
        {
            return false;
        }
    }

    public boolean a(int i, int j, int l, int i1, int j1)
    {
        int k1 = a(i, j, l);
        int l1 = e(i, j, l);
        if(super.a(i, j, l, i1, j1))
        {
            z.add(((Object) (new lc(this, i, j, l, k1, l1))));
            return true;
        } else
        {
            return false;
        }
    }

    public boolean a(int i, int j, int l, int i1)
    {
        int j1 = a(i, j, l);
        int k1 = e(i, j, l);
        if(super.a(i, j, l, i1))
        {
            z.add(((Object) (new lc(this, i, j, l, j1, k1))));
            return true;
        } else
        {
            return false;
        }
    }

    public boolean c(int i, int j, int l, int i1, int j1)
    {
        c(i, j, l, i, j, l);
        if(super.a(i, j, l, i1, j1))
        {
            e(i, j, l, i1);
            return true;
        } else
        {
            return false;
        }
    }

    public void b(int i, int j, int l, ic ic)
    {
        if(C)
        {
            return;
        } else
        {
            A.a(((fn) (new ny(i, j, l, ic))));
            return;
        }
    }

    public void k()
    {
        A.a(((fn) (new oh("Quitting"))));
    }

    private LinkedList z;
    private gy A;
    private lz B;
    private boolean C;
    private fi D;
    private Set E;
    private Set F;
}
