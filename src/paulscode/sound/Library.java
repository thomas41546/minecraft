// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import java.util.*;
import javax.sound.sampled.AudioFormat;

// Referenced classes of package paulscode.sound:
//            Channel, FilenameURL, ListenerData, MidiChannel, 
//            SoundSystemConfig, SoundSystemException, SoundSystemLogger, Source, 
//            StreamThread, Vector3D

public class Library
{

    public Library()
    {
        bufferMap = null;
        nextStreamingChannel = 0;
        nextNormalChannel = 0;
        logger = SoundSystemConfig.getLogger();
        bufferMap = new HashMap();
        sourceMap = new HashMap();
        listener = new ListenerData(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1F, 0.0F, 1.0F, 0.0F, 0.0F);
        streamingChannels = ((List) (new LinkedList()));
        normalChannels = ((List) (new LinkedList()));
        streamingChannelSourceNames = new String[SoundSystemConfig.getNumberStreamingChannels()];
        normalChannelSourceNames = new String[SoundSystemConfig.getNumberNormalChannels()];
        streamThread = new StreamThread();
        streamThread.start();
    }

    public void cleanup()
    {
        streamThread.kill();
        streamThread.interrupt();
        for(int i = 0; i < 50 && streamThread.alive(); i++)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception exception) { }

