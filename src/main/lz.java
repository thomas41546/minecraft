package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.*;

public class lz
    implements aw
{

    public lz(cn cn)
    {
        b = ((Map) (new HashMap()));
        c = ((List) (new ArrayList()));
        a = new ga(cn, new byte[32768], 0, 0);
        a.q = true;
        a.p = true;
        d = cn;
    }

    public boolean a(int i, int j)
    {
        hc hc1 = new hc(i, j);
        return b.containsKey(((Object) (hc1)));
    }

    public void c(int i, int j)
    {
        ga ga1 = b(i, j);
        if(!ga1.q)
            ga1.e();
        b.remove(((Object) (new hc(i, j))));
        c.remove(((Object) (ga1)));
    }

    public ga d(int i, int j)
    {
        hc hc1 = new hc(i, j);
        byte abyte0[] = new byte[32768];
        ga ga1 = new ga(d, abyte0, i, j);
        Arrays.fill(ga1.f.a, (byte)-1);
        b.put(((Object) (hc1)), ((Object) (ga1)));
        ga1.c = true;
        return ga1;
    }

    public ga b(int i, int j)
    {
        hc hc1 = new hc(i, j);
        ga ga1 = (ga)b.get(((Object) (hc1)));
        if(ga1 == null)
            return a;
        else
            return ga1;
    }

    public boolean a(boolean flag, nu nu)
    {
        return true;
    }

    public boolean a()
    {
        return false;
    }

    public boolean b()
    {
        return false;
    }

    public void a(aw aw1, int i, int j)
    {
    }

    private ga a;
    private Map b;
    private List c;
    private cn d;
}
