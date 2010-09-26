package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.File;
import java.io.PrintStream;
import java.util.Random;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class of
{

    public of()
    {
        b = new eb();
        c = new eb();
        d = new eb();
        e = 0;
        h = new Random();
        i = h.nextInt(12000);
    }

    public void a(fr fr1)
    {
        c.b = false;
        f = fr1;
        if(!g && (fr1 == null || fr1.b != 0.0F || fr1.a != 0.0F))
            d();
    }

    private void d()
    {
        try
        {
            float f1 = f.b;
            float f2 = f.a;
            f.b = 0.0F;
            f.a = 0.0F;
            f.b();
            SoundSystemConfig.addLibrary(paulscode/sound/libraries/LibraryLWJGLOpenAL);
            SoundSystemConfig.setCodec("ogg", paulscode/sound/codecs/CodecJOrbis);
            SoundSystemConfig.setCodec("mus", ep);
            SoundSystemConfig.setCodec("wav", paulscode/sound/codecs/CodecWav);
            a = new SoundSystem();
            f.b = f1;
            f.a = f2;
            f.b();
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }
        g = true;
    }

    public void a()
    {
        if(!g && (f.b != 0.0F || f.a != 0.0F))
            d();
        if(f.a == 0.0F)
            a.stop("BgMusic");
        else
            a.setVolume("BgMusic", f.a);
    }

    public void b()
    {
        if(g)
            a.cleanup();
    }

    public void a(String s, File file)
    {
        b.a(s, file);
    }

    public void b(String s, File file)
    {
        c.a(s, file);
    }

    public void c(String s, File file)
    {
        d.a(s, file);
    }

    public void c()
    {
        if(!g || f.a == 0.0F)
            return;
        if(!a.playing("BgMusic") && !a.playing("streaming"))
        {
            if(i > 0)
            {
                i--;
                return;
            }
            ah ah1 = d.a();
            if(ah1 != null)
            {
                i = h.nextInt(24000) + 24000;
                a.backgroundMusic("BgMusic", ah1.b, ah1.a, false);
                a.setVolume("BgMusic", f.a);
                a.play("BgMusic");
            }
        }
    }

    public void a(ge ge1, float f1)
    {
        if(!g || f.b == 0.0F)
            return;
        if(ge1 == null)
        {
            return;
        } else
        {
            float f2 = ge1.as + (ge1.aq - ge1.as) * f1;
            double d1 = ge1.ah + (ge1.ak - ge1.ah) * (double)f1;
            double d2 = ge1.ai + (ge1.al - ge1.ai) * (double)f1;
            double d3 = ge1.aj + (ge1.am - ge1.aj) * (double)f1;
            float f3 = eo.b(-f2 * 0.01745329F - 3.141593F);
            float f4 = eo.a(-f2 * 0.01745329F - 3.141593F);
            float f5 = -f4;
            float f6 = 0.0F;
            float f7 = -f3;
            float f8 = 0.0F;
            float f9 = 1.0F;
            float f10 = 0.0F;
            a.setListenerPosition((float)d1, (float)d2, (float)d3);
            a.setListenerOrientation(f5, f6, f7, f8, f9, f10);
            return;
        }
    }

    public void a(String s, float f1, float f2, float f3, float f4, float f5)
    {
        if(!g || f.b == 0.0F)
            return;
        String s1 = "streaming";
        if(a.playing("streaming"))
            a.stop("streaming");
        if(s == null)
            return;
        ah ah1 = c.a(s);
        if(ah1 != null && f4 > 0.0F)
        {
            if(a.playing("BgMusic"))
                a.stop("BgMusic");
            float f6 = 16F;
            a.newStreamingSource(true, s1, ah1.b, ah1.a, false, f1, f2, f3, 2, f6 * 4F);
            a.setVolume(s1, 0.5F * f.b);
            a.play(s1);
        }
    }

    public void b(String s, float f1, float f2, float f3, float f4, float f5)
    {
        if(!g || f.b == 0.0F)
            return;
        ah ah1 = b.a(s);
        if(ah1 != null && f4 > 0.0F)
        {
            e = (e + 1) % 256;
            String s1 = (new StringBuilder()).append("sound_").append(e).toString();
            float f6 = 16F;
            if(f4 > 1.0F)
                f6 *= f4;
            a.newSource(f4 > 1.0F, s1, ah1.b, ah1.a, false, f1, f2, f3, 2, f6);
            a.setPitch(s1, f5);
            if(f4 > 1.0F)
                f4 = 1.0F;
            a.setVolume(s1, f4 * f.b);
            a.play(s1);
        }
    }

    public void a(String s, float f1, float f2)
    {
        if(!g || f.b == 0.0F)
            return;
        ah ah1 = b.a(s);
        if(ah1 != null)
        {
            e = (e + 1) % 256;
            String s1 = (new StringBuilder()).append("sound_").append(e).toString();
            a.newSource(false, s1, ah1.b, ah1.a, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);
            if(f1 > 1.0F)
                f1 = 1.0F;
            f1 *= 0.25F;
            a.setPitch(s1, f2);
            a.setVolume(s1, f1 * f.b);
            a.play(s1);
        }
    }

    private static SoundSystem a;
    private eb b;
    private eb c;
    private eb d;
    private int e;
    private fr f;
    private static boolean g = false;
    private Random h;
    private int i;

}
