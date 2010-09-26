// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;


public class SimpleThread extends Thread
{

    public SimpleThread()
    {
        alive = true;
        kill = false;
    }

    protected void cleanup()
    {
        kill(true, true);
        alive(true, false);
    }

    public void run()
    {
        cleanup();
    }

    public void restart()
    {
        (new _cls1()).start();
    }

    private void rerun()
    {
        kill(true, true);
        for(; alive(false, false); snooze(100L));
        alive(true, true);
        kill(true, false);
        run();
    }

    public boolean alive()
    {
        return alive(false, false);
    }

    public void kill()
    {
        kill(true, true);
    }

    protected boolean dying()
    {
        return kill(false, false);
    }

    private synchronized boolean alive(boolean flag, boolean flag1)
    {
        if(flag)
            alive = flag1;
        return alive;
    }

    private synchronized boolean kill(boolean flag, boolean flag1)
    {
        if(flag)
            kill = flag1;
        return kill;
    }

    protected void snooze(long l)
    {
        try
        {
            Thread.sleep(l);
        }
        catch(InterruptedException interruptedexception) { }
    }

    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private boolean alive;
    private boolean kill;


    private class _cls1 extends Thread
    {

        public void run()
        {
            rerun();
        }

        final SimpleThread this$0;

        _cls1()
        {
            this$0 = SimpleThread.this;
            super();
        }
    }

}
