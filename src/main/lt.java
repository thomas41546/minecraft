package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class lt
{

    public lt()
    {
        a = new float[768];
        b = new int[5120];
        c = new int[5120];
        d = new int[5120];
        e = new int[5120];
        f = new int[34];
        g = new int[768];
        try
        {
            BufferedImage bufferedimage = ImageIO.read(((Class) (lt)).getResource("/terrain.png"));
            int ai[] = new int[0x10000];
            bufferedimage.getRGB(0, 0, 256, 256, ai, 0, 256);
            for(int j = 0; j < 256; j++)
            {
                int k = 0;
                int l = 0;
                int i1 = 0;
                int j1 = (j % 16) * 16;
                int k1 = (j / 16) * 16;
                int l1 = 0;
                for(int i2 = 0; i2 < 16; i2++)
                {
                    for(int j2 = 0; j2 < 16; j2++)
                    {
                        int k2 = ai[j2 + j1 + (i2 + k1) * 256];
                        int l2 = k2 >> 24 & 0xff;
                        if(l2 > 128)
                        {
                            k += k2 >> 16 & 0xff;
                            l += k2 >> 8 & 0xff;
                            i1 += k2 & 0xff;
                            l1++;
                        }
                    }

                    if(l1 == 0)
                        l1++;
                    a[j * 3 + 0] = k / l1;
                    a[j * 3 + 1] = l / l1;
                    a[j * 3 + 2] = i1 / l1;
                }

            }

        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        for(int i = 0; i < 256; i++)
            if(ly.n[i] != null)
            {
                g[i * 3 + 0] = ly.n[i].a(1);
                g[i * 3 + 1] = ly.n[i].a(2);
                g[i * 3 + 2] = ly.n[i].a(3);
            }

    }

    public void a(jj jj1)
    {
        cn cn1 = jj1.b;
        if(cn1 == null)
        {
            jj1.f = true;
            jj1.e = true;
            return;
        }
        int i = jj1.c * 16;
        int j = jj1.d * 16;
        int k = i + 16;
        int l = j + 16;
        ga ga1 = cn1.b(jj1.c, jj1.d);
        if(ga1.q)
        {
            jj1.f = true;
            jj1.e = true;
            return;
        }
        jj1.f = false;
        Arrays.fill(c, 0);
        Arrays.fill(d, 0);
        Arrays.fill(f, 160);
        for(int i1 = l - 1; i1 >= j; i1--)
        {
            for(int j1 = k - 1; j1 >= i; j1--)
            {
                int k1 = j1 - i;
                int l1 = i1 - j;
                int i2 = k1 + l1;
                boolean flag = true;
                for(int j2 = 0; j2 < 128; j2++)
                {
                    int k2 = ((l1 - k1 - j2) + 160) - 16;
                    if(k2 >= f[i2] && k2 >= f[i2 + 1])
                        continue;
                    ly ly1 = ly.n[cn1.a(j1, j2, i1)];
                    if(ly1 == null)
                    {
                        flag = false;
                        continue;
                    }
                    if(ly1.bn == gb.f)
                    {
                        int l2 = cn1.a(j1, j2 + 1, i1);
                        if(l2 != 0 && ly.n[l2].bn == gb.f)
                            continue;
                        float f2 = ((float)j2 / 127F) * 0.6F + 0.4F;
                        float f3 = cn1.c(j1, j2 + 1, i1) * f2;
                        if(k2 < 0 || k2 >= 160)
                            continue;
                        int i4 = i2 + k2 * 32;
                        if(i2 >= 0 && i2 <= 32 && d[i4] <= j2)
                        {
                            d[i4] = j2;
                            e[i4] = (int)(f3 * 127F);
                        }
                        if(i2 >= -1 && i2 <= 31 && d[i4 + 1] <= j2)
                        {
                            d[i4 + 1] = j2;
                            e[i4 + 1] = (int)(f3 * 127F);
                        }
                        flag = false;
                        continue;
                    }
                    if(flag)
                    {
                        if(k2 < f[i2])
                            f[i2] = k2;
                        if(k2 < f[i2 + 1])
                            f[i2 + 1] = k2;
                    }
                    float f1 = ((float)j2 / 127F) * 0.6F + 0.4F;
                    if(k2 >= 0 && k2 < 160)
                    {
                        int i3 = i2 + k2 * 32;
                        int k3 = g[ly1.bc * 3 + 0];
                        float f4 = (cn1.c(j1, j2 + 1, i1) * 0.8F + 0.2F) * f1;
                        int j4 = k3;
                        if(i2 >= 0)
                        {
                            float f6 = f4;
                            if(c[i3] <= j2)
                            {
                                c[i3] = j2;
                                b[i3] = 0xff000000 | (int)(a[j4 * 3 + 0] * f6) << 16 | (int)(a[j4 * 3 + 1] * f6) << 8 | (int)(a[j4 * 3 + 2] * f6);
                            }
                        }
                        if(i2 < 31)
                        {
                            float f7 = f4 * 0.9F;
                            if(c[i3 + 1] <= j2)
                            {
                                c[i3 + 1] = j2;
                                b[i3 + 1] = 0xff000000 | (int)(a[j4 * 3 + 0] * f7) << 16 | (int)(a[j4 * 3 + 1] * f7) << 8 | (int)(a[j4 * 3 + 2] * f7);
                            }
                        }
                    }
                    if(k2 < -1 || k2 >= 159)
                        continue;
                    int j3 = i2 + (k2 + 1) * 32;
                    int l3 = g[ly1.bc * 3 + 1];
                    float f5 = cn1.c(j1 - 1, j2, i1) * 0.8F + 0.2F;
                    int k4 = g[ly1.bc * 3 + 2];
                    float f8 = cn1.c(j1, j2, i1 + 1) * 0.8F + 0.2F;
                    if(i2 >= 0)
                    {
                        float f9 = f5 * f1 * 0.6F;
                        if(c[j3] <= j2 - 1)
                        {
                            c[j3] = j2 - 1;
                            b[j3] = 0xff000000 | (int)(a[l3 * 3 + 0] * f9) << 16 | (int)(a[l3 * 3 + 1] * f9) << 8 | (int)(a[l3 * 3 + 2] * f9);
                        }
                    }
                    if(i2 >= 31)
                        continue;
                    float f10 = f8 * 0.9F * f1 * 0.4F;
                    if(c[j3 + 1] <= j2 - 1)
                    {
                        c[j3 + 1] = j2 - 1;
                        b[j3 + 1] = 0xff000000 | (int)(a[k4 * 3 + 0] * f10) << 16 | (int)(a[k4 * 3 + 1] * f10) << 8 | (int)(a[k4 * 3 + 2] * f10);
                    }
                }

            }

        }

        a();
        if(jj1.a == null)
            jj1.a = new BufferedImage(32, 160, 2);
        jj1.a.setRGB(0, 0, 32, 160, b, 0, 32);
        jj1.e = true;
    }

    private void a()
    {
        for(int i = 0; i < 32; i++)
        {
            for(int j = 0; j < 160; j++)
            {
                int k = i + j * 32;
                if(c[k] == 0)
                    b[k] = 0;
                if(d[k] <= c[k])
                    continue;
                int l = b[k] >> 24 & 0xff;
                b[k] = ((b[k] & 0xfefefe) >> 1) + e[k];
                if(l < 128)
                    b[k] = 0x80000000 + e[k] * 2;
                else
                    b[k] |= 0xff000000;
            }

        }

    }

    private float a[];
    private int b[];
    private int c[];
    private int d[];
    private int e[];
    private int f[];
    private int g[];
}
