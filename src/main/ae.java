package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class ae extends ik
{

    public ae(int i)
    {
        a = i;
    }

    public boolean a(cn cn1, Random random, int i, int j, int k)
    {
        for(int l = 0; l < 64; l++)
        {
            int i1 = (i + random.nextInt(8)) - random.nextInt(8);
            int j1 = (j + random.nextInt(4)) - random.nextInt(4);
            int k1 = (k + random.nextInt(8)) - random.nextInt(8);
            if(cn1.a(i1, j1, k1) == 0 && ((mq)ly.n[a]).g(cn1, i1, j1, k1))
                cn1.a(i1, j1, k1, a);
        }

        return true;
    }

    private int a;
}
