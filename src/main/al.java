package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import java.util.Random;

public class al extends ly
{

    protected al(int i, int j, js js1)
    {
        super(i, j, gb.d);
        a = js1;
        b(true);
        float f = 0.0625F;
        a(f, 0.0F, f, 1.0F - f, 0.03125F, 1.0F - f);
    }

    public int a()
    {
        return 20;
    }

    public cf d(cn cn1, int i, int j, int k)
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

    public boolean a(cn cn1, int i, int j, int k)
    {
        return cn1.g(i, j - 1, k);
    }

    public void e(cn cn1, int i, int j, int k)
    {
    }

    public void a(cn cn1, int i, int j, int k, int l)
    {
        boolean flag = false;
        if(!cn1.g(i, j - 1, k))
            flag = true;
        if(flag)
        {
            b_(cn1, i, j, k, cn1.e(i, j, k));
            cn1.d(i, j, k, 0);
        }
    }

    public void a(cn cn1, int i, int j, int k, Random random)
    {
        if(cn1.e(i, j, k) == 0)
        {
            return;
        } else
        {
            h(cn1, i, j, k);
            return;
        }
    }

    public void b(cn cn1, int i, int j, int k, kh kh)
    {
        if(cn1.e(i, j, k) == 1)
        {
            return;
        } else
        {
            h(cn1, i, j, k);
            return;
        }
    }

    private void h(cn cn1, int i, int j, int k)
    {
        boolean flag = cn1.e(i, j, k) == 1;
        boolean flag1 = false;
        float f = 0.125F;
        List list = null;
        if(a == js.a)
            list = cn1.b(((kh) (null)), cf.b((float)i + f, j, (float)k + f, (float)(i + 1) - f, (double)j + 0.25D, (float)(k + 1) - f));
        if(a == js.b)
            list = cn1.a(ge, cf.b((float)i + f, j, (float)k + f, (float)(i + 1) - f, (double)j + 0.25D, (float)(k + 1) - f));
        if(a == js.c)
            list = cn1.a(dm, cf.b((float)i + f, j, (float)k + f, (float)(i + 1) - f, (double)j + 0.25D, (float)(k + 1) - f));
        if(list.size() > 0)
            flag1 = true;
        if(flag1 && !flag)
        {
            cn1.b(i, j, k, 1);
            cn1.g(i, j, k, bc);
            cn1.g(i, j - 1, k, bc);
            cn1.b(i, j, k, i, j, k);
            cn1.a((double)i + 0.5D, (double)j + 0.10000000000000001D, (double)k + 0.5D, "random.click", 0.3F, 0.6F);
        }
        if(!flag1 && flag)
        {
            cn1.b(i, j, k, 0);
            cn1.g(i, j, k, bc);
            cn1.g(i, j - 1, k, bc);
            cn1.b(i, j, k, i, j, k);
            cn1.a((double)i + 0.5D, (double)j + 0.10000000000000001D, (double)k + 0.5D, "random.click", 0.3F, 0.5F);
        }
        if(flag1)
            cn1.h(i, j, k, bc);
    }

    public void b(cn cn1, int i, int j, int k)
    {
        int l = cn1.e(i, j, k);
        if(l > 0)
        {
            cn1.g(i, j, k, bc);
            cn1.g(i, j - 1, k, bc);
        }
        super.b(cn1, i, j, k);
    }

    public void a(nm nm1, int i, int j, int k)
    {
        boolean flag = nm1.e(i, j, k) == 1;
        float f = 0.0625F;
        if(flag)
            a(f, 0.0F, f, 1.0F - f, 0.03125F, 1.0F - f);
        else
            a(f, 0.0F, f, 1.0F - f, 0.0625F, 1.0F - f);
    }

    public boolean b(nm nm1, int i, int j, int k, int l)
    {
        return nm1.e(i, j, k) > 0;
    }

    public boolean c(cn cn1, int i, int j, int k, int l)
    {
        if(cn1.e(i, j, k) == 0)
            return false;
        else
            return l == 1;
    }

    public boolean d()
    {
        return true;
    }

    public void e()
    {
        float f = 0.5F;
        float f1 = 0.125F;
        float f2 = 0.5F;
        a(0.5F - f, 0.5F - f1, 0.5F - f2, 0.5F + f, 0.5F + f1, 0.5F + f2);
    }

    private js a;
}
