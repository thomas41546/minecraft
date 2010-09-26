package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class lo extends ee
{

    public lo(gh gh1, ev aev[])
    {
        f = true;
        j = new n(aev);
        i.add(((Object) (new an(((ee) (this)), ((gh) (j.a)), j.b, 0, 144, 36))));
        for(int k = 0; k < 2; k++)
        {
            for(int l1 = 0; l1 < 2; l1++)
                i.add(((Object) (new mm(((ee) (this)), ((gh) (j.a)), l1 + k * 2, 88 + l1 * 18, 26 + k * 18))));

        }

        for(int i1 = 0; i1 < 4; i1++)
        {
            int i2 = i1;
            i.add(((Object) (new lj(this, ((ee) (this)), gh1, gh1.c() - 1 - i1, 8, 8 + i1 * 18, i2))));
        }

        for(int j1 = 0; j1 < 3; j1++)
        {
            for(int j2 = 0; j2 < 9; j2++)
                i.add(((Object) (new mm(((ee) (this)), gh1, j2 + (j1 + 1) * 9, 8 + j2 * 18, 84 + j1 * 18))));

        }

        for(int k1 = 0; k1 < 9; k1++)
            i.add(((Object) (new mm(((ee) (this)), gh1, k1, 8 + k1 * 18, 142))));

    }

    protected void j()
    {
        g.b("Crafting", 86, 16, 0x404040);
    }

    public void a(int k, int i1, float f)
    {
        super.a(k, i1, f);
        l = k;
        m = i1;
    }

    protected void a(float f)
    {
        int k = b.n.a("/gui/inventory.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        b.n.b(k);
        int i1 = (c - a) / 2;
        int j1 = (d - h) / 2;
        b(i1, j1, 0, 0, a, h);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(i1 + 51, j1 + 75, 50F);
        float f1 = 30F;
        GL11.glScalef(-f1, f1, f1);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        float f2 = b.g.n;
        float f3 = b.g.aq;
        float f4 = b.g.ar;
        float f5 = (float)(i1 + 51) - l;
        float f6 = (float)((j1 + 75) - 50) - m;
        GL11.glRotatef(135F, 0.0F, 1.0F, 0.0F);
        i.b();
        GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-(float)Math.atan(f6 / 40F) * 20F, 1.0F, 0.0F, 0.0F);
        b.g.n = (float)Math.atan(f5 / 40F) * 20F;
        b.g.aq = (float)Math.atan(f5 / 40F) * 40F;
        b.g.ar = -(float)Math.atan(f6 / 40F) * 20F;
        GL11.glTranslatef(0.0F, b.g.aB, 0.0F);
        kx.a.a(((kh) (b.g)), 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        b.g.n = f2;
        b.g.aq = f3;
        b.g.ar = f4;
        GL11.glPopMatrix();
        i.a();
        GL11.glDisable(32826);
    }

    private n j;
    private float l;
    private float m;
}
