package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class fu extends di
{

    public fu(int i, int j)
    {
        super(i);
        aT = 1;
        aU = 32 << j;
    }

    public boolean a(ev ev1, dm dm, cn cn1, int i, int j, int k, int l)
    {
        int i1 = cn1.a(i, j, k);
        gb gb1 = cn1.f(i, j + 1, k);
        if(!gb1.a() && i1 == ly.v.bc || i1 == ly.w.bc)
        {
            ly ly1 = ly.aB;
            cn1.a((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, ly1.bl.d(), (ly1.bl.b() + 1.0F) / 2.0F, ly1.bl.c() * 0.8F);
            cn1.d(i, j, k, ly1.bc);
            ev1.b(1);
            if(cn1.n.nextInt(8) == 0 && i1 == ly.v.bc)
            {
                int j1 = 1;
                for(int k1 = 0; k1 < j1; k1++)
                {
                    float f = 0.7F;
                    float f1 = cn1.n.nextFloat() * f + (1.0F - f) * 0.5F;
                    float f2 = 1.2F;
                    float f3 = cn1.n.nextFloat() * f + (1.0F - f) * 0.5F;
                    dx dx1 = new dx(cn1, (float)i + f1, (float)j + f2, (float)k + f3, new ev(di.Q));
                    dx1.c = 10;
                    cn1.a(((kh) (dx1)));
                }

            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean a()
    {
        return true;
    }
}
