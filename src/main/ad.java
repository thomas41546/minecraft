package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;

public class ad extends Canvas
    implements KeyListener, MouseListener, MouseMotionListener, Runnable
{

    public File a()
    {
        if(e == null)
            e = a("minecraft");
        return e;
    }

    public File a(String s)
    {
        String s1 = System.getProperty("user.home", ".");
        File file;
        switch(ln.a[e().ordinal()])
        {
        case 1: // '\001'
        case 2: // '\002'
            file = new File(s1, (new StringBuilder()).append('.').append(s).append('/').toString());
            break;

        case 3: // '\003'
            String s2 = System.getenv("APPDATA");
            if(s2 != null)
                file = new File(s2, (new StringBuilder()).append(".").append(s).append('/').toString());
            else
                file = new File(s1, (new StringBuilder()).append('.').append(s).append('/').toString());
            break;

        case 4: // '\004'
            file = new File(s1, (new StringBuilder()).append("Library/Application Support/").append(s).toString());
            break;

        default:
            file = new File(s1, (new StringBuilder()).append(s).append('/').toString());
            break;
        }
        if(!file.exists() && !file.mkdirs())
            throw new RuntimeException((new StringBuilder()).append("The working directory could not be created: ").append(((Object) (file))).toString());
        else
            return file;
    }

    private static fa e()
    {
        String s = System.getProperty("os.name").toLowerCase();
        if(s.contains("win"))
            return fa.c;
        if(s.contains("mac"))
            return fa.d;
        if(s.contains("solaris"))
            return fa.b;
        if(s.contains("sunos"))
            return fa.b;
        if(s.contains("linux"))
            return fa.a;
        if(s.contains("unix"))
            return fa.a;
        else
            return fa.e;
    }

    public ad()
    {
        a = 0;
        b = 2;
        c = true;
        f = true;
        g = Collections.synchronizedList(((java.util.List) (new LinkedList())));
        h = new jj[64][64];
        e = a();
        for(int i1 = 0; i1 < 64; i1++)
        {
            for(int j1 = 0; j1 < 64; j1++)
                h[i1][j1] = new jj(((cn) (null)), i1, j1);

        }

        addMouseListener(((MouseListener) (this)));
        addMouseMotionListener(((MouseMotionListener) (this)));
        addKeyListener(((KeyListener) (this)));
        setFocusable(true);
        requestFocus();
        setBackground(Color.red);
    }

    public void b(String s)
    {
        i = j = 0;
        d = ((cn) (new lk(this, new File(e, "saves"), s)));
        d.e = 0;
        synchronized(g)
        {
            g.clear();
            for(int i1 = 0; i1 < 64; i1++)
            {
                for(int j1 = 0; j1 < 64; j1++)
                    h[i1][j1].a(d, i1, j1);

            }

        }
    }

    private void a(int i1)
    {
        synchronized(g)
        {
            d.e = i1;
            g.clear();
            for(int j1 = 0; j1 < 64; j1++)
            {
                for(int k1 = 0; k1 < 64; k1++)
                    h[j1][k1].a(d, j1, k1);

            }

        }
    }

    public void b()
    {
        (new lh(this)).start();
        for(int i1 = 0; i1 < 8; i1++)
            (new Thread(((Runnable) (this)))).start();

    }

    public void c()
    {
        f = false;
    }

    private jj a(int i1, int j1)
    {
        int k1 = i1 & 0x3f;
        int l1 = j1 & 0x3f;
        jj jj1 = h[k1][l1];
        if(jj1.c == i1 && jj1.d == j1)
            return jj1;
        synchronized(g)
        {
            g.remove(((Object) (jj1)));
        }
        jj1.a(i1, j1);
        return jj1;
    }

    public void run()
    {
        lt lt1 = new lt();
        while(f) 
        {
            jj jj1 = null;
            synchronized(g)
            {
                if(g.size() > 0)
                    jj1 = (jj)g.remove(0);
            }
            if(jj1 != null)
                if(a - jj1.g < 2)
                {
                    lt1.a(jj1);
                    repaint();
                } else
                {
                    jj1.h = false;
                }
            try
            {
                Thread.sleep(2L);
            }
            catch(InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
    }

    public void update(Graphics g1)
    {
    }

    public void paint(Graphics g1)
    {
    }

    public void d()
    {
        BufferStrategy bufferstrategy = getBufferStrategy();
        if(bufferstrategy == null)
        {
            createBufferStrategy(2);
            return;
        } else
        {
            a((Graphics2D)bufferstrategy.getDrawGraphics());
            bufferstrategy.show();
            return;
        }
    }

    public void a(Graphics2D graphics2d)
    {
        a++;
        java.awt.geom.AffineTransform affinetransform = graphics2d.getTransform();
        graphics2d.setClip(0, 0, getWidth(), getHeight());
        graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        graphics2d.translate(getWidth() / 2, getHeight() / 2);
        graphics2d.scale(b, b);
        graphics2d.translate(i, j);
        if(d != null)
            graphics2d.translate(-(d.o + d.q), -(-d.o + d.q) + 64);
        Rectangle rectangle = graphics2d.getClipBounds();
        graphics2d.setColor(new Color(0xff101020));
        graphics2d.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        byte byte0 = 16;
        byte byte1 = 3;
        int i1 = rectangle.x / byte0 / 2 - 2 - byte1;
        int j1 = (rectangle.x + rectangle.width) / byte0 / 2 + 1 + byte1;
        int k1 = rectangle.y / byte0 - 1 - byte1 * 2;
        int l1 = (rectangle.y + rectangle.height + 16 + 128) / byte0 + 1 + byte1 * 2;
        for(int i2 = k1; i2 <= l1; i2++)
        {
            for(int k2 = i1; k2 <= j1; k2++)
            {
                int l2 = k2 - (i2 >> 1);
                int i3 = k2 + (i2 + 1 >> 1);
                jj jj1 = a(l2, i3);
                jj1.g = a;
                if(!jj1.e)
                {
                    if(!jj1.h)
                    {
                        jj1.h = true;
                        g.add(((Object) (jj1)));
                    }
                    continue;
                }
                jj1.h = false;
                if(!jj1.f)
                {
                    int j3 = k2 * byte0 * 2 + (i2 & 1) * byte0;
                    int k3 = i2 * byte0 - 128 - 16;
                    graphics2d.drawImage(((java.awt.Image) (jj1.a)), j3, k3, ((java.awt.image.ImageObserver) (null)));
                }
            }

        }

        if(c)
        {
            graphics2d.setTransform(affinetransform);
            int j2 = getHeight() - 32 - 4;
            graphics2d.setColor(new Color(0x80000000, true));
            graphics2d.fillRect(4, getHeight() - 32 - 4, getWidth() - 8, 32);
            graphics2d.setColor(Color.WHITE);
            String s = "F1 - F5: load levels   |   0-9: Set time of day   |   Space: return to spawn   |   Double click: zoom   |   Escape: hide this text";
            graphics2d.drawString(s, getWidth() / 2 - graphics2d.getFontMetrics().stringWidth(s) / 2, j2 + 20);
        }
        graphics2d.dispose();
    }

    public void mouseDragged(MouseEvent mouseevent)
    {
        int i1 = mouseevent.getX() / b;
        int j1 = mouseevent.getY() / b;
        i += i1 - k;
        j += j1 - l;
        k = i1;
        l = j1;
        repaint();
    }

    public void mouseMoved(MouseEvent mouseevent)
    {
    }

    public void mouseClicked(MouseEvent mouseevent)
    {
        if(mouseevent.getClickCount() == 2)
        {
            b = 3 - b;
            repaint();
        }
    }

    public void mouseEntered(MouseEvent mouseevent)
    {
    }

    public void mouseExited(MouseEvent mouseevent)
    {
    }

    public void mousePressed(MouseEvent mouseevent)
    {
        int i1 = mouseevent.getX() / b;
        int j1 = mouseevent.getY() / b;
        k = i1;
        l = j1;
    }

    public void mouseReleased(MouseEvent mouseevent)
    {
    }

    public void keyPressed(KeyEvent keyevent)
    {
        if(keyevent.getKeyCode() == 48)
            a(11);
        if(keyevent.getKeyCode() == 49)
            a(10);
        if(keyevent.getKeyCode() == 50)
            a(9);
        if(keyevent.getKeyCode() == 51)
            a(7);
        if(keyevent.getKeyCode() == 52)
            a(6);
        if(keyevent.getKeyCode() == 53)
            a(5);
        if(keyevent.getKeyCode() == 54)
            a(3);
        if(keyevent.getKeyCode() == 55)
            a(2);
        if(keyevent.getKeyCode() == 56)
            a(1);
        if(keyevent.getKeyCode() == 57)
            a(0);
        if(keyevent.getKeyCode() == 112)
            b("World1");
        if(keyevent.getKeyCode() == 113)
            b("World2");
        if(keyevent.getKeyCode() == 114)
            b("World3");
        if(keyevent.getKeyCode() == 115)
            b("World4");
        if(keyevent.getKeyCode() == 116)
            b("World5");
        if(keyevent.getKeyCode() == 32)
            i = j = 0;
        if(keyevent.getKeyCode() == 27)
            c = !c;
        repaint();
    }

    public void keyReleased(KeyEvent keyevent)
    {
    }

    public void keyTyped(KeyEvent keyevent)
    {
    }

    static boolean a(ad ad1)
    {
        return ad1.f;
    }

    private int a;
    private int b;
    private boolean c;
    private cn d;
    private File e;
    private boolean f;
    private java.util.List g;
    private jj h[][];
    private int i;
    private int j;
    private int k;
    private int l;
}
