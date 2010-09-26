// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound.codecs;

import com.jcraft.jogg.*;
import com.jcraft.jorbis.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import javax.sound.sampled.AudioFormat;
import paulscode.sound.*;

public class CodecJOrbis
    implements ICodec
{

    public CodecJOrbis()
    {
        urlConnection = null;
        endOfStream = false;
        initialized = false;
        buffer = null;
        count = 0;
        index = 0;
        joggPacket = new Packet();
        joggPage = new Page();
        joggStreamState = new StreamState();
        joggSyncState = new SyncState();
        jorbisDspState = new DspState();
        jorbisBlock = new Block(jorbisDspState);
        jorbisComment = new Comment();
        jorbisInfo = new Info();
        logger = SoundSystemConfig.getLogger();
    }

    public void reverseByteOrder(boolean flag)
    {
    }

    public boolean initialize(URL url1)
    {
        initialized(true, false);
        if(joggStreamState != null)
            joggStreamState.clear();
        if(jorbisBlock != null)
            jorbisBlock.clear();
        if(jorbisDspState != null)
            jorbisDspState.clear();
        if(jorbisInfo != null)
            jorbisInfo.clear();
        if(joggSyncState != null)
            joggSyncState.clear();
        if(inputStream != null)
            try
            {
                inputStream.close();
            }
            catch(IOException ioexception) { }
        url = url1;
        bufferSize = SoundSystemConfig.getStreamingBufferSize() / 2;
        buffer = null;
        count = 0;
        index = 0;
        joggStreamState = new StreamState();
        jorbisBlock = new Block(jorbisDspState);
        jorbisDspState = new DspState();
        jorbisInfo = new Info();
        joggSyncState = new SyncState();
        try
        {
            urlConnection = url1.openConnection();
        }
        catch(UnknownServiceException unknownserviceexception)
        {
            errorMessage("Unable to create a UrlConnection in method 'initialize'.");
            printStackTrace(((Exception) (unknownserviceexception)));
            cleanup();
            return false;
        }
        catch(IOException ioexception1)
        {
            errorMessage("Unable to create a UrlConnection in method 'initialize'.");
            printStackTrace(((Exception) (ioexception1)));
            cleanup();
            return false;
        }
        if(urlConnection != null)
            try
            {
                inputStream = openInputStream();
            }
            catch(IOException ioexception2)
            {
                errorMessage("Unable to acquire inputstream in method 'initialize'.");
                printStackTrace(((Exception) (ioexception2)));
                cleanup();
                return false;
            }
        endOfStream(true, false);
        joggSyncState.init();
        joggSyncState.buffer(bufferSize);
        buffer = joggSyncState.data;
        if(readHeader())
            break MISSING_BLOCK_LABEL_332;
        errorMessage("Error reading the header");
        return false;
        IOException ioexception3;
        ioexception3;
        errorMessage("Error reading the header");
        return false;
        convertedBufferSize = bufferSize * 2;
        jorbisDspState.synthesis_init(jorbisInfo);
        jorbisBlock.init(jorbisDspState);
        int i = jorbisInfo.channels;
        int j = jorbisInfo.rate;
        audioFormat = new AudioFormat(j, 16, i, true, false);
        pcmInfo = new float[1][][];
        pcmIndex = new int[jorbisInfo.channels];
        initialized(true, true);
        return true;
    }

    protected InputStream openInputStream()
    {
        return urlConnection.getInputStream();
    }

    public boolean initialized()
    {
        return initialized(false, false);
    }

    public SoundBuffer read()
    {
        byte abyte0[] = readBytes();
        if(abyte0 == null)
            return null;
        else
            return new SoundBuffer(abyte0, audioFormat);
    }

    public SoundBuffer readAll()
    {
        byte abyte0[] = readBytes();
        do
        {
            if(endOfStream(false, false))
                break;
            abyte0 = appendByteArrays(abyte0, readBytes());
        } while(abyte0 == null || abyte0.length < SoundSystemConfig.getMaxFileSize());
        return new SoundBuffer(abyte0, audioFormat);
    }

    public boolean endOfStream()
    {
        return endOfStream(false, false);
    }

    public void cleanup()
    {
        joggStreamState.clear();
        jorbisBlock.clear();
        jorbisDspState.clear();
        jorbisInfo.clear();
        joggSyncState.clear();
        if(inputStream != null)
            try
            {
                inputStream.close();
            }
            catch(IOException ioexception) { }
        joggStreamState = null;
        jorbisBlock = null;
        jorbisDspState = null;
        jorbisInfo = null;
        joggSyncState = null;
        inputStream = null;
    }

    public AudioFormat getAudioFormat()
    {
        return audioFormat;
    }

    private boolean readHeader()
    {
        int k;
        index = joggSyncState.buffer(bufferSize);
        int i = inputStream.read(joggSyncState.data, index, bufferSize);
        if(i < 0)
            i = 0;
        joggSyncState.wrote(i);
        if(joggSyncState.pageout(joggPage) != 1)
            if(i < bufferSize)
            {
                return true;
            } else
            {
                errorMessage("Ogg header not recognized in method 'readHeader'.");
                return false;
            }
        joggStreamState.init(joggPage.serialno());
        jorbisInfo.init();
        jorbisComment.init();
        if(joggStreamState.pagein(joggPage) < 0)
        {
            errorMessage("Problem with first Ogg header page in method 'readHeader'.");
            return false;
        }
        if(joggStreamState.packetout(joggPacket) != 1)
        {
            errorMessage("Problem with first Ogg header packet in method 'readHeader'.");
            return false;
        }
        if(jorbisInfo.synthesis_headerin(jorbisComment, joggPacket) < 0)
        {
            errorMessage("File does not contain Vorbis header in method 'readHeader'.");
            return false;
        }
        k = 0;
_L6:
        if(k >= 2) goto _L2; else goto _L1
_L1:
        int l;
        do
        {
            if(k >= 2)
                break MISSING_BLOCK_LABEL_295;
            l = joggSyncState.pageout(joggPage);
            if(l == 0)
                break MISSING_BLOCK_LABEL_295;
        } while(l != 1);
        joggStreamState.pagein(joggPage);
_L5:
        if(k >= 2) goto _L1; else goto _L3
_L3:
        int i1 = joggStreamState.packetout(joggPacket);
        if(i1 != 0) goto _L4; else goto _L1
_L4:
        if(i1 == -1)
        {
            errorMessage("Secondary Ogg header corrupt in method 'readHeader'.");
            return false;
        }
        jorbisInfo.synthesis_headerin(jorbisComment, joggPacket);
        k++;
          goto _L5
        index = joggSyncState.buffer(bufferSize);
        int j = inputStream.read(joggSyncState.data, index, bufferSize);
        if(j < 0)
            j = 0;
        if(j == 0 && k < 2)
        {
            errorMessage("End of file reached before finished readingOgg header in method 'readHeader'");
            return false;
        }
        joggSyncState.wrote(j);
          goto _L6
_L2:
        index = joggSyncState.buffer(bufferSize);
        buffer = joggSyncState.data;
        return true;
    }

    private byte[] readBytes()
    {
        if(!initialized(false, false))
            return null;
        if(endOfStream(false, false))
            return null;
        byte abyte0[] = null;
        switch(joggSyncState.pageout(joggPage))
        {
        case -1: 
        case 0: // '\0'
            endOfStream(true, true);
            break;

        case 1: // '\001'
            joggStreamState.pagein(joggPage);
            if(joggPage.granulepos() == 0L)
            {
                endOfStream(true, true);
            } else
            {
label0:
                do
                    switch(joggStreamState.packetout(joggPacket))
                    {
                    default:
                        break;

                    case -1: 
                    case 0: // '\0'
                        break label0;

                    case 1: // '\001'
                        abyte0 = appendByteArrays(abyte0, decodeCurrentPacket());
                        break;
                    }
                while(true);
                if(joggPage.eos() != 0)
                    endOfStream(true, true);
            }
            break;
        }
        if(!endOfStream(false, false))
        {
            index = joggSyncState.buffer(bufferSize);
            if(index == -1)
            {
                endOfStream(true, true);
            } else
            {
                buffer = joggSyncState.data;
                try
                {
                    count = inputStream.read(buffer, index, bufferSize);
                }
                catch(Exception exception)
                {
                    printStackTrace(exception);
                    return abyte0;
                }
                joggSyncState.wrote(count);
                if(count == 0)
                    endOfStream(true, true);
            }
        }
        return abyte0;
    }

    private byte[] decodeCurrentPacket()
    {
        byte abyte0[] = new byte[convertedBufferSize];
        if(jorbisBlock.synthesis(joggPacket) == 0)
            jorbisDspState.synthesis_blockin(jorbisBlock);
        int k = convertedBufferSize / (jorbisInfo.channels * 2);
        int i;
        int l;
        for(l = 0; l < convertedBufferSize && (i = jorbisDspState.synthesis_pcmout(pcmInfo, pcmIndex)) > 0;)
        {
            int j;
            if(i < k)
                j = i;
            else
                j = k;
            for(int i1 = 0; i1 < jorbisInfo.channels; i1++)
            {
                int j1 = i1 * 2;
                for(int k1 = 0; k1 < j; k1++)
                {
                    int l1 = (int)(pcmInfo[0][i1][pcmIndex[i1] + k1] * 32767F);
                    if(l1 > 32767)
                        l1 = 32767;
                    if(l1 < -32768)
                        l1 = -32768;
                    if(l1 < 0)
                        l1 |= 0x8000;
                    abyte0[l + j1] = (byte)l1;
                    abyte0[l + j1 + 1] = (byte)(l1 >>> 8);
                    j1 += 2 * jorbisInfo.channels;
                }

            }

            l += j * jorbisInfo.channels * 2;
            jorbisDspState.synthesis_read(j);
        }

        abyte0 = trimArray(abyte0, l);
        return abyte0;
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

    private static byte[] appendByteArrays(byte abyte0[], byte abyte1[])
    {
        if(abyte0 == null && abyte1 == null)
            return null;
        byte abyte2[];
        if(abyte0 == null)
        {
            abyte2 = new byte[abyte1.length];
            System.arraycopy(((Object) (abyte1)), 0, ((Object) (abyte2)), 0, abyte1.length);
            abyte1 = null;
        } else
        if(abyte1 == null)
        {
            abyte2 = new byte[abyte0.length];
            System.arraycopy(((Object) (abyte0)), 0, ((Object) (abyte2)), 0, abyte0.length);
            abyte0 = null;
        } else
        {
            abyte2 = new byte[abyte0.length + abyte1.length];
            System.arraycopy(((Object) (abyte0)), 0, ((Object) (abyte2)), 0, abyte0.length);
            System.arraycopy(((Object) (abyte1)), 0, ((Object) (abyte2)), abyte0.length, abyte1.length);
            abyte0 = null;
            abyte1 = null;
        }
        return abyte2;
    }

    private void errorMessage(String s)
    {
        logger.errorMessage("CodecJOrbis", s, 0);
    }

    private void printStackTrace(Exception exception)
    {
        logger.printStackTrace(exception, 1);
    }

    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    protected URL url;
    protected URLConnection urlConnection;
    private InputStream inputStream;
    private AudioFormat audioFormat;
    private boolean endOfStream;
    private boolean initialized;
    private byte buffer[];
    private int bufferSize;
    private int count;
    private int index;
    private int convertedBufferSize;
    private float pcmInfo[][][];
    private int pcmIndex[];
    private Packet joggPacket;
    private Page joggPage;
    private StreamState joggStreamState;
    private SyncState joggSyncState;
    private DspState jorbisDspState;
    private Block jorbisBlock;
    private Comment jorbisComment;
    private Info jorbisInfo;
    private SoundSystemLogger logger;
}
