package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class b extends jt
{

    protected b(int i)
    {
        super(i, gb.c);
        a = new Random();
        bb = 26;
    }

    public int a(nm nm1, int i, int j, int k, int l)
    {
        if(l == 1)
            return bb - 1;
        if(l == 0)
            return bb - 1;
        int i1 = nm1.a(i, j, k - 1);
        int j1 = nm1.a(i, j, k + 1);
        int k1 = nm1.a(i - 1, j, k);
        int l1 = nm1.a(i + 1, j, k);
        if(i1 == bc || j1 == bc)
        {
            if(l == 2 || l == 3)
                return bb;
            int i2 = 0;
            if(i1 == bc)
                i2 = -1;
            int k2 = nm1.a(i - 1, j, i1 != bc ? k + 1 : k - 1);
            int i3 = nm1.a(i + 1, j, i1 != bc ? k + 1 : k - 1);
            if(l == 4)
                i2 = -1 - i2;
            byte byte1 = 5;
            if((ly.p[k1] || ly.p[k2]) && !ly.p[l1] && !ly.p[i3])
                byte1 = 5;
            if((ly.p[l1] || ly.p[i3]) && !ly.p[k1] && !ly.p[k2])
                byte1 = 4;
            return (l != byte1 ? bb + 32 : bb + 16) + i2;
        }
        if(k1 == bc || l1 == bc)
        {
            if(l == 4 || l == 5)
                return bb;
            int j2 = 0;
            if(k1 == bc)
                j2 = -1;
            int l2 = nm1.a(k1 != bc ? i + 1 : i - 1, j, k - 1);
            int j3 = nm1.a(k1 != bc ? i + 1 : i - 1, j, k + 1);
            if(l == 3)
                j2 = -1 - j2;
            byte byte2 = 3;
            if((ly.p[i1] || ly.p[l2]) && !ly.p[j1] && !ly.p[j3])
                byte2 = 3;
            if((ly.p[j1] || ly.p[j3]) && !ly.p[i1] && !ly.p[l2])
                byte2 = 2;
            return (l != byte2 ? bb + 32 : bb + 16) + j2;
        }
        byte byte0 = 3;
        if(ly.p[i1] && !ly.p[j1])
            byte0 = 3;
        if(ly.p[j1] && !ly.p[i1])
            byte0 = 2;
        if(ly.p[k1] && !ly.p[l1])
            byte0 = 5;
        if(ly.p[l1] && !ly.p[k1])
            byte0 = 4;
        return l != byte0 ? bb : bb + 1;
    }

    public int a(int i)
    {
        if(i == 1)
            return bb - 1;
        if(i == 0)
            return bb - 1;
        if(i == 3)
            return bb + 1;
        else
            return bb;
    }

    public boolean a(cn cn1, int i, int j, int k)
    {
        int l = 0;
        if(cn1.a(i - 1, j, k) == bc)
            l++;
        if(cn1.a(i + 1, j, k) == bc)
            l++;
        if(cn1.a(i, j, k - 1) == bc)
            l++;
        if(cn1.a(i, j, k + 1) == bc)
            l++;
        if(l > 1)
            return false;
        if(h(cn1, i - 1, j, k))
            return false;
        if(h(cn1, i + 1, j, k))
            return false;
        if(h(cn1, i, j, k - 1))
            return false;
        return !h(cn1, i, j, k + 1);
    }

    private boolean h(cn cn1, int i, int j, int k)
    {
        if(cn1.a(i, j, k) != bc)
            return false;
        if(cn1.a(i - 1, j, k) == bc)
            return true;
        if(cn1.a(i + 1, j, k) == bc)
            return true;
        if(cn1.a(i, j, k - 1) == bc)
            return true;
        return cn1.a(i, j, k + 1) == bc;
    }

    public void b(cn cn1, int i, int j, int k)
    {
        fe fe1 = (fe)cn1.b(i, j, k);
label0:
        for(int l = 0; l < ((gh) (fe1)).c(); l++)
        {
            ev ev1 = ((gh) (fe1)).c(l);
            if(ev1 == null)
                continue;
            float f = a.nextFloat() * 0.8F + 0.1F;
            float f1 = a.nextFloat() * 0.8F + 0.1F;
            float f2 = a.nextFloat() * 0.8F + 0.1F;
            do
            {
                if(ev1.a <= 0)
                    continue label0;
                int i1 = a.nextInt(21) + 10;
                if(i1 > ev1.a)
                    i1 = ev1.a;
                ev1.a -= i1;
                dx dx1 = new dx(cn1, (float)i + f, (float)j + f1, (float)k + f2, new ev(ev1.c, i1, ev1.d));
                float f3 = 0.05F;
                dx1.an = (float)a.nextGaussian() * f3;
                dx1.ao = (float)a.nextGaussian() * f3 + 0.2F;
                dx1.ap = (float)a.nextGaussian() * f3;
                cn1.a(((kh) (dx1)));
            } while(true);
        }

        super.b(cn1, i, j, k);
    }

    public boolean a(cn cn1, int i, int j, int k, dm dm1)
    {
        Object obj = ((Object) ((fe)cn1.b(i, j, k)));
        if(cn1.g(i, j + 1, k))
            return true;
        if(cn1.a(i - 1, j, k) == bc && cn1.g(i - 1, j + 1, k))
            return true;
        if(cn1.a(i + 1, j, k) == bc && cn1.g(i + 1, j + 1, k))
            return true;
        if(cn1.a(i, j, k - 1) == bc && cn1.g(i, j + 1, k - 1))
            return true;
        if(cn1.a(i, j, k + 1) == bc && cn1.g(i, j + 1, k + 1))
            return true;
        if(cn1.a(i - 1, j, k) == bc)
            obj = ((Object) (new hs("Large chest", ((gh) ((fe)cn1.b(i - 1, j, k))), ((gh) (obj)))));
        if(cn1.a(i + 1, j, k) == bc)
            obj = ((Object) (new hs("Large chest", ((gh) (obj)), ((gh) ((fe)cn1.b(i + 1, j, k))))));
        if(cn1.a(i, j, k - 1) == bc)
            obj = ((Object) (new hs("Large chest", ((gh) ((fe)cn1.b(i, j, k - 1))), ((gh) (obj)))));
        if(cn1.a(i, j, k + 1) == bc)
            obj = ((Object) (new hs("Large chest", ((gh) (obj)), ((gh) ((fe)cn1.b(i, j, k + 1))))));
        dm1.a(((gh) (obj)));
        return true;
    }

    protected ic a_()
    {
        return ((ic) (new fe()));
    }

    private Random a;
}
