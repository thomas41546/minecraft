// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;


class Mdct
{

    Mdct()
    {
        _x = new float[1024];
        _w = new float[1024];
    }

    void init(int i)
    {
        bitrev = new int[i / 4];
        trig = new float[i + i / 4];
        log2n = (int)Math.rint(Math.log(i) / Math.log(2D));
        n = i;
        int j = 0;
        int k = 1;
        int l = j + i / 2;
        int i1 = l + 1;
        int j1 = l + i / 2;
        int k1 = j1 + 1;
        for(int l1 = 0; l1 < i / 4; l1++)
        {
            trig[j + l1 * 2] = (float)Math.cos((3.1415926535897931D / (double)i) * (double)(4 * l1));
            trig[k + l1 * 2] = (float)(-Math.sin((3.1415926535897931D / (double)i) * (double)(4 * l1)));
            trig[l + l1 * 2] = (float)Math.cos((3.1415926535897931D / (double)(2 * i)) * (double)(2 * l1 + 1));
            trig[i1 + l1 * 2] = (float)Math.sin((3.1415926535897931D / (double)(2 * i)) * (double)(2 * l1 + 1));
        }

        for(int i2 = 0; i2 < i / 8; i2++)
        {
            trig[j1 + i2 * 2] = (float)Math.cos((3.1415926535897931D / (double)i) * (double)(4 * i2 + 2));
            trig[k1 + i2 * 2] = (float)(-Math.sin((3.1415926535897931D / (double)i) * (double)(4 * i2 + 2)));
        }

        int j2 = (1 << log2n - 1) - 1;
        int k2 = 1 << log2n - 2;
        for(int l2 = 0; l2 < i / 8; l2++)
        {
            int i3 = 0;
            for(int j3 = 0; k2 >>> j3 != 0; j3++)
                if((k2 >>> j3 & l2) != 0)
                    i3 |= 1 << j3;

            bitrev[l2 * 2] = ~i3 & j2;
            bitrev[l2 * 2 + 1] = i3;
        }

        scale = 4F / (float)i;
    }

    void clear()
    {
    }

    void forward(float af[], float af1[])
    {
    }

    synchronized void backward(float af[], float af1[])
    {
        if(_x.length < n / 2)
            _x = new float[n / 2];
        if(_w.length < n / 2)
            _w = new float[n / 2];
        float af2[] = _x;
        float af3[] = _w;
        int i = n >>> 1;
        int j = n >>> 2;
        int k = n >>> 3;
        int l = 1;
        int i1 = 0;
        int j1 = i;
        for(int k1 = 0; k1 < k; k1++)
        {
            j1 -= 2;
            af2[i1++] = -af[l + 2] * trig[j1 + 1] - af[l] * trig[j1];
            af2[i1++] = af[l] * trig[j1 + 1] - af[l + 2] * trig[j1];
            l += 4;
        }

        l = i - 4;
        for(int l1 = 0; l1 < k; l1++)
        {
            j1 -= 2;
            af2[i1++] = af[l] * trig[j1 + 1] + af[l + 2] * trig[j1];
            af2[i1++] = af[l] * trig[j1] - af[l + 2] * trig[j1 + 1];
            l -= 4;
        }

        float af4[] = mdct_kernel(af2, af3, n, i, j, k);
        i1 = 0;
        j1 = i;
        int i2 = j;
        int j2 = i2 - 1;
        int k2 = j + i;
        int l2 = k2 - 1;
        for(int i3 = 0; i3 < j; i3++)
        {
            float f = af4[i1] * trig[j1 + 1] - af4[i1 + 1] * trig[j1];
            float f1 = -(af4[i1] * trig[j1] + af4[i1 + 1] * trig[j1 + 1]);
            af1[i2] = -f;
            af1[j2] = f;
            af1[k2] = f1;
            af1[l2] = f1;
            i2++;
            j2--;
            k2++;
            l2--;
            i1 += 2;
            j1 += 2;
        }

    }

    private float[] mdct_kernel(float af[], float af1[], int i, int j, int k, int l)
    {
        int i1 = k;
        int j1 = 0;
        int k1 = k;
        int i2 = j;
        for(int k2 = 0; k2 < k; k2++)
        {
            float f = af[i1] - af[j1];
            af1[k1 + k2] = af[i1++] + af[j1++];
            float f1 = af[i1] - af[j1];
            i2 -= 4;
            af1[k2++] = f * trig[i2] + f1 * trig[i2 + 1];
            af1[k2] = f1 * trig[i2] - f * trig[i2 + 1];
            af1[k1 + k2] = af[i1++] + af[j1++];
        }

        for(int l2 = 0; l2 < log2n - 3; l2++)
        {
            int j3 = i >>> l2 + 2;
            int l3 = 1 << l2 + 3;
            int j4 = j - 2;
            int j2 = 0;
            for(int i5 = 0; i5 < j3 >>> 2; i5++)
            {
                int k5 = j4;
                int l1 = k5 - (j3 >> 1);
                float f2 = trig[j2];
                float f6 = trig[j2 + 1];
                j4 -= 2;
                j3++;
                for(int i6 = 0; i6 < 2 << l2; i6++)
                {
                    float f8 = af1[k5] - af1[l1];
                    af[k5] = af1[k5] + af1[l1];
                    float f4 = af1[++k5] - af1[++l1];
                    af[k5] = af1[k5] + af1[l1];
                    af[l1] = f4 * f2 - f8 * f6;
                    af[l1 - 1] = f8 * f2 + f4 * f6;
                    k5 -= j3;
                    l1 -= j3;
                }

                j3--;
                j2 += l3;
            }

            float af2[] = af1;
            af1 = af;
            af = af2;
        }

        int i3 = i;
        int k3 = 0;
        int i4 = 0;
        int k4 = j - 1;
        for(int l4 = 0; l4 < l; l4++)
        {
            int j5 = bitrev[k3++];
            int l5 = bitrev[k3++];
            float f3 = af1[j5] - af1[l5 + 1];
            float f5 = af1[j5 - 1] + af1[l5];
            float f7 = af1[j5] + af1[l5 + 1];
            float f9 = af1[j5 - 1] - af1[l5];
            float f10 = f3 * trig[i3];
            float f11 = f5 * trig[i3++];
            float f12 = f3 * trig[i3];
            float f13 = f5 * trig[i3++];
            af[i4++] = (f7 + f12 + f11) * 0.5F;
            af[k4--] = ((-f9 + f13) - f10) * 0.5F;
            af[i4++] = ((f9 + f13) - f10) * 0.5F;
            af[k4--] = (f7 - f12 - f11) * 0.5F;
        }

        return af;
    }

    int n;
    int log2n;
    float trig[];
    int bitrev[];
    float scale;
    float _x[];
    float _w[];
}
