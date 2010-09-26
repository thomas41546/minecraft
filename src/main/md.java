package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class md extends di
{

    public md(int i)
    {
        super(i);
        aU = 64;
        aT = 1;
    }

    public boolean a(ev ev1, dm dm1, cn cn1, int i, int j, int k, int l)
    {
        if(l == 0)
            return false;
        if(!cn1.f(i, j, k).a())
            return false;
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
        if(!ly.aE.a(cn1, i, j, k))
            return false;
        if(l == 1)
            cn1.b(i, j, k, ly.aE.bc, eo.b((double)(((dm1.aq + 180F) * 16F) / 360F) + 0.5D) & 0xf);
        else
            cn1.b(i, j, k, ly.aJ.bc, l);
        ev1.a--;
        dm1.a((ob)cn1.b(i, j, k));
        return true;
    }
}
