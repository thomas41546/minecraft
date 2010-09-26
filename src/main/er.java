package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile


public final class er extends Enum
{

    public static er[] values()
    {
        return (er[])((er []) (D)).clone();
    }

    public static er valueOf(String s1)
    {
        return (er)Enum.valueOf(er, s1);
    }

    private er(String s1, int i1, String s2, int j1, int k1, int l1, int i2)
    {
        super(s1, i1);
        y = s2;
        z = j1;
        A = k1;
        B = l1;
        C = i2;
    }

    public static final er a;
    public static final er b;
    public static final er c;
    public static final er d;
    public static final er e;
    public static final er f;
    public static final er g;
    public static final er h;
    public static final er i;
    public static final er j;
    public static final er k;
    public static final er l;
    public static final er m;
    public static final er n;
    public static final er o;
    public static final er p;
    public static final er q;
    public static final er r;
    public static final er s;
    public static final er t;
    public static final er u;
    public static final er v;
    public static final er w;
    public static final er x;
    public final String y;
    public final int z;
    public final int A;
    public final int B;
    public final int C;
    private static final er D[];

    static 
    {
        a = new er("Kebab", 0, "Kebab", 16, 16, 0, 0);
        b = new er("Aztec", 1, "Aztec", 16, 16, 16, 0);
        c = new er("Alban", 2, "Alban", 16, 16, 32, 0);
        d = new er("Aztec2", 3, "Aztec2", 16, 16, 48, 0);
        e = new er("Bomb", 4, "Bomb", 16, 16, 64, 0);
        f = new er("Plant", 5, "Plant", 16, 16, 80, 0);
        g = new er("Wasteland", 6, "Wasteland", 16, 16, 96, 0);
        h = new er("Pool", 7, "Pool", 32, 16, 0, 32);
        i = new er("Courbet", 8, "Courbet", 32, 16, 32, 32);
        j = new er("Sea", 9, "Sea", 32, 16, 64, 32);
        k = new er("Sunset", 10, "Sunset", 32, 16, 96, 32);
        l = new er("Creebet", 11, "Creebet", 32, 16, 128, 32);
        m = new er("Wanderer", 12, "Wanderer", 16, 32, 0, 64);
        n = new er("Graham", 13, "Graham", 16, 32, 16, 64);
        o = new er("Match", 14, "Match", 32, 32, 0, 128);
        p = new er("Bust", 15, "Bust", 32, 32, 32, 128);
        q = new er("Stage", 16, "Stage", 32, 32, 64, 128);
        r = new er("Void", 17, "Void", 32, 32, 96, 128);
        s = new er("SkullAndRoses", 18, "SkullAndRoses", 32, 32, 128, 128);
        t = new er("Fighters", 19, "Fighters", 64, 32, 0, 96);
        u = new er("Pointer", 20, "Pointer", 64, 64, 0, 192);
        v = new er("Pigscene", 21, "Pigscene", 64, 64, 64, 192);
        w = new er("Skeleton", 22, "Skeleton", 64, 48, 192, 64);
        x = new er("DonkeyKong", 23, "DonkeyKong", 64, 48, 192, 112);
        D = (new er[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x
        });
    }
}
