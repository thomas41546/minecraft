// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;


class PsyInfo
{

    PsyInfo()
    {
        toneatt_125Hz = new float[5];
        toneatt_250Hz = new float[5];
        toneatt_500Hz = new float[5];
        toneatt_1000Hz = new float[5];
        toneatt_2000Hz = new float[5];
        toneatt_4000Hz = new float[5];
        toneatt_8000Hz = new float[5];
        peakatt_125Hz = new float[5];
        peakatt_250Hz = new float[5];
        peakatt_500Hz = new float[5];
        peakatt_1000Hz = new float[5];
        peakatt_2000Hz = new float[5];
        peakatt_4000Hz = new float[5];
        peakatt_8000Hz = new float[5];
        noiseatt_125Hz = new float[5];
        noiseatt_250Hz = new float[5];
        noiseatt_500Hz = new float[5];
        noiseatt_1000Hz = new float[5];
        noiseatt_2000Hz = new float[5];
        noiseatt_4000Hz = new float[5];
        noiseatt_8000Hz = new float[5];
    }

    void free()
    {
    }

    int athp;
    int decayp;
    int smoothp;
    int noisefitp;
    int noisefit_subblock;
    float noisefit_threshdB;
    float ath_att;
    int tonemaskp;
    float toneatt_125Hz[];
    float toneatt_250Hz[];
    float toneatt_500Hz[];
    float toneatt_1000Hz[];
    float toneatt_2000Hz[];
    float toneatt_4000Hz[];
    float toneatt_8000Hz[];
    int peakattp;
    float peakatt_125Hz[];
    float peakatt_250Hz[];
    float peakatt_500Hz[];
    float peakatt_1000Hz[];
    float peakatt_2000Hz[];
    float peakatt_4000Hz[];
    float peakatt_8000Hz[];
    int noisemaskp;
    float noiseatt_125Hz[];
    float noiseatt_250Hz[];
    float noiseatt_500Hz[];
    float noiseatt_1000Hz[];
    float noiseatt_2000Hz[];
    float noiseatt_4000Hz[];
    float noiseatt_8000Hz[];
    float max_curve_dB;
    float attack_coeff;
    float decay_coeff;
}
