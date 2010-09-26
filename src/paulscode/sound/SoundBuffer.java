// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import javax.sound.sampled.AudioFormat;

public class SoundBuffer
{

    public SoundBuffer(byte abyte0[], AudioFormat audioformat)
    {
        audioData = abyte0;
        audioFormat = audioformat;
    }

    public void cleanup()
    {
        audioData = null;
        audioFormat = null;
    }

    public void trimData(int i)
    {
        if(audioData == null || i == 0)
            audioData = null;
        else
        if(audioData.length > i)
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(((Object) (audioData)), 0, ((Object) (abyte0)), 0, i);
            audioData = abyte0;
        }
    }

    public byte audioData[];
    public AudioFormat audioFormat;
}
