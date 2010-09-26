// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;


class Drft
{

    Drft()
    {
    }

    void backward(float af[])
    {
        if(n == 1)
        {
            return;
        } else
        {
            drftb1(n, af, trigcache, trigcache, n, splitcache);
            return;
        }
    }

    void init(int i)
    {
        n = i;
        trigcache = new float[3 * i];
        splitcache = new int[32];
        fdrffti(i, trigcache, splitcache);
    }

    void clear()
    {
        if(trigcache != null)
            trigcache = null;
        if(splitcache != null)
            splitcache = null;
    }

    static void drfti1(int i, float af[], int j, int ai[])
    {
        int k;
        int j1;
        int i5;
        int j5;
        byte byte0;
        k = 0;
        j1 = -1;
        i5 = i;
        j5 = 0;
        byte0 = 101;
_L6:
        byte0;
        JVM INSTR lookupswitch 3: default 388
    //                   101: 52
    //                   104: 75
    //                   107: 184;
           goto _L1 _L2 _L3 _L4
_L1:
        continue; /* Loop/switch isn't completed */
_L2:
        if(++j1 < 4)
            k = ntryh[j1];
        else
            k += 2;
_L3:
        int l3 = i5 / k;
        int i4 = i5 - k * l3;
        if(i4 != 0)
        {
            byte0 = 101;
            continue; /* Loop/switch isn't completed */
        }
        j5++;
        ai[j5 + 1] = k;
        i5 = l3;
        if(k != 2)
        {
            byte0 = 107;
            continue; /* Loop/switch isn't completed */
        }
        if(j5 == 1)
        {
            byte0 = 107;
            continue; /* Loop/switch isn't completed */
        }
        for(int l = 1; l < j5; l++)
        {
            int k2 = (j5 - l) + 1;
            ai[k2 + 1] = ai[k2];
        }

        ai[2] = 2;
_L4:
        if(i5 == 1)
            break; /* Loop/switch isn't completed */
        byte0 = 104;
        if(true) goto _L6; else goto _L5
_L5:
        ai[0] = i;
        ai[1] = j5;
        float f1 = tpi / (float)i;
        int k3 = 0;
        int l4 = j5 - 1;
        int i2 = 1;
        if(l4 == 0)
            return;
        for(int l1 = 0; l1 < l4; l1++)
        {
            int j3 = ai[l1 + 2];
            int l2 = 0;
            int j2 = i2 * j3;
            int j4 = i / j2;
            int k4 = j3 - 1;
            for(int k1 = 0; k1 < k4; k1++)
            {
                l2 += i2;
                int i1 = k3;
                float f2 = (float)l2 * f1;
                float f3 = 0.0F;
                for(int i3 = 2; i3 < j4; i3 += 2)
                {
                    f3++;
                    float f = f3 * f2;
                    af[j + i1++] = (float)Math.cos(f);
                    af[j + i1++] = (float)Math.sin(f);
                }

                k3 += j4;
            }

            i2 = j2;
        }

        return;
    }

    static void fdrffti(int i, float af[], int ai[])
    {
        if(i == 1)
        {
            return;
        } else
        {
            drfti1(i, af, i, ai);
            return;
        }
    }

    static void dradf2(int i, int j, float af[], float af1[], float af2[], int k)
    {
        int i2 = 0;
        int j2;
        int l1 = j2 = j * i;
        int k2 = i << 1;
        for(int i1 = 0; i1 < j; i1++)
        {
            af1[i2 << 1] = af[i2] + af[j2];
            af1[((i2 << 1) + k2) - 1] = af[i2] - af[j2];
            i2 += i;
            j2 += i;
        }

        if(i < 2)
            return;
        if(i != 2)
        {
            i2 = 0;
            j2 = l1;
            for(int j1 = 0; j1 < j; j1++)
            {
                k2 = j2;
                int l2 = (i2 << 1) + (i << 1);
                int i3 = i2;
                int j3 = i2 + i2;
                for(int l = 2; l < i; l += 2)
                {
                    k2 += 2;
                    l2 -= 2;
                    i3 += 2;
                    j3 += 2;
                    float f1 = af2[(k + l) - 2] * af[k2 - 1] + af2[(k + l) - 1] * af[k2];
                    float f = af2[(k + l) - 2] * af[k2] - af2[(k + l) - 1] * af[k2 - 1];
                    af1[j3] = af[i3] + f;
                    af1[l2] = f - af[i3];
                    af1[j3 - 1] = af[i3 - 1] + f1;
                    af1[l2 - 1] = af[i3 - 1] - f1;
                }

                i2 += i;
                j2 += i;
            }

            if(i % 2 == 1)
                return;
        }
        k2 = j2 = (i2 = i) - 1;
        j2 += l1;
        for(int k1 = 0; k1 < j; k1++)
        {
            af1[i2] = -af[j2];
            af1[i2 - 1] = af[k2];
            i2 += i << 1;
            j2 += i;
            k2 += i;
        }

    }

