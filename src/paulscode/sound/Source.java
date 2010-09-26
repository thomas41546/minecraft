// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import java.util.LinkedList;
import java.util.ListIterator;
import javax.sound.sampled.AudioFormat;

// Referenced classes of package paulscode.sound:
//            Channel, FilenameURL, ICodec, Library, 
//            SoundBuffer, SoundSystemConfig, SoundSystemLogger, Vector3D

public class Source
{

    public Source(boolean flag, boolean flag1, boolean flag2, String s, FilenameURL filenameurl, SoundBuffer soundbuffer, float f, 
            float f1, float f2, int i, float f3, boolean flag3)
    {
        libraryType = paulscode/sound/Library;
        rawDataStream = false;
        rawDataFormat = null;
        temporary = false;
        priority = false;
        toStream = false;
        toLoop = false;
        toPlay = false;
        sourcename = "";
        filenameURL = null;
        attModel = 0;
        distOrRoll = 0.0F;
        gain = 1.0F;
        sourceVolume = 1.0F;
        pitch = 1.0F;
        distanceFromListener = 0.0F;
        channel = null;
        active = true;
        stopped = true;
        paused = false;
        soundBuffer = null;
        codec = null;
        reverseByteOrder = false;
        soundSequenceQueue = null;
        soundSequenceLock = new Object();
        preLoad = false;
        fadeOutGain = -1F;
        fadeInGain = 1.0F;
        fadeOutMilis = 0L;
        fadeInMilis = 0L;
        lastFadeCheck = 0L;
        logger = SoundSystemConfig.getLogger();
        priority = flag;
        toStream = flag1;
        toLoop = flag2;
        sourcename = s;
        filenameURL = filenameurl;
        soundBuffer = soundbuffer;
        position = new Vector3D(f, f1, f2);
        attModel = i;
        distOrRoll = f3;
        temporary = flag3;
        if(flag1 && filenameurl != null)
            codec = SoundSystemConfig.getCodec(filenameurl.getFilename());
    }

    public Source(Source source, SoundBuffer soundbuffer)
    {
        libraryType = paulscode/sound/Library;
        rawDataStream = false;
        rawDataFormat = null;
        temporary = false;
        priority = false;
        toStream = false;
        toLoop = false;
        toPlay = false;
        sourcename = "";
        filenameURL = null;
        attModel = 0;
        distOrRoll = 0.0F;
        gain = 1.0F;
        sourceVolume = 1.0F;
        pitch = 1.0F;
        distanceFromListener = 0.0F;
        channel = null;
        active = true;
        stopped = true;
        paused = false;
        soundBuffer = null;
        codec = null;
        reverseByteOrder = false;
        soundSequenceQueue = null;
        soundSequenceLock = new Object();
        preLoad = false;
        fadeOutGain = -1F;
        fadeInGain = 1.0F;
        fadeOutMilis = 0L;
        fadeInMilis = 0L;
        lastFadeCheck = 0L;
        logger = SoundSystemConfig.getLogger();
        priority = source.priority;
        toStream = source.toStream;
        toLoop = source.toLoop;
        sourcename = source.sourcename;
        filenameURL = source.filenameURL;
        position = source.position.clone();
        attModel = source.attModel;
        distOrRoll = source.distOrRoll;
        temporary = source.temporary;
        sourceVolume = source.sourceVolume;
        rawDataStream = source.rawDataStream;
        rawDataFormat = source.rawDataFormat;
        soundBuffer = soundbuffer;
        if(toStream && filenameURL != null)
            codec = SoundSystemConfig.getCodec(filenameURL.getFilename());
    }

    public Source(AudioFormat audioformat, boolean flag, String s, float f, float f1, float f2, int i, 
            float f3)
    {
        libraryType = paulscode/sound/Library;
        rawDataStream = false;
        rawDataFormat = null;
        temporary = false;
        priority = false;
        toStream = false;
        toLoop = false;
        toPlay = false;
        sourcename = "";
        filenameURL = null;
        attModel = 0;
        distOrRoll = 0.0F;
        gain = 1.0F;
        sourceVolume = 1.0F;
        pitch = 1.0F;
        distanceFromListener = 0.0F;
        channel = null;
        active = true;
        stopped = true;
        paused = false;
        soundBuffer = null;
        codec = null;
        reverseByteOrder = false;
        soundSequenceQueue = null;
        soundSequenceLock = new Object();
        preLoad = false;
        fadeOutGain = -1F;
        fadeInGain = 1.0F;
        fadeOutMilis = 0L;
        fadeInMilis = 0L;
        lastFadeCheck = 0L;
        logger = SoundSystemConfig.getLogger();
        priority = flag;
        toStream = true;
        toLoop = false;
        sourcename = s;
        filenameURL = null;
        soundBuffer = null;
        position = new Vector3D(f, f1, f2);
        attModel = i;
        distOrRoll = f3;
        temporary = false;
        rawDataStream = true;
        rawDataFormat = audioformat;
    }

