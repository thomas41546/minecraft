package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class ic
{

    public ic()
    {
    }

    private static void a(Class class1, String s)
    {
        if(b.containsKey(((Object) (s))))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate id: ").append(s).toString());
        } else
        {
            a.put(((Object) (s)), ((Object) (class1)));
            b.put(((Object) (class1)), ((Object) (s)));
            return;
        }
    }

    public void a(hm hm1)
    {
        f = hm1.e("x");
        g = hm1.e("y");
        h = hm1.e("z");
    }

    public void b(hm hm1)
    {
        String s = (String)b.get(((Object) (((Object)this).getClass())));
        if(s == null)
        {
            throw new RuntimeException((new StringBuilder()).append(((Object) (((Object)this).getClass()))).append(" is missing a mapping! This is a bug!").toString());
        } else
        {
            hm1.a("id", s);
            hm1.a("x", f);
            hm1.a("y", g);
            hm1.a("z", h);
            return;
        }
    }

    public void b()
    {
    }

    public static ic c(hm hm1)
    {
        ic ic1 = null;
        try
        {
            Class class1 = (Class)a.get(((Object) (hm1.i("id"))));
            if(class1 != null)
                ic1 = (ic)class1.newInstance();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        if(ic1 != null)
            ic1.a(hm1);
        else
            System.out.println((new StringBuilder()).append("Skipping TileEntity with id ").append(hm1.i("id")).toString());
        return ic1;
    }

    public int f()
    {
        return e.e(f, g, h);
    }

    public void j_()
    {
        e.b(f, g, h, this);
    }

    public double a(double d, double d1, double d2)
    {
        double d3 = ((double)f + 0.5D) - d;
        double d4 = ((double)g + 0.5D) - d1;
        double d5 = ((double)h + 0.5D) - d2;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public ly g()
    {
        return ly.n[e.a(f, g, h)];
    }

    private static Map a = new HashMap();
    private static Map b = new HashMap();
    public cn e;
    public int f;
    public int g;
    public int h;

    static 
    {
        a(ke, "Furnace");
        a(fe, "Chest");
        a(ob, "Sign");
        a(bd, "MobSpawner");
    }
}