    static void dradf4(int i, int j, float af[], float af1[], float af2[], int k, float af3[], int l, 
            float af4[], int i1)
    {
        int j2 = j * i;
        int k2 = j2;
        int j3 = k2 << 1;
        int l2 = k2 + (k2 << 1);
        int i3 = 0;
        for(int k1 = 0; k1 < j; k1++)
        {
            float f11 = af[k2] + af[l2];
            float f14 = af[i3] + af[j3];
            int k3;
            af1[k3 = i3 << 2] = f11 + f14;
            af1[((i << 2) + k3) - 1] = f14 - f11;
            af1[(k3 += i << 1) - 1] = af[i3] - af[j3];
            af1[k3] = af[l2] - af[k2];
            k2 += i;
            l2 += i;
            i3 += i;
            j3 += i;
        }

        if(i < 2)
            return;
        if(i != 2)
        {
            k2 = 0;
            for(int l1 = 0; l1 < j; l1++)
            {
                l2 = k2;
                j3 = k2 << 2;
                int j4;
                int l3 = (j4 = i << 1) + j3;
                for(int j1 = 2; j1 < i; j1 += 2)
                {
                    i3 = l2 += 2;
                    j3 += 2;
                    l3 -= 2;
                    i3 += j2;
                    float f3 = af2[(k + j1) - 2] * af[i3 - 1] + af2[(k + j1) - 1] * af[i3];
                    float f = af2[(k + j1) - 2] * af[i3] - af2[(k + j1) - 1] * af[i3 - 1];
                    i3 += j2;
                    float f4 = af3[(l + j1) - 2] * af[i3 - 1] + af3[(l + j1) - 1] * af[i3];
                    float f1 = af3[(l + j1) - 2] * af[i3] - af3[(l + j1) - 1] * af[i3 - 1];
                    i3 += j2;
                    float f5 = af4[(i1 + j1) - 2] * af[i3 - 1] + af4[(i1 + j1) - 1] * af[i3];
                    float f2 = af4[(i1 + j1) - 2] * af[i3] - af4[(i1 + j1) - 1] * af[i3 - 1];
                    float f12 = f3 + f5;
                    float f17 = f5 - f3;
                    float f6 = f + f2;
                    float f10 = f - f2;
                    float f8 = af[l2] + f1;
                    float f9 = af[l2] - f1;
                    float f15 = af[l2 - 1] + f4;
                    float f16 = af[l2 - 1] - f4;
                    af1[j3 - 1] = f12 + f15;
                    af1[j3] = f6 + f8;
                    af1[l3 - 1] = f16 - f10;
                    af1[l3] = f17 - f9;
                    af1[(j3 + j4) - 1] = f10 + f16;
                    af1[j3 + j4] = f17 + f9;
                    af1[(l3 + j4) - 1] = f15 - f12;
                    af1[l3 + j4] = f6 - f8;
                }

                k2 += i;
            }

            if((i & 1) != 0)
                return;
        }
        l2 = (k2 = (j2 + i) - 1) + (j2 << 1);
        i3 = i << 2;
        j3 = i;
        int i4 = i << 1;
        int k4 = i;
        for(int i2 = 0; i2 < j; i2++)
        {
            float f7 = -hsqt2 * (af[k2] + af[l2]);
            float f13 = hsqt2 * (af[k2] - af[l2]);
            af1[j3 - 1] = f13 + af[k4 - 1];
            af1[(j3 + i4) - 1] = af[k4 - 1] - f13;
            af1[j3] = f7 - af[k2 + j2];
            af1[j3 + i4] = f7 + af[k2 + j2];
            k2 += i;
            l2 += i;
            j3 += i3;
            k4 += i;
        }

    }

