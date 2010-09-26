package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

class kz extends Thread
{

    kz(cc cc1, String s, hb hb1)
    {
        c = cc1;
        a = s;
        b = hb1;
        super();
    }

    public void run()
    {
        HttpURLConnection httpurlconnection = null;
        URL url = new URL(a);
        httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setDoInput(true);
        httpurlconnection.setDoOutput(false);
        httpurlconnection.connect();
        if(httpurlconnection.getResponseCode() == 404)
        {
            httpurlconnection.disconnect();
            return;
        }
        if(b == null)
            c.a = ImageIO.read(httpurlconnection.getInputStream());
        else
            c.a = b.a(ImageIO.read(httpurlconnection.getInputStream()));
        httpurlconnection.disconnect();
        break MISSING_BLOCK_LABEL_124;
        Exception exception;
        exception;
        exception.printStackTrace();
        httpurlconnection.disconnect();
        break MISSING_BLOCK_LABEL_124;
        Exception exception1;
        exception1;
        httpurlconnection.disconnect();
        throw exception1;
    }

    final String a;
    final hb b;
    final cc c;
}
