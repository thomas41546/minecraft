package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.ArrayList;
import java.util.List;

public class cf
{

    public static cf a(double d1, double d2, double d3, double d4, 
            double d5, double d6)
    {
        return new cf(d1, d2, d3, d4, d5, d6);
    }

    public static void a()
    {
        h = 0;
    }

    public static cf b(double d1, double d2, double d3, double d4, 
            double d5, double d6)
    {
        if(h >= g.size())
            g.add(((Object) (a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D))));
        return ((cf)g.get(h++)).c(d1, d2, d3, d4, d5, d6);
    }

    private cf(double d1, double d2, double d3, double d4, double d5, double d6)
    {
        a = d1;
        b = d2;
        c = d3;
        d = d4;
        e = d5;
        f = d6;
    }

    public cf c(double d1, double d2, double d3, double d4, double d5, double d6)
    {
        a = d1;
        b = d2;
        c = d3;
        d = d4;
        e = d5;
        f = d6;
        return this;
    }

    public cf a(double d1, double d2, double d3)
    {
        double d4 = a;
        double d5 = b;
        double d6 = c;
        double d7 = d;
        double d8 = e;
        double d9 = f;
        if(d1 < 0.0D)
            d4 += d1;
        if(d1 > 0.0D)
            d7 += d1;
        if(d2 < 0.0D)
            d5 += d2;
        if(d2 > 0.0D)
            d8 += d2;
        if(d3 < 0.0D)
            d6 += d3;
        if(d3 > 0.0D)
            d9 += d3;
        return b(d4, d5, d6, d7, d8, d9);
    }

    public cf b(double d1, double d2, double d3)
    {
        double d4 = a - d1;
        double d5 = b - d2;
        double d6 = c - d3;
        double d7 = d + d1;
        double d8 = e + d2;
        double d9 = f + d3;
        return b(d4, d5, d6, d7, d8, d9);
    }

    public cf c(double d1, double d2, double d3)
    {
        return b(a + d1, b + d2, c + d3, d + d1, e + d2, f + d3);
    }

    public double a(cf cf1, double d1)
    {
        if(cf1.e <= b || cf1.b >= e)
            return d1;
        if(cf1.f <= c || cf1.c >= f)
            return d1;
        if(d1 > 0.0D && cf1.d <= a)
        {
            double d2 = a - cf1.d;
            if(d2 < d1)
                d1 = d2;
        }
        if(d1 < 0.0D && cf1.a >= d)
        {
            double d3 = d - cf1.a;
            if(d3 > d1)
                d1 = d3;
        }
        return d1;
    }

    public double b(cf cf1, double d1)
    {
        if(cf1.d <= a || cf1.a >= d)
            return d1;
        if(cf1.f <= c || cf1.c >= f)
            return d1;
        if(d1 > 0.0D && cf1.e <= b)
        {
            double d2 = b - cf1.e;
            if(d2 < d1)
                d1 = d2;
        }
        if(d1 < 0.0D && cf1.b >= e)
        {
            double d3 = e - cf1.b;
            if(d3 > d1)
                d1 = d3;
        }
        return d1;
    }

    public double c(cf cf1, double d1)
    {
        if(cf1.d <= a || cf1.a >= d)
            return d1;
        if(cf1.e <= b || cf1.b >= e)
            return d1;
        if(d1 > 0.0D && cf1.f <= c)
        {
            double d2 = c - cf1.f;
            if(d2 < d1)
                d1 = d2;
        }
        if(d1 < 0.0D && cf1.c >= f)
        {
            double d3 = f - cf1.c;
            if(d3 > d1)
                d1 = d3;
        }
        return d1;
    }

    public boolean a(cf cf1)
    {
        if(cf1.d <= a || cf1.a >= d)
            return false;
        if(cf1.e <= b || cf1.b >= e)
            return false;
        return cf1.f > c && cf1.c < f;
    }

    public cf d(double d1, double d2, double d3)
    {
        a += d1;
        b += d2;
        c += d3;
        d += d1;
        e += d2;
        f += d3;
        return this;
    }

    public double b()
    {
        double d1 = d - a;
        double d2 = e - b;
        double d3 = f - c;
        return (d1 + d2 + d3) / 3D;
    }

    public cf c()
    {
        return b(a, b, c, d, e, f);
    }

    public mf a(aj aj1, aj aj2)
    {
        aj aj3 = aj1.a(aj2, a);
        aj aj4 = aj1.a(aj2, d);
        aj aj5 = aj1.b(aj2, b);
        aj aj6 = aj1.b(aj2, e);
        aj aj7 = aj1.c(aj2, c);
        aj aj8 = aj1.c(aj2, f);
        if(!a(aj3))
            aj3 = null;
        if(!a(aj4))
            aj4 = null;
        if(!b(aj5))
            aj5 = null;
        if(!b(aj6))
            aj6 = null;
        if(!c(aj7))
            aj7 = null;
        if(!c(aj8))
            aj8 = null;
        aj aj9 = null;
        if(aj3 != null && (aj9 == null || aj1.d(aj3) < aj1.d(aj9)))
            aj9 = aj3;
        if(aj4 != null && (aj9 == null || aj1.d(aj4) < aj1.d(aj9)))
            aj9 = aj4;
        if(aj5 != null && (aj9 == null || aj1.d(aj5) < aj1.d(aj9)))
            aj9 = aj5;
        if(aj6 != null && (aj9 == null || aj1.d(aj6) < aj1.d(aj9)))
            aj9 = aj6;
        if(aj7 != null && (aj9 == null || aj1.d(aj7) < aj1.d(aj9)))
            aj9 = aj7;
        if(aj8 != null && (aj9 == null || aj1.d(aj8) < aj1.d(aj9)))
            aj9 = aj8;
        if(aj9 == null)
            return null;
        byte byte0 = -1;
        if(aj9 == aj3)
            byte0 = 4;
        if(aj9 == aj4)
            byte0 = 5;
        if(aj9 == aj5)
            byte0 = 0;
        if(aj9 == aj6)
            byte0 = 1;
        if(aj9 == aj7)
            byte0 = 2;
        if(aj9 == aj8)
            byte0 = 3;
        return new mf(0, 0, 0, ((int) (byte0)), aj9);
    }

    private boolean a(aj aj1)
    {
        if(aj1 == null)
            return false;
        else
            return aj1.b >= b && aj1.b <= e && aj1.c >= c && aj1.c <= f;
    }

    private boolean b(aj aj1)
    {
        if(aj1 == null)
            return false;
        else
            return aj1.a >= a && aj1.a <= d && aj1.c >= c && aj1.c <= f;
    }

    private boolean c(aj aj1)
    {
        if(aj1 == null)
            return false;
        else
            return aj1.a >= a && aj1.a <= d && aj1.b >= b && aj1.b <= e;
    }

    public void b(cf cf1)
    {
        a = cf1.a;
        b = cf1.b;
        c = cf1.c;
        d = cf1.d;
        e = cf1.e;
        f = cf1.f;
    }

    private static List g = new ArrayList();
    private static int h = 0;
    public double a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;

}
