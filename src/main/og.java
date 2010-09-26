package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class og extends ly
{

    protected og(int j, int k)
    {
        super(j, k, gb.l);
        a = new int[256];
        b = new int[256];
        a(ly.y.bc, 5, 20);
        a(ly.K.bc, 5, 5);
        a(ly.L.bc, 30, 60);
        a(ly.ao.bc, 30, 20);
        a(ly.an.bc, 15, 100);
        a(ly.ac.bc, 30, 60);
        b(true);
    }

    private void a(int j, int k, int l)
    {
        a[j] = k;
        b[j] = l;
    }

    public cf d(cn cn1, int j, int k, int l)
    {
        return null;
    }

    public boolean b()
    {
        return false;
    }

    public boolean c()
    {
        return false;
    }

    public int f()
    {
        return 3;
    }

    public int a(Random random)
    {
        return 0;
    }

    public int a()
    {
        return 10;
    }

    public void a(cn cn1, int j, int k, int l, Random random)
    {
        int i1 = cn1.e(j, k, l);
        if(i1 < 15)
        {
            cn1.b(j, k, l, i1 + 1);
            cn1.h(j, k, l, bc);
        }
        if(!h(cn1, j, k, l))
        {
            if(!cn1.g(j, k - 1, l) || i1 > 3)
                cn1.d(j, k, l, 0);
            return;
        }
        if(!b(((nm) (cn1)), j, k - 1, l) && i1 == 15 && random.nextInt(4) == 0)
        {
            cn1.d(j, k, l, 0);
            return;
        }
        if(i1 % 2 == 0 && i1 > 2)
        {
            a(cn1, j + 1, k, l, 300, random);
            a(cn1, j - 1, k, l, 300, random);
            a(cn1, j, k - 1, l, 200, random);
            a(cn1, j, k + 1, l, 250, random);
            a(cn1, j, k, l - 1, 300, random);
            a(cn1, j, k, l + 1, 300, random);
            for(int j1 = j - 1; j1 <= j + 1; j1++)
            {
                for(int k1 = l - 1; k1 <= l + 1; k1++)
                {
                    for(int l1 = k - 1; l1 <= k + 4; l1++)
                    {
                        if(j1 == j && l1 == k && k1 == l)
                            continue;
                        int i2 = 100;
                        if(l1 > k + 1)
                            i2 += (l1 - (k + 1)) * 100;
                        int j2 = i(cn1, j1, l1, k1);
                        if(j2 > 0 && random.nextInt(i2) <= j2)
                            cn1.d(j1, l1, k1, bc);
                    }

                }

            }

        }
    }

    private void a(cn cn1, int j, int k, int l, int i1, Random random)
    {
        int j1 = b[cn1.a(j, k, l)];
        if(random.nextInt(i1) < j1)
        {
            boolean flag = cn1.a(j, k, l) == ly.an.bc;
            if(random.nextInt(2) == 0)
                cn1.d(j, k, l, bc);
            else
                cn1.d(j, k, l, 0);
            if(flag)
                ly.an.b(cn1, j, k, l, 0);
        }
    }

    private boolean h(cn cn1, int j, int k, int l)
    {
        if(b(((nm) (cn1)), j + 1, k, l))
            return true;
        if(b(((nm) (cn1)), j - 1, k, l))
            return true;
        if(b(((nm) (cn1)), j, k - 1, l))
            return true;
        if(b(((nm) (cn1)), j, k + 1, l))
            return true;
        if(b(((nm) (cn1)), j, k, l - 1))
            return true;
        return b(((nm) (cn1)), j, k, l + 1);
    }

    private int i(cn cn1, int j, int k, int l)
    {
        int i1 = 0;
        if(cn1.a(j, k, l) != 0)
        {
            return 0;
        } else
        {
            i1 = g(cn1, j + 1, k, l, i1);
            i1 = g(cn1, j - 1, k, l, i1);
            i1 = g(cn1, j, k - 1, l, i1);
            i1 = g(cn1, j, k + 1, l, i1);
            i1 = g(cn1, j, k, l - 1, i1);
            i1 = g(cn1, j, k, l + 1, i1);
            return i1;
        }
    }

    public boolean h()
    {
        return false;
    }

    public boolean b(nm nm1, int j, int k, int l)
    {
        return a[nm1.a(j, k, l)] > 0;
    }

    public int g(cn cn1, int j, int k, int l, int i1)
    {
        int j1 = a[cn1.a(j, k, l)];
        if(j1 > i1)
            return j1;
        else
            return i1;
    }

    public boolean a(cn cn1, int j, int k, int l)
    {
        return cn1.g(j, k - 1, l) || h(cn1, j, k, l);
    }

    public void a(cn cn1, int j, int k, int l, int i1)
    {
        if(!cn1.g(j, k - 1, l) && !h(cn1, j, k, l))
        {
            cn1.d(j, k, l, 0);
            return;
        } else
        {
            return;
        }
    }

    public void e(cn cn1, int j, int k, int l)
    {
        if(!cn1.g(j, k - 1, l) && !h(cn1, j, k, l))
        {
            cn1.d(j, k, l, 0);
            return;
        } else
        {
            cn1.h(j, k, l, bc);
            return;
        }
    }

    public void b(cn cn1, int j, int k, int l, Random random)
    {
        if(random.nextInt(24) == 0)
            cn1.a((float)j + 0.5F, (float)k + 0.5F, (float)l + 0.5F, "fire.fire", 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F);
        if(cn1.g(j, k - 1, l) || ly.as.b(((nm) (cn1)), j, k - 1, l))
        {
            for(int i1 = 0; i1 < 3; i1++)
            {
                float f1 = (float)j + random.nextFloat();
                float f7 = (float)k + random.nextFloat() * 0.5F + 0.5F;
                float f13 = (float)l + random.nextFloat();
                cn1.a("largesmoke", f1, f7, f13, 0.0D, 0.0D, 0.0D);
            }

        } else
        {
            if(ly.as.b(((nm) (cn1)), j - 1, k, l))
            {
                for(int j1 = 0; j1 < 2; j1++)
                {
                    float f2 = (float)j + random.nextFloat() * 0.1F;
                    float f8 = (float)k + random.nextFloat();
                    float f14 = (float)l + random.nextFloat();
                    cn1.a("largesmoke", f2, f8, f14, 0.0D, 0.0D, 0.0D);
                }

            }
            if(ly.as.b(((nm) (cn1)), j + 1, k, l))
            {
                for(int k1 = 0; k1 < 2; k1++)
                {
                    float f3 = (float)(j + 1) - random.nextFloat() * 0.1F;
                    float f9 = (float)k + random.nextFloat();
                    float f15 = (float)l + random.nextFloat();
                    cn1.a("largesmoke", f3, f9, f15, 0.0D, 0.0D, 0.0D);
                }

            }
            if(ly.as.b(((nm) (cn1)), j, k, l - 1))
            {
                for(int l1 = 0; l1 < 2; l1++)
                {
                    float f4 = (float)j + random.nextFloat();
                    float f10 = (float)k + random.nextFloat();
                    float f16 = (float)l + random.nextFloat() * 0.1F;
                    cn1.a("largesmoke", f4, f10, f16, 0.0D, 0.0D, 0.0D);
                }

            }
            if(ly.as.b(((nm) (cn1)), j, k, l + 1))
            {
                for(int i2 = 0; i2 < 2; i2++)
                {
                    float f5 = (float)j + random.nextFloat();
                    float f11 = (float)k + random.nextFloat();
                    float f17 = (float)(l + 1) - random.nextFloat() * 0.1F;
                    cn1.a("largesmoke", f5, f11, f17, 0.0D, 0.0D, 0.0D);
                }

            }
            if(ly.as.b(((nm) (cn1)), j, k + 1, l))
            {
                for(int j2 = 0; j2 < 2; j2++)
                {
                    float f6 = (float)j + random.nextFloat();
                    float f12 = (float)(k + 1) - random.nextFloat() * 0.1F;
                    float f18 = (float)l + random.nextFloat();
                    cn1.a("largesmoke", f6, f12, f18, 0.0D, 0.0D, 0.0D);
                }

            }
        }
    }

    private int a[];
    private int b[];
}
