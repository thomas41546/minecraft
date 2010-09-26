package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class ml extends z
{

    public ml()
    {
        super(ly.B.bb);
        g = new float[256];
        h = new float[256];
        i = new float[256];
        j = new float[256];
        k = 0;
    }

    public void a()
    {
        k++;
        for(int l = 0; l < 16; l++)
        {
            for(int j1 = 0; j1 < 16; j1++)
            {
                float f = 0.0F;
                for(int i2 = l - 1; i2 <= l + 1; i2++)
                {
                    int j2 = i2 & 0xf;
                    int l2 = j1 & 0xf;
                    f += g[j2 + l2 * 16];
                }

                h[l + j1 * 16] = f / 3.3F + i[l + j1 * 16] * 0.8F;
            }

        }

        for(int i1 = 0; i1 < 16; i1++)
        {
            for(int k1 = 0; k1 < 16; k1++)
            {
                i[i1 + k1 * 16] += j[i1 + k1 * 16] * 0.05F;
                if(i[i1 + k1 * 16] < 0.0F)
                    i[i1 + k1 * 16] = 0.0F;
                j[i1 + k1 * 16] -= 0.1F;
                if(Math.random() < 0.050000000000000003D)
                    j[i1 + k1 * 16] = 0.5F;
            }

        }

        float af[] = h;
        h = g;
        g = af;
        for(int l1 = 0; l1 < 256; l1++)
        {
            float f1 = g[l1];
            if(f1 > 1.0F)
                f1 = 1.0F;
            if(f1 < 0.0F)
                f1 = 0.0F;
            float f2 = f1 * f1;
            int k2 = (int)(32F + f2 * 32F);
            int i3 = (int)(50F + f2 * 64F);
            int j3 = 255;
            int k3 = (int)(146F + f2 * 50F);
            if(c)
            {
                int l3 = (k2 * 30 + i3 * 59 + j3 * 11) / 100;
                int i4 = (k2 * 30 + i3 * 70) / 100;
                int j4 = (k2 * 30 + j3 * 70) / 100;
                k2 = l3;
                i3 = i4;
                j3 = j4;
            }
            a[l1 * 4 + 0] = (byte)k2;
            a[l1 * 4 + 1] = (byte)i3;
            a[l1 * 4 + 2] = (byte)j3;
            a[l1 * 4 + 3] = (byte)k3;
        }

    }

    protected float g[];
    protected float h[];
    protected float i[];
    protected float j[];
    private int k;
}
