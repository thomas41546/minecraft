// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import java.net.URL;
import java.util.*;
import javax.sound.sampled.AudioFormat;

// Referenced classes of package paulscode.sound:
//            CommandObject, CommandThread, FilenameURL, Library, 
//            MidiChannel, SoundSystemConfig, SoundSystemException, SoundSystemLogger, 
//            Source, ListenerData

public class SoundSystem
{

    public SoundSystem()
    {
        className = "SoundSystem";
        logger = SoundSystemConfig.getLogger();
        if(logger == null)
        {
            logger = new SoundSystemLogger();
            SoundSystemConfig.setLogger(logger);
        }
        linkDefaultLibrariesAndCodecs();
        LinkedList linkedlist = SoundSystemConfig.getLibraries();
        if(linkedlist != null)
        {
            for(ListIterator listiterator = linkedlist.listIterator(); listiterator.hasNext();)
            {
                Class class1 = (Class)listiterator.next();
                try
                {
                    init(class1);
                    return;
                }
                catch(SoundSystemException soundsystemexception1)
                {
                    logger.printExceptionMessage(((Exception) (soundsystemexception1)), 1);
                }
            }

        }
        try
        {
            init(paulscode/sound/Library);
            return;
        }
        catch(SoundSystemException soundsystemexception)
        {
            logger.printExceptionMessage(((Exception) (soundsystemexception)), 1);
        }
    }

    public SoundSystem(Class class1)
    {
        className = "SoundSystem";
        logger = SoundSystemConfig.getLogger();
        if(logger == null)
        {
            logger = new SoundSystemLogger();
            SoundSystemConfig.setLogger(logger);
        }
        linkDefaultLibrariesAndCodecs();
        init(class1);
    }

    protected void linkDefaultLibrariesAndCodecs()
    {
    }

    protected void init(Class class1)
    {
        message("", 0);
        message((new StringBuilder()).append("Starting up ").append(className).append("...").toString(), 0);
        randomNumberGenerator = new Random();
        commandQueue = ((List) (new LinkedList()));
        sourcePlayList = ((List) (new LinkedList()));
        commandThread = new CommandThread(this);
        commandThread.start();
        snooze(200L);
        newLibrary(class1);
        message("", 0);
    }

    public void cleanup()
    {
        boolean flag = false;
        message("", 0);
        message((new StringBuilder()).append(className).append(" shutting down...").toString(), 0);
        try
        {
            commandThread.kill();
            commandThread.interrupt();
        }
        catch(Exception exception)
        {
            flag = true;
        }
        if(!flag)
        {
            for(int i = 0; i < 50 && commandThread.alive(); i++)
                snooze(100L);

        }
        if(flag || commandThread.alive())
        {
            errorMessage("Command thread did not die!", 0);
            message("Ignoring errors... continuing clean-up.", 0);
        }
        initialized(true, false);
        currentLibrary(true, ((Class) (null)));
        try
        {
            if(soundLibrary != null)
                soundLibrary.cleanup();
        }
        catch(Exception exception1)
        {
            errorMessage("Problem during Library.cleanup()!", 0);
            message("Ignoring errors... continuing clean-up.", 0);
        }
        try
        {
            if(commandQueue != null)
                commandQueue.clear();
        }
        catch(Exception exception2)
        {
            errorMessage("Unable to clear the command queue!", 0);
            message("Ignoring errors... continuing clean-up.", 0);
        }
        try
        {
            if(sourcePlayList != null)
                sourcePlayList.clear();
        }
        catch(Exception exception3)
        {
            errorMessage("Unable to clear the source management list!", 0);
            message("Ignoring errors... continuing clean-up.", 0);
        }
        randomNumberGenerator = null;
        soundLibrary = null;
        commandQueue = null;
        sourcePlayList = null;
        commandThread = null;
        importantMessage("Author: Paul Lamb, www.paulscode.com", 1);
        message("", 0);
    }

    public void interruptCommandThread()
    {
        if(commandThread == null)
        {
            errorMessage("Command Thread null in method 'interruptCommandThread'", 0);
            return;
        } else
        {
            commandThread.interrupt();
            return;
        }
    }

    public void loadSound(String s)
    {
        CommandQueue(new CommandObject(2, ((Object) (new FilenameURL(s)))));
        commandThread.interrupt();
    }

    public void loadSound(URL url, String s)
    {
        CommandQueue(new CommandObject(2, ((Object) (new FilenameURL(url, s)))));
        commandThread.interrupt();
    }

    public void unloadSound(String s)
    {
        CommandQueue(new CommandObject(4, s));
        commandThread.interrupt();
    }

    public void queueSound(String s, String s1)
    {
        CommandQueue(new CommandObject(5, s, ((Object) (new FilenameURL(s1)))));
        commandThread.interrupt();
    }

    public void queueSound(String s, URL url, String s1)
    {
        CommandQueue(new CommandObject(5, s, ((Object) (new FilenameURL(url, s1)))));
        commandThread.interrupt();
    }

