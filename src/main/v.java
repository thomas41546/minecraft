package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class v extends bk
{

    public v()
    {
        this(new Random());
    }

    public v(Random random)
    {
        d = new int[512];
        a = random.nextDouble() * 256D;
        b = random.nextDouble() * 256D;
        c = random.nextDouble() * 256D;
        for(int i = 0; i < 256; i++)
            d[i] = i;

        for(int j = 0; j < 256; j++)
        {
            int k = random.nextInt(256 - j) + j;
            int l = d[j];
            d[j] = d[k];
            d[k] = l;
            d[j + 256] = d[j];
        }

    }

    public double a(double d1, double d2, double d3)
    {
        double d4 = d1 + a;
        double d5 = d2 + b;
        double d6 = d3 + c;
        int i = (int)d4;
        int j = (int)d5;
        int k = (int)d6;
        if(d4 < (double)i)
            i--;
        if(d5 < (double)j)
            j--;
        if(d6 < (double)k)
            k--;
        int l = i & 0xff;
        int i1 = j & 0xff;
        int j1 = k & 0xff;
        d4 -= i;
        d5 -= j;
        d6 -= k;
        double d7 = d4 * d4 * d4 * (d4 * (d4 * 6D - 15D) + 10D);
        double d8 = d5 * d5 * d5 * (d5 * (d5 * 6D - 15D) + 10D);
        double d9 = d6 * d6 * d6 * (d6 * (d6 * 6D - 15D) + 10D);
        int k1 = d[l] + i1;
        int l1 = d[k1] + j1;
        int i2 = d[k1 + 1] + j1;
        int j2 = d[l + 1] + i1;
        int k2 = d[j2] + j1;
        int l2 = d[j2 + 1] + j1;
        return b(d9, b(d8, b(d7, a(d[l1], d4, d5, d6), a(d[k2], d4 - 1.0D, d5, d6)), b(d7, a(d[i2], d4, d5 - 1.0D, d6), a(d[l2], d4 - 1.0D, d5 - 1.0D, d6))), b(d8, b(d7, a(d[l1 + 1], d4, d5, d6 - 1.0D), a(d[k2 + 1], d4 - 1.0D, d5, d6 - 1.0D)), b(d7, a(d[i2 + 1], d4, d5 - 1.0D, d6 - 1.0D), a(d[l2 + 1], d4 - 1.0D, d5 - 1.0D, d6 - 1.0D))));
    }

    public double b(double d1, double d2, double d3)
    {
        return d2 + d1 * (d3 - d2);
    }

    public double a(int i, double d1, double d2, double d3)
    {
        int j = i & 0xf;
        double d4 = j >= 8 ? d2 : d1;
        double d5 = j >= 4 ? j != 12 && j != 14 ? d3 : d1 : d2;
        return ((j & 1) != 0 ? -d4 : d4) + ((j & 2) != 0 ? -d5 : d5);
    }

    public double a(double d1, double d2)
    {
        return a(d1, d2, 0.0D);
    }

    public void a(double ad[], double d1, double d2, double d3, 
            int i, int j, int k, double d4, double d5, 
            double d6, double d7)
    {
        int l = 0;
        double d8 = 1.0D / d7;
        int i1 = -1;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        double d9 = 0.0D;
        double d10 = 0.0D;
        double d11 = 0.0D;
        double d12 = 0.0D;
        for(int l2 = 0; l2 < i; l2++)
        {
            double d13 = (d1 + (double)l2) * d4 + a;
            int i3 = (int)d13;
            if(d13 < (double)i3)
                i3--;
            int j3 = i3 & 0xff;
            d13 -= i3;
            double d14 = d13 * d13 * d13 * (d13 * (d13 * 6D - 15D) + 10D);
            for(int k3 = 0; k3 < k; k3++)
            {
                double d15 = (d3 + (double)k3) * d6 + c;
                int l3 = (int)d15;
                if(d15 < (double)l3)
                    l3--;
                int i4 = l3 & 0xff;
                d15 -= l3;
                double d16 = d15 * d15 * d15 * (d15 * (d15 * 6D - 15D) + 10D);
                for(int j4 = 0; j4 < j; j4++)
                {
                    double d17 = (d2 + (double)j4) * d5 + b;
                    int k4 = (int)d17;
                    if(d17 < (double)k4)
                        k4--;
                    int l4 = k4 & 0xff;
                    d17 -= k4;
                    double d18 = d17 * d17 * d17 * (d17 * (d17 * 6D - 15D) + 10D);
                    if(j4 == 0 || l4 != i1)
                    {
                        i1 = l4;
                        int j1 = d[j3] + l4;
                        int k1 = d[j1] + i4;
                        int l1 = d[j1 + 1] + i4;
                        int i2 = d[j3 + 1] + l4;
                        int j2 = d[i2] + i4;
                        int k2 = d[i2 + 1] + i4;
                        d9 = b(d14, a(d[k1], d13, d17, d15), a(d[j2], d13 - 1.0D, d17, d15));
                        d10 = b(d14, a(d[l1], d13, d17 - 1.0D, d15), a(d[k2], d13 - 1.0D, d17 - 1.0D, d15));
                        d11 = b(d14, a(d[k1 + 1], d13, d17, d15 - 1.0D), a(d[j2 + 1], d13 - 1.0D, d17, d15 - 1.0D));
                        d12 = b(d14, a(d[l1 + 1], d13, d17 - 1.0D, d15 - 1.0D), a(d[k2 + 1], d13 - 1.0D, d17 - 1.0D, d15 - 1.0D));
                    }
                    double d19 = b(d18, d9, d10);
                    double d20 = b(d18, d11, d12);
                    double d21 = b(d16, d19, d20);
                    ad[l++] += d21 * d8;
                }

            }

        }

    }

    private int d[];
    public double a;
    public double b;
    public double c;
}
