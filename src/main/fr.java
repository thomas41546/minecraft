package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class fr
{

    public fr(Minecraft minecraft, File file)
    {
        a = 1.0F;
        b = 1.0F;
        c = 0.5F;
        d = false;
        e = 0;
        f = true;
        g = false;
        h = false;
        i = true;
        j = new it("Forward", 17);
        k = new it("Left", 30);
        l = new it("Back", 31);
        m = new it("Right", 32);
        n = new it("Jump", 57);
        o = new it("Inventory", 23);
        p = new it("Drop", 16);
        q = new it("Chat", 20);
        r = new it("Toggle fog", 33);
        s = new it("Sneak", 42);
        t = (new it[] {
            j, k, l, m, n, s, p, o, q, r
        });
        v = 10;
        w = 2;
        x = false;
        u = minecraft;
        A = new File(file, "options.txt");
        a();
    }

    public fr()
    {
        a = 1.0F;
        b = 1.0F;
        c = 0.5F;
        d = false;
        e = 0;
        f = true;
        g = false;
        h = false;
        i = true;
        j = new it("Forward", 17);
        k = new it("Left", 30);
        l = new it("Back", 31);
        m = new it("Right", 32);
        n = new it("Jump", 57);
        o = new it("Inventory", 23);
        p = new it("Drop", 16);
        q = new it("Chat", 20);
        r = new it("Toggle fog", 33);
        s = new it("Sneak", 42);
        t = (new it[] {
            j, k, l, m, n, s, p, o, q, r
        });
        v = 10;
        w = 2;
        x = false;
    }

    public String a(int i1)
    {
        return (new StringBuilder()).append(t[i1].a).append(": ").append(Keyboard.getKeyName(t[i1].b)).toString();
    }

    public void a(int i1, int j1)
    {
        t[i1].b = j1;
        b();
    }

    public void a(int i1, float f1)
    {
        if(i1 == 0)
        {
            a = f1;
            u.A.a();
        }
        if(i1 == 1)
        {
            b = f1;
            u.A.a();
        }
        if(i1 == 3)
            c = f1;
    }

    public void b(int i1, int j1)
    {
        if(i1 == 2)
            d = !d;
        if(i1 == 4)
            e = e + j1 & 3;
        if(i1 == 5)
            f = !f;
        if(i1 == 6)
        {
            g = !g;
            u.n.b();
        }
        if(i1 == 7)
            h = !h;
        if(i1 == 8)
            w = w + j1 & 3;
        if(i1 == 9)
        {
            i = !i;
            u.f.a();
        }
        b();
    }

    public int b(int i1)
    {
        if(i1 == 0)
            return 1;
        if(i1 == 1)
            return 1;
        return i1 != 3 ? 0 : 1;
    }

    public float c(int i1)
    {
        if(i1 == 0)
            return a;
        if(i1 == 1)
            return b;
        if(i1 == 3)
            return c;
        else
            return 0.0F;
    }

    public String d(int i1)
    {
        if(i1 == 0)
            return (new StringBuilder()).append("Music: ").append(a <= 0.0F ? "OFF" : (new StringBuilder()).append((int)(a * 100F)).append("%").toString()).toString();
        if(i1 == 1)
            return (new StringBuilder()).append("Sound: ").append(b <= 0.0F ? "OFF" : (new StringBuilder()).append((int)(b * 100F)).append("%").toString()).toString();
        if(i1 == 2)
            return (new StringBuilder()).append("Invert mouse: ").append(d ? "ON" : "OFF").toString();
        if(i1 == 3)
        {
            if(c == 0.0F)
                return "Sensitivity: *yawn*";
            if(c == 1.0F)
                return "Sensitivity: HYPERSPEED!!!";
            else
                return (new StringBuilder()).append("Sensitivity: ").append((int)(c * 200F)).append("%").toString();
        }
        if(i1 == 4)
            return (new StringBuilder()).append("Render distance: ").append(y[e]).toString();
        if(i1 == 5)
            return (new StringBuilder()).append("View bobbing: ").append(f ? "ON" : "OFF").toString();
        if(i1 == 6)
            return (new StringBuilder()).append("3d anaglyph: ").append(g ? "ON" : "OFF").toString();
        if(i1 == 7)
            return (new StringBuilder()).append("Limit framerate: ").append(h ? "ON" : "OFF").toString();
        if(i1 == 8)
            return (new StringBuilder()).append("Difficulty: ").append(z[w]).toString();
        if(i1 == 9)
            return (new StringBuilder()).append("Graphics: ").append(i ? "FANCY" : "FAST").toString();
        else
            return "";
    }

    public void a()
    {
        if(!A.exists())
            return;
        try
        {
            BufferedReader bufferedreader = new BufferedReader(((java.io.Reader) (new FileReader(A))));
            for(String s1 = ""; (s1 = bufferedreader.readLine()) != null;)
            {
                String as[] = s1.split(":");
                if(as[0].equals("music"))
                    a = a(as[1]);
                if(as[0].equals("sound"))
                    b = a(as[1]);
                if(as[0].equals("mouseSensitivity"))
                    c = a(as[1]);
                if(as[0].equals("invertYMouse"))
                    d = as[1].equals("true");
                if(as[0].equals("viewDistance"))
                    e = Integer.parseInt(as[1]);
                if(as[0].equals("bobView"))
                    f = as[1].equals("true");
                if(as[0].equals("anaglyph3d"))
                    g = as[1].equals("true");
                if(as[0].equals("limitFramerate"))
                    h = as[1].equals("true");
                if(as[0].equals("difficulty"))
                    w = Integer.parseInt(as[1]);
                if(as[0].equals("fancyGraphics"))
                    i = as[1].equals("true");
                int i1 = 0;
                while(i1 < t.length) 
                {
                    if(as[0].equals(((Object) ((new StringBuilder()).append("key_").append(t[i1].a).toString()))))
                        t[i1].b = Integer.parseInt(as[1]);
                    i1++;
                }
            }

            bufferedreader.close();
        }
        catch(Exception exception)
        {
            System.out.println("Failed to load options");
            exception.printStackTrace();
        }
        return;
    }

    private float a(String s1)
    {
        if(s1.equals("true"))
            return 1.0F;
        if(s1.equals("false"))
            return 0.0F;
        else
            return Float.parseFloat(s1);
    }

    public void b()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(((java.io.Writer) (new FileWriter(A))));
            printwriter.println((new StringBuilder()).append("music:").append(a).toString());
            printwriter.println((new StringBuilder()).append("sound:").append(b).toString());
            printwriter.println((new StringBuilder()).append("invertYMouse:").append(d).toString());
            printwriter.println((new StringBuilder()).append("mouseSensitivity:").append(c).toString());
            printwriter.println((new StringBuilder()).append("viewDistance:").append(e).toString());
            printwriter.println((new StringBuilder()).append("bobView:").append(f).toString());
            printwriter.println((new StringBuilder()).append("anaglyph3d:").append(g).toString());
            printwriter.println((new StringBuilder()).append("limitFramerate:").append(h).toString());
            printwriter.println((new StringBuilder()).append("difficulty:").append(w).toString());
            printwriter.println((new StringBuilder()).append("fancyGraphics:").append(i).toString());
            for(int i1 = 0; i1 < t.length; i1++)
                printwriter.println((new StringBuilder()).append("key_").append(t[i1].a).append(":").append(t[i1].b).toString());

            printwriter.close();
        }
        catch(Exception exception)
        {
            System.out.println("Failed to save options");
            exception.printStackTrace();
        }
    }

    private static final String y[] = {
        "FAR", "NORMAL", "SHORT", "TINY"
    };
    private static final String z[] = {
        "Peaceful", "Easy", "Normal", "Hard"
    };
    public float a;
    public float b;
    public float c;
    public boolean d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public it j;
    public it k;
    public it l;
    public it m;
    public it n;
    public it o;
    public it p;
    public it q;
    public it r;
    public it s;
    public it t[];
    protected Minecraft u;
    private File A;
    public int v;
    public int w;
    public boolean x;

}
