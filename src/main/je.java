package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.*;

public class je
{

    public je()
    {
    }

    public void a(cn cn1, kh kh1, double d, double d1, double d2, float f)
    {
        cn1.a(d, d1, d2, "random.explode", 4F, (1.0F + (cn1.n.nextFloat() - cn1.n.nextFloat()) * 0.2F) * 0.7F);
        HashSet hashset = new HashSet();
        float f1 = f;
        int i = 16;
        for(int j = 0; j < i; j++)
        {
            for(int l = 0; l < i; l++)
            {
label0:
                for(int j1 = 0; j1 < i; j1++)
                {
                    if(j != 0 && j != i - 1 && l != 0 && l != i - 1 && j1 != 0 && j1 != i - 1)
                        continue;
                    double d3 = ((float)j / ((float)i - 1.0F)) * 2.0F - 1.0F;
                    double d4 = ((float)l / ((float)i - 1.0F)) * 2.0F - 1.0F;
                    double d5 = ((float)j1 / ((float)i - 1.0F)) * 2.0F - 1.0F;
                    double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
                    d3 /= d6;
                    d4 /= d6;
                    d5 /= d6;
                    float f2 = f * (0.7F + cn1.n.nextFloat() * 0.6F);
                    double d8 = d;
                    double d10 = d1;
                    double d12 = d2;
                    float f3 = 0.3F;
                    do
                    {
                        if(f2 <= 0.0F)
                            continue label0;
                        int j4 = eo.b(d8);
                        int k4 = eo.b(d10);
                        int l4 = eo.b(d12);
                        int i5 = cn1.a(j4, k4, l4);
                        if(i5 > 0)
                            f2 -= (ly.n[i5].a(kh1) + 0.3F) * f3;
                        if(f2 > 0.0F)
                            ((Set) (hashset)).add(((Object) (new mt(j4, k4, l4))));
                        d8 += d3 * (double)f3;
                        d10 += d4 * (double)f3;
                        d12 += d5 * (double)f3;
                        f2 -= f3 * 0.75F;
                    } while(true);
                }

            }

        }

        f *= 2.0F;
        int k = eo.b(d - (double)f - 1.0D);
        int i1 = eo.b(d + (double)f + 1.0D);
        int k1 = eo.b(d1 - (double)f - 1.0D);
        int l1 = eo.b(d1 + (double)f + 1.0D);
        int i2 = eo.b(d2 - (double)f - 1.0D);
        int j2 = eo.b(d2 + (double)f + 1.0D);
        List list = cn1.b(kh1, cf.b(k, k1, i2, i1, l1, j2));
        aj aj1 = aj.b(d, d1, d2);
        for(int k2 = 0; k2 < list.size(); k2++)
        {
            kh kh2 = (kh)list.get(k2);
            double d7 = kh2.e(d, d1, d2) / (double)f;
            if(d7 <= 1.0D)
            {
                double d9 = kh2.ak - d;
                double d11 = kh2.al - d1;
                double d13 = kh2.am - d2;
                double d15 = eo.a(d9 * d9 + d11 * d11 + d13 * d13);
                d9 /= d15;
                d11 /= d15;
                d13 /= d15;
                double d17 = cn1.a(aj1, kh2.au);
                double d19 = (1.0D - d7) * d17;
                kh2.a(kh1, (int)(((d19 * d19 + d19) / 2D) * 8D * (double)f + 1.0D));
                double d21 = d19;
                kh2.an += d9 * d21;
                kh2.ao += d11 * d21;
                kh2.ap += d13 * d21;
            }
        }

        f = f1;
        ArrayList arraylist = new ArrayList();
        ((List) (arraylist)).addAll(((java.util.Collection) (hashset)));
        for(int l2 = ((List) (arraylist)).size() - 1; l2 >= 0; l2--)
        {
            mt mt1 = (mt)((List) (arraylist)).get(l2);
            int i3 = mt1.a;
            int j3 = mt1.b;
            int k3 = mt1.c;
            int l3 = cn1.a(i3, j3, k3);
            for(int i4 = 0; i4 < 1; i4++)
            {
                double d14 = (float)i3 + cn1.n.nextFloat();
                double d16 = (float)j3 + cn1.n.nextFloat();
                double d18 = (float)k3 + cn1.n.nextFloat();
                double d20 = d14 - d;
                double d22 = d16 - d1;
                double d23 = d18 - d2;
                double d24 = eo.a(d20 * d20 + d22 * d22 + d23 * d23);
                d20 /= d24;
                d22 /= d24;
                d23 /= d24;
                double d25 = 0.5D / (d24 / (double)f + 0.10000000000000001D);
                d25 *= cn1.n.nextFloat() * cn1.n.nextFloat() + 0.3F;
                d20 *= d25;
                d22 *= d25;
                d23 *= d25;
                cn1.a("explode", (d14 + d * 1.0D) / 2D, (d16 + d1 * 1.0D) / 2D, (d18 + d2 * 1.0D) / 2D, d20, d22, d23);
                cn1.a("smoke", d14, d16, d18, d20, d22, d23);
            }

            if(l3 > 0)
            {
                ly.n[l3].a(cn1, i3, j3, k3, cn1.e(i3, j3, k3), 0.3F);
                cn1.d(i3, j3, k3, 0);
                ly.n[l3].c(cn1, i3, j3, k3);
            }
        }

    }
}
