package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class gf extends di
{

    public gf(int i, ly ly1)
    {
        super(i);
        a = ly1.bc;
    }

    public boolean a(ev ev1, dm dm, cn cn1, int i, int j, int k, int l)
    {
        if(cn1.a(i, j, k) == ly.aT.bc)
        {
            l = 0;
        } else
        {
            if(l == 0)
                j--;
            if(l == 1)
                j++;
            if(l == 2)
                k--;
            if(l == 3)
                k++;
            if(l == 4)
                i--;
            if(l == 5)
                i++;
        }
        if(ev1.a == 0)
            return false;
        if(cn1.a(a, i, j, k, false))
        {
            ly ly1 = ly.n[a];
            if(cn1.d(i, j, k, a))
            {
                ly.n[a].d(cn1, i, j, k, l);
                cn1.a((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, ly1.bl.d(), (ly1.bl.b() + 1.0F) / 2.0F, ly1.bl.c() * 0.8F);
                ev1.a--;
            }
        }
        return true;
    }

    private int a;
}