    static void dradfg(int i, int j, int k, int l, float af[], float af1[], float af2[], float af3[], 
            float af4[], float af5[], int i1)
    {
        int l1;
        int k11;
        int k13;
        int j24;
        int k24;
        float f6;
        float f8;
        int l24;
        int i25;
        char c;
        k13 = 0;
        f6 = 0.0F;
        f8 = 0.0F;
        float f7 = tpi / (float)j;
        f6 = (float)Math.cos(f7);
        f8 = (float)Math.sin(f7);
        l1 = j + 1 >> 1;
        i25 = j;
        l24 = i;
        k24 = i - 1 >> 1;
        k11 = k * i;
        j24 = j * i;
        c = 'd';
_L8:
        c;
        JVM INSTR lookupswitch 5: default 2201
    //                   101: 120
    //                   119: 917
    //                   132: 1520
    //                   135: 1581
    //                   141: 1977;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        continue; /* Loop/switch isn't completed */
_L2:
        if(i == 1)
        {
            c = 'w';
            continue; /* Loop/switch isn't completed */
        }
        for(int i10 = 0; i10 < l; i10++)
            af4[i10] = af2[i10];

        int l11 = 0;
        for(int i4 = 1; i4 < j; i4++)
        {
            l11 += k11;
            k13 = l11;
            for(int l6 = 0; l6 < k; l6++)
            {
                af3[k13] = af1[k13];
                k13 += i;
            }

        }

        int j11 = -i;
        l11 = 0;
        if(k24 > k)
        {
            for(int j4 = 1; j4 < j; j4++)
            {
                l11 += k11;
                j11 += i;
                k13 = -i + l11;
                for(int i7 = 0; i7 < k; i7++)
                {
                    int j1 = j11 - 1;
                    k13 += i;
                    int l13 = k13;
                    for(int i2 = 2; i2 < i; i2 += 2)
                    {
                        j1 += 2;
                        l13 += 2;
                        af3[l13 - 1] = af5[(i1 + j1) - 1] * af1[l13 - 1] + af5[i1 + j1] * af1[l13];
                        af3[l13] = af5[(i1 + j1) - 1] * af1[l13] - af5[i1 + j1] * af1[l13 - 1];
                    }

                }

            }

        } else
        {
            for(int k4 = 1; k4 < j; k4++)
            {
                j11 += i;
                int k1 = j11 - 1;
                l11 += k11;
                k13 = l11;
                for(int j2 = 2; j2 < i; j2 += 2)
                {
                    k1 += 2;
                    int i14 = k13 += 2;
                    for(int j7 = 0; j7 < k; j7++)
                    {
                        af3[i14 - 1] = af5[(i1 + k1) - 1] * af1[i14 - 1] + af5[i1 + k1] * af1[i14];
                        af3[i14] = af5[(i1 + k1) - 1] * af1[i14] - af5[i1 + k1] * af1[i14 - 1];
                        i14 += i;
                    }

                }

            }

        }
        l11 = 0;
        k13 = i25 * k11;
        if(k24 < k)
        {
            for(int l4 = 1; l4 < l1; l4++)
            {
                l11 += k11;
                k13 -= k11;
                int j14 = l11;
                int j16 = k13;
                for(int k2 = 2; k2 < i; k2 += 2)
                {
                    j14 += 2;
                    j16 += 2;
                    int j18 = j14 - i;
                    int l19 = j16 - i;
                    for(int k7 = 0; k7 < k; k7++)
                    {
                        j18 += i;
                        l19 += i;
                        af1[j18 - 1] = af3[j18 - 1] + af3[l19 - 1];
                        af1[l19 - 1] = af3[j18] - af3[l19];
                        af1[j18] = af3[j18] + af3[l19];
                        af1[l19] = af3[l19 - 1] - af3[j18 - 1];
                    }

                }

            }

        } else
        {
            for(int i5 = 1; i5 < l1; i5++)
            {
                l11 += k11;
                k13 -= k11;
                int k14 = l11;
                int k16 = k13;
                for(int l7 = 0; l7 < k; l7++)
                {
                    int k18 = k14;
                    int i20 = k16;
                    for(int l2 = 2; l2 < i; l2 += 2)
                    {
                        k18 += 2;
                        i20 += 2;
                        af1[k18 - 1] = af3[k18 - 1] + af3[i20 - 1];
                        af1[i20 - 1] = af3[k18] - af3[i20];
                        af1[k18] = af3[k18] + af3[i20];
                        af1[i20] = af3[i20 - 1] - af3[k18 - 1];
                    }

                    k14 += i;
                    k16 += i;
                }

            }

        }
_L3:
        for(int j10 = 0; j10 < l; j10++)
            af2[j10] = af4[j10];

        int i12 = 0;
        k13 = i25 * l;
        for(int j5 = 1; j5 < l1; j5++)
        {
            i12 += k11;
            k13 -= k11;
            int l14 = i12 - i;
            int l16 = k13 - i;
            for(int i8 = 0; i8 < k; i8++)
            {
                l14 += i;
                l16 += i;
                af1[l14] = af3[l14] + af3[l16];
                af1[l16] = af3[l16] - af3[l14];
            }

        }

        float f3 = 1.0F;
        float f1 = 0.0F;
        i12 = 0;
        k13 = i25 * l;
        int i15 = (j - 1) * l;
        for(int k9 = 1; k9 < l1; k9++)
        {
            i12 += l;
            k13 -= l;
            float f9 = f6 * f3 - f8 * f1;
            f1 = f6 * f1 + f8 * f3;
            f3 = f9;
            int i17 = i12;
            int l18 = k13;
            int j20 = i15;
            int k21 = l;
            for(int k10 = 0; k10 < l; k10++)
            {
                af4[i17++] = af2[k10] + f3 * af2[k21++];
                af4[l18++] = f1 * af2[j20++];
            }

            float f = f3;
            float f5 = f1;
            float f4 = f3;
            float f2 = f1;
            i17 = l;
            l18 = (i25 - 1) * l;
            for(int k5 = 2; k5 < l1; k5++)
            {
                i17 += l;
                l18 -= l;
                float f10 = f * f4 - f5 * f2;
                f2 = f * f2 + f5 * f4;
                f4 = f10;
                int k20 = i12;
                int l21 = k13;
                int l22 = i17;
                int k23 = l18;
                for(int l10 = 0; l10 < l; l10++)
                {
                    af4[k20++] += f4 * af2[l22++];
                    af4[l21++] += f2 * af2[k23++];
                }

            }

        }

        i12 = 0;
        for(int l5 = 1; l5 < l1; l5++)
        {
            i12 += l;
            k13 = i12;
            for(int i11 = 0; i11 < l; i11++)
                af4[i11] += af2[k13++];

        }

        if(i < k)
        {
            c = '\204';
        } else
        {
            int j12 = 0;
            k13 = 0;
            for(int j8 = 0; j8 < k; j8++)
            {
                int j15 = j12;
                int j17 = k13;
                for(int i3 = 0; i3 < i; i3++)
                    af[j17++] = af3[j15++];

                j12 += i;
                k13 += j24;
            }

            c = '\207';
        }
        continue; /* Loop/switch isn't completed */
_L4:
        for(int j3 = 0; j3 < i; j3++)
        {
            int k12 = j3;
            k13 = j3;
            for(int k8 = 0; k8 < k; k8++)
            {
                af[k13] = af3[k12];
                k12 += i;
                k13 += j24;
            }

        }

_L5:
        int l12 = 0;
        k13 = i << 1;
        int k15 = 0;
        int k17 = i25 * k11;
        for(int i6 = 1; i6 < l1; i6++)
        {
            l12 += k13;
            k15 += k11;
            k17 -= k11;
            int i19 = l12;
            int l20 = k15;
            int i22 = k17;
            for(int l8 = 0; l8 < k; l8++)
            {
                af[i19 - 1] = af3[l20];
                af[i19] = af3[i22];
                i19 += j24;
                l20 += i;
                i22 += i;
            }

        }

        if(i == 1)
            return;
        if(k24 >= k)
            break; /* Loop/switch isn't completed */
        c = '\215';
        if(true) goto _L8; else goto _L7
_L7:
        int i13 = -i;
        int l15 = 0;
        int l17 = 0;
        int j19 = i25 * k11;
        for(int j6 = 1; j6 < l1; j6++)
        {
            i13 += k13;
            l15 += k13;
            l17 += k11;
            j19 -= k11;
            int i21 = i13;
            int j22 = l15;
            int i23 = l17;
            int l23 = j19;
            for(int i9 = 0; i9 < k; i9++)
            {
                for(int k3 = 2; k3 < i; k3 += 2)
                {
                    int l9 = l24 - k3;
                    af[(k3 + j22) - 1] = af3[(k3 + i23) - 1] + af3[(k3 + l23) - 1];
                    af[(l9 + i21) - 1] = af3[(k3 + i23) - 1] - af3[(k3 + l23) - 1];
                    af[k3 + j22] = af3[k3 + i23] + af3[k3 + l23];
                    af[l9 + i21] = af3[k3 + l23] - af3[k3 + i23];
                }

                i21 += j24;
                j22 += j24;
                i23 += i;
                l23 += i;
            }

        }

        return;
_L6:
        int j13 = -i;
        int i16 = 0;
        int i18 = 0;
        int k19 = i25 * k11;
        for(int k6 = 1; k6 < l1; k6++)
        {
            j13 += k13;
            i16 += k13;
            i18 += k11;
            k19 -= k11;
            for(int l3 = 2; l3 < i; l3 += 2)
            {
                int j21 = (l24 + j13) - l3;
                int k22 = l3 + i16;
                int j23 = l3 + i18;
                int i24 = l3 + k19;
                for(int j9 = 0; j9 < k; j9++)
                {
                    af[k22 - 1] = af3[j23 - 1] + af3[i24 - 1];
                    af[j21 - 1] = af3[j23 - 1] - af3[i24 - 1];
                    af[k22] = af3[j23] + af3[i24];
                    af[j21] = af3[i24] - af3[j23];
                    j21 += j24;
                    k22 += j24;
                    j23 += i;
                    i24 += i;
                }

            }

        }

        return;
    }

