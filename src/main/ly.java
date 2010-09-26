package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.util.ArrayList;
import java.util.Random;

public class ly
{

    protected ly(int i1, gb gb1)
    {
        bl = e;
        bm = 1.0F;
        bo = 0.6F;
        if(n[i1] != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Slot ").append(i1).append(" is already occupied by ").append(((Object) (n[i1]))).append(" when adding ").append(((Object) (this))).toString());
        } else
        {
            bn = gb1;
            n[i1] = this;
            bc = i1;
            a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            p[i1] = b();
            r[i1] = b() ? 255 : 0;
            s[i1] = i();
            q[i1] = false;
            return;
        }
    }

    protected ly(int i1, int j1, gb gb1)
    {
        this(i1, gb1);
        bb = j1;
    }

    protected ly a(bb bb1)
    {
        bl = bb1;
        return this;
    }

    protected ly d(int i1)
    {
        r[bc] = i1;
        return this;
    }

    protected ly a(float f1)
    {
        t[bc] = (int)(15F * f1);
        return this;
    }

    protected ly b(float f1)
    {
        be = f1 * 3F;
        return this;
    }

    private boolean i()
    {
        return false;
    }

    public boolean c()
    {
        return true;
    }

    public int f()
    {
        return 0;
    }

    protected ly c(float f1)
    {
        bd = f1;
        if(be < f1 * 5F)
            be = f1 * 5F;
        return this;
    }

    protected void b(boolean flag)
    {
        o[bc] = flag;
    }

    public void a(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        bf = f1;
        bg = f2;
        bh = f3;
        bi = f4;
        bj = f5;
        bk = f6;
    }

    public float c(nm nm1, int i1, int j1, int k1)
    {
        return nm1.c(i1, j1, k1);
    }

    public boolean c(nm nm1, int i1, int j1, int k1, int l1)
    {
        if(l1 == 0 && bg > 0.0D)
            return true;
        if(l1 == 1 && bj < 1.0D)
            return true;
        if(l1 == 2 && bh > 0.0D)
            return true;
        if(l1 == 3 && bk < 1.0D)
            return true;
        if(l1 == 4 && bf > 0.0D)
            return true;
        if(l1 == 5 && bi < 1.0D)
            return true;
        else
            return !nm1.g(i1, j1, k1);
    }

    public int a(nm nm1, int i1, int j1, int k1, int l1)
    {
        return a(l1, nm1.e(i1, j1, k1));
    }

    public int a(int i1, int j1)
    {
        return a(i1);
    }

    public int a(int i1)
    {
        return bb;
    }

    public cf f(cn cn1, int i1, int j1, int k1)
    {
        return cf.b((double)i1 + bf, (double)j1 + bg, (double)k1 + bh, (double)i1 + bi, (double)j1 + bj, (double)k1 + bk);
    }

    public void a(cn cn1, int i1, int j1, int k1, cf cf1, ArrayList arraylist)
    {
        cf cf2 = d(cn1, i1, j1, k1);
        if(cf2 != null && cf1.a(cf2))
            arraylist.add(((Object) (cf2)));
    }

    public cf d(cn cn1, int i1, int j1, int k1)
    {
        return cf.b((double)i1 + bf, (double)j1 + bg, (double)k1 + bh, (double)i1 + bi, (double)j1 + bj, (double)k1 + bk);
    }

    public boolean b()
    {
        return true;
    }

    public boolean a(int i1, boolean flag)
    {
        return h();
    }

    public boolean h()
    {
        return true;
    }

    public void a(cn cn1, int i1, int j1, int k1, Random random)
    {
    }

    public void b(cn cn1, int i1, int j1, int k1, Random random)
    {
    }

    public void b(cn cn1, int i1, int j1, int k1, int l1)
    {
    }

    public void a(cn cn1, int i1, int j1, int k1, int l1)
    {
    }

    public int a()
    {
        return 10;
    }

    public void e(cn cn1, int i1, int j1, int k1)
    {
    }

    public void b(cn cn1, int i1, int j1, int k1)
    {
    }

    public int a(Random random)
    {
        return 1;
    }

    public int a(int i1, Random random)
    {
        return bc;
    }

    public float a(dm dm1)
    {
        if(bd < 0.0F)
            return 0.0F;
        if(!dm1.b(this))
            return 1.0F / bd / 100F;
        else
            return dm1.a(this) / bd / 30F;
    }

    public void b_(cn cn1, int i1, int j1, int k1, int l1)
    {
        a(cn1, i1, j1, k1, l1, 1.0F);
    }

