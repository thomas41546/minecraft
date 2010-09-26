package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class mo extends fk
{

    public mo(int k, int i1, int j1, int k1, String s, float f)
    {
        super(k, i1, j1, 150, 20, s);
        i = 1.0F;
        j = false;
        l = 0;
        l = k1;
        i = f;
    }

    protected int a(boolean flag)
    {
        return 0;
    }

    protected void b(Minecraft minecraft, int k, int i1)
    {
        if(!h)
            return;
        if(j)
        {
            i = (float)(k - (c + 4)) / (float)(a - 8);
            if(i < 0.0F)
                i = 0.0F;
            if(i > 1.0F)
                i = 1.0F;
            minecraft.y.a(l, i);
            e = minecraft.y.d(l);
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        b(c + (int)(i * (float)(a - 8)), d, 0, 66, 4, 20);
        b(c + (int)(i * (float)(a - 8)) + 4, d, 196, 66, 4, 20);
    }

    public boolean c(Minecraft minecraft, int k, int i1)
    {
        if(super.c(minecraft, k, i1))
        {
            i = (float)(k - (c + 4)) / (float)(a - 8);
            if(i < 0.0F)
                i = 0.0F;
            if(i > 1.0F)
                i = 1.0F;
            minecraft.y.a(l, i);
            e = minecraft.y.d(l);
            j = true;
            return true;
        } else
        {
            return false;
        }
    }

    public void a(int k, int i1)
    {
        j = false;
    }

    public float i;
    public boolean j;
    private int l;
}
