package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.ArrayList;
import java.util.List;

class mk
{

    public mk(if if1, cn cn1, int i, int j, int k)
    {
        a = if1;
        super();
        g = ((List) (new ArrayList()));
        b = cn1;
        c = i;
        d = j;
        e = k;
        f = cn1.e(i, j, k);
        a();
    }

    private void a()
    {
        g.clear();
        if(f == 0)
        {
            g.add(((Object) (new mt(c, d, e - 1))));
            g.add(((Object) (new mt(c, d, e + 1))));
        } else
        if(f == 1)
        {
            g.add(((Object) (new mt(c - 1, d, e))));
            g.add(((Object) (new mt(c + 1, d, e))));
        } else
        if(f == 2)
        {
            g.add(((Object) (new mt(c - 1, d, e))));
            g.add(((Object) (new mt(c + 1, d + 1, e))));
        } else
        if(f == 3)
        {
            g.add(((Object) (new mt(c - 1, d + 1, e))));
            g.add(((Object) (new mt(c + 1, d, e))));
        } else
        if(f == 4)
        {
            g.add(((Object) (new mt(c, d + 1, e - 1))));
            g.add(((Object) (new mt(c, d, e + 1))));
        } else
        if(f == 5)
        {
            g.add(((Object) (new mt(c, d, e - 1))));
            g.add(((Object) (new mt(c, d + 1, e + 1))));
        } else
        if(f == 6)
        {
            g.add(((Object) (new mt(c + 1, d, e))));
            g.add(((Object) (new mt(c, d, e + 1))));
        } else
        if(f == 7)
        {
            g.add(((Object) (new mt(c - 1, d, e))));
            g.add(((Object) (new mt(c, d, e + 1))));
        } else
        if(f == 8)
        {
            g.add(((Object) (new mt(c - 1, d, e))));
            g.add(((Object) (new mt(c, d, e - 1))));
        } else
        if(f == 9)
        {
            g.add(((Object) (new mt(c + 1, d, e))));
            g.add(((Object) (new mt(c, d, e - 1))));
        }
    }

    private void b()
    {
        for(int i = 0; i < g.size(); i++)
        {
            mk mk1 = a((mt)g.get(i));
            if(mk1 == null || !mk1.b(this))
                g.remove(i--);
            else
                g.set(i, ((Object) (new mt(mk1.c, mk1.d, mk1.e))));
        }

    }

    private boolean a(int i, int j, int k)
    {
        if(b.a(i, j, k) == a.bc)
            return true;
        if(b.a(i, j + 1, k) == a.bc)
            return true;
        return b.a(i, j - 1, k) == a.bc;
    }

    private mk a(mt mt1)
    {
        if(b.a(mt1.a, mt1.b, mt1.c) == a.bc)
            return new mk(a, b, mt1.a, mt1.b, mt1.c);
        if(b.a(mt1.a, mt1.b + 1, mt1.c) == a.bc)
            return new mk(a, b, mt1.a, mt1.b + 1, mt1.c);
        if(b.a(mt1.a, mt1.b - 1, mt1.c) == a.bc)
            return new mk(a, b, mt1.a, mt1.b - 1, mt1.c);
        else
            return null;
    }

    private boolean b(mk mk1)
    {
        for(int i = 0; i < g.size(); i++)
        {
            mt mt1 = (mt)g.get(i);
            if(mt1.a == mk1.c && mt1.c == mk1.e)
                return true;
        }

        return false;
    }

    private boolean b(int i, int j, int k)
    {
        for(int l = 0; l < g.size(); l++)
        {
            mt mt1 = (mt)g.get(l);
            if(mt1.a == i && mt1.c == k)
                return true;
        }

        return false;
    }

    private int c()
    {
        int i = 0;
        if(a(c, d, e - 1))
            i++;
        if(a(c, d, e + 1))
            i++;
        if(a(c - 1, d, e))
            i++;
        if(a(c + 1, d, e))
            i++;
        return i;
    }

