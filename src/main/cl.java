package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class cl extends fo
{

    public cl()
    {
        a = new ip[5];
        a[0] = new ip(0, 8);
        a[1] = new ip(0, 0);
        a[2] = new ip(0, 0);
        a[3] = new ip(0, 0);
        a[4] = new ip(0, 0);
        byte byte0 = 24;
        byte byte1 = 6;
        byte byte2 = 20;
        byte byte3 = 4;
        a[0].a(-byte0 / 2, -byte2 / 2 + 2, -3F, ((int) (byte0)), byte2 - 4, 4, 0.0F);
        a[0].a(0.0F, 0 + byte3, 0.0F);
        a[1].a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, ((int) (byte1)), 2, 0.0F);
        a[1].a(-byte0 / 2 + 1, 0 + byte3, 0.0F);
        a[2].a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, ((int) (byte1)), 2, 0.0F);
        a[2].a(byte0 / 2 - 1, 0 + byte3, 0.0F);
        a[3].a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, ((int) (byte1)), 2, 0.0F);
        a[3].a(0.0F, 0 + byte3, -byte2 / 2 + 1);
        a[4].a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, ((int) (byte1)), 2, 0.0F);
        a[4].a(0.0F, 0 + byte3, byte2 / 2 - 1);
        a[0].d = 1.570796F;
        a[1].e = 4.712389F;
        a[2].e = 1.570796F;
        a[3].e = 3.141593F;
    }

    public void b(float f, float f1, float f2, float f3, float f4, float f5)
    {
        for(int i = 0; i < 5; i++)
            a[i].a(f5);

    }

    public void a(float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

    public ip a[];
}
