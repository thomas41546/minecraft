// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import java.net.URL;
import javax.sound.sampled.AudioFormat;

// Referenced classes of package paulscode.sound:
//            SoundBuffer

public interface ICodec
{

    public abstract void reverseByteOrder(boolean flag);

    public abstract boolean initialize(URL url);

    public abstract boolean initialized();

    public abstract SoundBuffer read();

    public abstract SoundBuffer readAll();

    public abstract boolean endOfStream();

    public abstract void cleanup();

    public abstract AudioFormat getAudioFormat();
}