    static void drftf1(int i, float af[], float af1[], float af2[], int ai[])
    {
        int l1 = ai[1];
        int j1 = 1;
        int i1 = i;
        int j2 = i;
        int k = 0;
label0:
        do
        {
            if(k < l1)
            {
                int k1 = l1 - k;
                int i2 = ai[k1 + 1];
                int l = i1 / i2;
                int k2 = i / i1;
                int l2 = k2 * l;
                j2 -= (i2 - 1) * k2;
                j1 = 1 - j1;
                byte byte0 = 100;
                do
                    switch(byte0)
                    {
                    case 100: // 'd'
                        if(i2 != 4)
                        {
                            byte0 = 102;
                        } else
                        {
                            int i3 = j2 + k2;
                            int j3 = i3 + k2;
                            if(j1 != 0)
                                dradf4(k2, l, af1, af, af2, j2 - 1, af2, i3 - 1, af2, j3 - 1);
                            else
                                dradf4(k2, l, af, af1, af2, j2 - 1, af2, i3 - 1, af2, j3 - 1);
                            byte0 = 110;
                        }
                        break;

                    case 102: // 'f'
                        if(i2 != 2)
                            byte0 = 104;
                        else
                        if(j1 != 0)
                        {
                            byte0 = 103;
                        } else
                        {
                            dradf2(k2, l, af, af1, af2, j2 - 1);
                            byte0 = 110;
                        }
                        break;

                    case 103: // 'g'
                        dradf2(k2, l, af1, af, af2, j2 - 1);
                        // fall through

                    case 104: // 'h'
                        if(k2 == 1)
                            j1 = 1 - j1;
                        if(j1 != 0)
                        {
                            byte0 = 109;
                        } else
                        {
                            dradfg(k2, i2, l, l2, af, af, af, af1, af1, af2, j2 - 1);
                            j1 = 1;
                            byte0 = 110;
                        }
                        break;

                    case 109: // 'm'
                        dradfg(k2, i2, l, l2, af1, af1, af1, af, af, af2, j2 - 1);
                        j1 = 0;
                        // fall through

                    case 110: // 'n'
                        i1 = l;
                        k++;
                        continue label0;
                    }
                while(true);
            }
            if(j1 == 1)
                return;
            for(int j = 0; j < i; j++)
                af[j] = af1[j];

            break;
        } while(true);
    }

