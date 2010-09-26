package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;

public class ie extends bh
{

    public ie()
    {
        a = 0;
        h = 0;
    }

    public void a()
    {
        a = 0;
        e.clear();
        e.add(((Object) (new fk(1, c / 2 - 100, d / 4 + 48, "Save and quit to title"))));
        if(b.j())
            ((fk)e.get(0)).e = "Disconnect";
        e.add(((Object) (new fk(4, c / 2 - 100, d / 4 + 24, "Back to game"))));
        e.add(((Object) (new fk(0, c / 2 - 100, d / 4 + 96, "Options..."))));
    }

    protected void a(fk fk1)
    {
        if(fk1.f == 0)
            b.a(((bh) (new ay(((bh) (this)), b.y))));
        if(fk1.f == 1)
        {
            if(b.j())
                b.e.k();
            b.a(((cn) (null)));
            b.a(((bh) (new cx())));
        }
        if(fk1.f == 4)
        {
            b.a(((bh) (null)));
            b.e();
        }
    }

    public void g()
    {
        super.g();
        h++;
    }

    public void a(int i, int j, float f)
    {
        i();
        boolean flag = !b.e.a(a++);
        if(flag || h < 20)
        {
            float f1 = ((float)(h % 10) + f) / 10F;
            f1 = eo.a(f1 * 3.141593F * 2.0F) * 0.2F + 0.8F;
            int k = (int)(255F * f1);
            b(g, "Saving level..", 8, d - 16, k << 16 | k << 8 | k);
        }
        a(g, "Game menu", c / 2, 40, 0xffffff);
        super.a(i, j, f);
    }

    private int a;
    private int h;
}
