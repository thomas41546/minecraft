package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public abstract class jp extends ly
{

    protected jp(int k, gb gb1)
    {
        super(k, (gb1 != gb.g ? 12 : 14) * 16 + 13, gb1);
        d = 1;
        float f1 = 0.0F;
        float f2 = 0.0F;
        if(gb1 == gb.g)
            d = 2;
        a(0.0F + f2, 0.0F + f1, 0.0F + f2, 1.0F + f2, 1.0F + f1, 1.0F + f2);
        b(true);
    }

    public static float b(int k)
    {
        if(k >= 8)
            k = 0;
        float f1 = (float)(k + 1) / 9F;
        return f1;
    }

    public int a(int k)
    {
        if(k == 0 || k == 1)
            return bb;
        else
            return bb + 1;
    }

    protected int h(cn cn1, int k, int l, int i1)
    {
        if(cn1.f(k, l, i1) != bn)
            return -1;
        else
            return cn1.e(k, l, i1);
    }

    protected int b(nm nm1, int k, int l, int i1)
    {
        if(nm1.f(k, l, i1) != bn)
            return -1;
        int j1 = nm1.e(k, l, i1);
        if(j1 >= 8)
            j1 = 0;
        return j1;
    }

    public boolean c()
    {
        return false;
    }

    public boolean b()
    {
        return false;
    }

    public boolean a(int k, boolean flag)
    {
        return flag && k == 0;
    }

    public boolean c(nm nm1, int k, int l, int i1, int j1)
    {
        gb gb1 = nm1.f(k, l, i1);
        if(gb1 == bn)
            return false;
        if(gb1 == gb.r)
            return false;
        if(j1 == 1)
            return true;
        else
            return super.c(nm1, k, l, i1, j1);
    }

    public cf d(cn cn1, int k, int l, int i1)
    {
        return null;
    }

    public int f()
    {
        return 4;
    }

    public int a(int k, Random random)
    {
        return 0;
    }

    public int a(Random random)
    {
        return 0;
    }

    private aj e(nm nm1, int k, int l, int i1)
    {
        aj aj1 = aj.b(0.0D, 0.0D, 0.0D);
        int j1 = b(nm1, k, l, i1);
        for(int k1 = 0; k1 < 4; k1++)
        {
            int l1 = k;
            int i2 = l;
            int j2 = i1;
            if(k1 == 0)
                l1--;
            if(k1 == 1)
                j2--;
            if(k1 == 2)
                l1++;
            if(k1 == 3)
                j2++;
            int k2 = b(nm1, l1, i2, j2);
            if(k2 < 0)
            {
                if(nm1.f(l1, i2, j2).c())
                    continue;
                k2 = b(nm1, l1, i2 - 1, j2);
                if(k2 >= 0)
                {
                    int l2 = k2 - (j1 - 8);
                    aj1 = aj1.c((l1 - k) * l2, (i2 - l) * l2, (j2 - i1) * l2);
                }
                continue;
            }
            if(k2 >= 0)
            {
                int i3 = k2 - j1;
                aj1 = aj1.c((l1 - k) * i3, (i2 - l) * i3, (j2 - i1) * i3);
            }
        }

        if(nm1.e(k, l, i1) >= 8)
        {
            boolean flag = false;
            if(flag || c(nm1, k, l, i1 - 1, 2))
                flag = true;
            if(flag || c(nm1, k, l, i1 + 1, 3))
                flag = true;
            if(flag || c(nm1, k - 1, l, i1, 4))
                flag = true;
            if(flag || c(nm1, k + 1, l, i1, 5))
                flag = true;
            if(flag || c(nm1, k, l + 1, i1 - 1, 2))
                flag = true;
            if(flag || c(nm1, k, l + 1, i1 + 1, 3))
                flag = true;
            if(flag || c(nm1, k - 1, l + 1, i1, 4))
                flag = true;
            if(flag || c(nm1, k + 1, l + 1, i1, 5))
                flag = true;
            if(flag)
                aj1 = aj1.b().c(0.0D, -6D, 0.0D);
        }
        aj1 = aj1.b();
        return aj1;
    }

    public void a(cn cn1, int k, int l, int i1, kh kh, aj aj1)
    {
        aj aj2 = e(((nm) (cn1)), k, l, i1);
        aj1.a += aj2.a;
        aj1.b += aj2.b;
        aj1.c += aj2.c;
    }

    public int a()
    {
        if(bn == gb.f)
            return 5;
        return bn != gb.g ? 0 : 30;
    }

    public float c(nm nm1, int k, int l, int i1)
    {
        float f1 = nm1.c(k, l, i1);
        float f2 = nm1.c(k, l + 1, i1);
        return f1 <= f2 ? f2 : f1;
    }

    public void a(cn cn1, int k, int l, int i1, Random random)
    {
        super.a(cn1, k, l, i1, random);
    }

    public int g()
    {
        return bn != gb.f ? 0 : 1;
    }

    public void b(cn cn1, int k, int l, int i1, Random random)
    {
        if(bn == gb.f && random.nextInt(64) == 0)
        {
            int j1 = cn1.e(k, l, i1);
            if(j1 > 0 && j1 < 8)
                cn1.a((float)k + 0.5F, (float)l + 0.5F, (float)i1 + 0.5F, "liquid.water", random.nextFloat() * 0.25F + 0.75F, random.nextFloat() * 1.0F + 0.5F);
        }
        if(bn == gb.g && cn1.f(k, l + 1, i1) == gb.a && !cn1.g(k, l + 1, i1) && random.nextInt(100) == 0)
        {
            double d1 = (float)k + random.nextFloat();
            double d2 = (double)l + bj;
            double d3 = (float)i1 + random.nextFloat();
            cn1.a("lava", d1, d2, d3, 0.0D, 0.0D, 0.0D);
        }
    }

    public static double a(nm nm1, int k, int l, int i1, gb gb1)
    {
        aj aj1 = null;
        if(gb1 == gb.f)
            aj1 = ((jp)ly.B).e(nm1, k, l, i1);
        if(gb1 == gb.g)
            aj1 = ((jp)ly.D).e(nm1, k, l, i1);
        if(aj1.a == 0.0D && aj1.c == 0.0D)
            return -1000D;
        else
            return Math.atan2(aj1.c, aj1.a) - 1.5707963267948966D;
    }

    public void e(cn cn1, int k, int l, int i1)
    {
        j(cn1, k, l, i1);
    }

    public void a(cn cn1, int k, int l, int i1, int j1)
    {
        j(cn1, k, l, i1);
    }

    private void j(cn cn1, int k, int l, int i1)
    {
        if(cn1.a(k, l, i1) != bc)
            return;
        if(bn == gb.g)
        {
            boolean flag = false;
            if(flag || cn1.f(k, l, i1 - 1) == gb.f)
                flag = true;
            if(flag || cn1.f(k, l, i1 + 1) == gb.f)
                flag = true;
            if(flag || cn1.f(k - 1, l, i1) == gb.f)
                flag = true;
            if(flag || cn1.f(k + 1, l, i1) == gb.f)
                flag = true;
            if(flag || cn1.f(k, l + 1, i1) == gb.f)
                flag = true;
            if(flag)
            {
                int j1 = cn1.e(k, l, i1);
                if(j1 == 0)
                    cn1.d(k, l, i1, ly.aq.bc);
                else
                if(j1 <= 4)
                    cn1.d(k, l, i1, ly.x.bc);
                i(cn1, k, l, i1);
            }
        }
    }

    protected void i(cn cn1, int k, int l, int i1)
    {
        cn1.a((float)k + 0.5F, (float)l + 0.5F, (float)i1 + 0.5F, "random.fizz", 0.5F, 2.6F + (cn1.n.nextFloat() - cn1.n.nextFloat()) * 0.8F);
        for(int j1 = 0; j1 < 8; j1++)
            cn1.a("largesmoke", (double)k + Math.random(), (double)l + 1.2D, (double)i1 + Math.random(), 0.0D, 0.0D, 0.0D);

    }

    protected int d;
}
