// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jogg;


public class Page
{

    public Page()
    {
    }

    private static int crc_entry(int i)
    {
        int j = i << 24;
        for(int k = 0; k < 8; k++)
            if((j & 0x80000000) != 0)
                j = j << 1 ^ 0x4c11db7;
            else
                j <<= 1;

        return j & -1;
    }

    int version()
    {
        return header_base[header + 4] & 0xff;
    }

    int continued()
    {
        return header_base[header + 5] & 1;
    }

    public int bos()
    {
        return header_base[header + 5] & 2;
    }

    public int eos()
    {
        return header_base[header + 5] & 4;
    }

    public long granulepos()
    {
        long l = header_base[header + 13] & 0xff;
        l = l << 8 | (long)(header_base[header + 12] & 0xff);
        l = l << 8 | (long)(header_base[header + 11] & 0xff);
        l = l << 8 | (long)(header_base[header + 10] & 0xff);
        l = l << 8 | (long)(header_base[header + 9] & 0xff);
        l = l << 8 | (long)(header_base[header + 8] & 0xff);
        l = l << 8 | (long)(header_base[header + 7] & 0xff);
        l = l << 8 | (long)(header_base[header + 6] & 0xff);
        return l;
    }

    public int serialno()
    {
        return header_base[header + 14] & 0xff | (header_base[header + 15] & 0xff) << 8 | (header_base[header + 16] & 0xff) << 16 | (header_base[header + 17] & 0xff) << 24;
    }

    int pageno()
    {
        return header_base[header + 18] & 0xff | (header_base[header + 19] & 0xff) << 8 | (header_base[header + 20] & 0xff) << 16 | (header_base[header + 21] & 0xff) << 24;
    }

    void checksum()
    {
        int i = 0;
        for(int j = 0; j < header_len; j++)
            i = i << 8 ^ crc_lookup[i >>> 24 & 0xff ^ header_base[header + j] & 0xff];

        for(int k = 0; k < body_len; k++)
            i = i << 8 ^ crc_lookup[i >>> 24 & 0xff ^ body_base[body + k] & 0xff];

        header_base[header + 22] = (byte)i;
        header_base[header + 23] = (byte)(i >>> 8);
        header_base[header + 24] = (byte)(i >>> 16);
        header_base[header + 25] = (byte)(i >>> 24);
    }

    public Page copy()
    {
        return copy(new Page());
    }

    public Page copy(Page page)
    {
        byte abyte0[] = new byte[header_len];
        System.arraycopy(((Object) (header_base)), header, ((Object) (abyte0)), 0, header_len);
        page.header_len = header_len;
        page.header_base = abyte0;
        page.header = 0;
        abyte0 = new byte[body_len];
        System.arraycopy(((Object) (body_base)), body, ((Object) (abyte0)), 0, body_len);
        page.body_len = body_len;
        page.body_base = abyte0;
        page.body = 0;
        return page;
    }

    private static int crc_lookup[];
    public byte header_base[];
    public int header;
    public int header_len;
    public byte body_base[];
    public int body;
    public int body_len;

    static 
    {
        crc_lookup = new int[256];
        for(int i = 0; i < crc_lookup.length; i++)
            crc_lookup[i] = crc_entry(i);

    }
}
