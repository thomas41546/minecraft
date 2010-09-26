// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound.libraries;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import javax.sound.sampled.AudioFormat;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import paulscode.sound.Channel;
import paulscode.sound.Source;

// Referenced classes of package paulscode.sound.libraries:
//            LibraryLWJGLOpenAL

public class ChannelLWJGLOpenAL extends Channel
{

    public ChannelLWJGLOpenAL(int i, IntBuffer intbuffer)
    {
        super(i);
        bufferBuffer = BufferUtils.createByteBuffer(0x500000);
        libraryType = paulscode/sound/libraries/LibraryLWJGLOpenAL;
        ALSource = intbuffer;
    }

    public void cleanup()
    {
        if(ALSource != null)
        {
            try
            {
                AL10.alSourceStop(ALSource);
                AL10.alGetError();
            }
            catch(Exception exception) { }
            try
            {
                AL10.alDeleteSources(ALSource);
                AL10.alGetError();
            }
            catch(Exception exception1) { }
            ALSource.clear();
        }
        ALSource = null;
        super.cleanup();
    }

    public boolean attachBuffer(IntBuffer intbuffer)
    {
        if(errorCheck(channelType != 0, "Sound buffers may only be attached to normal sources."))
        {
            return false;
        } else
        {
            AL10.alSourcei(ALSource.get(0), 4105, intbuffer.get(0));
            return checkALError();
        }
    }

    public void setAudioFormat(AudioFormat audioformat)
    {
        int i = 0;
        if(audioformat.getChannels() == 1)
        {
            if(audioformat.getSampleSizeInBits() == 8)
                i = 4352;
            else
            if(audioformat.getSampleSizeInBits() == 16)
            {
                i = 4353;
            } else
            {
                errorMessage("Illegal sample size in method 'setAudioFormat'");
                return;
            }
        } else
        if(audioformat.getChannels() == 2)
        {
            if(audioformat.getSampleSizeInBits() == 8)
                i = 4354;
            else
            if(audioformat.getSampleSizeInBits() == 16)
            {
                i = 4355;
            } else
            {
                errorMessage("Illegal sample size in method 'setAudioFormat'");
                return;
            }
        } else
        {
            errorMessage("Audio data neither mono nor stereo in method 'setAudioFormat'");
            return;
        }
        ALformat = i;
        sampleRate = (int)audioformat.getSampleRate();
    }

    public void setFormat(int i, int j)
    {
        ALformat = i;
        sampleRate = j;
    }

    public boolean preLoadBuffers(LinkedList linkedlist)
    {
        if(errorCheck(channelType != 1, "Buffers may only be queued for streaming sources."))
            return false;
        if(errorCheck(linkedlist == null, "Buffer List null in method 'preLoadBuffers'"))
            return false;
        boolean flag = playing();
        if(flag)
        {
            AL10.alSourceStop(ALSource.get(0));
            checkALError();
        }
        int i = AL10.alGetSourcei(ALSource.get(0), 4118);
        if(i > 0)
        {
            IntBuffer intbuffer = BufferUtils.createIntBuffer(i);
            AL10.alGenBuffers(intbuffer);
            if(errorCheck(checkALError(), "Error clearing stream buffers in method 'preLoadBuffers'"))
                return false;
            AL10.alSourceUnqueueBuffers(ALSource.get(0), intbuffer);
            if(errorCheck(checkALError(), "Error unqueuing stream buffers in method 'preLoadBuffers'"))
                return false;
        }
        if(flag)
        {
            AL10.alSourcePlay(ALSource.get(0));
            checkALError();
        }
        IntBuffer intbuffer1 = BufferUtils.createIntBuffer(linkedlist.size());
        AL10.alGenBuffers(intbuffer1);
        if(errorCheck(checkALError(), "Error generating stream buffers in method 'preLoadBuffers'"))
            return false;
        for(int j = 0; j < linkedlist.size(); j++)
        {
            bufferBuffer.clear();
            bufferBuffer.put((byte[])linkedlist.get(j), 0, ((byte[])linkedlist.get(j)).length);
            bufferBuffer.flip();
            try
            {
                AL10.alBufferData(intbuffer1.get(j), ALformat, bufferBuffer, sampleRate);
            }
            catch(Exception exception1)
            {
                errorMessage("Error creating buffers in method 'preLoadBuffers'");
                printStackTrace(exception1);
                return false;
            }
            if(errorCheck(checkALError(), "Error creating buffers in method 'preLoadBuffers'"))
                return false;
        }

        try
        {
            AL10.alSourceQueueBuffers(ALSource.get(0), intbuffer1);
        }
        catch(Exception exception)
        {
            errorMessage("Error queuing buffers in method 'preLoadBuffers'");
            printStackTrace(exception);
            return false;
        }
        if(errorCheck(checkALError(), "Error queuing buffers in method 'preLoadBuffers'"))
            return false;
        AL10.alSourcePlay(ALSource.get(0));
        return !errorCheck(checkALError(), "Error playing source in method 'preLoadBuffers'");
    }

