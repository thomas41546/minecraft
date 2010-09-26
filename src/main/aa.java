package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;

public class aa extends z
{

    public aa(Minecraft minecraft)
    {
        super(di.aO.a(((ev) (null))));
        g = new float[320];
        h = new float[320];
        j = new int[256];
        i = minecraft;
        f = 1;
        try
        {
            BufferedImage bufferedimage = ImageIO.read(((Class) (net/minecraft/client/Minecraft)).getResource("/gui/items.png"));
            int i1 = (b % 16) * 16;
            int j1 = (b / 16) * 16;
            bufferedimage.getRGB(i1, j1, 16, 16, j, 0, 16);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void a()
    {
        for(int i1 = 0; i1 < 256; i1++)
        {
            int j1 = j[i1] >> 24 & 0xff;
            int k1 = j[i1] >> 16 & 0xff;
            int l1 = j[i1] >> 8 & 0xff;
            int i2 = j[i1] >> 0 & 0xff;
            if(this.c)
            {
                int j2 = (k1 * 30 + l1 * 59 + i2 * 11) / 100;
                int k2 = (k1 * 30 + l1 * 70) / 100;
                int l2 = (k1 * 30 + i2 * 70) / 100;
                k1 = j2;
                l1 = k2;
                i2 = l2;
            }
            a[i1 * 4 + 0] = (byte)k1;
            a[i1 * 4 + 1] = (byte)l1;
            a[i1 * 4 + 2] = (byte)i2;
            a[i1 * 4 + 3] = (byte)j1;
        }

        double d = 0.0D;
        if(i.e != null && i.g != null)
        {
            double d1 = (double)i.e.o - i.g.ak;
            double d3 = (double)i.e.q - i.g.am;
            d = ((double)(i.g.aq - 90F) * 3.1415926535897931D) / 180D - Math.atan2(d3, d1);
        }
        double d2;
        for(d2 = d - k; d2 < -3.1415926535897931D; d2 += 6.2831853071795862D);
        for(; d2 >= 3.1415926535897931D; d2 -= 6.2831853071795862D);
        if(d2 < -1D)
            d2 = -1D;
        if(d2 > 1.0D)
            d2 = 1.0D;
        l += d2 * 0.10000000000000001D;
        l *= 0.80000000000000004D;
        k += l;
        double d4 = Math.sin(k);
        double d5 = Math.cos(k);
        for(int i3 = -4; i3 <= 4; i3++)
        {
            int k3 = (int)(8.5D + d5 * (double)i3 * 0.29999999999999999D);
            int i4 = (int)(7.5D - d4 * (double)i3 * 0.29999999999999999D * 0.5D);
            int k4 = i4 * 16 + k3;
            int i5 = 100;
            int k5 = 100;
            int i6 = 100;
            char c = '\377';
            if(this.c)
            {
                int k6 = (i5 * 30 + k5 * 59 + i6 * 11) / 100;
                int i7 = (i5 * 30 + k5 * 70) / 100;
                int k7 = (i5 * 30 + i6 * 70) / 100;
                i5 = k6;
                k5 = i7;
                i6 = k7;
            }
            a[k4 * 4 + 0] = (byte)i5;
            a[k4 * 4 + 1] = (byte)k5;
            a[k4 * 4 + 2] = (byte)i6;
            a[k4 * 4 + 3] = (byte)c;
        }

        for(int j3 = -8; j3 <= 16; j3++)
        {
            int l3 = (int)(8.5D + d4 * (double)j3 * 0.29999999999999999D);
            int j4 = (int)(7.5D + d5 * (double)j3 * 0.29999999999999999D * 0.5D);
            int l4 = j4 * 16 + l3;
            int j5 = ((int) (j3 < 0 ? 100 : 255));
            int l5 = ((int) (j3 < 0 ? 100 : 20));
            int j6 = ((int) (j3 < 0 ? 100 : 20));
            char c1 = '\377';
            if(this.c)
            {
                int l6 = (j5 * 30 + l5 * 59 + j6 * 11) / 100;
                int j7 = (j5 * 30 + l5 * 70) / 100;
                int l7 = (j5 * 30 + j6 * 70) / 100;
                j5 = l6;
                l5 = j7;
                j6 = l7;
            }
            a[l4 * 4 + 0] = (byte)j5;
            a[l4 * 4 + 1] = (byte)l5;
            a[l4 * 4 + 2] = (byte)j6;
            a[l4 * 4 + 3] = (byte)c1;
        }

    }

    protected float g[];
    protected float h[];
    private Minecraft i;
    private int j[];
    private double k;
    private double l;
}
