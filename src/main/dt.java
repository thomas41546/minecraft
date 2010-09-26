package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class dt extends mq
{

    protected dt(int i, int j)
    {
        super(i, j);
        float f = 0.4F;
        a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    public void a(cn cn1, int i, int j, int k, Random random)
    {
        super.a(cn1, i, j, k, random);
        if(cn1.j(i, j + 1, k) >= 9 && random.nextInt(5) == 0)
        {
            int l = cn1.e(i, j, k);
            if(l < 15)
            {
                cn1.b(i, j, k, l + 1);
            } else
            {
                cn1.a(i, j, k, 0);
                Object obj = ((Object) (new oa()));
                if(random.nextInt(10) == 0)
                    obj = ((Object) (new ej()));
                if(!((ik) (obj)).a(cn1, random, i, j, k))
                    cn1.a(i, j, k, bc);
            }
        }
    }
}
