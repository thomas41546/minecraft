package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class gq extends dn
{

    public gq(fo fo, fo fo1, float f1)
    {
        super(fo, f1);
        f = fo1;
    }

    protected boolean a(ma ma1, int i)
    {
        if(i == 0)
        {
            a(f);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return true;
        }
        if(i == 1)
        {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        return false;
    }

    protected void a(ma ma1, float f1)
    {
        float f2 = (ma1.b + (ma1.a - ma1.b) * f1) / ((float)ma1.c * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        float f4 = ma1.c;
        GL11.glScalef(f3 * f4, (1.0F / f3) * f4, f3 * f4);
    }

    protected volatile void a(ge ge, float f1)
    {
        a((ma)ge, f1);
    }

    protected volatile boolean a(ge ge, int i)
    {
        return a((ma)ge, i);
    }

    private fo f;
}
