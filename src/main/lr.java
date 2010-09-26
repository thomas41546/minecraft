package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class lr extends jt
{

    protected lr(int i, Class class1, boolean flag)
    {
        super(i, gb.c);
        b = flag;
        bb = 4;
        a = class1;
        float f1 = 0.25F;
        float f2 = 1.0F;
        a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f2, 0.5F + f1);
    }

    public cf d(cn cn1, int i, int j, int k)
    {
        return null;
    }

    public cf f(cn cn1, int i, int j, int k)
    {
        a(((nm) (cn1)), i, j, k);
        return super.f(cn1, i, j, k);
    }

    public void a(nm nm1, int i, int j, int k)
    {
        if(b)
            return;
        int l = nm1.e(i, j, k);
        float f1 = 0.28125F;
        float f2 = 0.78125F;
        float f3 = 0.0F;
        float f4 = 1.0F;
        float f5 = 0.125F;
        a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if(l == 2)
            a(f3, f1, 1.0F - f5, f4, f2, 1.0F);
        if(l == 3)
            a(f3, f1, 0.0F, f4, f2, f5);
        if(l == 4)
            a(1.0F - f5, f1, f3, 1.0F, f2, f4);
        if(l == 5)
            a(0.0F, f1, f3, f5, f2, f4);
    }

    public int f()
    {
        return -1;
    }

    public boolean c()
    {
        return false;
    }

    public boolean b()
    {
        return false;
    }

    protected ic a_()
    {
        return (ic)a.newInstance();
        Exception exception;
        exception;
        throw new RuntimeException(((Throwable) (exception)));
    }

    public int a(int i, Random random)
    {
        return di.as.aS;
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        boolean flag = false;
        if(b)
        {
            if(!cn1.f(i, j - 1, k).a())
                flag = true;
        } else
        {
            int i1 = cn1.e(i, j, k);
            flag = true;
            if(i1 == 2 && cn1.f(i, j, k + 1).a())
                flag = false;
            if(i1 == 3 && cn1.f(i, j, k - 1).a())
                flag = false;
            if(i1 == 4 && cn1.f(i + 1, j, k).a())
                flag = false;
            if(i1 == 5 && cn1.f(i - 1, j, k).a())
                flag = false;
        }
        if(flag)
        {
            b_(cn1, i, j, k, cn1.e(i, j, k));
            cn1.d(i, j, k, 0);
        }
        super.a(cn1, i, j, k, l);
    }

    private Class a;
    private boolean b;
}
