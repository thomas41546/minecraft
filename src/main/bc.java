package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.GL11;

public class bc
{

    public bc(nm nm1)
    {
        b = -1;
        c = false;
        d = false;
        a = nm1;
    }

    public bc()
    {
        b = -1;
        c = false;
        d = false;
    }

    public void a(ly ly1, int i1, int j1, int k1, int l1)
    {
        b = l1;
        a(ly1, i1, j1, k1);
        b = -1;
    }

    public boolean a(ly ly1, int i1, int j1, int k1)
    {
        int l1 = ly1.f();
        ly1.a(a, i1, j1, k1);
        if(l1 == 0)
            return k(ly1, i1, j1, k1);
        if(l1 == 4)
            return j(ly1, i1, j1, k1);
        if(l1 == 13)
            return l(ly1, i1, j1, k1);
        if(l1 == 1)
            return h(ly1, i1, j1, k1);
        if(l1 == 6)
            return i(ly1, i1, j1, k1);
        if(l1 == 2)
            return b(ly1, i1, j1, k1);
        if(l1 == 3)
            return d(ly1, i1, j1, k1);
        if(l1 == 5)
            return e(ly1, i1, j1, k1);
        if(l1 == 8)
            return g(ly1, i1, j1, k1);
        if(l1 == 7)
            return o(ly1, i1, j1, k1);
        if(l1 == 9)
            return f(ly1, i1, j1, k1);
        if(l1 == 10)
            return n(ly1, i1, j1, k1);
        if(l1 == 11)
            return m(ly1, i1, j1, k1);
        if(l1 == 12)
            return c(ly1, i1, j1, k1);
        else
            return false;
    }

    public boolean b(ly ly1, int i1, int j1, int k1)
    {
        int l1 = a.e(i1, j1, k1);
        ho ho1 = ho.a;
        float f1 = ly1.c(a, i1, j1, k1);
        if(ly.t[ly1.bc] > 0)
            f1 = 1.0F;
        ho1.a(f1, f1, f1);
        double d1 = 0.40000000596046448D;
        double d2 = 0.5D - d1;
        double d3 = 0.20000000298023224D;
        if(l1 == 1)
            a(ly1, (double)i1 - d2, (double)j1 + d3, k1, -d1, 0.0D);
        else
        if(l1 == 2)
            a(ly1, (double)i1 + d2, (double)j1 + d3, k1, d1, 0.0D);
        else
        if(l1 == 3)
            a(ly1, i1, (double)j1 + d3, (double)k1 - d2, 0.0D, -d1);
        else
        if(l1 == 4)
            a(ly1, i1, (double)j1 + d3, (double)k1 + d2, 0.0D, d1);
        else
            a(ly1, i1, j1, k1, 0.0D, 0.0D);
        return true;
    }

    public boolean c(ly ly1, int i1, int j1, int k1)
    {
        int l1 = a.e(i1, j1, k1);
        int i2 = l1 & 7;
        boolean flag = (l1 & 8) > 0;
        ho ho1 = ho.a;
        boolean flag1 = b >= 0;
        if(!flag1)
            b = ly.x.bb;
        float f1 = 0.25F;
        float f2 = 0.1875F;
        float f3 = 0.1875F;
        if(i2 == 5)
            ly1.a(0.5F - f2, 0.0F, 0.5F - f1, 0.5F + f2, f3, 0.5F + f1);
        else
        if(i2 == 6)
            ly1.a(0.5F - f1, 0.0F, 0.5F - f2, 0.5F + f1, f3, 0.5F + f2);
        else
        if(i2 == 4)
            ly1.a(0.5F - f2, 0.5F - f1, 1.0F - f3, 0.5F + f2, 0.5F + f1, 1.0F);
        else
        if(i2 == 3)
            ly1.a(0.5F - f2, 0.5F - f1, 0.0F, 0.5F + f2, 0.5F + f1, f3);
        else
        if(i2 == 2)
            ly1.a(1.0F - f3, 0.5F - f1, 0.5F - f2, 1.0F, 0.5F + f1, 0.5F + f2);
        else
        if(i2 == 1)
            ly1.a(0.0F, 0.5F - f1, 0.5F - f2, f3, 0.5F + f1, 0.5F + f2);
        k(ly1, i1, j1, k1);
        if(!flag1)
            b = -1;
        float f4 = ly1.c(a, i1, j1, k1);
        if(ly.t[ly1.bc] > 0)
            f4 = 1.0F;
        ho1.a(f4, f4, f4);
        int j2 = ly1.a(0);
        if(b >= 0)
            j2 = b;
        int k2 = (j2 & 0xf) << 4;
        int l2 = j2 & 0xf0;
        float f5 = (float)k2 / 256F;
        float f6 = ((float)k2 + 15.99F) / 256F;
        float f7 = (float)l2 / 256F;
        float f8 = ((float)l2 + 15.99F) / 256F;
        aj aaj[] = new aj[8];
        float f9 = 0.0625F;
        float f10 = 0.0625F;
        float f11 = 0.625F;
        aaj[0] = aj.b(-f9, 0.0D, -f10);
        aaj[1] = aj.b(f9, 0.0D, -f10);
        aaj[2] = aj.b(f9, 0.0D, f10);
        aaj[3] = aj.b(-f9, 0.0D, f10);
        aaj[4] = aj.b(-f9, f11, -f10);
        aaj[5] = aj.b(f9, f11, -f10);
        aaj[6] = aj.b(f9, f11, f10);
        aaj[7] = aj.b(-f9, f11, f10);
        for(int i3 = 0; i3 < 8; i3++)
        {
            if(flag)
            {
                aaj[i3].c -= 0.0625D;
                aaj[i3].a(0.6981317F);
            } else
            {
                aaj[i3].c += 0.0625D;
                aaj[i3].a(-0.6981317F);
            }
            if(i2 == 6)
                aaj[i3].b(1.570796F);
            if(i2 < 5)
            {
                aaj[i3].b -= 0.375D;
                aaj[i3].a(1.570796F);
                if(i2 == 4)
                    aaj[i3].b(0.0F);
                if(i2 == 3)
                    aaj[i3].b(3.141593F);
                if(i2 == 2)
                    aaj[i3].b(1.570796F);
                if(i2 == 1)
                    aaj[i3].b(-1.570796F);
                aaj[i3].a += (double)i1 + 0.5D;
                aaj[i3].b += (float)j1 + 0.5F;
                aaj[i3].c += (double)k1 + 0.5D;
            } else
            {
                aaj[i3].a += (double)i1 + 0.5D;
                aaj[i3].b += (float)j1 + 0.125F;
                aaj[i3].c += (double)k1 + 0.5D;
            }
        }

        aj aj1 = null;
        aj aj2 = null;
        aj aj3 = null;
        aj aj4 = null;
        for(int j3 = 0; j3 < 6; j3++)
        {
            if(j3 == 0)
            {
                f5 = (float)(k2 + 7) / 256F;
                f6 = ((float)(k2 + 9) - 0.01F) / 256F;
                f7 = (float)(l2 + 6) / 256F;
                f8 = ((float)(l2 + 8) - 0.01F) / 256F;
            } else
            if(j3 == 2)
            {
                f5 = (float)(k2 + 7) / 256F;
                f6 = ((float)(k2 + 9) - 0.01F) / 256F;
                f7 = (float)(l2 + 6) / 256F;
                f8 = ((float)(l2 + 16) - 0.01F) / 256F;
            }
            if(j3 == 0)
            {
                aj1 = aaj[0];
                aj2 = aaj[1];
                aj3 = aaj[2];
                aj4 = aaj[3];
            } else
            if(j3 == 1)
            {
                aj1 = aaj[7];
                aj2 = aaj[6];
                aj3 = aaj[5];
                aj4 = aaj[4];
            } else
            if(j3 == 2)
            {
                aj1 = aaj[1];
                aj2 = aaj[0];
                aj3 = aaj[4];
                aj4 = aaj[5];
            } else
            if(j3 == 3)
            {
                aj1 = aaj[2];
                aj2 = aaj[1];
                aj3 = aaj[5];
                aj4 = aaj[6];
            } else
            if(j3 == 4)
            {
                aj1 = aaj[3];
                aj2 = aaj[2];
                aj3 = aaj[6];
                aj4 = aaj[7];
            } else
            if(j3 == 5)
            {
                aj1 = aaj[0];
                aj2 = aaj[3];
                aj3 = aaj[7];
                aj4 = aaj[4];
            }
            ho1.a(aj1.a, aj1.b, aj1.c, f5, f8);
            ho1.a(aj2.a, aj2.b, aj2.c, f6, f8);
            ho1.a(aj3.a, aj3.b, aj3.c, f6, f7);
            ho1.a(aj4.a, aj4.b, aj4.c, f5, f7);
        }

        return true;
    }

