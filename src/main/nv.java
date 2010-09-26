package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class nv extends bh
{

    public nv(ob ob1)
    {
        a = "Edit sign message:";
        j = 0;
        h = ob1;
    }

    public void a()
    {
        e.clear();
        Keyboard.enableRepeatEvents(true);
        e.add(((Object) (new fk(0, c / 2 - 100, d / 4 + 120, "Done"))));
    }

    public void h()
    {
        Keyboard.enableRepeatEvents(false);
    }

    public void g()
    {
        i++;
    }

    protected void a(fk fk1)
    {
        if(!fk1.g)
            return;
        if(fk1.f == 0)
        {
            h.j_();
            b.a(((bh) (null)));
        }
    }

    protected void a(char c, int k)
    {
        if(k == 200)
            j = j - 1 & 3;
        if(k == 208 || k == 28)
            j = j + 1 & 3;
        if(k == 14 && h.a[j].length() > 0)
            h.a[j] = h.a[j].substring(0, h.a[j].length() - 1);
        if(" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~¦\307\374\351\342\344\340\345\347\352\353\350\357\356\354\304\305\311\346\306\364\366\362\373\371\377\326\334\370\243\330\327ƒ\341\355\363\372\361\321\252\272\277\256\254\275\274\241\253\273".indexOf(((int) (c))) < 0 || h.a[j].length() >= 15) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        h.a;
        j;
        JVM INSTR dup2_x1 ;
        JVM INSTR aaload ;
        append();
        c;
        append();
        toString();
        JVM INSTR aastore ;
_L2:
    }

    public void a(int k, int l, float f)
    {
        i();
        a(g, a, c / 2, 40, 0xffffff);
        GL11.glPushMatrix();
        GL11.glTranslatef(c / 2, d / 2, 50F);
        float f1 = 93.75F;
        GL11.glScalef(-f1, -f1, -f1);
        GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
        ly ly1 = h.g();
        if(ly1 == ly.aE)
        {
            float f2 = (float)(h.f() * 360) / 16F;
            GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
        } else
        {
            int i1 = h.f();
            float f3 = 0.0F;
            if(i1 == 2)
                f3 = 180F;
            if(i1 == 4)
                f3 = 90F;
            if(i1 == 5)
                f3 = -90F;
            GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, 0.3125F, 0.0F);
        }
        if((i / 6) % 2 == 0)
            h.b = j;
        fz.a.a(((ic) (h)), -0.5D, -0.75D, -0.5D, 0.0F);
        h.b = -1;
        GL11.glPopMatrix();
        super.a(k, l, f);
    }

    protected String a;
    private ob h;
    private int i;
    private int j;
}
