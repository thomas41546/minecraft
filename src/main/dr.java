package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class dr
{

    public dr()
    {
        b = (new Object[][] {
            new Object[] {
                ly.y, ly.x, di.m, di.l, di.n
            }, new Object[] {
                di.r, di.v, di.e, di.z, di.G
            }, new Object[] {
                di.q, di.u, di.d, di.y, di.F
            }, new Object[] {
                di.s, di.w, di.f, di.A, di.H
            }, new Object[] {
                di.L, di.M, di.N, di.O, di.P
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

    }

    private String a[][] = {
        {
            "XXX", " # ", " # "
        }, {
            "X", "#", "#"
        }, {
            "XX", "X#", " #"
        }, {
            "XX", " #", " #"
        }
    };
    private Object b[][];
}
