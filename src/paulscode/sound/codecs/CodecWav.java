// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound.codecs;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.*;
import javax.sound.sampled.*;
import paulscode.sound.*;

public class CodecWav
    implements ICodec
{

    public void reverseByteOrder(boolean flag)
    {
    }

    public CodecWav()
    {
        endOfStream = false;
        initialized = false;
        myAudioInputStream = null;
        logger = SoundSystemConfig.getLogger();
    }

    public boolean initialize(URL url)
    {
        initialized(true, false);
        cleanup();
        if(url == null)
        {
            errorMessage("url null in method 'initialize'");
            cleanup();
            return false;
        }
        try
        {
            myAudioInputStream = AudioSystem.getAudioInputStream(((java.io.InputStream) (new BufferedInputStream(url.openStream()))));
        }
        catch(UnsupportedAudioFileException unsupportedaudiofileexception)
        {
            errorMessage("Unsupported audio format in method 'initialize'");
            printStackTrace(((Exception) (unsupportedaudiofileexception)));
            return false;
        }
        catch(IOException ioexception)
        {
            errorMessage("Error setting up audio input stream in method 'initialize'");
            printStackTrace(((Exception) (ioexception)));
            return false;
        }
        endOfStream(true, false);
        initialized(true, true);
        return true;
    }

    public boolean initialized()
    {
        return initialized(false, false);
    }

    public SoundBuffer read()
    {
        if(myAudioInputStream == null)
            return null;
        AudioFormat audioformat = myAudioInputStream.getFormat();
        if(audioformat == null)
        {
            errorMessage("Audio Format null in method 'read'");
            return null;
        }
        int i = 0;
        boolean flag = false;
        byte abyte0[] = new byte[SoundSystemConfig.getStreamingBufferSize()];
        try
        {
            do
            {
                if(endOfStream(false, false) || i >= abyte0.length)
                    break;
                int j;
                if((j = myAudioInputStream.read(abyte0, i, abyte0.length - i)) <= 0)
                {
                    endOfStream(true, true);
                    break;
                }
                i += j;
            } while(true);
        }
        catch(IOException ioexception)
        {
            endOfStream(true, true);
            return null;
        }
        if(i <= 0)
            return null;
        if(i < abyte0.length)
            abyte0 = trimArray(abyte0, i);
        byte abyte1[] = convertAudioBytes(abyte0, audioformat.getSampleSizeInBits() == 16);
        SoundBuffer soundbuffer = new SoundBuffer(abyte1, audioformat);
        return soundbuffer;
    }

    public SoundBuffer readAll()
    {
        if(myAudioInputStream == null)
        {
            errorMessage("Audio input stream null in method 'readAll'");
            return null;
        }
        AudioFormat audioformat = myAudioInputStream.getFormat();
        if(audioformat == null)
        {
            errorMessage("Audio Format null in method 'readAll'");
            return null;
        }
        byte abyte0[] = null;
        int i = (audioformat.getChannels() * (int)myAudioInputStream.getFrameLength() * audioformat.getSampleSizeInBits()) / 8;
        if(i > 0)
        {
            abyte0 = new byte[(audioformat.getChannels() * (int)myAudioInputStream.getFrameLength() * audioformat.getSampleSizeInBits()) / 8];
            int j = 0;
            int l = 0;
            try
            {
                while((j = myAudioInputStream.read(abyte0, l, abyte0.length - l)) != -1 && l < abyte0.length) 
                    l += j;
            }
            catch(IOException ioexception)
            {
                errorMessage("Exception thrown while reading from the AudioInputStream (location #1).");
                printStackTrace(((Exception) (ioexception)));
                return null;
            }
        } else
        {
            int k = 0;
            boolean flag = false;
            boolean flag1 = false;
            byte abyte2[] = null;
            abyte2 = new byte[SoundSystemConfig.getFileChunkSize()];
            while(!endOfStream(false, false) && k < SoundSystemConfig.getMaxFileSize()) 
            {
                int i1 = 0;
                boolean flag2 = false;
                try
                {
                    do
                    {
                        if(i1 >= abyte2.length)
                            break;
                        int j1;
                        if((j1 = myAudioInputStream.read(abyte2, i1, abyte2.length - i1)) <= 0)
                        {
                            endOfStream(true, true);
                            break;
                        }
                        i1 += j1;
                    } while(true);
                }
                catch(IOException ioexception2)
                {
                    errorMessage("Exception thrown while reading from the AudioInputStream (location #2).");
                    printStackTrace(((Exception) (ioexception2)));
                    return null;
                }
                k += i1;
                abyte0 = appendByteArrays(abyte0, abyte2, i1);
            }
        }
        byte abyte1[] = convertAudioBytes(abyte0, audioformat.getSampleSizeInBits() == 16);
        SoundBuffer soundbuffer = new SoundBuffer(abyte1, audioformat);
        try
        {
            myAudioInputStream.close();
        }
        catch(IOException ioexception1) { }
        return soundbuffer;
    }

    public boolean endOfStream()
    {
        return endOfStream(false, false);
    }

    public void cleanup()
    {
        if(myAudioInputStream != null)
            try
            {
                myAudioInputStream.close();
            }
            catch(Exception exception) { }
        myAudioInputStream = null;
    }

    public AudioFormat getAudioFormat()
    {
        if(myAudioInputStream == null)
            return null;
        else
            return myAudioInputStream.getFormat();
    }

    private synchronized boolean initialized(boolean flag, boolean flag1)
    {
        if(flag)
            initialized = flag1;
        return initialized;
    }

    private synchronized boolean endOfStream(boolean flag, boolean flag1)
    {
        if(flag)
            endOfStream = flag1;
        return endOfStream;
    }

    private static byte[] trimArray(byte abyte0[], int i)
    {
        byte abyte1[] = null;
        if(abyte0 != null && abyte0.length > i)
        {
            abyte1 = new byte[i];
            System.arraycopy(((Object) (abyte0)), 0, ((Object) (abyte1)), 0, i);
        }
        return abyte1;
    }

    private static byte[] convertAudioBytes(byte abyte0[], boolean flag)
    {
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(abyte0.length);
        bytebuffer.order(ByteOrder.nativeOrder());
        ByteBuffer bytebuffer1 = ByteBuffer.wrap(abyte0);
        bytebuffer1.order(ByteOrder.LITTLE_ENDIAN);
        if(flag)
        {
            ShortBuffer shortbuffer = bytebuffer.asShortBuffer();
            for(ShortBuffer shortbuffer1 = bytebuffer1.asShortBuffer(); shortbuffer1.hasRemaining(); shortbuffer.put(shortbuffer1.get()));
        } else
        {
            for(; bytebuffer1.hasRemaining(); bytebuffer.put(bytebuffer1.get()));
        }
        bytebuffer.rewind();
        if(!bytebuffer.hasArray())
        {
            byte abyte1[] = new byte[bytebuffer.capacity()];
            bytebuffer.get(abyte1);
            bytebuffer.clear();
            return abyte1;
        } else
        {
            return bytebuffer.array();
        }
    }

    private static byte[] appendByteArrays(byte abyte0[], byte abyte1[], int i)
    {
        if(abyte0 == null && abyte1 == null)
            return null;
        byte abyte2[];
        if(abyte0 == null)
        {
            abyte2 = new byte[i];
            System.arraycopy(((Object) (abyte1)), 0, ((Object) (abyte2)), 0, i);
            abyte1 = null;
        } else
        if(abyte1 == null)
        {
            abyte2 = new byte[abyte0.length];
            System.arraycopy(((Object) (abyte0)), 0, ((Object) (abyte2)), 0, abyte0.length);
            abyte0 = null;
        } else
        {
            abyte2 = new byte[abyte0.length + i];
            System.arraycopy(((Object) (abyte0)), 0, ((Object) (abyte2)), 0, abyte0.length);
            System.arraycopy(((Object) (abyte1)), 0, ((Object) (abyte2)), abyte0.length, i);
            abyte0 = null;
            abyte1 = null;
        }
        return abyte2;
    }

    private void errorMessage(String s)
    {
        logger.errorMessage("CodecWav", s, 0);
    }

    private void printStackTrace(Exception exception)
    {
        logger.printStackTrace(exception, 1);
    }

    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private boolean endOfStream;
    private boolean initialized;
    private AudioInputStream myAudioInputStream;
    private SoundSystemLogger logger;
}
