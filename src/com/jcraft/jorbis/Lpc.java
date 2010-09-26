// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;


// Referenced classes of package com.jcraft.jorbis:
//            Drft

class Lpc
{

    Lpc()
    {
        fft = new Drft();
    }

    static float lpc_from_data(float af[], float af1[], int i, int j)
    {
        float af2[] = new float[j + 1];
        for(int i1 = j + 1; i1-- != 0;)
        {
            float f1 = 0.0F;
            for(int k = i1; k < i; k++)
                f1 += af[k] * af[k - i1];

            af2[i1] = f1;
        }

        float f = af2[0];
        for(int l = 0; l < j; l++)
        {
            float f2 = -af2[l + 1];
            if(f == 0.0F)
            {
                for(int l1 = 0; l1 < j; l1++)
                    af1[l1] = 0.0F;

                return 0.0F;
            }
            for(int j1 = 0; j1 < l; j1++)
                f2 -= af1[j1] * af2[l - j1];

            f2 /= f;
            af1[l] = f2;
            int k1;
            for(k1 = 0; k1 < l / 2; k1++)
            {
                float f3 = af1[k1];
                af1[k1] += f2 * af1[l - 1 - k1];
                af1[l - 1 - k1] += f2 * f3;
            }

            if(l % 2 != 0)
                af1[k1] += af1[k1] * f2;
            f = (float)((double)f * (1.0D - (double)(f2 * f2)));
        }

        return f;
    }

    float lpc_from_curve(float af[], float af1[])
    {
        int i = ln;
        float af2[] = new float[i + i];
        float f = (float)(0.5D / (double)i);
        for(int j = 0; j < i; j++)
        {
            af2[j * 2] = af[j] * f;
            af2[j * 2 + 1] = 0.0F;
        }

        af2[i * 2 - 1] = af[i - 1] * f;
        i *= 2;
        fft.backward(af2);
        int k = 0;
        int l = i / 2;
        while(k < i / 2) 
        {
            float f1 = af2[k];
            af2[k++] = af2[l];
            af2[l++] = f1;
        }
        return lpc_from_data(af2, af1, i, m);
    }

    void init(int i, int j)
    {
        ln = i;
        m = j;
        fft.init(i * 2);
    }

    void clear()
    {
        fft.clear();
    }

    static float FAST_HYPOT(float f, float f1)
    {
        return (float)Math.sqrt(f * f + f1 * f1);
    }

    void lpc_to_curve(float af[], float af1[], float f)
    {
        for(int i = 0; i < ln * 2; i++)
            af[i] = 0.0F;

        if(f == 0.0F)
            return;
        for(int j = 0; j < m; j++)
        {
            af[j * 2 + 1] = af1[j] / (4F * f);
            af[j * 2 + 2] = -af1[j] / (4F * f);
        }

        fft.backward(af);
        int k = ln * 2;
        float f1 = (float)(1.0D / (double)f);
        af[0] = (float)(1.0D / (double)(af[0] * 2.0F + f1));
        for(int l = 1; l < ln; l++)
        {
            float f2 = af[l] + af[k - l];
            float f3 = af[l] - af[k - l];
            float f4 = f2 + f1;
            af[l] = (float)(1.0D / (double)FAST_HYPOT(f4, f3));
        }

    }

    Drft fft;
    int ln;
    int m;
}
