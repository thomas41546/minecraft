package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import paulscode.sound.codecs.CodecJOrbis;

public class ep extends CodecJOrbis
{

    public ep()
    {
    }

    protected InputStream openInputStream()
    {
        return ((InputStream) (new hk(this, url, urlConnection.getInputStream())));
    }
}
