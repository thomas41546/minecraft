// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import java.util.LinkedList;
import javax.sound.sampled.AudioFormat;

// Referenced classes of package paulscode.sound:
//            Library, SoundSystemConfig, SoundSystemLogger, Source

public class Channel
{

    public Channel(int i)
    {
        libraryType = paulscode/sound/Library;
        attachedSource = null;
        logger = SoundSystemConfig.getLogger();
        channelType = i;
    }

    public void cleanup()
    {
        logger = null;
    }

    public boolean preLoadBuffers(LinkedList linkedlist)
    {
        return true;
    }

    public boolean queueBuffer(byte abyte0[])
    {
        return false;
    }

    public int feedRawAudioData(byte abyte0[])
    {
        return 1;
    }

    public int buffersProcessed()
    {
        return 0;
    }

    public boolean processBuffer()
    {
        return false;
    }

    public void setAudioFormat(AudioFormat audioformat)
    {
    }

    public void flush()
    {
    }

    public void close()
    {
    }

    public void play()
    {
    }

    public void pause()
    {
    }

    public void stop()
    {
    }

    public void rewind()
    {
    }

    public boolean playing()
    {
        return false;
    }

    public String getClassName()
    {
        String s = SoundSystemConfig.getLibraryTitle(libraryType);
        if(s.equals("No Sound"))
            return "Channel";
        else
            return (new StringBuilder()).append("Channel").append(s).toString();
    }

    protected void message(String s)
    {
        logger.message(s, 0);
    }

    protected void importantMessage(String s)
    {
        logger.importantMessage(s, 0);
    }

    protected boolean errorCheck(boolean flag, String s)
    {
        return logger.errorCheck(flag, getClassName(), s, 0);
    }

    protected void errorMessage(String s)
    {
        logger.errorMessage(getClassName(), s, 0);
    }

    protected void printStackTrace(Exception exception)
    {
        logger.printStackTrace(exception, 1);
    }

    protected Class libraryType;
    public int channelType;
    private SoundSystemLogger logger;
    public Source attachedSource;
}
