package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


class mx
{

    mx(int i, int j, Object obj, mx mx1)
    {
        b = obj;
        c = mx1;
        a = j;
        d = i;
    }

    public final int a()
    {
        return a;
    }

    public final Object b()
    {
        return b;
    }

    public final boolean equals(Object obj)
    {
        if(!(obj instanceof mx))
            return false;
        mx mx1 = (mx)obj;
        Integer integer = Integer.valueOf(a());
        Integer integer1 = Integer.valueOf(mx1.a());
        if(integer == integer1 || integer != null && ((Object) (integer)).equals(((Object) (integer1))))
        {
            Object obj1 = b();
            Object obj2 = mx1.b();
            if(obj1 == obj2 || obj1 != null && obj1.equals(obj2))
                return true;
        }
        return false;
    }

    public final int hashCode()
    {
        return fi.d(a);
    }

    public final String toString()
    {
        return (new StringBuilder()).append(a()).append("=").append(b()).toString();
    }

    final int a;
    Object b;
    mx c;
    final int d;
}
