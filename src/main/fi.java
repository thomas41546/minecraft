package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class fi
{

    public fi()
    {
        c = 12;
        a = new mx[16];
    }

    private static int e(int i)
    {
        i ^= i >>> 20 ^ i >>> 12;
        return i ^ i >>> 7 ^ i >>> 4;
    }

    private static int a(int i, int j)
    {
        return i & j - 1;
    }

    public Object a(int i)
    {
        int j = e(i);
        for(mx mx1 = a[a(j, a.length)]; mx1 != null; mx1 = mx1.c)
            if(mx1.a == i)
                return mx1.b;

        return ((Object) (null));
    }

    public void a(int i, Object obj)
    {
        int j = e(i);
        int k = a(j, a.length);
        for(mx mx1 = a[k]; mx1 != null; mx1 = mx1.c)
            if(mx1.a == i)
                mx1.b = obj;

        e++;
        a(j, i, obj, k);
    }

    private void f(int i)
    {
        mx amx[] = a;
        int j = amx.length;
        if(j == 0x40000000)
        {
            c = 0x7fffffff;
            return;
        } else
        {
            mx amx1[] = new mx[i];
            a(amx1);
            a = amx1;
            c = (int)((float)i * d);
            return;
        }
    }

    private void a(mx amx[])
    {
        mx amx1[] = a;
        int i = amx.length;
        for(int j = 0; j < amx1.length; j++)
        {
            mx mx1 = amx1[j];
            if(mx1 == null)
                continue;
            amx1[j] = null;
            do
            {
                mx mx2 = mx1.c;
                int k = a(mx1.d, i);
                mx1.c = amx[k];
                amx[k] = mx1;
                mx1 = mx2;
            } while(mx1 != null);
        }

    }

    public Object b(int i)
    {
        mx mx1 = c(i);
        return mx1 != null ? mx1.b : null;
    }

    final mx c(int i)
    {
        int j = e(i);
        int k = a(j, a.length);
        mx mx1 = a[k];
        mx mx2;
        mx mx3;
        for(mx2 = mx1; mx2 != null; mx2 = mx3)
        {
            mx3 = mx2.c;
            if(mx2.a == i)
            {
                e++;
                b--;
                if(mx1 == mx2)
                    a[k] = mx3;
                else
                    mx1.c = mx3;
                return mx2;
            }
            mx1 = mx2;
        }

        return mx2;
    }

    public void a()
    {
        e++;
        mx amx[] = a;
        for(int i = 0; i < amx.length; i++)
            amx[i] = null;

        b = 0;
    }

    private void a(int i, int j, Object obj, int k)
    {
        mx mx1 = a[k];
        a[k] = new mx(i, j, obj, mx1);
        if(b++ >= c)
            f(2 * a.length);
    }

    static int d(int i)
    {
        return e(i);
    }

    private transient mx a[];
    private transient int b;
    private int c;
    private final float d = 0.75F;
    private volatile transient int e;
}
