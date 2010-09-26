package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class fe extends ic
    implements gh
{

    public fe()
    {
        a = new ev[36];
    }

    public int c()
    {
        return 27;
    }

    public ev c(int i)
    {
        return a[i];
    }

    public ev a(int i, int j)
    {
        if(a[i] != null)
        {
            if(a[i].a <= j)
            {
                ev ev1 = a[i];
                a[i] = null;
                j_();
                return ev1;
            }
            ev ev2 = a[i].a(j);
            if(a[i].a == 0)
                a[i] = null;
            j_();
            return ev2;
        } else
        {
            return null;
        }
    }

    public void a(int i, ev ev1)
    {
        a[i] = ev1;
        if(ev1 != null && ev1.a > e())
            ev1.a = e();
        j_();
    }

    public String d()
    {
        return "Chest";
    }

    public void a(hm hm1)
    {
        super.a(hm1);
        ki ki1 = hm1.l("Items");
        a = new ev[c()];
        for(int i = 0; i < ki1.c(); i++)
        {
            hm hm2 = (hm)ki1.a(i);
            int j = hm2.c("Slot") & 0xff;
            if(j >= 0 && j < a.length)
                a[j] = new ev(hm2);
        }

    }

    public void b(hm hm1)
    {
        super.b(hm1);
        ki ki1 = new ki();
        for(int i = 0; i < a.length; i++)
            if(a[i] != null)
            {
                hm hm2 = new hm();
                hm2.a("Slot", (byte)i);
                a[i].a(hm2);
                ki1.a(((el) (hm2)));
            }

        hm1.a("Items", ((el) (ki1)));
    }

    public int e()
    {
        return 64;
    }

    private ev a[];
}
