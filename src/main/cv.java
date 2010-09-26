package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class cv extends ly
{

    protected cv(int i, int j)
    {
        super(i, j, gb.c);
    }

    public int a(int i)
    {
        return bb + (i != 1 ? 0 : 1);
    }

    public boolean a(cn cn1, int i, int j, int k, dm dm)
    {
        int l = cn1.e(i, j, k);
        if(l > 0)
        {
            e(cn1, i, j, k, l);
            return true;
        } else
        {
            return false;
        }
    }

    public void e(cn cn1, int i, int j, int k, int l)
    {
        cn1.a(((String) (null)), i, j, k);
        cn1.b(i, j, k, 0);
        int i1 = (di.aQ.aS + l) - 1;
        float f = 0.7F;
        double d = (double)(cn1.n.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d1 = (double)(cn1.n.nextFloat() * f) + (double)(1.0F - f) * 0.20000000000000001D + 0.59999999999999998D;
        double d2 = (double)(cn1.n.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        dx dx1 = new dx(cn1, (double)i + d, (double)j + d1, (double)k + d2, new ev(i1));
        dx1.c = 10;
        cn1.a(((kh) (dx1)));
    }

    public void a(cn cn1, int i, int j, int k, int l, float f)
    {
        if(cn1.y)
            return;
        if(l > 0)
            e(cn1, i, j, k, l);
        super.a(cn1, i, j, k, l, f);
    }
}
