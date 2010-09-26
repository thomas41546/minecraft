package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ea extends ee
{

    public ea(gh gh1, gh gh2)
    {
        m = 0;
        j = gh1;
        l = gh2;
        f = false;
        char c = '\336';
        int i = c - 108;
        m = gh2.c() / 9;
        h = i + m * 18;
        int k = (m - 4) * 18;
        for(int i1 = 0; i1 < m; i1++)
        {
            for(int l1 = 0; l1 < 9; l1++)
                this.i.add(((Object) (new mm(((ee) (this)), gh2, l1 + i1 * 9, 8 + l1 * 18, 18 + i1 * 18))));

        }

        for(int j1 = 0; j1 < 3; j1++)
        {
            for(int i2 = 0; i2 < 9; i2++)
                this.i.add(((Object) (new mm(((ee) (this)), gh1, i2 + (j1 + 1) * 9, 8 + i2 * 18, 103 + j1 * 18 + k))));

        }

        for(int k1 = 0; k1 < 9; k1++)
            this.i.add(((Object) (new mm(((ee) (this)), gh1, k1, 8 + k1 * 18, 161 + k))));

    }

    protected void j()
    {
        g.b(l.d(), 8, 6, 0x404040);
        g.b(j.d(), 8, (h - 96) + 2, 0x404040);
    }

    protected void a(float f)
    {
        int i = b.n.a("/gui/container.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        b.n.b(i);
        int k = (c - a) / 2;
        int i1 = (d - h) / 2;
        b(k, i1, 0, 0, a, m * 18 + 17);
        b(k, i1 + m * 18 + 17, 0, 126, a, 96);
    }

    private gh j;
    private gh l;
    private int m;
}
