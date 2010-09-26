package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public class be
{

    public be()
    {
    }

    public boolean a()
    {
        return a && GLContext.getCapabilities().GL_ARB_occlusion_query;
    }

    private static boolean a = false;

}
