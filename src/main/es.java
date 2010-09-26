package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class es extends ik
{

    public es()
    {
    }

    public boolean a(cn cn1, Random random, int i, int j, int k)
    {
        for(int l = 0; l < 20; l++)
        {
            int i1 = (i + random.nextInt(4)) - random.nextInt(4);
            int j1 = j;
            int k1 = (k + random.nextInt(4)) - random.nextInt(4);
            if(cn1.a(i1, j1, k1) != 0 || cn1.f(i1 - 1, j1 - 1, k1) != gb.f && cn1.f(i1 + 1, j1 - 1, k1) != gb.f && cn1.f(i1, j1 - 1, k1 - 1) != gb.f && cn1.f(i1, j1 - 1, k1 + 1) != gb.f)
                continue;
            int l1 = 2 + random.nextInt(random.nextInt(3) + 1);
            for(int i2 = 0; i2 < l1; i2++)
                if(ly.aY.g(cn1, i1, j1 + i2, k1))
                    cn1.a(i1, j1 + i2, k1, ly.aY.bc);

        }

        return true;
    }
}
