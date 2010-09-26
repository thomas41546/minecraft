// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;

// Referenced classes of package paulscode.sound:
//            FilenameURL, SoundSystem, SoundSystemConfig, SoundSystemException, 
//            SoundSystemLogger

public class MidiChannel
    implements MetaEventListener
{

    public MidiChannel(boolean flag, String s, String s1)
    {
        sequencer = null;
        synthesizer = null;
        synthDevice = null;
        sequence = null;
        toLoop = true;
        gain = 1.0F;
        loading = true;
        sequenceQueue = null;
        sequenceQueueLock = new Object();
        fadeOutGain = -1F;
        fadeInGain = 1.0F;
        fadeOutMilis = 0L;
        fadeInMilis = 0L;
        lastFadeCheck = 0L;
        fadeThread = null;
        loading(true, true);
        logger = SoundSystemConfig.getLogger();
        filenameURL(true, new FilenameURL(s1));
        sourcename(true, s);
        setLooping(flag);
        init();
        loading(true, false);
    }

    public MidiChannel(boolean flag, String s, URL url, String s1)
    {
        sequencer = null;
        synthesizer = null;
        synthDevice = null;
        sequence = null;
        toLoop = true;
        gain = 1.0F;
        loading = true;
        sequenceQueue = null;
        sequenceQueueLock = new Object();
        fadeOutGain = -1F;
        fadeInGain = 1.0F;
        fadeOutMilis = 0L;
        fadeInMilis = 0L;
        lastFadeCheck = 0L;
        fadeThread = null;
        loading(true, true);
        logger = SoundSystemConfig.getLogger();
        filenameURL(true, new FilenameURL(url, s1));
        sourcename(true, s);
        setLooping(flag);
        init();
        loading(true, false);
    }

    public MidiChannel(boolean flag, String s, FilenameURL filenameurl)
    {
        sequencer = null;
        synthesizer = null;
        synthDevice = null;
        sequence = null;
        toLoop = true;
        gain = 1.0F;
        loading = true;
        sequenceQueue = null;
        sequenceQueueLock = new Object();
        fadeOutGain = -1F;
        fadeInGain = 1.0F;
        fadeOutMilis = 0L;
        fadeInMilis = 0L;
        lastFadeCheck = 0L;
        fadeThread = null;
        loading(true, true);
        logger = SoundSystemConfig.getLogger();
        filenameURL(true, filenameurl);
        sourcename(true, s);
        setLooping(flag);
        init();
        loading(true, false);
    }

    private void init()
    {
        getSequencer();
        setSequence(filenameURL(false, ((FilenameURL) (null))).getURL());
        getSynthesizer();
        resetGain();
    }

    public void cleanup()
    {
        loading(true, true);
        setLooping(true);
        if(sequencer != null)
            try
            {
                sequencer.stop();
                sequencer.close();
                sequencer.removeMetaEventListener(((MetaEventListener) (this)));
            }
            catch(Exception exception) { }
        logger = null;
        sequencer = null;
        synthesizer = null;
        sequence = null;
        synchronized(sequenceQueueLock)
        {
            if(sequenceQueue != null)
                sequenceQueue.clear();
            sequenceQueue = null;
        }
        if(fadeThread != null)
        {
            boolean flag = false;
            try
            {
                fadeThread.kill();
                fadeThread.interrupt();
            }
            catch(Exception exception2)
            {
                flag = true;
            }
            if(!flag)
            {
                for(int i = 0; i < 50 && fadeThread.alive(); i++)
                    try
                    {
                        Thread.sleep(100L);
                    }
                    catch(InterruptedException interruptedexception) { }

            }
            if(flag || fadeThread.alive())
            {
                errorMessage("MIDI fade effects thread did not die!");
                message("Ignoring errors... continuing clean-up.");
            }
        }
        fadeThread = null;
        loading(true, false);
    }

    public void queueSound(FilenameURL filenameurl)
    {
        if(filenameurl == null)
        {
            errorMessage("Filename/URL not specified in method 'queueSound'");
            return;
        }
        synchronized(sequenceQueueLock)
        {
            if(sequenceQueue == null)
                sequenceQueue = new LinkedList();
            sequenceQueue.add(((Object) (filenameurl)));
        }
    }

    public void dequeueSound(String s)
    {
        if(s == null || s.equals(""))
        {
            errorMessage("Filename not specified in method 'dequeueSound'");
            return;
        }
        synchronized(sequenceQueueLock)
        {
label0:
            {
                if(sequenceQueue == null)
                    break label0;
                ListIterator listiterator = sequenceQueue.listIterator();
                do
                    if(!listiterator.hasNext())
                        break label0;
                while(!((FilenameURL)listiterator.next()).getFilename().equals(((Object) (s))));
                listiterator.remove();
            }
        }
        break MISSING_BLOCK_LABEL_91;
        exception;
        throw exception;
    }

    public void fadeOut(FilenameURL filenameurl, long l)
    {
        if(l < 0L)
        {
            errorMessage("Miliseconds may not be negative in method 'fadeOut'.");
            return;
        }
        fadeOutMilis = l;
        fadeInMilis = 0L;
        fadeOutGain = 1.0F;
        lastFadeCheck = System.currentTimeMillis();
        synchronized(sequenceQueueLock)
        {
            if(sequenceQueue != null)
                sequenceQueue.clear();
            if(filenameurl != null)
            {
                if(sequenceQueue == null)
                    sequenceQueue = new LinkedList();
                sequenceQueue.add(((Object) (filenameurl)));
            }
        }
        if(fadeThread == null)
        {
            fadeThread = new FadeThread(((_cls1) (null)));
            fadeThread.start();
        }
        fadeThread.interrupt();
    }

    public void fadeOutIn(FilenameURL filenameurl, long l, long l1)
    {
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
        synchronized(sequenceQueueLock)
        {
            if(sequenceQueue == null)
                sequenceQueue = new LinkedList();
            sequenceQueue.clear();
            sequenceQueue.add(((Object) (filenameurl)));
        }
        if(fadeThread == null)
        {
            fadeThread = new FadeThread(((_cls1) (null)));
            fadeThread.start();
        }
        fadeThread.interrupt();
    }

    private synchronized boolean checkFadeOut()
    {
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
                if(!incrementSequence())
                    stop();
                rewind();
                resetGain();
                return false;
            }
            float f = (float)l1 / (float)fadeOutMilis;
            fadeOutGain -= f;
            if(fadeOutGain <= 0.0F)
            {
                fadeOutGain = -1F;
                fadeInGain = 0.0F;
                if(!incrementSequence())
                    stop();
                rewind();
                resetGain();
                return false;
            } else
            {
                resetGain();
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
            resetGain();
        }
        return false;
    }

    private boolean incrementSequence()
    {
        Object obj = sequenceQueueLock;
        JVM INSTR monitorenter ;
        if(sequenceQueue == null || sequenceQueue.size() <= 0) goto _L2; else goto _L1
_L1:
        filenameURL(true, (FilenameURL)sequenceQueue.remove(0));
        loading(true, true);
        if(sequencer == null)
        {
            getSequencer();
        } else
        {
            sequencer.stop();
            sequencer.setMicrosecondPosition(0L);
            sequencer.removeMetaEventListener(((MetaEventListener) (this)));
            try
            {
                Thread.sleep(100L);
            }
            catch(InterruptedException interruptedexception) { }
        }
        if(sequencer != null)
            break MISSING_BLOCK_LABEL_125;
        errorMessage("Unable to set the sequence in method 'incrementSequence', because there wasn't a sequencer to use.");
        loading(true, false);
        return false;
        setSequence(filenameURL(false, ((FilenameURL) (null))).getURL());
        sequencer.start();
        resetGain();
        sequencer.addMetaEventListener(((MetaEventListener) (this)));
        loading(true, false);
        true;
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception;
        exception;
        throw exception;
_L3:
        return false;
    }

    public void play()
    {
        if(!loading())
        {
            if(sequencer == null)
                return;
            try
            {
                sequencer.start();
                sequencer.addMetaEventListener(((MetaEventListener) (this)));
            }
            catch(Exception exception)
            {
                errorMessage("Exception in method 'play'");
                printStackTrace(exception);
                SoundSystemException soundsystemexception = new SoundSystemException(exception.getMessage());
                SoundSystem.setException(soundsystemexception);
            }
        }
    }

    public void stop()
    {
        if(!loading())
        {
            if(sequencer == null)
                return;
            try
            {
                sequencer.stop();
                sequencer.setMicrosecondPosition(0L);
                sequencer.removeMetaEventListener(((MetaEventListener) (this)));
            }
            catch(Exception exception)
            {
                errorMessage("Exception in method 'stop'");
                printStackTrace(exception);
                SoundSystemException soundsystemexception = new SoundSystemException(exception.getMessage());
                SoundSystem.setException(soundsystemexception);
            }
        }
    }

    public void pause()
    {
        if(!loading())
        {
            if(sequencer == null)
                return;
            try
            {
                sequencer.stop();
            }
            catch(Exception exception)
            {
                errorMessage("Exception in method 'pause'");
                printStackTrace(exception);
                SoundSystemException soundsystemexception = new SoundSystemException(exception.getMessage());
                SoundSystem.setException(soundsystemexception);
            }
        }
    }

    public void rewind()
    {
        if(!loading())
        {
            if(sequencer == null)
                return;
            try
            {
                sequencer.setMicrosecondPosition(0L);
            }
            catch(Exception exception)
            {
                errorMessage("Exception in method 'rewind'");
                printStackTrace(exception);
                SoundSystemException soundsystemexception = new SoundSystemException(exception.getMessage());
                SoundSystem.setException(soundsystemexception);
            }
        }
    }

    public void setVolume(float f)
    {
        gain = f;
        resetGain();
    }

    public float getVolume()
    {
        return gain;
    }

    public void switchSource(boolean flag, String s, String s1)
    {
        loading(true, true);
        filenameURL(true, new FilenameURL(s1));
        sourcename(true, s);
        setLooping(flag);
        reset();
        loading(true, false);
    }

    public void switchSource(boolean flag, String s, URL url, String s1)
    {
        loading(true, true);
        filenameURL(true, new FilenameURL(url, s1));
        sourcename(true, s);
        setLooping(flag);
        reset();
        loading(true, false);
    }

    public void switchSource(boolean flag, String s, FilenameURL filenameurl)
    {
        loading(true, true);
        filenameURL(true, filenameurl);
        sourcename(true, s);
        setLooping(flag);
        reset();
        loading(true, false);
    }

    private void reset()
    {
        synchronized(sequenceQueueLock)
        {
            if(sequenceQueue != null)
                sequenceQueue.clear();
        }
        if(sequencer == null)
        {
            getSequencer();
        } else
        {
            sequencer.stop();
            sequencer.setMicrosecondPosition(0L);
            sequencer.removeMetaEventListener(((MetaEventListener) (this)));
            try
            {
                Thread.sleep(100L);
            }
            catch(InterruptedException interruptedexception) { }
        }
        if(sequencer == null)
        {
            errorMessage("Unable to set the sequence in method 'reset', because there wasn't a sequencer to use.");
            return;
        } else
        {
            setSequence(filenameURL(false, ((FilenameURL) (null))).getURL());
            sequencer.start();
            resetGain();
            sequencer.addMetaEventListener(((MetaEventListener) (this)));
            return;
        }
    }

    public void setLooping(boolean flag)
    {
        toLoop(true, flag);
    }

    public boolean getLooping()
    {
        return toLoop(false, false);
    }

    private synchronized boolean toLoop(boolean flag, boolean flag1)
    {
        if(flag)
            toLoop = flag1;
        return toLoop;
    }

    public boolean loading()
    {
        return loading(false, false);
    }

    private synchronized boolean loading(boolean flag, boolean flag1)
    {
        if(flag)
            loading = flag1;
        return loading;
    }

    public void setSourcename(String s)
    {
        sourcename(true, s);
    }

    public String getSourcename()
    {
        return sourcename(false, ((String) (null)));
    }

    private synchronized String sourcename(boolean flag, String s)
    {
        if(flag)
            sourcename = s;
        return sourcename;
    }

    public void setFilenameURL(FilenameURL filenameurl)
    {
        filenameURL(true, filenameurl);
    }

    public String getFilename()
    {
        return filenameURL(false, ((FilenameURL) (null))).getFilename();
    }

    public FilenameURL getFilenameURL()
    {
        return filenameURL(false, ((FilenameURL) (null)));
    }

    private synchronized FilenameURL filenameURL(boolean flag, FilenameURL filenameurl)
    {
        if(flag)
            filenameURL = filenameurl;
        return filenameURL;
    }

    public void meta(MetaMessage metamessage)
    {
        if(metamessage.getType() == 47)
            if(toLoop)
            {
                if(!checkFadeOut())
                {
                    if(!incrementSequence())
                        try
                        {
                            sequencer.setMicrosecondPosition(0L);
                            sequencer.start();
                            resetGain();
                        }
                        catch(Exception exception) { }
                } else
                if(sequencer != null)
                    try
                    {
                        sequencer.setMicrosecondPosition(0L);
                        sequencer.start();
                        resetGain();
                    }
                    catch(Exception exception1) { }
            } else
            if(!checkFadeOut())
            {
                if(!incrementSequence())
                    try
                    {
                        sequencer.stop();
                        sequencer.setMicrosecondPosition(0L);
                        sequencer.removeMetaEventListener(((MetaEventListener) (this)));
                    }
                    catch(Exception exception2) { }
            } else
            {
                try
                {
                    sequencer.stop();
                    sequencer.setMicrosecondPosition(0L);
                    sequencer.removeMetaEventListener(((MetaEventListener) (this)));
                }
                catch(Exception exception3) { }
            }
    }

    public void resetGain()
    {
        if(gain < 0.0F)
            gain = 0.0F;
        if(gain > 1.0F)
            gain = 1.0F;
        int i = (int)(gain * SoundSystemConfig.getMasterGain() * Math.abs(fadeOutGain) * fadeInGain * 127F);
        if(synthesizer != null)
        {
            javax.sound.midi.MidiChannel amidichannel[] = synthesizer.getChannels();
            for(int j = 0; amidichannel != null && j < amidichannel.length; j++)
                amidichannel[j].controlChange(7, i);

        } else
        if(synthDevice != null)
            try
            {
                ShortMessage shortmessage = new ShortMessage();
                for(int k = 0; k < 16; k++)
                {
                    shortmessage.setMessage(176, k, 7, i);
                    synthDevice.getReceiver().send(((javax.sound.midi.MidiMessage) (shortmessage)), -1L);
                }

            }
            catch(Exception exception)
            {
                errorMessage("Error resetting gain on MIDI device");
                printStackTrace(exception);
            }
        else
        if(sequencer != null && (sequencer instanceof Synthesizer))
        {
            synthesizer = (Synthesizer)sequencer;
            javax.sound.midi.MidiChannel amidichannel1[] = synthesizer.getChannels();
            for(int l = 0; amidichannel1 != null && l < amidichannel1.length; l++)
                amidichannel1[l].controlChange(7, i);

        } else
        {
            try
            {
                Receiver receiver = MidiSystem.getReceiver();
                ShortMessage shortmessage1 = new ShortMessage();
                for(int i1 = 0; i1 < 16; i1++)
                {
                    shortmessage1.setMessage(176, i1, 7, i);
                    receiver.send(((javax.sound.midi.MidiMessage) (shortmessage1)), -1L);
                }

            }
            catch(Exception exception1)
            {
                errorMessage("Error resetting gain on default receiver");
                printStackTrace(exception1);
            }
        }
    }

    private void getSequencer()
    {
        try
        {
            sequencer = MidiSystem.getSequencer();
            if(sequencer != null)
            {
                try
                {
                    sequencer.getTransmitter();
                }
                catch(MidiUnavailableException midiunavailableexception)
                {
                    message("Unable to get a transmitter from the default MIDI sequencer");
                }
                sequencer.open();
            }
        }
        catch(MidiUnavailableException midiunavailableexception1)
        {
            message("Unable to open the default MIDI sequencer");
            sequencer = null;
        }
        if(sequencer == null)
            sequencer = openSequencer("Real Time Sequencer");
        if(sequencer == null)
            sequencer = openSequencer("Java Sound Sequencer");
        if(sequencer == null)
        {
            errorMessage("Failed to find an available MIDI sequencer");
            return;
        } else
        {
            return;
        }
    }

    private void setSequence(URL url)
    {
        if(sequencer == null)
        {
            errorMessage("Unable to update the sequence in method 'setSequence', because variable 'sequencer' is null");
            return;
        }
        if(url == null)
        {
            errorMessage("Unable to load Midi file in method 'setSequence'.");
            return;
        }
        try
        {
            sequence = MidiSystem.getSequence(url);
        }
        catch(IOException ioexception)
        {
            errorMessage("Input failed while reading from MIDI file in method 'setSequence'.");
            printStackTrace(((Exception) (ioexception)));
            return;
        }
        catch(InvalidMidiDataException invalidmididataexception)
        {
            errorMessage("Invalid MIDI data encountered, or not a MIDI file in method 'setSequence' (1).");
            printStackTrace(((Exception) (invalidmididataexception)));
            return;
        }
        if(sequence == null)
            errorMessage("MidiSystem 'getSequence' method returned null in method 'setSequence'.");
        else
            try
            {
                sequencer.setSequence(sequence);
            }
            catch(InvalidMidiDataException invalidmididataexception1)
            {
                errorMessage("Invalid MIDI data encountered, or not a MIDI file in method 'setSequence' (2).");
                printStackTrace(((Exception) (invalidmididataexception1)));
                return;
            }
            catch(Exception exception)
            {
                errorMessage("Problem setting sequence from MIDI file in method 'setSequence'.");
                printStackTrace(exception);
                return;
            }
    }

    private void getSynthesizer()
    {
        if(sequencer == null)
        {
            errorMessage("Unable to load a Synthesizer in method 'getSynthesizer', because variable 'sequencer' is null");
            return;
        }
        if(sequencer instanceof Synthesizer)
        {
            synthesizer = (Synthesizer)sequencer;
        } else
        {
            try
            {
                synthesizer = MidiSystem.getSynthesizer();
                synthesizer.open();
            }
            catch(MidiUnavailableException midiunavailableexception)
            {
                message("Unable to open the default synthesizer");
                synthesizer = null;
            }
            if(synthesizer == null)
            {
                synthDevice = openMidiDevice("Java Sound Synthesizer");
                if(synthDevice == null)
                    synthDevice = openMidiDevice("Microsoft GS Wavetable");
                if(synthDevice == null)
                    synthDevice = openMidiDevice("Gervill");
                if(synthDevice == null)
                {
                    errorMessage("Failed to find an available MIDI synthesizer");
                    return;
                }
            }
            if(synthesizer == null)
                try
                {
                    sequencer.getTransmitter().setReceiver(synthDevice.getReceiver());
                }
                catch(MidiUnavailableException midiunavailableexception1)
                {
                    errorMessage("Unable to link sequencer transmitter with MIDI device receiver");
                }
            else
            if(synthesizer.getDefaultSoundbank() == null)
                try
                {
                    sequencer.getTransmitter().setReceiver(MidiSystem.getReceiver());
                }
                catch(MidiUnavailableException midiunavailableexception2)
                {
                    errorMessage("Unable to link sequencer transmitter with default receiver");
                }
            else
                try
                {
                    sequencer.getTransmitter().setReceiver(synthesizer.getReceiver());
                }
                catch(MidiUnavailableException midiunavailableexception3)
                {
                    errorMessage("Unable to link sequencer transmitter with synthesizer receiver");
                }
        }
    }

    private Sequencer openSequencer(String s)
    {
        Sequencer sequencer1 = null;
        sequencer1 = (Sequencer)openMidiDevice(s);
        if(sequencer1 == null)
            return null;
        try
        {
            sequencer1.getTransmitter();
        }
        catch(MidiUnavailableException midiunavailableexception)
        {
            message("    Unable to get a transmitter from this sequencer");
            sequencer1 = null;
            return null;
        }
        return sequencer1;
    }

    private MidiDevice openMidiDevice(String s)
    {
        message((new StringBuilder()).append("Searching for MIDI device with name containing '").append(s).append("'").toString());
        Object obj = null;
        javax.sound.midi.MidiDevice.Info ainfo[] = MidiSystem.getMidiDeviceInfo();
        for(int i = 0; i < ainfo.length; i++)
        {
            MidiDevice mididevice = null;
            try
            {
                mididevice = MidiSystem.getMidiDevice(ainfo[i]);
            }
            catch(MidiUnavailableException midiunavailableexception)
            {
                message("    Problem in method 'getMidiDevice':  MIDIUnavailableException was thrown");
                mididevice = null;
            }
            if(mididevice != null && ainfo[i].getName().contains(((CharSequence) (s))))
            {
                message((new StringBuilder()).append("    Found MIDI device named '").append(ainfo[i].getName()).append("'").toString());
                if(mididevice instanceof Synthesizer)
                    message("        *this is a Synthesizer instance");
                if(mididevice instanceof Sequencer)
                    message("        *this is a Sequencer instance");
                try
                {
                    mididevice.open();
                }
                catch(MidiUnavailableException midiunavailableexception1)
                {
                    message("    Unable to open this MIDI device");
                    mididevice = null;
                }
                return mididevice;
            }
        }

        message("    MIDI device not found");
        return null;
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
        return logger.errorCheck(flag, "MidiChannel", s, 0);
    }

    protected void errorMessage(String s)
    {
        logger.errorMessage("MidiChannel", s, 0);
    }

    protected void printStackTrace(Exception exception)
    {
        logger.printStackTrace(exception, 1);
    }

    private SoundSystemLogger logger;
    private FilenameURL filenameURL;
    private String sourcename;
    private static final int CHANGE_VOLUME = 7;
    private static final int END_OF_TRACK = 47;
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private Sequencer sequencer;
    private Synthesizer synthesizer;
    private MidiDevice synthDevice;
    private Sequence sequence;
    private boolean toLoop;
    private float gain;
    private boolean loading;
    private LinkedList sequenceQueue;
    private final Object sequenceQueueLock;
    protected float fadeOutGain;
    protected float fadeInGain;
    protected long fadeOutMilis;
    protected long fadeInMilis;
    protected long lastFadeCheck;
    private FadeThread fadeThread;


    private class FadeThread extends SimpleThread
    {

        public void run()
        {
            for(; !dying(); snooze(50L))
            {
                if(fadeOutGain == -1F && fadeInGain == 1.0F)
                    snooze(0x36ee80L);
                checkFadeOut();
            }

            cleanup();
        }

        final MidiChannel this$0;

        private FadeThread()
        {
            this$0 = MidiChannel.this;
            super();
        }

        FadeThread(_cls1 _pcls1)
        {
            this();
        }
    }

}
