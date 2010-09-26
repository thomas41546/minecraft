// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import java.net.URL;

// Referenced classes of package paulscode.sound:
//            SoundSystemConfig, SoundSystemLogger

public class FilenameURL
{

    public FilenameURL(URL url1, String s)
    {
        filename = null;
        url = null;
        logger = SoundSystemConfig.getLogger();
        filename = s;
        url = url1;
    }

    public FilenameURL(String s)
    {
        filename = null;
        url = null;
        logger = SoundSystemConfig.getLogger();
        filename = s;
        url = null;
    }

    public String getFilename()
    {
        return filename;
    }

    public URL getURL()
    {
        if(url == null)
            if(filename.matches("^[hH][tT][tT][pP]://.*"))
                try
                {
                    url = new URL(filename);
                }
                catch(Exception exception)
                {
                    errorMessage("Unable to access online URL in method 'getURL'");
                    printStackTrace(exception);
                    return null;
                }
            else
                url = ((Object)this).getClass().getClassLoader().getResource((new StringBuilder()).append(SoundSystemConfig.getSoundFilesPackage()).append(filename).toString());
        return url;
    }

    private void errorMessage(String s)
    {
        logger.errorMessage("MidiChannel", s, 0);
    }

    private void printStackTrace(Exception exception)
    {
        logger.printStackTrace(exception, 1);
    }

    private SoundSystemLogger logger;
    private String filename;
    private URL url;
}
