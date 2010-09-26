package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class ci
    implements nm
{

    public ci(cn cn1, int i, int j, int k, int l, int i1, int j1)
    {
        d = cn1;
        a = i >> 4;
        b = k >> 4;
        int k1 = l >> 4;
        int l1 = j1 >> 4;
        c = new ga[(k1 - a) + 1][(l1 - b) + 1];
        for(int i2 = a; i2 <= k1; i2++)
        {
            for(int j2 = b; j2 <= l1; j2++)
                c[i2 - a][j2 - b] = cn1.b(i2, j2);

        }

    }

    public int a(int i, int j, int k)
    {
        if(j < 0)
            return 0;
        if(j >= 128)
        {
            return 0;
        } else
        {
            int l = (i >> 4) - a;
            int i1 = (k >> 4) - b;
            return c[l][i1].a(i & 0xf, j, k & 0xf);
        }
    }

    public ic b(int i, int j, int k)
    {
        int l = (i >> 4) - a;
        int i1 = (k >> 4) - b;
        return c[l][i1].d(i & 0xf, j, k & 0xf);
    }

    public float c(int i, int j, int k)
    {
        return cn.i[d(i, j, k)];
    }

    public int d(int i, int j, int k)
    {
        return a(i, j, k, true);
    }

    public int a(int i, int j, int k, boolean flag)
    {
        if(i < 0xfe17b800 || k < 0xfe17b800 || i >= 0x1e84800 || k > 0x1e84800)
            return 15;
        if(flag)
        {
            int l = a(i, j, k);
            if(l == ly.al.bc || l == ly.aB.bc)
            {
                int k1 = a(i, j + 1, k, false);
                int i2 = a(i + 1, j, k, false);
                int j2 = a(i - 1, j, k, false);
                int k2 = a(i, j, k + 1, false);
                int l2 = a(i, j, k - 1, false);
                if(i2 > k1)
                    k1 = i2;
                if(j2 > k1)
                    k1 = j2;
                if(k2 > k1)
                    k1 = k2;
                if(l2 > k1)
                    k1 = l2;
                return k1;
            }
        }
        if(j < 0)
            return 0;
        if(j >= 128)
        {
            int i1 = 15 - d.e;
            if(i1 < 0)
                i1 = 0;
            return i1;
        } else
        {
            int j1 = (i >> 4) - a;
            int l1 = (k >> 4) - b;
            return c[j1][l1].c(i & 0xf, j, k & 0xf, d.e);
        }
    }

    public int e(int i, int j, int k)
    {
        if(j < 0)
            return 0;
        if(j >= 128)
        {
            return 0;
        } else
        {
            int l = (i >> 4) - a;
            int i1 = (k >> 4) - b;
            return c[l][i1].b(i & 0xf, j, k & 0xf);
        }
    }

    public gb f(int i, int j, int k)
    {
        int l = a(i, j, k);
        if(l == 0)
            return gb.a;
        else
            return ly.n[l].bn;
    }

    public boolean g(int i, int j, int k)
    {
        ly ly1 = ly.n[a(i, j, k)];
        if(ly1 == null)
            return false;
        else
            return ly1.b();
    }

    private int a;
    private int b;
    private ga c[][];
    private cn d;
}
