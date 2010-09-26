package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.Minecraft;

class nc extends Thread
{

    nc(mn mn1, Minecraft minecraft, String s, int i)
    {
        d = mn1;
        a = minecraft;
        b = s;
        c = i;
        super();
    }

    public void run()
    {
        mn.a(d, new gy(a, b, c));
        if(mn.a(d))
            return;
        try
        {
            mn.b(d).a(((fn) (new gt(a.i.b))));
        }
        catch(UnknownHostException unknownhostexception)
        {
            if(mn.a(d))
                return;
            a.a(((bh) (new cj("Failed to connect to the server", (new StringBuilder()).append("Unknown host '").append(b).append("'").toString()))));
        }
        catch(ConnectException connectexception)
        {
            if(mn.a(d))
                return;
            a.a(((bh) (new cj("Failed to connect to the server", connectexception.getMessage()))));
        }
        catch(Exception exception)
        {
            if(mn.a(d))
                return;
            exception.printStackTrace();
            a.a(((bh) (new cj("Failed to connect to the server", exception.toString()))));
        }
        return;
    }

    final Minecraft a;
    final String b;
    final int c;
    final mn d;
}
