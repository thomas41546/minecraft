package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class l
{

    public l()
    {
        b = (new Object[][] {
            new Object[] {
                di.aD, ly.as, di.m, di.l, di.n
            }, new Object[] {
                di.T, di.X, di.ab, di.af, di.aj
            }, new Object[] {
                di.U, di.Y, di.ac, di.ag, di.ak
            }, new Object[] {
                di.V, di.Z, di.ad, di.ah, di.al
            }, new Object[] {
                di.W, di.aa, di.ae, di.ai, di.am
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
                    a[j], Character.valueOf('X'), obj
                });
            }

        }

    }

    private String a[][] = {
        {
            "XXX", "X X"
        }, {
            "X X", "XXX", "XXX"
        }, {
            "XXX", "X X", "X X"
        }, {
            "X X", "X X"
        }
    };
    private Object b[][];
}