    static void dradb2(int i, int j, float af[], float af1[], float af2[], int k)
    {
        int l1 = j * i;
        int i2 = 0;
        int j2 = 0;
        int k2 = (i << 1) - 1;
        for(int i1 = 0; i1 < j; i1++)
        {
            af1[i2] = af[j2] + af[k2 + j2];
            af1[i2 + l1] = af[j2] - af[k2 + j2];
            j2 = (i2 += i) << 1;
        }

        if(i < 2)
            return;
        if(i != 2)
        {
            i2 = 0;
            j2 = 0;
            for(int j1 = 0; j1 < j; j1++)
            {
                int l2 = i2;
                int i3;
                int j3 = (i3 = j2) + (i << 1);
                int k3 = l1 + i2;
                for(int l = 2; l < i; l += 2)
                {
                    l2 += 2;
                    i3 += 2;
                    j3 -= 2;
                    k3 += 2;
                    af1[l2 - 1] = af[i3 - 1] + af[j3 - 1];
                    float f1 = af[i3 - 1] - af[j3 - 1];
                    af1[l2] = af[i3] - af[j3];
                    float f = af[i3] + af[j3];
                    af1[k3 - 1] = af2[(k + l) - 2] * f1 - af2[(k + l) - 1] * f;
                    af1[k3] = af2[(k + l) - 2] * f + af2[(k + l) - 1] * f1;
                }

                j2 = (i2 += i) << 1;
            }

            if(i % 2 == 1)
                return;
        }
        i2 = i - 1;
        j2 = i - 1;
        for(int k1 = 0; k1 < j; k1++)
        {
            af1[i2] = af[j2] + af[j2];
            af1[i2 + l1] = -(af[j2 + 1] + af[j2 + 1]);
            i2 += i;
            j2 += i << 1;
        }

    }

    static void dradb3(int i, int j, float af[], float af1[], float af2[], int k, float af3[], int l)
    {
        int l1 = j * i;
        int i2 = 0;
        int j2 = l1 << 1;
        int k2 = i << 1;
        int l2 = i + (i << 1);
        int i3 = 0;
        for(int j1 = 0; j1 < j; j1++)
        {
            float f11 = af[k2 - 1] + af[k2 - 1];
            float f5 = af[i3] + taur * f11;
            af1[i2] = af[i3] + f11;
            float f1 = taui * (af[k2] + af[k2]);
            af1[i2 + l1] = f5 - f1;
            af1[i2 + j2] = f5 + f1;
            i2 += i;
            k2 += l2;
            i3 += l2;
        }

        if(i == 1)
            return;
        i2 = 0;
        k2 = i << 1;
        for(int k1 = 0; k1 < j; k1++)
        {
            int l3 = i2 + (i2 << 1);
            int j3;
            int k3 = j3 = l3 + k2;
            int i4 = i2;
            int j4;
            int k4 = (j4 = i2 + l1) + l1;
            for(int i1 = 2; i1 < i; i1 += 2)
            {
                j3 += 2;
                k3 -= 2;
                l3 += 2;
                i4 += 2;
                j4 += 2;
                k4 += 2;
                float f12 = af[j3 - 1] + af[k3 - 1];
                float f6 = af[l3 - 1] + taur * f12;
                af1[i4 - 1] = af[l3 - 1] + f12;
                float f10 = af[j3] - af[k3];
                float f = af[l3] + taur * f10;
                af1[i4] = af[l3] + f10;
                float f7 = taui * (af[j3 - 1] - af[k3 - 1]);
                float f2 = taui * (af[j3] + af[k3]);
                float f8 = f6 - f2;
                float f9 = f6 + f2;
                float f3 = f + f7;
                float f4 = f - f7;
                af1[j4 - 1] = af2[(k + i1) - 2] * f8 - af2[(k + i1) - 1] * f3;
                af1[j4] = af2[(k + i1) - 2] * f3 + af2[(k + i1) - 1] * f8;
                af1[k4 - 1] = af3[(l + i1) - 2] * f9 - af3[(l + i1) - 1] * f4;
                af1[k4] = af3[(l + i1) - 2] * f4 + af3[(l + i1) - 1] * f9;
            }

            i2 += i;
        }

    }

