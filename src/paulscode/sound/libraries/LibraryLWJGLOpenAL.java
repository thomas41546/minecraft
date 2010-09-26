// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound.libraries;

import java.nio.*;
import java.util.*;
import javax.sound.sampled.AudioFormat;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import paulscode.sound.*;

// Referenced classes of package paulscode.sound.libraries:
//            ChannelLWJGLOpenAL, SourceLWJGLOpenAL

public class LibraryLWJGLOpenAL extends Library
{

    public LibraryLWJGLOpenAL()
    {
        listenerPositionAL = null;
        listenerOrientation = null;
        listenerVelocity = null;
        ALBufferMap = null;
        ALBufferMap = new HashMap();
    }

    public void init()
    {
        boolean flag = false;
        try
        {
            AL.create();
            flag = checkALError();
        }
        catch(LWJGLException lwjglexception)
        {
            errorMessage("Unable to initialize OpenAL.  Probable cause: OpenAL not supported.");
            printStackTrace(((Exception) (lwjglexception)));
            throw new SoundSystemException(lwjglexception.getMessage(), 6);
        }
        if(flag)
            importantMessage("OpenAL did not initialize properly!");
        else
            message("OpenAL initialized.");
        listenerPositionAL = BufferUtils.createFloatBuffer(3).put(new float[] {
            listener.position.x, listener.position.y, listener.position.z
        });
        listenerOrientation = BufferUtils.createFloatBuffer(6).put(new float[] {
            listener.lookAt.x, listener.lookAt.y, listener.lookAt.z, listener.up.x, listener.up.y, listener.up.z
        });
        listenerVelocity = BufferUtils.createFloatBuffer(3).put(new float[] {
            0.0F, 0.0F, 0.0F
        });
        listenerPositionAL.flip();
        listenerOrientation.flip();
        listenerVelocity.flip();
        AL10.alListener(4100, listenerPositionAL);
        flag = checkALError() || flag;
        AL10.alListener(4111, listenerOrientation);
        flag = checkALError() || flag;
        AL10.alListener(4102, listenerVelocity);
        flag = checkALError() || flag;
        if(flag)
        {
            importantMessage("OpenAL did not initialize properly!");
            throw new SoundSystemException("Problem encountered while loading OpenAL or creating the listener.  Probably cause:  OpenAL not supported", 6);
        }
        super.init();
        ChannelLWJGLOpenAL channellwjglopenal = (ChannelLWJGLOpenAL)normalChannels.get(1);
        try
        {
            AL10.alSourcef(channellwjglopenal.ALSource.get(0), 4099, 1.0F);
            if(checkALError())
            {
                alPitchSupported(true, false);
                throw new SoundSystemException("OpenAL: AL_PITCH not supported.", 13);
            }
            alPitchSupported(true, true);
        }
        catch(Exception exception)
        {
            alPitchSupported(true, false);
            throw new SoundSystemException("OpenAL: AL_PITCH not supported.", 13);
        }
    }

    public static boolean libraryCompatible()
    {
        if(AL.isCreated())
            return true;
        try
        {
            AL.create();
        }
        catch(Exception exception)
        {
            return false;
        }
        try
        {
            AL.destroy();
        }
        catch(Exception exception1) { }
        return true;
    }

    protected Channel createChannel(int i)
    {
        IntBuffer intbuffer = BufferUtils.createIntBuffer(1);
        try
        {
            AL10.alGenSources(intbuffer);
        }
        catch(Exception exception)
        {
            AL10.alGetError();
            return null;
        }
        if(AL10.alGetError() != 0)
        {
            return null;
        } else
        {
            ChannelLWJGLOpenAL channellwjglopenal = new ChannelLWJGLOpenAL(i, intbuffer);
            return ((Channel) (channellwjglopenal));
        }
    }