    public void a(cn cn1, int i1, int j1, int k1, int l1, float f1)
    {
        if(cn1.y)
            return;
        int i2 = a(cn1.n);
        for(int j2 = 0; j2 < i2; j2++)
        {
            if(cn1.n.nextFloat() > f1)
                continue;
            int k2 = a(l1, cn1.n);
            if(k2 > 0)
            {
                float f2 = 0.7F;
                double d1 = (double)(cn1.n.nextFloat() * f2) + (double)(1.0F - f2) * 0.5D;
                double d2 = (double)(cn1.n.nextFloat() * f2) + (double)(1.0F - f2) * 0.5D;
                double d3 = (double)(cn1.n.nextFloat() * f2) + (double)(1.0F - f2) * 0.5D;
                dx dx1 = new dx(cn1, (double)i1 + d1, (double)j1 + d2, (double)k1 + d3, new ev(k2));
                dx1.c = 10;
                cn1.a(((kh) (dx1)));
            }
        }

    }

    public float a(kh kh)
    {
        return be / 5F;
    }

    public mf a(cn cn1, int i1, int j1, int k1, aj aj1, aj aj2)
    {
        a(((nm) (cn1)), i1, j1, k1);
        aj1 = aj1.c(-i1, -j1, -k1);
        aj2 = aj2.c(-i1, -j1, -k1);
        aj aj3 = aj1.a(aj2, bf);
        aj aj4 = aj1.a(aj2, bi);
        aj aj5 = aj1.b(aj2, bg);
        aj aj6 = aj1.b(aj2, bj);
        aj aj7 = aj1.c(aj2, bh);
        aj aj8 = aj1.c(aj2, bk);
        if(!a(aj3))
            aj3 = null;
        if(!a(aj4))
            aj4 = null;
        if(!b(aj5))
            aj5 = null;
        if(!b(aj6))
            aj6 = null;
        if(!c(aj7))
            aj7 = null;
        if(!c(aj8))
            aj8 = null;
        aj aj9 = null;
        if(aj3 != null && (aj9 == null || aj1.c(aj3) < aj1.c(aj9)))
            aj9 = aj3;
        if(aj4 != null && (aj9 == null || aj1.c(aj4) < aj1.c(aj9)))
            aj9 = aj4;
        if(aj5 != null && (aj9 == null || aj1.c(aj5) < aj1.c(aj9)))
            aj9 = aj5;
        if(aj6 != null && (aj9 == null || aj1.c(aj6) < aj1.c(aj9)))
            aj9 = aj6;
        if(aj7 != null && (aj9 == null || aj1.c(aj7) < aj1.c(aj9)))
            aj9 = aj7;
        if(aj8 != null && (aj9 == null || aj1.c(aj8) < aj1.c(aj9)))
            aj9 = aj8;
        if(aj9 == null)
            return null;
        byte byte0 = -1;
        if(aj9 == aj3)
            byte0 = 4;
        if(aj9 == aj4)
            byte0 = 5;
        if(aj9 == aj5)
            byte0 = 0;
        if(aj9 == aj6)
            byte0 = 1;
        if(aj9 == aj7)
            byte0 = 2;
        if(aj9 == aj8)
            byte0 = 3;
        return new mf(i1, j1, k1, ((int) (byte0)), aj9.c(i1, j1, k1));
    }

    private boolean a(aj aj1)
    {
        if(aj1 == null)
            return false;
        else
            return aj1.b >= bg && aj1.b <= bj && aj1.c >= bh && aj1.c <= bk;
    }

    private boolean b(aj aj1)
    {
        if(aj1 == null)
            return false;
        else
            return aj1.a >= bf && aj1.a <= bi && aj1.c >= bh && aj1.c <= bk;
    }

    private boolean c(aj aj1)
    {
        if(aj1 == null)
            return false;
        else
            return aj1.a >= bf && aj1.a <= bi && aj1.b >= bg && aj1.b <= bj;
    }

    public void c(cn cn1, int i1, int j1, int k1)
    {
    }

    public int g()
    {
        return 0;
    }

    public boolean a(cn cn1, int i1, int j1, int k1)
    {
        int l1 = cn1.a(i1, j1, k1);
        return l1 == 0 || n[l1].bn.d();
    }

    public boolean a(cn cn1, int i1, int j1, int k1, dm dm1)
    {
        return false;
    }

    public void a(cn cn1, int i1, int j1, int k1, kh kh)
    {
    }

    public void d(cn cn1, int i1, int j1, int k1, int l1)
    {
    }

    public void b(cn cn1, int i1, int j1, int k1, dm dm1)
    {
    }

    public void a(cn cn1, int i1, int j1, int k1, kh kh, aj aj1)
    {
    }

    public void a(nm nm1, int i1, int j1, int k1)
    {
    }

    public int d(nm nm1, int i1, int j1, int k1)
    {
        return 0xffffff;
    }

