// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound.libraries;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import javax.sound.sampled.AudioFormat;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import paulscode.sound.*;

// Referenced classes of package paulscode.sound.libraries:
//            ChannelLWJGLOpenAL, LibraryLWJGLOpenAL

public class SourceLWJGLOpenAL extends Source
{

    public SourceLWJGLOpenAL(FloatBuffer floatbuffer, IntBuffer intbuffer, boolean flag, boolean flag1, boolean flag2, String s, FilenameURL filenameurl, 
            SoundBuffer soundbuffer, float f, float f1, float f2, int i, float f3, boolean flag3)
    {
        super(flag, flag1, flag2, s, filenameurl, soundbuffer, f, f1, f2, i, f3, flag3);
        channelOpenAL = (ChannelLWJGLOpenAL)channel;
        reverseByteOrder = true;
        if(codec != null)
            codec.reverseByteOrder(true);
        listenerPosition = floatbuffer;
        myBuffer = intbuffer;
        libraryType = paulscode/sound/libraries/LibraryLWJGLOpenAL;
        pitch = 1.0F;
        resetALInformation();
    }

    public SourceLWJGLOpenAL(FloatBuffer floatbuffer, IntBuffer intbuffer, Source source, SoundBuffer soundbuffer)
    {
        super(source, soundbuffer);
        channelOpenAL = (ChannelLWJGLOpenAL)channel;
        reverseByteOrder = true;
        if(codec != null)
            codec.reverseByteOrder(true);
        listenerPosition = floatbuffer;
        myBuffer = intbuffer;
        libraryType = paulscode/sound/libraries/LibraryLWJGLOpenAL;
        pitch = 1.0F;
        resetALInformation();
    }

    public SourceLWJGLOpenAL(FloatBuffer floatbuffer, AudioFormat audioformat, boolean flag, String s, float f, float f1, float f2, 
            int i, float f3)
    {
        super(audioformat, flag, s, f, f1, f2, i, f3);
        channelOpenAL = (ChannelLWJGLOpenAL)channel;
        reverseByteOrder = true;
        listenerPosition = floatbuffer;
        libraryType = paulscode/sound/libraries/LibraryLWJGLOpenAL;
        pitch = 1.0F;
        resetALInformation();
    }

    public void cleanup()
    {
        super.cleanup();
    }

    public void changeSource(FloatBuffer floatbuffer, IntBuffer intbuffer, boolean flag, boolean flag1, boolean flag2, String s, FilenameURL filenameurl, 
            SoundBuffer soundbuffer, float f, float f1, float f2, int i, float f3, boolean flag3)
    {
        super.changeSource(flag, flag1, flag2, s, filenameurl, soundbuffer, f, f1, f2, i, f3, flag3);
        reverseByteOrder = true;
        listenerPosition = floatbuffer;
        myBuffer = intbuffer;
        pitch = 1.0F;
        resetALInformation();
    }

    public boolean incrementSoundSequence()
    {
        if(!toStream)
        {
            errorMessage("Method 'incrementSoundSequence' may only be used for streaming sources.");
            return false;
        }
        Object obj = soundSequenceLock;
        JVM INSTR monitorenter ;
        if(soundSequenceQueue == null || soundSequenceQueue.size() <= 0) goto _L2; else goto _L1
_L1:
        AudioFormat audioformat;
        filenameURL = (FilenameURL)soundSequenceQueue.remove(0);
        if(codec != null)
            codec.cleanup();
        codec = SoundSystemConfig.getCodec(filenameURL.getFilename());
        if(codec == null)
            break MISSING_BLOCK_LABEL_284;
        codec.reverseByteOrder(true);
        if(codec.getAudioFormat() == null)
            codec.initialize(filenameURL.getURL());
        audioformat = codec.getAudioFormat();
        if(audioformat != null)
            break MISSING_BLOCK_LABEL_154;
        errorMessage("Audio Format null in method 'incrementSoundSequence'");
        return false;
        char c = '\0';
        if(audioformat.getChannels() != 1) goto _L4; else goto _L3
_L3:
        if(audioformat.getSampleSizeInBits() != 8) goto _L6; else goto _L5
_L5:
        c = '\u1100';
          goto _L7
_L6:
        if(audioformat.getSampleSizeInBits() != 16) goto _L9; else goto _L8
_L8:
        c = '\u1101';
          goto _L7
_L9:
        errorMessage("Illegal sample size in method 'incrementSoundSequence'");
        false;
        obj;
        JVM INSTR monitorexit ;
        return;
_L4:
        if(audioformat.getChannels() != 2) goto _L11; else goto _L10
_L10:
        if(audioformat.getSampleSizeInBits() != 8) goto _L13; else goto _L12
_L12:
        c = '\u1102';
          goto _L7
_L13:
        if(audioformat.getSampleSizeInBits() != 16) goto _L15; else goto _L14
_L14:
        c = '\u1103';
          goto _L7
_L15:
        errorMessage("Illegal sample size in method 'incrementSoundSequence'");
        false;
        obj;
        JVM INSTR monitorexit ;
        return;
_L11:
        errorMessage("Audio data neither mono nor stereo in method 'incrementSoundSequence'");
        false;
        obj;
        JVM INSTR monitorexit ;
        return;
_L7:
        channelOpenAL.setFormat(((int) (c)), (int)audioformat.getSampleRate());
        preLoad = true;
        true;
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj;
        JVM INSTR monitorexit ;
          goto _L16
        Exception exception;
        exception;
        throw exception;
_L16:
        return false;
    }

