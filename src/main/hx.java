package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class hx extends ee
{

    public hx(eu eu)
    {
        j = new et();
        this.i.add(((Object) (new an(((ee) (this)), ((gh) (j.a)), j.b, 0, 124, 35))));
        for(int i = 0; i < 3; i++)
        {
            for(int i1 = 0; i1 < 3; i1++)
                this.i.add(((Object) (new mm(((ee) (this)), ((gh) (j.a)), i1 + i * 3, 30 + i1 * 18, 17 + i * 18))));

        }

        for(int k = 0; k < 3; k++)
        {
            for(int j1 = 0; j1 < 9; j1++)
                this.i.add(((Object) (new mm(((ee) (this)), ((gh) (eu)), j1 + (k + 1) * 9, 8 + j1 * 18, 84 + k * 18))));

        }

        for(int l = 0; l < 9; l++)
            this.i.add(((Object) (new mm(((ee) (this)), ((gh) (eu)), l, 8 + l * 18, 142))));

    }

    public void h()
    {
        super.h();
        j.a(((dm) (b.g)));
    }

    protected void j()
    {
        g.b("Crafting", 28, 6, 0x404040);
        g.b("Inventory", 8, (h - 96) + 2, 0x404040);
    }

    protected void a(float f)
    {
        int i = b.n.a("/gui/crafting.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        b.n.b(i);
        int k = (c - a) / 2;
        int l = (d - h) / 2;
        b(k, l, 0, 0, a, h);
    }

    public et j;
}
