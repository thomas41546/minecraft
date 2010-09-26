package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class ob extends ic
{

    public ob()
    {
        b = -1;
    }

    public void b(hm hm1)
    {
        super.b(hm1);
        hm1.a("Text1", a[0]);
        hm1.a("Text2", a[1]);
        hm1.a("Text3", a[2]);
        hm1.a("Text4", a[3]);
    }

    public void a(hm hm1)
    {
        super.a(hm1);
        for(int i = 0; i < 4; i++)
        {
            a[i] = hm1.i((new StringBuilder()).append("Text").append(i + 1).toString());
            if(a[i].length() > 15)
                a[i] = a[i].substring(0, 15);
        }

    }

    public String a[] = {
        "", "", "", ""
    };
    public int b;
}
