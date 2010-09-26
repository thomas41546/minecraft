package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;

public class gc extends bh
{

    public gc(bh bh1)
    {
        h = 0;
        i = "";
        a = bh1;
    }

    public void g()
    {
        h++;
    }

    public void a()
    {
        e.clear();
        e.add(((Object) (new fk(0, c / 2 - 100, d / 4 + 96 + 12, "Connect"))));
        e.add(((Object) (new fk(1, c / 2 - 100, d / 4 + 120 + 12, "Cancel"))));
        ((fk)e.get(0)).g = false;
    }

    protected void a(fk fk1)
    {
        if(!fk1.g)
            return;
        if(fk1.f == 1)
            b.a(a);
        else
        if(fk1.f == 0)
        {
            String as[] = i.split(":");
            b.a(((bh) (new mn(b, as[0], as.length <= 1 ? 25565 : Integer.parseInt(as[1])))));
        }
    }

    protected void a(char c, int j)
    {
        if(c != '\026') goto _L2; else goto _L1
_L1:
        String s;
        int k;
        s = bh.c();
        if(s == null)
            s = "";
        k = 32 - i.length();
        if(k > s.length())
            k = s.length();
        if(k <= 0) goto _L2; else goto _L3
_L3:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        i;
        append();
        s.substring(0, k);
        append();
        toString();
        i;
_L2:
        if(c == '\r')
            a((fk)e.get(0));
        if(j == 14 && i.length() > 0)
            i = i.substring(0, i.length() - 1);
        if(" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~¦\307\374\351\342\344\340\345\347\352\353\350\357\356\354\304\305\311\346\306\364\366\362\373\371\377\326\334\370\243\330\327ƒ\341\355\363\372\361\321\252\272\277\256\254\275\274\241\253\273".indexOf(((int) (c))) < 0 || i.length() >= 32) goto _L5; else goto _L4
_L4:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        i;
        append();
        c;
        append();
        toString();
        i;
_L5:
        ((fk)e.get(0)).g = i.length() > 0;
        return;
    }

    public void a(int j, int k, float f)
    {
        i();
        a(g, "Play Multiplayer", this.c / 2, (d / 4 - 60) + 20, 0xffffff);
        b(g, "Minecraft Multiplayer is currently not finished, but there", this.c / 2 - 140, (d / 4 - 60) + 60 + 0, 0xa0a0a0);
        b(g, "is some buggy early testing going on.", this.c / 2 - 140, (d / 4 - 60) + 60 + 9, 0xa0a0a0);
        b(g, "Enter the IP of a server to connect to it:", this.c / 2 - 140, (d / 4 - 60) + 60 + 36, 0xa0a0a0);
        int l = this.c / 2 - 100;
        int i1 = (d / 4 - 10) + 50 + 18;
        char c = '\310';
        byte byte0 = 20;
        a(l - 1, i1 - 1, l + c + 1, i1 + byte0 + 1, 0xffa0a0a0);
        a(l, i1, l + c, i1 + byte0, 0xff000000);
        b(g, (new StringBuilder()).append(i).append((h / 6) % 2 != 0 ? "" : "_").toString(), l + 4, i1 + (byte0 - 8) / 2, 0xe0e0e0);
        super.a(j, k, f);
    }

    private bh a;
    private int h;
    private String i;
}