        if(streamThread.alive())
        {
            errorMessage("Stream thread did not die!");
            message("Ignoring errors... continuing clean-up.");
        }
        if(midiChannel != null)
        {
            midiChannel.cleanup();
            midiChannel = null;
        }
        Object obj = null;
        if(streamingChannels != null)
        {
            while(!streamingChannels.isEmpty()) 
            {
                Channel channel = (Channel)streamingChannels.remove(0);
                channel.close();
                channel.cleanup();
                channel = null;
            }
            streamingChannels.clear();
            streamingChannels = null;
        }
        if(normalChannels != null)
        {
            while(!normalChannels.isEmpty()) 
            {
                Channel channel1 = (Channel)normalChannels.remove(0);
                channel1.close();
                channel1.cleanup();
                channel1 = null;
            }
            normalChannels.clear();
            normalChannels = null;
        }
        Set set = sourceMap.keySet();
        Iterator iterator = set.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.cleanup();
        } while(true);
        sourceMap.clear();
        sourceMap = null;
        listener = null;
        streamThread = null;
    }

    public void init()
    {
        Object obj = null;
        int i = 0;
        do
        {
            if(i >= SoundSystemConfig.getNumberStreamingChannels())
                break;
            Channel channel = createChannel(1);
            if(channel == null)
                break;
            streamingChannels.add(((Object) (channel)));
            i++;
        } while(true);
        i = 0;
        do
        {
            if(i >= SoundSystemConfig.getNumberNormalChannels())
                break;
            Channel channel1 = createChannel(0);
            if(channel1 == null)
                break;
            normalChannels.add(((Object) (channel1)));
            i++;
        } while(true);
    }

    public static boolean libraryCompatible()
    {
        return true;
    }

    protected Channel createChannel(int i)
    {
        return null;
    }

    public boolean loadSound(FilenameURL filenameurl)
    {
        return true;
    }

    public void unloadSound(String s)
    {
        bufferMap.remove(((Object) (s)));
    }

    public void rawDataStream(AudioFormat audioformat, boolean flag, String s, float f, float f1, float f2, int i, 
            float f3)
    {
        sourceMap.put(((Object) (s)), ((Object) (new Source(audioformat, flag, s, f, f1, f2, i, f3))));
    }

    public void newSource(boolean flag, boolean flag1, boolean flag2, String s, FilenameURL filenameurl, float f, float f1, 
            float f2, int i, float f3)
    {
        sourceMap.put(((Object) (s)), ((Object) (new Source(flag, flag1, flag2, s, filenameurl, ((SoundBuffer) (null)), f, f1, f2, i, f3, false))));
    }

    public void quickPlay(boolean flag, boolean flag1, boolean flag2, String s, FilenameURL filenameurl, float f, float f1, 
            float f2, int i, float f3, boolean flag3)
    {
        sourceMap.put(((Object) (s)), ((Object) (new Source(flag, flag1, flag2, s, filenameurl, ((SoundBuffer) (null)), f, f1, f2, i, f3, flag3))));
    }

    public void setTemporary(String s, boolean flag)
    {
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source != null)
            source.setTemporary(flag);
    }

    public void setPosition(String s, float f, float f1, float f2)
    {
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source != null)
            source.setPosition(f, f1, f2);
    }

    public void setPriority(String s, boolean flag)
    {
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source != null)
            source.setPriority(flag);
    }

    public void setLooping(String s, boolean flag)
    {
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source != null)
            source.setLooping(flag);
    }

    public void setAttenuation(String s, int i)
    {
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source != null)
            source.setAttenuation(i);
    }

    public void setDistOrRoll(String s, float f)
    {
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source != null)
            source.setDistOrRoll(f);
    }

    public int feedRawAudioData(String s, byte abyte0[])
    {
        if(s == null || s.equals(""))
        {
            errorMessage("Sourcename not specified in method 'feedRawAudioData'");
            return -1;
        }
        if(midiSourcename(s))
        {
            errorMessage("Raw audio data can not be fed to the MIDI channel.");
            return -1;
        }
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source == null)
            errorMessage((new StringBuilder()).append("Source '").append(s).append("' not found in ").append("method 'feedRawAudioData'").toString());
        return feedRawAudioData(source, abyte0);
    }

    public int feedRawAudioData(Source source, byte abyte0[])
    {
        if(source == null)
        {
            errorMessage("Source parameter null in method 'feedRawAudioData'");
            return -1;
        }
        if(!source.toStream)
        {
            errorMessage("Only a streaming source may be specified in method 'feedRawAudioData'");
            return -1;
        }
        if(!source.rawDataStream)
        {
            errorMessage("Streaming source already associated with a file or URL in method'feedRawAudioData'");
            return -1;
        }
        if(!source.playing() || source.channel == null)
        {
            Channel channel;
            if(source.channel != null && source.channel.attachedSource == source)
                channel = source.channel;
            else
                channel = getNextChannel(source);
            int i = source.feedRawAudioData(channel, abyte0);
            channel.attachedSource = source;
            streamThread.watch(source);
            streamThread.interrupt();
            return i;
        } else
        {
            return source.feedRawAudioData(source.channel, abyte0);
        }
    }

    public void play(String s)
    {
        if(s == null || s.equals(""))
        {
            errorMessage("Sourcename not specified in method 'play'");
            return;
        }
        if(midiSourcename(s))
        {
            midiChannel.play();
        } else
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source == null)
                errorMessage((new StringBuilder()).append("Source '").append(s).append("' not found in ").append("method 'play'").toString());
            play(source);
        }
    }

    public void play(Source source)
    {
        if(source == null)
            return;
        if(source.rawDataStream)
            return;
        if(!source.active())
            return;
        if(!source.playing())
        {
            Channel channel = getNextChannel(source);
            if(source != null && channel != null)
            {
                if(source.channel != null && source.channel.attachedSource != source)
                    source.channel = null;
                channel.attachedSource = source;
                source.play(channel);
                if(source.toStream)
                {
                    streamThread.watch(source);
                    streamThread.interrupt();
                }
            }
        }
    }

    public void stop(String s)
    {
        if(s == null || s.equals(""))
        {
            errorMessage("Sourcename not specified in method 'stop'");
            return;
        }
        if(midiSourcename(s))
        {
            midiChannel.stop();
        } else
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.stop();
        }
    }

    public void pause(String s)
    {
        if(s == null || s.equals(""))
        {
            errorMessage("Sourcename not specified in method 'stop'");
            return;
        }
        if(midiSourcename(s))
        {
            midiChannel.pause();
        } else
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.pause();
        }
    }

    public void rewind(String s)
    {
        if(midiSourcename(s))
        {
            midiChannel.rewind();
        } else
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.rewind();
        }
    }

    public void flush(String s)
    {
        if(midiSourcename(s))
        {
            errorMessage("You can not flush the MIDI channel");
        } else
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.flush();
        }
    }

    public void cull(String s)
    {
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source != null)
            source.cull();
    }

    public void activate(String s)
    {
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source != null)
        {
            source.activate();
            if(source.toPlay)
                play(source);
        }
    }

    public void setMasterVolume(float f)
    {
        SoundSystemConfig.setMasterGain(f);
        if(midiChannel != null)
            midiChannel.resetGain();
    }

    public void setVolume(String s, float f)
    {
        if(midiSourcename(s))
        {
            midiChannel.setVolume(f);
        } else
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
            {
                float f1 = f;
                if(f1 < 0.0F)
                    f1 = 0.0F;
                else
                if(f1 > 1.0F)
                    f1 = 1.0F;
                source.sourceVolume = f1;
                source.positionChanged();
            }
        }
    }

    public float getVolume(String s)
    {
        if(midiSourcename(s))
            return midiChannel.getVolume();
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source != null)
            return source.sourceVolume;
        else
            return 0.0F;
    }

    public void setPitch(String s, float f)
    {
        if(!midiSourcename(s))
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
            {
                float f1 = f;
                if(f1 < 0.5F)
                    f1 = 0.5F;
                else
                if(f1 > 2.0F)
                    f1 = 2.0F;
                source.setPitch(f1);
                source.positionChanged();
            }
        }
    }

    public float getPitch(String s)
    {
        if(!midiSourcename(s))
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                return source.getPitch();
        }
        return 1.0F;
    }

    public void moveListener(float f, float f1, float f2)
    {
        setListenerPosition(listener.position.x + f, listener.position.y + f1, listener.position.z + f2);
    }

    public void setListenerPosition(float f, float f1, float f2)
    {
        listener.setPosition(f, f1, f2);
        Set set = sourceMap.keySet();
        Iterator iterator = set.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.positionChanged();
        } while(true);
    }

    public void turnListener(float f)
    {
        setListenerAngle(listener.angle + f);
    }

    public void setListenerAngle(float f)
    {
        listener.setAngle(f);
        Set set = sourceMap.keySet();
        Iterator iterator = set.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.positionChanged();
        } while(true);
    }

    public void setListenerOrientation(float f, float f1, float f2, float f3, float f4, float f5)
    {
        listener.setOrientation(f, f1, f2, f3, f4, f5);
        Set set = sourceMap.keySet();
        Iterator iterator = set.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.positionChanged();
        } while(true);
    }

    public void setListenerData(ListenerData listenerdata)
    {
        listener.setData(listenerdata);
    }

    public void copySources(HashMap hashmap)
    {
        if(hashmap == null)
            return;
        Set set = hashmap.keySet();
        Iterator iterator = set.iterator();
        sourceMap.clear();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            Source source = (Source)hashmap.get(((Object) (s)));
            if(source != null)
            {
                loadSound(source.filenameURL);
                sourceMap.put(((Object) (s)), ((Object) (new Source(source, ((SoundBuffer) (null))))));
            }
        } while(true);
    }

    public void removeSource(String s)
    {
        Source source = (Source)sourceMap.get(((Object) (s)));
        if(source != null)
            source.cleanup();
        sourceMap.remove(((Object) (s)));
    }

    public void removeTemporarySources()
    {
        Set set = sourceMap.keySet();
        Iterator iterator = set.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null && source.temporary && !source.playing())
            {
                source.cleanup();
                iterator.remove();
            }
        } while(true);
    }

    private Channel getNextChannel(Source source)
    {
        if(source == null)
            return null;
        String s = source.sourcename;
        if(s == null)
            return null;
        int i1;
        List list;
        String as[];
        if(source.toStream)
        {
            i1 = nextStreamingChannel;
            list = streamingChannels;
            as = streamingChannelSourceNames;
        } else
        {
            i1 = nextNormalChannel;
            list = normalChannels;
            as = normalChannelSourceNames;
        }
        int l = list.size();
        for(int i = 0; i < l; i++)
            if(s.equals(((Object) (as[i]))))
                return (Channel)list.get(i);

        int j1 = i1;
        for(int j = 0; j < l; j++)
        {
            String s1 = as[j1];
            Source source1;
            if(s1 == null)
                source1 = null;
            else
                source1 = (Source)sourceMap.get(((Object) (s1)));
            if(source1 == null || !source1.playing())
            {
                if(source.toStream)
                {
                    nextStreamingChannel = j1 + 1;
                    if(nextStreamingChannel >= l)
                        nextStreamingChannel = 0;
                } else
                {
                    nextNormalChannel = j1 + 1;
                    if(nextNormalChannel >= l)
                        nextNormalChannel = 0;
                }
                as[j1] = s;
                return (Channel)list.get(j1);
            }
            if(++j1 >= l)
                j1 = 0;
        }

        j1 = i1;
        for(int k = 0; k < l; k++)
        {
            String s2 = as[j1];
            Source source2;
            if(s2 == null)
                source2 = null;
            else
                source2 = (Source)sourceMap.get(((Object) (s2)));
            if(source2 == null || !source2.playing() || !source2.priority)
            {
                if(source.toStream)
                {
                    nextStreamingChannel = j1 + 1;
                    if(nextStreamingChannel >= l)
                        nextStreamingChannel = 0;
                } else
                {
                    nextNormalChannel = j1 + 1;
                    if(nextNormalChannel >= l)
                        nextNormalChannel = 0;
                }
                as[j1] = s;
                return (Channel)list.get(j1);
            }
            if(++j1 >= l)
                j1 = 0;
        }

        return null;
    }

    public void replaySources()
    {
        Set set = sourceMap.keySet();
        Iterator iterator = set.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null && source.toPlay && !source.playing())
            {
                play(s);
                source.toPlay = false;
            }
        } while(true);
    }

    public void queueSound(String s, FilenameURL filenameurl)
    {
        if(midiSourcename(s))
        {
            midiChannel.queueSound(filenameurl);
        } else
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.queueSound(filenameurl);
        }
    }

    public void dequeueSound(String s, String s1)
    {
        if(midiSourcename(s))
        {
            midiChannel.dequeueSound(s1);
        } else
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.dequeueSound(s1);
        }
    }

    public void fadeOut(String s, FilenameURL filenameurl, long l)
    {
        if(midiSourcename(s))
        {
            midiChannel.fadeOut(filenameurl, l);
        } else
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.fadeOut(filenameurl, l);
        }
    }

    public void fadeOutIn(String s, FilenameURL filenameurl, long l, long l1)
    {
        if(midiSourcename(s))
        {
            midiChannel.fadeOutIn(filenameurl, l, l1);
        } else
        {
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.fadeOutIn(filenameurl, l, l1);
        }
    }

    public void checkFadeVolumes()
    {
        if(midiChannel != null)
            midiChannel.resetGain();
        for(int i = 0; i < streamingChannels.size(); i++)
        {
            Channel channel = (Channel)streamingChannels.get(i);
            if(channel == null)
                continue;
            Source source = channel.attachedSource;
            if(source != null)
                source.checkFadeOut();
        }

        Object obj = null;
        Object obj1 = null;
    }

    public void loadMidi(boolean flag, String s, FilenameURL filenameurl)
    {
        if(filenameurl == null)
        {
            errorMessage("Filename/URL not specified in method 'loadMidi'.");
            return;
        }
        if(!filenameurl.getFilename().matches(".*[mM][iI][dD][iI]?$"))
        {
            errorMessage("Filename/identifier doesn't end in '.mid' or'.midi' in method loadMidi.");
            return;
        }
        if(midiChannel == null)
            midiChannel = new MidiChannel(flag, s, filenameurl);
        else
            midiChannel.switchSource(flag, s, filenameurl);
    }

    public void unloadMidi()
    {
        if(midiChannel != null)
            midiChannel.cleanup();
        midiChannel = null;
    }

    public boolean midiSourcename(String s)
    {
        if(midiChannel == null || s == null)
            return false;
        if(midiChannel.getSourcename() == null || s.equals(""))
            return false;
        return s.equals(((Object) (midiChannel.getSourcename())));
    }

    public Source getSource(String s)
    {
        return (Source)sourceMap.get(((Object) (s)));
    }

    public MidiChannel getMidiChannel()
    {
        return midiChannel;
    }

    public void setMidiChannel(MidiChannel midichannel)
    {
        if(midiChannel != null && midiChannel != midichannel)
            midiChannel.cleanup();
        midiChannel = midichannel;
    }

    public void listenerMoved()
    {
        Set set = sourceMap.keySet();
        Iterator iterator = set.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            Source source = (Source)sourceMap.get(((Object) (s)));
            if(source != null)
                source.listenerMoved();
        } while(true);
    }

    public HashMap getSources()
    {
        return sourceMap;
    }

    public ListenerData getListenerData()
    {
        return listener;
    }

    public static String getTitle()
    {
        return "No Sound";
    }

    public static String getDescription()
    {
        return "Silent Mode";
    }

    public String getClassName()
    {
        return "Library";
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

    private SoundSystemLogger logger;
    protected ListenerData listener;
    protected HashMap bufferMap;
    protected HashMap sourceMap;
    private MidiChannel midiChannel;
    protected List streamingChannels;
    protected List normalChannels;
    private String streamingChannelSourceNames[];
    private String normalChannelSourceNames[];
    private int nextStreamingChannel;
    private int nextNormalChannel;
    protected StreamThread streamThread;
}
