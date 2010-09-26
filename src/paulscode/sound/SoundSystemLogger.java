// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;

import java.io.PrintStream;

public class SoundSystemLogger
{

    public SoundSystemLogger()
    {
    }

    public void message(String s, int i)
    {
        String s2 = "";
        for(int j = 0; j < i; j++)
            s2 = (new StringBuilder()).append(s2).append("    ").toString();

        String s1 = (new StringBuilder()).append(s2).append(s).toString();
        System.out.println(s1);
    }

    public void importantMessage(String s, int i)
    {
        String s2 = "";
        for(int j = 0; j < i; j++)
            s2 = (new StringBuilder()).append(s2).append("    ").toString();

        String s1 = (new StringBuilder()).append(s2).append(s).toString();
        System.out.println(s1);
    }

    public boolean errorCheck(boolean flag, String s, String s1, int i)
    {
        if(flag)
            errorMessage(s, s1, i);
        return flag;
    }

    public void errorMessage(String s, String s1, int i)
    {
        String s4 = "";
        for(int j = 0; j < i; j++)
            s4 = (new StringBuilder()).append(s4).append("    ").toString();

        String s2 = (new StringBuilder()).append(s4).append("Error in class '").append(s).append("'").toString();
        String s3 = (new StringBuilder()).append("    ").append(s4).append(s1).toString();
        System.out.println(s2);
        System.out.println(s3);
    }

    public void printStackTrace(Exception exception, int i)
    {
        printExceptionMessage(exception, i);
        importantMessage("STACK TRACE:", i);
        if(exception == null)
            return;
        StackTraceElement astacktraceelement[] = exception.getStackTrace();
        if(astacktraceelement == null)
            return;
        for(int j = 0; j < astacktraceelement.length; j++)
        {
            StackTraceElement stacktraceelement = astacktraceelement[j];
            if(stacktraceelement != null)
                message(stacktraceelement.toString(), i + 1);
        }

    }

    public void printExceptionMessage(Exception exception, int i)
    {
        importantMessage("ERROR MESSAGE:", i);
        if(exception.getMessage() == null)
            message("(none)", i + 1);
        else
            message(exception.getMessage(), i + 1);
    }
}
