package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;
import java.util.*;

public class cn
    implements nm
{

    public static hm a(File file, String s1)
    {
        File file3;
        File file1 = new File(file, "saves");
        File file2 = new File(file1, s1);
        if(!file2.exists())
            return null;
        file3 = new File(file2, "level.dat");
        if(!file3.exists())
            break MISSING_BLOCK_LABEL_83;
        hm hm2;
        hm hm1 = x.a(((java.io.InputStream) (new FileInputStream(file3))));
        hm2 = hm1.k("Data");
        return hm2;
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    public static void b(File file, String s1)
    {
        File file1 = new File(file, "saves");
        File file2 = new File(file1, s1);
        if(!file2.exists())
        {
            return;
        } else
        {
            a(file2.listFiles());
            file2.delete();
            return;
        }
    }

    private static void a(File afile[])
    {
        for(int i1 = 0; i1 < afile.length; i1++)
        {
            if(afile[i1].isDirectory())
                a(afile[i1].listFiles());
            afile[i1].delete();
        }

    }

    public cn(File file, String s1)
    {
        this(file, s1, (new Random()).nextLong());
    }

    public cn(String s1)
    {
        z = ((List) (new ArrayList()));
        a = ((List) (new ArrayList()));
        A = ((List) (new ArrayList()));
        B = new TreeSet();
        C = ((Set) (new HashSet()));
        b = ((List) (new ArrayList()));
        c = 0L;
        d = false;
        D = 0x88bbffL;
        E = 0xc0d8ffL;
        F = 0xffffffL;
        e = 0;
        f = (new Random()).nextInt();
        g = 0x3c6ef35f;
        h = false;
        G = System.currentTimeMillis();
        j = 40;
        k = ((List) (new ArrayList()));
        n = new Random();
        r = false;
        s = ((List) (new ArrayList()));
        u = 0L;
        v = 0L;
        J = new ArrayList();
        K = ((Set) (new HashSet()));
        L = n.nextInt(12000);
        M = ((List) (new ArrayList()));
        y = false;
        w = s1;
        H = a(t);
        f();
    }

    public cn(File file, String s1, long l1)
    {
        z = ((List) (new ArrayList()));
        a = ((List) (new ArrayList()));
        A = ((List) (new ArrayList()));
        B = new TreeSet();
        C = ((Set) (new HashSet()));
        b = ((List) (new ArrayList()));
        c = 0L;
        d = false;
        D = 0x88bbffL;
        E = 0xc0d8ffL;
        F = 0xffffffL;
        e = 0;
        f = (new Random()).nextInt();
        g = 0x3c6ef35f;
        h = false;
        G = System.currentTimeMillis();
        j = 40;
        k = ((List) (new ArrayList()));
        n = new Random();
        r = false;
        s = ((List) (new ArrayList()));
        u = 0L;
        v = 0L;
        J = new ArrayList();
        K = ((Set) (new HashSet()));
        L = n.nextInt(12000);
        M = ((List) (new ArrayList()));
        y = false;
        w = s1;
        file.mkdirs();
        t = new File(file, s1);
        t.mkdirs();
        DataOutputStream dataoutputstream;
        File file1 = new File(t, "session.lock");
        dataoutputstream = new DataOutputStream(((java.io.OutputStream) (new FileOutputStream(file1))));
        dataoutputstream.writeLong(G);
        dataoutputstream.close();
        break MISSING_BLOCK_LABEL_350;
        Exception exception1;
        exception1;
        dataoutputstream.close();
        throw exception1;
        IOException ioexception;
        ioexception;
        throw new RuntimeException("Failed to check session lock, aborting");
        File file2 = new File(t, "level.dat");
        r = !file2.exists();
        if(file2.exists())
            try
            {
                hm hm1 = x.a(((java.io.InputStream) (new FileInputStream(file2))));
                hm hm2 = hm1.k("Data");
                u = hm2.f("RandomSeed");
                o = hm2.e("SpawnX");
                p = hm2.e("SpawnY");
                q = hm2.e("SpawnZ");
                c = hm2.f("Time");
                v = hm2.f("SizeOnDisk");
                d = hm2.m("SnowCovered");
                if(hm2.b("Player"))
                    I = hm2.k("Player");
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        else
            d = n.nextInt(4) == 0;
        boolean flag = false;
        if(u == 0L)
        {
            u = l1;
            flag = true;
        }
        H = a(t);
        if(flag)
        {
            x = true;
            o = 0;
            p = 64;
            for(q = 0; !f(o, q); q += n.nextInt(64) - n.nextInt(64))
                o += n.nextInt(64) - n.nextInt(64);

            x = false;
        }
        f();
        return;
    }

    protected aw a(File file)
    {
        return ((aw) (new ft(this, ((af) (new le(file, true))), ((aw) (new nw(this, u))))));
    }

    public void a()
    {
        if(p <= 0)
            p = 64;
        for(; g(o, q) == 0; q += n.nextInt(8) - n.nextInt(8))
            o += n.nextInt(8) - n.nextInt(8);

    }

    private boolean f(int i1, int j1)
    {
        int k1 = g(i1, j1);
        return k1 == ly.F.bc;
    }

    private int g(int i1, int j1)
    {
        int k1;
        for(k1 = 63; a(i1, k1 + 1, j1) != 0; k1++);
        return a(i1, k1, j1);
    }

    public void a(dm dm1)
    {
        try
        {
            if(I != null)
            {
                dm1.e(I);
                I = null;
            }
            a(((kh) (dm1)));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void a(boolean flag, nu nu1)
    {
        if(!H.b())
            return;
        if(nu1 != null)
            nu1.b("Saving level");
        m();
        if(nu1 != null)
            nu1.d("Saving chunks");
        H.a(flag, nu1);
    }

    private void m()
    {
        l();
        hm hm1 = new hm();
        hm1.a("RandomSeed", u);
        hm1.a("SpawnX", o);
        hm1.a("SpawnY", p);
        hm1.a("SpawnZ", q);
        hm1.a("Time", c);
        hm1.a("SizeOnDisk", v);
        hm1.a("SnowCovered", d);
        hm1.a("LastPlayed", System.currentTimeMillis());
        dm dm1 = null;
        if(k.size() > 0)
            dm1 = (dm)k.get(0);
        if(dm1 != null)
        {
            hm hm2 = new hm();
            dm1.d(hm2);
            hm1.a("Player", hm2);
        }
        hm hm3 = new hm();
        hm3.a("Data", ((el) (hm1)));
        try
        {
            File file = new File(t, "level.dat_new");
            File file1 = new File(t, "level.dat_old");
            File file2 = new File(t, "level.dat");
            x.a(hm3, ((java.io.OutputStream) (new FileOutputStream(file))));
            if(file1.exists())
                file1.delete();
            file2.renameTo(file1);
            if(file2.exists())
                file2.delete();
            file.renameTo(file2);
            if(file.exists())
                file.delete();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public boolean a(int i1)
    {
        if(!H.b())
            return true;
        if(i1 == 0)
            m();
        return H.a(false, ((nu) (null)));
    }

    public int a(int i1, int j1, int k1)
    {
        if(i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800)
            return 0;
        if(j1 < 0)
            return 0;
        if(j1 >= 128)
            return 0;
        else
            return b(i1 >> 4, k1 >> 4).a(i1 & 0xf, j1, k1 & 0xf);
    }

    public boolean d(int i1, int j1, int k1)
    {
        if(j1 < 0 || j1 >= 128)
            return false;
        else
            return h(i1 >> 4, k1 >> 4);
    }

    public boolean a(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        if(i2 < 0 || j1 >= 128)
            return false;
        i1 >>= 4;
        j1 >>= 4;
        k1 >>= 4;
        l1 >>= 4;
        i2 >>= 4;
        j2 >>= 4;
        for(int k2 = i1; k2 <= l1; k2++)
        {
            for(int l2 = k1; l2 <= j2; l2++)
                if(!h(k2, l2))
                    return false;

        }

        return true;
    }

    private boolean h(int i1, int j1)
    {
        return H.a(i1, j1);
    }

    public ga a(int i1, int j1)
    {
        return b(i1 >> 4, j1 >> 4);
    }

    public ga b(int i1, int j1)
    {
        return H.b(i1, j1);
    }

    public boolean a(int i1, int j1, int k1, int l1, int i2)
    {
        if(i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800)
            return false;
        if(j1 < 0)
            return false;
        if(j1 >= 128)
        {
            return false;
        } else
        {
            ga ga1 = b(i1 >> 4, k1 >> 4);
            return ga1.a(i1 & 0xf, j1, k1 & 0xf, l1, i2);
        }
    }

    public boolean a(int i1, int j1, int k1, int l1)
    {
        if(i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800)
            return false;
        if(j1 < 0)
            return false;
        if(j1 >= 128)
        {
            return false;
        } else
        {
            ga ga1 = b(i1 >> 4, k1 >> 4);
            return ga1.a(i1 & 0xf, j1, k1 & 0xf, l1);
        }
    }

    public gb f(int i1, int j1, int k1)
    {
        int l1 = a(i1, j1, k1);
        if(l1 == 0)
            return gb.a;
        else
            return ly.n[l1].bn;
    }

    public int e(int i1, int j1, int k1)
    {
        if(i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800)
            return 0;
        if(j1 < 0)
            return 0;
        if(j1 >= 128)
        {
            return 0;
        } else
        {
            ga ga1 = b(i1 >> 4, k1 >> 4);
            i1 &= 0xf;
            k1 &= 0xf;
            return ga1.b(i1, j1, k1);
        }
    }

    public void b(int i1, int j1, int k1, int l1)
    {
        c(i1, j1, k1, l1);
    }

    public boolean c(int i1, int j1, int k1, int l1)
    {
        if(i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800)
            return false;
        if(j1 < 0)
            return false;
        if(j1 >= 128)
        {
            return false;
        } else
        {
            ga ga1 = b(i1 >> 4, k1 >> 4);
            i1 &= 0xf;
            k1 &= 0xf;
            ga1.b(i1, j1, k1, l1);
            return true;
        }
    }

    public boolean d(int i1, int j1, int k1, int l1)
    {
        if(a(i1, j1, k1, l1))
        {
            e(i1, j1, k1, l1);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean b(int i1, int j1, int k1, int l1, int i2)
    {
        if(a(i1, j1, k1, l1, i2))
        {
            e(i1, j1, k1, l1);
            return true;
        } else
        {
            return false;
        }
    }

    public void h(int i1, int j1, int k1)
    {
        for(int l1 = 0; l1 < s.size(); l1++)
            ((im)s.get(l1)).a(i1, j1, k1);

    }

    protected void e(int i1, int j1, int k1, int l1)
    {
        h(i1, j1, k1);
        g(i1, j1, k1, l1);
    }

    public void f(int i1, int j1, int k1, int l1)
    {
        if(k1 > l1)
        {
            int i2 = l1;
            l1 = k1;
            k1 = i2;
        }
        b(i1, k1, j1, i1, l1, j1);
    }

    public void b(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        for(int k2 = 0; k2 < s.size(); k2++)
            ((im)s.get(k2)).b(i1, j1, k1, l1, i2, j2);

    }

    public void g(int i1, int j1, int k1, int l1)
    {
        l(i1 - 1, j1, k1, l1);
        l(i1 + 1, j1, k1, l1);
        l(i1, j1 - 1, k1, l1);
        l(i1, j1 + 1, k1, l1);
        l(i1, j1, k1 - 1, l1);
        l(i1, j1, k1 + 1, l1);
    }

    private void l(int i1, int j1, int k1, int l1)
    {
        if(h || y)
            return;
        ly ly1 = ly.n[a(i1, j1, k1)];
        if(ly1 != null)
            ly1.a(this, i1, j1, k1, l1);
    }

    public boolean i(int i1, int j1, int k1)
    {
        return b(i1 >> 4, k1 >> 4).c(i1 & 0xf, j1, k1 & 0xf);
    }

    public int j(int i1, int j1, int k1)
    {
        return a(i1, j1, k1, true);
    }

    public int a(int i1, int j1, int k1, boolean flag)
    {
        if(i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800)
            return 15;
        if(flag)
        {
            int l1 = a(i1, j1, k1);
            if(l1 == ly.al.bc || l1 == ly.aB.bc)
            {
                int j2 = a(i1, j1 + 1, k1, false);
                int k2 = a(i1 + 1, j1, k1, false);
                int l2 = a(i1 - 1, j1, k1, false);
                int i3 = a(i1, j1, k1 + 1, false);
                int j3 = a(i1, j1, k1 - 1, false);
                if(k2 > j2)
                    j2 = k2;
                if(l2 > j2)
                    j2 = l2;
                if(i3 > j2)
                    j2 = i3;
                if(j3 > j2)
                    j2 = j3;
                return j2;
            }
        }
        if(j1 < 0)
            return 0;
        if(j1 >= 128)
        {
            int i2 = 15 - e;
            if(i2 < 0)
                i2 = 0;
            return i2;
        } else
        {
            ga ga1 = b(i1 >> 4, k1 >> 4);
            i1 &= 0xf;
            k1 &= 0xf;
            return ga1.c(i1, j1, k1, e);
        }
    }

    public boolean k(int i1, int j1, int k1)
    {
        if(i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800)
            return false;
        if(j1 < 0)
            return false;
        if(j1 >= 128)
            return true;
        if(!h(i1 >> 4, k1 >> 4))
        {
            return false;
        } else
        {
            ga ga1 = b(i1 >> 4, k1 >> 4);
            i1 &= 0xf;
            k1 &= 0xf;
            return ga1.c(i1, j1, k1);
        }
    }

    public int c(int i1, int j1)
    {
        if(i1 < 0xfe17b800 || j1 < 0xfe17b800 || i1 >= 0x1e84800 || j1 > 0x1e84800)
            return 0;
        if(!h(i1 >> 4, j1 >> 4))
        {
            return 0;
        } else
        {
            ga ga1 = b(i1 >> 4, j1 >> 4);
            return ga1.b(i1 & 0xf, j1 & 0xf);
        }
    }

    public void a(by by1, int i1, int j1, int k1, int l1)
    {
        if(!d(i1, j1, k1))
            return;
        if(by1 == by.a)
        {
            if(k(i1, j1, k1))
                l1 = 15;
        } else
        if(by1 == by.b)
        {
            int i2 = a(i1, j1, k1);
            if(ly.t[i2] > l1)
                l1 = ly.t[i2];
        }
        if(a(by1, i1, j1, k1) != l1)
            a(by1, i1, j1, k1, i1, j1, k1);
    }

    public int a(by by1, int i1, int j1, int k1)
    {
        if(j1 < 0 || j1 >= 128 || i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800)
            return by1.c;
        int l1 = i1 >> 4;
        int i2 = k1 >> 4;
        if(!h(l1, i2))
        {
            return 0;
        } else
        {
            ga ga1 = b(l1, i2);
            return ga1.a(by1, i1 & 0xf, j1, k1 & 0xf);
        }
    }

    public void b(by by1, int i1, int j1, int k1, int l1)
    {
        if(i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800)
            return;
        if(j1 < 0)
            return;
        if(j1 >= 128)
            return;
        if(!h(i1 >> 4, k1 >> 4))
            return;
        ga ga1 = b(i1 >> 4, k1 >> 4);
        ga1.a(by1, i1 & 0xf, j1, k1 & 0xf, l1);
        for(int i2 = 0; i2 < s.size(); i2++)
            ((im)s.get(i2)).a(i1, j1, k1);

    }

    public float c(int i1, int j1, int k1)
    {
        return i[j(i1, j1, k1)];
    }

    public boolean b()
    {
        return e < 4;
    }

    public mf a(aj aj1, aj aj2)
    {
        return a(aj1, aj2, false);
    }

    public mf a(aj aj1, aj aj2, boolean flag)
    {
        if(Double.isNaN(aj1.a) || Double.isNaN(aj1.b) || Double.isNaN(aj1.c))
            return null;
        if(Double.isNaN(aj2.a) || Double.isNaN(aj2.b) || Double.isNaN(aj2.c))
            return null;
        int i1 = eo.b(aj2.a);
        int j1 = eo.b(aj2.b);
        int k1 = eo.b(aj2.c);
        int l1 = eo.b(aj1.a);
        int i2 = eo.b(aj1.b);
        int j2 = eo.b(aj1.c);
        for(int k2 = 20; k2-- >= 0;)
        {
            if(Double.isNaN(aj1.a) || Double.isNaN(aj1.b) || Double.isNaN(aj1.c))
                return null;
            if(l1 == i1 && i2 == j1 && j2 == k1)
                return null;
            double d1 = 999D;
            double d2 = 999D;
            double d3 = 999D;
            if(i1 > l1)
                d1 = (double)l1 + 1.0D;
            if(i1 < l1)
                d1 = (double)l1 + 0.0D;
            if(j1 > i2)
                d2 = (double)i2 + 1.0D;
            if(j1 < i2)
                d2 = (double)i2 + 0.0D;
            if(k1 > j2)
                d3 = (double)j2 + 1.0D;
            if(k1 < j2)
                d3 = (double)j2 + 0.0D;
            double d4 = 999D;
            double d5 = 999D;
            double d6 = 999D;
            double d7 = aj2.a - aj1.a;
            double d8 = aj2.b - aj1.b;
            double d9 = aj2.c - aj1.c;
            if(d1 != 999D)
                d4 = (d1 - aj1.a) / d7;
            if(d2 != 999D)
                d5 = (d2 - aj1.b) / d8;
            if(d3 != 999D)
                d6 = (d3 - aj1.c) / d9;
            byte byte0 = 0;
            if(d4 < d5 && d4 < d6)
            {
                if(i1 > l1)
                    byte0 = 4;
                else
                    byte0 = 5;
                aj1.a = d1;
                aj1.b += d8 * d4;
                aj1.c += d9 * d4;
            } else
            if(d5 < d6)
            {
                if(j1 > i2)
                    byte0 = 0;
                else
                    byte0 = 1;
                aj1.a += d7 * d5;
                aj1.b = d2;
                aj1.c += d9 * d5;
            } else
            {
                if(k1 > j2)
                    byte0 = 2;
                else
                    byte0 = 3;
                aj1.a += d7 * d6;
                aj1.b += d8 * d6;
                aj1.c = d3;
            }
            aj aj3 = aj.b(aj1.a, aj1.b, aj1.c);
            l1 = (int)(aj3.a = eo.b(aj1.a));
            if(byte0 == 5)
            {
                l1--;
                aj3.a++;
            }
            i2 = (int)(aj3.b = eo.b(aj1.b));
            if(byte0 == 1)
            {
                i2--;
                aj3.b++;
            }
            j2 = (int)(aj3.c = eo.b(aj1.c));
            if(byte0 == 3)
            {
                j2--;
                aj3.c++;
            }
            int l2 = a(l1, i2, j2);
            int i3 = e(l1, i2, j2);
            ly ly1 = ly.n[l2];
            if(l2 > 0 && ly1.a(i3, flag))
            {
                mf mf = ly1.a(this, l1, i2, j2, aj1, aj2);
                if(mf != null)
                    return mf;
            }
        }

        return null;
    }

    public void a(kh kh1, String s1, float f1, float f2)
    {
        for(int i1 = 0; i1 < s.size(); i1++)
            ((im)s.get(i1)).a(s1, kh1.ak, kh1.al - (double)kh1.aB, kh1.am, f1, f2);

    }

    public void a(double d1, double d2, double d3, String s1, 
            float f1, float f2)
    {
        for(int i1 = 0; i1 < s.size(); i1++)
            ((im)s.get(i1)).a(s1, d1, d2, d3, f1, f2);

    }

    public void a(String s1, int i1, int j1, int k1)
    {
        for(int l1 = 0; l1 < s.size(); l1++)
            ((im)s.get(l1)).a(s1, i1, j1, k1);

    }

    public void a(String s1, double d1, double d2, double d3, 
            double d4, double d5, double d6)
    {
        for(int i1 = 0; i1 < s.size(); i1++)
            ((im)s.get(i1)).a(s1, d1, d2, d3, d4, d5, d6);

    }

    public boolean a(kh kh1)
    {
        int i1 = eo.b(kh1.ak / 16D);
        int j1 = eo.b(kh1.am / 16D);
        boolean flag = false;
        if(kh1 instanceof dm)
            flag = true;
        if(flag || h(i1, j1))
        {
            if(kh1 instanceof dm)
            {
                k.add(((Object) ((dm)kh1)));
                System.out.println((new StringBuilder()).append("Player count: ").append(k.size()).toString());
            }
            b(i1, j1).a(kh1);
            a.add(((Object) (kh1)));
            b(kh1);
            return true;
        } else
        {
            return false;
        }
    }

    protected void b(kh kh1)
    {
        for(int i1 = 0; i1 < s.size(); i1++)
            ((im)s.get(i1)).a(kh1);

    }

    protected void c(kh kh1)
    {
        for(int i1 = 0; i1 < s.size(); i1++)
            ((im)s.get(i1)).b(kh1);

    }

    public void d(kh kh1)
    {
        kh1.F();
        if(kh1 instanceof dm)
        {
            k.remove(((Object) ((dm)kh1)));
            System.out.println((new StringBuilder()).append("Player count: ").append(k.size()).toString());
        }
    }

    public void a(im im1)
    {
        s.add(((Object) (im1)));
    }

    public void b(im im1)
    {
        s.remove(((Object) (im1)));
    }

    public List a(kh kh1, cf cf1)
    {
        J.clear();
        int i1 = eo.b(cf1.a);
        int j1 = eo.b(cf1.d + 1.0D);
        int k1 = eo.b(cf1.b);
        int l1 = eo.b(cf1.e + 1.0D);
        int i2 = eo.b(cf1.c);
        int j2 = eo.b(cf1.f + 1.0D);
        for(int k2 = i1; k2 < j1; k2++)
        {
            for(int l2 = i2; l2 < j2; l2++)
            {
                if(!d(k2, 64, l2))
                    continue;
                for(int i3 = k1 - 1; i3 < l1; i3++)
                {
                    ly ly1 = ly.n[a(k2, i3, l2)];
                    if(ly1 != null)
                        ly1.a(this, k2, i3, l2, cf1, J);
                }

            }

        }

        double d1 = 0.25D;
        List list = b(kh1, cf1.b(d1, d1, d1));
        for(int j3 = 0; j3 < list.size(); j3++)
        {
            cf cf2 = ((kh)list.get(j3)).f_();
            if(cf2 != null && cf2.a(cf1))
                J.add(((Object) (cf2)));
            cf2 = kh1.b_((kh)list.get(j3));
            if(cf2 != null && cf2.a(cf1))
                J.add(((Object) (cf2)));
        }

        return ((List) (J));
    }

    public int a(float f1)
    {
        float f2 = c(f1);
        float f3 = 1.0F - (eo.b(f2 * 3.141593F * 2.0F) * 2.0F + 0.5F);
        if(f3 < 0.0F)
            f3 = 0.0F;
        if(f3 > 1.0F)
            f3 = 1.0F;
        return (int)(f3 * 11F);
    }

    public aj b(float f1)
    {
        float f2 = c(f1);
        float f3 = eo.b(f2 * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f3 < 0.0F)
            f3 = 0.0F;
        if(f3 > 1.0F)
            f3 = 1.0F;
        float f4 = (float)(D >> 16 & 255L) / 255F;
        float f5 = (float)(D >> 8 & 255L) / 255F;
        float f6 = (float)(D & 255L) / 255F;
        f4 *= f3;
        f5 *= f3;
        f6 *= f3;
        return aj.b(f4, f5, f6);
    }

    public float c(float f1)
    {
        int i1 = (int)(c % 24000L);
        float f2 = ((float)i1 + f1) / 24000F - 0.25F;
        if(f2 < 0.0F)
            f2++;
        if(f2 > 1.0F)
            f2--;
        float f3 = f2;
        f2 = 1.0F - (float)((Math.cos((double)f2 * 3.1415926535897931D) + 1.0D) / 2D);
        f2 = f3 + (f2 - f3) / 3F;
        return f2;
    }

    public aj d(float f1)
    {
        float f2 = c(f1);
        float f3 = eo.b(f2 * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f3 < 0.0F)
            f3 = 0.0F;
        if(f3 > 1.0F)
            f3 = 1.0F;
        float f4 = (float)(F >> 16 & 255L) / 255F;
        float f5 = (float)(F >> 8 & 255L) / 255F;
        float f6 = (float)(F & 255L) / 255F;
        f4 *= f3 * 0.9F + 0.1F;
        f5 *= f3 * 0.9F + 0.1F;
        f6 *= f3 * 0.85F + 0.15F;
        return aj.b(f4, f5, f6);
    }

    public aj e(float f1)
    {
        float f2 = c(f1);
        float f3 = eo.b(f2 * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f3 < 0.0F)
            f3 = 0.0F;
        if(f3 > 1.0F)
            f3 = 1.0F;
        float f4 = (float)(E >> 16 & 255L) / 255F;
        float f5 = (float)(E >> 8 & 255L) / 255F;
        float f6 = (float)(E & 255L) / 255F;
        f4 *= f3 * 0.94F + 0.06F;
        f5 *= f3 * 0.94F + 0.06F;
        f6 *= f3 * 0.91F + 0.09F;
        return aj.b(f4, f5, f6);
    }

    public int d(int i1, int j1)
    {
        ga ga1 = a(i1, j1);
        int k1 = 127;
        i1 &= 0xf;
        j1 &= 0xf;
        while(k1 > 0) 
        {
            int l1 = ga1.a(i1, k1, j1);
            if(l1 == 0 || !ly.n[l1].bn.c() && !ly.n[l1].bn.d())
                k1--;
            else
                return k1 + 1;
        }
        return -1;
    }

    public int e(int i1, int j1)
    {
        return a(i1, j1).b(i1 & 0xf, j1 & 0xf);
    }

    public float f(float f1)
    {
        float f2 = c(f1);
        float f3 = 1.0F - (eo.b(f2 * 3.141593F * 2.0F) * 2.0F + 0.75F);
        if(f3 < 0.0F)
            f3 = 0.0F;
        if(f3 > 1.0F)
            f3 = 1.0F;
        return f3 * f3 * 0.5F;
    }

    public void h(int i1, int j1, int k1, int l1)
    {
        jf jf1 = new jf(i1, j1, k1, l1);
        byte byte0 = 8;
        if(a(i1 - byte0, j1 - byte0, k1 - byte0, i1 + byte0, j1 + byte0, k1 + byte0))
        {
            if(l1 > 0)
                jf1.a((long)ly.n[l1].a() + c);
            if(!C.contains(((Object) (jf1))))
            {
                C.add(((Object) (jf1)));
                B.add(((Object) (jf1)));
            }
        }
    }

    public void c()
    {
        a.removeAll(((java.util.Collection) (A)));
        for(int i1 = 0; i1 < A.size(); i1++)
        {
            kh kh1 = (kh)A.get(i1);
            int i2 = kh1.ba;
            int k2 = kh1.bc;
            if(kh1.aZ && h(i2, k2))
                b(i2, k2).b(kh1);
        }

        for(int j1 = 0; j1 < A.size(); j1++)
            c((kh)A.get(j1));

        A.clear();
        for(int k1 = 0; k1 < a.size(); k1++)
        {
            kh kh2 = (kh)a.get(k1);
            if(kh2.af != null)
            {
                if(!kh2.af.aA && kh2.af.ae == kh2)
                    continue;
                kh2.af.ae = null;
                kh2.af = null;
            }
            if(!kh2.aA)
                e(kh2);
            if(!kh2.aA)
                continue;
            int j2 = kh2.ba;
            int l2 = kh2.bc;
            if(kh2.aZ && h(j2, l2))
                b(j2, l2).b(kh2);
            a.remove(k1--);
            c(kh2);
        }

        for(int l1 = 0; l1 < b.size(); l1++)
        {
            ic ic1 = (ic)b.get(l1);
            ic1.b();
        }

    }

    protected void e(kh kh1)
    {
        int i1 = eo.b(kh1.ak);
        int j1 = eo.b(kh1.am);
        byte byte0 = 16;
        if(!a(i1 - byte0, 0, j1 - byte0, i1 + byte0, 128, j1 + byte0))
            return;
        kh1.aI = kh1.ak;
        kh1.aJ = kh1.al;
        kh1.aK = kh1.am;
        kh1.as = kh1.aq;
        kh1.at = kh1.ar;
        if(kh1.af != null)
            kh1.p();
        else
            kh1.e_();
        int k1 = eo.b(kh1.ak / 16D);
        int l1 = eo.b(kh1.al / 16D);
        int i2 = eo.b(kh1.am / 16D);
        if(!kh1.aZ || kh1.ba != k1 || kh1.bb != l1 || kh1.bc != i2)
        {
            if(kh1.aZ && h(kh1.ba, kh1.bc))
                b(kh1.ba, kh1.bc).a(kh1, kh1.bb);
            if(h(k1, i2))
            {
                b(k1, i2).a(kh1);
            } else
            {
                kh1.aZ = false;
                System.out.println("Removing entity because it's not in a chunk!!");
                kh1.F();
            }
        }
        if(kh1.ae != null)
            if(kh1.ae.aA || kh1.ae.af != kh1)
            {
                kh1.ae.af = null;
                kh1.ae = null;
            } else
            {
                e(kh1.ae);
            }
        if(Double.isNaN(kh1.ak) || Double.isInfinite(kh1.ak))
            kh1.ak = kh1.aI;
        if(Double.isNaN(kh1.al) || Double.isInfinite(kh1.al))
            kh1.al = kh1.aJ;
        if(Double.isNaN(kh1.am) || Double.isInfinite(kh1.am))
            kh1.am = kh1.aK;
        if(Double.isNaN(kh1.ar) || Double.isInfinite(kh1.ar))
            kh1.ar = kh1.at;
        if(Double.isNaN(kh1.aq) || Double.isInfinite(kh1.aq))
            kh1.aq = kh1.as;
    }

    public boolean a(cf cf1)
    {
        List list = b(((kh) (null)), cf1);
        for(int i1 = 0; i1 < list.size(); i1++)
        {
            kh kh1 = (kh)list.get(i1);
            if(!kh1.aA && kh1.ad)
                return false;
        }

        return true;
    }

    public boolean b(cf cf1)
    {
        int i1 = eo.b(cf1.a);
        int j1 = eo.b(cf1.d + 1.0D);
        int k1 = eo.b(cf1.b);
        int l1 = eo.b(cf1.e + 1.0D);
        int i2 = eo.b(cf1.c);
        int j2 = eo.b(cf1.f + 1.0D);
        if(cf1.a < 0.0D)
            i1--;
        if(cf1.b < 0.0D)
            k1--;
        if(cf1.c < 0.0D)
            i2--;
        for(int k2 = i1; k2 < j1; k2++)
        {
            for(int l2 = k1; l2 < l1; l2++)
            {
                for(int i3 = i2; i3 < j2; i3++)
                {
                    ly ly1 = ly.n[a(k2, l2, i3)];
                    if(ly1 != null && ly1.bn.d())
                        return true;
                }

            }

        }

        return false;
    }

    public boolean c(cf cf1)
    {
        int i1 = eo.b(cf1.a);
        int j1 = eo.b(cf1.d + 1.0D);
        int k1 = eo.b(cf1.b);
        int l1 = eo.b(cf1.e + 1.0D);
        int i2 = eo.b(cf1.c);
        int j2 = eo.b(cf1.f + 1.0D);
        for(int k2 = i1; k2 < j1; k2++)
        {
            for(int l2 = k1; l2 < l1; l2++)
            {
                for(int i3 = i2; i3 < j2; i3++)
                {
                    int j3 = a(k2, l2, i3);
                    if(j3 == ly.as.bc || j3 == ly.D.bc || j3 == ly.E.bc)
                        return true;
                }

            }

        }

        return false;
    }

    public boolean a(cf cf1, gb gb1, kh kh1)
    {
        int i1 = eo.b(cf1.a);
        int j1 = eo.b(cf1.d + 1.0D);
        int k1 = eo.b(cf1.b);
        int l1 = eo.b(cf1.e + 1.0D);
        int i2 = eo.b(cf1.c);
        int j2 = eo.b(cf1.f + 1.0D);
        boolean flag = false;
        aj aj1 = aj.b(0.0D, 0.0D, 0.0D);
        for(int k2 = i1; k2 < j1; k2++)
        {
            for(int l2 = k1; l2 < l1; l2++)
            {
                for(int i3 = i2; i3 < j2; i3++)
                {
                    ly ly1 = ly.n[a(k2, l2, i3)];
                    if(ly1 == null || ly1.bn != gb1)
                        continue;
                    double d2 = (float)(l2 + 1) - jp.b(e(k2, l2, i3));
                    if((double)l1 >= d2)
                    {
                        flag = true;
                        ly1.a(this, k2, l2, i3, kh1, aj1);
                    }
                }

            }

        }

        if(aj1.c() > 0.0D)
        {
            aj1 = aj1.b();
            double d1 = 0.0040000000000000001D;
            kh1.an += aj1.a * d1;
            kh1.ao += aj1.b * d1;
            kh1.ap += aj1.c * d1;
        }
        return flag;
    }

    public boolean a(cf cf1, gb gb1)
    {
        int i1 = eo.b(cf1.a);
        int j1 = eo.b(cf1.d + 1.0D);
        int k1 = eo.b(cf1.b);
        int l1 = eo.b(cf1.e + 1.0D);
        int i2 = eo.b(cf1.c);
        int j2 = eo.b(cf1.f + 1.0D);
        for(int k2 = i1; k2 < j1; k2++)
        {
            for(int l2 = k1; l2 < l1; l2++)
            {
                for(int i3 = i2; i3 < j2; i3++)
                {
                    ly ly1 = ly.n[a(k2, l2, i3)];
                    if(ly1 != null && ly1.bn == gb1)
                        return true;
                }

            }

        }

        return false;
    }

    public boolean b(cf cf1, gb gb1)
    {
        int i1 = eo.b(cf1.a);
        int j1 = eo.b(cf1.d + 1.0D);
        int k1 = eo.b(cf1.b);
        int l1 = eo.b(cf1.e + 1.0D);
        int i2 = eo.b(cf1.c);
        int j2 = eo.b(cf1.f + 1.0D);
        for(int k2 = i1; k2 < j1; k2++)
        {
            for(int l2 = k1; l2 < l1; l2++)
            {
                for(int i3 = i2; i3 < j2; i3++)
                {
                    ly ly1 = ly.n[a(k2, l2, i3)];
                    if(ly1 == null || ly1.bn != gb1)
                        continue;
                    int j3 = e(k2, l2, i3);
                    double d1 = l2 + 1;
                    if(j3 < 8)
                        d1 = (double)(l2 + 1) - (double)j3 / 8D;
                    if(d1 >= cf1.b)
                        return true;
                }

            }

        }

        return false;
    }

    public void a(kh kh1, double d1, double d2, double d3, 
            float f1)
    {
        (new je()).a(this, kh1, d1, d2, d3, f1);
    }

    public float a(aj aj1, cf cf1)
    {
        double d1 = 1.0D / ((cf1.d - cf1.a) * 2D + 1.0D);
        double d2 = 1.0D / ((cf1.e - cf1.b) * 2D + 1.0D);
        double d3 = 1.0D / ((cf1.f - cf1.c) * 2D + 1.0D);
        int i1 = 0;
        int j1 = 0;
        for(float f1 = 0.0F; f1 <= 1.0F; f1 = (float)((double)f1 + d1))
        {
            for(float f2 = 0.0F; f2 <= 1.0F; f2 = (float)((double)f2 + d2))
            {
                for(float f3 = 0.0F; f3 <= 1.0F; f3 = (float)((double)f3 + d3))
                {
                    double d4 = cf1.a + (cf1.d - cf1.a) * (double)f1;
                    double d5 = cf1.b + (cf1.e - cf1.b) * (double)f2;
                    double d6 = cf1.c + (cf1.f - cf1.c) * (double)f3;
                    if(a(aj.b(d4, d5, d6), aj1) == null)
                        i1++;
                    j1++;
                }

            }

        }

        return (float)i1 / (float)j1;
    }

    public void i(int i1, int j1, int k1, int l1)
    {
        if(l1 == 0)
            j1--;
        if(l1 == 1)
            j1++;
        if(l1 == 2)
            k1--;
        if(l1 == 3)
            k1++;
        if(l1 == 4)
            i1--;
        if(l1 == 5)
            i1++;
        if(a(i1, j1, k1) == ly.as.bc)
        {
            a((float)i1 + 0.5F, (float)j1 + 0.5F, (float)k1 + 0.5F, "random.fizz", 0.5F, 2.6F + (n.nextFloat() - n.nextFloat()) * 0.8F);
            d(i1, j1, k1, 0);
        }
    }

    public kh a(Class class1)
    {
        return null;
    }

    public String d()
    {
        return (new StringBuilder()).append("All: ").append(a.size()).toString();
    }

    public ic b(int i1, int j1, int k1)
    {
        ga ga1 = b(i1 >> 4, k1 >> 4);
        if(ga1 != null)
            return ga1.d(i1 & 0xf, j1, k1 & 0xf);
        else
            return null;
    }

    public void a(int i1, int j1, int k1, ic ic1)
    {
        ga ga1 = b(i1 >> 4, k1 >> 4);
        if(ga1 != null)
            ga1.a(i1 & 0xf, j1, k1 & 0xf, ic1);
    }

    public void l(int i1, int j1, int k1)
    {
        ga ga1 = b(i1 >> 4, k1 >> 4);
        if(ga1 != null)
            ga1.e(i1 & 0xf, j1, k1 & 0xf);
    }

    public boolean g(int i1, int j1, int k1)
    {
        ly ly1 = ly.n[a(i1, j1, k1)];
        if(ly1 == null)
            return false;
        else
            return ly1.b();
    }

    public void a(nu nu1)
    {
        a(true, nu1);
    }

    public boolean e()
    {
        int i1 = 1000;
        for(; z.size() > 0; ((kn)z.remove(z.size() - 1)).a(this))
            if(--i1 <= 0)
                return true;

        return false;
    }

    public void a(by by1, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        a(by1, i1, j1, k1, l1, i2, j2, true);
    }

    public void a(by by1, int i1, int j1, int k1, int l1, int i2, int j2, 
            boolean flag)
    {
        int k2 = (l1 + i1) / 2;
        int l2 = (j2 + k1) / 2;
        if(!d(k2, 64, l2))
            return;
        int i3 = z.size();
        if(flag)
        {
            int j3 = 4;
            if(j3 > i3)
                j3 = i3;
            for(int k3 = 0; k3 < j3; k3++)
            {
                kn kn1 = (kn)z.get(z.size() - k3 - 1);
                if(kn1.a == by1 && kn1.a(i1, j1, k1, l1, i2, j2))
                    return;
            }

        }
        z.add(((Object) (new kn(by1, i1, j1, k1, l1, i2, j2))));
        if(z.size() > 0x186a0)
            for(; z.size() > 50000; e());
    }

    public void f()
    {
        int i1 = a(1.0F);
        if(i1 != e)
            e = i1;
    }

    public void g()
    {
        H.a();
        int i1 = a(1.0F);
        if(i1 != e)
        {
            e = i1;
            for(int j1 = 0; j1 < s.size(); j1++)
                ((im)s.get(j1)).e();

        }
        c++;
        if(c % (long)j == 0L)
            a(false, ((nu) (null)));
        a(false);
        h();
    }

    protected void h()
    {
        K.clear();
        for(int i1 = 0; i1 < k.size(); i1++)
        {
            dm dm1 = (dm)k.get(i1);
            int j1 = eo.b(dm1.ak / 16D);
            int l1 = eo.b(dm1.am / 16D);
            byte byte0 = 9;
            for(int j2 = -byte0; j2 <= byte0; j2++)
            {
                for(int j3 = -byte0; j3 <= byte0; j3++)
                    K.add(((Object) (new ol(j2 + j1, j3 + l1))));

            }

        }

        if(L > 0)
            L--;
        for(Iterator iterator = K.iterator(); iterator.hasNext();)
        {
            ol ol1 = (ol)iterator.next();
            int k1 = ol1.a * 16;
            int i2 = ol1.b * 16;
            ga ga1 = b(ol1.a, ol1.b);
            if(L == 0)
            {
                f = f * 3 + g;
                int k2 = f >> 2;
                int k3 = k2 & 0xf;
                int j4 = k2 >> 8 & 0xf;
                int i5 = k2 >> 16 & 0x7f;
                int l5 = ga1.a(k3, i5, j4);
                k3 += k1;
                j4 += i2;
                if(l5 == 0 && j(k3, i5, j4) <= n.nextInt(8) && a(by.a, k3, i5, j4) <= 0)
                {
                    dm dm2 = a((double)k3 + 0.5D, (double)i5 + 0.5D, (double)j4 + 0.5D, 8D);
                    if(dm2 != null && dm2.d((double)k3 + 0.5D, (double)i5 + 0.5D, (double)j4 + 0.5D) > 4D)
                    {
                        a((double)k3 + 0.5D, (double)i5 + 0.5D, (double)j4 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + n.nextFloat() * 0.2F);
                        L = n.nextInt(12000) + 6000;
                    }
                }
            }
            if(d && n.nextInt(4) == 0)
            {
                f = f * 3 + g;
                int l2 = f >> 2;
                int l3 = l2 & 0xf;
                int k4 = l2 >> 8 & 0xf;
                int j5 = d(l3 + k1, k4 + i2);
                if(j5 >= 0 && j5 < 128 && ga1.a(by.b, l3, j5, k4) < 10)
                {
                    int i6 = ga1.a(l3, j5 - 1, k4);
                    if(ga1.a(l3, j5, k4) == 0 && ly.aT.a(this, l3 + k1, j5, k4 + i2))
                        d(l3 + k1, j5, k4 + i2, ly.aT.bc);
                    if(i6 == ly.C.bc && ga1.b(l3, j5 - 1, k4) == 0)
                        d(l3 + k1, j5 - 1, k4 + i2, ly.aU.bc);
                }
            }
            int i3 = 0;
            while(i3 < 80) 
            {
                f = f * 3 + g;
                int i4 = f >> 2;
                int l4 = i4 & 0xf;
                int k5 = i4 >> 8 & 0xf;
                int j6 = i4 >> 16 & 0x7f;
                byte byte1 = ga1.b[l4 << 11 | k5 << 7 | j6];
                if(ly.o[byte1])
                    ly.n[byte1].a(this, l4 + k1, j6, k5 + i2, n);
                i3++;
            }
        }

    }

    public boolean a(boolean flag)
    {
        int i1 = B.size();
        if(i1 != C.size())
            throw new IllegalStateException("TickNextTick list out of synch");
        if(i1 > 1000)
            i1 = 1000;
        for(int j1 = 0; j1 < i1; j1++)
        {
            jf jf1 = (jf)B.first();
            if(!flag && jf1.e > c)
                break;
            B.remove(((Object) (jf1)));
            C.remove(((Object) (jf1)));
            byte byte0 = 8;
            if(!a(jf1.a - byte0, jf1.b - byte0, jf1.c - byte0, jf1.a + byte0, jf1.b + byte0, jf1.c + byte0))
                continue;
            int k1 = a(jf1.a, jf1.b, jf1.c);
            if(k1 == jf1.d && k1 > 0)
                ly.n[k1].a(this, jf1.a, jf1.b, jf1.c, n);
        }

        return B.size() != 0;
    }

    public void m(int i1, int j1, int k1)
    {
        byte byte0 = 16;
        Random random = new Random();
        for(int l1 = 0; l1 < 1000; l1++)
        {
            int i2 = (i1 + n.nextInt(((int) (byte0)))) - n.nextInt(((int) (byte0)));
            int j2 = (j1 + n.nextInt(((int) (byte0)))) - n.nextInt(((int) (byte0)));
            int k2 = (k1 + n.nextInt(((int) (byte0)))) - n.nextInt(((int) (byte0)));
            int l2 = a(i2, j2, k2);
            if(l2 > 0)
                ly.n[l2].b(this, i2, j2, k2, random);
        }

    }

    public List b(kh kh1, cf cf1)
    {
        M.clear();
        int i1 = eo.b((cf1.a - 2D) / 16D);
        int j1 = eo.b((cf1.d + 2D) / 16D);
        int k1 = eo.b((cf1.c - 2D) / 16D);
        int l1 = eo.b((cf1.f + 2D) / 16D);
        for(int i2 = i1; i2 <= j1; i2++)
        {
            for(int j2 = k1; j2 <= l1; j2++)
                if(h(i2, j2))
                    b(i2, j2).a(kh1, cf1, M);

        }

        return M;
    }

    public List a(Class class1, cf cf1)
    {
        int i1 = eo.b((cf1.a - 2D) / 16D);
        int j1 = eo.b((cf1.d + 2D) / 16D);
        int k1 = eo.b((cf1.c - 2D) / 16D);
        int l1 = eo.b((cf1.f + 2D) / 16D);
        ArrayList arraylist = new ArrayList();
        for(int i2 = i1; i2 <= j1; i2++)
        {
            for(int j2 = k1; j2 <= l1; j2++)
                if(h(i2, j2))
                    b(i2, j2).a(class1, cf1, ((List) (arraylist)));

        }

        return ((List) (arraylist));
    }

    public List i()
    {
        return a;
    }

    public void b(int i1, int j1, int k1, ic ic1)
    {
        if(d(i1, j1, k1))
            a(i1, k1).f();
        for(int l1 = 0; l1 < s.size(); l1++)
            ((im)s.get(l1)).a(i1, j1, k1, ic1);

    }

    public int b(Class class1)
    {
        int i1 = 0;
        for(int j1 = 0; j1 < a.size(); j1++)
        {
            kh kh1 = (kh)a.get(j1);
            if(class1.isAssignableFrom(((Object) (kh1)).getClass()))
                i1++;
        }

        return i1;
    }

    public void a(List list)
    {
        a.addAll(((java.util.Collection) (list)));
        for(int i1 = 0; i1 < list.size(); i1++)
            b((kh)list.get(i1));

    }

    public void b(List list)
    {
        A.addAll(((java.util.Collection) (list)));
    }

    public void j()
    {
        while(H.a()) ;
    }

    public boolean a(int i1, int j1, int k1, int l1, boolean flag)
    {
        int i2 = a(j1, k1, l1);
        ly ly1 = ly.n[i2];
        ly ly2 = ly.n[i1];
        cf cf1 = ly2.d(this, j1, k1, l1);
        if(flag)
            cf1 = null;
        if(cf1 != null && !a(cf1))
            return false;
        if(ly1 == ly.B || ly1 == ly.C || ly1 == ly.D || ly1 == ly.E || ly1 == ly.as || ly1 == ly.aT)
            return true;
        return i1 > 0 && ly1 == null && ly2.a(this, j1, k1, l1);
    }

    public bl a(kh kh1, kh kh2, float f1)
    {
        int i1 = eo.b(kh1.ak);
        int j1 = eo.b(kh1.al);
        int k1 = eo.b(kh1.am);
        int l1 = (int)(f1 + 16F);
        int i2 = i1 - l1;
        int j2 = j1 - l1;
        int k2 = k1 - l1;
        int l2 = i1 + l1;
        int i3 = j1 + l1;
        int j3 = k1 + l1;
        ci ci1 = new ci(this, i2, j2, k2, l2, i3, j3);
        return (new cz(((nm) (ci1)))).a(kh1, kh2, f1);
    }

    public bl a(kh kh1, int i1, int j1, int k1, float f1)
    {
        int l1 = eo.b(kh1.ak);
        int i2 = eo.b(kh1.al);
        int j2 = eo.b(kh1.am);
        int k2 = (int)(f1 + 8F);
        int l2 = l1 - k2;
        int i3 = i2 - k2;
        int j3 = j2 - k2;
        int k3 = l1 + k2;
        int l3 = i2 + k2;
        int i4 = j2 + k2;
        ci ci1 = new ci(this, l2, i3, j3, k3, l3, i4);
        return (new cz(((nm) (ci1)))).a(kh1, i1, j1, k1, f1);
    }

    public boolean j(int i1, int j1, int k1, int l1)
    {
        int i2 = a(i1, j1, k1);
        if(i2 == 0)
            return false;
        else
            return ly.n[i2].c(this, i1, j1, k1, l1);
    }

    public boolean n(int i1, int j1, int k1)
    {
        if(j(i1, j1 - 1, k1, 0))
            return true;
        if(j(i1, j1 + 1, k1, 1))
            return true;
        if(j(i1, j1, k1 - 1, 2))
            return true;
        if(j(i1, j1, k1 + 1, 3))
            return true;
        if(j(i1 - 1, j1, k1, 4))
            return true;
        return j(i1 + 1, j1, k1, 5);
    }

    public boolean k(int i1, int j1, int k1, int l1)
    {
        if(g(i1, j1, k1))
            return n(i1, j1, k1);
        int i2 = a(i1, j1, k1);
        if(i2 == 0)
            return false;
        else
            return ly.n[i2].b(((nm) (this)), i1, j1, k1, l1);
    }

    public boolean o(int i1, int j1, int k1)
    {
        if(k(i1, j1 - 1, k1, 0))
            return true;
        if(k(i1, j1 + 1, k1, 1))
            return true;
        if(k(i1, j1, k1 - 1, 2))
            return true;
        if(k(i1, j1, k1 + 1, 3))
            return true;
        if(k(i1 - 1, j1, k1, 4))
            return true;
        return k(i1 + 1, j1, k1, 5);
    }

    public dm a(kh kh1, double d1)
    {
        return a(kh1.ak, kh1.al, kh1.am, d1);
    }

    public dm a(double d1, double d2, double d3, double d4)
    {
        double d5 = -1D;
        dm dm1 = null;
        for(int i1 = 0; i1 < k.size(); i1++)
        {
            dm dm2 = (dm)k.get(i1);
            double d6 = dm2.d(d1, d2, d3);
            if((d4 < 0.0D || d6 < d4 * d4) && (d5 == -1D || d6 < d5))
            {
                d5 = d6;
                dm1 = dm2;
            }
        }

        return dm1;
    }

    public void a(int i1, int j1, int k1, int l1, int i2, int j2, byte abyte0[])
    {
        int k2 = i1 >> 4;
        int l2 = k1 >> 4;
        int i3 = (i1 + l1) - 1 >> 4;
        int j3 = (k1 + j2) - 1 >> 4;
        int k3 = 0;
        int l3 = j1;
        int i4 = j1 + i2;
        if(l3 < 0)
            l3 = 0;
        if(i4 > 128)
            i4 = 128;
        for(int j4 = k2; j4 <= i3; j4++)
        {
            int k4 = i1 - j4 * 16;
            int l4 = (i1 + l1) - j4 * 16;
            if(k4 < 0)
                k4 = 0;
            if(l4 > 16)
                l4 = 16;
            for(int i5 = l2; i5 <= j3; i5++)
            {
                int j5 = k1 - i5 * 16;
                int k5 = (k1 + j2) - i5 * 16;
                if(j5 < 0)
                    j5 = 0;
                if(k5 > 16)
                    k5 = 16;
                k3 = b(j4, i5).a(abyte0, k4, l3, j5, l4, i4, k5, k3);
                b(j4 * 16 + k4, l3, i5 * 16 + j5, j4 * 16 + l4, i4, i5 * 16 + k5);
            }

        }

    }

    public void k()
    {
    }

    public void l()
    {
        DataInputStream datainputstream;
        File file = new File(t, "session.lock");
        datainputstream = new DataInputStream(((java.io.InputStream) (new FileInputStream(file))));
        if(datainputstream.readLong() != G)
            throw new lx("The save is being accessed from another location, aborting");
        datainputstream.close();
        break MISSING_BLOCK_LABEL_80;
        Exception exception;
        exception;
        datainputstream.close();
        throw exception;
        IOException ioexception;
        ioexception;
        throw new lx("Failed to check session lock, aborting");
    }

    public void a(long l1)
    {
        c = l1;
    }

    public void f(kh kh1)
    {
        int i1 = eo.b(kh1.ak / 16D);
        int j1 = eo.b(kh1.am / 16D);
        byte byte0 = 2;
        for(int k1 = i1 - byte0; k1 <= i1 + byte0; k1++)
        {
            for(int l1 = j1 - byte0; l1 <= j1 + byte0; l1++)
                b(k1, l1);

        }

        if(!a.contains(((Object) (kh1))))
        {
            System.out.println("REINSERTING PLAYER!");
            a.add(((Object) (kh1)));
        }
    }

    private List z;
    public List a;
    private List A;
    private TreeSet B;
    private Set C;
    public List b;
    public long c;
    public boolean d;
    private long D;
    private long E;
    private long F;
    public int e;
    protected int f;
    protected int g;
    public boolean h;
    public static float i[];
    private final long G;
    protected int j;
    public List k;
    public int l;
    public Object m;
    public Random n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    protected List s;
    private aw H;
    public File t;
    public long u;
    private hm I;
    public long v;
    public final String w;
    public boolean x;
    private ArrayList J;
    private Set K;
    private int L;
    private List M;
    public boolean y;

    static 
    {
        i = new float[16];
        float f1 = 0.05F;
        for(int i1 = 0; i1 <= 15; i1++)
        {
            float f2 = 1.0F - (float)i1 / 15F;
            i[i1] = ((1.0F - f2) / (f2 * 3F + 1.0F)) * (1.0F - f1) + f1;
        }

    }
}
