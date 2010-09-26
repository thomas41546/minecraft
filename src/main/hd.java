package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.PrintStream;
import java.util.Random;

public class hd extends mq
{

    protected hd(int j, int k)
    {
        super(j, k);
        bb = k;
        b(true);
        float f1 = 0.5F;
        a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 0.25F, 0.5F + f1);
    }

    protected boolean b(int j)
    {
        return j == ly.aB.bc;
    }

    public void a(cn cn1, int j, int k, int l, Random random)
    {
        super.a(cn1, j, k, l, random);
        if(cn1.j(j, k + 1, l) >= 9)
        {
            int i1 = cn1.e(j, k, l);
            if(i1 < 7)
            {
                float f1 = i(cn1, j, k, l);
                if(random.nextInt((int)(100F / f1)) == 0)
                {
                    i1++;
                    cn1.b(j, k, l, i1);
                }
            }
        }
    }

    private float i(cn cn1, int j, int k, int l)
    {
        float f1 = 1.0F;
        int i1 = cn1.a(j, k, l - 1);
        int j1 = cn1.a(j, k, l + 1);
        int k1 = cn1.a(j - 1, k, l);
        int l1 = cn1.a(j + 1, k, l);
        int i2 = cn1.a(j - 1, k, l - 1);
        int j2 = cn1.a(j + 1, k, l - 1);
        int k2 = cn1.a(j + 1, k, l + 1);
        int l2 = cn1.a(j - 1, k, l + 1);
        boolean flag = k1 == bc || l1 == bc;
        boolean flag1 = i1 == bc || j1 == bc;
        boolean flag2 = i2 == bc || j2 == bc || k2 == bc || l2 == bc;
        for(int i3 = j - 1; i3 <= j + 1; i3++)
        {
            for(int j3 = l - 1; j3 <= l + 1; j3++)
            {
                int k3 = cn1.a(i3, k - 1, j3);
                float f2 = 0.0F;
                if(k3 == ly.aB.bc)
                {
                    f2 = 1.0F;
                    if(cn1.e(i3, k - 1, j3) > 0)
                        f2 = 3F;
                }
                if(i3 != j || j3 != l)
                    f2 /= 4F;
                f1 += f2;
            }

        }

        if(flag2 || flag && flag1)
            f1 /= 2.0F;
        return f1;
    }

    public int a(int j, int k)
    {
        if(k < 0)
            k = 7;
        return bb + k;
    }

    public int f()
    {
        return 6;
    }

    public void b(cn cn1, int j, int k, int l, int i1)
    {
        super.b(cn1, j, k, l, i1);
        for(int j1 = 0; j1 < 3; j1++)
            if(cn1.n.nextInt(15) <= i1)
            {
                float f1 = 0.7F;
                float f2 = cn1.n.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f3 = cn1.n.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f4 = cn1.n.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                dx dx1 = new dx(cn1, (float)j + f2, (float)k + f3, (float)l + f4, new ev(di.Q));
                dx1.c = 10;
                cn1.a(((kh) (dx1)));
            }

    }

    public int a(int j, Random random)
    {
        System.out.println((new StringBuilder()).append("Get resource: ").append(j).toString());
        if(j == 7)
            return di.R.aS;
        else
            return -1;
    }

    public int a(Random random)
    {
        return 1;
    }
}
