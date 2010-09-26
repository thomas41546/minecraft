// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class if extends ly
{

    protected if(int i, int j)
    {
        super(i, j, gb.n);
        a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public cf d(cn cn1, int i, int j, int k)
    {
        return null;
    }

    public boolean b()
    {
        return false;
    }

    public mf a(cn cn1, int i, int j, int k, aj aj, aj aj1)
    {
        a(((nm) (cn1)), i, j, k);
        return super.a(cn1, i, j, k, aj, aj1);
    }

    public void a(nm nm1, int i, int j, int k)
    {
        int l = nm1.e(i, j, k);
        if(l >= 2 && l <= 5)
            a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
        else
            a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public int a(int i, int j)
    {
        if(j >= 6)
            return bb - 16;
        else
            return bb;
    }

    public boolean c()
    {
        return false;
    }

    public int f()
    {
        return 9;
    }

    public int a(Random random)
    {
        return 1;
    }

    public boolean a(cn cn1, int i, int j, int k)
    {
        return cn1.g(i, j - 1, k);
    }

    public void e(cn cn1, int i, int j, int k)
    {
        cn1.b(i, j, k, 15);
        h(cn1, i, j, k);
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        int i1 = cn1.e(i, j, k);
        boolean flag = false;
        if(!cn1.g(i, j - 1, k))
            flag = true;
        if(i1 == 2 && !cn1.g(i + 1, j, k))
            flag = true;
        if(i1 == 3 && !cn1.g(i - 1, j, k))
            flag = true;
        if(i1 == 4 && !cn1.g(i, j, k - 1))
            flag = true;
        if(i1 == 5 && !cn1.g(i, j, k + 1))
            flag = true;
        if(flag)
        {
            b_(cn1, i, j, k, cn1.e(i, j, k));
            cn1.d(i, j, k, 0);
        } else
        if(l > 0 && ly.n[l].d() && mk.a(new mk(this, cn1, i, j, k)) == 3)
            h(cn1, i, j, k);
    }

    private void h(cn cn1, int i, int j, int k)
    {
        (new mk(this, cn1, i, j, k)).a(cn1.o(i, j, k));
    }
}