    public void dequeueSound(String s, String s1)
    {
        CommandQueue(new CommandObject(6, s, s1));
        commandThread.interrupt();
    }

    public void fadeOut(String s, String s1, long l)
    {
        FilenameURL filenameurl = null;
        if(s1 != null)
            filenameurl = new FilenameURL(s1);
        CommandQueue(new CommandObject(7, s, ((Object) (filenameurl)), l));
        commandThread.interrupt();
    }

    public void fadeOut(String s, URL url, String s1, long l)
    {
        FilenameURL filenameurl = null;
        if(url != null && s1 != null)
            filenameurl = new FilenameURL(url, s1);
        CommandQueue(new CommandObject(7, s, ((Object) (filenameurl)), l));
        commandThread.interrupt();
    }

    public void fadeOutIn(String s, String s1, long l, long l1)
    {
        CommandQueue(new CommandObject(8, s, ((Object) (new FilenameURL(s1))), l, l1));
        commandThread.interrupt();
    }

    public void fadeOutIn(String s, URL url, String s1, long l, long l1)
    {
        CommandQueue(new CommandObject(8, s, ((Object) (new FilenameURL(url, s1))), l, l1));
        commandThread.interrupt();
    }

    public void checkFadeVolumes()
    {
        CommandQueue(new CommandObject(9));
        commandThread.interrupt();
    }

    public void backgroundMusic(String s, String s1, boolean flag)
    {
        CommandQueue(new CommandObject(12, true, true, flag, s, ((Object) (new FilenameURL(s1))), 0.0F, 0.0F, 0.0F, 0, 0.0F, false));
        CommandQueue(new CommandObject(21, s));
        commandThread.interrupt();
    }

    public void backgroundMusic(String s, URL url, String s1, boolean flag)
    {
        CommandQueue(new CommandObject(12, true, true, flag, s, ((Object) (new FilenameURL(url, s1))), 0.0F, 0.0F, 0.0F, 0, 0.0F, false));
        CommandQueue(new CommandObject(21, s));
        commandThread.interrupt();
    }

    public void newSource(boolean flag, String s, String s1, boolean flag1, float f, float f1, float f2, 
            int i, float f3)
    {
        CommandQueue(new CommandObject(10, flag, false, flag1, s, ((Object) (new FilenameURL(s1))), f, f1, f2, i, f3));
        commandThread.interrupt();
    }

    public void newSource(boolean flag, String s, URL url, String s1, boolean flag1, float f, float f1, 
            float f2, int i, float f3)
    {
        CommandQueue(new CommandObject(10, flag, false, flag1, s, ((Object) (new FilenameURL(url, s1))), f, f1, f2, i, f3));
        commandThread.interrupt();
    }

    public void newStreamingSource(boolean flag, String s, String s1, boolean flag1, float f, float f1, float f2, 
            int i, float f3)
    {
        CommandQueue(new CommandObject(10, flag, true, flag1, s, ((Object) (new FilenameURL(s1))), f, f1, f2, i, f3));
        commandThread.interrupt();
    }

    public void newStreamingSource(boolean flag, String s, URL url, String s1, boolean flag1, float f, float f1, 
            float f2, int i, float f3)
    {
        CommandQueue(new CommandObject(10, flag, true, flag1, s, ((Object) (new FilenameURL(url, s1))), f, f1, f2, i, f3));
        commandThread.interrupt();
    }

    public void rawDataStream(AudioFormat audioformat, boolean flag, String s, float f, float f1, float f2, int i, 
            float f3)
    {
        CommandQueue(new CommandObject(11, ((Object) (audioformat)), flag, s, f, f1, f2, i, f3));
        commandThread.interrupt();
    }

    public String quickPlay(boolean flag, String s, boolean flag1, float f, float f1, float f2, int i, 
            float f3)
    {
        String s1 = (new StringBuilder()).append("Source_").append(randomNumberGenerator.nextInt()).append("_").append(randomNumberGenerator.nextInt()).toString();
        CommandQueue(new CommandObject(12, flag, false, flag1, s1, ((Object) (new FilenameURL(s))), f, f1, f2, i, f3, true));
        CommandQueue(new CommandObject(21, s1));
        commandThread.interrupt();
        return s1;
    }

    public String quickPlay(boolean flag, URL url, String s, boolean flag1, float f, float f1, float f2, 
            int i, float f3)
    {
        String s1 = (new StringBuilder()).append("Source_").append(randomNumberGenerator.nextInt()).append("_").append(randomNumberGenerator.nextInt()).toString();
        CommandQueue(new CommandObject(12, flag, false, flag1, s1, ((Object) (new FilenameURL(url, s))), f, f1, f2, i, f3, true));
        CommandQueue(new CommandObject(21, s1));
        commandThread.interrupt();
        return s1;
    }