    public void listenerMoved()
    {
        positionChanged();
    }

    public void setPosition(float f, float f1, float f2)
    {
        super.setPosition(f, f1, f2);
        if(sourcePosition == null)
            resetALInformation();
        else
            positionChanged();
        sourcePosition.put(0, f);
        sourcePosition.put(1, f1);
        sourcePosition.put(2, f2);
        if(channel != null && channel.attachedSource == this && channelOpenAL != null && channelOpenAL.ALSource != null)
        {
            AL10.alSource(channelOpenAL.ALSource.get(0), 4100, sourcePosition);
            checkALError();
        }
    }

    public void positionChanged()
    {
        calculateDistance();
        calculateGain();
        if(channel != null && channel.attachedSource == this && channelOpenAL != null && channelOpenAL.ALSource != null)
        {
            AL10.alSourcef(channelOpenAL.ALSource.get(0), 4106, gain * sourceVolume * Math.abs(fadeOutGain) * fadeInGain);
            checkALError();
        }
        checkPitch();
    }

    private void checkPitch()
    {
        if(channel != null && channel.attachedSource == this && LibraryLWJGLOpenAL.alPitchSupported() && channelOpenAL != null && channelOpenAL.ALSource != null)
        {
            AL10.alSourcef(channelOpenAL.ALSource.get(0), 4099, pitch);
            checkALError();
        }
    }

    public void setLooping(boolean flag)
    {
        super.setLooping(flag);
        if(channel != null && channel.attachedSource == this && channelOpenAL != null && channelOpenAL.ALSource != null)
        {
            if(flag)
                AL10.alSourcei(channelOpenAL.ALSource.get(0), 4103, 1);
            else
                AL10.alSourcei(channelOpenAL.ALSource.get(0), 4103, 0);
            checkALError();
        }
    }

    public void setAttenuation(int i)
    {
        super.setAttenuation(i);
        if(channel != null && channel.attachedSource == this && channelOpenAL != null && channelOpenAL.ALSource != null)
        {
            if(i == 1)
                AL10.alSourcef(channelOpenAL.ALSource.get(0), 4129, distOrRoll);
            else
                AL10.alSourcef(channelOpenAL.ALSource.get(0), 4129, 0.0F);
            checkALError();
        }
    }

    public void setDistOrRoll(float f)
    {
        super.setDistOrRoll(f);
        if(channel != null && channel.attachedSource == this && channelOpenAL != null && channelOpenAL.ALSource != null)
        {
            if(attModel == 1)
                AL10.alSourcef(channelOpenAL.ALSource.get(0), 4129, f);
            else
                AL10.alSourcef(channelOpenAL.ALSource.get(0), 4129, 0.0F);
            checkALError();
        }
    }

    public void setPitch(float f)
    {
        super.setPitch(f);
        checkPitch();
    }

