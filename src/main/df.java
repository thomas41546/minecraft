package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.nio.*;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class df
{

    public df()
    {
    }

    public static synchronized int a(int i)
    {
        int j = GL11.glGenLists(i);
        a.add(((Object) (Integer.valueOf(j))));
        a.add(((Object) (Integer.valueOf(i))));
        return j;
    }

    public static synchronized void a(IntBuffer intbuffer)
    {
        GL11.glGenTextures(intbuffer);
        for(int i = intbuffer.position(); i < intbuffer.limit(); i++)
            b.add(((Object) (Integer.valueOf(intbuffer.get(i)))));

    }

    public static synchronized void a()
    {
        for(int i = 0; i < a.size(); i += 2)
            GL11.glDeleteLists(((Integer)a.get(i)).intValue(), ((Integer)a.get(i + 1)).intValue());

        IntBuffer intbuffer = c(b.size());
        intbuffer.flip();
        GL11.glDeleteTextures(intbuffer);
        for(int j = 0; j < b.size(); j++)
            intbuffer.put(((Integer)b.get(j)).intValue());

        intbuffer.flip();
        GL11.glDeleteTextures(intbuffer);
        a.clear();
        b.clear();
    }

    public static synchronized ByteBuffer b(int i)
    {
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        return bytebuffer;
    }

    public static IntBuffer c(int i)
    {
        return b(i << 2).asIntBuffer();
    }

    public static FloatBuffer d(int i)
    {
        return b(i << 2).asFloatBuffer();
    }

    private static List a = new ArrayList();
    private static List b = new ArrayList();

}
