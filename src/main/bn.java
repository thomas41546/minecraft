package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.*;
import org.lwjgl.opengl.GL11;

public class bn
{

    public bn(cn cn, List list, int i1, int j1, int k1, int l1, int i2)
    {
        C = -1;
        o = false;
        p = new boolean[2];
        x = true;
        E = false;
        B = ((List) (new ArrayList()));
        a = cn;
        F = list;
        f = g = h = l1;
        t = eo.c(f * f + g * g + h * h) / 2.0F;
        C = i2;
        c = -999;
        a(i1, j1, k1);
        u = false;
    }

    public void a(int i1, int j1, int k1)
    {
        if(i1 == c && j1 == d && k1 == e)
        {
            return;
        } else
        {
            b();
            c = i1;
            d = j1;
            e = k1;
            q = i1 + f / 2;
            r = j1 + g / 2;
            s = k1 + h / 2;
            l = i1 & 0x3ff;
            m = j1;
            n = k1 & 0x3ff;
            i = i1 - l;
            j = j1 - m;
            k = k1 - n;
            float f1 = 2.0F;
            v = cf.a((float)i1 - f1, (float)j1 - f1, (float)k1 - f1, (float)(i1 + f) + f1, (float)(j1 + g) + f1, (float)(k1 + h) + f1);
            GL11.glNewList(C + 2, 4864);
            ab.a(cf.b((float)l - f1, (float)m - f1, (float)n - f1, (float)(l + f) + f1, (float)(m + g) + f1, (float)(n + h) + f1));
            GL11.glEndList();
            f();
            return;
        }
    }

    private void g()
    {
        GL11.glTranslatef(l, m, n);
    }

    public void a()
    {
        if(!u)
            return;
        b++;
        int i1 = c;
        int j1 = d;
        int k1 = e;
        int l1 = c + f;
        int i2 = d + g;
        int j2 = e + h;
        for(int k2 = 0; k2 < 2; k2++)
            p[k2] = true;

        ga.a = false;
        HashSet hashset = new HashSet();
        ((Set) (hashset)).addAll(((java.util.Collection) (B)));
        B.clear();
        int l2 = 1;
        ci ci1 = new ci(a, i1 - l2, j1 - l2, k1 - l2, l1 + l2, i2 + l2, j2 + l2);
        bc bc1 = new bc(((nm) (ci1)));
        int i3 = 0;
        do
        {
            if(i3 >= 2)
                break;
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            for(int j3 = j1; j3 < i2; j3++)
            {
                for(int k3 = k1; k3 < j2; k3++)
                {
                    for(int l3 = i1; l3 < l1; l3++)
                    {
                        int i4 = ((nm) (ci1)).a(l3, j3, k3);
                        if(i4 <= 0)
                            continue;
                        if(!flag2)
                        {
                            flag2 = true;
                            GL11.glNewList(C + i3, 4864);
                            GL11.glPushMatrix();
                            g();
                            float f1 = 1.000001F;
                            GL11.glTranslatef((float)(-h) / 2.0F, (float)(-g) / 2.0F, (float)(-h) / 2.0F);
                            GL11.glScalef(f1, f1, f1);
                            GL11.glTranslatef((float)h / 2.0F, (float)g / 2.0F, (float)h / 2.0F);
                            D.b();
                            D.b(-c, -d, -e);
                        }
                        if(i3 == 0 && ly.q[i4])
                        {
                            ic ic = ((nm) (ci1)).b(l3, j3, k3);
                            if(fz.a.a(ic))
                                B.add(((Object) (ic)));
                        }
                        ly ly1 = ly.n[i4];
                        int j4 = ly1.g();
                        if(j4 != i3)
                        {
                            flag = true;
                            continue;
                        }
                        if(j4 == i3)
                            flag1 |= bc1.a(ly1, l3, j3, k3);
                    }

                }

            }

            if(flag2)
            {
                D.a();
                GL11.glPopMatrix();
                GL11.glEndList();
                D.b(0.0D, 0.0D, 0.0D);
            } else
            {
                flag1 = false;
            }
            if(flag1)
                p[i3] = false;
            if(!flag)
                break;
            i3++;
        } while(true);
        HashSet hashset1 = new HashSet();
        ((Set) (hashset1)).addAll(((java.util.Collection) (B)));
        ((Set) (hashset1)).removeAll(((java.util.Collection) (hashset)));
        F.addAll(((java.util.Collection) (hashset1)));
        ((Set) (hashset)).removeAll(((java.util.Collection) (B)));
        F.removeAll(((java.util.Collection) (hashset)));
        A = ga.a;
        E = true;
    }

    public float a(kh kh1)
    {
        float f1 = (float)(kh1.ak - (double)q);
        float f2 = (float)(kh1.al - (double)r);
        float f3 = (float)(kh1.am - (double)s);
        return f1 * f1 + f2 * f2 + f3 * f3;
    }

    public void b()
    {
        for(int i1 = 0; i1 < 2; i1++)
            p[i1] = true;

        o = false;
        E = false;
    }

    public void c()
    {
        b();
        a = null;
    }

    public int a(int i1)
    {
        if(!o)
            return -1;
        if(!p[i1])
            return C + i1;
        else
            return -1;
    }

    public void a(oe oe1)
    {
        o = oe1.a(v);
    }

    public void d()
    {
        GL11.glCallList(C + 2);
    }

    public boolean e()
    {
        if(!E)
            return false;
        else
            return p[0] && p[1];
    }

    public void f()
    {
        u = true;
    }

    public cn a;
    private int C;
    private static ho D;
    public static int b = 0;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p[];
    public int q;
    public int r;
    public int s;
    public float t;
    public boolean u;
    public cf v;
    public int w;
    public boolean x;
    public boolean y;
    public int z;
    public boolean A;
    private boolean E;
    public List B;
    private List F;

    static 
    {
        D = ho.a;
    }
}
