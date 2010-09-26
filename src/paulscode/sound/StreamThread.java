// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import java.util.*;

// Referenced classes of package paulscode.sound:
//            SimpleThread, Channel, SoundSystemConfig, SoundSystemLogger, 
//            Source

public class StreamThread extends SimpleThread
{

    public StreamThread()
    {
        logger = SoundSystemConfig.getLogger();
        streamingSources = ((List) (new LinkedList()));
    }

    protected void cleanup()
    {
        kill();
        super.cleanup();
    }

    public void run()
    {
        snooze(0x36ee80L);
        do
        {
            if(dying())
                break;
            do
            {
                if(dying() || streamingSources.isEmpty())
                    break;
                synchronized(listLock)
                {
                    ListIterator listiterator = streamingSources.listIterator();
                    do
                    {
                        if(dying() || !listiterator.hasNext())
                            break;
                        Source source = (Source)listiterator.next();
                        if(source == null)
                            listiterator.remove();
                        else
                        if(source.stopped())
                        {
                            if(!source.rawDataStream)
                                listiterator.remove();
                        } else
                        if(!source.active())
                        {
                            if(source.toLoop || source.rawDataStream)
                                source.toPlay = true;
                            listiterator.remove();
                        } else
                        if(!source.paused())
                        {
                            source.checkFadeOut();
                            if(!source.stream() && !source.rawDataStream && (source.channel == null || !source.channel.processBuffer()))
                                if(source.toLoop)
                                {
                                    if(!source.playing())
                                        if(source.checkFadeOut())
                                        {
                                            source.preLoad = true;
                                        } else
                                        {
                                            source.incrementSoundSequence();
                                            source.preLoad = true;
                                        }
                                } else
                                if(!source.playing() && !source.checkFadeOut())
                                    if(source.incrementSoundSequence())
                                        source.preLoad = true;
                                    else
                                        listiterator.remove();
                        }
                    } while(true);
                }
                if(!dying() && !streamingSources.isEmpty())
                    snooze(20L);
            } while(true);
            if(!dying() && streamingSources.isEmpty())
                snooze(0x36ee80L);
        } while(true);
        cleanup();
        break MISSING_BLOCK_LABEL_356;
        Exception exception1;
        exception1;
        cleanup();
        throw exception1;
    }

    public void watch(Source source)
    {
        if(source == null)
            return;
        if(streamingSources.contains(((Object) (source))))
            return;
        synchronized(listLock)
        {
            ListIterator listiterator = streamingSources.listIterator();
            do
            {
                if(!listiterator.hasNext())
                    break;
                Source source1 = (Source)listiterator.next();
                if(source1 == null)
                    listiterator.remove();
                else
                if(source.channel == source1.channel)
                {
                    source1.stop();
                    listiterator.remove();
                }
            } while(true);
            streamingSources.add(((Object) (source)));
        }
    }

    private void message(String s)
    {
        logger.message(s, 0);
    }

    private void importantMessage(String s)
    {
        logger.importantMessage(s, 0);
    }

    private boolean errorCheck(boolean flag, String s)
    {
        return logger.errorCheck(flag, "StreamThread", s, 0);
    }

    private void errorMessage(String s)
    {
        logger.errorMessage("StreamThread", s, 0);
    }

    private SoundSystemLogger logger;
    private List streamingSources;
    private final Object listLock = new Object();
}
