// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;


// Referenced classes of package com.jcraft.jorbis:
//            Lookup

class Lsp
{

    Lsp()
    {
    }

    static void lsp_to_curve(float af[], int ai[], int i, int j, float af1[], int k, float f, float f1)
    {
        float f2 = 3.141593F / (float)j;
        for(int l = 0; l < k; l++)
            af1[l] = Lookup.coslook(af1[l]);

        int j1 = (k / 2) * 2;
        for(int i1 = 0; i1 < i;)
        {
            int k1 = ai[i1];
            float f3 = 0.7071068F;
            float f4 = 0.7071068F;
            float f5 = Lookup.coslook(f2 * (float)k1);
            for(int l1 = 0; l1 < j1; l1 += 2)
            {
                f4 *= af1[l1] - f5;
                f3 *= af1[l1 + 1] - f5;
            }

            if((k & 1) != 0)
            {
                f4 *= af1[k - 1] - f5;
                f4 *= f4;
                f3 *= f3 * (1.0F - f5 * f5);
            } else
            {
                f4 *= f4 * (1.0F + f5);
                f3 *= f3 * (1.0F - f5);
            }
            f4 = f3 + f4;
            int i2 = Float.floatToIntBits(f4);
            int j2 = 0x7fffffff & i2;
            int k2 = 0;
            if(j2 < 0x7f800000 && j2 != 0)
            {
                if(j2 < 0x800000)
                {
                    f4 = (float)((double)f4 * 33554432D);
                    i2 = Float.floatToIntBits(f4);
                    j2 = 0x7fffffff & i2;
                    k2 = -25;
                }
                k2 += (j2 >>> 23) - 126;
                i2 = i2 & 0x807fffff | 0x3f000000;
                f4 = Float.intBitsToFloat(i2);
            }
            f4 = Lookup.fromdBlook(f * Lookup.invsqlook(f4) * Lookup.invsq2explook(k2 + k) - f1);
            do
                af[i1++] *= f4;
            while(i1 < i && ai[i1] == k1);
        }

    }

    static final float M_PI = 3.141593F;
}
