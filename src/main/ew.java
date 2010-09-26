package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ew
{

    public ew()
    {
    }

    private static void a(Class class1, String s, int i)
    {
        a.put(((Object) (s)), ((Object) (class1)));
        b.put(((Object) (class1)), ((Object) (s)));
        c.put(((Object) (Integer.valueOf(i))), ((Object) (class1)));
        d.put(((Object) (class1)), ((Object) (Integer.valueOf(i))));
    }

    public static kh a(String s, cn cn1)
    {
        kh kh1 = null;
        try
        {
            Class class1 = (Class)a.get(((Object) (s)));
            if(class1 != null)
                kh1 = (kh)class1.getConstructor(new Class[] {
                    cn
                }).newInstance(new Object[] {
                    cn1
                });
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return kh1;
    }

    public static kh a(hm hm1, cn cn1)
    {
        kh kh1 = null;
        try
        {
            Class class1 = (Class)a.get(((Object) (hm1.i("id"))));
            if(class1 != null)
                kh1 = (kh)class1.getConstructor(new Class[] {
                    cn
                }).newInstance(new Object[] {
                    cn1
                });
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        if(kh1 != null)
            kh1.e(hm1);
        else
            System.out.println((new StringBuilder()).append("Skipping Entity with id ").append(hm1.i("id")).toString());
        return kh1;
    }

    public static kh a(int i, cn cn1)
    {
        kh kh1 = null;
        try
        {
            Class class1 = (Class)c.get(((Object) (Integer.valueOf(i))));
            if(class1 != null)
                kh1 = (kh)class1.getConstructor(new Class[] {
                    cn
                }).newInstance(new Object[] {
                    cn1
                });
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        if(kh1 == null)
            System.out.println((new StringBuilder()).append("Skipping Entity with id ").append(i).toString());
        return kh1;
    }

    public static int a(kh kh1)
    {
        return ((Integer)d.get(((Object) (((Object) (kh1)).getClass())))).intValue();
    }

    public static String b(kh kh1)
    {
        return (String)b.get(((Object) (((Object) (kh1)).getClass())));
    }

    private static Map a = new HashMap();
    private static Map b = new HashMap();
    private static Map c = new HashMap();
    private static Map d = new HashMap();

    static 
    {
        a(kg, "Arrow", 10);
        a(ao, "Snowball", 11);
        a(dx, "Item", 1);
        a(jc, "Painting", 9);
        a(ge, "Mob", 48);
        a(dq, "Monster", 49);
        a(dd, "Creeper", 50);
        a(cw, "Skeleton", 51);
        a(ax, "Spider", 52);
        a(hl, "Giant", 53);
        a(mb, "Zombie", 54);
        a(ma, "Slime", 55);
        a(mv, "Pig", 90);
        a(bo, "Sheep", 91);
        a(am, "Cow", 91);
        a(mz, "Chicken", 91);
        a(jd, "PrimedTnt", 20);
        a(ff, "FallingSand", 21);
        a(oc, "Minecart", 40);
        a(dc, "Boat", 41);
    }
}
