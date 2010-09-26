package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class at extends z
{

    public at()
    {
        super(ly.D.bb);
        g = new float[256];
        h = new float[256];
        i = new float[256];
        j = new float[256];
    }

    public void a()
    {
        for(int k = 0; k < 16; k++)
        {
            for(int l = 0; l < 16; l++)
            {
                float f = 0.0F;
                int j1 = (int)(eo.a(((float)l * 3.141593F * 2.0F) / 16F) * 1.2F);
                int k1 = (int)(eo.a(((float)k * 3.141593F * 2.0F) / 16F) * 1.2F);
                for(int i2 = k - 1; i2 <= k + 1; i2++)
                {
                    for(int k2 = l - 1; k2 <= l + 1; k2++)
                    {
                        int i3 = i2 + j1 & 0xf;
                        int k3 = k2 + k1 & 0xf;
                        f += g[i3 + k3 * 16];
                    }

                }

                h[k + l * 16] = f / 10F + ((i[(k + 0 & 0xf) + (l + 0 & 0xf) * 16] + i[(k + 1 & 0xf) + (l + 0 & 0xf) * 16] + i[(k + 1 & 0xf) + (l + 1 & 0xf) * 16] + i[(k + 0 & 0xf) + (l + 1 & 0xf) * 16]) / 4F) * 0.8F;
                i[k + l * 16] += j[k + l * 16] * 0.01F;
                if(i[k + l * 16] < 0.0F)
                    i[k + l * 16] = 0.0F;
                j[k + l * 16] -= 0.06F;
                if(Math.random() < 0.0050000000000000001D)
                    j[k + l * 16] = 1.5F;
            }

        }

        float af[] = h;
        h = g;
        g = af;
        for(int i1 = 0; i1 < 256; i1++)
        {
            float f1 = g[i1] * 2.0F;
            if(f1 > 1.0F)
                f1 = 1.0F;
            if(f1 < 0.0F)
                f1 = 0.0F;
            float f2 = f1;
            int l1 = (int)(f2 * 100F + 155F);
            int j2 = (int)(f2 * f2 * 255F);
            int l2 = (int)(f2 * f2 * f2 * f2 * 128F);
            if(c)
            {
                int j3 = (l1 * 30 + j2 * 59 + l2 * 11) / 100;
                int l3 = (l1 * 30 + j2 * 70) / 100;
                int i4 = (l1 * 30 + l2 * 70) / 100;
                l1 = j3;
                j2 = l3;
                l2 = i4;
            }
            a[i1 * 4 + 0] = (byte)l1;
            a[i1 * 4 + 1] = (byte)j2;
            a[i1 * 4 + 2] = (byte)l2;
            a[i1 * 4 + 3] = -1;
        }

    }

    protected float g[];
    protected float h[];
    protected float i[];
    protected float j[];
}
