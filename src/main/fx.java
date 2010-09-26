package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class fx
{

    public fx()
    {
        a = new a[1024];
        b = 0;
    }

    public a a(a a1)
    {
        if(a1.e >= 0)
            throw new IllegalStateException("OW KNOWS!");
        if(b == a.length)
        {
            a aa[] = new a[b << 1];
            System.arraycopy(((Object) (a)), 0, ((Object) (aa)), 0, b);
            a = aa;
        }
        a[b] = a1;
        a1.e = b;
        a(b++);
        return a1;
    }

    public void a()
    {
        b = 0;
    }

    public a b()
    {
        a a1 = a[0];
        a[0] = a[--b];
        a[b] = null;
        if(b > 0)
            b(0);
        a1.e = -1;
        return a1;
    }

    public void a(a a1, float f)
    {
        float f1 = a1.h;
        a1.h = f;
        if(f < f1)
            a(a1.e);
        else
            b(a1.e);
    }

    private void a(int i)
    {
        a a1 = a[i];
        float f = a1.h;
        do
        {
            if(i <= 0)
                break;
            int j = i - 1 >> 1;
            a a2 = a[j];
            if(f >= a2.h)
                break;
            a[i] = a2;
            a2.e = i;
            i = j;
        } while(true);
        a[i] = a1;
        a1.e = i;
    }

    private void b(int i)
    {
        a a1 = a[i];
        float f = a1.h;
        do
        {
            int j = 1 + (i << 1);
            int k = j + 1;
            if(j >= b)
                break;
            a a2 = a[j];
            float f1 = a2.h;
            a a3;
            float f2;
            if(k >= b)
            {
                a3 = null;
                f2 = (1.0F / 0.0F);
            } else
            {
                a3 = a[k];
                f2 = a3.h;
            }
            if(f1 < f2)
            {
                if(f1 >= f)
                    break;
                a[i] = a2;
                a2.e = i;
                i = j;
                continue;
            }
            if(f2 >= f)
                break;
            a[i] = a3;
            a3.e = i;
            i = k;
        } while(true);
        a[i] = a1;
        a1.e = i;
    }

    public boolean c()
    {
        return b == 0;
    }

    private a a[];
    private int b;
}
