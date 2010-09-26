package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class hn extends jp
{

    protected hn(int i, gb gb1)
    {
        super(i, gb1);
        b(false);
        if(gb1 == gb.g)
            b(true);
    }

    public void a(cn cn1, int i, int l, int i1, int j1)
    {
        super.a(cn1, i, l, i1, j1);
        if(cn1.a(i, l, i1) == bc)
            j(cn1, i, l, i1);
    }

    private void j(cn cn1, int i, int l, int i1)
    {
        int j1 = cn1.e(i, l, i1);
        cn1.h = true;
        cn1.a(i, l, i1, bc - 1, j1);
        cn1.b(i, l, i1, i, l, i1);
        cn1.h(i, l, i1, bc - 1);
        cn1.h = false;
    }

    public void a(cn cn1, int i, int l, int i1, Random random)
    {
        if(bn == gb.g)
        {
            int j1 = random.nextInt(3);
            for(int k1 = 0; k1 < j1; k1++)
            {
                i += random.nextInt(3) - 1;
                l++;
                i1 += random.nextInt(3) - 1;
                int l1 = cn1.a(i, l, i1);
                if(l1 == 0)
                {
                    if(k(cn1, i - 1, l, i1) || k(cn1, i + 1, l, i1) || k(cn1, i, l, i1 - 1) || k(cn1, i, l, i1 + 1) || k(cn1, i, l - 1, i1) || k(cn1, i, l + 1, i1))
                    {
                        cn1.d(i, l, i1, ly.as.bc);
                        return;
                    }
                    continue;
                }
                if(ly.n[l1].bn.c())
                    return;
            }

        }
    }

    private boolean k(cn cn1, int i, int l, int i1)
    {
        return cn1.f(i, l, i1).e();
    }
}
