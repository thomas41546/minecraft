package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

class db extends Canvas
{

    public db()
    {
        try
        {
            a = ImageIO.read(((Class) (aq)).getResource("/gui/logo.png"));
        }
        catch(IOException ioexception) { }
        byte byte0 = 100;
        setPreferredSize(new Dimension(((int) (byte0)), ((int) (byte0))));
        setMinimumSize(new Dimension(((int) (byte0)), ((int) (byte0))));
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(((java.awt.Image) (a)), getWidth() / 2 - a.getWidth() / 2, 32, ((java.awt.image.ImageObserver) (null)));
    }

    private BufferedImage a;
}
