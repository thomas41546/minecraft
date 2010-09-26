// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package net.minecraft.client;

import dl;
import g;
import h;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.io.PrintStream;
import java.net.URL;

// Referenced classes of package net.minecraft.client:
//            Minecraft

public class MinecraftApplet extends Applet
{

    public MinecraftApplet()
    {
        c = null;
    }

    public void init()
    {
        a = ((Canvas) (new h(this)));
        boolean flag = false;
        if(getParameter("fullscreen") != null)
            flag = getParameter("fullscreen").equalsIgnoreCase("true");
        b = ((Minecraft) (new g(this, ((java.awt.Component) (this)), a, this, getWidth(), getHeight(), flag)));
        b.j = getDocumentBase().getHost();
        if(getDocumentBase().getPort() <= 0) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        b;
        JVM INSTR dup_x1 ;
        j;
        append();
        ":";
        append();
        getDocumentBase().getPort();
        append();
        toString();
        j;
_L2:
        if(getParameter("username") != null && getParameter("sessionid") != null)
        {
            b.i = new dl(getParameter("username"), getParameter("sessionid"));
            System.out.println((new StringBuilder()).append("Setting user: ").append(b.i.b).append(", ").append(b.i.c).toString());
            if(getParameter("mppass") != null)
                b.i.d = getParameter("mppass");
        } else
        {
            b.i = new dl("Player", "");
        }
        if(getParameter("loadmap_user") != null && getParameter("loadmap_id") != null)
        {
            b.s = getParameter("loadmap_user");
            b.t = Integer.parseInt(getParameter("loadmap_id"));
        } else
        if(getParameter("server") != null && getParameter("port") != null)
            b.a(getParameter("server"), Integer.parseInt(getParameter("port")));
        b.l = true;
        setLayout(((java.awt.LayoutManager) (new BorderLayout())));
        add(((java.awt.Component) (a)), "Center");
        a.setFocusable(true);
        validate();
        return;
    }

    public void a()
    {
        if(c != null)
        {
            return;
        } else
        {
            c = new Thread(((Runnable) (b)), "Minecraft main thread");
            c.start();
            return;
        }
    }

    public void start()
    {
        if(b != null)
            b.m = false;
    }

    public void stop()
    {
        if(b != null)
            b.m = true;
    }

    public void destroy()
    {
        b();
    }

    public void b()
    {
        if(c == null)
            return;
        b.d();
        try
        {
            c.join(10000L);
        }
        catch(InterruptedException interruptedexception)
        {
            try
            {
                b.c();
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        c = null;
    }

    public void c()
    {
        a = null;
        b = null;
        c = null;
        try
        {
            removeAll();
            validate();
        }
        catch(Exception exception) { }
    }

    private Canvas a;
    private Minecraft b;
    private Thread c;
}