    public String quickStream(boolean flag, String s, boolean flag1, float f, float f1, float f2, int i, 
            float f3)
    {
        String s1 = (new StringBuilder()).append("Source_").append(randomNumberGenerator.nextInt()).append("_").append(randomNumberGenerator.nextInt()).toString();
        CommandQueue(new CommandObject(12, flag, true, flag1, s1, ((Object) (new FilenameURL(s))), f, f1, f2, i, f3, true));
        CommandQueue(new CommandObject(21, s1));
        commandThread.interrupt();
        return s1;
    }

    public String quickStream(boolean flag, URL url, String s, boolean flag1, float f, float f1, float f2, 
            int i, float f3)
    {
        String s1 = (new StringBuilder()).append("Source_").append(randomNumberGenerator.nextInt()).append("_").append(randomNumberGenerator.nextInt()).toString();
        CommandQueue(new CommandObject(12, flag, true, flag1, s1, ((Object) (new FilenameURL(url, s))), f, f1, f2, i, f3, true));
        CommandQueue(new CommandObject(21, s1));
        commandThread.interrupt();
        return s1;
    }

    public void setPosition(String s, float f, float f1, float f2)
    {
        CommandQueue(new CommandObject(13, s, f, f1, f2));
        commandThread.interrupt();
    }

    public void setVolume(String s, float f)
    {
        CommandQueue(new CommandObject(14, s, f));
        commandThread.interrupt();
    }

