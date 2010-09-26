package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class fn
{

    public fn()
    {
        j = false;
    }

    static void a(int i, Class class1)
    {
        if(a.containsKey(((Object) (Integer.valueOf(i)))))
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate packet id:").append(i).toString());
        if(b.containsKey(((Object) (class1))))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate packet class:").append(((Object) (class1))).toString());
        } else
        {
            a.put(((Object) (Integer.valueOf(i))), ((Object) (class1)));
            b.put(((Object) (class1)), ((Object) (Integer.valueOf(i))));
            return;
        }
    }

    public static fn a(int i)
    {
        Class class1 = (Class)a.get(((Object) (Integer.valueOf(i))));
        if(class1 == null)
            return null;
        return (fn)class1.newInstance();
        Exception exception;
        exception;
        exception.printStackTrace();
        System.out.println((new StringBuilder()).append("Skipping packet with id ").append(i).toString());
        return null;
    }

    public final int b()
    {
        return ((Integer)b.get(((Object) (((Object)this).getClass())))).intValue();
    }

    public static fn b(DataInputStream datainputstream)
    {
        int i = datainputstream.read();
        if(i == -1)
            return null;
        fn fn1 = a(i);
        if(fn1 == null)
        {
            throw new IOException((new StringBuilder()).append("Bad packet id ").append(i).toString());
        } else
        {
            fn1.a(datainputstream);
            return fn1;
        }
    }

    public static void a(fn fn1, DataOutputStream dataoutputstream)
    {
        dataoutputstream.write(fn1.b());
        fn1.a(dataoutputstream);
    }

    public abstract void a(DataInputStream datainputstream);

    public abstract void a(DataOutputStream dataoutputstream);

    public abstract void a(lb lb);

    public abstract int a();

    private static Map a = new HashMap();
    private static Map b = new HashMap();
    public boolean j;

    static 
    {
        a(0, gi);
        a(1, hp);
        a(2, gt);
        a(3, ij);
        a(4, du);
        a(5, m);
        a(6, ji);
        a(10, eh);
        a(11, s);
        a(12, mh);
        a(13, ch);
        a(14, fg);
        a(15, do);
        a(16, dz);
        a(17, ld);
        a(18, hf);
        a(20, gp);
        a(21, ha);
        a(22, bm);
        a(23, kj);
        a(24, ez);
        a(29, ju);
        a(30, lq);
        a(31, kp);
        a(32, jx);
        a(33, is);
        a(34, jl);
        a(50, ka);
        a(51, bz);
        a(52, na);
        a(53, li);
        a(59, ny);
        a(255, oh);
    }
}
