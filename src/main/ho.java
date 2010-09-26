package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.PrintStream;
import java.nio.*;
import org.lwjgl.opengl.*;

public class ho
{

    private ho(int i1)
    {
        h = 0;
        l = false;
        m = false;
        n = false;
        o = 0;
        p = 0;
        q = false;
        w = false;
        x = false;
        z = 0;
        A = 10;
        B = i1;
        d = df.b(i1 * 4);
        e = d.asIntBuffer();
        f = d.asFloatBuffer();
        g = new int[i1];
        x = c && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
        if(x)
        {
            y = df.c(A);
            ARBVertexBufferObject.glGenBuffersARB(y);
        }
    }

    public void a()
    {
        if(!w)
            throw new IllegalStateException("Not tesselating!");
        w = false;
        if(h > 0)
        {
            e.clear();
            e.put(g, 0, o);
            d.position(0);
            d.limit(o * 4);
            if(x)
            {
                z = (z + 1) % A;
                ARBVertexBufferObject.glBindBufferARB(34962, y.get(z));
                ARBVertexBufferObject.glBufferDataARB(34962, d, 35040);
            }
            if(m)
            {
                if(x)
                {
                    GL11.glTexCoordPointer(2, 5126, 32, 12L);
                } else
                {
                    f.position(3);
                    GL11.glTexCoordPointer(2, 32, f);
                }
                GL11.glEnableClientState(32888);
            }
            if(l)
            {
                if(x)
                {
                    GL11.glColorPointer(4, 5121, 32, 20L);
                } else
                {
                    d.position(20);
                    GL11.glColorPointer(4, true, 32, d);
                }
                GL11.glEnableClientState(32886);
            }
            if(n)
            {
                if(x)
                {
                    GL11.glNormalPointer(5120, 32, 24L);
                } else
                {
                    d.position(24);
                    GL11.glNormalPointer(32, d);
                }
                GL11.glEnableClientState(32885);
            }
            if(x)
            {
                GL11.glVertexPointer(3, 5126, 32, 0L);
            } else
            {
                f.position(0);
                GL11.glVertexPointer(3, 32, f);
            }
            GL11.glEnableClientState(32884);
            if(r == 7 && b)
                GL11.glDrawArrays(4, 0, h);
            else
                GL11.glDrawArrays(r, 0, h);
            GL11.glDisableClientState(32884);
            if(m)
                GL11.glDisableClientState(32888);
            if(l)
                GL11.glDisableClientState(32886);
            if(n)
                GL11.glDisableClientState(32885);
        }
        d();
    }

    private void d()
    {
        h = 0;
        d.clear();
        o = 0;
        p = 0;
    }

    public void b()
    {
        a(7);
    }

    public void a(int i1)
    {
        if(w)
        {
            throw new IllegalStateException("Already tesselating!");
        } else
        {
            w = true;
            d();
            r = i1;
            n = false;
            l = false;
            m = false;
            q = false;
            return;
        }
    }

    public void a(double d1, double d2)
    {
        m = true;
        i = d1;
        j = d2;
    }

    public void a(float f1, float f2, float f3)
    {
        a((int)(f1 * 255F), (int)(f2 * 255F), (int)(f3 * 255F));
    }

    public void a(float f1, float f2, float f3, float f4)
    {
        a((int)(f1 * 255F), (int)(f2 * 255F), (int)(f3 * 255F), (int)(f4 * 255F));
    }

    public void a(int i1, int j1, int k1)
    {
        a(i1, j1, k1, 255);
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        if(q)
            return;
        if(i1 > 255)
            i1 = 255;
        if(j1 > 255)
            j1 = 255;
        if(k1 > 255)
            k1 = 255;
        if(l1 > 255)
            l1 = 255;
        if(i1 < 0)
            i1 = 0;
        if(j1 < 0)
            j1 = 0;
        if(k1 < 0)
            k1 = 0;
        if(l1 < 0)
            l1 = 0;
        l = true;
        k = l1 << 24 | k1 << 16 | j1 << 8 | i1;
    }

    public void a(double d1, double d2, double d3, double d4, double d5)
    {
        a(d4, d5);
        a(d1, d2, d3);
    }

    public void a(double d1, double d2, double d3)
    {
        p++;
        if(r == 7 && b && p % 4 == 0)
        {
            for(int i1 = 0; i1 < 2; i1++)
            {
                int j1 = 8 * (3 - i1);
                if(m)
                {
                    g[o + 3] = g[(o - j1) + 3];
                    g[o + 4] = g[(o - j1) + 4];
                }
                if(l)
                    g[o + 5] = g[(o - j1) + 5];
                g[o + 0] = g[(o - j1) + 0];
                g[o + 1] = g[(o - j1) + 1];
                g[o + 2] = g[(o - j1) + 2];
                h++;
                o += 8;
            }

        }
        if(m)
        {
            g[o + 3] = Float.floatToRawIntBits((float)i);
            g[o + 4] = Float.floatToRawIntBits((float)j);
        }
        if(l)
            g[o + 5] = k;
        if(n)
            g[o + 6] = v;
        g[o + 0] = Float.floatToRawIntBits((float)(d1 + s));
        g[o + 1] = Float.floatToRawIntBits((float)(d2 + t));
        g[o + 2] = Float.floatToRawIntBits((float)(d3 + u));
        o += 8;
        h++;
        if(h % 4 == 0 && o >= B - 32)
        {
            a();
            w = true;
        }
    }

    public void b(int i1)
    {
        int j1 = i1 >> 16 & 0xff;
        int k1 = i1 >> 8 & 0xff;
        int l1 = i1 & 0xff;
        a(j1, k1, l1);
    }

    public void c()
    {
        q = true;
    }

    public void b(float f1, float f2, float f3)
    {
        if(!w)
            System.out.println("But..");
        n = true;
        byte byte0 = (byte)(int)(f1 * 128F);
        byte byte1 = (byte)(int)(f2 * 127F);
        byte byte2 = (byte)(int)(f3 * 127F);
        v = byte0 | byte1 << 8 | byte2 << 16;
    }

    public void b(double d1, double d2, double d3)
    {
        s = d1;
        t = d2;
        u = d3;
    }

    public void c(float f1, float f2, float f3)
    {
        s += f1;
        t += f2;
        u += f3;
    }

    private static boolean b = true;
    private static boolean c = false;
    private ByteBuffer d;
    private IntBuffer e;
    private FloatBuffer f;
    private int g[];
    private int h;
    private double i;
    private double j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private boolean q;
    private int r;
    private double s;
    private double t;
    private double u;
    private int v;
    public static final ho a = new ho(0x200000);
    private boolean w;
    private boolean x;
    private IntBuffer y;
    private int z;
    private int A;
    private int B;

}
