package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class nd
{

    public nd()
    {
        b = (new Object[][] {
            new Object[] {
                ly.y, ly.x, di.m, di.l, di.n
            }, new Object[] {
                di.p, di.t, di.o, di.x, di.E
            }
        });
    }

    public void a(dw dw1)
    {
        for(int i = 0; i < b[0].length; i++)
        {
            Object obj = b[0][i];
            for(int j = 0; j < b.length - 1; j++)
            {
                di di1 = (di)b[j + 1][i];
                dw1.a(new ev(di1), new Object[] {
                    a[j], Character.valueOf('#'), di.B, Character.valueOf('X'), obj
                });
            }

        }

        dw1.a(new ev(di.i, 1), new Object[] {
            " #X", "# X", " #X", Character.valueOf('X'), di.I, Character.valueOf('#'), di.B
        });
        dw1.a(new ev(di.j, 4), new Object[] {
            "X", "#", "Y", Character.valueOf('Y'), di.J, Character.valueOf('X'), di.an, Character.valueOf('#'), di.B
        });
    }

    private String a[][] = {
        {
            "X", "X", "#"
        }
    };
    private Object b[][];
}
