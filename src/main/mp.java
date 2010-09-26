package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.Component;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;

public class mp
{

    public mp(Component component)
    {
        e = 10;
        c = component;
        IntBuffer intbuffer = df.c(1);
        intbuffer.put(0);
        intbuffer.flip();
        IntBuffer intbuffer1 = df.c(1024);
        try
        {
            d = new Cursor(32, 32, 16, 16, 1, intbuffer1, intbuffer);
        }
        catch(LWJGLException lwjglexception)
        {
            lwjglexception.printStackTrace();
        }
    }

    public void a()
    {
        Mouse.setGrabbed(true);
        a = 0;
        b = 0;
    }

    public void b()
    {
        Mouse.setCursorPosition(c.getWidth() / 2, c.getHeight() / 2);
        Mouse.setGrabbed(false);
    }

    public void c()
    {
        a = Mouse.getDX();
        b = Mouse.getDY();
    }

    private Component c;
    private Cursor d;
    public int a;
    public int b;
    private int e;
}