    public boolean d(ly ly1, int i1, int j1, int k1)
    {
        ho ho1 = ho.a;
        int l1 = ly1.a(0);
        if(b >= 0)
            l1 = b;
        float f1 = ly1.c(a, i1, j1, k1);
        ho1.a(f1, f1, f1);
        int i2 = (l1 & 0xf) << 4;
        int j2 = l1 & 0xf0;
        double d1 = (float)i2 / 256F;
        double d3 = ((float)i2 + 15.99F) / 256F;
        double d5 = (float)j2 / 256F;
        double d7 = ((float)j2 + 15.99F) / 256F;
        float f2 = 1.4F;
        if(a.g(i1, j1 - 1, k1) || ly.as.b(a, i1, j1 - 1, k1))
        {
            double d9 = (double)i1 + 0.5D + 0.20000000000000001D;
            double d10 = ((double)i1 + 0.5D) - 0.20000000000000001D;
            double d13 = (double)k1 + 0.5D + 0.20000000000000001D;
            double d15 = ((double)k1 + 0.5D) - 0.20000000000000001D;
            double d17 = ((double)i1 + 0.5D) - 0.29999999999999999D;
            double d19 = (double)i1 + 0.5D + 0.29999999999999999D;
            double d21 = ((double)k1 + 0.5D) - 0.29999999999999999D;
            double d23 = (double)k1 + 0.5D + 0.29999999999999999D;
            ho1.a(d17, (float)j1 + f2, k1 + 1, d3, d5);
            ho1.a(d9, j1 + 0, k1 + 1, d3, d7);
            ho1.a(d9, j1 + 0, k1 + 0, d1, d7);
            ho1.a(d17, (float)j1 + f2, k1 + 0, d1, d5);
            ho1.a(d19, (float)j1 + f2, k1 + 0, d3, d5);
            ho1.a(d10, j1 + 0, k1 + 0, d3, d7);
            ho1.a(d10, j1 + 0, k1 + 1, d1, d7);
            ho1.a(d19, (float)j1 + f2, k1 + 1, d1, d5);
            d1 = (float)i2 / 256F;
            d3 = ((float)i2 + 15.99F) / 256F;
            d5 = (float)(j2 + 16) / 256F;
            d7 = ((float)j2 + 15.99F + 16F) / 256F;
            ho1.a(i1 + 1, (float)j1 + f2, d23, d3, d5);
            ho1.a(i1 + 1, j1 + 0, d15, d3, d7);
            ho1.a(i1 + 0, j1 + 0, d15, d1, d7);
            ho1.a(i1 + 0, (float)j1 + f2, d23, d1, d5);
            ho1.a(i1 + 0, (float)j1 + f2, d21, d3, d5);
            ho1.a(i1 + 0, j1 + 0, d13, d3, d7);
            ho1.a(i1 + 1, j1 + 0, d13, d1, d7);
            ho1.a(i1 + 1, (float)j1 + f2, d21, d1, d5);
            d9 = ((double)i1 + 0.5D) - 0.5D;
            d10 = (double)i1 + 0.5D + 0.5D;
            d13 = ((double)k1 + 0.5D) - 0.5D;
            d15 = (double)k1 + 0.5D + 0.5D;
            d17 = ((double)i1 + 0.5D) - 0.40000000000000002D;
            d19 = (double)i1 + 0.5D + 0.40000000000000002D;
            d21 = ((double)k1 + 0.5D) - 0.40000000000000002D;
            d23 = (double)k1 + 0.5D + 0.40000000000000002D;
            ho1.a(d17, (float)j1 + f2, k1 + 0, d1, d5);
            ho1.a(d9, j1 + 0, k1 + 0, d1, d7);
            ho1.a(d9, j1 + 0, k1 + 1, d3, d7);
            ho1.a(d17, (float)j1 + f2, k1 + 1, d3, d5);
            ho1.a(d19, (float)j1 + f2, k1 + 1, d1, d5);
            ho1.a(d10, j1 + 0, k1 + 1, d1, d7);
            ho1.a(d10, j1 + 0, k1 + 0, d3, d7);
            ho1.a(d19, (float)j1 + f2, k1 + 0, d3, d5);
            d1 = (float)i2 / 256F;
            d3 = ((float)i2 + 15.99F) / 256F;
            d5 = (float)j2 / 256F;
            d7 = ((float)j2 + 15.99F) / 256F;
            ho1.a(i1 + 0, (float)j1 + f2, d23, d1, d5);
            ho1.a(i1 + 0, j1 + 0, d15, d1, d7);
            ho1.a(i1 + 1, j1 + 0, d15, d3, d7);
            ho1.a(i1 + 1, (float)j1 + f2, d23, d3, d5);
            ho1.a(i1 + 1, (float)j1 + f2, d21, d1, d5);
            ho1.a(i1 + 1, j1 + 0, d13, d1, d7);
            ho1.a(i1 + 0, j1 + 0, d13, d3, d7);
            ho1.a(i1 + 0, (float)j1 + f2, d21, d3, d5);
        } else
        {
            float f4 = 0.2F;
            float f5 = 0.0625F;
            if((i1 + j1 + k1 & 1) == 1)
            {
                d1 = (float)i2 / 256F;
                d3 = ((float)i2 + 15.99F) / 256F;
                d5 = (float)(j2 + 16) / 256F;
                d7 = ((float)j2 + 15.99F + 16F) / 256F;
            }
            if((i1 / 2 + j1 / 2 + k1 / 2 & 1) == 1)
            {
                double d11 = d3;
                d3 = d1;
                d1 = d11;
            }
            if(ly.as.b(a, i1 - 1, j1, k1))
            {
                ho1.a((float)i1 + f4, (float)j1 + f2 + f5, k1 + 1, d3, d5);
                ho1.a(i1 + 0, (float)(j1 + 0) + f5, k1 + 1, d3, d7);
                ho1.a(i1 + 0, (float)(j1 + 0) + f5, k1 + 0, d1, d7);
                ho1.a((float)i1 + f4, (float)j1 + f2 + f5, k1 + 0, d1, d5);
                ho1.a((float)i1 + f4, (float)j1 + f2 + f5, k1 + 0, d1, d5);
                ho1.a(i1 + 0, (float)(j1 + 0) + f5, k1 + 0, d1, d7);
                ho1.a(i1 + 0, (float)(j1 + 0) + f5, k1 + 1, d3, d7);
                ho1.a((float)i1 + f4, (float)j1 + f2 + f5, k1 + 1, d3, d5);
            }
            if(ly.as.b(a, i1 + 1, j1, k1))
            {
                ho1.a((float)(i1 + 1) - f4, (float)j1 + f2 + f5, k1 + 0, d1, d5);
                ho1.a((i1 + 1) - 0, (float)(j1 + 0) + f5, k1 + 0, d1, d7);
                ho1.a((i1 + 1) - 0, (float)(j1 + 0) + f5, k1 + 1, d3, d7);
                ho1.a((float)(i1 + 1) - f4, (float)j1 + f2 + f5, k1 + 1, d3, d5);
                ho1.a((float)(i1 + 1) - f4, (float)j1 + f2 + f5, k1 + 1, d3, d5);
                ho1.a((i1 + 1) - 0, (float)(j1 + 0) + f5, k1 + 1, d3, d7);
                ho1.a((i1 + 1) - 0, (float)(j1 + 0) + f5, k1 + 0, d1, d7);
                ho1.a((float)(i1 + 1) - f4, (float)j1 + f2 + f5, k1 + 0, d1, d5);
            }
            if(ly.as.b(a, i1, j1, k1 - 1))
            {
                ho1.a(i1 + 0, (float)j1 + f2 + f5, (float)k1 + f4, d3, d5);
                ho1.a(i1 + 0, (float)(j1 + 0) + f5, k1 + 0, d3, d7);
                ho1.a(i1 + 1, (float)(j1 + 0) + f5, k1 + 0, d1, d7);
                ho1.a(i1 + 1, (float)j1 + f2 + f5, (float)k1 + f4, d1, d5);
                ho1.a(i1 + 1, (float)j1 + f2 + f5, (float)k1 + f4, d1, d5);
                ho1.a(i1 + 1, (float)(j1 + 0) + f5, k1 + 0, d1, d7);
                ho1.a(i1 + 0, (float)(j1 + 0) + f5, k1 + 0, d3, d7);
                ho1.a(i1 + 0, (float)j1 + f2 + f5, (float)k1 + f4, d3, d5);
            }
            if(ly.as.b(a, i1, j1, k1 + 1))
            {
                ho1.a(i1 + 1, (float)j1 + f2 + f5, (float)(k1 + 1) - f4, d1, d5);
                ho1.a(i1 + 1, (float)(j1 + 0) + f5, (k1 + 1) - 0, d1, d7);
                ho1.a(i1 + 0, (float)(j1 + 0) + f5, (k1 + 1) - 0, d3, d7);
                ho1.a(i1 + 0, (float)j1 + f2 + f5, (float)(k1 + 1) - f4, d3, d5);
                ho1.a(i1 + 0, (float)j1 + f2 + f5, (float)(k1 + 1) - f4, d3, d5);
                ho1.a(i1 + 0, (float)(j1 + 0) + f5, (k1 + 1) - 0, d3, d7);
                ho1.a(i1 + 1, (float)(j1 + 0) + f5, (k1 + 1) - 0, d1, d7);
                ho1.a(i1 + 1, (float)j1 + f2 + f5, (float)(k1 + 1) - f4, d1, d5);
            }
            if(ly.as.b(a, i1, j1 + 1, k1))
            {
                double d12 = (double)i1 + 0.5D + 0.5D;
                double d14 = ((double)i1 + 0.5D) - 0.5D;
                double d16 = (double)k1 + 0.5D + 0.5D;
                double d18 = ((double)k1 + 0.5D) - 0.5D;
                double d20 = ((double)i1 + 0.5D) - 0.5D;
                double d22 = (double)i1 + 0.5D + 0.5D;
                double d24 = ((double)k1 + 0.5D) - 0.5D;
                double d25 = (double)k1 + 0.5D + 0.5D;
                double d2 = (float)i2 / 256F;
                double d4 = ((float)i2 + 15.99F) / 256F;
                double d6 = (float)j2 / 256F;
                double d8 = ((float)j2 + 15.99F) / 256F;
                j1++;
                float f3 = -0.2F;
                if((i1 + j1 + k1 & 1) == 0)
                {
                    ho1.a(d20, (float)j1 + f3, k1 + 0, d4, d6);
                    ho1.a(d12, j1 + 0, k1 + 0, d4, d8);
                    ho1.a(d12, j1 + 0, k1 + 1, d2, d8);
                    ho1.a(d20, (float)j1 + f3, k1 + 1, d2, d6);
                    d2 = (float)i2 / 256F;
                    d4 = ((float)i2 + 15.99F) / 256F;
                    d6 = (float)(j2 + 16) / 256F;
                    d8 = ((float)j2 + 15.99F + 16F) / 256F;
                    ho1.a(d22, (float)j1 + f3, k1 + 1, d4, d6);
                    ho1.a(d14, j1 + 0, k1 + 1, d4, d8);
                    ho1.a(d14, j1 + 0, k1 + 0, d2, d8);
                    ho1.a(d22, (float)j1 + f3, k1 + 0, d2, d6);
                } else
                {
                    ho1.a(i1 + 0, (float)j1 + f3, d25, d4, d6);
                    ho1.a(i1 + 0, j1 + 0, d18, d4, d8);
                    ho1.a(i1 + 1, j1 + 0, d18, d2, d8);
                    ho1.a(i1 + 1, (float)j1 + f3, d25, d2, d6);
                    d2 = (float)i2 / 256F;
                    d4 = ((float)i2 + 15.99F) / 256F;
                    d6 = (float)(j2 + 16) / 256F;
                    d8 = ((float)j2 + 15.99F + 16F) / 256F;
                    ho1.a(i1 + 1, (float)j1 + f3, d24, d4, d6);
                    ho1.a(i1 + 1, j1 + 0, d16, d4, d8);
                    ho1.a(i1 + 0, j1 + 0, d16, d2, d8);
                    ho1.a(i1 + 0, (float)j1 + f3, d24, d2, d6);
                }
            }
        }
        return true;
    }

