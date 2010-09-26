package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class ll
{

    public ll(ed aed[])
    {
        b = 0;
        c = false;
        a = aed;
        b = aed.length;
    }

    public ll(ed aed[], int i, int j, int k, int l)
    {
        this(aed);
        float f = 0.0015625F;
        float f1 = 0.003125F;
        aed[0] = aed[0].a((float)k / 64F - f, (float)j / 32F + f1);
        aed[1] = aed[1].a((float)i / 64F + f, (float)j / 32F + f1);
        aed[2] = aed[2].a((float)i / 64F + f, (float)l / 32F - f1);
        aed[3] = aed[3].a((float)k / 64F - f, (float)l / 32F - f1);
    }

    public void a()
    {
        ed aed[] = new ed[a.length];
        for(int i = 0; i < a.length; i++)
            aed[i] = a[a.length - i - 1];

        a = aed;
    }

    public void a(ho ho1, float f)
    {
        aj aj1 = a[1].a.a(a[0].a);
        aj aj2 = a[1].a.a(a[2].a);
        aj aj3 = aj2.b(aj1).b();
        ho1.b();
        if(c)
            ho1.b(-(float)aj3.a, -(float)aj3.b, -(float)aj3.c);
        else
            ho1.b((float)aj3.a, (float)aj3.b, (float)aj3.c);
        for(int i = 0; i < 4; i++)
        {
            ed ed1 = a[i];
            ho1.a((float)ed1.a.a * f, (float)ed1.a.b * f, (float)ed1.a.c * f, ed1.b, ed1.c);
        }

        ho1.a();
    }

    public ed a[];
    public int b;
    private boolean c;
}
