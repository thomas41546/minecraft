package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class ip
{

    public ip(int i1, int j1)
    {
        n = false;
        o = 0;
        g = false;
        h = true;
        i = false;
        l = i1;
        m = j1;
    }

    public void a(float f1, float f2, float f3, int i1, int j1, int k1)
    {
        a(f1, f2, f3, i1, j1, k1, 0.0F);
    }

    public void a(float f1, float f2, float f3, int i1, int j1, int k1, float f4)
    {
        j = new ed[8];
        k = new ll[6];
        float f5 = f1 + (float)i1;
        float f6 = f2 + (float)j1;
        float f7 = f3 + (float)k1;
        f1 -= f4;
        f2 -= f4;
        f3 -= f4;
        f5 += f4;
        f6 += f4;
        f7 += f4;
        if(g)
        {
            float f8 = f5;
            f5 = f1;
            f1 = f8;
        }
        ed ed1 = new ed(f1, f2, f3, 0.0F, 0.0F);
        ed ed2 = new ed(f5, f2, f3, 0.0F, 8F);
        ed ed3 = new ed(f5, f6, f3, 8F, 8F);
        ed ed4 = new ed(f1, f6, f3, 8F, 0.0F);
        ed ed5 = new ed(f1, f2, f7, 0.0F, 0.0F);
        ed ed6 = new ed(f5, f2, f7, 0.0F, 8F);
        ed ed7 = new ed(f5, f6, f7, 8F, 8F);
        ed ed8 = new ed(f1, f6, f7, 8F, 0.0F);
        j[0] = ed1;
        j[1] = ed2;
        j[2] = ed3;
        j[3] = ed4;
        j[4] = ed5;
        j[5] = ed6;
        j[6] = ed7;
        j[7] = ed8;
        k[0] = new ll(new ed[] {
            ed6, ed2, ed3, ed7
        }, l + k1 + i1, m + k1, l + k1 + i1 + k1, m + k1 + j1);
        k[1] = new ll(new ed[] {
            ed1, ed5, ed8, ed4
        }, l + 0, m + k1, l + k1, m + k1 + j1);
        k[2] = new ll(new ed[] {
            ed6, ed5, ed1, ed2
        }, l + k1, m + 0, l + k1 + i1, m + k1);
        k[3] = new ll(new ed[] {
            ed3, ed4, ed8, ed7
        }, l + k1 + i1, m + 0, l + k1 + i1 + i1, m + k1);
        k[4] = new ll(new ed[] {
            ed2, ed1, ed4, ed3
        }, l + k1, m + k1, l + k1 + i1, m + k1 + j1);
        k[5] = new ll(new ed[] {
            ed5, ed6, ed7, ed8
        }, l + k1 + i1 + k1, m + k1, l + k1 + i1 + k1 + i1, m + k1 + j1);
        if(g)
        {
            for(int l1 = 0; l1 < k.length; l1++)
                k[l1].a();

        }
    }

    public void a(float f1, float f2, float f3)
    {
        a = f1;
        b = f2;
        c = f3;
    }

    public void a(float f1)
    {
        if(i)
            return;
        if(!h)
            return;
        if(!n)
            c(f1);
        if(d != 0.0F || e != 0.0F || f != 0.0F)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(a * f1, b * f1, c * f1);
            if(f != 0.0F)
                GL11.glRotatef(f * 57.29578F, 0.0F, 0.0F, 1.0F);
            if(e != 0.0F)
                GL11.glRotatef(e * 57.29578F, 0.0F, 1.0F, 0.0F);
            if(d != 0.0F)
                GL11.glRotatef(d * 57.29578F, 1.0F, 0.0F, 0.0F);
            GL11.glCallList(o);
            GL11.glPopMatrix();
        } else
        if(a != 0.0F || b != 0.0F || c != 0.0F)
        {
            GL11.glTranslatef(a * f1, b * f1, c * f1);
            GL11.glCallList(o);
            GL11.glTranslatef(-a * f1, -b * f1, -c * f1);
        } else
        {
            GL11.glCallList(o);
        }
    }

    public void b(float f1)
    {
        if(i)
            return;
        if(!h)
            return;
        if(!n)
            c(f1);
        if(d != 0.0F || e != 0.0F || f != 0.0F)
        {
            GL11.glTranslatef(a * f1, b * f1, c * f1);
            if(f != 0.0F)
                GL11.glRotatef(f * 57.29578F, 0.0F, 0.0F, 1.0F);
            if(e != 0.0F)
                GL11.glRotatef(e * 57.29578F, 0.0F, 1.0F, 0.0F);
            if(d != 0.0F)
                GL11.glRotatef(d * 57.29578F, 1.0F, 0.0F, 0.0F);
        } else
        if(a != 0.0F || b != 0.0F || c != 0.0F)
            GL11.glTranslatef(a * f1, b * f1, c * f1);
    }

    private void c(float f1)
    {
        o = df.a(1);
        GL11.glNewList(o, 4864);
        ho ho1 = ho.a;
        for(int i1 = 0; i1 < k.length; i1++)
            k[i1].a(ho1, f1);

        GL11.glEndList();
        n = true;
    }

    private ed j[];
    private ll k[];
    private int l;
    private int m;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    private boolean n;
    private int o;
    public boolean g;
    public boolean h;
    public boolean i;
}