    public void cleanup()
    {
        if(codec != null)
            codec.cleanup();
        synchronized(soundSequenceLock)
        {
            if(soundSequenceQueue != null)
                soundSequenceQueue.clear();
            soundSequenceQueue = null;
        }
        sourcename = null;
        filenameURL = null;
        position = null;
        soundBuffer = null;
        codec = null;
    }

    public void queueSound(FilenameURL filenameurl)
    {
        if(!toStream)
        {
            errorMessage("Method 'queueSound' may only be used for streaming and MIDI sources.");
            return;
        }
        if(filenameurl == null)
        {
            errorMessage("File not specified in method 'queueSound'");
            return;
        }
        synchronized(soundSequenceLock)
        {
            if(soundSequenceQueue == null)
                soundSequenceQueue = new LinkedList();
            soundSequenceQueue.add(((Object) (filenameurl)));
        }
    }

    public void dequeueSound(String s)
    {
        if(!toStream)
        {
            errorMessage("Method 'dequeueSound' may only be used for streaming and MIDI sources.");
            return;
        }
        if(s == null || s.equals(""))
        {
            errorMessage("Filename not specified in method 'dequeueSound'");
            return;
        }
        synchronized(soundSequenceLock)
        {
            if(soundSequenceQueue != null)
                soundSequenceQueue.remove(((Object) (s)));
        }
        synchronized(soundSequenceLock)
        {
label0:
            {
                if(soundSequenceQueue == null)
                    break label0;
                ListIterator listiterator = soundSequenceQueue.listIterator();
                do
                    if(!listiterator.hasNext())
                        break label0;
                while(!((FilenameURL)listiterator.next()).getFilename().equals(((Object) (s))));
                listiterator.remove();
            }
        }
        break MISSING_BLOCK_LABEL_138;
        exception1;
        throw exception1;
    }

    public void fadeOut(FilenameURL filenameurl, long l)
    {
        if(!toStream)
        {
            errorMessage("Method 'fadeOut' may only be used for streaming and MIDI sources.");
            return;
        }
        if(l < 0L)
        {
            errorMessage("Miliseconds may not be negative in method 'fadeOut'.");
            return;
        }
        fadeOutMilis = l;
        fadeInMilis = 0L;
        fadeOutGain = 1.0F;
        lastFadeCheck = System.currentTimeMillis();
        synchronized(soundSequenceLock)
        {
            if(soundSequenceQueue != null)
                soundSequenceQueue.clear();
            if(filenameurl != null)
            {
                if(soundSequenceQueue == null)
                    soundSequenceQueue = new LinkedList();
                soundSequenceQueue.add(((Object) (filenameurl)));
            }
        }
    }

    public void fadeOutIn(FilenameURL filenameurl, long l, long l1)
    {
        if(!toStream)
        {
            errorMessage("Method 'fadeOutIn' may only be used for streaming and MIDI sources.");
            return;
        }
        if(filenameurl == null)
        {
            errorMessage("Filename/URL not specified in method 'fadeOutIn'.");
            return;
        }
        if(l < 0L || l1 < 0L)
        {
            errorMessage("Miliseconds may not be negative in method 'fadeOutIn'.");
            return;
        }
        fadeOutMilis = l;
        fadeInMilis = l1;
        fadeOutGain = 1.0F;
        lastFadeCheck = System.currentTimeMillis();
        synchronized(soundSequenceLock)
        {
            if(soundSequenceQueue == null)
                soundSequenceQueue = new LinkedList();
            soundSequenceQueue.clear();
            soundSequenceQueue.add(((Object) (filenameurl)));
        }
    }