    public boolean e(ly ly1, int i1, int j1, int k1)
    {
        ho ho1 = ho.a;
        int l1 = ly1.a(1, a.e(i1, j1, k1));
        if(b >= 0)
            l1 = b;
        float f1 = ly1.c(a, i1, j1, k1);
        ho1.a(f1, f1, f1);
        int i2 = (l1 & 0xf) << 4;
        int j2 = l1 & 0xf0;
        double d1 = (float)i2 / 256F;
        double d2 = ((float)i2 + 15.99F) / 256F;
        double d3 = (float)j2 / 256F;
        double d4 = ((float)j2 + 15.99F) / 256F;
        float f2 = 0.0F;
        float f3 = 0.03125F;
        boolean flag = kf.b(a, i1 - 1, j1, k1) || !a.g(i1 - 1, j1, k1) && kf.b(a, i1 - 1, j1 - 1, k1);
        boolean flag1 = kf.b(a, i1 + 1, j1, k1) || !a.g(i1 + 1, j1, k1) && kf.b(a, i1 + 1, j1 - 1, k1);
        boolean flag2 = kf.b(a, i1, j1, k1 - 1) || !a.g(i1, j1, k1 - 1) && kf.b(a, i1, j1 - 1, k1 - 1);
        boolean flag3 = kf.b(a, i1, j1, k1 + 1) || !a.g(i1, j1, k1 + 1) && kf.b(a, i1, j1 - 1, k1 + 1);
        if(!a.g(i1, j1 + 1, k1))
        {
            if(a.g(i1 - 1, j1, k1) && kf.b(a, i1 - 1, j1 + 1, k1))
                flag = true;
            if(a.g(i1 + 1, j1, k1) && kf.b(a, i1 + 1, j1 + 1, k1))
                flag1 = true;
            if(a.g(i1, j1, k1 - 1) && kf.b(a, i1, j1 + 1, k1 - 1))
                flag2 = true;
            if(a.g(i1, j1, k1 + 1) && kf.b(a, i1, j1 + 1, k1 + 1))
                flag3 = true;
        }
        float f4 = 0.3125F;
        float f5 = i1 + 0;
        float f6 = i1 + 1;
        float f7 = k1 + 0;
        float f8 = k1 + 1;
        byte byte0 = 0;
        if((flag || flag1) && !flag2 && !flag3)
            byte0 = 1;
        if((flag2 || flag3) && !flag1 && !flag)
            byte0 = 2;
        if(byte0 != 0)
        {
            d1 = (float)(i2 + 16) / 256F;
            d2 = ((float)(i2 + 16) + 15.99F) / 256F;
            d3 = (float)j2 / 256F;
            d4 = ((float)j2 + 15.99F) / 256F;
        }
        if(byte0 == 0)
        {
            if(flag1 || flag2 || flag3 || flag)
            {
                if(!flag)
                    f5 += f4;
                if(!flag)
                    d1 += f4 / 16F;
                if(!flag1)
                    f6 -= f4;
                if(!flag1)
                    d2 -= f4 / 16F;
                if(!flag2)
                    f7 += f4;
                if(!flag2)
                    d3 += f4 / 16F;
                if(!flag3)
                    f8 -= f4;
                if(!flag3)
                    d4 -= f4 / 16F;
            }
            ho1.a(f6 + f2, (float)j1 + f3, f8 + f2, d2, d4);
            ho1.a(f6 + f2, (float)j1 + f3, f7 - f2, d2, d3);
            ho1.a(f5 - f2, (float)j1 + f3, f7 - f2, d1, d3);
            ho1.a(f5 - f2, (float)j1 + f3, f8 + f2, d1, d4);
        }
        if(byte0 == 1)
        {
            ho1.a(f6 + f2, (float)j1 + f3, f8 + f2, d2, d4);
            ho1.a(f6 + f2, (float)j1 + f3, f7 - f2, d2, d3);
            ho1.a(f5 - f2, (float)j1 + f3, f7 - f2, d1, d3);
            ho1.a(f5 - f2, (float)j1 + f3, f8 + f2, d1, d4);
        }
        if(byte0 == 2)
        {
            ho1.a(f6 + f2, (float)j1 + f3, f8 + f2, d2, d4);
            ho1.a(f6 + f2, (float)j1 + f3, f7 - f2, d1, d4);
            ho1.a(f5 - f2, (float)j1 + f3, f7 - f2, d1, d3);
            ho1.a(f5 - f2, (float)j1 + f3, f8 + f2, d2, d3);
        }
        d1 = (float)(i2 + 16) / 256F;
        d2 = ((float)(i2 + 16) + 15.99F) / 256F;
        d3 = (float)j2 / 256F;
        d4 = ((float)j2 + 15.99F) / 256F;
        if(!a.g(i1, j1 + 1, k1))
        {
            if(a.g(i1 - 1, j1, k1) && a.a(i1 - 1, j1 + 1, k1) == ly.aw.bc)
            {
                ho1.a((float)i1 + f3, (float)(j1 + 1) + f2, (float)(k1 + 1) + f2, d2, d3);
                ho1.a((float)i1 + f3, (float)(j1 + 0) - f2, (float)(k1 + 1) + f2, d1, d3);
                ho1.a((float)i1 + f3, (float)(j1 + 0) - f2, (float)(k1 + 0) - f2, d1, d4);
                ho1.a((float)i1 + f3, (float)(j1 + 1) + f2, (float)(k1 + 0) - f2, d2, d4);
            }
            if(a.g(i1 + 1, j1, k1) && a.a(i1 + 1, j1 + 1, k1) == ly.aw.bc)
            {
                ho1.a((float)(i1 + 1) - f3, (float)(j1 + 0) - f2, (float)(k1 + 1) + f2, d1, d4);
                ho1.a((float)(i1 + 1) - f3, (float)(j1 + 1) + f2, (float)(k1 + 1) + f2, d2, d4);
                ho1.a((float)(i1 + 1) - f3, (float)(j1 + 1) + f2, (float)(k1 + 0) - f2, d2, d3);
                ho1.a((float)(i1 + 1) - f3, (float)(j1 + 0) - f2, (float)(k1 + 0) - f2, d1, d3);
            }
            if(a.g(i1, j1, k1 - 1) && a.a(i1, j1 + 1, k1 - 1) == ly.aw.bc)
            {
                ho1.a((float)(i1 + 1) + f2, (float)(j1 + 0) - f2, (float)k1 + f3, d1, d4);
                ho1.a((float)(i1 + 1) + f2, (float)(j1 + 1) + f2, (float)k1 + f3, d2, d4);
                ho1.a((float)(i1 + 0) - f2, (float)(j1 + 1) + f2, (float)k1 + f3, d2, d3);
                ho1.a((float)(i1 + 0) - f2, (float)(j1 + 0) - f2, (float)k1 + f3, d1, d3);
            }
            if(a.g(i1, j1, k1 + 1) && a.a(i1, j1 + 1, k1 + 1) == ly.aw.bc)
            {
                ho1.a((float)(i1 + 1) + f2, (float)(j1 + 1) + f2, (float)(k1 + 1) - f3, d2, d3);
                ho1.a((float)(i1 + 1) + f2, (float)(j1 + 0) - f2, (float)(k1 + 1) - f3, d1, d3);
                ho1.a((float)(i1 + 0) - f2, (float)(j1 + 0) - f2, (float)(k1 + 1) - f3, d1, d4);
                ho1.a((float)(i1 + 0) - f2, (float)(j1 + 1) + f2, (float)(k1 + 1) - f3, d2, d4);
            }
        }
        return true;
    }

    public boolean f(ly ly1, int i1, int j1, int k1)
    {
        ho ho1 = ho.a;
        int l1 = a.e(i1, j1, k1);
        int i2 = ly1.a(0, l1);
        if(b >= 0)
            i2 = b;
        float f1 = ly1.c(a, i1, j1, k1);
        ho1.a(f1, f1, f1);
        int j2 = (i2 & 0xf) << 4;
        int k2 = i2 & 0xf0;
        double d1 = (float)j2 / 256F;
        double d2 = ((float)j2 + 15.99F) / 256F;
        double d3 = (float)k2 / 256F;
        double d4 = ((float)k2 + 15.99F) / 256F;
        float f2 = 0.0625F;
        float f3 = i1 + 1;
        float f4 = i1 + 1;
        float f5 = i1 + 0;
        float f6 = i1 + 0;
        float f7 = k1 + 0;
        float f8 = k1 + 1;
        float f9 = k1 + 1;
        float f10 = k1 + 0;
        float f11 = (float)j1 + f2;
        float f12 = (float)j1 + f2;
        float f13 = (float)j1 + f2;
        float f14 = (float)j1 + f2;
        if(l1 == 1 || l1 == 2 || l1 == 3 || l1 == 7)
        {
            f3 = f6 = i1 + 1;
            f4 = f5 = i1 + 0;
            f7 = f8 = k1 + 1;
            f9 = f10 = k1 + 0;
        } else
        if(l1 == 8)
        {
            f3 = f4 = i1 + 0;
            f5 = f6 = i1 + 1;
            f7 = f10 = k1 + 1;
            f8 = f9 = k1 + 0;
        } else
        if(l1 == 9)
        {
            f3 = f6 = i1 + 0;
            f4 = f5 = i1 + 1;
            f7 = f8 = k1 + 0;
            f9 = f10 = k1 + 1;
        }
        if(l1 == 2 || l1 == 4)
        {
            f11++;
            f14++;
        } else
        if(l1 == 3 || l1 == 5)
        {
            f12++;
            f13++;
        }
        ho1.a(f3, f11, f7, d2, d3);
        ho1.a(f4, f12, f8, d2, d4);
        ho1.a(f5, f13, f9, d1, d4);
        ho1.a(f6, f14, f10, d1, d3);
        ho1.a(f6, f14, f10, d1, d3);
        ho1.a(f5, f13, f9, d1, d4);
        ho1.a(f4, f12, f8, d2, d4);
        ho1.a(f3, f11, f7, d2, d3);
        return true;
    }

