package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class od extends di
{

    public od(int i)
    {
        super(i);
        aU = 64;
    }

    public boolean a(ev ev1, dm dm, cn cn1, int i, int j, int k, int l)
    {
        if(l == 0)
            return false;
        if(l == 1)
            return false;
        byte byte0 = 0;
        if(l == 4)
            byte0 = 1;
        if(l == 3)
            byte0 = 2;
        if(l == 5)
            byte0 = 3;
        jc jc1 = new jc(cn1, i, j, k, ((int) (byte0)));
        if(jc1.i())
        {
            cn1.a(((kh) (jc1)));
            ev1.a--;
        }
        return true;
    }
}