    static void dradb4(int i, int j, float af[], float af1[], float af2[], int k, float af3[], int l, 
            float af4[], int i1)
    {
        int j2 = j * i;
        int k2 = 0;
        int l2 = i << 2;
        int i3 = 0;
        int l4 = i << 1;
        for(int k1 = 0; k1 < j; k1++)
        {
            int j3 = i3 + l4;
            int i4 = k2;
            float f18 = af[j3 - 1] + af[j3 - 1];
            float f20 = af[j3] + af[j3];
            float f12 = af[i3] - af[(j3 += l4) - 1];
            float f15 = af[i3] + af[j3 - 1];
            af1[i4] = f15 + f18;
            af1[i4 += j2] = f12 - f20;
            af1[i4 += j2] = f15 - f18;
            af1[i4 += j2] = f12 + f20;
            k2 += i;
            i3 += l2;
        }

        if(i < 2)
            return;
        if(i != 2)
        {
            k2 = 0;
            for(int l1 = 0; l1 < j; l1++)
            {
                int k3;
                int j4 = (k3 = i3 = (l2 = k2 << 2) + l4) + l4;
                int i5 = k2;
                for(int j1 = 2; j1 < i; j1 += 2)
                {
                    l2 += 2;
                    i3 += 2;
                    k3 -= 2;
                    j4 -= 2;
                    i5 += 2;
                    float f6 = af[l2] + af[j4];
                    float f8 = af[l2] - af[j4];
                    float f10 = af[i3] - af[k3];
                    float f21 = af[i3] + af[k3];
                    float f13 = af[l2 - 1] - af[j4 - 1];
                    float f16 = af[l2 - 1] + af[j4 - 1];
                    float f11 = af[i3 - 1] - af[k3 - 1];
                    float f19 = af[i3 - 1] + af[k3 - 1];
                    af1[i5 - 1] = f16 + f19;
                    float f4 = f16 - f19;
                    af1[i5] = f8 + f10;
                    float f1 = f8 - f10;
                    float f3 = f13 - f21;
                    float f5 = f13 + f21;
                    float f = f6 + f11;
                    float f2 = f6 - f11;
                    int j5;
                    af1[(j5 = i5 + j2) - 1] = af2[(k + j1) - 2] * f3 - af2[(k + j1) - 1] * f;
                    af1[j5] = af2[(k + j1) - 2] * f + af2[(k + j1) - 1] * f3;
                    af1[(j5 += j2) - 1] = af3[(l + j1) - 2] * f4 - af3[(l + j1) - 1] * f1;
                    af1[j5] = af3[(l + j1) - 2] * f1 + af3[(l + j1) - 1] * f4;
                    af1[(j5 += j2) - 1] = af4[(i1 + j1) - 2] * f5 - af4[(i1 + j1) - 1] * f2;
                    af1[j5] = af4[(i1 + j1) - 2] * f2 + af4[(i1 + j1) - 1] * f5;
                }

                k2 += i;
            }

            if(i % 2 == 1)
                return;
        }
        k2 = i;
        l2 = i << 2;
        i3 = i - 1;
        int l3 = i + (i << 1);
        for(int i2 = 0; i2 < j; i2++)
        {
            int k4 = i3;
            float f7 = af[k2] + af[l3];
            float f9 = af[l3] - af[k2];
            float f14 = af[k2 - 1] - af[l3 - 1];
            float f17 = af[k2 - 1] + af[l3 - 1];
            af1[k4] = f17 + f17;
            af1[k4 += j2] = sqrt2 * (f14 - f7);
            af1[k4 += j2] = f9 + f9;
            af1[k4 += j2] = -sqrt2 * (f14 + f7);
            i3 += i;
            k2 += l2;
            l3 += l2;
        }

    }

