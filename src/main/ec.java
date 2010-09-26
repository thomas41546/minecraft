package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class ec extends di
{

    public ec(int i, gb gb1)
    {
        super(i);
        a = gb1;
        aU = 64;
        aT = 1;
    }

    public boolean a(ev ev1, dm dm1, cn cn1, int i, int j, int k, int l)
    {
        if(l != 1)
            return false;
        j++;
        ly ly1;
        if(a == gb.c)
            ly1 = ly.aF;
        else
            ly1 = ly.aM;
        if(!ly1.a(cn1, i, j, k))
            return false;
        int i1 = eo.b((double)(((dm1.aq + 180F) * 4F) / 360F) - 0.5D) & 3;
        byte byte0 = 0;
        byte byte1 = 0;
        if(i1 == 0)
            byte1 = 1;
        if(i1 == 1)
            byte0 = -1;
        if(i1 == 2)
            byte1 = -1;
        if(i1 == 3)
            byte0 = 1;
        int j1 = (cn1.g(i - byte0, j, k - byte1) ? 1 : 0) + (cn1.g(i - byte0, j + 1, k - byte1) ? 1 : 0);
        int k1 = (cn1.g(i + byte0, j, k + byte1) ? 1 : 0) + (cn1.g(i + byte0, j + 1, k + byte1) ? 1 : 0);
        boolean flag = cn1.a(i - byte0, j, k - byte1) == ly1.bc || cn1.a(i - byte0, j + 1, k - byte1) == ly1.bc;
        boolean flag1 = cn1.a(i + byte0, j, k + byte1) == ly1.bc || cn1.a(i + byte0, j + 1, k + byte1) == ly1.bc;
        boolean flag2 = false;
        if(flag && !flag1)
            flag2 = true;
        else
        if(k1 > j1)
            flag2 = true;
        if(flag2)
        {
            i1 = i1 - 1 & 3;
            i1 += 4;
        }
        cn1.d(i, j, k, ly1.bc);
        cn1.b(i, j, k, i1);
        cn1.d(i, j + 1, k, ly1.bc);
        cn1.b(i, j + 1, k, i1 + 8);
        ev1.a--;
        return true;
    }

    private gb a;
}
