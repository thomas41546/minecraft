package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.*;

public class eb
{

    public eb()
    {
        c = new Random();
        d = ((Map) (new HashMap()));
        e = ((List) (new ArrayList()));
        a = 0;
        b = true;
    }

    public ah a(String s, File file)
    {
        ah ah1;
        String s1 = s;
        s = s.substring(0, s.indexOf("."));
        if(b)
            for(; Character.isDigit(s.charAt(s.length() - 1)); s = s.substring(0, s.length() - 1));
        s = s.replaceAll("/", ".");
        if(!d.containsKey(((Object) (s))))
            d.put(((Object) (s)), ((Object) (new ArrayList())));
        ah1 = new ah(s1, file.toURI().toURL());
        ((List)d.get(((Object) (s)))).add(((Object) (ah1)));
        e.add(((Object) (ah1)));
        a++;
        return ah1;
        MalformedURLException malformedurlexception;
        malformedurlexception;
        malformedurlexception.printStackTrace();
        throw new RuntimeException(((Throwable) (malformedurlexception)));
    }

    public ah a(String s)
    {
        List list = (List)d.get(((Object) (s)));
        if(list == null)
            return null;
        else
            return (ah)list.get(c.nextInt(list.size()));
    }

    public ah a()
    {
        if(e.size() == 0)
            return null;
        else
            return (ah)e.get(c.nextInt(e.size()));
    }

    private Random c;
    private Map d;
    private List e;
    public int a;
    public boolean b;
}
