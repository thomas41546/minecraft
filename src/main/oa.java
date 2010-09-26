package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class oa extends ik
{

    public oa()
    {
    }

    public boolean a(cn cn1, Random random, int i, int j, int k)
    {
        int l = random.nextInt(3) + 4;
        boolean flag = true;
        if(j < 1 || j + l + 1 > 128)
            return false;
        for(int i1 = j; i1 <= j + 1 + l; i1++)
        {
            byte byte0 = 1;
            if(i1 == j)
                byte0 = 0;
            if(i1 >= (j + 1 + l) - 2)
                byte0 = 2;
            for(int i2 = i - byte0; i2 <= i + byte0 && flag; i2++)
            {
                for(int l2 = k - byte0; l2 <= k + byte0 && flag; l2++)
                    if(i1 >= 0 && i1 < 128)
                    {
                        int j3 = cn1.a(i2, i1, l2);
                        if(j3 != 0 && j3 != ly.L.bc)
                            flag = false;
                    } else
                    {
                        flag = false;
                    }

            }

        }

        if(!flag)
            return false;
        int j1 = cn1.a(i, j - 1, k);
        if(j1 != ly.v.bc && j1 != ly.w.bc || j >= 128 - l - 1)
            return false;
        cn1.a(i, j - 1, k, ly.w.bc);
        for(int k1 = (j - 3) + l; k1 <= j + l; k1++)
        {
            int j2 = k1 - (j + l);
            int i3 = 1 - j2 / 2;
            for(int k3 = i - i3; k3 <= i + i3; k3++)
            {
                int l3 = k3 - i;
                for(int i4 = k - i3; i4 <= k + i3; i4++)
                {
                    int j4 = i4 - k;
                    if((Math.abs(l3) != i3 || Math.abs(j4) != i3 || random.nextInt(2) != 0 && j2 != 0) && !ly.p[cn1.a(k3, k1, i4)])
                        cn1.a(k3, k1, i4, ly.L.bc);
                }

            }

        }

        for(int l1 = 0; l1 < l; l1++)
        {
            int k2 = cn1.a(i, j + l1, k);
            if(k2 == 0 || k2 == ly.L.bc)
                cn1.a(i, j + l1, k, ly.K.bc);
        }

        return true;
    }
}