    public void play(Channel channel)
    {
        if(!active())
        {
            if(toLoop)
                toPlay = true;
            return;
        }
        if(channel == null)
        {
            errorMessage("Unable to play source, because channel was null");
            return;
        }
        boolean flag = this.channel != channel;
        if(this.channel != null && this.channel.attachedSource != this)
            flag = true;
        boolean flag1 = paused();
        super.play(channel);
        channelOpenAL = (ChannelLWJGLOpenAL)this.channel;
        if(flag)
        {
            setPosition(position.x, position.y, position.z);
            checkPitch();
            if(channelOpenAL != null && channelOpenAL.ALSource != null)
            {
                if(LibraryLWJGLOpenAL.alPitchSupported())
                {
                    AL10.alSourcef(channelOpenAL.ALSource.get(0), 4099, pitch);
                    checkALError();
                }
                AL10.alSource(channelOpenAL.ALSource.get(0), 4100, sourcePosition);
                checkALError();
                AL10.alSource(channelOpenAL.ALSource.get(0), 4102, sourceVelocity);
                checkALError();
                if(attModel == 1)
                    AL10.alSourcef(channelOpenAL.ALSource.get(0), 4129, distOrRoll);
                else
                    AL10.alSourcef(channelOpenAL.ALSource.get(0), 4129, 0.0F);
                checkALError();
                if(toLoop && !toStream)
                    AL10.alSourcei(channelOpenAL.ALSource.get(0), 4103, 1);
                else
                    AL10.alSourcei(channelOpenAL.ALSource.get(0), 4103, 0);
                checkALError();
            }
            if(!toStream)
            {
                if(myBuffer == null)
                {
                    errorMessage("No sound buffer to play");
                    return;
                }
                channelOpenAL.attachBuffer(myBuffer);
            }
        }
        if(!playing())
        {
            if(toStream && !flag1)
            {
                if(codec == null)
                {
                    errorMessage("Decoder null in method 'play'");
                    return;
                }
                if(codec.getAudioFormat() == null)
                    codec.initialize(filenameURL.getURL());
                AudioFormat audioformat = codec.getAudioFormat();
                if(audioformat == null)
                {
                    errorMessage("Audio Format null in method 'play'");
                    return;
                }
                char c = '\0';
                if(audioformat.getChannels() == 1)
                {
                    if(audioformat.getSampleSizeInBits() == 8)
                        c = '\u1100';
                    else
                    if(audioformat.getSampleSizeInBits() == 16)
                    {
                        c = '\u1101';
                    } else
                    {
                        errorMessage("Illegal sample size in method 'play'");
                        return;
                    }
                } else
                if(audioformat.getChannels() == 2)
                {
                    if(audioformat.getSampleSizeInBits() == 8)
                        c = '\u1102';
                    else
                    if(audioformat.getSampleSizeInBits() == 16)
                    {
                        c = '\u1103';
                    } else
                    {
                        errorMessage("Illegal sample size in method 'play'");
                        return;
                    }
                } else
                {
                    errorMessage("Audio data neither mono nor stereo in method 'play'");
                    return;
                }
                channelOpenAL.setFormat(((int) (c)), (int)audioformat.getSampleRate());
                preLoad = true;
            }
            this.channel.play();
            if(pitch != 1.0F)
                checkPitch();
        }
    }

    public boolean preLoad()
    {
        if(codec == null)
            return false;
        codec.initialize(filenameURL.getURL());
        LinkedList linkedlist = new LinkedList();
        int i = 0;
        do
        {
            if(i >= SoundSystemConfig.getNumberStreamingBuffers())
                break;
            soundBuffer = codec.read();
            if(soundBuffer == null || soundBuffer.audioData == null)
                break;
            linkedlist.add(((Object) (soundBuffer.audioData)));
            i++;
        } while(true);
        positionChanged();
        channel.preLoadBuffers(linkedlist);
        preLoad = false;
        return true;
    }

    private void resetALInformation()
    {
        sourcePosition = BufferUtils.createFloatBuffer(3).put(new float[] {
            position.x, position.y, position.z
        });
        sourceVelocity = BufferUtils.createFloatBuffer(3).put(new float[] {
            0.0F, 0.0F, 0.0F
        });
        sourcePosition.flip();
        sourceVelocity.flip();
        positionChanged();
    }

    private void calculateDistance()
    {
        if(listenerPosition != null)
        {
            double d = position.x - listenerPosition.get(0);
            double d1 = position.y - listenerPosition.get(1);
            double d2 = position.z - listenerPosition.get(2);
            distanceFromListener = (float)Math.sqrt(d * d + d1 * d1 + d2 * d2);
        }
    }

    private void calculateGain()
    {
        if(attModel == 2)
        {
            if(distanceFromListener <= 0.0F)
                gain = 1.0F;
            else
            if(distanceFromListener >= distOrRoll)
                gain = 0.0F;
            else
                gain = 1.0F - distanceFromListener / distOrRoll;
            if(gain > 1.0F)
                gain = 1.0F;
            if(gain < 0.0F)
                gain = 0.0F;
        } else
        {
            gain = 1.0F;
        }
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

    private ChannelLWJGLOpenAL channelOpenAL;
    private IntBuffer myBuffer;
    private FloatBuffer listenerPosition;
    private FloatBuffer sourcePosition;
    private FloatBuffer sourceVelocity;
}