    static void dradbg(int i, int j, int k, int l, float af[], float af1[], float af2[], float af3[], 
            float af4[], float af5[], int i1)
    {
        int l1;
        int j11;
        int l27;
        int j29;
        float f6;
        float f8;
        int k29;
        char c;
        l1 = 0;
        j11 = 0;
        l27 = 0;
        j29 = 0;
        f6 = 0.0F;
        f8 = 0.0F;
        k29 = 0;
        c = 'd';
_L11:
        c;
        JVM INSTR lookupswitch 8: default 2250
    //                   100: 100
    //                   103: 245
    //                   106: 312
    //                   112: 697
    //                   116: 924
    //                   128: 1627
    //                   132: 1807
    //                   139: 2081;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        continue; /* Loop/switch isn't completed */
_L2:
        l27 = j * i;
        j11 = k * i;
        float f7 = tpi / (float)j;
        f6 = (float)Math.cos(f7);
        f8 = (float)Math.sin(f7);
        j29 = i - 1 >>> 1;
        k29 = j;
        l1 = j + 1 >>> 1;
        if(i < k)
        {
            c = 'g';
        } else
        {
            int k11 = 0;
            int j14 = 0;
            for(int l6 = 0; l6 < k; l6++)
            {
                int i17 = k11;
                int l19 = j14;
                for(int i2 = 0; i2 < i; i2++)
                {
                    af3[i17] = af[l19];
                    i17++;
                    l19++;
                }

                k11 += i;
                j14 += l27;
            }

            c = 'j';
        }
        continue; /* Loop/switch isn't completed */
_L3:
        int l11 = 0;
        for(int j2 = 0; j2 < i; j2++)
        {
            int k14 = l11;
            int j17 = l11;
            for(int i7 = 0; i7 < k; i7++)
            {
                af3[k14] = af[j17];
                k14 += i;
                j17 += l27;
            }

            l11++;
        }

_L4:
        int i12 = 0;
        int l14 = k29 * j11;
        int i22;
        int j25 = i22 = i << 1;
        for(int i4 = 1; i4 < l1; i4++)
        {
            i12 += j11;
            l14 -= j11;
            int k17 = i12;
            int i20 = l14;
            int l23 = i22;
            for(int j7 = 0; j7 < k; j7++)
            {
                af3[k17] = af[l23 - 1] + af[l23 - 1];
                af3[i20] = af[l23] + af[l23];
                k17 += i;
                i20 += i;
                l23 += l27;
            }

            i22 += j25;
        }

        if(i == 1)
            c = 't';
        else
        if(j29 < k)
        {
            c = 'p';
        } else
        {
            int j12 = 0;
            int i15 = k29 * j11;
            int k25 = 0;
            for(int j4 = 1; j4 < l1; j4++)
            {
                j12 += j11;
                i15 -= j11;
                int l17 = j12;
                int j20 = i15;
                k25 += i << 1;
                int j26 = k25;
                for(int k7 = 0; k7 < k; k7++)
                {
                    int j22 = l17;
                    int i24 = j20;
                    int i27 = j26;
                    int i28 = j26;
                    for(int k2 = 2; k2 < i; k2 += 2)
                    {
                        j22 += 2;
                        i24 += 2;
                        i27 += 2;
                        i28 -= 2;
                        af3[j22 - 1] = af[i27 - 1] + af[i28 - 1];
                        af3[i24 - 1] = af[i27 - 1] - af[i28 - 1];
                        af3[j22] = af[i27] - af[i28];
                        af3[i24] = af[i27] + af[i28];
                    }

                    l17 += i;
                    j20 += i;
                    j26 += l27;
                }

            }

            c = 't';
        }
        continue; /* Loop/switch isn't completed */
_L5:
        int k12 = 0;
        int j15 = k29 * j11;
        int l25 = 0;
        for(int k4 = 1; k4 < l1; k4++)
        {
            k12 += j11;
            j15 -= j11;
            int i18 = k12;
            int k20 = j15;
            l25 += i << 1;
            int k26 = l25;
            int j27 = l25;
            for(int l2 = 2; l2 < i; l2 += 2)
            {
                i18 += 2;
                k20 += 2;
                k26 += 2;
                j27 -= 2;
                int k22 = i18;
                int j24 = k20;
                int j28 = k26;
                int l28 = j27;
                for(int l7 = 0; l7 < k; l7++)
                {
                    af3[k22 - 1] = af[j28 - 1] + af[l28 - 1];
                    af3[j24 - 1] = af[j28 - 1] - af[l28 - 1];
                    af3[k22] = af[j28] - af[l28];
                    af3[j24] = af[j28] + af[l28];
                    k22 += i;
                    j24 += i;
                    j28 += l27;
                    l28 += l27;
                }

            }

        }

_L6:
        float f3 = 1.0F;
        float f1 = 0.0F;
        int l12 = 0;
        int k15;
        int k27 = k15 = k29 * l;
        int j18 = (j - 1) * l;
        for(int k9 = 1; k9 < l1; k9++)
        {
            l12 += l;
            k15 -= l;
            float f9 = f6 * f3 - f8 * f1;
            f1 = f6 * f1 + f8 * f3;
            f3 = f9;
            int l20 = l12;
            int l22 = k15;
            int k24 = 0;
            int i26 = l;
            int l26 = j18;
            for(int l9 = 0; l9 < l; l9++)
            {
                af2[l20++] = af4[k24++] + f3 * af4[i26++];
                af2[l22++] = f1 * af4[l26++];
            }

            float f = f3;
            float f5 = f1;
            float f4 = f3;
            float f2 = f1;
            k24 = l;
            i26 = k27 - l;
            for(int l4 = 2; l4 < l1; l4++)
            {
                k24 += l;
                i26 -= l;
                float f10 = f * f4 - f5 * f2;
                f2 = f * f2 + f5 * f4;
                f4 = f10;
                int i21 = l12;
                int i23 = k15;
                int k28 = k24;
                int i29 = i26;
                for(int i10 = 0; i10 < l; i10++)
                {
                    af2[i21++] += f4 * af4[k28++];
                    af2[i23++] += f2 * af4[i29++];
                }

            }

        }

        l12 = 0;
        for(int i5 = 1; i5 < l1; i5++)
        {
            l12 += l;
            k15 = l12;
            for(int j10 = 0; j10 < l; j10++)
                af4[j10] += af4[k15++];

        }

        l12 = 0;
        k15 = k29 * j11;
        for(int j5 = 1; j5 < l1; j5++)
        {
            l12 += j11;
            k15 -= j11;
            int k18 = l12;
            int j21 = k15;
            for(int i8 = 0; i8 < k; i8++)
            {
                af3[k18] = af1[k18] - af1[j21];
                af3[j21] = af1[k18] + af1[j21];
                k18 += i;
                j21 += i;
            }

        }

        if(i == 1)
            c = '\204';
        else
        if(j29 < k)
        {
            c = '\200';
        } else
        {
            int i13 = 0;
            int l15 = k29 * j11;
            for(int k5 = 1; k5 < l1; k5++)
            {
                i13 += j11;
                l15 -= j11;
                int l18 = i13;
                int k21 = l15;
                for(int j8 = 0; j8 < k; j8++)
                {
                    int j23 = l18;
                    int l24 = k21;
                    for(int i3 = 2; i3 < i; i3 += 2)
                    {
                        j23 += 2;
                        l24 += 2;
                        af3[j23 - 1] = af1[j23 - 1] - af1[l24];
                        af3[l24 - 1] = af1[j23 - 1] + af1[l24];
                        af3[j23] = af1[j23] + af1[l24 - 1];
                        af3[l24] = af1[j23] - af1[l24 - 1];
                    }

                    l18 += i;
                    k21 += i;
                }

            }

            c = '\204';
        }
        continue; /* Loop/switch isn't completed */
_L7:
        int j13 = 0;
        int i16 = k29 * j11;
        for(int l5 = 1; l5 < l1; l5++)
        {
            j13 += j11;
            i16 -= j11;
            int i19 = j13;
            int l21 = i16;
            for(int j3 = 2; j3 < i; j3 += 2)
            {
                i19 += 2;
                l21 += 2;
                int k23 = i19;
                int i25 = l21;
                for(int k8 = 0; k8 < k; k8++)
                {
                    af3[k23 - 1] = af1[k23 - 1] - af1[i25];
                    af3[i25 - 1] = af1[k23 - 1] + af1[i25];
                    af3[k23] = af1[k23] + af1[i25 - 1];
                    af3[i25] = af1[k23] - af1[i25 - 1];
                    k23 += i;
                    i25 += i;
                }

            }

        }

_L8:
        if(i == 1)
            return;
        for(int k10 = 0; k10 < l; k10++)
            af2[k10] = af4[k10];

        int k13 = 0;
        for(int i6 = 1; i6 < j; i6++)
        {
            int j16 = k13 += j11;
            for(int l8 = 0; l8 < k; l8++)
            {
                af1[j16] = af3[j16];
                j16 += i;
            }

        }

        if(j29 <= k)
            break; /* Loop/switch isn't completed */
        c = '\213';
        if(true) goto _L11; else goto _L10
_L10:
        int l10 = -i - 1;
        int l13 = 0;
        for(int j6 = 1; j6 < j; j6++)
        {
            l10 += i;
            l13 += j11;
            int j1 = l10;
            int k16 = l13;
            for(int k3 = 2; k3 < i; k3 += 2)
            {
                k16 += 2;
                j1 += 2;
                int j19 = k16;
                for(int i9 = 0; i9 < k; i9++)
                {
                    af1[j19 - 1] = af5[(i1 + j1) - 1] * af3[j19 - 1] - af5[i1 + j1] * af3[j19];
                    af1[j19] = af5[(i1 + j1) - 1] * af3[j19] + af5[i1 + j1] * af3[j19 - 1];
                    j19 += i;
                }

            }

        }

        return;
_L9:
        int i11 = -i - 1;
        int i14 = 0;
        for(int k6 = 1; k6 < j; k6++)
        {
            i11 += i;
            i14 += j11;
            int l16 = i14;
            for(int j9 = 0; j9 < k; j9++)
            {
                int k1 = i11;
                int k19 = l16;
                for(int l3 = 2; l3 < i; l3 += 2)
                {
                    k1 += 2;
                    k19 += 2;
                    af1[k19 - 1] = af5[(i1 + k1) - 1] * af3[k19 - 1] - af5[i1 + k1] * af3[k19];
                    af1[k19] = af5[(i1 + k1) - 1] * af3[k19] + af5[i1 + k1] * af3[k19 - 1];
                }

                l16 += i;
            }

        }

        return;
    }

