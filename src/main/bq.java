package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.*;
import org.lwjgl.opengl.GL11;

public class bq
{

    public bq(cn cn1, ey ey1)
    {
        b = new List[4];
        d = new Random();
        if(cn1 != null)
            a = cn1;
        c = ey1;
        for(int i = 0; i < 4; i++)
            b[i] = ((List) (new ArrayList()));

    }

    public void a(nq nq1)
    {
        int i = nq1.c();
        b[i].add(((Object) (nq1)));
    }

    public void a()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < b[i].size(); j++)
            {
                nq nq1 = (nq)b[i].get(j);
                nq1.e_();
                if(nq1.aA)
                    b[i].remove(j--);
            }

        }

    }

    public void a(kh kh1, float f)
    {
        float f1 = eo.b((kh1.aq * 3.141593F) / 180F);
        float f2 = eo.a((kh1.aq * 3.141593F) / 180F);
        float f3 = -f2 * eo.a((kh1.ar * 3.141593F) / 180F);
        float f4 = f1 * eo.a((kh1.ar * 3.141593F) / 180F);
        float f5 = eo.b((kh1.ar * 3.141593F) / 180F);
        nq.l = kh1.aI + (kh1.ak - kh1.aI) * (double)f;
        nq.m = kh1.aJ + (kh1.al - kh1.aJ) * (double)f;
        nq.n = kh1.aK + (kh1.am - kh1.aK) * (double)f;
        for(int i = 0; i < 3; i++)
        {
            if(b[i].size() == 0)
                continue;
            int j = 0;
            if(i == 0)
                j = c.a("/particles.png");
            if(i == 1)
                j = c.a("/terrain.png");
            if(i == 2)
                j = c.a("/gui/items.png");
            GL11.glBindTexture(3553, j);
            ho ho1 = ho.a;
            ho1.b();
            for(int k = 0; k < b[i].size(); k++)
            {
                nq nq1 = (nq)b[i].get(k);
                nq1.a(ho1, f, f1, f5, f2, f3, f4);
            }

            ho1.a();
        }

    }

    public void b(kh kh1, float f)
    {
        byte byte0 = 3;
        if(b[byte0].size() == 0)
            return;
        ho ho1 = ho.a;
        for(int i = 0; i < b[byte0].size(); i++)
        {
            nq nq1 = (nq)b[byte0].get(i);
            nq1.a(ho1, f, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        }

    }

    public void a(cn cn1)
    {
        a = cn1;
        for(int i = 0; i < 4; i++)
            b[i].clear();

    }

    public void a(int i, int j, int k)
    {
        int l = a.a(i, j, k);
        if(l == 0)
            return;
        ly ly1 = ly.n[l];
        int i1 = 4;
        for(int j1 = 0; j1 < i1; j1++)
        {
            for(int k1 = 0; k1 < i1; k1++)
            {
                for(int l1 = 0; l1 < i1; l1++)
                {
                    double d1 = (double)i + ((double)j1 + 0.5D) / (double)i1;
                    double d2 = (double)j + ((double)k1 + 0.5D) / (double)i1;
                    double d3 = (double)k + ((double)l1 + 0.5D) / (double)i1;
                    a(((nq) (new iw(a, d1, d2, d3, d1 - (double)i - 0.5D, d2 - (double)j - 0.5D, d3 - (double)k - 0.5D, ly1))));
                }

            }

        }

    }

    public void a(int i, int j, int k, int l)
    {
        int i1 = a.a(i, j, k);
        if(i1 == 0)
            return;
        ly ly1 = ly.n[i1];
        float f = 0.1F;
        double d1 = (double)i + d.nextDouble() * (ly1.bi - ly1.bf - (double)(f * 2.0F)) + (double)f + ly1.bf;
        double d2 = (double)j + d.nextDouble() * (ly1.bj - ly1.bg - (double)(f * 2.0F)) + (double)f + ly1.bg;
        double d3 = (double)k + d.nextDouble() * (ly1.bk - ly1.bh - (double)(f * 2.0F)) + (double)f + ly1.bh;
        if(l == 0)
            d2 = ((double)j + ly1.bg) - (double)f;
        if(l == 1)
            d2 = (double)j + ly1.bj + (double)f;
        if(l == 2)
            d3 = ((double)k + ly1.bh) - (double)f;
        if(l == 3)
            d3 = (double)k + ly1.bk + (double)f;
        if(l == 4)
            d1 = ((double)i + ly1.bf) - (double)f;
        if(l == 5)
            d1 = (double)i + ly1.bi + (double)f;
        a((new iw(a, d1, d2, d3, 0.0D, 0.0D, 0.0D, ly1)).b(0.2F).d(0.6F));
    }

    public String b()
    {
        return (new StringBuilder()).append("").append(b[0].size() + b[1].size() + b[2].size()).toString();
    }

    protected cn a;
    private List b[];
    private ey c;
    private Random d;
}
