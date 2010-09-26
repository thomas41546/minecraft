package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.lang.reflect.Constructor;
import java.util.*;

public class az
{

    public az(int i, Class class1, Class aclass[])
    {
        d = ((Set) (new HashSet()));
        a = i;
        b = class1;
        c = aclass;
    }

    public void a(cn cn1)
    {
        int i = cn1.b(b);
        if(i < a)
        {
            for(int j = 0; j < 3; j++)
                a(cn1, 1, ((nu) (null)));

        }
    }

    protected mt a(cn cn1, int i, int j)
    {
        int k = i + cn1.n.nextInt(16);
        int l = cn1.n.nextInt(128);
        int i1 = j + cn1.n.nextInt(16);
        return new mt(k, l, i1);
    }

    private int a(cn cn1, int i, nu nu)
    {
        d.clear();
        for(int j = 0; j < cn1.k.size(); j++)
        {
            dm dm1 = (dm)cn1.k.get(j);
            int l = eo.b(dm1.ak / 16D);
            int i1 = eo.b(dm1.am / 16D);
            byte byte0 = 4;
            for(int k1 = -byte0; k1 <= byte0; k1++)
            {
                for(int i2 = -byte0; i2 <= byte0; i2++)
                    d.add(((Object) (new ol(k1 + l, i2 + i1))));

            }

        }

        int k = 0;
        Iterator iterator = d.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            ol ol1 = (ol)iterator.next();
            if(cn1.n.nextInt(10) == 0)
            {
                int j1 = cn1.n.nextInt(c.length);
                mt mt1 = a(cn1, ol1.a * 16, ol1.b * 16);
                int l1 = mt1.a;
                int j2 = mt1.b;
                int k2 = mt1.c;
                if(cn1.g(l1, j2, k2))
                    return 0;
                if(cn1.f(l1, j2, k2) != gb.a)
                    return 0;
                int l2 = 0;
                while(l2 < 3) 
                {
                    int i3 = l1;
                    int j3 = j2;
                    int k3 = k2;
                    byte byte1 = 6;
                    for(int l3 = 0; l3 < 2; l3++)
                    {
                        i3 += cn1.n.nextInt(((int) (byte1))) - cn1.n.nextInt(((int) (byte1)));
                        j3 += cn1.n.nextInt(1) - cn1.n.nextInt(1);
                        k3 += cn1.n.nextInt(((int) (byte1))) - cn1.n.nextInt(((int) (byte1)));
                        if(!cn1.g(i3, j3 - 1, k3) || cn1.g(i3, j3, k3) || cn1.f(i3, j3, k3).d() || cn1.g(i3, j3 + 1, k3))
                            continue;
                        float f = (float)i3 + 0.5F;
                        float f1 = j3;
                        float f2 = (float)k3 + 0.5F;
                        if(cn1.a(f, f1, f2, 24D) != null)
                            continue;
                        float f3 = f - (float)cn1.o;
                        float f4 = f1 - (float)cn1.p;
                        float f5 = f2 - (float)cn1.q;
                        float f6 = f3 * f3 + f4 * f4 + f5 * f5;
                        if(f6 < 576F)
                            continue;
                        ge ge1;
                        try
                        {
                            ge1 = (ge)c[j1].getConstructor(new Class[] {
                                cn
                            }).newInstance(new Object[] {
                                cn1
                            });
                        }
                        catch(Exception exception)
                        {
                            exception.printStackTrace();
                            return k;
                        }
                        ge1.c(f, f1, f2, cn1.n.nextFloat() * 360F, 0.0F);
                        if(!ge1.a())
                            continue;
                        k++;
                        cn1.a(((kh) (ge1)));
                        if((ge1 instanceof ax) && cn1.n.nextInt(100) == 0)
                        {
                            cw cw1 = new cw(cn1);
                            cw1.c(f, f1, f2, ge1.aq, 0.0F);
                            cn1.a(((kh) (cw1)));
                            cw1.g(((kh) (ge1)));
                        }
                    }

                    l2++;
                }
            }
        } while(true);
        return k;
    }

    private int a;
    private Class b;
    private Class c[];
    private Set d;
}
