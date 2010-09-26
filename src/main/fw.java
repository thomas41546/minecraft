package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class fw extends ly
{

    protected fw(int i, gb gb1)
    {
        super(i, gb1);
        bb = 97;
        if(gb1 == gb.e)
            bb++;
        float f1 = 0.5F;
        float f2 = 1.0F;
        a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f2, 0.5F + f1);
    }

    public int a(int i, int j)
    {
        if(i == 0 || i == 1)
            return bb;
        int k = c(j);
        if((k == 0 || k == 2) ^ (i <= 3))
            return bb;
        int l = k / 2 + (i & 1 ^ k);
        l += (j & 4) / 4;
        int i1 = bb - (j & 8) * 2;
        if((l & 1) != 0)
            i1 = -i1;
        return i1;
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
        return 7;
    }

    public cf f(cn cn1, int i, int j, int k)
    {
        a(((nm) (cn1)), i, j, k);
        return super.f(cn1, i, j, k);
    }

    public cf d(cn cn1, int i, int j, int k)
    {
        a(((nm) (cn1)), i, j, k);
        return super.d(cn1, i, j, k);
    }

    public void a(nm nm1, int i, int j, int k)
    {
        b(c(nm1.e(i, j, k)));
    }

    public void b(int i)
    {
        float f1 = 0.1875F;
        a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        if(i == 0)
            a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f1);
        if(i == 1)
            a(1.0F - f1, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if(i == 2)
            a(0.0F, 0.0F, 1.0F - f1, 1.0F, 1.0F, 1.0F);
        if(i == 3)
            a(0.0F, 0.0F, 0.0F, f1, 1.0F, 1.0F);
    }

    public void b(cn cn1, int i, int j, int k, dm dm)
    {
        a(cn1, i, j, k, dm);
    }

    public boolean a(cn cn1, int i, int j, int k, dm dm)
    {
        if(bn == gb.e)
            return true;
        int l = cn1.e(i, j, k);
        if((l & 8) != 0)
        {
            if(cn1.a(i, j - 1, k) == bc)
                a(cn1, i, j - 1, k, dm);
            return true;
        }
        if(cn1.a(i, j + 1, k) == bc)
            cn1.b(i, j + 1, k, (l ^ 4) + 8);
        cn1.b(i, j, k, l ^ 4);
        cn1.b(i, j - 1, k, i, j, k);
        if(Math.random() < 0.5D)
            cn1.a((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.door_open", 1.0F, cn1.n.nextFloat() * 0.1F + 0.9F);
        else
            cn1.a((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.door_close", 1.0F, cn1.n.nextFloat() * 0.1F + 0.9F);
        return true;
    }

    public void a(cn cn1, int i, int j, int k, boolean flag)
    {
        int l = cn1.e(i, j, k);
        if((l & 8) != 0)
        {
            if(cn1.a(i, j - 1, k) == bc)
                a(cn1, i, j - 1, k, flag);
            return;
        }
        boolean flag1 = (cn1.e(i, j, k) & 4) > 0;
        if(flag1 == flag)
            return;
        if(cn1.a(i, j + 1, k) == bc)
            cn1.b(i, j + 1, k, (l ^ 4) + 8);
        cn1.b(i, j, k, l ^ 4);
        cn1.b(i, j - 1, k, i, j, k);
        if(Math.random() < 0.5D)
            cn1.a((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.door_open", 1.0F, cn1.n.nextFloat() * 0.1F + 0.9F);
        else
            cn1.a((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.door_close", 1.0F, cn1.n.nextFloat() * 0.1F + 0.9F);
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        int i1 = cn1.e(i, j, k);
        if((i1 & 8) != 0)
        {
            if(cn1.a(i, j - 1, k) != bc)
                cn1.d(i, j, k, 0);
            if(l > 0 && ly.n[l].d())
                a(cn1, i, j - 1, k, l);
        } else
        {
            boolean flag = false;
            if(cn1.a(i, j + 1, k) != bc)
            {
                cn1.d(i, j, k, 0);
                flag = true;
            }
            if(!cn1.g(i, j - 1, k))
            {
                cn1.d(i, j, k, 0);
                flag = true;
                if(cn1.a(i, j + 1, k) == bc)
                    cn1.d(i, j + 1, k, 0);
            }
            if(flag)
                b_(cn1, i, j, k, i1);
            else
            if(l > 0 && ly.n[l].d())
            {
                boolean flag1 = cn1.o(i, j, k) || cn1.o(i, j + 1, k);
                a(cn1, i, j, k, flag1);
            }
        }
    }

    public int a(int i, Random random)
    {
        if((i & 8) != 0)
            return 0;
        if(bn == gb.e)
            return di.az.aS;
        else
            return di.at.aS;
    }

    public mf a(cn cn1, int i, int j, int k, aj aj, aj aj1)
    {
        a(((nm) (cn1)), i, j, k);
        return super.a(cn1, i, j, k, aj, aj1);
    }

    public int c(int i)
    {
        if((i & 4) == 0)
            return i - 1 & 3;
        else
            return i & 3;
    }

    public boolean a(cn cn1, int i, int j, int k)
    {
        if(j >= 127)
            return false;
        else
            return cn1.g(i, j - 1, k) && super.a(cn1, i, j, k) && super.a(cn1, i, j + 1, k);
    }
}
