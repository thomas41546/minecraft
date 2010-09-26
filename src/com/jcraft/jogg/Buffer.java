// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jogg;

import java.io.PrintStream;

public class Buffer
{

    public Buffer()
    {
        ptr = 0;
        buffer = null;
        endbit = 0;
        endbyte = 0;
        storage = 0;
    }

    public void writeinit()
    {
        buffer = new byte[256];
        ptr = 0;
        buffer[0] = 0;
        storage = 256;
    }

    public void write(byte abyte0[])
    {
        for(int i = 0; i < abyte0.length && abyte0[i] != 0; i++)
            write(((int) (abyte0[i])), 8);

    }

    public void read(byte abyte0[], int i)
    {
        int j = 0;
        while(i-- != 0) 
            abyte0[j++] = (byte)read(8);
    }

    void reset()
    {
        ptr = 0;
        buffer[0] = 0;
        endbit = endbyte = 0;
    }

    public void writeclear()
    {
        buffer = null;
    }

    public void readinit(byte abyte0[], int i)
    {
        readinit(abyte0, 0, i);
    }

    public void readinit(byte abyte0[], int i, int j)
    {
        ptr = i;
        buffer = abyte0;
        endbit = endbyte = 0;
        storage = j;
    }

    public void write(int i, int j)
    {
        if(endbyte + 4 >= storage)
        {
            byte abyte0[] = new byte[storage + 256];
            System.arraycopy(((Object) (buffer)), 0, ((Object) (abyte0)), 0, storage);
            buffer = abyte0;
            storage += 256;
        }
        i &= mask[j];
        j += endbit;
        buffer[ptr] |= (byte)(i << endbit);
        if(j >= 8)
        {
            buffer[ptr + 1] = (byte)(i >>> 8 - endbit);
            if(j >= 16)
            {
                buffer[ptr + 2] = (byte)(i >>> 16 - endbit);
                if(j >= 24)
                {
                    buffer[ptr + 3] = (byte)(i >>> 24 - endbit);
                    if(j >= 32)
                        if(endbit > 0)
                            buffer[ptr + 4] = (byte)(i >>> 32 - endbit);
                        else
                            buffer[ptr + 4] = 0;
                }
            }
        }
        endbyte += j / 8;
        ptr += j / 8;
        endbit = j & 7;
    }

    public int look(int i)
    {
        int k = mask[i];
        i += endbit;
        if(endbyte + 4 >= storage && endbyte + (i - 1) / 8 >= storage)
            return -1;
        int j = (buffer[ptr] & 0xff) >>> endbit;
        if(i > 8)
        {
            j |= (buffer[ptr + 1] & 0xff) << 8 - endbit;
            if(i > 16)
            {
                j |= (buffer[ptr + 2] & 0xff) << 16 - endbit;
                if(i > 24)
                {
                    j |= (buffer[ptr + 3] & 0xff) << 24 - endbit;
                    if(i > 32 && endbit != 0)
                        j |= (buffer[ptr + 4] & 0xff) << 32 - endbit;
                }
            }
        }
        return k & j;
    }

    public int look1()
    {
        if(endbyte >= storage)
            return -1;
        else
            return buffer[ptr] >> endbit & 1;
    }

    public void adv(int i)
    {
        i += endbit;
        ptr += i / 8;
        endbyte += i / 8;
        endbit = i & 7;
    }

    public void adv1()
    {
        endbit++;
        if(endbit > 7)
        {
            endbit = 0;
            ptr++;
            endbyte++;
        }
    }

    public int read(int i)
    {
        int k = mask[i];
        i += endbit;
        if(endbyte + 4 >= storage)
        {
            byte byte0 = -1;
            if(endbyte + (i - 1) / 8 >= storage)
            {
                ptr += i / 8;
                endbyte += i / 8;
                endbit = i & 7;
                return ((int) (byte0));
            }
        }
        int j = (buffer[ptr] & 0xff) >>> endbit;
        if(i > 8)
        {
            j |= (buffer[ptr + 1] & 0xff) << 8 - endbit;
            if(i > 16)
            {
                j |= (buffer[ptr + 2] & 0xff) << 16 - endbit;
                if(i > 24)
                {
                    j |= (buffer[ptr + 3] & 0xff) << 24 - endbit;
                    if(i > 32 && endbit != 0)
                        j |= (buffer[ptr + 4] & 0xff) << 32 - endbit;
                }
            }
        }
        j &= k;
        ptr += i / 8;
        endbyte += i / 8;
        endbit = i & 7;
        return j;
    }

    public int readB(int i)
    {
        int k = 32 - i;
        i += endbit;
        if(endbyte + 4 >= storage)
        {
            byte byte0 = -1;
            if(endbyte * 8 + i > storage * 8)
            {
                ptr += i / 8;
                endbyte += i / 8;
                endbit = i & 7;
                return ((int) (byte0));
            }
        }
        int j = (buffer[ptr] & 0xff) << 24 + endbit;
        if(i > 8)
        {
            j |= (buffer[ptr + 1] & 0xff) << 16 + endbit;
            if(i > 16)
            {
                j |= (buffer[ptr + 2] & 0xff) << 8 + endbit;
                if(i > 24)
                {
                    j |= (buffer[ptr + 3] & 0xff) << endbit;
                    if(i > 32 && endbit != 0)
                        j |= (buffer[ptr + 4] & 0xff) >> 8 - endbit;
                }
            }
        }
        j = j >>> (k >> 1) >>> (k + 1 >> 1);
        ptr += i / 8;
        endbyte += i / 8;
        endbit = i & 7;
        return j;
    }

    public int read1()
    {
        if(endbyte >= storage)
        {
            byte byte0 = -1;
            endbit++;
            if(endbit > 7)
            {
                endbit = 0;
                ptr++;
                endbyte++;
            }
            return ((int) (byte0));
        }
        int i = buffer[ptr] >> endbit & 1;
        endbit++;
        if(endbit > 7)
        {
            endbit = 0;
            ptr++;
            endbyte++;
        }
        return i;
    }

    public int bytes()
    {
        return endbyte + (endbit + 7) / 8;
    }

    public int bits()
    {
        return endbyte * 8 + endbit;
    }

    public byte[] buffer()
    {
        return buffer;
    }

    public static int ilog(int i)
    {
        int j = 0;
        for(; i > 0; i >>>= 1)
            j++;

        return j;
    }

    public static void report(String s)
    {
        System.err.println(s);
        System.exit(1);
    }

    private static final int BUFFER_INCREMENT = 256;
    private static final int mask[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    int ptr;
    byte buffer[];
    int endbit;
    int endbyte;
    int storage;

}
