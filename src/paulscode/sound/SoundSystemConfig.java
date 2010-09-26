// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.ListIterator;

// Referenced classes of package paulscode.sound:
//            ICodec, Library, SoundSystemException, SoundSystemLogger

public class SoundSystemConfig
{

    public SoundSystemConfig()
    {
    }

    public static void addLibrary(Class class1)
    {
        if(class1 == null)
            throw new SoundSystemException("Parameter null in method 'addLibrary'", 2);
        if(!((Class) (paulscode/sound/Library)).isAssignableFrom(class1))
            throw new SoundSystemException("The specified class does not extend class 'Library' in method 'addLibrary'");
        if(libraries == null)
            libraries = new LinkedList();
        if(!libraries.contains(((Object) (class1))))
            libraries.add(((Object) (class1)));
    }

    public static void removeLibrary(Class class1)
    {
        if(libraries == null || class1 == null)
        {
            return;
        } else
        {
            libraries.remove(((Object) (class1)));
            return;
        }
    }

    public static LinkedList getLibraries()
    {
        return libraries;
    }

    public static boolean libraryCompatible(Class class1)
    {
        if(class1 == null)
        {
            errorMessage("Parameter 'libraryClass' null in method'librayCompatible'");
            return false;
        }
        if(!((Class) (paulscode/sound/Library)).isAssignableFrom(class1))
        {
            errorMessage("The specified class does not extend class 'Library' in method 'libraryCompatible'");
            return false;
        }
        Object obj = runMethod(class1, "libraryCompatible", new Class[0], new Object[0]);
        if(obj == null)
        {
            errorMessage("Method 'Library.libraryCompatible' returned 'null' in method 'libraryCompatible'");
            return false;
        } else
        {
            return ((Boolean)obj).booleanValue();
        }
    }

    public static String getLibraryTitle(Class class1)
    {
        if(class1 == null)
        {
            errorMessage("Parameter 'libraryClass' null in method'getLibrayTitle'");
            return null;
        }
        if(!((Class) (paulscode/sound/Library)).isAssignableFrom(class1))
        {
            errorMessage("The specified class does not extend class 'Library' in method 'getLibraryTitle'");
            return null;
        }
        Object obj = runMethod(class1, "getTitle", new Class[0], new Object[0]);
        if(obj == null)
        {
            errorMessage("Method 'Library.getTitle' returned 'null' in method 'getLibraryTitle'");
            return null;
        } else
        {
            return (String)obj;
        }
    }

    public static String getLibraryDescription(Class class1)
    {
        if(class1 == null)
        {
            errorMessage("Parameter 'libraryClass' null in method'getLibrayDescription'");
            return null;
        }
        if(!((Class) (paulscode/sound/Library)).isAssignableFrom(class1))
        {
            errorMessage("The specified class does not extend class 'Library' in method 'getLibraryDescription'");
            return null;
        }
        Object obj = runMethod(class1, "getDescription", new Class[0], new Object[0]);
        if(obj == null)
        {
            errorMessage("Method 'Library.getDescription' returned 'null' in method 'getLibraryDescription'");
            return null;
        } else
        {
            return (String)obj;
        }
    }

    public static void setLogger(SoundSystemLogger soundsystemlogger)
    {
        logger = soundsystemlogger;
    }

    public static SoundSystemLogger getLogger()
    {
        return logger;
    }

    public static synchronized void setNumberNormalChannels(int i)
    {
        numberNormalChannels = i;
    }

    public static synchronized int getNumberNormalChannels()
    {
        return numberNormalChannels;
    }

    public static synchronized void setNumberStreamingChannels(int i)
    {
        numberStreamingChannels = i;
    }

    public static synchronized int getNumberStreamingChannels()
    {
        return numberStreamingChannels;
    }

    public static synchronized void setMasterGain(float f)
    {
        masterGain = f;
    }

    public static synchronized float getMasterGain()
    {
        return masterGain;
    }

    public static synchronized void setDefaultAttenuation(int i)
    {
        defaultAttenuationModel = i;
    }

    public static synchronized int getDefaultAttenuation()
    {
        return defaultAttenuationModel;
    }

    public static synchronized void setDefaultRolloff(float f)
    {
        defaultRolloffFactor = f;
    }

