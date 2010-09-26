// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jogg;


public class Packet
{

    public Packet()
    {
    }

    public byte packet_base[];
    public int packet;
    public int bytes;
    public int b_o_s;
    public int e_o_s;
    public long granulepos;
    public long packetno;
}
