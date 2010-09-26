package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class d extends dn
{

    public d()
    {
        super(((fo) (new em())), 0.5F);
    }

    protected void a(dd dd1, float f)
    {
        dd dd2 = dd1;
        float f1 = dd2.b(f);
        float f2 = 1.0F + eo.a(f1 * 100F) * f1 * 0.01F;
        if(f1 < 0.0F)
            f1 = 0.0F;
        if(f1 > 1.0F)
            f1 = 1.0F;
        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0F + f1 * 0.4F) * f2;
        float f4 = (1.0F + f1 * 0.1F) / f2;
        GL11.glScalef(f3, f4, f3);
    }

    protected int a(dd dd1, float f, float f1)
    {
        dd dd2 = dd1;
        float f2 = dd2.b(f1);
        if((int)(f2 * 10F) % 2 == 0)
            return 0;
        int i = (int)(f2 * 0.2F * 255F);
        if(i < 0)
            i = 0;
        if(i > 255)
            i = 255;
        char c = '\377';
        char c1 = '\377';
        char c2 = '\377';
        return i << 24 | c << 16 | c1 << 8 | c2;
    }

    protected volatile void a(ge ge, float f)
    {
        a((dd)ge, f);
    }

    protected volatile int a(ge ge, float f, float f1)
    {
        return a((dd)ge, f, f1);
    }
}