    public static synchronized float getDefaultRolloff()
    {
        return defaultRolloffFactor;
    }

    public static synchronized void setDefaultFadeDistance(float f)
    {
        defaultFadeDistance = f;
    }

    public static synchronized float getDefaultFadeDistance()
    {
        return defaultFadeDistance;
    }

    public static synchronized void setSoundFilesPackage(String s)
    {
        soundFilesPackage = s;
    }

    public static synchronized String getSoundFilesPackage()
    {
        return soundFilesPackage;
    }

    public static synchronized void setStreamingBufferSize(int i)
    {
        streamingBufferSize = i;
    }

    public static synchronized int getStreamingBufferSize()
    {
        return streamingBufferSize;
    }

    public static synchronized void setNumberStreamingBuffers(int i)
    {
        numberStreamingBuffers = i;
    }

    public static synchronized int getNumberStreamingBuffers()
    {
        return numberStreamingBuffers;
    }

    public static synchronized void setMaxFileSize(int i)
    {
        maxFileSize = i;
    }

    public static synchronized int getMaxFileSize()
    {
        return maxFileSize;
    }

    public static synchronized void setFileChunkSize(int i)
    {
        fileChunkSize = i;
    }

    public static synchronized int getFileChunkSize()
    {
        return fileChunkSize;
    }

    public static synchronized void setCodec(String s, Class class1)
    {
        if(s == null)
            throw new SoundSystemException("Parameter 'extension' null in method 'setCodec'.", 2);
        if(class1 == null)
            throw new SoundSystemException("Parameter 'iCodecClass' null in method 'setCodec'.", 2);
        if(!((Class) (paulscode/sound/ICodec)).isAssignableFrom(class1))
            throw new SoundSystemException("The specified class does not implement interface 'ICodec' in method 'setCodec'", 3);
        if(codecs == null)
            codecs = new LinkedList();
        ListIterator listiterator = codecs.listIterator();
        do
        {
            if(!listiterator.hasNext())
                break;
            Codec codec = (Codec)listiterator.next();
            if(s.matches(codec.extensionRegX))
                listiterator.remove();
        } while(true);
        codecs.add(((Object) (new Codec(s, class1))));
        if(s.matches(".*[mM][iI][dD][iI]?$"))
            midiCodec = true;
    }

    public static synchronized ICodec getCodec(String s)
    {
        if(codecs == null)
            return null;
        for(ListIterator listiterator = codecs.listIterator(); listiterator.hasNext();)
        {
            Codec codec = (Codec)listiterator.next();
            if(s.matches(codec.extensionRegX))
                return codec.getInstance();
        }

        return null;
    }

    public static boolean midiCodec()
    {
        return midiCodec;
    }

    private static void errorMessage(String s)
    {
        if(logger != null)
            logger.errorMessage("SoundSystemConfig", s, 0);
    }

    private static Object runMethod(Class class1, String s, Class aclass[], Object aobj[])
    {
        Method method = null;
        try
        {
            method = class1.getMethod(s, aclass);
        }
        catch(NoSuchMethodException nosuchmethodexception)
        {
            errorMessage((new StringBuilder()).append("NoSuchMethodException thrown when attempting to call method '").append(s).append("' in ").append("method 'runMethod'").toString());
            return ((Object) (null));
        }
        catch(SecurityException securityexception)
        {
            errorMessage((new StringBuilder()).append("Access denied when attempting to call method '").append(s).append("' in method 'runMethod'").toString());
            return ((Object) (null));
        }
        catch(NullPointerException nullpointerexception)
        {
            errorMessage((new StringBuilder()).append("NullPointerException thrown when attempting to call method '").append(s).append("' in ").append("method 'runMethod'").toString());
            return ((Object) (null));
        }
        if(method == null)
        {
            errorMessage((new StringBuilder()).append("Method '").append(s).append("' not found for the class ").append("specified in method 'runMethod'").toString());
            return ((Object) (null));
        }
        Object obj = null;
        try
        {
            obj = method.invoke(((Object) (null)), aobj);
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            errorMessage((new StringBuilder()).append("IllegalAccessException thrown when attempting to invoke method '").append(s).append("' in ").append("method 'runMethod'").toString());
            return ((Object) (null));
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            errorMessage((new StringBuilder()).append("IllegalArgumentException thrown when attempting to invoke method '").append(s).append("' in ").append("method 'runMethod'").toString());
            return ((Object) (null));
        }
        catch(InvocationTargetException invocationtargetexception)
        {
            errorMessage("InvocationTargetException thrown while attempting to invoke method 'Library.getTitle' in method 'getLibraryTitle'");
            return ((Object) (null));
        }
        catch(NullPointerException nullpointerexception1)
        {
            errorMessage((new StringBuilder()).append("NullPointerException thrown when attempting to invoke method '").append(s).append("' in ").append("method 'runMethod'").toString());
            return ((Object) (null));
        }
        catch(ExceptionInInitializerError exceptionininitializererror)
        {
            errorMessage((new StringBuilder()).append("ExceptionInInitializerError thrown when attempting to invoke method '").append(s).append("' in ").append("method 'runMethod'").toString());
            return ((Object) (null));
        }
        return obj;
    }