    public boolean g(ly ly1, int i1, int j1, int k1)
    {
        ho ho1 = ho.a;
        int l1 = ly1.a(0);
        if(b >= 0)
            l1 = b;
        float f1 = ly1.c(a, i1, j1, k1);
        ho1.a(f1, f1, f1);
        int i2 = (l1 & 0xf) << 4;
        int j2 = l1 & 0xf0;
        double d1 = (float)i2 / 256F;
        double d2 = ((float)i2 + 15.99F) / 256F;
        double d3 = (float)j2 / 256F;
        double d4 = ((float)j2 + 15.99F) / 256F;
        int k2 = a.e(i1, j1, k1);
        float f2 = 0.0F;
        float f3 = 0.05F;
        if(k2 == 5)
        {
            ho1.a((float)i1 + f3, (float)(j1 + 1) + f2, (float)(k1 + 1) + f2, d1, d3);
            ho1.a((float)i1 + f3, (float)(j1 + 0) - f2, (float)(k1 + 1) + f2, d1, d4);
            ho1.a((float)i1 + f3, (float)(j1 + 0) - f2, (float)(k1 + 0) - f2, d2, d4);
            ho1.a((float)i1 + f3, (float)(j1 + 1) + f2, (float)(k1 + 0) - f2, d2, d3);
        }
        if(k2 == 4)
        {
            ho1.a((float)(i1 + 1) - f3, (float)(j1 + 0) - f2, (float)(k1 + 1) + f2, d2, d4);
            ho1.a((float)(i1 + 1) - f3, (float)(j1 + 1) + f2, (float)(k1 + 1) + f2, d2, d3);
            ho1.a((float)(i1 + 1) - f3, (float)(j1 + 1) + f2, (float)(k1 + 0) - f2, d1, d3);
            ho1.a((float)(i1 + 1) - f3, (float)(j1 + 0) - f2, (float)(k1 + 0) - f2, d1, d4);
        }
        if(k2 == 3)
        {
            ho1.a((float)(i1 + 1) + f2, (float)(j1 + 0) - f2, (float)k1 + f3, d2, d4);
            ho1.a((float)(i1 + 1) + f2, (float)(j1 + 1) + f2, (float)k1 + f3, d2, d3);
            ho1.a((float)(i1 + 0) - f2, (float)(j1 + 1) + f2, (float)k1 + f3, d1, d3);
            ho1.a((float)(i1 + 0) - f2, (float)(j1 + 0) - f2, (float)k1 + f3, d1, d4);
        }
        if(k2 == 2)
        {
            ho1.a((float)(i1 + 1) + f2, (float)(j1 + 1) + f2, (float)(k1 + 1) - f3, d1, d3);
            ho1.a((float)(i1 + 1) + f2, (float)(j1 + 0) - f2, (float)(k1 + 1) - f3, d1, d4);
            ho1.a((float)(i1 + 0) - f2, (float)(j1 + 0) - f2, (float)(k1 + 1) - f3, d2, d4);
            ho1.a((float)(i1 + 0) - f2, (float)(j1 + 1) + f2, (float)(k1 + 1) - f3, d2, d3);
        }
        return true;
    }

    public boolean h(ly ly1, int i1, int j1, int k1)
    {
        ho ho1 = ho.a;
        float f1 = ly1.c(a, i1, j1, k1);
        ho1.a(f1, f1, f1);
        a(ly1, a.e(i1, j1, k1), i1, j1, k1);
        return true;
    }

    public boolean i(ly ly1, int i1, int j1, int k1)
    {
        ho ho1 = ho.a;
        float f1 = ly1.c(a, i1, j1, k1);
        ho1.a(f1, f1, f1);
        b(ly1, a.e(i1, j1, k1), i1, (float)j1 - 0.0625F, k1);
        return true;
    }

    public void a(ly ly1, double d1, double d2, double d3, 
            double d4, double d5)
    {
        ho ho1 = ho.a;
        int i1 = ly1.a(0);
        if(b >= 0)
            i1 = b;
        int j1 = (i1 & 0xf) << 4;
        int k1 = i1 & 0xf0;
        float f1 = (float)j1 / 256F;
        float f2 = ((float)j1 + 15.99F) / 256F;
        float f3 = (float)k1 / 256F;
        float f4 = ((float)k1 + 15.99F) / 256F;
        double d6 = (double)f1 + 0.02734375D;
        double d7 = (double)f3 + 0.0234375D;
        double d8 = (double)f1 + 0.03515625D;
        double d9 = (double)f3 + 0.03125D;
        d1 += 0.5D;
        d3 += 0.5D;
        double d10 = d1 - 0.5D;
        double d11 = d1 + 0.5D;
        double d12 = d3 - 0.5D;
        double d13 = d3 + 0.5D;
        double d14 = 0.0625D;
        double d15 = 0.625D;
        ho1.a((d1 + d4 * (1.0D - d15)) - d14, d2 + d15, (d3 + d5 * (1.0D - d15)) - d14, d6, d7);
        ho1.a((d1 + d4 * (1.0D - d15)) - d14, d2 + d15, d3 + d5 * (1.0D - d15) + d14, d6, d9);
        ho1.a(d1 + d4 * (1.0D - d15) + d14, d2 + d15, d3 + d5 * (1.0D - d15) + d14, d8, d9);
        ho1.a(d1 + d4 * (1.0D - d15) + d14, d2 + d15, (d3 + d5 * (1.0D - d15)) - d14, d8, d7);
        ho1.a(d1 - d14, d2 + 1.0D, d12, f1, f3);
        ho1.a((d1 - d14) + d4, d2 + 0.0D, d12 + d5, f1, f4);
        ho1.a((d1 - d14) + d4, d2 + 0.0D, d13 + d5, f2, f4);
        ho1.a(d1 - d14, d2 + 1.0D, d13, f2, f3);
        ho1.a(d1 + d14, d2 + 1.0D, d13, f1, f3);
        ho1.a(d1 + d4 + d14, d2 + 0.0D, d13 + d5, f1, f4);
        ho1.a(d1 + d4 + d14, d2 + 0.0D, d12 + d5, f2, f4);
        ho1.a(d1 + d14, d2 + 1.0D, d12, f2, f3);
        ho1.a(d10, d2 + 1.0D, d3 + d14, f1, f3);
        ho1.a(d10 + d4, d2 + 0.0D, d3 + d14 + d5, f1, f4);
        ho1.a(d11 + d4, d2 + 0.0D, d3 + d14 + d5, f2, f4);
        ho1.a(d11, d2 + 1.0D, d3 + d14, f2, f3);
        ho1.a(d11, d2 + 1.0D, d3 - d14, f1, f3);
        ho1.a(d11 + d4, d2 + 0.0D, (d3 - d14) + d5, f1, f4);
        ho1.a(d10 + d4, d2 + 0.0D, (d3 - d14) + d5, f2, f4);
        ho1.a(d10, d2 + 1.0D, d3 - d14, f2, f3);
    }

    public void a(ly ly1, int i1, double d1, double d2, double d3)
    {
        ho ho1 = ho.a;
        int j1 = ly1.a(0, i1);
        if(b >= 0)
            j1 = b;
        int k1 = (j1 & 0xf) << 4;
        int l1 = j1 & 0xf0;
        double d4 = (float)k1 / 256F;
        double d5 = ((float)k1 + 15.99F) / 256F;
        double d6 = (float)l1 / 256F;
        double d7 = ((float)l1 + 15.99F) / 256F;
        double d8 = (d1 + 0.5D) - 0.44999998807907104D;
        double d9 = d1 + 0.5D + 0.44999998807907104D;
        double d10 = (d3 + 0.5D) - 0.44999998807907104D;
        double d11 = d3 + 0.5D + 0.44999998807907104D;
        ho1.a(d8, d2 + 1.0D, d10, d4, d6);
        ho1.a(d8, d2 + 0.0D, d10, d4, d7);
        ho1.a(d9, d2 + 0.0D, d11, d5, d7);
        ho1.a(d9, d2 + 1.0D, d11, d5, d6);
        ho1.a(d9, d2 + 1.0D, d11, d4, d6);
        ho1.a(d9, d2 + 0.0D, d11, d4, d7);
        ho1.a(d8, d2 + 0.0D, d10, d5, d7);
        ho1.a(d8, d2 + 1.0D, d10, d5, d6);
        ho1.a(d8, d2 + 1.0D, d11, d4, d6);
        ho1.a(d8, d2 + 0.0D, d11, d4, d7);
        ho1.a(d9, d2 + 0.0D, d10, d5, d7);
        ho1.a(d9, d2 + 1.0D, d10, d5, d6);
        ho1.a(d9, d2 + 1.0D, d10, d4, d6);
        ho1.a(d9, d2 + 0.0D, d10, d4, d7);
        ho1.a(d8, d2 + 0.0D, d11, d5, d7);
        ho1.a(d8, d2 + 1.0D, d11, d5, d6);
    }

