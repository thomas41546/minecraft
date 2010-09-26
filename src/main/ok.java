package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class ok extends dn
{

    public ok()
    {
        super(((fo) (new jy())), 1.0F);
        a(((fo) (new jy())));
    }

    protected float a(ax ax1)
    {
        return 180F;
    }

    protected boolean a(ax ax1, int i)
    {
        if(i != 0)
            return false;
        if(i != 0)
        {
            return false;
        } else
        {
            a("/mob/spider_eyes.png");
            float f = (1.0F - ax1.a(1.0F)) * 0.5F;
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
            return true;
        }
    }

    protected volatile float a(ge ge)
    {
        return a((ax)ge);
    }

    protected volatile boolean a(ge ge, int i)
    {
        return a((ax)ge, i);
    }
}
