package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class au extends bh
{

    public au()
    {
    }

    public void a()
    {
        e.clear();
        e.add(((Object) (new fk(1, c / 2 - 100, d / 4 + 72, "Respawn"))));
        e.add(((Object) (new fk(2, c / 2 - 100, d / 4 + 96, "Title menu"))));
        if(b.i == null)
            ((fk)e.get(1)).g = false;
    }

    protected void a(char c, int i)
    {
    }

    protected void a(fk fk1)
    {
        if(fk1.f != 0);
        if(fk1.f == 1)
        {
            b.o();
            b.a(((bh) (null)));
        }
        if(fk1.f == 2)
        {
            b.a(((cn) (null)));
            b.a(((bh) (new cx())));
        }
    }

    public void a(int i, int j, float f)
    {
        a(0, 0, c, d, 0x60500000, 0xa0803030);
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        a(g, "Game over!", c / 2 / 2, 30, 0xffffff);
        GL11.glPopMatrix();
        a(g, (new StringBuilder()).append("Score: &e").append(b.g.r()).toString(), c / 2, 100, 0xffffff);
        super.a(i, j, f);
    }

    public boolean b()
    {
        return false;
    }
}
