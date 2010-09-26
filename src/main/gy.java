package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;
import java.net.*;
import java.util.Random;
import net.minecraft.client.Minecraft;

public class gy extends lb
{

    public gy(Minecraft minecraft, String s, int i)
    {
        c = false;
        g = false;
        b = new Random();
        e = minecraft;
        Socket socket = new Socket(InetAddress.getByName(s), i);
        d = new ii(socket, "Client", ((lb) (this)));
    }

    public void a()
    {
        if(c)
        {
            return;
        } else
        {
            d.a();
            return;
        }
    }

    public void a(hp hp1)
    {
        e.b = ((hq) (new nj(e, this)));
        f = new gs(this);
        f.y = true;
        e.a(((cn) (f)));
        e.a(((bh) (new dg(this))));
    }

    public void a(ha ha1)
    {
        double d1 = (double)ha1.b / 32D;
        double d2 = (double)ha1.c / 32D;
        double d3 = (double)ha1.d / 32D;
        dx dx1 = new dx(((cn) (f)), d1, d2, d3, new ev(ha1.h, ha1.i));
        dx1.an = (double)ha1.e / 128D;
        dx1.ao = (double)ha1.f / 128D;
        dx1.ap = (double)ha1.g / 128D;
        dx1.bd = ha1.b;
        dx1.be = ha1.c;
        dx1.bf = ha1.d;
        f.a(ha1.a, ((kh) (dx1)));
    }

    public void a(kj kj1)
    {
        double d1 = (double)kj1.b / 32D;
        double d2 = (double)kj1.c / 32D;
        double d3 = (double)kj1.d / 32D;
        Object obj = null;
        if(kj1.e == 10)
            obj = ((Object) (new oc(((cn) (f)), d1, d2, d3, 0)));
        if(kj1.e == 11)
            obj = ((Object) (new oc(((cn) (f)), d1, d2, d3, 1)));
        if(kj1.e == 12)
            obj = ((Object) (new oc(((cn) (f)), d1, d2, d3, 2)));
        if(kj1.e == 1)
            obj = ((Object) (new dc(((cn) (f)), d1, d2, d3)));
        if(obj != null)
        {
            obj.bd = kj1.b;
            obj.be = kj1.c;
            obj.bf = kj1.d;
            obj.aq = 0.0F;
            obj.ar = 0.0F;
            obj.ab = kj1.a;
            f.a(kj1.a, ((kh) (obj)));
        }
    }

    public void a(gp gp1)
    {
        double d1 = (double)gp1.c / 32D;
        double d2 = (double)gp1.d / 32D;
        double d3 = (double)gp1.e / 32D;
        float f1 = (float)(gp1.f * 360) / 256F;
        float f2 = (float)(gp1.g * 360) / 256F;
        nt nt1 = new nt(e.e, gp1.b);
        nt1.bd = gp1.c;
        nt1.be = gp1.d;
        nt1.bf = gp1.e;
        int i = gp1.h;
        if(i == 0)
            nt1.b.a[nt1.b.d] = null;
        else
            nt1.b.a[nt1.b.d] = new ev(i);
        nt1.b(d1, d2, d3, f1, f2);
        f.a(gp1.a, ((kh) (nt1)));
    }

    public void a(jl jl1)
    {
        kh kh1 = f.b(jl1.a);
        if(kh1 == null)
        {
            return;
        } else
        {
            kh1.bd = jl1.b;
            kh1.be = jl1.c;
            kh1.bf = jl1.d;
            double d1 = (double)kh1.bd / 32D;
            double d2 = (double)kh1.be / 32D;
            double d3 = (double)kh1.bf / 32D;
            float f1 = (float)(jl1.e * 360) / 256F;
            float f2 = (float)(jl1.f * 360) / 256F;
            kh1.a(d1, d2, d3, f1, f2, 3);
            return;
        }
    }

