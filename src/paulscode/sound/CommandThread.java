// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;


// Referenced classes of package paulscode.sound:
//            SimpleThread, SoundSystem, SoundSystemConfig, SoundSystemLogger

public class CommandThread extends SimpleThread
{

    public CommandThread(SoundSystem soundsystem)
    {
        className = "CommandThread";
        logger = SoundSystemConfig.getLogger();
        soundSystem = soundsystem;
    }

    protected void cleanup()
    {
        kill();
        logger = null;
        soundSystem = null;
        super.cleanup();
    }

    public void run()
    {
        long l = System.currentTimeMillis();
        long l1 = l;
        if(soundSystem == null)
        {
            errorMessage("SoundSystem was null in method run().", 0);
            cleanup();
            return;
        }
        snooze(0x36ee80L);
        do
        {
            if(dying())
                break;
            soundSystem.ManageSources();
            soundSystem.CommandQueue(((CommandObject) (null)));
            long l2 = System.currentTimeMillis();
            if(!dying() && l2 - l > 10000L)
            {
                l = l2;
                soundSystem.removeTemporarySources();
            }
            if(!dying())
                snooze(0x36ee80L);
        } while(true);
        cleanup();
    }

    protected void message(String s, int i)
    {
        logger.message(s, i);
    }

    protected void importantMessage(String s, int i)
    {
        logger.importantMessage(s, i);
    }

    protected boolean errorCheck(boolean flag, String s)
    {
        return logger.errorCheck(flag, className, s, 0);
    }

    protected void errorMessage(String s, int i)
    {
        logger.errorMessage(className, s, i);
    }

    protected SoundSystemLogger logger;
    private SoundSystem soundSystem;
    protected String className;
}
