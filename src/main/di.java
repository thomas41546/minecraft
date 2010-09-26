package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.PrintStream;
import java.util.Random;

public class di
{

    protected di(int i1)
    {
        aT = 64;
        aU = 32;
        aW = false;
        aS = 256 + i1;
        if(c[256 + i1] != null)
            System.out.println((new StringBuilder()).append("CONFLICT @ ").append(i1).toString());
        c[256 + i1] = this;
    }

    public di a(int i1)
    {
        aV = i1;
        return this;
    }

    public int a(ev ev)
    {
        return aV;
    }

    public boolean a(ev ev, dm dm, cn cn, int i1, int j1, int k1, int l1)
    {
        return false;
    }

    public float a(ev ev, ly ly1)
    {
        return 1.0F;
    }

    public ev a(ev ev, cn cn, dm dm)
    {
        return ev;
    }

    public int b()
    {
        return aT;
    }

    public int c()
    {
        return aU;
    }

    public void a(ev ev, ge ge)
    {
    }

    public void a(ev ev, int i1, int j1, int k1, int l1)
    {
    }

    public int a(kh kh)
    {
        return 1;
    }

    public boolean a(ly ly1)
    {
        return false;
    }

    public void b(ev ev, ge ge)
    {
    }

    public di d()
    {
        aW = true;
        return this;
    }

    public boolean a()
    {
        return aW;
    }

    protected static Random b = new Random();
    public static di c[] = new di[32000];
    public static di d = (new ms(0, 2)).a(82);
    public static di e = (new y(1, 2)).a(98);
    public static di f = (new ks(2, 2)).a(114);
    public static di g = (new nx(3)).a(5);
    public static di h = (new oj(4, 4)).a(10);
    public static di i = (new jg(5)).a(21);
    public static di j = (new di(6)).a(37);
    public static di k = (new di(7)).a(7);
    public static di l = (new di(8)).a(55);
    public static di m = (new di(9)).a(23);
    public static di n = (new di(10)).a(39);
    public static di o = (new iu(11, 2)).a(66);
    public static di p = (new iu(12, 0)).a(64);
    public static di q = (new ms(13, 0)).a(80);
    public static di r = (new y(14, 0)).a(96);
    public static di s = (new ks(15, 0)).a(112);
    public static di t = (new iu(16, 1)).a(65);
    public static di u = (new ms(17, 1)).a(81);
    public static di v = (new y(18, 1)).a(97);
    public static di w = (new ks(19, 1)).a(113);
    public static di x = (new iu(20, 3)).a(67);
    public static di y = (new ms(21, 3)).a(83);
    public static di z = (new y(22, 3)).a(99);
    public static di A = (new ks(23, 3)).a(115);
    public static di B = (new di(24)).a(53).d();
    public static di C = (new di(25)).a(71);
    public static di D = (new ap(26, 10)).a(72);
    public static di E = (new iu(27, 0)).a(68);
    public static di F = (new ms(28, 0)).a(84);
    public static di G = (new y(29, 0)).a(100);
    public static di H = (new ks(30, 0)).a(116);
    public static di I = (new di(31)).a(8);
    public static di J = (new di(32)).a(24);
    public static di K = (new di(33)).a(40);
    public static di L = (new fu(34, 0)).a(128);
    public static di M = (new fu(35, 1)).a(129);
    public static di N = (new fu(36, 2)).a(130);
    public static di O = (new fu(37, 3)).a(131);
    public static di P = (new fu(38, 1)).a(132);
    public static di Q;
    public static di R = (new di(40)).a(25);
    public static di S = (new oj(41, 5)).a(41);
    public static di T = (new mr(42, 0, 0, 0)).a(0);
    public static di U = (new mr(43, 0, 0, 1)).a(16);
    public static di V = (new mr(44, 0, 0, 2)).a(32);
    public static di W = (new mr(45, 0, 0, 3)).a(48);
    public static di X = (new mr(46, 1, 1, 0)).a(1);
    public static di Y = (new mr(47, 1, 1, 1)).a(17);
    public static di Z = (new mr(48, 1, 1, 2)).a(33);
    public static di aa = (new mr(49, 1, 1, 3)).a(49);
    public static di ab = (new mr(50, 2, 2, 0)).a(2);
    public static di ac = (new mr(51, 2, 2, 1)).a(18);
    public static di ad = (new mr(52, 2, 2, 2)).a(34);
    public static di ae = (new mr(53, 2, 2, 3)).a(50);
    public static di af = (new mr(54, 3, 3, 0)).a(3);
    public static di ag = (new mr(55, 3, 3, 1)).a(19);
    public static di ah = (new mr(56, 3, 3, 2)).a(35);
    public static di ai = (new mr(57, 3, 3, 3)).a(51);
    public static di aj = (new mr(58, 1, 4, 0)).a(4);
    public static di ak = (new mr(59, 1, 4, 1)).a(20);
    public static di al = (new mr(60, 1, 4, 2)).a(36);
    public static di am = (new mr(61, 1, 4, 3)).a(52);
    public static di an = (new di(62)).a(6);
    public static di ao = (new oj(63, 3)).a(87);
    public static di ap = (new oj(64, 8)).a(88);
    public static di aq = (new od(65)).a(26);
    public static di ar = (new oj(66, 42)).a(11);
    public static di as = (new md(67)).a(42);
    public static di at;
    public static di au = (new ac(69, 0)).a(74);
    public static di av;
    public static di aw;
    public static di ax = (new jo(72, 0)).a(135);
    public static di ay = (new jw(73)).a(104);
    public static di az;
    public static di aA = (new ef(75)).a(56);
    public static di aB = (new bp(76)).a(14);
    public static di aC = (new me(77)).a(136);
    public static di aD = (new di(78)).a(103);
    public static di aE = (new ac(79, -1)).a(77);
    public static di aF = (new di(80)).a(22);
    public static di aG = (new di(81)).a(57);
    public static di aH;
    public static di aI = (new di(83)).a(58);
    public static di aJ = (new di(84)).a(59);
    public static di aK = (new di(85)).a(30);
    public static di aL = (new jo(86, 1)).a(151);
    public static di aM = (new jo(87, 2)).a(167);
    public static di aN = (new di(88)).a(12);
    public static di aO = (new di(89)).a(54);
    public static di aP = (new di(90)).a(69);
    public static di aQ = (new lg(2000, "13")).a(240);
    public static di aR = (new lg(2001, "cat")).a(241);
    public final int aS;
    protected int aT;
    protected int aU;
    protected int aV;
    protected boolean aW;

    static 
    {
        Q = (new jn(39, ly.aA.bc)).a(9);
        at = (new ec(68, gb.c)).a(43);
        av = (new ac(70, ly.B.bc)).a(75);
        aw = (new ac(71, ly.D.bc)).a(76);
        az = (new ec(74, gb.e)).a(44);
        aH = (new gf(82, ly.aY)).a(27);
    }
}