    public void b(ly ly1, int i1, double d1, double d2, double d3)
    {
        ho ho1 = ho.a;
        int j1 = ly1.a(0, i1);
        if(b >= 0)
            j1 = b;
        int k1 = (j1 & 0xf) << 4;
        int l1 = j1 & 0xf0;
        double d4 = (float)k1 / 256F;
        double d5 = ((float)k1 + 15.99F) / 256F;
        double d6 = (float)l1 / 256F;
        double d7 = ((float)l1 + 15.99F) / 256F;
        double d8 = (d1 + 0.5D) - 0.25D;
        double d9 = d1 + 0.5D + 0.25D;
        double d10 = (d3 + 0.5D) - 0.5D;
        double d11 = d3 + 0.5D + 0.5D;
        ho1.a(d8, d2 + 1.0D, d10, d4, d6);
        ho1.a(d8, d2 + 0.0D, d10, d4, d7);
        ho1.a(d8, d2 + 0.0D, d11, d5, d7);
        ho1.a(d8, d2 + 1.0D, d11, d5, d6);
        ho1.a(d8, d2 + 1.0D, d11, d4, d6);
        ho1.a(d8, d2 + 0.0D, d11, d4, d7);
        ho1.a(d8, d2 + 0.0D, d10, d5, d7);
        ho1.a(d8, d2 + 1.0D, d10, d5, d6);
        ho1.a(d9, d2 + 1.0D, d11, d4, d6);
        ho1.a(d9, d2 + 0.0D, d11, d4, d7);
        ho1.a(d9, d2 + 0.0D, d10, d5, d7);
        ho1.a(d9, d2 + 1.0D, d10, d5, d6);
        ho1.a(d9, d2 + 1.0D, d10, d4, d6);
        ho1.a(d9, d2 + 0.0D, d10, d4, d7);
        ho1.a(d9, d2 + 0.0D, d11, d5, d7);
        ho1.a(d9, d2 + 1.0D, d11, d5, d6);
        d8 = (d1 + 0.5D) - 0.5D;
        d9 = d1 + 0.5D + 0.5D;
        d10 = (d3 + 0.5D) - 0.25D;
        d11 = d3 + 0.5D + 0.25D;
        ho1.a(d8, d2 + 1.0D, d10, d4, d6);
        ho1.a(d8, d2 + 0.0D, d10, d4, d7);
        ho1.a(d9, d2 + 0.0D, d10, d5, d7);
        ho1.a(d9, d2 + 1.0D, d10, d5, d6);
        ho1.a(d9, d2 + 1.0D, d10, d4, d6);
        ho1.a(d9, d2 + 0.0D, d10, d4, d7);
        ho1.a(d8, d2 + 0.0D, d10, d5, d7);
        ho1.a(d8, d2 + 1.0D, d10, d5, d6);
        ho1.a(d9, d2 + 1.0D, d11, d4, d6);
        ho1.a(d9, d2 + 0.0D, d11, d4, d7);
        ho1.a(d8, d2 + 0.0D, d11, d5, d7);
        ho1.a(d8, d2 + 1.0D, d11, d5, d6);
        ho1.a(d8, d2 + 1.0D, d11, d4, d6);
        ho1.a(d8, d2 + 0.0D, d11, d4, d7);
        ho1.a(d9, d2 + 0.0D, d11, d5, d7);
        ho1.a(d9, d2 + 1.0D, d11, d5, d6);
    }

    public boolean j(ly ly1, int i1, int j1, int k1)
    {
        ho ho1 = ho.a;
        boolean flag = ly1.c(a, i1, j1 + 1, k1, 1);
        boolean flag1 = ly1.c(a, i1, j1 - 1, k1, 0);
        boolean aflag[] = new boolean[4];
        aflag[0] = ly1.c(a, i1, j1, k1 - 1, 2);
        aflag[1] = ly1.c(a, i1, j1, k1 + 1, 3);
        aflag[2] = ly1.c(a, i1 - 1, j1, k1, 4);
        aflag[3] = ly1.c(a, i1 + 1, j1, k1, 5);
        if(!flag && !flag1 && !aflag[0] && !aflag[1] && !aflag[2] && !aflag[3])
            return false;
        boolean flag2 = false;
        float f1 = 0.5F;
        float f2 = 1.0F;
        float f3 = 0.8F;
        float f4 = 0.6F;
        double d1 = 0.0D;
        double d2 = 1.0D;
        gb gb1 = ly1.bn;
        int l1 = a.e(i1, j1, k1);
        float f5 = a(i1, j1, k1, gb1);
        float f6 = a(i1, j1, k1 + 1, gb1);
        float f7 = a(i1 + 1, j1, k1 + 1, gb1);
        float f8 = a(i1 + 1, j1, k1, gb1);
        if(d || flag)
        {
            flag2 = true;
            int i2 = ly1.a(1, l1);
            float f10 = (float)jp.a(a, i1, j1, k1, gb1);
            if(f10 > -999F)
                i2 = ly1.a(2, l1);
            int l2 = (i2 & 0xf) << 4;
            int j3 = i2 & 0xf0;
            double d3 = ((double)l2 + 8D) / 256D;
            double d4 = ((double)j3 + 8D) / 256D;
            if(f10 < -999F)
            {
                f10 = 0.0F;
            } else
            {
                d3 = (float)(l2 + 16) / 256F;
                d4 = (float)(j3 + 16) / 256F;
            }
            float f12 = (eo.a(f10) * 8F) / 256F;
            float f14 = (eo.b(f10) * 8F) / 256F;
            float f16 = ly1.c(a, i1, j1, k1);
            ho1.a(f2 * f16, f2 * f16, f2 * f16);
            ho1.a(i1 + 0, (float)j1 + f5, k1 + 0, d3 - (double)f14 - (double)f12, (d4 - (double)f14) + (double)f12);
            ho1.a(i1 + 0, (float)j1 + f6, k1 + 1, (d3 - (double)f14) + (double)f12, d4 + (double)f14 + (double)f12);
            ho1.a(i1 + 1, (float)j1 + f7, k1 + 1, d3 + (double)f14 + (double)f12, (d4 + (double)f14) - (double)f12);
            ho1.a(i1 + 1, (float)j1 + f8, k1 + 0, (d3 + (double)f14) - (double)f12, d4 - (double)f14 - (double)f12);
        }
        if(d || flag1)
        {
            float f9 = ly1.c(a, i1, j1 - 1, k1);
            ho1.a(f1 * f9, f1 * f9, f1 * f9);
            a(ly1, i1, j1, k1, ly1.a(0));
            flag2 = true;
        }
        for(int j2 = 0; j2 < 4; j2++)
        {
            int k2 = i1;
            int i3 = j1;
            int k3 = k1;
            if(j2 == 0)
                k3--;
            if(j2 == 1)
                k3++;
            if(j2 == 2)
                k2--;
            if(j2 == 3)
                k2++;
            int l3 = ly1.a(j2 + 2, l1);
            int i4 = (l3 & 0xf) << 4;
            int j4 = l3 & 0xf0;
            if(!d && !aflag[j2])
                continue;
            float f11;
            float f13;
            float f15;
            float f17;
            float f18;
            float f19;
            if(j2 == 0)
            {
                f11 = f5;
                f13 = f8;
                f15 = i1;
                f18 = i1 + 1;
                f17 = k1;
                f19 = k1;
            } else
            if(j2 == 1)
            {
                f11 = f7;
                f13 = f6;
                f15 = i1 + 1;
                f18 = i1;
                f17 = k1 + 1;
                f19 = k1 + 1;
            } else
            if(j2 == 2)
            {
                f11 = f6;
                f13 = f5;
                f15 = i1;
                f18 = i1;
                f17 = k1 + 1;
                f19 = k1;
            } else
            {
                f11 = f8;
                f13 = f7;
                f15 = i1 + 1;
                f18 = i1 + 1;
                f17 = k1;
                f19 = k1 + 1;
            }
            flag2 = true;
            double d5 = (float)(i4 + 0) / 256F;
            double d6 = ((double)(i4 + 16) - 0.01D) / 256D;
            double d7 = ((float)j4 + (1.0F - f11) * 16F) / 256F;
            double d8 = ((float)j4 + (1.0F - f13) * 16F) / 256F;
            double d9 = ((double)(j4 + 16) - 0.01D) / 256D;
            float f20 = ly1.c(a, k2, i3, k3);
            if(j2 < 2)
                f20 *= f3;
            else
                f20 *= f4;
            ho1.a(f2 * f20, f2 * f20, f2 * f20);
            ho1.a(f15, (float)j1 + f11, f17, d5, d7);
            ho1.a(f18, (float)j1 + f13, f19, d6, d8);
            ho1.a(f18, j1 + 0, f19, d6, d9);
            ho1.a(f15, j1 + 0, f17, d5, d9);
        }

        ly1.bg = d1;
        ly1.bj = d2;
        return flag2;
    }

    private float a(int i1, int j1, int k1, gb gb1)
    {
        int l1 = 0;
        float f1 = 0.0F;
        for(int i2 = 0; i2 < 4; i2++)
        {
            int j2 = i1 - (i2 & 1);
            int k2 = j1;
            int l2 = k1 - (i2 >> 1 & 1);
            if(a.f(j2, k2 + 1, l2) == gb1)
                return 1.0F;
            gb gb2 = a.f(j2, k2, l2);
            if(gb2 == gb1)
            {
                int i3 = a.e(j2, k2, l2);
                if(i3 >= 8 || i3 == 0)
                {
                    f1 += jp.b(i3) * 10F;
                    l1 += 10;
                }
                f1 += jp.b(i3);
                l1++;
                continue;
            }
            if(!gb2.a())
            {
                f1++;
                l1++;
            }
        }

        return 1.0F - f1 / (float)l1;
    }

    public void a(ly ly1, cn cn, int i1, int j1, int k1)
    {
        float f1 = 0.5F;
        float f2 = 1.0F;
        float f3 = 0.8F;
        float f4 = 0.6F;
        ho ho1 = ho.a;
        ho1.b();
        float f5 = ly1.c(((nm) (cn)), i1, j1, k1);
        float f6 = ly1.c(((nm) (cn)), i1, j1 - 1, k1);
        if(f6 < f5)
            f6 = f5;
        ho1.a(f1 * f6, f1 * f6, f1 * f6);
        a(ly1, -0.5D, -0.5D, -0.5D, ly1.a(0));
        f6 = ly1.c(((nm) (cn)), i1, j1 + 1, k1);
        if(f6 < f5)
            f6 = f5;
        ho1.a(f2 * f6, f2 * f6, f2 * f6);
        b(ly1, -0.5D, -0.5D, -0.5D, ly1.a(1));
        f6 = ly1.c(((nm) (cn)), i1, j1, k1 - 1);
        if(f6 < f5)
            f6 = f5;
        ho1.a(f3 * f6, f3 * f6, f3 * f6);
        c(ly1, -0.5D, -0.5D, -0.5D, ly1.a(2));
        f6 = ly1.c(((nm) (cn)), i1, j1, k1 + 1);
        if(f6 < f5)
            f6 = f5;
        ho1.a(f3 * f6, f3 * f6, f3 * f6);
        d(ly1, -0.5D, -0.5D, -0.5D, ly1.a(3));
        f6 = ly1.c(((nm) (cn)), i1 - 1, j1, k1);
        if(f6 < f5)
            f6 = f5;
        ho1.a(f4 * f6, f4 * f6, f4 * f6);
        e(ly1, -0.5D, -0.5D, -0.5D, ly1.a(4));
        f6 = ly1.c(((nm) (cn)), i1 + 1, j1, k1);
        if(f6 < f5)
            f6 = f5;
        ho1.a(f4 * f6, f4 * f6, f4 * f6);
        f(ly1, -0.5D, -0.5D, -0.5D, ly1.a(5));
        ho1.a();
    }

