package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

class hk extends InputStream
{

    public hk(ep ep1, URL url, InputStream inputstream)
    {
        b = ep1;
        super();
        a = new byte[1];
        d = inputstream;
        String s = url.getPath();
        s = s.substring(s.lastIndexOf("/") + 1);
        c = s.hashCode();
    }

    public int read()
    {
        int i = read(a, 0, 1);
        if(i < 0)
            return i;
        else
            return ((int) (a[0]));
    }

    public int read(byte abyte0[], int i, int j)
    {
        j = d.read(abyte0, i, j);
        for(int k = 0; k < j; k++)
        {
            byte byte0 = abyte0[i + k] ^= ((byte) (c >> 8));
            c = c * 0x1dba038f + 0x14ee3 * byte0;
        }

        return j;
    }

    private int c;
    private InputStream d;
    byte a[];
    final ep b;
}
