package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class eg extends z
{

    public eg()
    {
        super(ly.D.bb + 1);
        g = new float[256];
        h = new float[256];
        i = new float[256];
        j = new float[256];
        k = 0;
        e = 2;
    }

    public void a()
    {
        k++;
        for(int l = 0; l < 16; l++)
        {
            for(int i1 = 0; i1 < 16; i1++)
            {
                float f = 0.0F;
                int k1 = (int)(eo.a(((float)i1 * 3.141593F * 2.0F) / 16F) * 1.2F);
                int l1 = (int)(eo.a(((float)l * 3.141593F * 2.0F) / 16F) * 1.2F);
                for(int j2 = l - 1; j2 <= l + 1; j2++)
                {
                    for(int l2 = i1 - 1; l2 <= i1 + 1; l2++)
                    {
                        int j3 = j2 + k1 & 0xf;
                        int l3 = l2 + l1 & 0xf;
                        f += g[j3 + l3 * 16];
                    }

                }

                h[l + i1 * 16] = f / 10F + ((i[(l + 0 & 0xf) + (i1 + 0 & 0xf) * 16] + i[(l + 1 & 0xf) + (i1 + 0 & 0xf) * 16] + i[(l + 1 & 0xf) + (i1 + 1 & 0xf) * 16] + i[(l + 0 & 0xf) + (i1 + 1 & 0xf) * 16]) / 4F) * 0.8F;
                i[l + i1 * 16] += j[l + i1 * 16] * 0.01F;
                if(i[l + i1 * 16] < 0.0F)
                    i[l + i1 * 16] = 0.0F;
                j[l + i1 * 16] -= 0.06F;
                if(Math.random() < 0.0050000000000000001D)
                    j[l + i1 * 16] = 1.5F;
            }

        }

        float af[] = h;
        h = g;
        g = af;
        for(int j1 = 0; j1 < 256; j1++)
        {
            float f1 = g[j1 - (k / 3) * 16 & 0xff] * 2.0F;
            if(f1 > 1.0F)
                f1 = 1.0F;
            if(f1 < 0.0F)
                f1 = 0.0F;
            float f2 = f1;
            int i2 = (int)(f2 * 100F + 155F);
            int k2 = (int)(f2 * f2 * 255F);
            int i3 = (int)(f2 * f2 * f2 * f2 * 128F);
            if(c)
            {
                int k3 = (i2 * 30 + k2 * 59 + i3 * 11) / 100;
                int i4 = (i2 * 30 + k2 * 70) / 100;
                int j4 = (i2 * 30 + i3 * 70) / 100;
                i2 = k3;
                k2 = i4;
                i3 = j4;
            }
            a[j1 * 4 + 0] = (byte)i2;
            a[j1 * 4 + 1] = (byte)k2;
            a[j1 * 4 + 2] = (byte)i3;
            a[j1 * 4 + 3] = -1;
        }

    }

    protected float g[];
    protected float h[];
    protected float i[];
    protected float j[];
    int k;
}
