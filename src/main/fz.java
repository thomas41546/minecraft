package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.*;
import org.lwjgl.opengl.GL11;

public class fz
{

    private fz()
    {
        m = ((Map) (new HashMap()));
        m.put(ob, ((Object) (new in())));
        m.put(bd, ((Object) (new r())));
        ex ex1;
        for(Iterator iterator = m.values().iterator(); iterator.hasNext(); ex1.a(this))
            ex1 = (ex)iterator.next();

    }

    public ex a(Class class1)
    {
        ex ex1 = (ex)m.get(((Object) (class1)));
        if(ex1 == null && class1 != ic)
        {
            ex1 = a(class1.getSuperclass());
            m.put(((Object) (class1)), ((Object) (ex1)));
        }
        return ex1;
    }

    public boolean a(ic ic1)
    {
        return b(ic1) != null;
    }

    public ex b(ic ic1)
    {
        return a(((Object) (ic1)).getClass());
    }

    public void a(cn cn1, ey ey, kd kd, dm dm1, float f1)
    {
        f = cn1;
        e = ey;
        g = dm1;
        n = kd;
        h = dm1.as + (dm1.aq - dm1.as) * f1;
        i = dm1.at + (dm1.ar - dm1.at) * f1;
        j = dm1.aI + (dm1.ak - dm1.aI) * (double)f1;
        k = dm1.aJ + (dm1.al - dm1.aJ) * (double)f1;
        l = dm1.aK + (dm1.am - dm1.aK) * (double)f1;
    }

    public void a(ic ic1, float f1)
    {
        if(ic1.a(j, k, l) < 4096D)
        {
            float f2 = f.c(ic1.f, ic1.g, ic1.h);
            GL11.glColor3f(f2, f2, f2);
            a(ic1, (double)ic1.f - b, (double)ic1.g - c, (double)ic1.h - d, f1);
        }
    }

    public void a(ic ic1, double d1, double d2, double d3, 
            float f1)
    {
        ex ex1 = b(ic1);
        if(ex1 != null)
            ex1.a(ic1, d1, d2, d3, f1);
    }

    public kd a()
    {
        return n;
    }

    private Map m;
    public static fz a = new fz();
    private kd n;
    public static double b;
    public static double c;
    public static double d;
    public ey e;
    public cn f;
    public dm g;
    public float h;
    public float i;
    public double j;
    public double k;
    public double l;

}
