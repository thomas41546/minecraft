package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class kf extends ly
{

    public kf(int j, int k)
    {
        super(j, k, gb.n);
        a = true;
        a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }

    public int a(int j, int k)
    {
        return bb + (k <= 0 ? 0 : 16);
    }

    public cf d(cn cn1, int j, int k, int l)
    {
        return null;
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
        return 5;
    }

    public boolean a(cn cn1, int j, int k, int l)
    {
        return cn1.g(j, k - 1, l);
    }

    private void h(cn cn1, int j, int k, int l)
    {
        int i1 = cn1.e(j, k, l);
        int j1 = 0;
        a = false;
        boolean flag = cn1.o(j, k, l);
        a = true;
        if(flag)
        {
            j1 = 15;
        } else
        {
            for(int k1 = 0; k1 < 4; k1++)
            {
                int i2 = j;
                int k2 = l;
                if(k1 == 0)
                    i2--;
                if(k1 == 1)
                    i2++;
                if(k1 == 2)
                    k2--;
                if(k1 == 3)
                    k2++;
                j1 = g(cn1, i2, k, k2, j1);
                if(cn1.g(i2, k, k2) && !cn1.g(j, k + 1, l))
                {
                    j1 = g(cn1, i2, k + 1, k2, j1);
                    continue;
                }
                if(!cn1.g(i2, k, k2))
                    j1 = g(cn1, i2, k - 1, k2, j1);
            }

            if(j1 > 0)
                j1--;
            else
                j1 = 0;
        }
        if(i1 != j1)
        {
            cn1.b(j, k, l, j1);
            cn1.b(j, k, l, j, k, l);
            if(j1 > 0)
                j1--;
            for(int l1 = 0; l1 < 4; l1++)
            {
                int j2 = j;
                int l2 = l;
                int i3 = k - 1;
                if(l1 == 0)
                    j2--;
                if(l1 == 1)
                    j2++;
                if(l1 == 2)
                    l2--;
                if(l1 == 3)
                    l2++;
                if(cn1.g(j2, k, l2))
                    i3 += 2;
                int j3 = g(cn1, j2, k, l2, -1);
                if(j3 >= 0 && j3 != j1)
                    h(cn1, j2, k, l2);
                j3 = g(cn1, j2, i3, l2, -1);
                if(j3 >= 0 && j3 != j1)
                    h(cn1, j2, i3, l2);
            }

            if(i1 == 0 || j1 == 0)
            {
                cn1.g(j, k, l, bc);
                cn1.g(j - 1, k, l, bc);
                cn1.g(j + 1, k, l, bc);
                cn1.g(j, k, l - 1, bc);
                cn1.g(j, k, l + 1, bc);
                cn1.g(j, k - 1, l, bc);
                cn1.g(j, k + 1, l, bc);
            }
        }
    }

    private void i(cn cn1, int j, int k, int l)
    {
        if(cn1.a(j, k, l) != bc)
        {
            return;
        } else
        {
            cn1.g(j, k, l, bc);
            cn1.g(j - 1, k, l, bc);
            cn1.g(j + 1, k, l, bc);
            cn1.g(j, k, l - 1, bc);
            cn1.g(j, k, l + 1, bc);
            cn1.g(j, k - 1, l, bc);
            cn1.g(j, k + 1, l, bc);
            return;
        }
    }

    public void e(cn cn1, int j, int k, int l)
    {
        super.e(cn1, j, k, l);
        h(cn1, j, k, l);
        cn1.g(j, k + 1, l, bc);
        cn1.g(j, k - 1, l, bc);
        i(cn1, j - 1, k, l);
        i(cn1, j + 1, k, l);
        i(cn1, j, k, l - 1);
        i(cn1, j, k, l + 1);
        if(cn1.g(j - 1, k, l))
            i(cn1, j - 1, k + 1, l);
        else
            i(cn1, j - 1, k - 1, l);
        if(cn1.g(j + 1, k, l))
            i(cn1, j + 1, k + 1, l);
        else
            i(cn1, j + 1, k - 1, l);
        if(cn1.g(j, k, l - 1))
            i(cn1, j, k + 1, l - 1);
        else
            i(cn1, j, k - 1, l - 1);
        if(cn1.g(j, k, l + 1))
            i(cn1, j, k + 1, l + 1);
        else
            i(cn1, j, k - 1, l + 1);
    }

    public void b(cn cn1, int j, int k, int l)
    {
        super.b(cn1, j, k, l);
        cn1.g(j, k + 1, l, bc);
        cn1.g(j, k - 1, l, bc);
        h(cn1, j, k, l);
        i(cn1, j - 1, k, l);
        i(cn1, j + 1, k, l);
        i(cn1, j, k, l - 1);
        i(cn1, j, k, l + 1);
        if(cn1.g(j - 1, k, l))
            i(cn1, j - 1, k + 1, l);
        else
            i(cn1, j - 1, k - 1, l);
        if(cn1.g(j + 1, k, l))
            i(cn1, j + 1, k + 1, l);
        else
            i(cn1, j + 1, k - 1, l);
        if(cn1.g(j, k, l - 1))
            i(cn1, j, k + 1, l - 1);
        else
            i(cn1, j, k - 1, l - 1);
        if(cn1.g(j, k, l + 1))
            i(cn1, j, k + 1, l + 1);
        else
            i(cn1, j, k - 1, l + 1);
    }

    private int g(cn cn1, int j, int k, int l, int i1)
    {
        if(cn1.a(j, k, l) != bc)
            return i1;
        int j1 = cn1.e(j, k, l);
        if(j1 > i1)
            return j1;
        else
            return i1;
    }

    public void a(cn cn1, int j, int k, int l, int i1)
    {
        int j1 = cn1.e(j, k, l);
        boolean flag = a(cn1, j, k, l);
        if(!flag)
        {
            b_(cn1, j, k, l, j1);
            cn1.d(j, k, l, 0);
        } else
        {
            h(cn1, j, k, l);
        }
        super.a(cn1, j, k, l, i1);
    }

    public int a(int j, Random random)
    {
        return di.aA.aS;
    }

    public boolean c(cn cn1, int j, int k, int l, int i1)
    {
        if(!a)
            return false;
        else
            return b(((nm) (cn1)), j, k, l, i1);
    }

    public boolean b(nm nm1, int j, int k, int l, int i1)
    {
        if(!a)
            return false;
        if(nm1.e(j, k, l) == 0)
            return false;
        if(i1 == 1)
            return true;
        boolean flag = b(nm1, j - 1, k, l) || !nm1.g(j - 1, k, l) && b(nm1, j - 1, k - 1, l);
        boolean flag1 = b(nm1, j + 1, k, l) || !nm1.g(j + 1, k, l) && b(nm1, j + 1, k - 1, l);
        boolean flag2 = b(nm1, j, k, l - 1) || !nm1.g(j, k, l - 1) && b(nm1, j, k - 1, l - 1);
        boolean flag3 = b(nm1, j, k, l + 1) || !nm1.g(j, k, l + 1) && b(nm1, j, k - 1, l + 1);
        if(!nm1.g(j, k + 1, l))
        {
            if(nm1.g(j - 1, k, l) && b(nm1, j - 1, k + 1, l))
                flag = true;
            if(nm1.g(j + 1, k, l) && b(nm1, j + 1, k + 1, l))
                flag1 = true;
            if(nm1.g(j, k, l - 1) && b(nm1, j, k + 1, l - 1))
                flag2 = true;
            if(nm1.g(j, k, l + 1) && b(nm1, j, k + 1, l + 1))
                flag3 = true;
        }
        if(!flag2 && !flag1 && !flag && !flag3 && i1 >= 2 && i1 <= 5)
            return true;
        if(i1 == 2 && flag2 && !flag && !flag1)
            return true;
        if(i1 == 3 && flag3 && !flag && !flag1)
            return true;
        if(i1 == 4 && flag && !flag2 && !flag3)
            return true;
        return i1 == 5 && flag1 && !flag2 && !flag3;
    }

    public boolean d()
    {
        return a;
    }

    public void b(cn cn1, int j, int k, int l, Random random)
    {
        if(cn1.e(j, k, l) > 0)
        {
            double d1 = (double)j + 0.5D + ((double)random.nextFloat() - 0.5D) * 0.20000000000000001D;
            double d2 = (float)k + 0.0625F;
            double d3 = (double)l + 0.5D + ((double)random.nextFloat() - 0.5D) * 0.20000000000000001D;
            cn1.a("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
        }
    }

    public static boolean b(nm nm1, int j, int k, int l)
    {
        int i1 = nm1.a(j, k, l);
        if(i1 == ly.aw.bc)
            return true;
        if(i1 == 0)
            return false;
        return ly.n[i1].d();
    }

    private boolean a;
}
