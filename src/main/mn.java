package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;

public class mn extends bh
{

    public mn(Minecraft minecraft, String s, int i)
    {
        h = false;
        minecraft.a(((cn) (null)));
        (new nc(this, minecraft, s, i)).start();
    }

    public void g()
    {
        if(a != null)
            a.a();
    }

    protected void a(char c, int i)
    {
    }

    public void a()
    {
        e.clear();
        e.add(((Object) (new fk(0, c / 2 - 100, d / 4 + 120 + 12, "Cancel"))));
    }

    protected void a(fk fk1)
    {
        if(fk1.f == 0)
        {
            h = true;
            if(a != null)
                a.b();
            b.a(((bh) (new cx())));
        }
    }

    public void a(int i, int j, float f)
    {
        i();
        if(a == null)
        {
            a(g, "Connecting to the server...", c / 2, d / 2 - 50, 0xffffff);
            a(g, "", c / 2, d / 2 - 10, 0xffffff);
        } else
        {
            a(g, "Logging in...", c / 2, d / 2 - 50, 0xffffff);
            a(g, a.a, c / 2, d / 2 - 10, 0xffffff);
        }
        super.a(i, j, f);
    }

    static gy a(mn mn1, gy gy1)
    {
        return mn1.a = gy1;
    }

    static boolean a(mn mn1)
    {
        return mn1.h;
    }

    static gy b(mn mn1)
    {
        return mn1.a;
    }

    private gy a;
    private boolean h;
}