    private boolean c(mk mk1)
    {
        if(b(mk1))
            return true;
        if(g.size() == 2)
            return false;
        if(g.size() == 0)
            return true;
        mt mt1 = (mt)g.get(0);
        return mk1.d != d || mt1.b != d ? true : true;
    }

    private void d(mk mk1)
    {
        g.add(((Object) (new mt(mk1.c, mk1.d, mk1.e))));
        boolean flag = b(c, d, e - 1);
        boolean flag1 = b(c, d, e + 1);
        boolean flag2 = b(c - 1, d, e);
        boolean flag3 = b(c + 1, d, e);
        byte byte0 = -1;
        if(flag || flag1)
            byte0 = 0;
        if(flag2 || flag3)
            byte0 = 1;
        if(flag1 && flag3 && !flag && !flag2)
            byte0 = 6;
        if(flag1 && flag2 && !flag && !flag3)
            byte0 = 7;
        if(flag && flag2 && !flag1 && !flag3)
            byte0 = 8;
        if(flag && flag3 && !flag1 && !flag2)
            byte0 = 9;
        if(byte0 == 0)
        {
            if(b.a(c, d + 1, e - 1) == a.bc)
                byte0 = 4;
            if(b.a(c, d + 1, e + 1) == a.bc)
                byte0 = 5;
        }
        if(byte0 == 1)
        {
            if(b.a(c + 1, d + 1, e) == a.bc)
                byte0 = 2;
            if(b.a(c - 1, d + 1, e) == a.bc)
                byte0 = 3;
        }
        if(byte0 < 0)
            byte0 = 0;
        b.b(c, d, e, ((int) (byte0)));
    }

    private boolean c(int i, int j, int k)
    {
        mk mk1 = a(new mt(i, j, k));
        if(mk1 == null)
        {
            return false;
        } else
        {
            mk1.b();
            return mk1.c(this);
        }
    }

    public void a(boolean flag)
    {
        boolean flag1 = c(c, d, e - 1);
        boolean flag2 = c(c, d, e + 1);
        boolean flag3 = c(c - 1, d, e);
        boolean flag4 = c(c + 1, d, e);
        int i = -1;
        if((flag1 || flag2) && !flag3 && !flag4)
            i = 0;
        if((flag3 || flag4) && !flag1 && !flag2)
            i = 1;
        if(flag2 && flag4 && !flag1 && !flag3)
            i = 6;
        if(flag2 && flag3 && !flag1 && !flag4)
            i = 7;
        if(flag1 && flag3 && !flag2 && !flag4)
            i = 8;
        if(flag1 && flag4 && !flag2 && !flag3)
            i = 9;
        if(i == -1)
        {
            if(flag1 || flag2)
                i = 0;
            if(flag3 || flag4)
                i = 1;
            if(flag)
            {
                if(flag2 && flag4)
                    i = 6;
                if(flag3 && flag2)
                    i = 7;
                if(flag4 && flag1)
                    i = 9;
                if(flag1 && flag3)
                    i = 8;
            } else
            {
                if(flag1 && flag3)
                    i = 8;
                if(flag4 && flag1)
                    i = 9;
                if(flag3 && flag2)
                    i = 7;
                if(flag2 && flag4)
                    i = 6;
            }
        }
        if(i == 0)
        {
            if(b.a(c, d + 1, e - 1) == a.bc)
                i = 4;
            if(b.a(c, d + 1, e + 1) == a.bc)
                i = 5;
        }
        if(i == 1)
        {
            if(b.a(c + 1, d + 1, e) == a.bc)
                i = 2;
            if(b.a(c - 1, d + 1, e) == a.bc)
                i = 3;
        }
        if(i < 0)
            i = 0;
        f = i;
        a();
        b.b(c, d, e, i);
        for(int j = 0; j < g.size(); j++)
        {
            mk mk1 = a((mt)g.get(j));
            if(mk1 == null)
                continue;
            mk1.b();
            if(mk1.c(this))
                mk1.d(this);
        }

    }

    static int a(mk mk1)
    {
        return mk1.c();
    }

    private cn b;
    private int c;
    private int d;
    private int e;
    private int f;
    private List g;
    final if a;
}
