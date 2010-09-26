package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class r extends ex
{

    public r()
    {
        b = ((Map) (new HashMap()));
    }

    public void a(bd bd1, double d, double d1, double d2, 
            float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1, (float)d2 + 0.5F);
        kh kh1 = (kh)b.get(((Object) (bd1.b)));
        if(kh1 == null)
        {
            kh1 = ew.a(bd1.b, ((cn) (null)));
            b.put(((Object) (bd1.b)), ((Object) (kh1)));
        }
        if(kh1 != null)
        {
            kh1.a(bd1.e);
            float f1 = 0.4375F;
            GL11.glTranslatef(0.0F, 0.4F, 0.0F);
            GL11.glRotatef((float)(bd1.d + (bd1.c - bd1.d) * (double)f) * 10F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-30F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.4F, 0.0F);
            GL11.glScalef(f1, f1, f1);
            kh1.c(d, d1, d2, 0.0F, 0.0F);
            kx.a.a(kh1, 0.0D, 0.0D, 0.0D, 0.0F, f);
        }
        GL11.glPopMatrix();
    }

    public volatile void a(ic ic, double d, double d1, double d2, 
            float f)
    {
        a((bd)ic, d, d1, d2, f);
    }

    private Map b;
}
