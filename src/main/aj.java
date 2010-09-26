package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.ArrayList;
import java.util.List;

public class aj
{

    public static aj a(double d1, double d2, double d3)
    {
        return new aj(d1, d2, d3);
    }

    public static void a()
    {
        e = 0;
    }

    public static aj b(double d1, double d2, double d3)
    {
        if(e >= d.size())
            d.add(((Object) (a(0.0D, 0.0D, 0.0D))));
        return ((aj)d.get(e++)).e(d1, d2, d3);
    }

    private aj(double d1, double d2, double d3)
    {
        if(d1 == 0D)
            d1 = 0.0D;
        if(d2 == 0D)
            d2 = 0.0D;
        if(d3 == 0D)
            d3 = 0.0D;
        a = d1;
        b = d2;
        c = d3;
    }

    private aj e(double d1, double d2, double d3)
    {
        a = d1;
        b = d2;
        c = d3;
        return this;
    }

    public aj a(aj aj1)
    {
        return b(aj1.a - a, aj1.b - b, aj1.c - c);
    }

    public aj b()
    {
        double d1 = eo.a(a * a + b * b + c * c);
        if(d1 < 0.0001D)
            return b(0.0D, 0.0D, 0.0D);
        else
            return b(a / d1, b / d1, c / d1);
    }

    public aj b(aj aj1)
    {
        return b(b * aj1.c - c * aj1.b, c * aj1.a - a * aj1.c, a * aj1.b - b * aj1.a);
    }

    public aj c(double d1, double d2, double d3)
    {
        return b(a + d1, b + d2, c + d3);
    }

    public double c(aj aj1)
    {
        double d1 = aj1.a - a;
        double d2 = aj1.b - b;
        double d3 = aj1.c - c;
        return (double)eo.a(d1 * d1 + d2 * d2 + d3 * d3);
    }

    public double d(aj aj1)
    {
        double d1 = aj1.a - a;
        double d2 = aj1.b - b;
        double d3 = aj1.c - c;
        return d1 * d1 + d2 * d2 + d3 * d3;
    }

    public double d(double d1, double d2, double d3)
    {
        double d4 = d1 - a;
        double d5 = d2 - b;
        double d6 = d3 - c;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double c()
    {
        return (double)eo.a(a * a + b * b + c * c);
    }

    public aj a(aj aj1, double d1)
    {
        double d2 = aj1.a - a;
        double d3 = aj1.b - b;
        double d4 = aj1.c - c;
        if(d2 * d2 < 1.0000000116860974E-007D)
            return null;
        double d5 = (d1 - a) / d2;
        if(d5 < 0.0D || d5 > 1.0D)
            return null;
        else
            return b(a + d2 * d5, b + d3 * d5, c + d4 * d5);
    }

    public aj b(aj aj1, double d1)
    {
        double d2 = aj1.a - a;
        double d3 = aj1.b - b;
        double d4 = aj1.c - c;
        if(d3 * d3 < 1.0000000116860974E-007D)
            return null;
        double d5 = (d1 - b) / d3;
        if(d5 < 0.0D || d5 > 1.0D)
            return null;
        else
            return b(a + d2 * d5, b + d3 * d5, c + d4 * d5);
    }

    public aj c(aj aj1, double d1)
    {
        double d2 = aj1.a - a;
        double d3 = aj1.b - b;
        double d4 = aj1.c - c;
        if(d4 * d4 < 1.0000000116860974E-007D)
            return null;
        double d5 = (d1 - c) / d4;
        if(d5 < 0.0D || d5 > 1.0D)
            return null;
        else
            return b(a + d2 * d5, b + d3 * d5, c + d4 * d5);
    }

    public String toString()
    {
        return (new StringBuilder()).append("(").append(a).append(", ").append(b).append(", ").append(c).append(")").toString();
    }

    public void a(float f)
    {
        float f1 = eo.b(f);
        float f2 = eo.a(f);
        double d1 = a;
        double d2 = b * (double)f1 + c * (double)f2;
        double d3 = c * (double)f1 - b * (double)f2;
        a = d1;
        b = d2;
        c = d3;
    }

    public void b(float f)
    {
        float f1 = eo.b(f);
        float f2 = eo.a(f);
        double d1 = a * (double)f1 + c * (double)f2;
        double d2 = b;
        double d3 = c * (double)f1 - a * (double)f2;
        a = d1;
        b = d2;
        c = d3;
    }

    private static List d = new ArrayList();
    private static int e = 0;
    public double a;
    public double b;
    public double c;

}
