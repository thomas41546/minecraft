package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class gr
    implements nu
{

    public gr(Minecraft minecraft)
    {
        a = "";
        c = "";
        d = System.currentTimeMillis();
        e = false;
        b = minecraft;
    }

    public void a(String s)
    {
        e = false;
        c(s);
    }

    public void b(String s)
    {
        e = true;
        c(c);
    }

    public void c(String s)
    {
        if(!b.F)
        {
            if(e)
                return;
            else
                throw new nr();
        } else
        {
            c = s;
            iy iy1 = new iy(b.c, b.d);
            int i = iy1.a();
            int j = iy1.b();
            GL11.glClear(256);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, i, j, 0.0D, 100D, 300D);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -200F);
            return;
        }
    }

    public void d(String s)
    {
        if(!b.F)
        {
            if(e)
                return;
            else
                throw new nr();
        } else
        {
            d = 0L;
            a = s;
            a(-1);
            d = 0L;
            return;
        }
    }

    public void a(int i)
    {
        if(!b.F)
            if(e)
                return;
            else
                throw new nr();
        long l = System.currentTimeMillis();
        if(l - d < 20L)
            return;
        d = l;
        iy iy1 = new iy(b.c, b.d);
        int j = iy1.a();
        int k = iy1.b();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, j, k, 0.0D, 100D, 300D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -200F);
        GL11.glClear(16640);
        ho ho1 = ho.a;
        int i1 = b.n.a("/dirt.png");
        GL11.glBindTexture(3553, i1);
        float f = 32F;
        ho1.b();
        ho1.b(0x404040);
        ho1.a(0.0D, k, 0.0D, 0.0D, (float)k / f);
        ho1.a(j, k, 0.0D, (float)j / f, (float)k / f);
        ho1.a(j, 0.0D, 0.0D, (float)j / f, 0.0D);
        ho1.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        ho1.a();
        if(i >= 0)
        {
            byte byte0 = 100;
            byte byte1 = 2;
            int j1 = j / 2 - byte0 / 2;
            int k1 = k / 2 + 16;
            GL11.glDisable(3553);
            ho1.b();
            ho1.b(0x808080);
            ho1.a(j1, k1, 0.0D);
            ho1.a(j1, k1 + byte1, 0.0D);
            ho1.a(j1 + byte0, k1 + byte1, 0.0D);
            ho1.a(j1 + byte0, k1, 0.0D);
            ho1.b(0x80ff80);
            ho1.a(j1, k1, 0.0D);
            ho1.a(j1, k1 + byte1, 0.0D);
            ho1.a(j1 + i, k1 + byte1, 0.0D);
            ho1.a(j1 + i, k1, 0.0D);
            ho1.a();
            GL11.glEnable(3553);
        }
        b.o.a(c, (j - b.o.a(c)) / 2, k / 2 - 4 - 16, 0xffffff);
        b.o.a(a, (j - b.o.a(a)) / 2, (k / 2 - 4) + 8, 0xffffff);
        Display.update();
        try
        {
            Thread.yield();
        }
        catch(Exception exception) { }
    }

    private String a;
    private Minecraft b;
    private String c;
    private long d;
    private boolean e;
}
