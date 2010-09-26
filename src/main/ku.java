package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class ku extends jt
{

    protected ku(int i, boolean flag)
    {
        super(i, gb.d);
        a = flag;
        bb = 45;
    }

    public int a(int i, Random random)
    {
        return ly.aC.bc;
    }

    public void e(cn cn1, int i, int j, int k)
    {
        super.e(cn1, i, j, k);
        h(cn1, i, j, k);
    }

    private void h(cn cn1, int i, int j, int k)
    {
        int l = cn1.a(i, j, k - 1);
        int i1 = cn1.a(i, j, k + 1);
        int j1 = cn1.a(i - 1, j, k);
        int k1 = cn1.a(i + 1, j, k);
        byte byte0 = 3;
        if(ly.p[l] && !ly.p[i1])
            byte0 = 3;
        if(ly.p[i1] && !ly.p[l])
            byte0 = 2;
        if(ly.p[j1] && !ly.p[k1])
            byte0 = 5;
        if(ly.p[k1] && !ly.p[j1])
            byte0 = 4;
        cn1.b(i, j, k, ((int) (byte0)));
    }

    public int a(nm nm1, int i, int j, int k, int l)
    {
        if(l == 1)
            return ly.u.bb;
        if(l == 0)
            return ly.u.bb;
        int i1 = nm1.e(i, j, k);
        if(l != i1)
            return bb;
        if(a)
            return bb + 16;
        else
            return bb - 1;
    }

    public void b(cn cn1, int i, int j, int k, Random random)
    {
        if(!a)
            return;
        int l = cn1.e(i, j, k);
        float f = (float)i + 0.5F;
        float f1 = (float)j + 0.0F + (random.nextFloat() * 6F) / 16F;
        float f2 = (float)k + 0.5F;
        float f3 = 0.52F;
        float f4 = random.nextFloat() * 0.6F - 0.3F;
        if(l == 4)
        {
            cn1.a("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            cn1.a("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 5)
        {
            cn1.a("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            cn1.a("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 2)
        {
            cn1.a("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
            cn1.a("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 3)
        {
            cn1.a("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
            cn1.a("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        }
    }

    public int a(int i)
    {
        if(i == 1)
            return ly.u.bc;
        if(i == 0)
            return ly.u.bc;
        if(i == 3)
            return bb - 1;
        else
            return bb;
    }

    public boolean a(cn cn1, int i, int j, int k, dm dm1)
    {
        ke ke1 = (ke)cn1.b(i, j, k);
        dm1.a(ke1);
        return true;
    }

    public static void a(boolean flag, cn cn1, int i, int j, int k)
    {
        int l = cn1.e(i, j, k);
        ic ic = cn1.b(i, j, k);
        if(flag)
            cn1.d(i, j, k, ly.aD.bc);
        else
            cn1.d(i, j, k, ly.aC.bc);
        cn1.b(i, j, k, l);
        cn1.a(i, j, k, ic);
    }

    protected ic a_()
    {
        return ((ic) (new ke()));
    }

    private final boolean a;
}
