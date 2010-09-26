package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.Random;

public class nw
    implements aw
{

    public nw(cn cn1, long l1)
    {
        r = new double[256];
        s = new double[256];
        t = new double[256];
        u = ((cy) (new kk()));
        i = new int[32][32];
        p = cn1;
        j = new Random(l1);
        k = new lp(j, 16);
        l = new lp(j, 16);
        m = new lp(j, 8);
        n = new lp(j, 4);
        o = new lp(j, 4);
        a = new lp(j, 10);
        b = new lp(j, 16);
        c = new lp(j, 8);
    }

    public void a(int i1, int j1, byte abyte0[])
    {
        byte byte0 = 4;
        byte byte1 = 64;
        int k1 = byte0 + 1;
        byte byte2 = 17;
        int l1 = byte0 + 1;
        q = a(q, i1 * byte0, 0, j1 * byte0, k1, ((int) (byte2)), l1);
        for(int i2 = 0; i2 < byte0; i2++)
        {
            for(int j2 = 0; j2 < byte0; j2++)
            {
                for(int k2 = 0; k2 < 16; k2++)
                {
                    double d1 = 0.125D;
                    double d2 = q[((i2 + 0) * l1 + (j2 + 0)) * byte2 + (k2 + 0)];
                    double d3 = q[((i2 + 0) * l1 + (j2 + 1)) * byte2 + (k2 + 0)];
                    double d4 = q[((i2 + 1) * l1 + (j2 + 0)) * byte2 + (k2 + 0)];
                    double d5 = q[((i2 + 1) * l1 + (j2 + 1)) * byte2 + (k2 + 0)];
                    double d6 = (q[((i2 + 0) * l1 + (j2 + 0)) * byte2 + (k2 + 1)] - d2) * d1;
                    double d7 = (q[((i2 + 0) * l1 + (j2 + 1)) * byte2 + (k2 + 1)] - d3) * d1;
                    double d8 = (q[((i2 + 1) * l1 + (j2 + 0)) * byte2 + (k2 + 1)] - d4) * d1;
                    double d9 = (q[((i2 + 1) * l1 + (j2 + 1)) * byte2 + (k2 + 1)] - d5) * d1;
                    for(int l2 = 0; l2 < 8; l2++)
                    {
                        double d10 = 0.25D;
                        double d11 = d2;
                        double d12 = d3;
                        double d13 = (d4 - d2) * d10;
                        double d14 = (d5 - d3) * d10;
                        for(int i3 = 0; i3 < 4; i3++)
                        {
                            int j3 = i3 + i2 * 4 << 11 | 0 + j2 * 4 << 7 | k2 * 8 + l2;
                            char c1 = '\200';
                            double d15 = 0.25D;
                            double d16 = d11;
                            double d17 = (d12 - d11) * d15;
                            for(int k3 = 0; k3 < 4; k3++)
                            {
                                int l3 = 0;
                                if(k2 * 8 + l2 < byte1)
                                    if(p.d && k2 * 8 + l2 >= byte1 - 1)
                                        l3 = ly.aU.bc;
                                    else
                                        l3 = ly.C.bc;
                                if(d16 > 0.0D)
                                    l3 = ly.u.bc;
                                abyte0[j3] = (byte)l3;
                                j3 += ((int) (c1));
                                d16 += d17;
                            }

                            d11 += d13;
                            d12 += d14;
                        }

                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }

                }

            }

        }

    }

    public void b(int i1, int j1, byte abyte0[])
    {
        byte byte0 = 64;
        double d1 = 0.03125D;
        r = n.a(r, i1 * 16, j1 * 16, 0.0D, 16, 16, 1, d1, d1, 1.0D);
        s = n.a(s, j1 * 16, 109.0134D, i1 * 16, 16, 1, 16, d1, 1.0D, d1);
        t = o.a(t, i1 * 16, j1 * 16, 0.0D, 16, 16, 1, d1 * 2D, d1 * 2D, d1 * 2D);
        for(int k1 = 0; k1 < 16; k1++)
        {
            for(int l1 = 0; l1 < 16; l1++)
            {
                boolean flag = r[k1 + l1 * 16] + j.nextDouble() * 0.20000000000000001D > 0.0D;
                boolean flag1 = s[k1 + l1 * 16] + j.nextDouble() * 0.20000000000000001D > 3D;
                int i2 = (int)(t[k1 + l1 * 16] / 3D + 3D + j.nextDouble() * 0.25D);
                int j2 = -1;
                byte byte1 = (byte)ly.v.bc;
                byte byte2 = (byte)ly.w.bc;
                for(int k2 = 127; k2 >= 0; k2--)
                {
                    int l2 = (k1 * 16 + l1) * 128 + k2;
                    if(k2 <= (0 + j.nextInt(6)) - 1)
                    {
                        abyte0[l2] = (byte)ly.A.bc;
                        continue;
                    }
                    byte byte3 = abyte0[l2];
                    if(byte3 == 0)
                    {
                        j2 = -1;
                        continue;
                    }
                    if(byte3 != ly.u.bc)
                        continue;
                    if(j2 == -1)
                    {
                        if(i2 <= 0)
                        {
                            byte1 = 0;
                            byte2 = (byte)ly.u.bc;
                        } else
                        if(k2 >= byte0 - 4 && k2 <= byte0 + 1)
                        {
                            byte1 = (byte)ly.v.bc;
                            byte2 = (byte)ly.w.bc;
                            if(flag1)
                                byte1 = 0;
                            if(flag1)
                                byte2 = (byte)ly.G.bc;
                            if(flag)
                                byte1 = (byte)ly.F.bc;
                            if(flag)
                                byte2 = (byte)ly.F.bc;
                        }
                        if(k2 < byte0 && byte1 == 0)
                            byte1 = (byte)ly.C.bc;
                        j2 = i2;
                        if(k2 >= byte0 - 1)
                            abyte0[l2] = byte1;
                        else
                            abyte0[l2] = byte2;
                        continue;
                    }
                    if(j2 > 0)
                    {
                        j2--;
                        abyte0[l2] = byte2;
                    }
                }

            }

        }

    }

    public ga b(int i1, int j1)
    {
        j.setSeed((long)i1 * 0x4f9939f508L + (long)j1 * 0x1ef1565bd5L);
        byte abyte0[] = new byte[32768];
        ga ga1 = new ga(p, abyte0, i1, j1);
        a(i1, j1, abyte0);
        b(i1, j1, abyte0);
        u.a(this, p, i1, j1, abyte0);
        ga1.c();
        return ga1;
    }

    private double[] a(double ad[], int i1, int j1, int k1, int l1, int i2, int j2)
    {
        if(ad == null)
            ad = new double[l1 * i2 * j2];
        double d1 = 684.41200000000003D;
        double d2 = 684.41200000000003D;
        g = a.a(g, i1, j1, k1, l1, 1, j2, 1.0D, 0.0D, 1.0D);
        h = b.a(h, i1, j1, k1, l1, 1, j2, 100D, 0.0D, 100D);
        d = m.a(d, i1, j1, k1, l1, i2, j2, d1 / 80D, d2 / 160D, d1 / 80D);
        e = k.a(e, i1, j1, k1, l1, i2, j2, d1, d2, d1);
        f = l.a(f, i1, j1, k1, l1, i2, j2, d1, d2, d1);
        int k2 = 0;
        int l2 = 0;
        for(int i3 = 0; i3 < l1; i3++)
        {
            for(int j3 = 0; j3 < j2; j3++)
            {
                double d3 = (g[l2] + 256D) / 512D;
                if(d3 > 1.0D)
                    d3 = 1.0D;
                double d4 = 0.0D;
                double d5 = h[l2] / 8000D;
                if(d5 < 0.0D)
                    d5 = -d5;
                d5 = d5 * 3D - 3D;
                if(d5 < 0.0D)
                {
                    d5 /= 2D;
                    if(d5 < -1D)
                        d5 = -1D;
                    d5 /= 1.3999999999999999D;
                    d5 /= 2D;
                    d3 = 0.0D;
                } else
                {
                    if(d5 > 1.0D)
                        d5 = 1.0D;
                    d5 /= 6D;
                }
                d3 += 0.5D;
                d5 = (d5 * (double)i2) / 16D;
                double d6 = (double)i2 / 2D + d5 * 4D;
                l2++;
                for(int k3 = 0; k3 < i2; k3++)
                {
                    double d7 = 0.0D;
                    double d8 = (((double)k3 - d6) * 12D) / d3;
                    if(d8 < 0.0D)
                        d8 *= 4D;
                    double d9 = e[k2] / 512D;
                    double d10 = f[k2] / 512D;
                    double d11 = (d[k2] / 10D + 1.0D) / 2D;
                    if(d11 < 0.0D)
                        d7 = d9;
                    else
                    if(d11 > 1.0D)
                        d7 = d10;
                    else
                        d7 = d9 + (d10 - d9) * d11;
                    d7 -= d8;
                    if(k3 > i2 - 4)
                    {
                        double d12 = (float)(k3 - (i2 - 4)) / 3F;
                        d7 = d7 * (1.0D - d12) + -10D * d12;
                    }
                    if((double)k3 < d4)
                    {
                        double d13 = (d4 - (double)k3) / 4D;
                        if(d13 < 0.0D)
                            d13 = 0.0D;
                        if(d13 > 1.0D)
                            d13 = 1.0D;
                        d7 = d7 * (1.0D - d13) + -10D * d13;
                    }
                    ad[k2] = d7;
                    k2++;
                }

            }

        }

        return ad;
    }

    public boolean a(int i1, int j1)
    {
        return true;
    }

    public void a(aw aw1, int i1, int j1)
    {
        dh.a = true;
        int k1 = i1 * 16;
        int l1 = j1 * 16;
        j.setSeed(p.u);
        long l2 = (j.nextLong() / 2L) * 2L + 1L;
        long l3 = (j.nextLong() / 2L) * 2L + 1L;
        j.setSeed((long)i1 * l2 + (long)j1 * l3 ^ p.u);
        double d1 = 0.25D;
        for(int i2 = 0; i2 < 8; i2++)
        {
            int i5 = k1 + j.nextInt(16) + 8;
            int j7 = j.nextInt(128);
            int i12 = l1 + j.nextInt(16) + 8;
            (new cg()).a(p, j, i5, j7, i12);
        }

        for(int j2 = 0; j2 < 10; j2++)
        {
            int j5 = k1 + j.nextInt(16);
            int k7 = j.nextInt(128);
            int j12 = l1 + j.nextInt(16);
            (new gv(32)).a(p, j, j5, k7, j12);
        }

        for(int k2 = 0; k2 < 20; k2++)
        {
            int k5 = k1 + j.nextInt(16);
            int l7 = j.nextInt(128);
            int k12 = l1 + j.nextInt(16);
            (new cu(ly.w.bc, 32)).a(p, j, k5, l7, k12);
        }

        for(int i3 = 0; i3 < 10; i3++)
        {
            int l5 = k1 + j.nextInt(16);
            int i8 = j.nextInt(128);
            int l12 = l1 + j.nextInt(16);
            (new cu(ly.G.bc, 32)).a(p, j, l5, i8, l12);
        }

        for(int j3 = 0; j3 < 20; j3++)
        {
            int i6 = k1 + j.nextInt(16);
            int j8 = j.nextInt(128);
            int i13 = l1 + j.nextInt(16);
            (new cu(ly.J.bc, 16)).a(p, j, i6, j8, i13);
        }

        for(int k3 = 0; k3 < 20; k3++)
        {
            int j6 = k1 + j.nextInt(16);
            int k8 = j.nextInt(64);
            int j13 = l1 + j.nextInt(16);
            (new cu(ly.I.bc, 8)).a(p, j, j6, k8, j13);
        }

        for(int i4 = 0; i4 < 2; i4++)
        {
            int k6 = k1 + j.nextInt(16);
            int l8 = j.nextInt(32);
            int k13 = l1 + j.nextInt(16);
            (new cu(ly.H.bc, 8)).a(p, j, k6, l8, k13);
        }

        for(int j4 = 0; j4 < 8; j4++)
        {
            int l6 = k1 + j.nextInt(16);
            int i9 = j.nextInt(16);
            int l13 = l1 + j.nextInt(16);
            (new cu(ly.aO.bc, 7)).a(p, j, l6, i9, l13);
        }

        for(int k4 = 0; k4 < 1; k4++)
        {
            int i7 = k1 + j.nextInt(16);
            int j9 = j.nextInt(16);
            int i14 = l1 + j.nextInt(16);
            (new cu(ly.ax.bc, 7)).a(p, j, i7, j9, i14);
        }

        d1 = 0.5D;
        int l4 = (int)((c.a((double)k1 * d1, (double)l1 * d1) / 8D + j.nextDouble() * 4D + 4D) / 3D);
        if(l4 < 0)
            l4 = 0;
        if(j.nextInt(10) == 0)
            l4++;
        Object obj = ((Object) (new oa()));
        if(j.nextInt(10) == 0)
            obj = ((Object) (new ej()));
        for(int k9 = 0; k9 < l4; k9++)
        {
            int j14 = k1 + j.nextInt(16) + 8;
            int l16 = l1 + j.nextInt(16) + 8;
            ((ik) (obj)).a(1.0D, 1.0D, 1.0D);
            ((ik) (obj)).a(p, j, j14, p.c(j14, l16), l16);
        }

        for(int l9 = 0; l9 < 2; l9++)
        {
            int k14 = k1 + j.nextInt(16) + 8;
            int i17 = j.nextInt(128);
            int j19 = l1 + j.nextInt(16) + 8;
            (new ae(ly.ae.bc)).a(p, j, k14, i17, j19);
        }

        if(j.nextInt(2) == 0)
        {
            int i10 = k1 + j.nextInt(16) + 8;
            int l14 = j.nextInt(128);
            int j17 = l1 + j.nextInt(16) + 8;
            (new ae(ly.af.bc)).a(p, j, i10, l14, j17);
        }
        if(j.nextInt(4) == 0)
        {
            int j10 = k1 + j.nextInt(16) + 8;
            int i15 = j.nextInt(128);
            int k17 = l1 + j.nextInt(16) + 8;
            (new ae(ly.ag.bc)).a(p, j, j10, i15, k17);
        }
        if(j.nextInt(8) == 0)
        {
            int k10 = k1 + j.nextInt(16) + 8;
            int j15 = j.nextInt(128);
            int l17 = l1 + j.nextInt(16) + 8;
            (new ae(ly.ah.bc)).a(p, j, k10, j15, l17);
        }
        for(int l10 = 0; l10 < 10; l10++)
        {
            int k15 = k1 + j.nextInt(16) + 8;
            int i18 = j.nextInt(128);
            int k19 = l1 + j.nextInt(16) + 8;
            (new es()).a(p, j, k15, i18, k19);
        }

        for(int i11 = 0; i11 < 1; i11++)
        {
            int l15 = k1 + j.nextInt(16) + 8;
            int j18 = j.nextInt(128);
            int l19 = l1 + j.nextInt(16) + 8;
            (new da()).a(p, j, l15, j18, l19);
        }

        for(int j11 = 0; j11 < 50; j11++)
        {
            int i16 = k1 + j.nextInt(16) + 8;
            int k18 = j.nextInt(j.nextInt(120) + 8);
            int i20 = l1 + j.nextInt(16) + 8;
            (new nn(ly.B.bc)).a(p, j, i16, k18, i20);
        }

        for(int k11 = 0; k11 < 20; k11++)
        {
            int j16 = k1 + j.nextInt(16) + 8;
            int l18 = j.nextInt(j.nextInt(j.nextInt(112) + 8) + 8);
            int j20 = l1 + j.nextInt(16) + 8;
            (new nn(ly.D.bc)).a(p, j, j16, l18, j20);
        }

        for(int l11 = k1 + 8 + 0; l11 < k1 + 8 + 16; l11++)
        {
            for(int k16 = l1 + 8 + 0; k16 < l1 + 8 + 16; k16++)
            {
                int i19 = p.d(l11, k16);
                if(p.d && i19 > 0 && i19 < 128 && p.a(l11, i19, k16) == 0 && p.f(l11, i19 - 1, k16).c() && p.f(l11, i19 - 1, k16) != gb.r)
                    p.d(l11, i19, k16, ly.aT.bc);
            }

        }

        dh.a = false;
    }

    public boolean a(boolean flag, nu nu)
    {
        return true;
    }

    public boolean a()
    {
        return false;
    }

    public boolean b()
    {
        return true;
    }

    private Random j;
    private lp k;
    private lp l;
    private lp m;
    private lp n;
    private lp o;
    public lp a;
    public lp b;
    public lp c;
    private cn p;
    private double q[];
    private double r[];
    private double s[];
    private double t[];
    private cy u;
    double d[];
    double e[];
    double f[];
    double g[];
    double h[];
    int i[][];
}
