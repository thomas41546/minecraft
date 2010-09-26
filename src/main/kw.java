package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;

public class kw
{

    public kw()
    {
        g = df.c(0x10000);
        h = false;
        i = false;
    }

    public void a(int j, int k, int l, double d1, double d2, 
            double d3)
    {
        h = true;
        g.clear();
        a = j;
        b = k;
        c = l;
        d = (float)d1;
        e = (float)d2;
        f = (float)d3;
    }

    public boolean a(int j, int k, int l)
    {
        if(!h)
            return false;
        else
            return j == a && k == b && l == c;
    }

    public void a(int j)
    {
        g.put(j);
        if(g.remaining() == 0)
            a();
    }

    public void a()
    {
        if(!h)
            return;
        if(!i)
        {
            g.flip();
            i = true;
        }
        if(g.remaining() > 0)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)a - d, (float)b - e, (float)c - f);
            GL11.glCallLists(g);
            GL11.glPopMatrix();
        }
    }

    public void b()
    {
        h = false;
        i = false;
    }

    private int a;
    private int b;
    private int c;
    private float d;
    private float e;
    private float f;
    private IntBuffer g;
    private boolean h;
    private boolean i;
}
