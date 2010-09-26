package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;

public class il extends hq
{

    public il(Minecraft minecraft)
    {
        super(minecraft);
        b = true;
    }

    public void b(dm dm1)
    {
        for(int i = 0; i < 9; i++)
            if(dm1.b.a[i] == null)
                a.g.b.a[i] = new ev(((ly)dl.a.get(i)).bc);
            else
                a.g.b.a[i].a = 1;

    }

    public boolean d()
    {
        return false;
    }

    public void a(cn cn)
    {
        super.a(cn);
    }

    public void c()
    {
    }
}
