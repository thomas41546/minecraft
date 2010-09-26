package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class de extends bh
{

    public de()
    {
        a = "";
        h = 0;
    }

    public void a()
    {
        Keyboard.enableRepeatEvents(true);
    }

    public void h()
    {
        Keyboard.enableRepeatEvents(false);
    }

    public void g()
    {
        h++;
    }

    protected void a(char c, int i)
    {
        if(i == 1)
        {
            b.a(((bh) (null)));
            return;
        }
        if(i == 28)
        {
            String s = a.trim();
            if(s.length() > 0)
                b.g.a(a.trim());
            b.a(((bh) (null)));
            return;
        }
        if(i == 14 && a.length() > 0)
            a = a.substring(0, a.length() - 1);
        if(" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~¦\307\374\351\342\344\340\345\347\352\353\350\357\356\354\304\305\311\346\306\364\366\362\373\371\377\326\334\370\243\330\327ƒ\341\355\363\372\361\321\252\272\277\256\254\275\274\241\253\273".indexOf(((int) (c))) < 0 || a.length() >= 100) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        a;
        append();
        c;
        append();
        toString();
        a;
_L2:
    }

    public void a(int i, int j, float f)
    {
        a(2, d - 14, c - 2, d - 2, 0x80000000);
        b(g, (new StringBuilder()).append("> ").append(a).append((h / 6) % 2 != 0 ? "" : "_").toString(), 4, d - 12, 0xe0e0e0);
    }

    protected void a(int i, int j, int k)
    {
        if(k != 0 || b.u.a == null)
            break MISSING_BLOCK_LABEL_129;
        if(a.length() <= 0 || a.endsWith(" ")) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        a;
        append();
        " ";
        append();
        toString();
        a;
_L2:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        a;
        append();
        b.u.a;
        append();
        toString();
        a;
        byte byte0 = 100;
        if(a.length() > byte0)
            a = a.substring(0, ((int) (byte0)));
    }

    private String a;
    private int h;
}
