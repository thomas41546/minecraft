package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;

public class bf extends Thread
{

    public bf(File file, Minecraft minecraft)
    {
        c = false;
        b = minecraft;
        setName("Resource download thread");
        setDaemon(true);
        a = new File(file, "resources/");
        if(!a.exists() && !a.mkdirs())
            throw new RuntimeException((new StringBuilder()).append("The working directory could not be created: ").append(((Object) (a))).toString());
        else
            return;
    }

    public void run()
    {
        ArrayList arraylist;
        URL url;
        int i;
        arraylist = new ArrayList();
        url = new URL("http://www.minecraft.net/resources/");
        BufferedReader bufferedreader = new BufferedReader(((java.io.Reader) (new InputStreamReader(url.openStream()))));
        for(String s = ""; (s = bufferedreader.readLine()) != null;)
            ((List) (arraylist)).add(((Object) (s)));

        bufferedreader.close();
        i = 0;
_L4:
        int j;
        if(i >= 2)
            break MISSING_BLOCK_LABEL_146;
        j = 0;
_L2:
        if(j >= ((List) (arraylist)).size())
            break MISSING_BLOCK_LABEL_122;
        a(url, (String)((List) (arraylist)).get(j), i);
        if(c)
            return;
        j++;
        if(true) goto _L2; else goto _L1
_L1:
        i++;
        if(true) goto _L4; else goto _L3
_L3:
        IOException ioexception;
        ioexception;
        a(a, "");
        ioexception.printStackTrace();
    }

    public void a()
    {
        a(a, "");
    }

    private void a(File file, String s)
    {
        File afile[] = file.listFiles();
        for(int i = 0; i < afile.length; i++)
        {
            if(afile[i].isDirectory())
            {
                a(afile[i], (new StringBuilder()).append(s).append(afile[i].getName()).append("/").toString());
                continue;
            }
            try
            {
                b.a((new StringBuilder()).append(s).append(afile[i].getName()).toString(), afile[i]);
            }
            catch(Exception exception)
            {
                System.out.println((new StringBuilder()).append("Failed to add ").append(s).append(afile[i].getName()).toString());
            }
        }

    }

    private void a(URL url, String s, int i)
    {
        String as[];
        String s1;
        as = s.split(",");
        s1 = as[0];
        int j = s1.indexOf("/");
        String s2 = s1.substring(0, j);
        if(s2.equals("sound") || s2.equals("newsound"))
        {
            if(i != 0)
                return;
            break MISSING_BLOCK_LABEL_64;
        }
        if(i != 1)
            return;
        File file;
        int k = Integer.parseInt(as[1]);
        long l = Long.parseLong(as[2]);
        l /= 2L;
        file = new File(a, s1);
        if(!file.exists() || file.length() != (long)k)
        {
            file.getParentFile().mkdirs();
            String s3 = s1.replaceAll(" ", "%20");
            a(new URL(url, s3), file, k);
            if(c)
                return;
        }
        try
        {
            b.a(s1, file);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return;
    }

    private void a(URL url, File file, int i)
    {
        byte abyte0[] = new byte[4096];
        DataInputStream datainputstream = new DataInputStream(url.openStream());
        DataOutputStream dataoutputstream = new DataOutputStream(((java.io.OutputStream) (new FileOutputStream(file))));
        for(int j = 0; (j = datainputstream.read(abyte0)) >= 0;)
        {
            dataoutputstream.write(abyte0, 0, j);
            if(c)
                return;
        }

        datainputstream.close();
        dataoutputstream.close();
    }

    public void b()
    {
        c = true;
    }

    public File a;
    private Minecraft b;
    private boolean c;
}