    public boolean b(nm nm1, int i1, int j1, int k1, int l1)
    {
        return false;
    }

    public boolean d()
    {
        return false;
    }

    public void b(cn cn1, int i1, int j1, int k1, kh kh)
    {
    }

    public boolean c(cn cn1, int i1, int j1, int k1, int l1)
    {
        return false;
    }

    public void e()
    {
    }

    public void a_(cn cn1, int i1, int j1, int k1, int l1)
    {
        b_(cn1, i1, j1, k1, l1);
    }

    public boolean g(cn cn1, int i1, int j1, int k1)
    {
        return true;
    }

    public static final bb e;
    public static final bb f;
    public static final bb g;
    public static final bb h;
    public static final bb i;
    public static final bb j;
    public static final bb k;
    public static final bb l;
    public static final bb m;
    public static final ly n[];
    public static final boolean o[] = new boolean[256];
    public static final boolean p[] = new boolean[256];
    public static final boolean q[] = new boolean[256];
    public static final int r[] = new int[256];
    public static final boolean s[] = new boolean[256];
    public static final int t[] = new int[256];
    public static final ly u;
    public static final my v;
    public static final ly w;
    public static final ly x;
    public static final ly y;
    public static final ly z;
    public static final ly A;
    public static final ly B;
    public static final ly C;
    public static final ly D;
    public static final ly E;
    public static final ly F;
    public static final ly G;
    public static final ly H;
    public static final ly I;
    public static final ly J;
    public static final ly K;
    public static final iz L;
    public static final ly M;
    public static final ly N;
    public static final ly O = null;
    public static final ly P = null;
    public static final ly Q = null;
    public static final ly R = null;
    public static final ly S = null;
    public static final ly T = null;
    public static final ly U = null;
    public static final ly V = null;
    public static final ly W = null;
    public static final ly X = null;
    public static final ly Y = null;
    public static final ly Z = null;
    public static final ly aa = null;
    public static final ly ab = null;
    public static final ly ac;
    public static final ly ad = null;
    public static final mq ae;
    public static final mq af;
    public static final mq ag;
    public static final mq ah;
    public static final ly ai;
    public static final ly aj;
    public static final ly ak;
    public static final ly al;
    public static final ly am;
    public static final ly an;
    public static final ly ao;
    public static final ly ap;
    public static final ly aq;
    public static final ly ar;
    public static final og as;
    public static final ly at;
    public static final ly au;
    public static final ly av;
    public static final ly aw;
    public static final ly ax;
    public static final ly ay;
    public static final ly az;
    public static final ly aA;
    public static final ly aB;
    public static final ly aC;
    public static final ly aD;
    public static final ly aE;
    public static final ly aF;
    public static final ly aG;
    public static final ly aH;
    public static final ly aI;
    public static final ly aJ;
    public static final ly aK;
    public static final ly aL;
    public static final ly aM;
    public static final ly aN;
    public static final ly aO;
    public static final ly aP;
    public static final ly aQ;
    public static final ly aR;
    public static final ly aS;
    public static final ly aT;
    public static final ly aU;
    public static final ly aV;
    public static final ly aW;
    public static final ly aX;
    public static final ly aY;
    public static final ly aZ;
    public static final ly ba;
    public int bb;
    public final int bc;
    protected float bd;
    protected float be;
    public double bf;
    public double bg;
    public double bh;
    public double bi;
    public double bj;
    public double bk;
    public bb bl;
    public float bm;
    public final gb bn;
    public float bo;

