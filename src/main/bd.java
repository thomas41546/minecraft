package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.List;
import java.util.Random;

public class bd extends ic
{

    public bd()
    {
        a = -1;
        d = 0.0D;
        b = "Pig";
        a = 20;
    }

    public boolean a()
    {
        return e.a((double)f + 0.5D, (double)g + 0.5D, (double)h + 0.5D, 16D) != null;
    }

    public void b()
    {
        d = c;
        if(!a())
            return;
        double d1 = (float)f + e.n.nextFloat();
        double d3 = (float)g + e.n.nextFloat();
        double d5 = (float)h + e.n.nextFloat();
        e.a("smoke", d1, d3, d5, 0.0D, 0.0D, 0.0D);
        e.a("flame", d1, d3, d5, 0.0D, 0.0D, 0.0D);
        for(c += 1000F / ((float)a + 200F); c > 360D;)
        {
            c -= 360D;
            d -= 360D;
        }

        if(a == -1)
            c();
        if(a > 0)
        {
            a--;
            return;
        }
        byte byte0 = 4;
        for(int i = 0; i < byte0; i++)
        {
            ge ge1 = (ge)(ge)ew.a(b, e);
            if(ge1 == null)
                return;
            int j = e.a(((Object) (ge1)).getClass(), cf.b(f, g, h, f + 1, g + 1, h + 1).b(8D, 4D, 8D)).size();
            if(j >= 6)
            {
                c();
                return;
            }
            if(ge1 == null)
                continue;
            double d7 = (double)f + (e.n.nextDouble() - e.n.nextDouble()) * 4D;
            double d8 = (g + e.n.nextInt(3)) - 1;
            double d9 = (double)h + (e.n.nextDouble() - e.n.nextDouble()) * 4D;
            ge1.c(d7, d8, d9, e.n.nextFloat() * 360F, 0.0F);
            if(!ge1.a())
                continue;
            e.a(((kh) (ge1)));
            for(int k = 0; k < 20; k++)
            {
                double d2 = (double)f + 0.5D + ((double)e.n.nextFloat() - 0.5D) * 2D;
                double d4 = (double)g + 0.5D + ((double)e.n.nextFloat() - 0.5D) * 2D;
                double d6 = (double)h + 0.5D + ((double)e.n.nextFloat() - 0.5D) * 2D;
                e.a("smoke", d2, d4, d6, 0.0D, 0.0D, 0.0D);
                e.a("flame", d2, d4, d6, 0.0D, 0.0D, 0.0D);
            }

            ge1.z();
            c();
        }

        super.b();
    }

    private void c()
    {
        a = 200 + e.n.nextInt(600);
    }

    public void a(hm hm1)
    {
        super.a(hm1);
        b = hm1.i("EntityId");
        a = ((int) (hm1.d("Delay")));
    }

    public void b(hm hm1)
    {
        super.b(hm1);
        hm1.a("EntityId", b);
        hm1.a("Delay", (short)a);
    }

    public int a;
    public String b;
    public double c;
    public double d;
}
