// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;


public class CommandObject
{

    public CommandObject(int i)
    {
        Command = i;
    }

    public CommandObject(int i, int j)
    {
        Command = i;
        intArgs = new int[1];
        intArgs[0] = j;
    }

    public CommandObject(int i, Class class1)
    {
        Command = i;
        classArgs = new Class[1];
        classArgs[0] = class1;
    }

    public CommandObject(int i, float f)
    {
        Command = i;
        floatArgs = new float[1];
        floatArgs[0] = f;
    }

    public CommandObject(int i, String s)
    {
        Command = i;
        stringArgs = new String[1];
        stringArgs[0] = s;
    }

    public CommandObject(int i, Object obj)
    {
        Command = i;
        objectArgs = new Object[1];
        objectArgs[0] = obj;
    }

    public CommandObject(int i, String s, Object obj)
    {
        Command = i;
        stringArgs = new String[1];
        stringArgs[0] = s;
        objectArgs = new Object[1];
        objectArgs[0] = obj;
    }

    public CommandObject(int i, String s, byte abyte0[])
    {
        Command = i;
        stringArgs = new String[1];
        stringArgs[0] = s;
        buffer = abyte0;
    }

    public CommandObject(int i, String s, Object obj, long l)
    {
        Command = i;
        stringArgs = new String[1];
        stringArgs[0] = s;
        objectArgs = new Object[1];
        objectArgs[0] = obj;
        longArgs = new long[1];
        longArgs[0] = l;
    }

    public CommandObject(int i, String s, Object obj, long l, long l1)
    {
        Command = i;
        stringArgs = new String[1];
        stringArgs[0] = s;
        objectArgs = new Object[1];
        objectArgs[0] = obj;
        longArgs = new long[2];
        longArgs[0] = l;
        longArgs[1] = l1;
    }

    public CommandObject(int i, String s, String s1)
    {
        Command = i;
        stringArgs = new String[2];
        stringArgs[0] = s;
        stringArgs[1] = s1;
    }

    public CommandObject(int i, String s, int j)
    {
        Command = i;
        intArgs = new int[1];
        stringArgs = new String[1];
        intArgs[0] = j;
        stringArgs[0] = s;
    }

    public CommandObject(int i, String s, float f)
    {
        Command = i;
        floatArgs = new float[1];
        stringArgs = new String[1];
        floatArgs[0] = f;
        stringArgs[0] = s;
    }

    public CommandObject(int i, String s, boolean flag)
    {
        Command = i;
        boolArgs = new boolean[1];
        stringArgs = new String[1];
        boolArgs[0] = flag;
        stringArgs[0] = s;
    }

    public CommandObject(int i, float f, float f1, float f2)
    {
        Command = i;
        floatArgs = new float[3];
        floatArgs[0] = f;
        floatArgs[1] = f1;
        floatArgs[2] = f2;
    }

    public CommandObject(int i, String s, float f, float f1, float f2)
    {
        Command = i;
        floatArgs = new float[3];
        stringArgs = new String[1];
        floatArgs[0] = f;
        floatArgs[1] = f1;
        floatArgs[2] = f2;
        stringArgs[0] = s;
    }

    public CommandObject(int i, float f, float f1, float f2, float f3, float f4, float f5)
    {
        Command = i;
        floatArgs = new float[6];
        floatArgs[0] = f;
        floatArgs[1] = f1;
        floatArgs[2] = f2;
        floatArgs[3] = f3;
        floatArgs[4] = f4;
        floatArgs[5] = f5;
    }

    public CommandObject(int i, boolean flag, boolean flag1, boolean flag2, String s, Object obj, float f, 
            float f1, float f2, int j, float f3)
    {
        Command = i;
        intArgs = new int[1];
        floatArgs = new float[4];
        boolArgs = new boolean[3];
        stringArgs = new String[1];
        objectArgs = new Object[1];
        intArgs[0] = j;
        floatArgs[0] = f;
        floatArgs[1] = f1;
        floatArgs[2] = f2;
        floatArgs[3] = f3;
        boolArgs[0] = flag;
        boolArgs[1] = flag1;
        boolArgs[2] = flag2;
        stringArgs[0] = s;
        objectArgs[0] = obj;
    }

    public CommandObject(int i, boolean flag, boolean flag1, boolean flag2, String s, Object obj, float f, 
            float f1, float f2, int j, float f3, boolean flag3)
    {
        Command = i;
        intArgs = new int[1];
        floatArgs = new float[4];
        boolArgs = new boolean[4];
        stringArgs = new String[1];
        objectArgs = new Object[1];
        intArgs[0] = j;
        floatArgs[0] = f;
        floatArgs[1] = f1;
        floatArgs[2] = f2;
        floatArgs[3] = f3;
        boolArgs[0] = flag;
        boolArgs[1] = flag1;
        boolArgs[2] = flag2;
        boolArgs[3] = flag3;
        stringArgs[0] = s;
        objectArgs[0] = obj;
    }

    public CommandObject(int i, Object obj, boolean flag, String s, float f, float f1, float f2, 
            int j, float f3)
    {
        Command = i;
        intArgs = new int[1];
        floatArgs = new float[4];
        boolArgs = new boolean[1];
        stringArgs = new String[1];
        objectArgs = new Object[1];
        intArgs[0] = j;
        floatArgs[0] = f;
        floatArgs[1] = f1;
        floatArgs[2] = f2;
        floatArgs[3] = f3;
        boolArgs[0] = flag;
        stringArgs[0] = s;
        objectArgs[0] = obj;
    }

    public static final int INITIALIZE = 1;
    public static final int LOAD_SOUND = 2;
    public static final int UNLOAD_SOUND = 4;
    public static final int QUEUE_SOUND = 5;
    public static final int DEQUEUE_SOUND = 6;
    public static final int FADE_OUT = 7;
    public static final int FADE_OUT_IN = 8;
    public static final int CHECK_FADE_VOLUMES = 9;
    public static final int NEW_SOURCE = 10;
    public static final int RAW_DATA_STREAM = 11;
    public static final int QUICK_PLAY = 12;
    public static final int SET_POSITION = 13;
    public static final int SET_VOLUME = 14;
    public static final int SET_PITCH = 15;
    public static final int SET_PRIORITY = 16;
    public static final int SET_LOOPING = 17;
    public static final int SET_ATTENUATION = 18;
    public static final int SET_DIST_OR_ROLL = 19;
    public static final int PLAY = 21;
    public static final int FEED_RAW_AUDIO_DATA = 22;
    public static final int PAUSE = 23;
    public static final int STOP = 24;
    public static final int REWIND = 25;
    public static final int FLUSH = 26;
    public static final int CULL = 27;
    public static final int ACTIVATE = 28;
    public static final int SET_TEMPORARY = 29;
    public static final int REMOVE_SOURCE = 30;
    public static final int MOVE_LISTENER = 31;
    public static final int SET_LISTENER_POSITION = 32;
    public static final int TURN_LISTENER = 33;
    public static final int SET_LISTENER_ANGLE = 34;
    public static final int SET_LISTENER_ORIENTATION = 35;
    public static final int SET_MASTER_VOLUME = 36;
    public static final int NEW_LIBRARY = 37;
    public byte buffer[];
    public int intArgs[];
    public float floatArgs[];
    public long longArgs[];
    public boolean boolArgs[];
    public String stringArgs[];
    public Class classArgs[];
    public Object objectArgs[];
    public int Command;
}
