package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class ej extends ik
{

    public ej()
    {
        b = new Random();
        e = 0;
        g = 0.61799999999999999D;
        h = 1.0D;
        i = 0.38100000000000001D;
        j = 1.0D;
        k = 1.0D;
        l = 1;
        m = 12;
        n = 4;
    }

    void a()
    {
        f = (int)((double)e * g);
        if(f >= e)
            f = e - 1;
        int i1 = (int)(1.3819999999999999D + Math.pow((k * (double)e) / 13D, 2D));
        if(i1 < 1)
            i1 = 1;
        int ai[][] = new int[i1 * e][4];
        int j1 = (d[1] + e) - n;
        int k1 = 1;
        int l1 = d[1] + f;
        int i2 = j1 - d[1];
        ai[0][0] = d[0];
        ai[0][1] = j1;
        ai[0][2] = d[2];
        ai[0][3] = l1;
        j1--;
        while(i2 >= 0) 
        {
            int j2 = 0;
            float f1 = a(i2);
            if(f1 < 0.0F)
            {
                j1--;
                i2--;
            } else
            {
                double d1 = 0.5D;
                for(; j2 < i1; j2++)
                {
                    double d2 = j * ((double)f1 * ((double)b.nextFloat() + 0.32800000000000001D));
                    double d3 = (double)b.nextFloat() * 2D * 3.1415899999999999D;
                    int k2 = (int)(d2 * Math.sin(d3) + (double)d[0] + d1);
                    int l2 = (int)(d2 * Math.cos(d3) + (double)d[2] + d1);
                    int ai1[] = {
                        k2, j1, l2
                    };
                    int ai2[] = {
                        k2, j1 + n, l2
                    };
                    if(a(ai1, ai2) != -1)
                        continue;
                    int ai3[] = {
                        d[0], d[1], d[2]
                    };
                    double d4 = Math.sqrt(Math.pow(Math.abs(d[0] - ai1[0]), 2D) + Math.pow(Math.abs(d[2] - ai1[2]), 2D));
                    double d5 = d4 * i;
                    if((double)ai1[1] - d5 > (double)l1)
                        ai3[1] = l1;
                    else
                        ai3[1] = (int)((double)ai1[1] - d5);
                    if(a(ai3, ai1) == -1)
                    {
                        ai[k1][0] = k2;
                        ai[k1][1] = j1;
                        ai[k1][2] = l2;
                        ai[k1][3] = ai3[1];
                        k1++;
                    }
                }

                j1--;
                i2--;
            }
        }
        o = new int[k1][4];
        System.arraycopy(((Object) (ai)), 0, ((Object) (o)), 0, k1);
    }

    void a(int i1, int j1, int k1, float f1, byte byte0, int l1)
    {
        int i2 = (int)((double)f1 + 0.61799999999999999D);
        byte byte1 = a[byte0];
        byte byte2 = a[byte0 + 3];
        int ai[] = {
            i1, j1, k1
        };
        int ai1[] = {
            0, 0, 0
        };
        int j2 = -i2;
        int k2 = -i2;
        ai1[byte0] = ai[byte0];
        for(; j2 <= i2; j2++)
        {
            ai1[byte1] = ai[byte1] + j2;
            for(int l2 = -i2; l2 <= i2;)
            {
                double d1 = Math.sqrt(Math.pow((double)Math.abs(j2) + 0.5D, 2D) + Math.pow((double)Math.abs(l2) + 0.5D, 2D));
                if(d1 > (double)f1)
                {
                    l2++;
                } else
                {
                    ai1[byte2] = ai[byte2] + l2;
                    int i3 = c.a(ai1[0], ai1[1], ai1[2]);
                    if(i3 != 0 && i3 != 18)
                    {
                        l2++;
                    } else
                    {
                        c.a(ai1[0], ai1[1], ai1[2], l1);
                        l2++;
                    }
                }
            }

        }

    }

    float a(int i1)
    {
        if((double)i1 < (double)(float)e * 0.29999999999999999D)
            return -1.618F;
        float f1 = (float)e / 2.0F;
        float f2 = (float)e / 2.0F - (float)i1;
        float f3;
        if(f2 == 0.0F)
            f3 = f1;
        else
        if(Math.abs(f2) >= f1)
            f3 = 0.0F;
        else
            f3 = (float)Math.sqrt(Math.pow(Math.abs(f1), 2D) - Math.pow(Math.abs(f2), 2D));
        f3 *= 0.5F;
        return f3;
    }

    float b(int i1)
    {
        if(i1 < 0 || i1 >= n)
            return -1F;
        return i1 != 0 && i1 != n - 1 ? 3F : 2.0F;
    }

    void a(int i1, int j1, int k1)
    {
        int l1 = j1;
        for(int i2 = j1 + n; l1 < i2; l1++)
        {
            float f1 = b(l1 - j1);
            a(i1, l1, k1, f1, (byte)1, 18);
        }

    }

    void a(int ai[], int ai1[], int i1)
    {
        int ai2[] = {
            0, 0, 0
        };
        byte byte0 = 0;
        int j1 = 0;
        for(; byte0 < 3; byte0++)
        {
            ai2[byte0] = ai1[byte0] - ai[byte0];
            if(Math.abs(ai2[byte0]) > Math.abs(ai2[j1]))
                j1 = ((int) (byte0));
        }

        if(ai2[j1] == 0)
            return;
        byte byte1 = a[j1];
        byte byte2 = a[j1 + 3];
        byte byte3;
        if(ai2[j1] > 0)
            byte3 = 1;
        else
            byte3 = -1;
        double d1 = (double)ai2[byte1] / (double)ai2[j1];
        double d2 = (double)ai2[byte2] / (double)ai2[j1];
        int ai3[] = {
            0, 0, 0
        };
        int k1 = 0;
        for(int l1 = ai2[j1] + byte3; k1 != l1; k1 += ((int) (byte3)))
        {
            ai3[j1] = eo.b((double)(ai[j1] + k1) + 0.5D);
            ai3[byte1] = eo.b((double)ai[byte1] + (double)k1 * d1 + 0.5D);
            ai3[byte2] = eo.b((double)ai[byte2] + (double)k1 * d2 + 0.5D);
            c.a(ai3[0], ai3[1], ai3[2], i1);
        }

    }

    void b()
    {
        int i1 = 0;
        for(int j1 = o.length; i1 < j1; i1++)
        {
            int k1 = o[i1][0];
            int l1 = o[i1][1];
            int i2 = o[i1][2];
            a(k1, l1, i2);
        }

    }

    boolean c(int i1)
    {
        return (double)i1 >= (double)e * 0.20000000000000001D;
    }

    void c()
    {
        int i1 = d[0];
        int j1 = d[1];
        int k1 = d[1] + f;
        int l1 = d[2];
        int ai[] = {
            i1, j1, l1
        };
        int ai1[] = {
            i1, k1, l1
        };
        a(ai, ai1, 17);
        if(l == 2)
        {
            ai[0]++;
            ai1[0]++;
            a(ai, ai1, 17);
            ai[2]++;
            ai1[2]++;
            a(ai, ai1, 17);
            ai[0]--;
            ai1[0]--;
            a(ai, ai1, 17);
        }
    }

    void d()
    {
        int i1 = 0;
        int j1 = o.length;
        int ai[] = {
            d[0], d[1], d[2]
        };
        for(; i1 < j1; i1++)
        {
            int ai1[] = o[i1];
            int ai2[] = {
                ai1[0], ai1[1], ai1[2]
            };
            ai[1] = ai1[3];
            int k1 = ai[1] - d[1];
            if(c(k1))
                a(ai, ai2, 17);
        }

    }

    int a(int ai[], int ai1[])
    {
        int ai2[] = {
            0, 0, 0
        };
        byte byte0 = 0;
        int i1 = 0;
        for(; byte0 < 3; byte0++)
        {
            ai2[byte0] = ai1[byte0] - ai[byte0];
            if(Math.abs(ai2[byte0]) > Math.abs(ai2[i1]))
                i1 = ((int) (byte0));
        }

        if(ai2[i1] == 0)
            return -1;
        byte byte1 = a[i1];
        byte byte2 = a[i1 + 3];
        byte byte3;
        if(ai2[i1] > 0)
            byte3 = 1;
        else
            byte3 = -1;
        double d1 = (double)ai2[byte1] / (double)ai2[i1];
        double d2 = (double)ai2[byte2] / (double)ai2[i1];
        int ai3[] = {
            0, 0, 0
        };
        int j1 = 0;
        int k1 = ai2[i1] + byte3;
        do
        {
            if(j1 == k1)
                break;
            ai3[i1] = ai[i1] + j1;
            ai3[byte1] = (int)((double)ai[byte1] + (double)j1 * d1);
            ai3[byte2] = (int)((double)ai[byte2] + (double)j1 * d2);
            int l1 = c.a(ai3[0], ai3[1], ai3[2]);
            if(l1 != 0 && l1 != 18)
                break;
            j1 += ((int) (byte3));
        } while(true);
        if(j1 == k1)
            return -1;
        else
            return Math.abs(j1);
    }

    boolean e()
    {
        int ai[] = {
            d[0], d[1], d[2]
        };
        int ai1[] = {
            d[0], (d[1] + e) - 1, d[2]
        };
        int i1 = c.a(d[0], d[1] - 1, d[2]);
        if(i1 != 2 && i1 != 3)
            return false;
        int j1 = a(ai, ai1);
        if(j1 == -1)
            return true;
        if(j1 < 6)
        {
            return false;
        } else
        {
            e = j1;
            return true;
        }
    }

    public void a(double d1, double d2, double d3)
    {
        m = (int)(d1 * 12D);
        if(d1 > 0.5D)
            n = 5;
        j = d2;
        k = d3;
    }

    public boolean a(cn cn1, Random random, int i1, int j1, int k1)
    {
        c = cn1;
        long l1 = random.nextLong();
        b.setSeed(l1);
        d[0] = i1;
        d[1] = j1;
        d[2] = k1;
        if(e == 0)
            e = 5 + b.nextInt(m);
        if(!e())
        {
            return false;
        } else
        {
            a();
            b();
            c();
            d();
            return true;
        }
    }

    static final byte a[] = {
        2, 0, 0, 1, 2, 1
    };
    Random b;
    cn c;
    int d[] = {
        0, 0, 0
    };
    int e;
    int f;
    double g;
    double h;
    double i;
    double j;
    double k;
    int l;
    int m;
    int n;
    int o[][];

}
