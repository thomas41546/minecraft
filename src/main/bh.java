package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class bh extends lm
{

    public bh()
    {
        e = ((java.util.List) (new ArrayList()));
        f = false;
        a = null;
    }

    public void a(int j, int k, float f1)
    {
        for(int l = 0; l < e.size(); l++)
        {
            fk fk1 = (fk)e.get(l);
            fk1.a(b, j, k);
        }

    }

    protected void a(char c1, int j)
    {
        if(j == 1)
        {
            b.a(((bh) (null)));
            b.e();
        }
    }

    public static String c()
    {
        String s;
        Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(((Object) (null)));
        if(transferable == null || !transferable.isDataFlavorSupported(DataFlavor.stringFlavor))
            break MISSING_BLOCK_LABEL_46;
        s = (String)transferable.getTransferData(DataFlavor.stringFlavor);
        return s;
        Exception exception;
        exception;
        return null;
    }

    protected void a(int j, int k, int l)
    {
        if(l == 0)
        {
            for(int i1 = 0; i1 < e.size(); i1++)
            {
                fk fk1 = (fk)e.get(i1);
                if(fk1.c(b, j, k))
                {
                    a = fk1;
                    b.A.a("random.click", 1.0F, 1.0F);
                    a(fk1);
                }
            }

        }
    }

    protected void b(int j, int k, int l)
    {
        if(a != null && l == 0)
        {
            a.a(j, k);
            a = null;
        }
    }

    protected void a(fk fk1)
    {
    }

    public void a(Minecraft minecraft, int j, int k)
    {
        b = minecraft;
        g = minecraft.o;
        c = j;
        d = k;
        a();
    }

    public void a()
    {
    }

    public void d()
    {
        for(; Mouse.next(); e());
        for(; Keyboard.next(); f());
    }

    public void e()
    {
        if(Mouse.getEventButtonState())
        {
            int j = (Mouse.getEventX() * c) / b.c;
            int l = d - (Mouse.getEventY() * d) / b.d - 1;
            a(j, l, Mouse.getEventButton());
        } else
        {
            int k = (Mouse.getEventX() * c) / b.c;
            int i1 = d - (Mouse.getEventY() * d) / b.d - 1;
            b(k, i1, Mouse.getEventButton());
        }
    }

    public void f()
    {
        if(Keyboard.getEventKeyState())
        {
            if(Keyboard.getEventKey() == 87)
            {
                b.h();
                return;
            }
            a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
        }
    }

    public void g()
    {
    }

    public void h()
    {
    }

    public void i()
    {
        a(0);
    }

    public void a(int j)
    {
        if(b.e != null)
            a(0, 0, c, d, 0xc0101010, 0xd0101010);
        else
            b(j);
    }

    public void b(int j)
    {
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        ho ho1 = ho.a;
        GL11.glBindTexture(3553, b.n.a("/dirt.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f1 = 32F;
        ho1.b();
        ho1.b(0x404040);
        ho1.a(0.0D, d, 0.0D, 0.0D, (float)d / f1 + (float)j);
        ho1.a(c, d, 0.0D, (float)c / f1, (float)d / f1 + (float)j);
        ho1.a(c, 0.0D, 0.0D, (float)c / f1, 0 + j);
        ho1.a(0.0D, 0.0D, 0.0D, 0.0D, 0 + j);
        ho1.a();
    }

    public boolean b()
    {
        return true;
    }

    public void a(boolean flag, int j)
    {
    }

    protected Minecraft b;
    public int c;
    public int d;
    protected java.util.List e;
    public boolean f;
    protected kd g;
    private fk a;
}