    public void cleanup()
    {
        super.cleanup();
        Set set = bufferMap.keySet();
        Iterator iterator = set.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            IntBuffer intbuffer = (IntBuffer)ALBufferMap.get(((Object) (s)));
            if(intbuffer != null)
            {
                AL10.alDeleteBuffers(intbuffer);
                checkALError();
                intbuffer.clear();
            }
        } while(true);
        bufferMap.clear();
        AL.destroy();
        bufferMap = null;
        listenerPositionAL = null;
        listenerOrientation = null;
        listenerVelocity = null;
    }

    public boolean loadSound(FilenameURL filenameurl)
    {
        if(bufferMap == null)
        {
            bufferMap = new HashMap();
            importantMessage("Buffer Map was null in method 'loadSound'");
        }
        if(ALBufferMap == null)
        {
            ALBufferMap = new HashMap();
            importantMessage("Open AL Buffer Map was null in method'loadSound'");
        }
        if(errorCheck(filenameurl == null, "Filename/URL not specified in method 'loadSound'"))
            return false;
        if(bufferMap.get(((Object) (filenameurl.getFilename()))) != null)
            return true;
        ICodec icodec = SoundSystemConfig.getCodec(filenameurl.getFilename());
        if(errorCheck(icodec == null, (new StringBuilder()).append("No codec found for file '").append(filenameurl.getFilename()).append("' in method 'loadSound'").toString()))
            return false;
        icodec.initialize(filenameurl.getURL());
        SoundBuffer soundbuffer = icodec.readAll();
        icodec.cleanup();
        icodec = null;
        if(errorCheck(soundbuffer == null, "Sound buffer null in method 'loadSound'"))
            return false;
        bufferMap.put(((Object) (filenameurl.getFilename())), ((Object) (soundbuffer)));
        AudioFormat audioformat = soundbuffer.audioFormat;
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
                errorMessage("Illegal sample size in method 'loadSound'");
                return false;
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
                errorMessage("Illegal sample size in method 'loadSound'");
                return false;
            }
        } else
        {
            errorMessage("File neither mono nor stereo in method 'loadSound'");
            return false;
        }
        IntBuffer intbuffer = BufferUtils.createIntBuffer(1);
        AL10.alGenBuffers(intbuffer);
        if(errorCheck(AL10.alGetError() != 0, (new StringBuilder()).append("alGenBuffers error when loading ").append(filenameurl.getFilename()).toString()))
            return false;
        ByteBuffer bytebuffer = BufferUtils.createByteBuffer(soundbuffer.audioData.length);
        bytebuffer.clear();
        bytebuffer.put(soundbuffer.audioData);
        bytebuffer.flip();
        AL10.alBufferData(intbuffer.get(0), ((int) (c)), bytebuffer, (int)audioformat.getSampleRate());
        if(errorCheck(AL10.alGetError() != 0, (new StringBuilder()).append("alBufferData error when loading ").append(filenameurl.getFilename()).toString()) && errorCheck(intbuffer == null, (new StringBuilder()).append("Sound buffer was not created for ").append(filenameurl.getFilename()).toString()))
        {
            return false;
        } else
        {
            ALBufferMap.put(((Object) (filenameurl.getFilename())), ((Object) (intbuffer)));
            return true;
        }
    }

    public void unloadSound(String s)
    {
        ALBufferMap.remove(((Object) (s)));
        super.unloadSound(s);
    }

    public void setMasterVolume(float f)
    {
        super.setMasterVolume(f);
        AL10.alListenerf(4106, f);
        checkALError();
    }

    public void newSource(boolean flag, boolean flag1, boolean flag2, String s, FilenameURL filenameurl, float f, float f1, 
            float f2, int i, float f3)
    {
        IntBuffer intbuffer = null;
        if(!flag1)
        {
            intbuffer = (IntBuffer)ALBufferMap.get(((Object) (filenameurl.getFilename())));
            if(intbuffer == null && !loadSound(filenameurl))
            {
                errorMessage((new StringBuilder()).append("Source '").append(s).append("' was not created ").append("because an error occurred while loading ").append(filenameurl.getFilename()).toString());
                return;
            }
            intbuffer = (IntBuffer)ALBufferMap.get(((Object) (filenameurl.getFilename())));
            if(intbuffer == null)
            {
                errorMessage((new StringBuilder()).append("Source '").append(s).append("' was not created ").append("because a sound buffer was not found for ").append(filenameurl.getFilename()).toString());
                return;
            }
        }
        SoundBuffer soundbuffer = null;
        if(!flag1)
        {
            soundbuffer = (SoundBuffer)bufferMap.get(((Object) (filenameurl.getFilename())));
            if(soundbuffer == null && !loadSound(filenameurl))
            {
                errorMessage((new StringBuilder()).append("Source '").append(s).append("' was not created ").append("because an error occurred while loading ").append(filenameurl.getFilename()).toString());
                return;
            }
            soundbuffer = (SoundBuffer)bufferMap.get(((Object) (filenameurl.getFilename())));
            if(soundbuffer == null)
            {
                errorMessage((new StringBuilder()).append("Source '").append(s).append("' was not created ").append("because audio data was not found for ").append(filenameurl.getFilename()).toString());
                return;
            }
        }
        sourceMap.put(((Object) (s)), ((Object) (new SourceLWJGLOpenAL(listenerPositionAL, intbuffer, flag, flag1, flag2, s, filenameurl, soundbuffer, f, f1, f2, i, f3, false))));
    }

    public void rawDataStream(AudioFormat audioformat, boolean flag, String s, float f, float f1, float f2, int i, 
            float f3)
    {
        sourceMap.put(((Object) (s)), ((Object) (new SourceLWJGLOpenAL(listenerPositionAL, audioformat, flag, s, f, f1, f2, i, f3))));
    }

    public void quickPlay(boolean flag, boolean flag1, boolean flag2, String s, FilenameURL filenameurl, float f, float f1, 
            float f2, int i, float f3, boolean flag3)
    {
        IntBuffer intbuffer = null;
        if(!flag1)
        {
            intbuffer = (IntBuffer)ALBufferMap.get(((Object) (filenameurl.getFilename())));
            if(intbuffer == null)
                loadSound(filenameurl);
            intbuffer = (IntBuffer)ALBufferMap.get(((Object) (filenameurl.getFilename())));
            if(intbuffer == null)
            {
                errorMessage((new StringBuilder()).append("Sound buffer was not created for ").append(filenameurl.getFilename()).toString());
                return;
            }
        }
        SoundBuffer soundbuffer = null;
        if(!flag1)
        {
            soundbuffer = (SoundBuffer)bufferMap.get(((Object) (filenameurl.getFilename())));
            if(soundbuffer == null && !loadSound(filenameurl))
            {
                errorMessage((new StringBuilder()).append("Source '").append(s).append("' was not created ").append("because an error occurred while loading ").append(filenameurl.getFilename()).toString());
                return;
            }
            soundbuffer = (SoundBuffer)bufferMap.get(((Object) (filenameurl.getFilename())));
            if(soundbuffer == null)
            {
                errorMessage((new StringBuilder()).append("Source '").append(s).append("' was not created ").append("because audio data was not found for ").append(filenameurl.getFilename()).toString());
                return;
            }
        }
        SourceLWJGLOpenAL sourcelwjglopenal = new SourceLWJGLOpenAL(listenerPositionAL, intbuffer, flag, flag1, flag2, s, filenameurl, soundbuffer, f, f1, f2, i, f3, false);
        sourceMap.put(((Object) (s)), ((Object) (sourcelwjglopenal)));
        play(((Source) (sourcelwjglopenal)));
        if(flag3)
            sourcelwjglopenal.setTemporary(true);
    }

    public void copySources(HashMap hashmap)
    {
        if(hashmap == null)
            return;
        Set set = hashmap.keySet();
        Iterator iterator = set.iterator();
        if(bufferMap == null)
        {
            bufferMap = new HashMap();
            importantMessage("Buffer Map was null in method 'copySources'");
        }
        if(ALBufferMap == null)
        {
            ALBufferMap = new HashMap();
            importantMessage("Open AL Buffer Map was null in method'copySources'");
        }
        sourceMap.clear();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            Source source = (Source)hashmap.get(((Object) (s)));
            if(source != null)
            {
                SoundBuffer soundbuffer = null;
                if(!source.toStream)
                {
                    loadSound(source.filenameURL);
                    soundbuffer = (SoundBuffer)bufferMap.get(((Object) (source.filenameURL.getFilename())));
                }
                if(source.toStream || soundbuffer != null)
                    sourceMap.put(((Object) (s)), ((Object) (new SourceLWJGLOpenAL(listenerPositionAL, (IntBuffer)ALBufferMap.get(((Object) (source.filenameURL.getFilename()))), source, soundbuffer))));
            }
        } while(true);
    }

    public void setListenerPosition(float f, float f1, float f2)
    {
        super.setListenerPosition(f, f1, f2);
        listenerPositionAL.put(0, f);
        listenerPositionAL.put(1, f1);
        listenerPositionAL.put(2, f2);
        AL10.alListener(4100, listenerPositionAL);
        checkALError();
    }

    public void setListenerAngle(float f)
    {
        super.setListenerAngle(f);
        listenerOrientation.put(0, listener.lookAt.x);
        listenerOrientation.put(2, listener.lookAt.z);
        AL10.alListener(4111, listenerOrientation);
        checkALError();
    }

    public void setListenerOrientation(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setListenerOrientation(f, f1, f2, f3, f4, f5);
        listenerOrientation.put(0, f);
        listenerOrientation.put(1, f1);
        listenerOrientation.put(2, f2);
        listenerOrientation.put(3, f3);
        listenerOrientation.put(4, f4);
        listenerOrientation.put(5, f5);
        AL10.alListener(4111, listenerOrientation);
        checkALError();
    }

    public void setListenerData(ListenerData listenerdata)
    {
        super.setListenerData(listenerdata);
        listenerPositionAL.put(0, listenerdata.position.x);
        listenerPositionAL.put(1, listenerdata.position.y);
        listenerPositionAL.put(2, listenerdata.position.z);
        AL10.alListener(4100, listenerPositionAL);
        listenerOrientation.put(0, listenerdata.lookAt.x);
        listenerOrientation.put(1, listenerdata.lookAt.y);
        listenerOrientation.put(2, listenerdata.lookAt.z);
        listenerOrientation.put(3, listenerdata.up.x);
        listenerOrientation.put(4, listenerdata.up.y);
        listenerOrientation.put(5, listenerdata.up.z);
        AL10.alListener(4111, listenerOrientation);
        checkALError();
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

    public static boolean alPitchSupported()
    {
        return alPitchSupported(false, false);
    }

    private static synchronized boolean alPitchSupported(boolean flag, boolean flag1)
    {
        if(flag)
            alPitchSupported = flag1;
        return alPitchSupported;
    }

    public static String getTitle()
    {
        return "LWJGL OpenAL";
    }

    public static String getDescription()
    {
        return "The LWJGL binding of OpenAL.  For more information, see http://www.lwjgl.org";
    }

    public String getClassName()
    {
        return "LibraryLWJGLOpenAL";
    }

    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private FloatBuffer listenerPositionAL;
    private FloatBuffer listenerOrientation;
    private FloatBuffer listenerVelocity;
    private HashMap ALBufferMap;
    private static boolean alPitchSupported = true;

}