    static 
    {
        e = new bb("stone", 1.0F, 1.0F);
        f = new bb("wood", 1.0F, 1.0F);
        g = new bb("gravel", 1.0F, 1.0F);
        h = new bb("grass", 1.0F, 1.0F);
        i = new bb("stone", 1.0F, 1.0F);
        j = new bb("stone", 1.0F, 1.5F);
        k = ((bb) (new u("stone", 1.0F, 1.0F)));
        l = new bb("cloth", 1.0F, 1.0F);
        m = ((bb) (new t("sand", 1.0F, 1.0F)));
        n = new ly[256];
        u = (new ce(1, 1)).c(1.5F).b(10F).a(i);
        v = (my)(new my(2)).c(0.6F).a(h);
        w = (new hz(3, 2)).c(0.5F).a(g);
        x = (new ly(4, 16, gb.d)).c(2.0F).b(10F).a(i);
        y = (new ly(5, 4, gb.c)).c(2.0F).b(5F).a(f);
        z = (new dt(6, 15)).c(0.0F).a(h);
        A = (new ly(7, 17, gb.d)).c(-1F).b(6000000F).a(i);
        B = (new hv(8, gb.f)).c(100F).d(3);
        C = (new hn(9, gb.f)).c(100F).d(3);
        D = (new hv(10, gb.g)).c(0.0F).a(1.0F).d(255);
        E = (new hn(11, gb.g)).c(100F).a(1.0F).d(255);
        F = (new dh(12, 18)).c(0.5F).a(m);
        G = (new gz(13, 19)).c(0.6F).a(g);
        H = (new gw(14, 32)).c(3F).b(5F).a(i);
        I = (new gw(15, 33)).c(3F).b(5F).a(i);
        J = (new gw(16, 34)).c(3F).b(5F).a(i);
        K = (new mg(17)).c(2.0F).a(f);
        L = (iz)(new iz(18, 52)).c(0.2F).d(1).a(h);
        M = (new ng(19)).c(0.6F).a(h);
        N = (new ct(20, 49, gb.o, false)).c(0.3F).a(k);
        ac = (new ly(35, 64, gb.k)).c(0.8F).a(l);
        ae = (mq)(new mq(37, 13)).c(0.0F).a(h);
        af = (mq)(new mq(38, 12)).c(0.0F).a(h);
        ag = (mq)(new ky(39, 29)).c(0.0F).a(h).a(0.125F);
        ah = (mq)(new ky(40, 28)).c(0.0F).a(h);
        ai = (new c(41, 39)).c(3F).b(10F).a(j);
        aj = (new c(42, 38)).c(5F).b(10F).a(j);
        ak = (new oi(43, true)).c(2.0F).b(10F).a(i);
        al = (new oi(44, false)).c(2.0F).b(10F).a(i);
        am = (new ly(45, 7, gb.d)).c(2.0F).b(10F).a(i);
        an = (new q(46, 8)).c(0.0F).a(h);
        ao = (new ds(47, 35)).c(1.5F).a(f);
        ap = (new ly(48, 36, gb.d)).c(2.0F).b(10F).a(i);
        aq = (new cm(49, 37)).c(10F).b(2000F).a(i);
        ar = (new mj(50, 80)).c(0.0F).a(0.9375F).a(f);
        as = (og)(og)(new og(51, 31)).c(0.0F).a(1.0F).a(f);
        at = (new bj(52, 65)).c(5F).a(j);
        au = ((ly) (new km(53, y)));
        av = (new b(54)).c(2.5F).a(f);
        aw = (new kf(55, 84)).c(0.0F).a(e);
        ax = (new gw(56, 50)).c(3F).b(5F).a(i);
        ay = (new c(57, 40)).c(5F).b(10F).a(j);
        az = (new cs(58)).c(2.5F).a(f);
        aA = (new hd(59, 88)).c(0.0F).a(h);
        aB = (new mi(60)).c(0.6F).a(g);
        aC = (new ku(61, false)).c(3.5F).a(i);
        aD = (new ku(62, true)).c(3.5F).a(i).a(0.875F);
        aE = (new lr(63, ob, true)).c(1.0F).a(f);
        aF = (new fw(64, gb.c)).c(3F).a(f);
        aG = (new br(65, 83)).c(0.4F).a(f);
        aH = (new if(66, 128)).c(0.7F).a(j);
        aI = ((ly) (new km(67, x)));
        aJ = (new lr(68, ob, false)).c(1.0F).a(f);
        aK = (new no(69, 96)).c(0.5F).a(f);
        aL = (new al(70, u.bb, js.b)).c(0.5F).a(i);
        aM = (new fw(71, gb.e)).c(5F).a(j);
        aN = (new al(72, y.bb, js.a)).c(0.5F).a(f);
        aO = (new ai(73, 51, false)).c(3F).b(5F).a(i);
        aP = (new ai(74, 51, true)).a(0.625F).c(3F).b(5F).a(i);
        aQ = (new bg(75, 115, false)).c(0.0F).a(f);
        aR = (new bg(76, 99, true)).c(0.0F).a(0.5F).a(f);
        aS = (new hu(77, u.bb)).c(0.5F).a(i);
        aT = (new fd(78, 66)).c(0.1F).a(l);
        aU = (new he(79, 67)).c(0.5F).d(3).a(k);
        aV = (new p(80, 66)).c(0.2F).a(l);
        aW = (new hy(81, 70)).c(0.4F).a(l);
        aX = (new jv(82, 72)).c(0.6F).a(g);
        aY = (new jm(83, 73)).c(0.0F).a(h);
        aZ = (new cv(84, 74)).c(2.0F).b(10F).a(i);
        ba = (new fh(85, 4)).c(2.0F).b(5F).a(f);
        for(int i1 = 0; i1 < 256; i1++)
            if(n[i1] != null)
                di.c[i1] = ((di) (new av(i1 - 256)));

    }
}