    public boolean checkFadeOut()
    {
        if(!toStream)
            return false;
        if(fadeOutGain == -1F && fadeInGain == 1.0F)
            return false;
        long l = System.currentTimeMillis();
        long l1 = l - lastFadeCheck;
        lastFadeCheck = l;
        if(fadeOutGain >= 0.0F)
        {
            if(fadeOutMilis == 0L)
            {
                fadeOutGain = 0.0F;
                fadeInGain = 0.0F;
                if(!incrementSoundSequence())
                    stop();
                positionChanged();
                preLoad = true;
                return false;
            }
            float f = (float)l1 / (float)fadeOutMilis;
            fadeOutGain -= f;
            if(fadeOutGain <= 0.0F)
            {
                fadeOutGain = -1F;
                fadeInGain = 0.0F;
                if(!incrementSoundSequence())
                    stop();
                positionChanged();
                preLoad = true;
                return false;
            } else
            {
                positionChanged();
                return true;
            }
        }
        if(fadeInGain < 1.0F)
        {
            fadeOutGain = -1F;
            if(fadeInMilis == 0L)
            {
                fadeOutGain = -1F;
                fadeInGain = 1.0F;
            } else
            {
                float f1 = (float)l1 / (float)fadeInMilis;
                fadeInGain += f1;
                if(fadeInGain >= 1.0F)
                {
                    fadeOutGain = -1F;
                    fadeInGain = 1.0F;
                }
            }
            positionChanged();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean incrementSoundSequence()
    {
        if(!toStream)
        {
            errorMessage("Method 'incrementSoundSequence' may only be used for streaming and MIDI sources.");
            return false;
        }
        Object obj = soundSequenceLock;
        JVM INSTR monitorenter ;
        if(soundSequenceQueue == null || soundSequenceQueue.size() <= 0)
            break MISSING_BLOCK_LABEL_88;
        filenameURL = (FilenameURL)soundSequenceQueue.remove(0);
        if(codec != null)
            codec.cleanup();
        codec = SoundSystemConfig.getCodec(filenameURL.getFilename());
        return true;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        return false;
    }

    public void setTemporary(boolean flag)
    {
        temporary = flag;
    }

    public void listenerMoved()
    {
    }

    public void setPosition(float f, float f1, float f2)
    {
        position.x = f;
        position.y = f1;
        position.z = f2;
    }

    public void positionChanged()
    {
    }

    public void setPriority(boolean flag)
    {
        priority = flag;
    }

    public void setLooping(boolean flag)
    {
        toLoop = flag;
    }

    public void setAttenuation(int i)
    {
        attModel = i;
    }

    public void setDistOrRoll(float f)
    {
        distOrRoll = f;
    }

    public float getDistanceFromListener()
    {
        return distanceFromListener;
    }

    public void setPitch(float f)
    {
        float f1 = f;
        if(f1 < 0.5F)
            f1 = 0.5F;
        else
        if(f1 > 2.0F)
            f1 = 2.0F;
        pitch = f1;
    }

    public float getPitch()
    {
        return pitch;
    }

    public boolean reverseByteOrderRequired()
    {
        return reverseByteOrder;
    }

    public void changeSource(boolean flag, boolean flag1, boolean flag2, String s, FilenameURL filenameurl, SoundBuffer soundbuffer, float f, 
            float f1, float f2, int i, float f3, boolean flag3)
    {
        priority = flag;
        toStream = flag1;
        toLoop = flag2;
        sourcename = s;
        filenameURL = filenameurl;
        soundBuffer = soundbuffer;
        position.x = f;
        position.y = f1;
        position.z = f2;
        attModel = i;
        distOrRoll = f3;
        temporary = flag3;
    }

    public int feedRawAudioData(Channel channel1, byte abyte0[])
    {
        if(!active(false, false))
        {
            toPlay = true;
            return -1;
        }
        if(channel != channel1)
        {
            channel = channel1;
            channel.close();
            channel.setAudioFormat(rawDataFormat);
            positionChanged();
        }
        stopped(true, false);
        paused(true, false);
        return channel.feedRawAudioData(abyte0);
    }

    public void play(Channel channel1)
    {
        if(!active(false, false))
        {
            if(toLoop)
                toPlay = true;
            return;
        }
        if(channel != channel1)
        {
            channel = channel1;
            channel.close();
        }
        stopped(true, false);
        paused(true, false);
    }

    public boolean stream()
    {
        if(channel == null)
            return false;
        if(preLoad)
            if(rawDataStream)
                preLoad = false;
            else
                return preLoad();
        if(rawDataStream)
        {
            if(stopped() || paused())
                return true;
            if(channel.buffersProcessed() > 0)
                channel.processBuffer();
        } else
        {
            if(codec == null)
                return false;
            if(stopped())
                return false;
            if(paused())
                return true;
            int i = channel.buffersProcessed();
            Object obj = null;
            for(int j = 0; j < i; j++)
            {
                SoundBuffer soundbuffer = codec.read();
                if(soundbuffer != null)
                {
                    if(soundbuffer.audioData != null)
                        channel.queueBuffer(soundbuffer.audioData);
                    soundbuffer.cleanup();
                    soundbuffer = null;
                }
                if(codec.endOfStream())
                    return false;
            }

        }
        return true;
    }

    public boolean preLoad()
    {
        if(channel == null)
            return false;
        if(codec == null)
            return false;
        java.net.URL url = filenameURL.getURL();
        codec.initialize(url);
        Object obj = null;
        for(int i = 0; i < SoundSystemConfig.getNumberStreamingBuffers(); i++)
        {
            SoundBuffer soundbuffer = codec.read();
            if(soundbuffer == null)
                continue;
            if(soundBuffer.audioData != null)
                channel.queueBuffer(soundBuffer.audioData);
            soundbuffer.cleanup();
            soundbuffer = null;
        }

        return true;
    }

    public void pause()
    {
        toPlay = false;
        paused(true, true);
        if(channel != null)
            channel.pause();
        else
            errorMessage("Channel null in method 'pause'");
    }

    public void stop()
    {
        toPlay = false;
        stopped(true, true);
        paused(true, false);
        if(channel != null)
            channel.stop();
        else
            errorMessage("Channel null in method 'stop'");
    }

    public void rewind()
    {
        if(paused(false, false))
            stop();
        if(channel != null)
        {
            boolean flag = playing();
            channel.rewind();
            if(toStream && flag)
            {
                stop();
                play(channel);
            }
        } else
        {
            errorMessage("Channel null in method 'rewind'");
        }
    }

    public void flush()
    {
        if(channel != null)
            channel.flush();
        else
            errorMessage("Channel null in method 'flush'");
    }

    public void cull()
    {
        if(!active(false, false))
            return;
        if(playing() && toLoop)
            toPlay = true;
        if(rawDataStream)
            toPlay = true;
        active(true, false);
        if(channel != null)
            channel.close();
        channel = null;
    }

    public void activate()
    {
        active(true, true);
    }

    public boolean active()
    {
        return active(false, false);
    }

    public boolean playing()
    {
        if(channel == null || channel.attachedSource != this)
            return false;
        if(paused() || stopped())
            return false;
        else
            return channel.playing();
    }

    public boolean stopped()
    {
        return stopped(false, false);
    }

    public boolean paused()
    {
        return paused(false, false);
    }

    private synchronized boolean active(boolean flag, boolean flag1)
    {
        if(flag)
            active = flag1;
        return active;
    }

    private synchronized boolean stopped(boolean flag, boolean flag1)
    {
        if(flag)
            stopped = flag1;
        return stopped;
    }

    private synchronized boolean paused(boolean flag, boolean flag1)
    {
        if(flag)
            paused = flag1;
        return paused;
    }

    public String getClassName()
    {
        String s = SoundSystemConfig.getLibraryTitle(libraryType);
        if(s.equals("No Sound"))
            return "Source";
        else
            return (new StringBuilder()).append("Source").append(s).toString();
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
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private SoundSystemLogger logger;
    public boolean rawDataStream;
    public AudioFormat rawDataFormat;
    public boolean temporary;
    public boolean priority;
    public boolean toStream;
    public boolean toLoop;
    public boolean toPlay;
    public String sourcename;
    public FilenameURL filenameURL;
    public Vector3D position;
    public int attModel;
    public float distOrRoll;
    public float gain;
    public float sourceVolume;
    protected float pitch;
    public float distanceFromListener;
    public Channel channel;
    private boolean active;
    private boolean stopped;
    private boolean paused;
    protected SoundBuffer soundBuffer;
    protected ICodec codec;
    protected boolean reverseByteOrder;
    protected LinkedList soundSequenceQueue;
    protected final Object soundSequenceLock;
    public boolean preLoad;
    protected float fadeOutGain;
    protected float fadeInGain;
    protected long fadeOutMilis;
    protected long fadeInMilis;
    protected long lastFadeCheck;
}
