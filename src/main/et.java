package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class et extends ar
{

    public et()
    {
        a = new gu(((ar) (this)), 3, 3);
        b = ((gh) (new mw()));
    }

    public void a(gh gh1)
    {
        int ai[] = new int[9];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                int k = i + j * 3;
                ev ev1 = a.c(k);
                if(ev1 == null)
                    ai[k] = -1;
                else
                    ai[k] = ev1.c;
            }

        }

        b.a(0, dw.a().a(ai));
    }

    public void a(dm dm1)
    {
        super.a(dm1);
        for(int i = 0; i < 9; i++)
        {
            ev ev1 = a.c(i);
            if(ev1 != null)
                dm1.a(ev1);
        }

    }

    public gu a;
    public gh b;
}