    public void a(lq lq1)
    {
        kh kh1 = f.b(lq1.a);
        if(kh1 == null)
        {
            return;
        } else
        {
            kh1.bd += ((int) (lq1.b));
            kh1.be += ((int) (lq1.c));
            kh1.bf += ((int) (lq1.d));
            double d1 = (double)kh1.bd / 32D;
            double d2 = (double)kh1.be / 32D;
            double d3 = (double)kh1.bf / 32D;
            float f1 = lq1.g ? (float)(lq1.e * 360) / 256F : kh1.aq;
            float f2 = lq1.g ? (float)(lq1.f * 360) / 256F : kh1.ar;
            kh1.a(d1, d2, d3, f1, f2, 3);
            return;
        }
    }

    public void a(ju ju1)
    {
        f.c(ju1.a);
    }

    public void a(eh eh1)
    {
        bi bi1 = e.g;
        double d1 = ((dm) (bi1)).ak;
        double d2 = ((dm) (bi1)).al;
        double d3 = ((dm) (bi1)).am;
        float f1 = ((dm) (bi1)).aq;
        float f2 = ((dm) (bi1)).ar;
        if(eh1.h)
        {
            d1 = eh1.a;
            d2 = eh1.b;
            d3 = eh1.c;
        }
        if(eh1.i)
        {
            f1 = eh1.e;
            f2 = eh1.f;
        }
        bi1.aL = 0.0F;
        bi1.an = bi1.ao = bi1.ap = 0.0D;
        ((dm) (bi1)).b(d1, d2, d3, f1, f2);
        eh1.a = ((dm) (bi1)).ak;
        eh1.b = ((dm) (bi1)).au.b;
        eh1.c = ((dm) (bi1)).am;
        eh1.d = ((dm) (bi1)).al;
        d.a(((fn) (eh1)));
        if(!g)
        {
            e.g.ah = e.g.ak;
            e.g.ai = e.g.al;
            e.g.aj = e.g.am;
            g = true;
            e.a(((bh) (null)));
        }
    }

    public void a(ka ka1)
    {
        f.a(ka1.a, ka1.b, ka1.c);
    }

    public void a(na na1)
    {
        ga ga1 = f.b(na1.a, na1.b);
        int i = na1.a * 16;
        int j = na1.b * 16;
        for(int k = 0; k < na1.f; k++)
        {
            short word0 = na1.c[k];
            int l = na1.d[k] & 0xff;
            byte byte0 = na1.e[k];
            int i1 = word0 >> 12 & 0xf;
            int j1 = word0 >> 8 & 0xf;
            int k1 = word0 & 0xff;
            ga1.a(i1, k1, j1, l, ((int) (byte0)));
            f.c(i1 + i, k1, j1 + j, i1 + i, k1, j1 + j);
            f.b(i1 + i, k1, j1 + j, i1 + i, k1, j1 + j);
        }

    }

    public void a(bz bz1)
    {
        f.c(bz1.a, bz1.b, bz1.c, (bz1.a + bz1.d) - 1, (bz1.b + bz1.e) - 1, (bz1.c + bz1.f) - 1);
        f.a(bz1.a, bz1.b, bz1.c, bz1.d, bz1.e, bz1.f, bz1.g);
    }

    public void a(li li1)
    {
        f.c(li1.a, li1.b, li1.c, li1.d, li1.e);
    }

    public void a(oh oh1)
    {
        d.a("Got kicked");
        c = true;
        e.a(((cn) (null)));
        e.a(((bh) (new cj("Disconnected by server", oh1.a))));
    }

    public void a(String s)
    {
        if(c)
        {
            return;
        } else
        {
            c = true;
            e.a(((cn) (null)));
            e.a(((bh) (new cj("Connection lost", s))));
            return;
        }
    }

    public void a(fn fn)
    {
        if(c)
        {
            return;
        } else
        {
            d.a(fn);
            return;
        }
    }

