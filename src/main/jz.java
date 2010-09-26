package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class jz extends z
{

    public jz(int i)
    {
        super(ly.as.bb + i * 16);
        g = new float[320];
        h = new float[320];
    }

    public void a()
    {
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                int l = 18;
                float f1 = g[i + ((j + 1) % 20) * 16] * (float)l;
                for(int i1 = i - 1; i1 <= i + 1; i1++)
                {
                    for(int k1 = j; k1 <= j + 1; k1++)
                    {
                        int i2 = i1;
                        int k2 = k1;
                        if(i2 >= 0 && k2 >= 0 && i2 < 16 && k2 < 20)
                            f1 += g[i2 + k2 * 16];
                        l++;
                    }

                }

                h[i + j * 16] = f1 / ((float)l * 1.06F);
                if(j >= 19)
                    h[i + j * 16] = (float)(Math.random() * Math.random() * Math.random() * 4D + Math.random() * 0.10000000149011612D + 0.20000000298023224D);
            }

        }

        float af[] = h;
        h = g;
        g = af;
        for(int k = 0; k < 256; k++)
        {
            float f = g[k] * 1.8F;
            if(f > 1.0F)
                f = 1.0F;
            if(f < 0.0F)
                f = 0.0F;
            float f2 = f;
            int j1 = (int)(f2 * 155F + 100F);
            int l1 = (int)(f2 * f2 * 255F);
            int j2 = (int)(f2 * f2 * f2 * f2 * f2 * f2 * f2 * f2 * f2 * f2 * 255F);
            char c = '\377';
            if(f2 < 0.5F)
                c = '\0';
            f2 = (f2 - 0.5F) * 2.0F;
            if(this.c)
            {
                int l2 = (j1 * 30 + l1 * 59 + j2 * 11) / 100;
                int i3 = (j1 * 30 + l1 * 70) / 100;
                int j3 = (j1 * 30 + j2 * 70) / 100;
                j1 = l2;
                l1 = i3;
                j2 = j3;
            }
            a[k * 4 + 0] = (byte)j1;
            a[k * 4 + 1] = (byte)l1;
            a[k * 4 + 2] = (byte)j2;
            a[k * 4 + 3] = (byte)c;
        }

    }

    protected float g[];
    protected float h[];
}
