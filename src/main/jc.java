package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.*;

public class jc extends kh
{

    public jc(cn cn1)
    {
        super(cn1);
        c = 0;
        a = 0;
        aB = 0.0F;
        a(0.5F, 0.5F);
    }

    public jc(cn cn1, int j, int k, int l, int i1)
    {
        this(cn1);
        d = j;
        e = k;
        f = l;
        ArrayList arraylist = new ArrayList();
        er aer[] = er.values();
        int j1 = aer.length;
        for(int k1 = 0; k1 < j1; k1++)
        {
            er er1 = aer[k1];
            b = er1;
            b(i1);
            if(i())
                ((List) (arraylist)).add(((Object) (er1)));
        }

        if(((List) (arraylist)).size() > 0)
            b = (er)((List) (arraylist)).get(aQ.nextInt(((List) (arraylist)).size()));
        b(i1);
    }

    public void b(int j)
    {
        a = j;
        as = aq = j * 90;
        float f1 = b.z;
        float f2 = b.A;
        float f3 = b.z;
        if(j == 0 || j == 2)
            f3 = 0.5F;
        else
            f1 = 0.5F;
        f1 /= 32F;
        f2 /= 32F;
        f3 /= 32F;
        float f4 = (float)d + 0.5F;
        float f5 = (float)e + 0.5F;
        float f6 = (float)f + 0.5F;
        float f7 = 0.5625F;
        if(j == 0)
            f6 -= f7;
        if(j == 1)
            f4 -= f7;
        if(j == 2)
            f6 += f7;
        if(j == 3)
            f4 += f7;
        if(j == 0)
            f4 -= c(b.z);
        if(j == 1)
            f6 += c(b.z);
        if(j == 2)
            f4 += c(b.z);
        if(j == 3)
            f6 -= c(b.z);
        f5 += c(b.A);
        a(f4, f5, f6);
        float f8 = -0.00625F;
        au.c(f4 - f1 - f8, f5 - f2 - f8, f6 - f3 - f8, f4 + f1 + f8, f5 + f2 + f8, f6 + f3 + f8);
    }

    private float c(int j)
    {
        if(j == 32)
            return 0.5F;
        return j != 64 ? 0.0F : 0.5F;
    }

    public void e_()
    {
        if(c++ == 100 && !i())
        {
            c = 0;
            F();
            ag.a(((kh) (new dx(ag, ak, al, am, new ev(di.aq)))));
        }
    }

    public boolean i()
    {
        if(ag.a(((kh) (this)), au).size() > 0)
            return false;
        int j = b.z / 16;
        int k = b.A / 16;
        int l = d;
        int i1 = e;
        int j1 = f;
        if(a == 0)
            l = eo.b(ak - (double)((float)b.z / 32F));
        if(a == 1)
            j1 = eo.b(am - (double)((float)b.z / 32F));
        if(a == 2)
            l = eo.b(ak - (double)((float)b.z / 32F));
        if(a == 3)
            j1 = eo.b(am - (double)((float)b.z / 32F));
        i1 = eo.b(al - (double)((float)b.A / 32F));
        for(int k1 = 0; k1 < j; k1++)
        {
            for(int l1 = 0; l1 < k; l1++)
            {
                gb gb1;
                if(a == 0 || a == 2)
                    gb1 = ag.f(l + k1, i1 + l1, f);
                else
                    gb1 = ag.f(d, i1 + l1, j1 + k1);
                if(!gb1.a())
                    return false;
            }

        }

        List list = ag.b(((kh) (this)), au);
        for(int i2 = 0; i2 < list.size(); i2++)
            if(list.get(i2) instanceof jc)
                return false;

        return true;
    }

    public boolean c_()
    {
        return true;
    }

    public boolean a(kh kh1, int j)
    {
        F();
        ag.a(((kh) (new dx(ag, ak, al, am, new ev(di.aq)))));
        return true;
    }

    public void a(hm hm1)
    {
        hm1.a("Dir", (byte)a);
        hm1.a("Motive", b.y);
        hm1.a("TileX", d);
        hm1.a("TileY", e);
        hm1.a("TileZ", f);
    }

    public void b(hm hm1)
    {
        a = ((int) (hm1.c("Dir")));
        d = hm1.e("TileX");
        e = hm1.e("TileY");
        f = hm1.e("TileZ");
        String s = hm1.i("Motive");
        er aer[] = er.values();
        int j = aer.length;
        for(int k = 0; k < j; k++)
        {
            er er1 = aer[k];
            if(er1.y.equals(((Object) (s))))
                b = er1;
        }

        if(b == null)
            b = er.a;
        b(a);
    }

    private int c;
    public int a;
    private int d;
    private int e;
    private int f;
    public er b;
}