    public boolean queueBuffer(byte abyte0[])
    {
        if(errorCheck(channelType != 1, "Buffers may only be queued for streaming sources."))
            return false;
        bufferBuffer.clear();
        bufferBuffer.put(abyte0, 0, abyte0.length);
        bufferBuffer.flip();
        IntBuffer intbuffer = BufferUtils.createIntBuffer(1);
        AL10.alSourceUnqueueBuffers(ALSource.get(0), intbuffer);
        if(checkALError())
            return false;
        AL10.alBufferData(intbuffer.get(0), ALformat, bufferBuffer, sampleRate);
        if(checkALError())
            return false;
        AL10.alSourceQueueBuffers(ALSource.get(0), intbuffer);
        return !checkALError();
    }

    public int feedRawAudioData(byte abyte0[])
    {
        if(errorCheck(channelType != 1, "Raw audio data can only be fed to streaming sources."))
            return -1;
        ByteBuffer bytebuffer = ByteBuffer.wrap(abyte0, 0, abyte0.length);
        int i = AL10.alGetSourcei(ALSource.get(0), 4118);
        IntBuffer intbuffer;
        if(i > 0)
        {
            intbuffer = BufferUtils.createIntBuffer(i);
            AL10.alGenBuffers(intbuffer);
            if(errorCheck(checkALError(), "Error clearing stream buffers in method 'feedRawAudioData'"))
                return -1;
            AL10.alSourceUnqueueBuffers(ALSource.get(0), intbuffer);
            if(errorCheck(checkALError(), "Error unqueuing stream buffers in method 'feedRawAudioData'"))
                return -1;
        } else
        {
            intbuffer = BufferUtils.createIntBuffer(1);
            AL10.alGenBuffers(intbuffer);
            if(errorCheck(checkALError(), "Error generating stream buffers in method 'preLoadBuffers'"))
                return -1;
        }
        AL10.alBufferData(intbuffer.get(0), ALformat, bytebuffer, sampleRate);
        if(checkALError())
            return -1;
        AL10.alSourceQueueBuffers(ALSource.get(0), intbuffer);
        if(checkALError())
            return -1;
        if(attachedSource != null && attachedSource.channel == this && attachedSource.active() && !playing())
        {
            AL10.alSourcePlay(ALSource.get(0));
            checkALError();
        }
        return i;
    }

    public int buffersProcessed()
    {
        if(channelType != 1)
            return 0;
        int i = AL10.alGetSourcei(ALSource.get(0), 4118);
        if(checkALError())
            return 0;
        else
            return i;
    }

    public void flush()
    {
        if(channelType != 1)
            return;
        int i = AL10.alGetSourcei(ALSource.get(0), 4117);
        if(checkALError())
            return;
        IntBuffer intbuffer = BufferUtils.createIntBuffer(1);
        for(; i > 0; i--)
        {
            try
            {
                AL10.alSourceUnqueueBuffers(ALSource.get(0), intbuffer);
            }
            catch(Exception exception)
            {
                return;
            }
            if(checkALError())
                return;
        }

    }

    public void close()
    {
        try
        {
            AL10.alSourceStop(ALSource.get(0));
            AL10.alGetError();
        }
        catch(Exception exception) { }
        if(channelType == 1)
            flush();
    }

    public void play()
    {
        AL10.alSourcePlay(ALSource.get(0));
        checkALError();
    }

    public void pause()
    {
        AL10.alSourcePause(ALSource.get(0));
        checkALError();
    }

    public void stop()
    {
        AL10.alSourceStop(ALSource.get(0));
        checkALError();
    }

    public void rewind()
    {
        if(channelType == 1)
        {
            return;
        } else
        {
            AL10.alSourceRewind(ALSource.get(0));
            checkALError();
            return;
        }
    }

    public boolean playing()
    {
        int i = AL10.alGetSourcei(ALSource.get(0), 4112);
        if(checkALError())
            return false;
        else
            return i == 4114;
    }

    private boolean checkALError()
    {
        switch(AL10.alGetError())
        {
        case 0: // '\0'
            return false;

        case 40961: 
            errorMessage("Invalid name parameter.");
            return true;

        case 40962: 
            errorMessage("Invalid parameter.");
            return true;

        case 40963: 
            errorMessage("Invalid enumerated parameter value.");
            return true;

        case 40964: 
            errorMessage("Illegal call.");
            return true;

        case 40965: 
            errorMessage("Unable to allocate memory.");
            return true;
        }
        errorMessage("An unrecognized error occurred.");
        return true;
    }

    public IntBuffer ALSource;
    public int ALformat;
    public int sampleRate;
    ByteBuffer bufferBuffer;
}
