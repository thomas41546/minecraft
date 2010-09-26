package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;

public class jq extends bh
{

    public jq(bh bh1)
    {
        h = "Select world";
        i = false;
        a = bh1;
    }

    public void a()
    {
        java.io.File file = Minecraft.b();
        for(int k = 0; k < 5; k++)
        {
            hm hm1 = cn.a(file, (new StringBuilder()).append("World").append(k + 1).toString());
            if(hm1 == null)
            {
                e.add(((Object) (new fk(k, c / 2 - 100, d / 6 + 24 * k, "- empty -"))));
            } else
            {
                String s = (new StringBuilder()).append("World ").append(k + 1).toString();
                long l = hm1.f("SizeOnDisk");
                s = (new StringBuilder()).append(s).append(" (").append((float)(((l / 1024L) * 100L) / 1024L) / 100F).append(" MB)").toString();
                e.add(((Object) (new fk(k, c / 2 - 100, d / 6 + 24 * k, s))));
            }
        }

        j();
    }

    protected String d(int k)
    {
        java.io.File file = Minecraft.b();
        return cn.a(file, (new StringBuilder()).append("World").append(k).toString()) == null ? null : (new StringBuilder()).append("World").append(k).toString();
    }

    public void j()
    {
        e.add(((Object) (new fk(5, c / 2 - 100, d / 6 + 120 + 12, "Delete world..."))));
        e.add(((Object) (new fk(6, c / 2 - 100, d / 6 + 168, "Cancel"))));
    }

    protected void a(fk fk1)
    {
        if(!fk1.g)
            return;
        if(fk1.f < 5)
            c(fk1.f + 1);
        else
        if(fk1.f == 5)
            b.a(((bh) (new ib(((bh) (this))))));
        else
        if(fk1.f == 6)
            b.a(a);
    }

    public void c(int k)
    {
        b.a(((bh) (null)));
        if(i)
        {
            return;
        } else
        {
            i = true;
            b.b = ((hq) (new ia(b)));
            b.b((new StringBuilder()).append("World").append(k).toString());
            b.a(((bh) (null)));
            return;
        }
    }

    public void a(int k, int l, float f)
    {
        i();
        a(g, h, c / 2, 20, 0xffffff);
        super.a(k, l, f);
    }

    protected bh a;
    protected String h;
    private boolean i;
}
