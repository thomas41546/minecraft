package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class no extends ly
{

    protected no(int i, int j)
    {
        super(i, j, gb.n);
    }

    public cf d(cn cn1, int i, int j, int k)
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
        return 12;
    }

    public boolean a(cn cn1, int i, int j, int k)
    {
        if(cn1.g(i - 1, j, k))
            return true;
        if(cn1.g(i + 1, j, k))
            return true;
        if(cn1.g(i, j, k - 1))
            return true;
        if(cn1.g(i, j, k + 1))
            return true;
        return cn1.g(i, j - 1, k);
    }

    public void d(cn cn1, int i, int j, int k, int l)
    {
        int i1 = cn1.e(i, j, k);
        int j1 = i1 & 8;
        i1 &= 7;
        if(l == 1 && cn1.g(i, j - 1, k))
            i1 = 5 + cn1.n.nextInt(2);
        if(l == 2 && cn1.g(i, j, k + 1))
            i1 = 4;
        if(l == 3 && cn1.g(i, j, k - 1))
            i1 = 3;
        if(l == 4 && cn1.g(i + 1, j, k))
            i1 = 2;
        if(l == 5 && cn1.g(i - 1, j, k))
            i1 = 1;
        cn1.b(i, j, k, i1 + j1);
    }

    public void e(cn cn1, int i, int j, int k)
    {
        if(cn1.g(i - 1, j, k))
            cn1.b(i, j, k, 1);
        else
        if(cn1.g(i + 1, j, k))
            cn1.b(i, j, k, 2);
        else
        if(cn1.g(i, j, k - 1))
            cn1.b(i, j, k, 3);
        else
        if(cn1.g(i, j, k + 1))
            cn1.b(i, j, k, 4);
        else
        if(cn1.g(i, j - 1, k))
            cn1.b(i, j, k, 5 + cn1.n.nextInt(2));
        h(cn1, i, j, k);
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        if(h(cn1, i, j, k))
        {
            int i1 = cn1.e(i, j, k) & 7;
            boolean flag = false;
            if(!cn1.g(i - 1, j, k) && i1 == 1)
                flag = true;
            if(!cn1.g(i + 1, j, k) && i1 == 2)
                flag = true;
            if(!cn1.g(i, j, k - 1) && i1 == 3)
                flag = true;
            if(!cn1.g(i, j, k + 1) && i1 == 4)
                flag = true;
            if(!cn1.g(i, j - 1, k) && i1 == 5)
                flag = true;
            if(flag)
            {
                b_(cn1, i, j, k, cn1.e(i, j, k));
                cn1.d(i, j, k, 0);
            }
        }
    }

    private boolean h(cn cn1, int i, int j, int k)
    {
        if(!a(cn1, i, j, k))
        {
            b_(cn1, i, j, k, cn1.e(i, j, k));
            cn1.d(i, j, k, 0);
            return false;
        } else
        {
            return true;
        }
    }

    public void a(nm nm1, int i, int j, int k)
    {
        int l = nm1.e(i, j, k) & 7;
        float f1 = 0.1875F;
        if(l == 1)
            a(0.0F, 0.2F, 0.5F - f1, f1 * 2.0F, 0.8F, 0.5F + f1);
        else
        if(l == 2)
            a(1.0F - f1 * 2.0F, 0.2F, 0.5F - f1, 1.0F, 0.8F, 0.5F + f1);
        else
        if(l == 3)
            a(0.5F - f1, 0.2F, 0.0F, 0.5F + f1, 0.8F, f1 * 2.0F);
        else
        if(l == 4)
        {
            a(0.5F - f1, 0.2F, 1.0F - f1 * 2.0F, 0.5F + f1, 0.8F, 1.0F);
        } else
        {
            float f2 = 0.25F;
            a(0.5F - f2, 0.0F, 0.5F - f2, 0.5F + f2, 0.6F, 0.5F + f2);
        }
    }

    public void b(cn cn1, int i, int j, int k, dm dm)
    {
        a(cn1, i, j, k, dm);
    }

    public boolean a(cn cn1, int i, int j, int k, dm dm)
    {
        int l = cn1.e(i, j, k);
        int i1 = l & 7;
        int j1 = 8 - (l & 8);
        cn1.b(i, j, k, i1 + j1);
        cn1.b(i, j, k, i, j, k);
        cn1.a((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.click", 0.3F, j1 <= 0 ? 0.5F : 0.6F);
        cn1.g(i, j, k, bc);
        if(i1 == 1)
            cn1.g(i - 1, j, k, bc);
        else
        if(i1 == 2)
            cn1.g(i + 1, j, k, bc);
        else
        if(i1 == 3)
            cn1.g(i, j, k - 1, bc);
        else
        if(i1 == 4)
            cn1.g(i, j, k + 1, bc);
        else
            cn1.g(i, j - 1, k, bc);
        return true;
    }

    public void b(cn cn1, int i, int j, int k)
    {
        int l = cn1.e(i, j, k);
        if((l & 8) > 0)
        {
            cn1.g(i, j, k, bc);
            int i1 = l & 7;
            if(i1 == 1)
                cn1.g(i - 1, j, k, bc);
            else
            if(i1 == 2)
                cn1.g(i + 1, j, k, bc);
            else
            if(i1 == 3)
                cn1.g(i, j, k - 1, bc);
            else
            if(i1 == 4)
                cn1.g(i, j, k + 1, bc);
            else
                cn1.g(i, j - 1, k, bc);
        }
        super.b(cn1, i, j, k);
    }

    public boolean b(nm nm1, int i, int j, int k, int l)
    {
        return (nm1.e(i, j, k) & 8) > 0;
    }

    public boolean c(cn cn1, int i, int j, int k, int l)
    {
        int i1 = cn1.e(i, j, k);
        if((i1 & 8) == 0)
            return false;
        int j1 = i1 & 7;
        if(j1 == 5 && l == 1)
            return true;
        if(j1 == 4 && l == 2)
            return true;
        if(j1 == 3 && l == 3)
            return true;
        if(j1 == 2 && l == 4)
            return true;
        return j1 == 1 && l == 5;
    }

    public boolean d()
    {
        return true;
    }
}
