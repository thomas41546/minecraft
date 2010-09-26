package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.PrintStream;
import java.util.*;

public class dw
{

    public static final dw a()
    {
        return a;
    }

    private dw()
    {
        b = ((List) (new ArrayList()));
        (new dr()).a(this);
        (new nd()).a(this);
        (new lf()).a(this);
        (new hr()).a(this);
        (new fj()).a(this);
        (new l()).a(this);
        a(new ev(di.aI, 3), new Object[] {
            "###", Character.valueOf('#'), di.aH
        });
        a(new ev(di.aJ, 1), new Object[] {
            "#", "#", "#", Character.valueOf('#'), di.aI
        });
        a(new ev(ly.ba, 2), new Object[] {
            "###", "###", Character.valueOf('#'), di.B
        });
        a(new ev(ly.aZ, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), ly.y, Character.valueOf('X'), di.l
        });
        a(new ev(ly.ao, 1), new Object[] {
            "###", "XXX", "###", Character.valueOf('#'), ly.y, Character.valueOf('X'), di.aJ
        });
        a(new ev(ly.aV, 1), new Object[] {
            "##", "##", Character.valueOf('#'), di.aB
        });
        a(new ev(ly.aX, 1), new Object[] {
            "##", "##", Character.valueOf('#'), di.aG
        });
        a(new ev(ly.am, 1), new Object[] {
            "##", "##", Character.valueOf('#'), di.aF
        });
        a(new ev(ly.ac, 1), new Object[] {
            "###", "###", "###", Character.valueOf('#'), di.I
        });
        a(new ev(ly.an, 1), new Object[] {
            "X#X", "#X#", "X#X", Character.valueOf('X'), di.K, Character.valueOf('#'), ly.F
        });
        a(new ev(ly.al, 3), new Object[] {
            "###", Character.valueOf('#'), ly.x
        });
        a(new ev(ly.aG, 1), new Object[] {
            "# #", "###", "# #", Character.valueOf('#'), di.B
        });
        a(new ev(di.at, 1), new Object[] {
            "##", "##", "##", Character.valueOf('#'), ly.y
        });
        a(new ev(di.az, 1), new Object[] {
            "##", "##", "##", Character.valueOf('#'), di.m
        });
        a(new ev(di.as, 1), new Object[] {
            "###", "###", " X ", Character.valueOf('#'), ly.y, Character.valueOf('X'), di.B
        });
        a(new ev(ly.y, 4), new Object[] {
            "#", Character.valueOf('#'), ly.K
        });
        a(new ev(di.B, 4), new Object[] {
            "#", "#", Character.valueOf('#'), ly.y
        });
        a(new ev(ly.ar, 4), new Object[] {
            "X", "#", Character.valueOf('X'), di.k, Character.valueOf('#'), di.B
        });
        a(new ev(di.C, 4), new Object[] {
            "# #", " # ", Character.valueOf('#'), ly.y
        });
        a(new ev(ly.aH, 16), new Object[] {
            "X X", "X#X", "X X", Character.valueOf('X'), di.m, Character.valueOf('#'), di.B
        });
        a(new ev(di.ax, 1), new Object[] {
            "# #", "###", Character.valueOf('#'), di.m
        });
        a(new ev(di.aL, 1), new Object[] {
            "A", "B", Character.valueOf('A'), ly.av, Character.valueOf('B'), di.ax
        });
        a(new ev(di.aM, 1), new Object[] {
            "A", "B", Character.valueOf('A'), ly.aC, Character.valueOf('B'), di.ax
        });
        a(new ev(di.aC, 1), new Object[] {
            "# #", "###", Character.valueOf('#'), ly.y
        });
        a(new ev(di.au, 1), new Object[] {
            "# #", " # ", Character.valueOf('#'), di.m
        });
        a(new ev(di.g, 1), new Object[] {
            "A ", " B", Character.valueOf('A'), di.m, Character.valueOf('B'), di.an
        });
        a(new ev(di.S, 1), new Object[] {
            "###", Character.valueOf('#'), di.R
        });
        a(new ev(ly.au, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), ly.y
        });
        a(new ev(di.aP, 1), new Object[] {
            "  #", " #X", "# X", Character.valueOf('#'), di.B, Character.valueOf('X'), di.I
        });
        a(new ev(ly.aI, 4), new Object[] {
            "#  ", "## ", "###", Character.valueOf('#'), ly.x
        });
        a(new ev(di.aq, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), di.B, Character.valueOf('X'), ly.ac
        });
        a(new ev(di.ar, 1), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), ly.ai, Character.valueOf('X'), di.h
        });
        a(new ev(ly.aK, 1), new Object[] {
            "X", "#", Character.valueOf('#'), ly.x, Character.valueOf('X'), di.B
        });
        a(new ev(ly.aR, 1), new Object[] {
            "X", "#", Character.valueOf('#'), di.B, Character.valueOf('X'), di.aA
        });
        a(new ev(di.aO, 1), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), di.m, Character.valueOf('X'), di.aA
        });
        a(new ev(ly.aS, 1), new Object[] {
            "#", "#", Character.valueOf('#'), ly.u
        });
        a(new ev(ly.aL, 1), new Object[] {
            "###", Character.valueOf('#'), ly.u
        });
        a(new ev(ly.aN, 1), new Object[] {
            "###", Character.valueOf('#'), ly.y
        });
        Collections.sort(b, ((java.util.Comparator) (new fs(this))));
        System.out.println((new StringBuilder()).append(b.size()).append(" recipes").toString());
    }

    transient void a(ev ev1, Object aobj[])
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;
        if(aobj[i] instanceof String[])
        {
            String as[] = (String[])(String[])aobj[i++];
            for(int i1 = 0; i1 < as.length; i1++)
            {
                String s2 = as[i1];
                k++;
                j = s2.length();
                s = (new StringBuilder()).append(s).append(s2).toString();
            }

        } else
        {
            while(aobj[i] instanceof String) 
            {
                String s1 = (String)aobj[i++];
                k++;
                j = s1.length();
                s = (new StringBuilder()).append(s).append(s1).toString();
            }
        }
        HashMap hashmap = new HashMap();
        for(; i < aobj.length; i += 2)
        {
            Character character = (Character)aobj[i];
            int j1 = 0;
            if(aobj[i + 1] instanceof di)
                j1 = ((di)aobj[i + 1]).aS;
            else
            if(aobj[i + 1] instanceof ly)
                j1 = ((ly)aobj[i + 1]).bc;
            ((Map) (hashmap)).put(((Object) (character)), ((Object) (Integer.valueOf(j1))));
        }

        int ai[] = new int[j * k];
        for(int k1 = 0; k1 < j * k; k1++)
        {
            char c = s.charAt(k1);
            if(((Map) (hashmap)).containsKey(((Object) (Character.valueOf(c)))))
                ai[k1] = ((Integer)((Map) (hashmap)).get(((Object) (Character.valueOf(c))))).intValue();
            else
                ai[k1] = -1;
        }

        b.add(((Object) (new bv(j, k, ai, ev1))));
    }

    public ev a(int ai[])
    {
        for(int i = 0; i < b.size(); i++)
        {
            bv bv1 = (bv)b.get(i);
            if(bv1.a(ai))
                return bv1.b(ai);
        }

        return null;
    }

    private static final dw a = new dw();
    private List b;

}