    public static final Object THREAD_SYNC = new Object();
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_STREAMING = 1;
    public static final int ATTENUATION_NONE = 0;
    public static final int ATTENUATION_ROLLOFF = 1;
    public static final int ATTENUATION_LINEAR = 2;
    public static final String EXTENSION_MIDI = ".*[mM][iI][dD][iI]?$";
    public static final String PREFIX_URL = "^[hH][tT][tT][pP]://.*";
    private static SoundSystemLogger logger = null;
    private static LinkedList libraries;
    private static LinkedList codecs = null;
    private static int numberNormalChannels = 28;
    private static int numberStreamingChannels = 4;
    private static float masterGain = 1.0F;
    private static int defaultAttenuationModel = 1;
    private static float defaultRolloffFactor = 0.03F;
    private static float defaultFadeDistance = 1000F;
    private static String soundFilesPackage = "Sounds/";
    private static int streamingBufferSize = 0x20000;
    private static int numberStreamingBuffers = 3;
    private static int maxFileSize = 0x10000000;
    private static int fileChunkSize = 0x100000;
    private static boolean midiCodec = false;



    private class Codec
    {

        public ICodec getInstance()
        {
            if(iCodecClass == null)
                return null;
            Object obj = null;
            try
            {
                obj = iCodecClass.newInstance();
            }
            catch(InstantiationException instantiationexception)
            {
                instantiationErrorMessage();
                return null;
            }
            catch(IllegalAccessException illegalaccessexception)
            {
                instantiationErrorMessage();
                return null;
            }
            catch(ExceptionInInitializerError exceptionininitializererror)
            {
                instantiationErrorMessage();
                return null;
            }
            catch(SecurityException securityexception)
            {
                instantiationErrorMessage();
                return null;
            }
            if(obj == null)
            {
                instantiationErrorMessage();
                return null;
            } else
            {
                return (ICodec)obj;
            }
        }

        private void instantiationErrorMessage()
        {
            SoundSystemConfig.errorMessage("Unrecognized ICodec implementation in method 'getInstance'.  Ensure that the implementing class has one public, parameterless constructor.");
        }

        public String extensionRegX;
        public Class iCodecClass;

        public Codec(String s, Class class1)
        {
            extensionRegX = "";
            if(s == null || s.length() <= 0) goto _L2; else goto _L1
_L1:
            int i;
            extensionRegX = ".*";
            i = 0;
_L4:
            String s1;
            if(i >= s.length())
                break; /* Loop/switch isn't completed */
            s1 = s.substring(i, i + 1);
            new StringBuilder();
            this;
            JVM INSTR dup_x1 ;
            extensionRegX;
            append();
            "[";
            append();
            s1.toLowerCase(Locale.ENGLISH);
            append();
            s1.toUpperCase(Locale.ENGLISH);
            append();
            "]";
            append();
            toString();
            extensionRegX;
            i++;
            if(true) goto _L4; else goto _L3
_L3:
            new StringBuilder();
            this;
            JVM INSTR dup_x1 ;
            extensionRegX;
            append();
            "$";
            append();
            toString();
            extensionRegX;
_L2:
            iCodecClass = class1;
            return;
        }
    }

}
