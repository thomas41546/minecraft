package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.nio.IntBuffer;
import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;

public class e
    implements im
{

    public e(Minecraft minecraft, ey ey1)
    {
        a = ((List) (new ArrayList()));
        m = ((List) (new ArrayList()));
        w = false;
        x = 0;
        H = -1;
        I = 2;
        b = new int[50000];
        c = df.c(64);
        R = ((List) (new ArrayList()));
        d = 0;
        e = df.a(1);
        f = -9999D;
        g = -9999D;
        h = -9999D;
        j = 0;
        t = minecraft;
        l = ey1;
        byte byte0 = 64;
        s = df.a(byte0 * byte0 * byte0 * 3);
        w = minecraft.k().a();
        if(w)
        {
            c.clear();
            v = df.c(byte0 * byte0 * byte0);
            v.clear();
            v.position(0);
            v.limit(byte0 * byte0 * byte0);
            ARBOcclusionQuery.glGenQueriesARB(v);
        }
        y = df.a(3);
        GL11.glPushMatrix();
        GL11.glNewList(y, 4864);
        f();
        GL11.glEndList();
        GL11.glPopMatrix();
        ho ho1 = ho.a;
        z = y + 1;
        GL11.glNewList(z, 4864);
        byte byte1 = 64;
        int i1 = 256 / byte1 + 2;
        float f1 = 16F;
        for(int j1 = -byte1 * i1; j1 <= byte1 * i1; j1 += ((int) (byte1)))
        {
            for(int l1 = -byte1 * i1; l1 <= byte1 * i1; l1 += ((int) (byte1)))
            {
                ho1.b();
                ho1.a(j1 + 0, f1, l1 + 0);
                ho1.a(j1 + byte1, f1, l1 + 0);
                ho1.a(j1 + byte1, f1, l1 + byte1);
                ho1.a(j1 + 0, f1, l1 + byte1);
                ho1.a();
            }

        }

        GL11.glEndList();
        A = y + 2;
        GL11.glNewList(A, 4864);
        f1 = -16F;
        ho1.b();
        for(int k1 = -byte1 * i1; k1 <= byte1 * i1; k1 += ((int) (byte1)))
        {
            for(int i2 = -byte1 * i1; i2 <= byte1 * i1; i2 += ((int) (byte1)))
            {
                ho1.a(k1 + byte1, f1, i2 + 0);
                ho1.a(k1 + 0, f1, i2 + 0);
                ho1.a(k1 + 0, f1, i2 + byte1);
                ho1.a(k1 + byte1, f1, i2 + byte1);
            }

        }

        ho1.a();
        GL11.glEndList();
    }

    private void f()
    {
        Random random = new Random(10842L);
        ho ho1 = ho.a;
        ho1.b();
        for(int i1 = 0; i1 < 1500; i1++)
        {
            double d1 = random.nextFloat() * 2.0F - 1.0F;
            double d2 = random.nextFloat() * 2.0F - 1.0F;
            double d3 = random.nextFloat() * 2.0F - 1.0F;
            double d4 = 0.25F + random.nextFloat() * 0.25F;
            double d5 = d1 * d1 + d2 * d2 + d3 * d3;
            if(d5 >= 1.0D || d5 <= 0.01D)
                continue;
            d5 = 1.0D / Math.sqrt(d5);
            d1 *= d5;
            d2 *= d5;
            d3 *= d5;
            double d6 = d1 * 100D;
            double d7 = d2 * 100D;
            double d8 = d3 * 100D;
            double d9 = Math.atan2(d1, d3);
            double d10 = Math.sin(d9);
            double d11 = Math.cos(d9);
            double d12 = Math.atan2(Math.sqrt(d1 * d1 + d3 * d3), d2);
            double d13 = Math.sin(d12);
            double d14 = Math.cos(d12);
            double d15 = random.nextDouble() * 3.1415926535897931D * 2D;
            double d16 = Math.sin(d15);
            double d17 = Math.cos(d15);
            for(int j1 = 0; j1 < 4; j1++)
            {
                double d18 = 0.0D;
                double d19 = (double)((j1 & 2) - 1) * d4;
                double d20 = (double)((j1 + 1 & 2) - 1) * d4;
                double d21 = d18;
                double d22 = d19 * d17 - d20 * d16;
                double d23 = d20 * d17 + d19 * d16;
                double d24 = d23;
                double d25 = d22 * d13 + d21 * d14;
                double d26 = d21 * d13 - d22 * d14;
                double d27 = d26 * d10 - d24 * d11;
                double d28 = d25;
                double d29 = d24 * d10 + d26 * d11;
                ho1.a(d6 + d27, d7 + d28, d8 + d29);
            }

        }

        ho1.a();
    }

    public void a(cn cn1)
    {
        if(k != null)
            k.b(((im) (this)));
        f = -9999D;
        g = -9999D;
        h = -9999D;
        kx.a.a(cn1);
        k = cn1;
        u = new bc(((nm) (cn1)));
        if(cn1 != null)
        {
            cn1.a(((im) (this)));
            a();
        }
    }

    public void a()
    {
        ly.L.a(t.y.i);
        H = t.y.e;
        if(o != null)
        {
            for(int i1 = 0; i1 < o.length; i1++)
                o[i1].c();

        }
        int j1 = 64 << 3 - H;
        if(j1 > 400)
            j1 = 400;
        p = j1 / 16 + 1;
        q = 8;
        r = j1 / 16 + 1;
        o = new bn[p * q * r];
        n = new bn[p * q * r];
        int k1 = 0;
        int l1 = 0;
        B = 0;
        C = 0;
        D = 0;
        E = p;
        F = q;
        G = r;
        for(int i2 = 0; i2 < m.size(); i2++)
            ((bn)m.get(i2)).u = false;

        m.clear();
        a.clear();
        for(int j2 = 0; j2 < p; j2++)
        {
            for(int k2 = 0; k2 < q; k2++)
            {
                for(int l2 = 0; l2 < r; l2++)
                {
                    o[(l2 * q + k2) * p + j2] = new bn(k, a, j2 * 16, k2 * 16, l2 * 16, 16, s + k1);
                    if(w)
                        o[(l2 * q + k2) * p + j2].z = v.get(l1);
                    o[(l2 * q + k2) * p + j2].y = false;
                    o[(l2 * q + k2) * p + j2].x = true;
                    o[(l2 * q + k2) * p + j2].o = true;
                    o[(l2 * q + k2) * p + j2].w = l1++;
                    o[(l2 * q + k2) * p + j2].f();
                    n[(l2 * q + k2) * p + j2] = o[(l2 * q + k2) * p + j2];
                    m.add(((Object) (o[(l2 * q + k2) * p + j2])));
                    k1 += 3;
                }

            }

        }

        if(k != null)
        {
            bi bi1 = t.g;
            b(eo.b(((kh) (bi1)).ak), eo.b(((kh) (bi1)).al), eo.b(((kh) (bi1)).am));
            Arrays.sort(((Object []) (n)), ((java.util.Comparator) (new fb(((kh) (bi1))))));
        }
        I = 2;
    }

    public void a(aj aj1, oe oe1, float f1)
    {
        if(I > 0)
        {
            I--;
            return;
        }
        fz.a.a(k, l, t.o, ((dm) (t.g)), f1);
        kx.a.a(k, l, t.o, ((dm) (t.g)), t.y, f1);
        J = 0;
        K = 0;
        L = 0;
        bi bi1 = t.g;
        kx.b = ((kh) (bi1)).aI + (((kh) (bi1)).ak - ((kh) (bi1)).aI) * (double)f1;
        kx.c = ((kh) (bi1)).aJ + (((kh) (bi1)).al - ((kh) (bi1)).aJ) * (double)f1;
        kx.d = ((kh) (bi1)).aK + (((kh) (bi1)).am - ((kh) (bi1)).aK) * (double)f1;
        fz.b = ((kh) (bi1)).aI + (((kh) (bi1)).ak - ((kh) (bi1)).aI) * (double)f1;
        fz.c = ((kh) (bi1)).aJ + (((kh) (bi1)).al - ((kh) (bi1)).aJ) * (double)f1;
        fz.d = ((kh) (bi1)).aK + (((kh) (bi1)).am - ((kh) (bi1)).aK) * (double)f1;
        List list = k.i();
        J = list.size();
        for(int i1 = 0; i1 < list.size(); i1++)
        {
            kh kh1 = (kh)list.get(i1);
            if(kh1.a(aj1) && oe1.a(kh1.au) && (kh1 != t.g || t.y.x))
            {
                K++;
                kx.a.a(kh1, f1);
            }
        }

        for(int j1 = 0; j1 < a.size(); j1++)
            fz.a.a((ic)a.get(j1), f1);

    }

    public String b()
    {
        return (new StringBuilder()).append("C: ").append(P).append("/").append(M).append(". F: ").append(N).append(", O: ").append(O).append(", E: ").append(Q).toString();
    }

    public String c()
    {
        return (new StringBuilder()).append("E: ").append(K).append("/").append(J).append(". B: ").append(L).append(", I: ").append(J - L - K).toString();
    }

    private void b(int i1, int j1, int k1)
    {
        i1 -= 8;
        j1 -= 8;
        k1 -= 8;
        B = 0x7fffffff;
        C = 0x7fffffff;
        D = 0x7fffffff;
        E = 0x80000000;
        F = 0x80000000;
        G = 0x80000000;
        int l1 = p * 16;
        int i2 = l1 / 2;
        for(int j2 = 0; j2 < p; j2++)
        {
            int k2 = j2 * 16;
            int l2 = (k2 + i2) - i1;
            if(l2 < 0)
                l2 -= l1 - 1;
            l2 /= l1;
            k2 -= l2 * l1;
            if(k2 < B)
                B = k2;
            if(k2 > E)
                E = k2;
            for(int i3 = 0; i3 < r; i3++)
            {
                int j3 = i3 * 16;
                int k3 = (j3 + i2) - k1;
                if(k3 < 0)
                    k3 -= l1 - 1;
                k3 /= l1;
                j3 -= k3 * l1;
                if(j3 < D)
                    D = j3;
                if(j3 > G)
                    G = j3;
                for(int l3 = 0; l3 < q; l3++)
                {
                    int i4 = l3 * 16;
                    if(i4 < C)
                        C = i4;
                    if(i4 > F)
                        F = i4;
                    bn bn1 = o[(i3 * q + l3) * p + j2];
                    boolean flag = bn1.u;
                    bn1.a(k2, i4, j3);
                    if(!flag && bn1.u)
                        m.add(((Object) (bn1)));
                }

            }

        }

    }

    public int a(dm dm1, int i1, double d1)
    {
        if(t.y.e != H)
            a();
        if(i1 == 0)
        {
            M = 0;
            N = 0;
            O = 0;
            P = 0;
            Q = 0;
        }
        double d2 = dm1.aI + (dm1.ak - dm1.aI) * d1;
        double d3 = dm1.aJ + (dm1.al - dm1.aJ) * d1;
        double d4 = dm1.aK + (dm1.am - dm1.aK) * d1;
        double d5 = dm1.ak - f;
        double d6 = dm1.al - g;
        double d7 = dm1.am - h;
        if(d5 * d5 + d6 * d6 + d7 * d7 > 16D)
        {
            f = dm1.ak;
            g = dm1.al;
            h = dm1.am;
            b(eo.b(dm1.ak), eo.b(dm1.al), eo.b(dm1.am));
            Arrays.sort(((Object []) (n)), ((java.util.Comparator) (new fb(((kh) (dm1))))));
        }
        int j1 = 0;
        if(w && !t.y.g && i1 == 0)
        {
            int k1 = 0;
            int l1 = 16;
            a(k1, l1);
            for(int i2 = k1; i2 < l1; i2++)
                n[i2].x = true;

            j1 += a(k1, l1, i1, d1);
            do
            {
                byte byte0 = ((byte) (l1));
                l1 *= 2;
                if(l1 > n.length)
                    l1 = n.length;
                GL11.glDisable(3553);
                GL11.glDisable(2896);
                GL11.glDisable(3008);
                GL11.glDisable(2912);
                GL11.glColorMask(false, false, false, false);
                GL11.glDepthMask(false);
                a(((int) (byte0)), l1);
                GL11.glPushMatrix();
                float f1 = 0.0F;
                float f2 = 0.0F;
                float f3 = 0.0F;
                for(int j2 = ((int) (byte0)); j2 < l1; j2++)
                {
                    if(n[j2].e())
                    {
                        n[j2].o = false;
                        continue;
                    }
                    if(!n[j2].o)
                        n[j2].x = true;
                    if(!n[j2].o || n[j2].y)
                        continue;
                    float f4 = eo.c(n[j2].a(((kh) (dm1))));
                    int k2 = (int)(1.0F + f4 / 128F);
                    if(x % k2 != j2 % k2)
                        continue;
                    bn bn1 = n[j2];
                    float f5 = (float)((double)bn1.i - d2);
                    float f6 = (float)((double)bn1.j - d3);
                    float f7 = (float)((double)bn1.k - d4);
                    float f8 = f5 - f1;
                    float f9 = f6 - f2;
                    float f10 = f7 - f3;
                    if(f8 != 0.0F || f9 != 0.0F || f10 != 0.0F)
                    {
                        GL11.glTranslatef(f8, f9, f10);
                        f1 += f8;
                        f2 += f9;
                        f3 += f10;
                    }
                    ARBOcclusionQuery.glBeginQueryARB(35092, n[j2].z);
                    n[j2].d();
                    ARBOcclusionQuery.glEndQueryARB(35092);
                    n[j2].y = true;
                }

                GL11.glPopMatrix();
                GL11.glColorMask(true, true, true, true);
                GL11.glDepthMask(true);
                GL11.glEnable(3553);
                GL11.glEnable(3008);
                GL11.glEnable(2912);
                j1 += a(((int) (byte0)), l1, i1, d1);
            } while(l1 < n.length);
        } else
        {
            j1 += a(0, n.length, i1, d1);
        }
        return j1;
    }

    private void a(int i1, int j1)
    {
        for(int k1 = i1; k1 < j1; k1++)
        {
            if(!n[k1].y)
                continue;
            c.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(n[k1].z, 34919, c);
            if(c.get(0) != 0)
            {
                n[k1].y = false;
                c.clear();
                ARBOcclusionQuery.glGetQueryObjectuARB(n[k1].z, 34918, c);
                n[k1].x = c.get(0) != 0;
            }
        }

    }

    private int a(int i1, int j1, int k1, double d1)
    {
        R.clear();
        int l1 = 0;
        for(int i2 = i1; i2 < j1; i2++)
        {
            if(k1 == 0)
            {
                M++;
                if(n[i2].p[k1])
                    Q++;
                else
                if(!n[i2].o)
                    N++;
                else
                if(w && !n[i2].x)
                    O++;
                else
                    P++;
            }
            if(n[i2].p[k1] || !n[i2].o || !n[i2].x)
                continue;
            int j2 = n[i2].a(k1);
            if(j2 >= 0)
            {
                R.add(((Object) (n[i2])));
                l1++;
            }
        }

        bi bi1 = t.g;
        double d2 = ((dm) (bi1)).aI + (((dm) (bi1)).ak - ((dm) (bi1)).aI) * d1;
        double d3 = ((dm) (bi1)).aJ + (((dm) (bi1)).al - ((dm) (bi1)).aJ) * d1;
        double d4 = ((dm) (bi1)).aK + (((dm) (bi1)).am - ((dm) (bi1)).aK) * d1;
        int k2 = 0;
        for(int l2 = 0; l2 < S.length; l2++)
            S[l2].b();

        for(int i3 = 0; i3 < R.size(); i3++)
        {
            bn bn1 = (bn)R.get(i3);
            int j3 = -1;
            for(int k3 = 0; k3 < k2; k3++)
                if(S[k3].a(bn1.i, bn1.j, bn1.k))
                    j3 = k3;

            if(j3 < 0)
            {
                j3 = k2++;
                S[j3].a(bn1.i, bn1.j, bn1.k, d2, d3, d4);
            }
            S[j3].a(bn1.a(k1));
        }

        a(k1, d1);
        return l1;
    }

    public void a(int i1, double d1)
    {
        for(int j1 = 0; j1 < S.length; j1++)
            S[j1].a();

    }

    public void d()
    {
        x++;
    }

    public void a(float f1)
    {
        GL11.glDisable(3553);
        aj aj1 = k.b(f1);
        float f2 = (float)aj1.a;
        float f3 = (float)aj1.b;
        float f4 = (float)aj1.c;
        if(t.y.g)
        {
            float f5 = (f2 * 30F + f3 * 59F + f4 * 11F) / 100F;
            float f6 = (f2 * 30F + f3 * 70F) / 100F;
            float f8 = (f2 * 30F + f4 * 70F) / 100F;
            f2 = f5;
            f3 = f6;
            f4 = f8;
        }
        GL11.glColor3f(f2, f3, f4);
        ho ho1 = ho.a;
        GL11.glDepthMask(false);
        GL11.glEnable(2912);
        GL11.glColor3f(f2, f3, f4);
        GL11.glCallList(z);
        GL11.glEnable(3553);
        GL11.glDisable(2912);
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(1, 1);
        GL11.glPushMatrix();
        float f7 = 0.0F;
        float f9 = 0.0F;
        float f10 = 0.0F;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef(f7, f9, f10);
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(k.c(f1) * 360F, 1.0F, 0.0F, 0.0F);
        float f11 = 30F;
        GL11.glBindTexture(3553, l.a("/terrain/sun.png"));
        ho1.b();
        ho1.a(-f11, 100D, -f11, 0.0D, 0.0D);
        ho1.a(f11, 100D, -f11, 1.0D, 0.0D);
        ho1.a(f11, 100D, f11, 1.0D, 1.0D);
        ho1.a(-f11, 100D, f11, 0.0D, 1.0D);
        ho1.a();
        f11 = 20F;
        GL11.glBindTexture(3553, l.a("/terrain/moon.png"));
        ho1.b();
        ho1.a(-f11, -100D, f11, 1.0D, 1.0D);
        ho1.a(f11, -100D, f11, 0.0D, 1.0D);
        ho1.a(f11, -100D, -f11, 0.0D, 0.0D);
        ho1.a(-f11, -100D, -f11, 1.0D, 0.0D);
        ho1.a();
        GL11.glDisable(3553);
        float f12 = k.f(f1);
        if(f12 > 0.0F)
        {
            GL11.glColor4f(f12, f12, f12, f12);
            GL11.glCallList(y);
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(2912);
        GL11.glPopMatrix();
        GL11.glColor3f(f2 * 0.2F + 0.04F, f3 * 0.2F + 0.04F, f4 * 0.6F + 0.1F);
        GL11.glDisable(3553);
        GL11.glCallList(A);
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
    }

    public void b(float f1)
    {
        if(t.y.i)
        {
            c(f1);
            return;
        }
        GL11.glDisable(2884);
        float f2 = (float)(t.g.aJ + (t.g.al - t.g.aJ) * (double)f1);
        byte byte0 = 32;
        int i1 = 256 / byte0;
        ho ho1 = ho.a;
        GL11.glBindTexture(3553, l.a("/clouds.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        aj aj1 = k.d(f1);
        float f3 = (float)aj1.a;
        float f4 = (float)aj1.b;
        float f5 = (float)aj1.c;
        if(t.y.g)
        {
            float f6 = (f3 * 30F + f4 * 59F + f5 * 11F) / 100F;
            float f8 = (f3 * 30F + f4 * 70F) / 100F;
            float f9 = (f3 * 30F + f5 * 70F) / 100F;
            f3 = f6;
            f4 = f8;
            f5 = f9;
        }
        float f7 = 0.0004882813F;
        double d1 = t.g.ah + (t.g.ak - t.g.ah) * (double)f1 + (double)(((float)x + f1) * 0.03F);
        double d2 = t.g.aj + (t.g.am - t.g.aj) * (double)f1;
        int j1 = eo.b(d1 / 2048D);
        int k1 = eo.b(d2 / 2048D);
        d1 -= j1 * 2048;
        d2 -= k1 * 2048;
        float f10 = (120F - f2) + 0.33F;
        float f11 = (float)(d1 * (double)f7);
        float f12 = (float)(d2 * (double)f7);
        ho1.b();
        ho1.a(f3, f4, f5, 0.8F);
        for(int l1 = -byte0 * i1; l1 < byte0 * i1; l1 += ((int) (byte0)))
        {
            for(int i2 = -byte0 * i1; i2 < byte0 * i1; i2 += ((int) (byte0)))
            {
                ho1.a(l1 + 0, f10, i2 + byte0, (float)(l1 + 0) * f7 + f11, (float)(i2 + byte0) * f7 + f12);
                ho1.a(l1 + byte0, f10, i2 + byte0, (float)(l1 + byte0) * f7 + f11, (float)(i2 + byte0) * f7 + f12);
                ho1.a(l1 + byte0, f10, i2 + 0, (float)(l1 + byte0) * f7 + f11, (float)(i2 + 0) * f7 + f12);
                ho1.a(l1 + 0, f10, i2 + 0, (float)(l1 + 0) * f7 + f11, (float)(i2 + 0) * f7 + f12);
            }

        }

        ho1.a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public void c(float f1)
    {
        GL11.glDisable(2884);
        float f2 = (float)(t.g.aJ + (t.g.al - t.g.aJ) * (double)f1);
        ho ho1 = ho.a;
        float f3 = 12F;
        float f4 = 4F;
        double d1 = (t.g.ah + (t.g.ak - t.g.ah) * (double)f1 + (double)(((float)x + f1) * 0.03F)) / (double)f3;
        double d2 = (t.g.aj + (t.g.am - t.g.aj) * (double)f1) / (double)f3 + 0.33000001311302185D;
        float f5 = (108F - f2) + 0.33F;
        int i1 = eo.b(d1 / 2048D);
        int j1 = eo.b(d2 / 2048D);
        d1 -= i1 * 2048;
        d2 -= j1 * 2048;
        GL11.glBindTexture(3553, l.a("/clouds.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        aj aj1 = k.d(f1);
        float f6 = (float)aj1.a;
        float f7 = (float)aj1.b;
        float f8 = (float)aj1.c;
        if(t.y.g)
        {
            float f9 = (f6 * 30F + f7 * 59F + f8 * 11F) / 100F;
            float f11 = (f6 * 30F + f7 * 70F) / 100F;
            float f13 = (f6 * 30F + f8 * 70F) / 100F;
            f6 = f9;
            f7 = f11;
            f8 = f13;
        }
        float f10 = (float)(d1 * 0.0D);
        float f12 = (float)(d2 * 0.0D);
        float f14 = 0.00390625F;
        f10 = (float)eo.b(d1) * f14;
        f12 = (float)eo.b(d2) * f14;
        float f15 = (float)(d1 - (double)eo.b(d1));
        float f16 = (float)(d2 - (double)eo.b(d2));
        int k1 = 8;
        byte byte0 = 3;
        float f17 = 0.0009765625F;
        GL11.glScalef(f3, 1.0F, f3);
        for(int l1 = 0; l1 < 2; l1++)
        {
            if(l1 == 0)
                GL11.glColorMask(false, false, false, false);
            else
                GL11.glColorMask(true, true, true, true);
            for(int i2 = -byte0 + 1; i2 <= byte0; i2++)
            {
                for(int j2 = -byte0 + 1; j2 <= byte0; j2++)
                {
                    ho1.b();
                    float f18 = i2 * k1;
                    float f19 = j2 * k1;
                    float f20 = f18 - f15;
                    float f21 = f19 - f16;
                    if(f5 > -f4 - 1.0F)
                    {
                        ho1.a(f6 * 0.7F, f7 * 0.7F, f8 * 0.7F, 0.8F);
                        ho1.b(0.0F, -1F, 0.0F);
                        ho1.a(f20 + 0.0F, f5 + 0.0F, f21 + (float)k1, (f18 + 0.0F) * f14 + f10, (f19 + (float)k1) * f14 + f12);
                        ho1.a(f20 + (float)k1, f5 + 0.0F, f21 + (float)k1, (f18 + (float)k1) * f14 + f10, (f19 + (float)k1) * f14 + f12);
                        ho1.a(f20 + (float)k1, f5 + 0.0F, f21 + 0.0F, (f18 + (float)k1) * f14 + f10, (f19 + 0.0F) * f14 + f12);
                        ho1.a(f20 + 0.0F, f5 + 0.0F, f21 + 0.0F, (f18 + 0.0F) * f14 + f10, (f19 + 0.0F) * f14 + f12);
                    }
                    if(f5 <= f4 + 1.0F)
                    {
                        ho1.a(f6, f7, f8, 0.8F);
                        ho1.b(0.0F, 1.0F, 0.0F);
                        ho1.a(f20 + 0.0F, (f5 + f4) - f17, f21 + (float)k1, (f18 + 0.0F) * f14 + f10, (f19 + (float)k1) * f14 + f12);
                        ho1.a(f20 + (float)k1, (f5 + f4) - f17, f21 + (float)k1, (f18 + (float)k1) * f14 + f10, (f19 + (float)k1) * f14 + f12);
                        ho1.a(f20 + (float)k1, (f5 + f4) - f17, f21 + 0.0F, (f18 + (float)k1) * f14 + f10, (f19 + 0.0F) * f14 + f12);
                        ho1.a(f20 + 0.0F, (f5 + f4) - f17, f21 + 0.0F, (f18 + 0.0F) * f14 + f10, (f19 + 0.0F) * f14 + f12);
                    }
                    ho1.a(f6 * 0.9F, f7 * 0.9F, f8 * 0.9F, 0.8F);
                    if(i2 > -1)
                    {
                        ho1.b(-1F, 0.0F, 0.0F);
                        for(int k2 = 0; k2 < k1; k2++)
                        {
                            ho1.a(f20 + (float)k2 + 0.0F, f5 + 0.0F, f21 + (float)k1, (f18 + (float)k2 + 0.5F) * f14 + f10, (f19 + (float)k1) * f14 + f12);
                            ho1.a(f20 + (float)k2 + 0.0F, f5 + f4, f21 + (float)k1, (f18 + (float)k2 + 0.5F) * f14 + f10, (f19 + (float)k1) * f14 + f12);
                            ho1.a(f20 + (float)k2 + 0.0F, f5 + f4, f21 + 0.0F, (f18 + (float)k2 + 0.5F) * f14 + f10, (f19 + 0.0F) * f14 + f12);
                            ho1.a(f20 + (float)k2 + 0.0F, f5 + 0.0F, f21 + 0.0F, (f18 + (float)k2 + 0.5F) * f14 + f10, (f19 + 0.0F) * f14 + f12);
                        }

                    }
                    if(i2 <= 1)
                    {
                        ho1.b(1.0F, 0.0F, 0.0F);
                        for(int l2 = 0; l2 < k1; l2++)
                        {
                            ho1.a((f20 + (float)l2 + 1.0F) - f17, f5 + 0.0F, f21 + (float)k1, (f18 + (float)l2 + 0.5F) * f14 + f10, (f19 + (float)k1) * f14 + f12);
                            ho1.a((f20 + (float)l2 + 1.0F) - f17, f5 + f4, f21 + (float)k1, (f18 + (float)l2 + 0.5F) * f14 + f10, (f19 + (float)k1) * f14 + f12);
                            ho1.a((f20 + (float)l2 + 1.0F) - f17, f5 + f4, f21 + 0.0F, (f18 + (float)l2 + 0.5F) * f14 + f10, (f19 + 0.0F) * f14 + f12);
                            ho1.a((f20 + (float)l2 + 1.0F) - f17, f5 + 0.0F, f21 + 0.0F, (f18 + (float)l2 + 0.5F) * f14 + f10, (f19 + 0.0F) * f14 + f12);
                        }

                    }
                    ho1.a(f6 * 0.8F, f7 * 0.8F, f8 * 0.8F, 0.8F);
                    if(j2 > -1)
                    {
                        ho1.b(0.0F, 0.0F, -1F);
                        for(int i3 = 0; i3 < k1; i3++)
                        {
                            ho1.a(f20 + 0.0F, f5 + f4, f21 + (float)i3 + 0.0F, (f18 + 0.0F) * f14 + f10, (f19 + (float)i3 + 0.5F) * f14 + f12);
                            ho1.a(f20 + (float)k1, f5 + f4, f21 + (float)i3 + 0.0F, (f18 + (float)k1) * f14 + f10, (f19 + (float)i3 + 0.5F) * f14 + f12);
                            ho1.a(f20 + (float)k1, f5 + 0.0F, f21 + (float)i3 + 0.0F, (f18 + (float)k1) * f14 + f10, (f19 + (float)i3 + 0.5F) * f14 + f12);
                            ho1.a(f20 + 0.0F, f5 + 0.0F, f21 + (float)i3 + 0.0F, (f18 + 0.0F) * f14 + f10, (f19 + (float)i3 + 0.5F) * f14 + f12);
                        }

                    }
                    if(j2 <= 1)
                    {
                        ho1.b(0.0F, 0.0F, 1.0F);
                        for(int j3 = 0; j3 < k1; j3++)
                        {
                            ho1.a(f20 + 0.0F, f5 + f4, (f21 + (float)j3 + 1.0F) - f17, (f18 + 0.0F) * f14 + f10, (f19 + (float)j3 + 0.5F) * f14 + f12);
                            ho1.a(f20 + (float)k1, f5 + f4, (f21 + (float)j3 + 1.0F) - f17, (f18 + (float)k1) * f14 + f10, (f19 + (float)j3 + 0.5F) * f14 + f12);
                            ho1.a(f20 + (float)k1, f5 + 0.0F, (f21 + (float)j3 + 1.0F) - f17, (f18 + (float)k1) * f14 + f10, (f19 + (float)j3 + 0.5F) * f14 + f12);
                            ho1.a(f20 + 0.0F, f5 + 0.0F, (f21 + (float)j3 + 1.0F) - f17, (f18 + 0.0F) * f14 + f10, (f19 + (float)j3 + 0.5F) * f14 + f12);
                        }

                    }
                    ho1.a();
                }

            }

        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public boolean a(dm dm1, boolean flag)
    {
        Collections.sort(m, ((java.util.Comparator) (new gl(dm1))));
        int i1 = m.size() - 1;
        int j1 = m.size();
        for(int k1 = 0; k1 < j1; k1++)
        {
            bn bn1 = (bn)m.get(i1 - k1);
            if(!flag)
            {
                if(bn1.a(((kh) (dm1))) > 1024F)
                    if(bn1.o)
                    {
                        if(k1 >= 3)
                            return false;
                    } else
                    if(k1 >= 1)
                        return false;
            } else
            if(!bn1.o)
                continue;
            bn1.a();
            m.remove(((Object) (bn1)));
            bn1.u = false;
        }

        return m.size() == 0;
    }

    public void a(dm dm1, mf mf1, int i1, ev ev, float f1)
    {
        ho ho1 = ho.a;
        GL11.glEnable(3042);
        GL11.glEnable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, (eo.a((float)System.currentTimeMillis() / 100F) * 0.2F + 0.4F) * 0.5F);
        if(i1 == 0)
        {
            if(i > 0.0F)
            {
                GL11.glBlendFunc(774, 768);
                int j1 = l.a("/terrain.png");
                GL11.glBindTexture(3553, j1);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
                GL11.glPushMatrix();
                int k1 = k.a(mf1.b, mf1.c, mf1.d);
                ly ly1 = k1 <= 0 ? null : ly.n[k1];
                GL11.glDisable(3008);
                GL11.glPolygonOffset(-3F, -3F);
                GL11.glEnable(32823);
                ho1.b();
                double d1 = dm1.aI + (dm1.ak - dm1.aI) * (double)f1;
                double d2 = dm1.aJ + (dm1.al - dm1.aJ) * (double)f1;
                double d3 = dm1.aK + (dm1.am - dm1.aK) * (double)f1;
                ho1.b(-d1, -d2, -d3);
                ho1.c();
                if(ly1 == null)
                    ly1 = ly.u;
                u.a(ly1, mf1.b, mf1.c, mf1.d, 240 + (int)(i * 10F));
                ho1.a();
                ho1.b(0.0D, 0.0D, 0.0D);
                GL11.glPolygonOffset(0.0F, 0.0F);
                GL11.glDisable(32823);
                GL11.glEnable(3008);
                GL11.glDepthMask(true);
                GL11.glPopMatrix();
            }
        } else
        if(ev != null)
        {
            GL11.glBlendFunc(770, 771);
            float f2 = eo.a((float)System.currentTimeMillis() / 100F) * 0.2F + 0.8F;
            GL11.glColor4f(f2, f2, f2, eo.a((float)System.currentTimeMillis() / 200F) * 0.2F + 0.5F);
            int l1 = l.a("/terrain.png");
            GL11.glBindTexture(3553, l1);
            int i2 = mf1.b;
            int j2 = mf1.c;
            int k2 = mf1.d;
            if(mf1.e == 0)
                j2--;
            if(mf1.e == 1)
                j2++;
            if(mf1.e == 2)
                k2--;
            if(mf1.e == 3)
                k2++;
            if(mf1.e == 4)
                i2--;
            if(mf1.e == 5)
                i2++;
        }
        GL11.glDisable(3042);
        GL11.glDisable(3008);
    }

    public void b(dm dm1, mf mf1, int i1, ev ev, float f1)
    {
        if(i1 == 0 && mf1.a == 0)
        {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
            GL11.glLineWidth(2.0F);
            GL11.glDisable(3553);
            GL11.glDepthMask(false);
            float f2 = 0.002F;
            int j1 = k.a(mf1.b, mf1.c, mf1.d);
            if(j1 > 0)
            {
                ly.n[j1].a(((nm) (k)), mf1.b, mf1.c, mf1.d);
                double d1 = dm1.aI + (dm1.ak - dm1.aI) * (double)f1;
                double d2 = dm1.aJ + (dm1.al - dm1.aJ) * (double)f1;
                double d3 = dm1.aK + (dm1.am - dm1.aK) * (double)f1;
                a(ly.n[j1].f(k, mf1.b, mf1.c, mf1.d).b(f2, f2, f2).c(-d1, -d2, -d3));
            }
            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
        }
    }

    private void a(cf cf1)
    {
        ho ho1 = ho.a;
        ho1.a(3);
        ho1.a(cf1.a, cf1.b, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.f);
        ho1.a(cf1.a, cf1.b, cf1.f);
        ho1.a(cf1.a, cf1.b, cf1.c);
        ho1.a();
        ho1.a(3);
        ho1.a(cf1.a, cf1.e, cf1.c);
        ho1.a(cf1.d, cf1.e, cf1.c);
        ho1.a(cf1.d, cf1.e, cf1.f);
        ho1.a(cf1.a, cf1.e, cf1.f);
        ho1.a(cf1.a, cf1.e, cf1.c);
        ho1.a();
        ho1.a(1);
        ho1.a(cf1.a, cf1.b, cf1.c);
        ho1.a(cf1.a, cf1.e, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.c);
        ho1.a(cf1.d, cf1.e, cf1.c);
        ho1.a(cf1.d, cf1.b, cf1.f);
        ho1.a(cf1.d, cf1.e, cf1.f);
        ho1.a(cf1.a, cf1.b, cf1.f);
        ho1.a(cf1.a, cf1.e, cf1.f);
        ho1.a();
    }

    public void a(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = eo.a(i1, 16);
        int l2 = eo.a(j1, 16);
        int i3 = eo.a(k1, 16);
        int j3 = eo.a(l1, 16);
        int k3 = eo.a(i2, 16);
        int l3 = eo.a(j2, 16);
        for(int i4 = k2; i4 <= j3; i4++)
        {
            int j4 = i4 % p;
            if(j4 < 0)
                j4 += p;
            for(int k4 = l2; k4 <= k3; k4++)
            {
                int l4 = k4 % q;
                if(l4 < 0)
                    l4 += q;
                for(int i5 = i3; i5 <= l3; i5++)
                {
                    int j5 = i5 % r;
                    if(j5 < 0)
                        j5 += r;
                    int k5 = (j5 * q + l4) * p + j4;
                    bn bn1 = o[k5];
                    if(!bn1.u)
                        m.add(((Object) (bn1)));
                    bn1.f();
                }

            }

        }

    }

    public void a(int i1, int j1, int k1)
    {
        a(i1 - 1, j1 - 1, k1 - 1, i1 + 1, j1 + 1, k1 + 1);
    }

    public void b(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        a(i1 - 1, j1 - 1, k1 - 1, l1 + 1, i2 + 1, j2 + 1);
    }

    public void a(oe oe1, float f1)
    {
        for(int i1 = 0; i1 < o.length; i1++)
            if(!o[i1].e() && (!o[i1].o || (i1 + j & 0xf) == 0))
                o[i1].a(oe1);

        j++;
    }

    public void a(String s1, int i1, int j1, int k1)
    {
        if(s1 != null)
            t.u.b((new StringBuilder()).append("C418 - ").append(s1).toString());
        t.A.a(s1, i1, j1, k1, 1.0F, 1.0F);
    }

    public void a(String s1, double d1, double d2, double d3, 
            float f1, float f2)
    {
        float f3 = 16F;
        if(f1 > 1.0F)
            f3 *= f1;
        if(t.g.d(d1, d2, d3) < (double)(f3 * f3))
            t.A.b(s1, (float)d1, (float)d2, (float)d3, f1, f2);
    }

    public void a(String s1, double d1, double d2, double d3, 
            double d4, double d5, double d6)
    {
        double d7 = t.g.ak - d1;
        double d8 = t.g.al - d2;
        double d9 = t.g.am - d3;
        if(d7 * d7 + d8 * d8 + d9 * d9 > 256D)
            return;
        if(s1 == "bubble")
            t.h.a(((nq) (new ba(k, d1, d2, d3, d4, d5, d6))));
        else
        if(s1 == "smoke")
            t.h.a(((nq) (new nl(k, d1, d2, d3))));
        else
        if(s1 == "explode")
            t.h.a(((nq) (new dp(k, d1, d2, d3, d4, d5, d6))));
        else
        if(s1 == "flame")
            t.h.a(((nq) (new jb(k, d1, d2, d3, d4, d5, d6))));
        else
        if(s1 == "lava")
            t.h.a(((nq) (new cq(k, d1, d2, d3))));
        else
        if(s1 == "splash")
            t.h.a(((nq) (new kq(k, d1, d2, d3, d4, d5, d6))));
        else
        if(s1 == "largesmoke")
            t.h.a(((nq) (new nl(k, d1, d2, d3, 2.5F))));
        else
        if(s1 == "reddust")
            t.h.a(((nq) (new en(k, d1, d2, d3))));
        else
        if(s1 == "snowballpoof")
            t.h.a(((nq) (new ig(k, d1, d2, d3, di.aB))));
        else
        if(s1 == "slime")
            t.h.a(((nq) (new ig(k, d1, d2, d3, di.aK))));
    }

    public void a(kh kh1)
    {
        if(kh1.aY != null)
            l.a(kh1.aY, ((hb) (new jr())));
    }

    public void b(kh kh1)
    {
        if(kh1.aY != null)
            l.b(kh1.aY);
    }

    public void e()
    {
        for(int i1 = 0; i1 < o.length; i1++)
        {
            if(!o[i1].A)
                continue;
            if(!o[i1].u)
                m.add(((Object) (o[i1])));
            o[i1].f();
        }

    }

    public void a(int i1, int j1, int k1, ic ic1)
    {
    }

    public List a;
    private cn k;
    private ey l;
    private List m;
    private bn n[];
    private bn o[];
    private int p;
    private int q;
    private int r;
    private int s;
    private Minecraft t;
    private bc u;
    private IntBuffer v;
    private boolean w;
    private int x;
    private int y;
    private int z;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    int b[];
    IntBuffer c;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private List R;
    private kw S[] = {
        new kw(), new kw(), new kw(), new kw()
    };
    int d;
    int e;
    double f;
    double g;
    double h;
    public float i;
    int j;
}
