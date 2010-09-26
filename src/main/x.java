package main;
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class x
{

    public x()
    {
    }

    public static hm a(InputStream inputstream)
    {
        DataInputStream datainputstream = new DataInputStream(((InputStream) (new GZIPInputStream(inputstream))));
        hm hm1 = a(((DataInput) (datainputstream)));
        datainputstream.close();
        return hm1;
        Exception exception;
        exception;
        datainputstream.close();
        throw exception;
    }

    public static void a(hm hm1, OutputStream outputstream)
    {
        DataOutputStream dataoutputstream = new DataOutputStream(((OutputStream) (new GZIPOutputStream(outputstream))));
        a(hm1, ((DataOutput) (dataoutputstream)));
        dataoutputstream.close();
        break MISSING_BLOCK_LABEL_35;
        Exception exception;
        exception;
        dataoutputstream.close();
        throw exception;
    }

    public static hm a(byte abyte0[])
    {
        DataInputStream datainputstream = new DataInputStream(((InputStream) (new GZIPInputStream(((InputStream) (new ByteArrayInputStream(abyte0)))))));
        hm hm1 = a(((DataInput) (datainputstream)));
        datainputstream.close();
        return hm1;
        Exception exception;
        exception;
        datainputstream.close();
        throw exception;
    }

    public static byte[] a(hm hm1)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        DataOutputStream dataoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        dataoutputstream = new DataOutputStream(((OutputStream) (new GZIPOutputStream(((OutputStream) (bytearrayoutputstream))))));
        a(hm1, ((DataOutput) (dataoutputstream)));
        dataoutputstream.close();
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        dataoutputstream.close();
        throw exception;
        return bytearrayoutputstream.toByteArray();
    }

    public static hm a(DataInput datainput)
    {
        el el1 = el.b(datainput);
        if(el1 instanceof hm)
            return (hm)el1;
        else
            throw new IOException("Root tag must be a named compound tag");
    }

    public static void a(hm hm1, DataOutput dataoutput)
    {
        el.a(((el) (hm1)), dataoutput);
    }
}
