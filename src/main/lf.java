package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public class lf
{

    public lf()
    {
        a = (new Object[][] {
            new Object[] {
                ly.ai, di.n
            }, new Object[] {
                ly.aj, di.m
            }, new Object[] {
                ly.ay, di.l
            }
        });
    }

    public void a(dw dw1)
    {
        for(int i = 0; i < a.length; i++)
        {
            ly ly1 = (ly)a[i][0];
            di di1 = (di)a[i][1];
            dw1.a(new ev(ly1), new Object[] {
                "###", "###", "###", Character.valueOf('#'), di1
            });
            dw1.a(new ev(di1, 9), new Object[] {
                "#", Character.valueOf('#'), ly1
            });
        }

    }

    private Object a[][];
}
