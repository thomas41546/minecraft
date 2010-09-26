package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class bt
{

    public bt()
    {
        a = new float[16][16];
        b = new float[16];
        c = new float[16];
        d = new float[16];
    }

    public boolean a(double d1, double d2, double d3, double d4, double d5, double d6)
    {
        for(int i = 0; i < 6; i++)
            if((double)a[i][0] * d1 + (double)a[i][1] * d2 + (double)a[i][2] * d3 + (double)a[i][3] <= 0.0D && (double)a[i][0] * d4 + (double)a[i][1] * d2 + (double)a[i][2] * d3 + (double)a[i][3] <= 0.0D && (double)a[i][0] * d1 + (double)a[i][1] * d5 + (double)a[i][2] * d3 + (double)a[i][3] <= 0.0D && (double)a[i][0] * d4 + (double)a[i][1] * d5 + (double)a[i][2] * d3 + (double)a[i][3] <= 0.0D && (double)a[i][0] * d1 + (double)a[i][1] * d2 + (double)a[i][2] * d6 + (double)a[i][3] <= 0.0D && (double)a[i][0] * d4 + (double)a[i][1] * d2 + (double)a[i][2] * d6 + (double)a[i][3] <= 0.0D && (double)a[i][0] * d1 + (double)a[i][1] * d5 + (double)a[i][2] * d6 + (double)a[i][3] <= 0.0D && (double)a[i][0] * d4 + (double)a[i][1] * d5 + (double)a[i][2] * d6 + (double)a[i][3] <= 0.0D)
                return false;

        return true;
    }

    public float a[][];
    public float b[];
    public float c[];
    public float d[];
}
