package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.nio.Buffer;
import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

public class j extends bt
{

    public j()
    {
        f = df.d(16);
        g = df.d(16);
        h = df.d(16);
    }

    public static bt a()
    {
        e.b();
        return ((bt) (e));
    }

    private void a(float af[][], int i)
    {
        float f1 = eo.c(af[i][0] * af[i][0] + af[i][1] * af[i][1] + af[i][2] * af[i][2]);
        af[i][0] /= f1;
        af[i][1] /= f1;
        af[i][2] /= f1;
        af[i][3] /= f1;
    }

    private void b()
    {
        f.clear();
        g.clear();
        h.clear();
        GL11.glGetFloat(2983, f);
        GL11.glGetFloat(2982, g);
        f.flip().limit(16);
        f.get(b);
        g.flip().limit(16);
        g.get(c);
        d[0] = c[0] * b[0] + c[1] * b[4] + c[2] * b[8] + c[3] * b[12];
        d[1] = c[0] * b[1] + c[1] * b[5] + c[2] * b[9] + c[3] * b[13];
        d[2] = c[0] * b[2] + c[1] * b[6] + c[2] * b[10] + c[3] * b[14];
        d[3] = c[0] * b[3] + c[1] * b[7] + c[2] * b[11] + c[3] * b[15];
        d[4] = c[4] * b[0] + c[5] * b[4] + c[6] * b[8] + c[7] * b[12];
        d[5] = c[4] * b[1] + c[5] * b[5] + c[6] * b[9] + c[7] * b[13];
        d[6] = c[4] * b[2] + c[5] * b[6] + c[6] * b[10] + c[7] * b[14];
        d[7] = c[4] * b[3] + c[5] * b[7] + c[6] * b[11] + c[7] * b[15];
        d[8] = c[8] * b[0] + c[9] * b[4] + c[10] * b[8] + c[11] * b[12];
        d[9] = c[8] * b[1] + c[9] * b[5] + c[10] * b[9] + c[11] * b[13];
        d[10] = c[8] * b[2] + c[9] * b[6] + c[10] * b[10] + c[11] * b[14];
        d[11] = c[8] * b[3] + c[9] * b[7] + c[10] * b[11] + c[11] * b[15];
        d[12] = c[12] * b[0] + c[13] * b[4] + c[14] * b[8] + c[15] * b[12];
        d[13] = c[12] * b[1] + c[13] * b[5] + c[14] * b[9] + c[15] * b[13];
        d[14] = c[12] * b[2] + c[13] * b[6] + c[14] * b[10] + c[15] * b[14];
        d[15] = c[12] * b[3] + c[13] * b[7] + c[14] * b[11] + c[15] * b[15];
        a[0][0] = d[3] - d[0];
        a[0][1] = d[7] - d[4];
        a[0][2] = d[11] - d[8];
        a[0][3] = d[15] - d[12];
        a(a, 0);
        a[1][0] = d[3] + d[0];
        a[1][1] = d[7] + d[4];
        a[1][2] = d[11] + d[8];
        a[1][3] = d[15] + d[12];
        a(a, 1);
        a[2][0] = d[3] + d[1];
        a[2][1] = d[7] + d[5];
        a[2][2] = d[11] + d[9];
        a[2][3] = d[15] + d[13];
        a(a, 2);
        a[3][0] = d[3] - d[1];
        a[3][1] = d[7] - d[5];
        a[3][2] = d[11] - d[9];
        a[3][3] = d[15] - d[13];
        a(a, 3);
        a[4][0] = d[3] - d[2];
        a[4][1] = d[7] - d[6];
        a[4][2] = d[11] - d[10];
        a[4][3] = d[15] - d[14];
        a(a, 4);
        a[5][0] = d[3] + d[2];
        a[5][1] = d[7] + d[6];
        a[5][2] = d[11] + d[10];
        a[5][3] = d[15] + d[14];
        a(a, 5);
    }

    private static j e = new j();
    private FloatBuffer f;
    private FloatBuffer g;
    private FloatBuffer h;

}
