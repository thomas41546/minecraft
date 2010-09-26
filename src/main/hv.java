package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class hv extends jp
{

    protected hv(int i, gb gb1)
    {
        super(i, gb1);
        a = 0;
        b = new boolean[4];
        c = new int[4];
    }

    private void j(cn cn1, int i, int i1, int j1)
    {
        int k1 = cn1.e(i, i1, j1);
        cn1.a(i, i1, j1, bc + 1, k1);
        cn1.b(i, i1, j1, i, i1, j1);
        cn1.h(i, i1, j1);
    }

    public void a(cn cn1, int i, int i1, int j1, Random random)
    {
        int k1 = h(cn1, i, i1, j1);
        boolean flag = true;
        if(k1 > 0)
        {
            int l1 = -100;
            a = 0;
            l1 = f(cn1, i - 1, i1, j1, l1);
            l1 = f(cn1, i + 1, i1, j1, l1);
            l1 = f(cn1, i, i1, j1 - 1, l1);
            l1 = f(cn1, i, i1, j1 + 1, l1);
            int i2 = l1 + d;
            if(i2 >= 8 || l1 < 0)
                i2 = -1;
            if(h(cn1, i, i1 + 1, j1) >= 0)
            {
                int k2 = h(cn1, i, i1 + 1, j1);
                if(k2 >= 8)
                    i2 = k2;
                else
                    i2 = k2 + 8;
            }
            if(a >= 2 && bn == gb.f)
                if(cn1.g(i, i1 - 1, j1))
                    i2 = 0;
                else
                if(cn1.f(i, i1 - 1, j1) == bn && cn1.e(i, i1, j1) == 0)
                    i2 = 0;
            if(bn == gb.g && k1 < 8 && i2 < 8 && i2 > k1 && random.nextInt(4) != 0)
            {
                i2 = k1;
                flag = false;
            }
            if(i2 != k1)
            {
                k1 = i2;
                if(k1 < 0)
                {
                    cn1.d(i, i1, j1, 0);
                } else
                {
                    cn1.b(i, i1, j1, k1);
                    cn1.h(i, i1, j1, bc);
                    cn1.g(i, i1, j1, bc);
                }
            } else
            if(flag)
                j(cn1, i, i1, j1);
        } else
        {
            j(cn1, i, i1, j1);
        }
        if(m(cn1, i, i1 - 1, j1))
        {
            if(k1 >= 8)
                cn1.b(i, i1 - 1, j1, bc, k1);
            else
                cn1.b(i, i1 - 1, j1, bc, k1 + 8);
        } else
        if(k1 >= 0 && (k1 == 0 || l(cn1, i, i1 - 1, j1)))
        {
            boolean aflag[] = k(cn1, i, i1, j1);
            int j2 = k1 + d;
            if(k1 >= 8)
                j2 = 1;
            if(j2 >= 8)
                return;
            if(aflag[0])
                g(cn1, i - 1, i1, j1, j2);
            if(aflag[1])
                g(cn1, i + 1, i1, j1, j2);
            if(aflag[2])
                g(cn1, i, i1, j1 - 1, j2);
            if(aflag[3])
                g(cn1, i, i1, j1 + 1, j2);
        }
    }

    private void g(cn cn1, int i, int i1, int j1, int k1)
    {
        if(m(cn1, i, i1, j1))
        {
            int l1 = cn1.a(i, i1, j1);
            if(l1 > 0)
                if(bn == gb.g)
                    i(cn1, i, i1, j1);
                else
                    ly.n[l1].b_(cn1, i, i1, j1, cn1.e(i, i1, j1));
            cn1.b(i, i1, j1, bc, k1);
        }
    }

    private int a(cn cn1, int i, int i1, int j1, int k1, int l1)
    {
        int i2 = 1000;
        for(int j2 = 0; j2 < 4; j2++)
        {
            if(j2 == 0 && l1 == 1 || j2 == 1 && l1 == 0 || j2 == 2 && l1 == 3 || j2 == 3 && l1 == 2)
                continue;
            int k2 = i;
            int l2 = i1;
            int i3 = j1;
            if(j2 == 0)
                k2--;
            if(j2 == 1)
                k2++;
            if(j2 == 2)
                i3--;
            if(j2 == 3)
                i3++;
            if(l(cn1, k2, l2, i3) || cn1.f(k2, l2, i3) == bn && cn1.e(k2, l2, i3) == 0)
                continue;
            if(!l(cn1, k2, l2 - 1, i3))
                return k1;
            if(k1 >= 4)
                continue;
            int j3 = a(cn1, k2, l2, i3, k1 + 1, j2);
            if(j3 < i2)
                i2 = j3;
        }

        return i2;
    }

    private boolean[] k(cn cn1, int i, int i1, int j1)
    {
        for(int k1 = 0; k1 < 4; k1++)
        {
            c[k1] = 1000;
            int i2 = i;
            int l2 = i1;
            int i3 = j1;
            if(k1 == 0)
                i2--;
            if(k1 == 1)
                i2++;
            if(k1 == 2)
                i3--;
            if(k1 == 3)
                i3++;
            if(l(cn1, i2, l2, i3) || cn1.f(i2, l2, i3) == bn && cn1.e(i2, l2, i3) == 0)
                continue;
            if(!l(cn1, i2, l2 - 1, i3))
                c[k1] = 0;
            else
                c[k1] = a(cn1, i2, l2, i3, 1, k1);
        }

        int l1 = c[0];
        for(int j2 = 1; j2 < 4; j2++)
            if(c[j2] < l1)
                l1 = c[j2];

        for(int k2 = 0; k2 < 4; k2++)
            b[k2] = c[k2] == l1;

        return b;
    }

    private boolean l(cn cn1, int i, int i1, int j1)
    {
        int k1 = cn1.a(i, i1, j1);
        if(k1 == ly.aF.bc || k1 == ly.aM.bc || k1 == ly.aE.bc || k1 == ly.aG.bc || k1 == ly.aY.bc)
            return true;
        if(k1 == 0)
            return false;
        gb gb1 = ly.n[k1].bn;
        return gb1.a();
    }

    protected int f(cn cn1, int i, int i1, int j1, int k1)
    {
        int l1 = h(cn1, i, i1, j1);
        if(l1 < 0)
            return k1;
        if(l1 == 0)
            a++;
        if(l1 >= 8)
            l1 = 0;
        return k1 >= 0 && l1 >= k1 ? k1 : l1;
    }

    private boolean m(cn cn1, int i, int i1, int j1)
    {
        gb gb1 = cn1.f(i, i1, j1);
        if(gb1 == bn)
            return false;
        if(gb1 == gb.g)
            return false;
        else
            return !l(cn1, i, i1, j1);
    }

    public void e(cn cn1, int i, int i1, int j1)
    {
        super.e(cn1, i, i1, j1);
        if(cn1.a(i, i1, j1) == bc)
            cn1.h(i, i1, j1, bc);
    }

    int a;
    boolean b[];
    int c[];
}
