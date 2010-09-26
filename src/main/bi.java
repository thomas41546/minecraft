package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.PrintStream;
import net.minecraft.client.Minecraft;

public class bi extends dm
{

    public bi(Minecraft minecraft, cn cn, dl dl1)
    {
        super(cn);
        bg = minecraft;
        if(dl1 != null && dl1.b != null && dl1.b.length() > 0)
        {
            aY = (new StringBuilder()).append("http://www.minecraft.net/skin/").append(dl1.b).append(".png").toString();
            System.out.println((new StringBuilder()).append("Loading texture ").append(aY).toString());
        }
        i = dl1.b;
    }

    public void b_()
    {
        super.b_();
        V = a.a;
        W = a.b;
        Y = a.d;
    }

    public void j()
    {
        a.a(((dm) (this)));
        if(a.e && aL < 0.2F)
            aL = 0.2F;
        super.j();
    }

    public void k()
    {
        a.a();
    }

    public void a(int i, boolean flag)
    {
        a.a(i, flag);
    }

    public void a(hm hm1)
    {
        super.a(hm1);
        hm1.a("Score", d);
    }

    public void b(hm hm1)
    {
        super.b(hm1);
        d = hm1.e("Score");
    }

    public void a(gh gh)
    {
        bg.a(((bh) (new ea(((gh) (b)), gh))));
    }

    public void a(ob ob)
    {
        bg.a(((bh) (new nv(ob))));
    }

    public void l()
    {
        bg.a(((bh) (new hx(b))));
    }

    public void a(ke ke)
    {
        bg.a(((bh) (new id(b, ke))));
    }

    public void a(kh kh1)
    {
        int i = b.a(kh1);
        if(i > 0)
        {
            kh1.a(((kh) (this)), i);
            ev ev1 = t();
            if(ev1 != null && (kh1 instanceof ge))
            {
                ev1.a((ge)kh1);
                if(ev1.a <= 0)
                {
                    ev1.a(((dm) (this)));
                    u();
                }
            }
        }
    }

    public void a_(kh kh1, int i)
    {
        bg.h.a(((nq) (new cd(bg.e, kh1, ((kh) (this)), -0.5F))));
    }

    public int m()
    {
        return b.f();
    }

    public void a_(kh kh1)
    {
        if(kh1.a(((dm) (this))))
            return;
        ev ev1 = t();
        if(ev1 != null && (kh1 instanceof ge))
        {
            ev1.b((ge)kh1);
            if(ev1.a <= 0)
            {
                ev1.a(((dm) (this)));
                u();
            }
        }
    }

    public void a(String s)
    {
    }

    public void n()
    {
    }

    public boolean o()
    {
        return a.e;
    }

    public lv a;
    private Minecraft bg;
}