    static void drftb1(int i, float af[], float af1[], float af2[], int j, int ai[])
    {
        int j1 = 0;
        int i2 = 0;
        int j3 = 0;
        int k3 = 0;
        int l1 = ai[1];
        int k1 = 0;
        int i1 = 1;
        int j2 = 1;
        int l = 0;
label0:
        do
        {
            if(l < l1)
            {
                byte byte0 = 100;
                do
                    switch(byte0)
                    {
                    case 100: // 'd'
                        i2 = ai[l + 2];
                        j1 = i2 * i1;
                        j3 = i / j1;
                        k3 = j3 * i1;
                        if(i2 != 4)
                        {
                            byte0 = 103;
                        } else
                        {
                            int k2 = j2 + j3;
                            int i3 = k2 + j3;
                            if(k1 != 0)
                                dradb4(j3, i1, af1, af, af2, (j + j2) - 1, af2, (j + k2) - 1, af2, (j + i3) - 1);
                            else
                                dradb4(j3, i1, af, af1, af2, (j + j2) - 1, af2, (j + k2) - 1, af2, (j + i3) - 1);
                            k1 = 1 - k1;
                            byte0 = 115;
                        }
                        break;

                    case 103: // 'g'
                        if(i2 != 2)
                        {
                            byte0 = 106;
                        } else
                        {
                            if(k1 != 0)
                                dradb2(j3, i1, af1, af, af2, (j + j2) - 1);
                            else
                                dradb2(j3, i1, af, af1, af2, (j + j2) - 1);
                            k1 = 1 - k1;
                            byte0 = 115;
                        }
                        break;

                    case 106: // 'j'
                        if(i2 != 3)
                        {
                            byte0 = 109;
                        } else
                        {
                            int l2 = j2 + j3;
                            if(k1 != 0)
                                dradb3(j3, i1, af1, af, af2, (j + j2) - 1, af2, (j + l2) - 1);
                            else
                                dradb3(j3, i1, af, af1, af2, (j + j2) - 1, af2, (j + l2) - 1);
                            k1 = 1 - k1;
                            byte0 = 115;
                        }
                        break;

                    case 109: // 'm'
                        if(k1 != 0)
                            dradbg(j3, i2, i1, k3, af1, af1, af1, af, af, af2, (j + j2) - 1);
                        else
                            dradbg(j3, i2, i1, k3, af, af, af, af1, af1, af2, (j + j2) - 1);
                        if(j3 == 1)
                            k1 = 1 - k1;
                        // fall through

                    case 115: // 's'
                        i1 = j1;
                        j2 += (i2 - 1) * j3;
                        l++;
                        continue label0;
                    }
                while(true);
            }
            if(k1 == 0)
                return;
            for(int k = 0; k < i; k++)
                af[k] = af1[k];

            break;
        } while(true);
    }

    int n;
    float trigcache[];
    int splitcache[];
    static int ntryh[] = {
        4, 2, 3, 5
    };
    static float tpi = 6.283185F;
    static float hsqt2 = 0.7071068F;
    static float taui = 0.8660254F;
    static float taur = -0.5F;
    static float sqrt2 = 1.414214F;

}