    public void a(bm bm1)
    {
        dx dx1 = (dx)f.b(bm1.a);
        Object obj = ((Object) ((ge)f.b(bm1.b)));
        if(obj == null)
            obj = ((Object) (e.g));
        if(dx1 != null)
        {
            f.a(((kh) (dx1)), "random.pop", 0.2F, ((b.nextFloat() - b.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            e.h.a(((nq) (new cd(e.e, ((kh) (dx1)), ((kh) (obj)), -0.5F))));
            f.c(bm1.a);
        }
    }

    public void a(dz dz1)
    {
        kh kh1 = f.b(dz1.a);
        if(kh1 == null)
            return;
        dm dm1 = (dm)kh1;
        int i = dz1.b;
        if(i == 0)
            dm1.b.a[dm1.b.d] = null;
        else
            dm1.b.a[dm1.b.d] = new ev(i);
    }

    public void a(ij ij1)
    {
        e.u.a(ij1.a);
    }

    public void a(hf hf1)
    {
        kh kh1 = f.b(hf1.a);
        if(kh1 == null)
        {
            return;
        } else
        {
            dm dm1 = (dm)kh1;
            dm1.w();
            return;
        }
    }

    public void a(ld ld1)
    {
        e.g.b.a(new ev(ld1.a, ld1.b, ld1.c));
    }

    public void a(gt gt1)
    {
        if(gt1.a.equals("-"))
            a(((fn) (new hp(e.i.b, "Password", 2))));
        else
            try
            {
                URL url = new URL((new StringBuilder()).append("http://www.minecraft.net/game/joinserver.jsp?user=").append(e.i.b).append("&sessionId=").append(e.i.c).append("&serverId=").append(gt1.a).toString());
                BufferedReader bufferedreader = new BufferedReader(((java.io.Reader) (new InputStreamReader(url.openStream()))));
                String s = bufferedreader.readLine();
                bufferedreader.close();
                if(s.equalsIgnoreCase("ok"))
                    a(((fn) (new hp(e.i.b, "Password", 2))));
                else
                    d.a((new StringBuilder()).append("Failed to login: ").append(s).toString());
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
                d.a((new StringBuilder()).append("Internal client error: ").append(exception.toString()).toString());
            }
    }

    public void b()
    {
        c = true;
        d.a("Closed");
    }

    public void a(ez ez1)
    {
        double d1 = (double)ez1.c / 32D;
        double d2 = (double)ez1.d / 32D;
        double d3 = (double)ez1.e / 32D;
        float f1 = (float)(ez1.f * 360) / 256F;
        float f2 = (float)(ez1.g * 360) / 256F;
        ge ge1 = (ge)ew.a(((int) (ez1.b)), e.e);
        ge1.bd = ez1.c;
        ge1.be = ez1.d;
        ge1.bf = ez1.e;
        ge1.b(d1, d2, d3, f1, f2);
        ge1.B = true;
        f.a(ez1.a, ((kh) (ge1)));
    }

    public void a(du du1)
    {
        e.e.a(du1.a);
    }

    public void a(m m1)
    {
        bi bi1 = e.g;
        if(m1.a == -1)
            ((dm) (bi1)).b.a = m1.b;
        if(m1.a == -2)
            ((dm) (bi1)).b.c = m1.b;
        if(m1.a == -3)
            ((dm) (bi1)).b.b = m1.b;
    }

    public void a(ny ny1)
    {
        ic ic1 = f.b(ny1.a, ny1.b, ny1.c);
        if(ic1 != null)
        {
            ic1.a(ny1.e);
            f.b(ny1.a, ny1.b, ny1.c, ny1.a, ny1.b, ny1.c);
        }
    }

    public void a(ji ji1)
    {
        f.o = ji1.a;
        f.p = ji1.b;
        f.q = ji1.c;
    }

    private boolean c;
    private ii d;
    public String a;
    private Minecraft e;
    private gs f;
    private boolean g;
    Random b;
}
