// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;
import com.jcraft.jogg.Packet;

public class Comment
{

    public Comment()
    {
    }

    public void init()
    {
        user_comments = (byte[][])null;
        comments = 0;
        vendor = null;
    }

    public void add(String s)
    {
        add(s.getBytes());
    }

    private void add(byte abyte0[])
    {
        byte abyte1[][] = new byte[comments + 2][];
        if(user_comments != null)
            System.arraycopy(((Object) (user_comments)), 0, ((Object) (abyte1)), 0, comments);
        user_comments = abyte1;
        int ai[] = new int[comments + 2];
        if(comment_lengths != null)
            System.arraycopy(((Object) (comment_lengths)), 0, ((Object) (ai)), 0, comments);
        comment_lengths = ai;
        byte abyte2[] = new byte[abyte0.length + 1];
        System.arraycopy(((Object) (abyte0)), 0, ((Object) (abyte2)), 0, abyte0.length);
        user_comments[comments] = abyte2;
        comment_lengths[comments] = abyte0.length;
        comments++;
        user_comments[comments] = null;
    }

    public void add_tag(String s, String s1)
    {
        if(s1 == null)
            s1 = "";
        add((new StringBuilder()).append(s).append("=").append(s1).toString());
    }

    static boolean tagcompare(byte abyte0[], byte abyte1[], int i)
    {
        for(int j = 0; j < i; j++)
        {
            byte byte0 = abyte0[j];
            byte byte1 = abyte1[j];
            if(90 >= byte0 && byte0 >= 65)
                byte0 = (byte)((byte0 - 65) + 97);
            if(90 >= byte1 && byte1 >= 65)
                byte1 = (byte)((byte1 - 65) + 97);
            if(byte0 != byte1)
                return false;
        }

        return true;
    }

    public String query(String s)
    {
        return query(s, 0);
    }

    public String query(String s, int i)
    {
        int j = query(s.getBytes(), i);
        if(j == -1)
            return null;
        byte abyte0[] = user_comments[j];
        for(int k = 0; k < comment_lengths[j]; k++)
            if(abyte0[k] == 61)
                return new String(abyte0, k + 1, comment_lengths[j] - (k + 1));

        return null;
    }

    private int query(byte abyte0[], int i)
    {
        boolean flag = false;
        int k = 0;
        int l = abyte0.length + 1;
        byte abyte1[] = new byte[l];
        System.arraycopy(((Object) (abyte0)), 0, ((Object) (abyte1)), 0, abyte0.length);
        abyte1[abyte0.length] = 61;
        for(int j = 0; j < comments; j++)
        {
            if(!tagcompare(user_comments[j], abyte1, l))
                continue;
            if(i == k)
                return j;
            k++;
        }

        return -1;
    }

    int unpack(Buffer buffer)
    {
        int i = buffer.read(32);
        if(i < 0)
        {
            clear();
            return -1;
        }
        vendor = new byte[i + 1];
        buffer.read(vendor, i);
        comments = buffer.read(32);
        if(comments < 0)
        {
            clear();
            return -1;
        }
        user_comments = new byte[comments + 1][];
        comment_lengths = new int[comments + 1];
        for(int j = 0; j < comments; j++)
        {
            int k = buffer.read(32);
            if(k < 0)
            {
                clear();
                return -1;
            }
            comment_lengths[j] = k;
            user_comments[j] = new byte[k + 1];
            buffer.read(user_comments[j], k);
        }

        if(buffer.read(1) != 1)
        {
            clear();
            return -1;
        } else
        {
            return 0;
        }
    }

    int pack(Buffer buffer)
    {
        buffer.write(3, 8);
        buffer.write(_vorbis);
        buffer.write(_vendor.length, 32);
        buffer.write(_vendor);
        buffer.write(comments, 32);
        if(comments != 0)
        {
            for(int i = 0; i < comments; i++)
                if(user_comments[i] != null)
                {
                    buffer.write(comment_lengths[i], 32);
                    buffer.write(user_comments[i]);
                } else
                {
                    buffer.write(0, 32);
                }

        }
        buffer.write(1, 1);
        return 0;
    }

    public int header_out(Packet packet)
    {
        Buffer buffer = new Buffer();
        buffer.writeinit();
        if(pack(buffer) != 0)
        {
            return -130;
        } else
        {
            packet.packet_base = new byte[buffer.bytes()];
            packet.packet = 0;
            packet.bytes = buffer.bytes();
            System.arraycopy(((Object) (buffer.buffer())), 0, ((Object) (packet.packet_base)), 0, packet.bytes);
            packet.b_o_s = 0;
            packet.e_o_s = 0;
            packet.granulepos = 0L;
            return 0;
        }
    }

    void clear()
    {
        for(int i = 0; i < comments; i++)
            user_comments[i] = null;

        user_comments = (byte[][])null;
        vendor = null;
    }

    public String getVendor()
    {
        return new String(vendor, 0, vendor.length - 1);
    }

    public String getComment(int i)
    {
        if(comments <= i)
            return null;
        else
            return new String(user_comments[i], 0, user_comments[i].length - 1);
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("Vendor: ").append(new String(vendor, 0, vendor.length - 1)).toString();
        for(int i = 0; i < comments; i++)
            s = (new StringBuilder()).append(s).append("\nComment: ").append(new String(user_comments[i], 0, user_comments[i].length - 1)).toString();

        s = (new StringBuilder()).append(s).append("\n").toString();
        return s;
    }

    private static byte _vorbis[] = "vorbis".getBytes();
    private static byte _vendor[] = "Xiphophorus libVorbis I 20000508".getBytes();
    private static final int OV_EIMPL = -130;
    public byte user_comments[][];
    public int comment_lengths[];
    public int comments;
    public byte vendor[];

}