    public boolean k(ly ly1, int i1, int j1, int k1)
    {
        int l1 = ly1.d(a, i1, j1, k1);
        float f1 = (float)(l1 >> 16 & 0xff) / 255F;
        float f2 = (float)(l1 >> 8 & 0xff) / 255F;
        float f3 = (float)(l1 & 0xff) / 255F;
        return a(ly1, i1, j1, k1, f1, f2, f3);
    }

    public boolean a(ly ly1, int i1, int j1, int k1, float f1, float f2, float f3)
    {
        ho ho1 = ho.a;
        boolean flag = false;
        float f4 = 0.5F;
        float f5 = 1.0F;
        float f6 = 0.8F;
        float f7 = 0.6F;
        float f8 = f4 * f1;
        float f9 = f5 * f1;
        float f10 = f6 * f1;
        float f11 = f7 * f1;
        float f12 = f4 * f2;
        float f13 = f5 * f2;
        float f14 = f6 * f2;
        float f15 = f7 * f2;
        float f16 = f4 * f3;
        float f17 = f5 * f3;
        float f18 = f6 * f3;
        float f19 = f7 * f3;
        float f20 = ly1.c(a, i1, j1, k1);
        if(d || ly1.c(a, i1, j1 - 1, k1, 0))
        {
            float f21 = ly1.c(a, i1, j1 - 1, k1);
            ho1.a(f8 * f21, f12 * f21, f16 * f21);
            a(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 0));
            flag = true;
        }
        if(d || ly1.c(a, i1, j1 + 1, k1, 1))
        {
            float f22 = ly1.c(a, i1, j1 + 1, k1);
            if(ly1.bj != 1.0D && !ly1.bn.d())
                f22 = f20;
            ho1.a(f9 * f22, f13 * f22, f17 * f22);
            b(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 1));
            flag = true;
        }
        if(d || ly1.c(a, i1, j1, k1 - 1, 2))
        {
            float f23 = ly1.c(a, i1, j1, k1 - 1);
            if(ly1.bh > 0.0D)
                f23 = f20;
            ho1.a(f10 * f23, f14 * f23, f18 * f23);
            c(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 2));
            flag = true;
        }
        if(d || ly1.c(a, i1, j1, k1 + 1, 3))
        {
            float f24 = ly1.c(a, i1, j1, k1 + 1);
            if(ly1.bk < 1.0D)
                f24 = f20;
            ho1.a(f10 * f24, f14 * f24, f18 * f24);
            d(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 3));
            flag = true;
        }
        if(d || ly1.c(a, i1 - 1, j1, k1, 4))
        {
            float f25 = ly1.c(a, i1 - 1, j1, k1);
            if(ly1.bf > 0.0D)
                f25 = f20;
            ho1.a(f11 * f25, f15 * f25, f19 * f25);
            e(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 4));
            flag = true;
        }
        if(d || ly1.c(a, i1 + 1, j1, k1, 5))
        {
            float f26 = ly1.c(a, i1 + 1, j1, k1);
            if(ly1.bi < 1.0D)
                f26 = f20;
            ho1.a(f11 * f26, f15 * f26, f19 * f26);
            f(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 5));
            flag = true;
        }
        return flag;
    }

    public boolean l(ly ly1, int i1, int j1, int k1)
    {
        int l1 = ly1.d(a, i1, j1, k1);
        float f1 = (float)(l1 >> 16 & 0xff) / 255F;
        float f2 = (float)(l1 >> 8 & 0xff) / 255F;
        float f3 = (float)(l1 & 0xff) / 255F;
        return b(ly1, i1, j1, k1, f1, f2, f3);
    }

    public boolean b(ly ly1, int i1, int j1, int k1, float f1, float f2, float f3)
    {
        ho ho1 = ho.a;
        boolean flag = false;
        float f4 = 0.5F;
        float f5 = 1.0F;
        float f6 = 0.8F;
        float f7 = 0.6F;
        float f8 = f4 * f1;
        float f9 = f5 * f1;
        float f10 = f6 * f1;
        float f11 = f7 * f1;
        float f12 = f4 * f2;
        float f13 = f5 * f2;
        float f14 = f6 * f2;
        float f15 = f7 * f2;
        float f16 = f4 * f3;
        float f17 = f5 * f3;
        float f18 = f6 * f3;
        float f19 = f7 * f3;
        float f20 = 0.0625F;
        float f21 = ly1.c(a, i1, j1, k1);
        if(d || ly1.c(a, i1, j1 - 1, k1, 0))
        {
            float f22 = ly1.c(a, i1, j1 - 1, k1);
            ho1.a(f8 * f22, f12 * f22, f16 * f22);
            a(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 0));
            flag = true;
        }
        if(d || ly1.c(a, i1, j1 + 1, k1, 1))
        {
            float f23 = ly1.c(a, i1, j1 + 1, k1);
            if(ly1.bj != 1.0D && !ly1.bn.d())
                f23 = f21;
            ho1.a(f9 * f23, f13 * f23, f17 * f23);
            b(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 1));
            flag = true;
        }
        if(d || ly1.c(a, i1, j1, k1 - 1, 2))
        {
            float f24 = ly1.c(a, i1, j1, k1 - 1);
            if(ly1.bh > 0.0D)
                f24 = f21;
            ho1.a(f10 * f24, f14 * f24, f18 * f24);
            ho1.c(0.0F, 0.0F, f20);
            c(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 2));
            ho1.c(0.0F, 0.0F, -f20);
            flag = true;
        }
        if(d || ly1.c(a, i1, j1, k1 + 1, 3))
        {
            float f25 = ly1.c(a, i1, j1, k1 + 1);
            if(ly1.bk < 1.0D)
                f25 = f21;
            ho1.a(f10 * f25, f14 * f25, f18 * f25);
            ho1.c(0.0F, 0.0F, -f20);
            d(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 3));
            ho1.c(0.0F, 0.0F, f20);
            flag = true;
        }
        if(d || ly1.c(a, i1 - 1, j1, k1, 4))
        {
            float f26 = ly1.c(a, i1 - 1, j1, k1);
            if(ly1.bf > 0.0D)
                f26 = f21;
            ho1.a(f11 * f26, f15 * f26, f19 * f26);
            ho1.c(f20, 0.0F, 0.0F);
            e(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 4));
            ho1.c(-f20, 0.0F, 0.0F);
            flag = true;
        }
        if(d || ly1.c(a, i1 + 1, j1, k1, 5))
        {
            float f27 = ly1.c(a, i1 + 1, j1, k1);
            if(ly1.bi < 1.0D)
                f27 = f21;
            ho1.a(f11 * f27, f15 * f27, f19 * f27);
            ho1.c(-f20, 0.0F, 0.0F);
            f(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 5));
            ho1.c(f20, 0.0F, 0.0F);
            flag = true;
        }
        return flag;
    }

    public boolean m(ly ly1, int i1, int j1, int k1)
    {
        boolean flag = false;
        float f1 = 0.375F;
        float f2 = 0.625F;
        ly1.a(f1, 0.0F, f1, f2, 1.0F, f2);
        k(ly1, i1, j1, k1);
        boolean flag1 = false;
        boolean flag2 = false;
        if(a.a(i1 - 1, j1, k1) == ly1.bc || a.a(i1 + 1, j1, k1) == ly1.bc)
            flag1 = true;
        if(a.a(i1, j1, k1 - 1) == ly1.bc || a.a(i1, j1, k1 + 1) == ly1.bc)
            flag2 = true;
        boolean flag3 = a.a(i1 - 1, j1, k1) == ly1.bc;
        boolean flag4 = a.a(i1 + 1, j1, k1) == ly1.bc;
        boolean flag5 = a.a(i1, j1, k1 - 1) == ly1.bc;
        boolean flag6 = a.a(i1, j1, k1 + 1) == ly1.bc;
        if(!flag1 && !flag2)
            flag1 = true;
        f1 = 0.4375F;
        f2 = 0.5625F;
        float f3 = 0.75F;
        float f4 = 0.9375F;
        float f5 = flag3 ? 0.0F : f1;
        float f6 = flag4 ? 1.0F : f2;
        float f7 = flag5 ? 0.0F : f1;
        float f8 = flag6 ? 1.0F : f2;
        if(flag1)
        {
            ly1.a(f5, f3, f1, f6, f4, f2);
            k(ly1, i1, j1, k1);
        }
        if(flag2)
        {
            ly1.a(f1, f3, f7, f2, f4, f8);
            k(ly1, i1, j1, k1);
        }
        f3 = 0.375F;
        f4 = 0.5625F;
        if(flag1)
        {
            ly1.a(f5, f3, f1, f6, f4, f2);
            k(ly1, i1, j1, k1);
        }
        if(flag2)
        {
            ly1.a(f1, f3, f7, f2, f4, f8);
            k(ly1, i1, j1, k1);
        }
        ly1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return flag;
    }

    public boolean n(ly ly1, int i1, int j1, int k1)
    {
        boolean flag = false;
        int l1 = a.e(i1, j1, k1);
        if(l1 == 0)
        {
            ly1.a(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            k(ly1, i1, j1, k1);
            ly1.a(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            k(ly1, i1, j1, k1);
        } else
        if(l1 == 1)
        {
            ly1.a(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            k(ly1, i1, j1, k1);
            ly1.a(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            k(ly1, i1, j1, k1);
        } else
        if(l1 == 2)
        {
            ly1.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            k(ly1, i1, j1, k1);
            ly1.a(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            k(ly1, i1, j1, k1);
        } else
        if(l1 == 3)
        {
            ly1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            k(ly1, i1, j1, k1);
            ly1.a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            k(ly1, i1, j1, k1);
        }
        ly1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return flag;
    }

    public boolean o(ly ly1, int i1, int j1, int k1)
    {
        ho ho1 = ho.a;
        fw fw1 = (fw)ly1;
        boolean flag = false;
        float f1 = 0.5F;
        float f2 = 1.0F;
        float f3 = 0.8F;
        float f4 = 0.6F;
        float f5 = ly1.c(a, i1, j1, k1);
        float f6 = ly1.c(a, i1, j1 - 1, k1);
        if(fw1.bg > 0.0D)
            f6 = f5;
        if(ly.t[ly1.bc] > 0)
            f6 = 1.0F;
        ho1.a(f1 * f6, f1 * f6, f1 * f6);
        a(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 0));
        flag = true;
        f6 = ly1.c(a, i1, j1 + 1, k1);
        if(fw1.bj < 1.0D)
            f6 = f5;
        if(ly.t[ly1.bc] > 0)
            f6 = 1.0F;
        ho1.a(f2 * f6, f2 * f6, f2 * f6);
        b(ly1, i1, j1, k1, ly1.a(a, i1, j1, k1, 1));
        flag = true;
        f6 = ly1.c(a, i1, j1, k1 - 1);
        if(fw1.bh > 0.0D)
            f6 = f5;
        if(ly.t[ly1.bc] > 0)
            f6 = 1.0F;
        ho1.a(f3 * f6, f3 * f6, f3 * f6);
        int l1 = ly1.a(a, i1, j1, k1, 2);
        if(l1 < 0)
        {
            c = true;
            l1 = -l1;
        }
        c(ly1, i1, j1, k1, l1);
        flag = true;
        c = false;
        f6 = ly1.c(a, i1, j1, k1 + 1);
        if(fw1.bk < 1.0D)
            f6 = f5;
        if(ly.t[ly1.bc] > 0)
            f6 = 1.0F;
        ho1.a(f3 * f6, f3 * f6, f3 * f6);
        l1 = ly1.a(a, i1, j1, k1, 3);
        if(l1 < 0)
        {
            c = true;
            l1 = -l1;
        }
        d(ly1, i1, j1, k1, l1);
        flag = true;
        c = false;
        f6 = ly1.c(a, i1 - 1, j1, k1);
        if(fw1.bf > 0.0D)
            f6 = f5;
        if(ly.t[ly1.bc] > 0)
            f6 = 1.0F;
        ho1.a(f4 * f6, f4 * f6, f4 * f6);
        l1 = ly1.a(a, i1, j1, k1, 4);
        if(l1 < 0)
        {
            c = true;
            l1 = -l1;
        }
        e(ly1, i1, j1, k1, l1);
        flag = true;
        c = false;
        f6 = ly1.c(a, i1 + 1, j1, k1);
        if(fw1.bi < 1.0D)
            f6 = f5;
        if(ly.t[ly1.bc] > 0)
            f6 = 1.0F;
        ho1.a(f4 * f6, f4 * f6, f4 * f6);
        l1 = ly1.a(a, i1, j1, k1, 5);
        if(l1 < 0)
        {
            c = true;
            l1 = -l1;
        }
        f(ly1, i1, j1, k1, l1);
        flag = true;
        c = false;
        return flag;
    }

    public void a(ly ly1, double d1, double d2, double d3, 
            int i1)
    {
        ho ho1 = ho.a;
        if(b >= 0)
            i1 = b;
        int j1 = (i1 & 0xf) << 4;
        int k1 = i1 & 0xf0;
        double d4 = ((double)j1 + ly1.bf * 16D) / 256D;
        double d5 = (((double)j1 + ly1.bi * 16D) - 0.01D) / 256D;
        double d6 = ((double)k1 + ly1.bh * 16D) / 256D;
        double d7 = (((double)k1 + ly1.bk * 16D) - 0.01D) / 256D;
        if(ly1.bf < 0.0D || ly1.bi > 1.0D)
        {
            d4 = ((float)j1 + 0.0F) / 256F;
            d5 = ((float)j1 + 15.99F) / 256F;
        }
        if(ly1.bh < 0.0D || ly1.bk > 1.0D)
        {
            d6 = ((float)k1 + 0.0F) / 256F;
            d7 = ((float)k1 + 15.99F) / 256F;
        }
        double d8 = d1 + ly1.bf;
        double d9 = d1 + ly1.bi;
        double d10 = d2 + ly1.bg;
        double d11 = d3 + ly1.bh;
        double d12 = d3 + ly1.bk;
        ho1.a(d8, d10, d12, d4, d7);
        ho1.a(d8, d10, d11, d4, d6);
        ho1.a(d9, d10, d11, d5, d6);
        ho1.a(d9, d10, d12, d5, d7);
    }

    public void b(ly ly1, double d1, double d2, double d3, 
            int i1)
    {
        ho ho1 = ho.a;
        if(b >= 0)
            i1 = b;
        int j1 = (i1 & 0xf) << 4;
        int k1 = i1 & 0xf0;
        double d4 = ((double)j1 + ly1.bf * 16D) / 256D;
        double d5 = (((double)j1 + ly1.bi * 16D) - 0.01D) / 256D;
        double d6 = ((double)k1 + ly1.bh * 16D) / 256D;
        double d7 = (((double)k1 + ly1.bk * 16D) - 0.01D) / 256D;
        if(ly1.bf < 0.0D || ly1.bi > 1.0D)
        {
            d4 = ((float)j1 + 0.0F) / 256F;
            d5 = ((float)j1 + 15.99F) / 256F;
        }
        if(ly1.bh < 0.0D || ly1.bk > 1.0D)
        {
            d6 = ((float)k1 + 0.0F) / 256F;
            d7 = ((float)k1 + 15.99F) / 256F;
        }
        double d8 = d1 + ly1.bf;
        double d9 = d1 + ly1.bi;
        double d10 = d2 + ly1.bj;
        double d11 = d3 + ly1.bh;
        double d12 = d3 + ly1.bk;
        ho1.a(d9, d10, d12, d5, d7);
        ho1.a(d9, d10, d11, d5, d6);
        ho1.a(d8, d10, d11, d4, d6);
        ho1.a(d8, d10, d12, d4, d7);
    }

    public void c(ly ly1, double d1, double d2, double d3, 
            int i1)
    {
        ho ho1 = ho.a;
        if(b >= 0)
            i1 = b;
        int j1 = (i1 & 0xf) << 4;
        int k1 = i1 & 0xf0;
        double d4 = ((double)j1 + ly1.bf * 16D) / 256D;
        double d5 = (((double)j1 + ly1.bi * 16D) - 0.01D) / 256D;
        double d6 = ((double)k1 + ly1.bg * 16D) / 256D;
        double d7 = (((double)k1 + ly1.bj * 16D) - 0.01D) / 256D;
        if(c)
        {
            double d8 = d4;
            d4 = d5;
            d5 = d8;
        }
        if(ly1.bf < 0.0D || ly1.bi > 1.0D)
        {
            d4 = ((float)j1 + 0.0F) / 256F;
            d5 = ((float)j1 + 15.99F) / 256F;
        }
        if(ly1.bg < 0.0D || ly1.bj > 1.0D)
        {
            d6 = ((float)k1 + 0.0F) / 256F;
            d7 = ((float)k1 + 15.99F) / 256F;
        }
        double d9 = d1 + ly1.bf;
        double d10 = d1 + ly1.bi;
        double d11 = d2 + ly1.bg;
        double d12 = d2 + ly1.bj;
        double d13 = d3 + ly1.bh;
        ho1.a(d9, d12, d13, d5, d6);
        ho1.a(d10, d12, d13, d4, d6);
        ho1.a(d10, d11, d13, d4, d7);
        ho1.a(d9, d11, d13, d5, d7);
    }

    public void d(ly ly1, double d1, double d2, double d3, 
            int i1)
    {
        ho ho1 = ho.a;
        if(b >= 0)
            i1 = b;
        int j1 = (i1 & 0xf) << 4;
        int k1 = i1 & 0xf0;
        double d4 = ((double)j1 + ly1.bf * 16D) / 256D;
        double d5 = (((double)j1 + ly1.bi * 16D) - 0.01D) / 256D;
        double d6 = ((double)k1 + ly1.bg * 16D) / 256D;
        double d7 = (((double)k1 + ly1.bj * 16D) - 0.01D) / 256D;
        if(c)
        {
            double d8 = d4;
            d4 = d5;
            d5 = d8;
        }
        if(ly1.bf < 0.0D || ly1.bi > 1.0D)
        {
            d4 = ((float)j1 + 0.0F) / 256F;
            d5 = ((float)j1 + 15.99F) / 256F;
        }
        if(ly1.bg < 0.0D || ly1.bj > 1.0D)
        {
            d6 = ((float)k1 + 0.0F) / 256F;
            d7 = ((float)k1 + 15.99F) / 256F;
        }
        double d9 = d1 + ly1.bf;
        double d10 = d1 + ly1.bi;
        double d11 = d2 + ly1.bg;
        double d12 = d2 + ly1.bj;
        double d13 = d3 + ly1.bk;
        ho1.a(d9, d12, d13, d4, d6);
        ho1.a(d9, d11, d13, d4, d7);
        ho1.a(d10, d11, d13, d5, d7);
        ho1.a(d10, d12, d13, d5, d6);
    }

    public void e(ly ly1, double d1, double d2, double d3, 
            int i1)
    {
        ho ho1 = ho.a;
        if(b >= 0)
            i1 = b;
        int j1 = (i1 & 0xf) << 4;
        int k1 = i1 & 0xf0;
        double d4 = ((double)j1 + ly1.bh * 16D) / 256D;
        double d5 = (((double)j1 + ly1.bk * 16D) - 0.01D) / 256D;
        double d6 = ((double)k1 + ly1.bg * 16D) / 256D;
        double d7 = (((double)k1 + ly1.bj * 16D) - 0.01D) / 256D;
        if(c)
        {
            double d8 = d4;
            d4 = d5;
            d5 = d8;
        }
        if(ly1.bh < 0.0D || ly1.bk > 1.0D)
        {
            d4 = ((float)j1 + 0.0F) / 256F;
            d5 = ((float)j1 + 15.99F) / 256F;
        }
        if(ly1.bg < 0.0D || ly1.bj > 1.0D)
        {
            d6 = ((float)k1 + 0.0F) / 256F;
            d7 = ((float)k1 + 15.99F) / 256F;
        }
        double d9 = d1 + ly1.bf;
        double d10 = d2 + ly1.bg;
        double d11 = d2 + ly1.bj;
        double d12 = d3 + ly1.bh;
        double d13 = d3 + ly1.bk;
        ho1.a(d9, d11, d13, d5, d6);
        ho1.a(d9, d11, d12, d4, d6);
        ho1.a(d9, d10, d12, d4, d7);
        ho1.a(d9, d10, d13, d5, d7);
    }

    public void f(ly ly1, double d1, double d2, double d3, 
            int i1)
    {
        ho ho1 = ho.a;
        if(b >= 0)
            i1 = b;
        int j1 = (i1 & 0xf) << 4;
        int k1 = i1 & 0xf0;
        double d4 = ((double)j1 + ly1.bh * 16D) / 256D;
        double d5 = (((double)j1 + ly1.bk * 16D) - 0.01D) / 256D;
        double d6 = ((double)k1 + ly1.bg * 16D) / 256D;
        double d7 = (((double)k1 + ly1.bj * 16D) - 0.01D) / 256D;
        if(c)
        {
            double d8 = d4;
            d4 = d5;
            d5 = d8;
        }
        if(ly1.bh < 0.0D || ly1.bk > 1.0D)
        {
            d4 = ((float)j1 + 0.0F) / 256F;
            d5 = ((float)j1 + 15.99F) / 256F;
        }
        if(ly1.bg < 0.0D || ly1.bj > 1.0D)
        {
            d6 = ((float)k1 + 0.0F) / 256F;
            d7 = ((float)k1 + 15.99F) / 256F;
        }
        double d9 = d1 + ly1.bi;
        double d10 = d2 + ly1.bg;
        double d11 = d2 + ly1.bj;
        double d12 = d3 + ly1.bh;
        double d13 = d3 + ly1.bk;
        ho1.a(d9, d10, d13, d4, d7);
        ho1.a(d9, d10, d12, d5, d7);
        ho1.a(d9, d11, d12, d5, d6);
        ho1.a(d9, d11, d13, d4, d6);
    }

    public void a(ly ly1, float f1)
    {
        int i1 = ly1.f();
        ho ho1 = ho.a;
        if(i1 == 0)
        {
            ly1.e();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f2 = 0.5F;
            float f3 = 1.0F;
            float f4 = 0.8F;
            float f5 = 0.6F;
            ho1.b();
            ho1.a(f3, f3, f3, f1);
            a(ly1, 0.0D, 0.0D, 0.0D, ly1.a(0));
            ho1.a(f2, f2, f2, f1);
            b(ly1, 0.0D, 0.0D, 0.0D, ly1.a(1));
            ho1.a(f4, f4, f4, f1);
            c(ly1, 0.0D, 0.0D, 0.0D, ly1.a(2));
            d(ly1, 0.0D, 0.0D, 0.0D, ly1.a(3));
            ho1.a(f5, f5, f5, f1);
            e(ly1, 0.0D, 0.0D, 0.0D, ly1.a(4));
            f(ly1, 0.0D, 0.0D, 0.0D, ly1.a(5));
            ho1.a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }
    }

    public void a(ly ly1)
    {
        byte byte0 = -1;
        ho ho1 = ho.a;
        int i1 = ly1.f();
        if(i1 == 0)
        {
            ly1.e();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            ho1.b();
            ho1.b(0.0F, -1F, 0.0F);
            a(ly1, 0.0D, 0.0D, 0.0D, ly1.a(0));
            ho1.a();
            ho1.b();
            ho1.b(0.0F, 1.0F, 0.0F);
            b(ly1, 0.0D, 0.0D, 0.0D, ly1.a(1));
            ho1.a();
            ho1.b();
            ho1.b(0.0F, 0.0F, -1F);
            c(ly1, 0.0D, 0.0D, 0.0D, ly1.a(2));
            ho1.a();
            ho1.b();
            ho1.b(0.0F, 0.0F, 1.0F);
            d(ly1, 0.0D, 0.0D, 0.0D, ly1.a(3));
            ho1.a();
            ho1.b();
            ho1.b(-1F, 0.0F, 0.0F);
            e(ly1, 0.0D, 0.0D, 0.0D, ly1.a(4));
            ho1.a();
            ho1.b();
            ho1.b(1.0F, 0.0F, 0.0F);
            f(ly1, 0.0D, 0.0D, 0.0D, ly1.a(5));
            ho1.a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        } else
        if(i1 == 1)
        {
            ho1.b();
            ho1.b(0.0F, -1F, 0.0F);
            a(ly1, ((int) (byte0)), -0.5D, -0.5D, -0.5D);
            ho1.a();
        } else
        if(i1 == 13)
        {
            ly1.e();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f1 = 0.0625F;
            ho1.b();
            ho1.b(0.0F, -1F, 0.0F);
            a(ly1, 0.0D, 0.0D, 0.0D, ly1.a(0));
            ho1.a();
            ho1.b();
            ho1.b(0.0F, 1.0F, 0.0F);
            b(ly1, 0.0D, 0.0D, 0.0D, ly1.a(1));
            ho1.a();
            ho1.b();
            ho1.b(0.0F, 0.0F, -1F);
            ho1.c(0.0F, 0.0F, f1);
            c(ly1, 0.0D, 0.0D, 0.0D, ly1.a(2));
            ho1.c(0.0F, 0.0F, -f1);
            ho1.a();
            ho1.b();
            ho1.b(0.0F, 0.0F, 1.0F);
            ho1.c(0.0F, 0.0F, -f1);
            d(ly1, 0.0D, 0.0D, 0.0D, ly1.a(3));
            ho1.c(0.0F, 0.0F, f1);
            ho1.a();
            ho1.b();
            ho1.b(-1F, 0.0F, 0.0F);
            ho1.c(f1, 0.0F, 0.0F);
            e(ly1, 0.0D, 0.0D, 0.0D, ly1.a(4));
            ho1.c(-f1, 0.0F, 0.0F);
            ho1.a();
            ho1.b();
            ho1.b(1.0F, 0.0F, 0.0F);
            ho1.c(-f1, 0.0F, 0.0F);
            f(ly1, 0.0D, 0.0D, 0.0D, ly1.a(5));
            ho1.c(f1, 0.0F, 0.0F);
            ho1.a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        } else
        if(i1 == 6)
        {
            ho1.b();
            ho1.b(0.0F, -1F, 0.0F);
            b(ly1, ((int) (byte0)), -0.5D, -0.5D, -0.5D);
            ho1.a();
        } else
        if(i1 == 2)
        {
            ho1.b();
            ho1.b(0.0F, -1F, 0.0F);
            a(ly1, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D);
            ho1.a();
        } else
        if(i1 == 10)
        {
            for(int j1 = 0; j1 < 2; j1++)
            {
                if(j1 == 0)
                    ly1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
                if(j1 == 1)
                    ly1.a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                ho1.b();
                ho1.b(0.0F, -1F, 0.0F);
                a(ly1, 0.0D, 0.0D, 0.0D, ly1.a(0));
                ho1.a();
                ho1.b();
                ho1.b(0.0F, 1.0F, 0.0F);
                b(ly1, 0.0D, 0.0D, 0.0D, ly1.a(1));
                ho1.a();
                ho1.b();
                ho1.b(0.0F, 0.0F, -1F);
                c(ly1, 0.0D, 0.0D, 0.0D, ly1.a(2));
                ho1.a();
                ho1.b();
                ho1.b(0.0F, 0.0F, 1.0F);
                d(ly1, 0.0D, 0.0D, 0.0D, ly1.a(3));
                ho1.a();
                ho1.b();
                ho1.b(-1F, 0.0F, 0.0F);
                e(ly1, 0.0D, 0.0D, 0.0D, ly1.a(4));
                ho1.a();
                ho1.b();
                ho1.b(1.0F, 0.0F, 0.0F);
                f(ly1, 0.0D, 0.0D, 0.0D, ly1.a(5));
                ho1.a();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

        } else
        if(i1 == 11)
        {
            for(int k1 = 0; k1 < 4; k1++)
            {
                float f2 = 0.125F;
                if(k1 == 0)
                    ly1.a(0.5F - f2, 0.0F, 0.0F, 0.5F + f2, 1.0F, f2 * 2.0F);
                if(k1 == 1)
                    ly1.a(0.5F - f2, 0.0F, 1.0F - f2 * 2.0F, 0.5F + f2, 1.0F, 1.0F);
                f2 = 0.0625F;
                if(k1 == 2)
                    ly1.a(0.5F - f2, 1.0F - f2 * 3F, -f2 * 2.0F, 0.5F + f2, 1.0F - f2, 1.0F + f2 * 2.0F);
                if(k1 == 3)
                    ly1.a(0.5F - f2, 0.5F - f2 * 3F, -f2 * 2.0F, 0.5F + f2, 0.5F - f2, 1.0F + f2 * 2.0F);
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                ho1.b();
                ho1.b(0.0F, -1F, 0.0F);
                a(ly1, 0.0D, 0.0D, 0.0D, ly1.a(0));
                ho1.a();
                ho1.b();
                ho1.b(0.0F, 1.0F, 0.0F);
                b(ly1, 0.0D, 0.0D, 0.0D, ly1.a(1));
                ho1.a();
                ho1.b();
                ho1.b(0.0F, 0.0F, -1F);
                c(ly1, 0.0D, 0.0D, 0.0D, ly1.a(2));
                ho1.a();
                ho1.b();
                ho1.b(0.0F, 0.0F, 1.0F);
                d(ly1, 0.0D, 0.0D, 0.0D, ly1.a(3));
                ho1.a();
                ho1.b();
                ho1.b(-1F, 0.0F, 0.0F);
                e(ly1, 0.0D, 0.0D, 0.0D, ly1.a(4));
                ho1.a();
                ho1.b();
                ho1.b(1.0F, 0.0F, 0.0F);
                f(ly1, 0.0D, 0.0D, 0.0D, ly1.a(5));
                ho1.a();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            ly1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public static boolean a(int i1)
    {
        if(i1 == 0)
            return true;
        if(i1 == 13)
            return true;
        if(i1 == 10)
            return true;
        return i1 == 11;
    }

    private nm a;
    private int b;
    private boolean c;
    private boolean d;
}