    public float getVolume(String s)
    {
        Object obj = SoundSystemConfig.THREAD_SYNC;
        JVM INSTR monitorenter ;
        if(soundLibrary != null)
            return soundLibrary.getVolume(s);
        0.0F;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setPitch(String s, float f)
    {
        CommandQueue(new CommandObject(15, s, f));
        commandThread.interrupt();
    }

    public float getPitch(String s)
    {
        if(soundLibrary != null)
            return soundLibrary.getPitch(s);
        else
            return 1.0F;
    }

    public void setPriority(String s, boolean flag)
    {
        CommandQueue(new CommandObject(16, s, flag));
        commandThread.interrupt();
    }

    public void setLooping(String s, boolean flag)
    {
        CommandQueue(new CommandObject(17, s, flag));
        commandThread.interrupt();
    }

    public void setAttenuation(String s, int i)
    {
        CommandQueue(new CommandObject(18, s, i));
        commandThread.interrupt();
    }

    public void setDistOrRoll(String s, float f)
    {
        CommandQueue(new CommandObject(19, s, f));
        commandThread.interrupt();
    }

    public void feedRawAudioData(String s, byte abyte0[])
    {
        CommandQueue(new CommandObject(22, s, abyte0));
        commandThread.interrupt();
    }

    public void play(String s)
    {
        CommandQueue(new CommandObject(21, s));
        commandThread.interrupt();
    }

    public void pause(String s)
    {
        CommandQueue(new CommandObject(23, s));
        commandThread.interrupt();
    }

    public void stop(String s)
    {
        CommandQueue(new CommandObject(24, s));
        commandThread.interrupt();
    }

    public void rewind(String s)
    {
        CommandQueue(new CommandObject(25, s));
        commandThread.interrupt();
    }

    public void flush(String s)
    {
        CommandQueue(new CommandObject(26, s));
        commandThread.interrupt();
    }

    public void cull(String s)
    {
        CommandQueue(new CommandObject(27, s));
        commandThread.interrupt();
    }

    public void activate(String s)
    {
        CommandQueue(new CommandObject(28, s));
        commandThread.interrupt();
    }

    public void setTemporary(String s, boolean flag)
    {
        CommandQueue(new CommandObject(29, s, flag));
        commandThread.interrupt();
    }

    public void removeSource(String s)
    {
        CommandQueue(new CommandObject(30, s));
        commandThread.interrupt();
    }

    public void moveListener(float f, float f1, float f2)
    {
        CommandQueue(new CommandObject(31, f, f1, f2));
        commandThread.interrupt();
    }

    public void setListenerPosition(float f, float f1, float f2)
    {
        CommandQueue(new CommandObject(32, f, f1, f2));
        commandThread.interrupt();
    }

    public void turnListener(float f)
    {
        CommandQueue(new CommandObject(33, f));
        commandThread.interrupt();
    }

    public void setListenerAngle(float f)
    {
        CommandQueue(new CommandObject(34, f));
        commandThread.interrupt();
    }

    public void setListenerOrientation(float f, float f1, float f2, float f3, float f4, float f5)
    {
        CommandQueue(new CommandObject(35, f, f1, f2, f3, f4, f5));
        commandThread.interrupt();
    }

    public void setMasterVolume(float f)
    {
        CommandQueue(new CommandObject(36, f));
        commandThread.interrupt();
    }

    public float getMasterVolume()
    {
        return SoundSystemConfig.getMasterGain();
    }

    public ListenerData getListenerData()
    {
        Object obj = SoundSystemConfig.THREAD_SYNC;
        JVM INSTR monitorenter ;
        return soundLibrary.getListenerData();
        Exception exception;
        exception;
        throw exception;
    }

    public boolean switchLibrary(Class class1)
    {
        Object obj = SoundSystemConfig.THREAD_SYNC;
        JVM INSTR monitorenter ;
        initialized(true, false);
        HashMap hashmap = null;
        ListenerData listenerdata = null;
        boolean flag = false;
        MidiChannel midichannel = null;
        FilenameURL filenameurl = null;
        String s = "";
        boolean flag1 = true;
        if(soundLibrary != null)
        {
            currentLibrary(true, ((Class) (null)));
            hashmap = copySources(soundLibrary.getSources());
            listenerdata = soundLibrary.getListenerData();
            midichannel = soundLibrary.getMidiChannel();
            if(midichannel != null)
            {
                flag = true;
                flag1 = midichannel.getLooping();
                s = midichannel.getSourcename();
                filenameurl = midichannel.getFilenameURL();
            }
            soundLibrary.cleanup();
            soundLibrary = null;
        }
        message("", 0);
        message((new StringBuilder()).append("Switching to ").append(SoundSystemConfig.getLibraryTitle(class1)).toString(), 0);
        message((new StringBuilder()).append("(").append(SoundSystemConfig.getLibraryDescription(class1)).append(")").toString(), 1);
        try
        {
            soundLibrary = (Library)class1.newInstance();
        }
        catch(InstantiationException instantiationexception)
        {
            errorMessage("The specified library did not load properly", 1);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            errorMessage("The specified library did not load properly", 1);
        }
        catch(ExceptionInInitializerError exceptionininitializererror)
        {
            errorMessage("The specified library did not load properly", 1);
        }
        catch(SecurityException securityexception)
        {
            errorMessage("The specified library did not load properly", 1);
        }
        if(errorCheck(soundLibrary == null, "Library null after initialization in method 'switchLibrary'", 1))
        {
            SoundSystemException soundsystemexception = new SoundSystemException((new StringBuilder()).append(className).append(" did not load properly.  ").append("Library was null after initialization.").toString(), 4);
            lastException(true, soundsystemexception);
            initialized(true, true);
            throw soundsystemexception;
        }
        try
        {
            soundLibrary.init();
        }
        catch(SoundSystemException soundsystemexception1)
        {
            lastException(true, soundsystemexception1);
            initialized(true, true);
            throw soundsystemexception1;
        }
        soundLibrary.setListenerData(listenerdata);
        if(flag)
        {
            if(midichannel != null)
                midichannel.cleanup();
            midichannel = new MidiChannel(flag1, s, filenameurl);
            soundLibrary.setMidiChannel(midichannel);
        }
        soundLibrary.copySources(hashmap);
        message("", 0);
        lastException(true, ((SoundSystemException) (null)));
        initialized(true, true);
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean newLibrary(Class class1)
    {
        initialized(true, false);
        CommandQueue(new CommandObject(37, class1));
        commandThread.interrupt();
        for(int i = 0; !initialized(false, false) && i < 100; i++)
        {
            snooze(400L);
            commandThread.interrupt();
        }

        if(!initialized(false, false))
        {
            SoundSystemException soundsystemexception = new SoundSystemException((new StringBuilder()).append(className).append(" did not load after 30 seconds.").toString(), 4);
            lastException(true, soundsystemexception);
            throw soundsystemexception;
        }
        SoundSystemException soundsystemexception1 = lastException(false, ((SoundSystemException) (null)));
        if(soundsystemexception1 != null)
            throw soundsystemexception1;
        else
            return true;
    }

    private void CommandNewLibrary(Class class1)
    {
        initialized(true, false);
        String s = "Initializing ";
        if(soundLibrary != null)
        {
            currentLibrary(true, ((Class) (null)));
            s = "Switching to ";
            soundLibrary.cleanup();
            soundLibrary = null;
        }
        message((new StringBuilder()).append(s).append(SoundSystemConfig.getLibraryTitle(class1)).toString(), 0);
        message((new StringBuilder()).append("(").append(SoundSystemConfig.getLibraryDescription(class1)).append(")").toString(), 1);
        try
        {
            soundLibrary = (Library)class1.newInstance();
        }
        catch(InstantiationException instantiationexception)
        {
            errorMessage("The specified library did not load properly", 1);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            errorMessage("The specified library did not load properly", 1);
        }
        catch(ExceptionInInitializerError exceptionininitializererror)
        {
            errorMessage("The specified library did not load properly", 1);
        }
        catch(SecurityException securityexception)
        {
            errorMessage("The specified library did not load properly", 1);
        }
        if(errorCheck(soundLibrary == null, "Library null after initialization in method 'newLibrary'", 1))
        {
            lastException(true, new SoundSystemException((new StringBuilder()).append(className).append(" did not load properly.  ").append("Library was null after initialization.").toString(), 4));
            importantMessage("Switching to silent mode", 1);
            try
            {
                soundLibrary = new Library();
            }
            catch(SoundSystemException soundsystemexception)
            {
                lastException(true, new SoundSystemException("Silent mode did not load properly.  Library was null after initialization.", 4));
                initialized(true, true);
                return;
            }
        }
        try
        {
            soundLibrary.init();
        }
        catch(SoundSystemException soundsystemexception1)
        {
            lastException(true, soundsystemexception1);
            initialized(true, true);
            return;
        }
        lastException(true, ((SoundSystemException) (null)));
        initialized(true, true);
    }

    private void CommandInitialize()
    {
        try
        {
            if(errorCheck(soundLibrary == null, "Library null after initialization in method 'CommandInitialize'", 1))
            {
                SoundSystemException soundsystemexception = new SoundSystemException((new StringBuilder()).append(className).append(" did not load properly.  ").append("Library was null after initialization.").toString(), 4);
                lastException(true, soundsystemexception);
                throw soundsystemexception;
            }
            soundLibrary.init();
        }
        catch(SoundSystemException soundsystemexception1)
        {
            lastException(true, soundsystemexception1);
            initialized(true, true);
        }
    }

    private void CommandLoadSound(FilenameURL filenameurl)
    {
        if(soundLibrary != null)
            soundLibrary.loadSound(filenameurl);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandLoadSound'", 0);
    }

    private void CommandUnloadSound(String s)
    {
        if(soundLibrary != null)
            soundLibrary.unloadSound(s);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandLoadSound'", 0);
    }

    private void CommandQueueSound(String s, FilenameURL filenameurl)
    {
        if(soundLibrary != null)
            soundLibrary.queueSound(s, filenameurl);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandQueueSound'", 0);
    }

    private void CommandDequeueSound(String s, String s1)
    {
        if(soundLibrary != null)
            soundLibrary.dequeueSound(s, s1);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandDequeueSound'", 0);
    }

    private void CommandFadeOut(String s, FilenameURL filenameurl, long l)
    {
        if(soundLibrary != null)
            soundLibrary.fadeOut(s, filenameurl, l);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandFadeOut'", 0);
    }

    private void CommandFadeOutIn(String s, FilenameURL filenameurl, long l, long l1)
    {
        if(soundLibrary != null)
            soundLibrary.fadeOutIn(s, filenameurl, l, l1);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandFadeOutIn'", 0);
    }

    private void CommandCheckFadeVolumes()
    {
        if(soundLibrary != null)
            soundLibrary.checkFadeVolumes();
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandCheckFadeVolumes'", 0);
    }

    private void CommandNewSource(boolean flag, boolean flag1, boolean flag2, String s, FilenameURL filenameurl, float f, float f1, 
            float f2, int i, float f3)
    {
        if(soundLibrary != null)
        {
            if(filenameurl.getFilename().matches(".*[mM][iI][dD][iI]?$") && !SoundSystemConfig.midiCodec())
                soundLibrary.loadMidi(flag2, s, filenameurl);
            else
                soundLibrary.newSource(flag, flag1, flag2, s, filenameurl, f, f1, f2, i, f3);
        } else
        {
            errorMessage("Variable 'soundLibrary' null in method 'CommandNewSource'", 0);
        }
    }

    private void CommandRawDataStream(AudioFormat audioformat, boolean flag, String s, float f, float f1, float f2, int i, 
            float f3)
    {
        if(soundLibrary != null)
            soundLibrary.rawDataStream(audioformat, flag, s, f, f1, f2, i, f3);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandRawDataStream'", 0);
    }

    private void CommandQuickPlay(boolean flag, boolean flag1, boolean flag2, String s, FilenameURL filenameurl, float f, float f1, 
            float f2, int i, float f3, boolean flag3)
    {
        if(soundLibrary != null)
        {
            if(filenameurl.getFilename().matches(".*[mM][iI][dD][iI]?$") && !SoundSystemConfig.midiCodec())
                soundLibrary.loadMidi(flag2, s, filenameurl);
            else
                soundLibrary.quickPlay(flag, flag1, flag2, s, filenameurl, f, f1, f2, i, f3, flag3);
        } else
        {
            errorMessage("Variable 'soundLibrary' null in method 'CommandQuickPlay'", 0);
        }
    }

    private void CommandSetPosition(String s, float f, float f1, float f2)
    {
        if(soundLibrary != null)
            soundLibrary.setPosition(s, f, f1, f2);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandMoveSource'", 0);
    }

    private void CommandSetVolume(String s, float f)
    {
        if(soundLibrary != null)
            soundLibrary.setVolume(s, f);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetVolume'", 0);
    }

    private void CommandSetPitch(String s, float f)
    {
        if(soundLibrary != null)
            soundLibrary.setPitch(s, f);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetPitch'", 0);
    }

    private void CommandSetPriority(String s, boolean flag)
    {
        if(soundLibrary != null)
            soundLibrary.setPriority(s, flag);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetPriority'", 0);
    }

    private void CommandSetLooping(String s, boolean flag)
    {
        if(soundLibrary != null)
            soundLibrary.setLooping(s, flag);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetLooping'", 0);
    }

    private void CommandSetAttenuation(String s, int i)
    {
        if(soundLibrary != null)
            soundLibrary.setAttenuation(s, i);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetAttenuation'", 0);
    }

    private void CommandSetDistOrRoll(String s, float f)
    {
        if(soundLibrary != null)
            soundLibrary.setDistOrRoll(s, f);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetDistOrRoll'", 0);
    }

    private void CommandPlay(String s)
    {
        if(soundLibrary != null)
            soundLibrary.play(s);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandPlay'", 0);
    }

    private void CommandFeedRawAudioData(String s, byte abyte0[])
    {
        if(soundLibrary != null)
            soundLibrary.feedRawAudioData(s, abyte0);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandFeedRawAudioData'", 0);
    }

    private void CommandPause(String s)
    {
        if(soundLibrary != null)
            soundLibrary.pause(s);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandPause'", 0);
    }

    private void CommandStop(String s)
    {
        if(soundLibrary != null)
            soundLibrary.stop(s);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandStop'", 0);
    }

    private void CommandRewind(String s)
    {
        if(soundLibrary != null)
            soundLibrary.rewind(s);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandRewind'", 0);
    }

    private void CommandFlush(String s)
    {
        if(soundLibrary != null)
            soundLibrary.flush(s);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandFlush'", 0);
    }

    private void CommandSetTemporary(String s, boolean flag)
    {
        if(soundLibrary != null)
            soundLibrary.setTemporary(s, flag);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetActive'", 0);
    }

    private void CommandRemoveSource(String s)
    {
        if(soundLibrary != null)
            soundLibrary.removeSource(s);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandRemoveSource'", 0);
    }

    private void CommandMoveListener(float f, float f1, float f2)
    {
        if(soundLibrary != null)
            soundLibrary.moveListener(f, f1, f2);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandMoveListener'", 0);
    }

    private void CommandSetListenerPosition(float f, float f1, float f2)
    {
        if(soundLibrary != null)
            soundLibrary.setListenerPosition(f, f1, f2);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetListenerPosition'", 0);
    }

    private void CommandTurnListener(float f)
    {
        if(soundLibrary != null)
            soundLibrary.turnListener(f);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandTurnListener'", 0);
    }

    private void CommandSetListenerAngle(float f)
    {
        if(soundLibrary != null)
            soundLibrary.setListenerAngle(f);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetListenerAngle'", 0);
    }

    private void CommandSetListenerOrientation(float f, float f1, float f2, float f3, float f4, float f5)
    {
        if(soundLibrary != null)
            soundLibrary.setListenerOrientation(f, f1, f2, f3, f4, f5);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetListenerOrientation'", 0);
    }

    private void CommandCull(String s)
    {
        if(soundLibrary != null)
            soundLibrary.cull(s);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandCull'", 0);
    }

    private void CommandActivate(String s)
    {
        if(soundLibrary != null)
            soundLibrary.activate(s);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandActivate'", 0);
    }

    private void CommandSetMasterVolume(float f)
    {
        if(soundLibrary != null)
            soundLibrary.setMasterVolume(f);
        else
            errorMessage("Variable 'soundLibrary' null in method 'CommandSetMasterVolume'", 0);
    }

    protected void ManageSources()
    {
    }

    public boolean CommandQueue(CommandObject commandobject)
    {
        Object obj = SoundSystemConfig.THREAD_SYNC;
        JVM INSTR monitorenter ;
        boolean flag;
        if(commandobject != null)
            break MISSING_BLOCK_LABEL_1228;
        flag = false;
_L5:
        while(commandQueue != null && commandQueue.size() > 0) 
        {
            CommandObject commandobject1 = (CommandObject)commandQueue.remove(0);
            if(commandobject1 != null)
            {
                switch(commandobject1.Command)
                {
                case 1: // '\001'
                    CommandInitialize();
                    break;

                case 2: // '\002'
                    CommandLoadSound((FilenameURL)commandobject1.objectArgs[0]);
                    break;

                case 4: // '\004'
                    CommandUnloadSound(commandobject1.stringArgs[0]);
                    break;

                case 5: // '\005'
                    CommandQueueSound(commandobject1.stringArgs[0], (FilenameURL)commandobject1.objectArgs[0]);
                    break;

                case 6: // '\006'
                    CommandDequeueSound(commandobject1.stringArgs[0], commandobject1.stringArgs[1]);
                    break;

                case 7: // '\007'
                    CommandFadeOut(commandobject1.stringArgs[0], (FilenameURL)commandobject1.objectArgs[0], commandobject1.longArgs[0]);
                    break;

                case 8: // '\b'
                    CommandFadeOutIn(commandobject1.stringArgs[0], (FilenameURL)commandobject1.objectArgs[0], commandobject1.longArgs[0], commandobject1.longArgs[1]);
                    break;

                case 9: // '\t'
                    CommandCheckFadeVolumes();
                    break;

                case 10: // '\n'
                    CommandNewSource(commandobject1.boolArgs[0], commandobject1.boolArgs[1], commandobject1.boolArgs[2], commandobject1.stringArgs[0], (FilenameURL)commandobject1.objectArgs[0], commandobject1.floatArgs[0], commandobject1.floatArgs[1], commandobject1.floatArgs[2], commandobject1.intArgs[0], commandobject1.floatArgs[3]);
                    break;

                case 11: // '\013'
                    CommandRawDataStream((AudioFormat)commandobject1.objectArgs[0], commandobject1.boolArgs[0], commandobject1.stringArgs[0], commandobject1.floatArgs[0], commandobject1.floatArgs[1], commandobject1.floatArgs[2], commandobject1.intArgs[0], commandobject1.floatArgs[3]);
                    break;

                case 12: // '\f'
                    CommandQuickPlay(commandobject1.boolArgs[0], commandobject1.boolArgs[1], commandobject1.boolArgs[2], commandobject1.stringArgs[0], (FilenameURL)commandobject1.objectArgs[0], commandobject1.floatArgs[0], commandobject1.floatArgs[1], commandobject1.floatArgs[2], commandobject1.intArgs[0], commandobject1.floatArgs[3], commandobject1.boolArgs[3]);
                    break;

                case 13: // '\r'
                    CommandSetPosition(commandobject1.stringArgs[0], commandobject1.floatArgs[0], commandobject1.floatArgs[1], commandobject1.floatArgs[2]);
                    break;

                case 14: // '\016'
                    CommandSetVolume(commandobject1.stringArgs[0], commandobject1.floatArgs[0]);
                    break;

                case 15: // '\017'
                    CommandSetPitch(commandobject1.stringArgs[0], commandobject1.floatArgs[0]);
                    break;

                case 16: // '\020'
                    CommandSetPriority(commandobject1.stringArgs[0], commandobject1.boolArgs[0]);
                    break;

                case 17: // '\021'
                    CommandSetLooping(commandobject1.stringArgs[0], commandobject1.boolArgs[0]);
                    break;

                case 18: // '\022'
                    CommandSetAttenuation(commandobject1.stringArgs[0], commandobject1.intArgs[0]);
                    break;

                case 19: // '\023'
                    CommandSetDistOrRoll(commandobject1.stringArgs[0], commandobject1.floatArgs[0]);
                    break;

                case 21: // '\025'
                    sourcePlayList.add(((Object) (commandobject1)));
                    break;

                case 22: // '\026'
                    sourcePlayList.add(((Object) (commandobject1)));
                    break;

                case 23: // '\027'
                    CommandPause(commandobject1.stringArgs[0]);
                    break;

                case 24: // '\030'
                    CommandStop(commandobject1.stringArgs[0]);
                    break;

                case 25: // '\031'
                    CommandRewind(commandobject1.stringArgs[0]);
                    break;

                case 26: // '\032'
                    CommandFlush(commandobject1.stringArgs[0]);
                    break;

                case 27: // '\033'
                    CommandCull(commandobject1.stringArgs[0]);
                    break;

                case 28: // '\034'
                    flag = true;
                    CommandActivate(commandobject1.stringArgs[0]);
                    break;

                case 29: // '\035'
                    CommandSetTemporary(commandobject1.stringArgs[0], commandobject1.boolArgs[0]);
                    break;

                case 30: // '\036'
                    CommandRemoveSource(commandobject1.stringArgs[0]);
                    break;

                case 31: // '\037'
                    CommandMoveListener(commandobject1.floatArgs[0], commandobject1.floatArgs[1], commandobject1.floatArgs[2]);
                    break;

                case 32: // ' '
                    CommandSetListenerPosition(commandobject1.floatArgs[0], commandobject1.floatArgs[1], commandobject1.floatArgs[2]);
                    break;

                case 33: // '!'
                    CommandTurnListener(commandobject1.floatArgs[0]);
                    break;

                case 34: // '"'
                    CommandSetListenerAngle(commandobject1.floatArgs[0]);
                    break;

                case 35: // '#'
                    CommandSetListenerOrientation(commandobject1.floatArgs[0], commandobject1.floatArgs[1], commandobject1.floatArgs[2], commandobject1.floatArgs[3], commandobject1.floatArgs[4], commandobject1.floatArgs[5]);
                    break;

                case 36: // '$'
                    CommandSetMasterVolume(commandobject1.floatArgs[0]);
                    break;

                case 37: // '%'
                    CommandNewLibrary(commandobject1.classArgs[0]);
                    break;
                }
                continue; /* Loop/switch isn't completed */
            }
        }
        if(flag)
            soundLibrary.replaySources();
_L3:
        while(sourcePlayList != null && sourcePlayList.size() > 0) 
        {
            CommandObject commandobject2 = (CommandObject)sourcePlayList.remove(0);
            if(commandobject2 != null)
            {
                switch(commandobject2.Command)
                {
                case 21: // '\025'
                    CommandPlay(commandobject2.stringArgs[0]);
                    break;

                case 22: // '\026'
                    CommandFeedRawAudioData(commandobject2.stringArgs[0], commandobject2.buffer);
                    break;
                }
                continue; /* Loop/switch isn't completed */
            }
        }
          goto _L1
        if(true) goto _L3; else goto _L2
_L2:
        if(true) goto _L5; else goto _L4
_L4:
_L1:
        return commandQueue != null && commandQueue.size() > 0;
        if(commandQueue != null) goto _L7; else goto _L6
_L6:
        false;
        obj;
        JVM INSTR monitorexit ;
        return;
_L7:
        commandQueue.add(((Object) (commandobject)));
        true;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void removeTemporarySources()
    {
        synchronized(SoundSystemConfig.THREAD_SYNC)
        {
            if(soundLibrary != null)
                soundLibrary.removeTemporarySources();
        }
    }

    public boolean playing(String s)
    {
        Object obj = SoundSystemConfig.THREAD_SYNC;
        JVM INSTR monitorenter ;
        if(soundLibrary == null)
            return false;
        Source source = (Source)soundLibrary.getSources().get(((Object) (s)));
        if(source != null) goto _L2; else goto _L1
_L1:
        false;
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        source.playing();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean playing()
    {
        Object obj = SoundSystemConfig.THREAD_SYNC;
        JVM INSTR monitorenter ;
        if(soundLibrary == null)
            return false;
        HashMap hashmap = soundLibrary.getSources();
        if(hashmap != null) goto _L2; else goto _L1
_L1:
        false;
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator;
        Set set = hashmap.keySet();
        iterator = set.iterator();
_L6:
        if(!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        Source source;
        String s = (String)iterator.next();
        source = (Source)hashmap.get(((Object) (s)));
        if(source == null || !source.playing()) goto _L6; else goto _L5
_L5:
        true;
        obj;
        JVM INSTR monitorexit ;
        return;
_L4:
        false;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private HashMap copySources(HashMap hashmap)
    {
        Set set = hashmap.keySet();
        Iterator iterator = set.iterator();
        HashMap hashmap1 = new HashMap();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            Source source = (Source)hashmap.get(((Object) (s)));
            if(source != null)
                hashmap1.put(((Object) (s)), ((Object) (new Source(source, ((SoundBuffer) (null))))));
        } while(true);
        return hashmap1;
    }

    public static boolean libraryCompatible(Class class1)
    {
        SoundSystemLogger soundsystemlogger = SoundSystemConfig.getLogger();
        if(soundsystemlogger == null)
        {
            soundsystemlogger = new SoundSystemLogger();
            SoundSystemConfig.setLogger(soundsystemlogger);
        }
        soundsystemlogger.message("", 0);
        soundsystemlogger.message((new StringBuilder()).append("Checking if ").append(SoundSystemConfig.getLibraryTitle(class1)).append(" is compatible...").toString(), 0);
        boolean flag = SoundSystemConfig.libraryCompatible(class1);
        if(flag)
            soundsystemlogger.message("...yes", 1);
        else
            soundsystemlogger.message("...no", 1);
        return flag;
    }

    public static Class currentLibrary()
    {
        return currentLibrary(false, ((Class) (null)));
    }

    public static boolean initialized()
    {
        return initialized(false, false);
    }

    public static SoundSystemException getLastException()
    {
        return lastException(false, ((SoundSystemException) (null)));
    }

    public static void setException(SoundSystemException soundsystemexception)
    {
        lastException(true, soundsystemexception);
    }

    private static boolean initialized(boolean flag, boolean flag1)
    {
        Object obj = SoundSystemConfig.THREAD_SYNC;
        JVM INSTR monitorenter ;
        if(flag)
            initialized = flag1;
        return initialized;
        Exception exception;
        exception;
        throw exception;
    }

    private static Class currentLibrary(boolean flag, Class class1)
    {
        Object obj = SoundSystemConfig.THREAD_SYNC;
        JVM INSTR monitorenter ;
        if(flag)
            currentLibrary = class1;
        return currentLibrary;
        Exception exception;
        exception;
        throw exception;
    }

    private static SoundSystemException lastException(boolean flag, SoundSystemException soundsystemexception)
    {
        Object obj = SoundSystemConfig.THREAD_SYNC;
        JVM INSTR monitorenter ;
        if(flag)
            lastException = soundsystemexception;
        return lastException;
        Exception exception;
        exception;
        throw exception;
    }

    protected static void snooze(long l)
    {
        try
        {
            Thread.sleep(l);
        }
        catch(InterruptedException interruptedexception) { }
    }

    protected void message(String s, int i)
    {
        logger.message(s, i);
    }

    protected void importantMessage(String s, int i)
    {
        logger.importantMessage(s, i);
    }

    protected boolean errorCheck(boolean flag, String s, int i)
    {
        return logger.errorCheck(flag, className, s, i);
    }

    protected void errorMessage(String s, int i)
    {
        logger.errorMessage(className, s, i);
    }

    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    protected SoundSystemLogger logger;
    protected Library soundLibrary;
    protected List commandQueue;
    private List sourcePlayList;
    protected CommandThread commandThread;
    public Random randomNumberGenerator;
    protected String className;
    private static Class currentLibrary = null;
    private static boolean initialized = false;
    private static SoundSystemException lastException = null;

}
