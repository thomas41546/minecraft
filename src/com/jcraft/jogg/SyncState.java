// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jogg;


// Referenced classes of package com.jcraft.jogg:
//            Page

public class SyncState
{

    public SyncState()
    {
        pageseek = new Page();
        chksum = new byte[4];
    }

    public int clear()
    {
        data = null;
        return 0;
    }

    public int buffer(int i)
    {
        if(returned != 0)
        {
            fill -= returned;
            if(fill > 0)
                System.arraycopy(((Object) (data)), returned, ((Object) (data)), 0, fill);
            returned = 0;
        }
        if(i > storage - fill)
        {
            int j = i + fill + 4096;
            if(data != null)
            {
                byte abyte0[] = new byte[j];
                System.arraycopy(((Object) (data)), 0, ((Object) (abyte0)), 0, data.length);
                data = abyte0;
            } else
            {
                data = new byte[j];
            }
            storage = j;
        }
        return fill;
    }

    public int wrote(int i)
    {
        if(fill + i > storage)
        {
            return -1;
        } else
        {
            fill += i;
            return 0;
        }
    }

    public int pageseek(Page page)
    {
        int i;
        int i1;
        i = returned;
        i1 = fill - returned;
        if(headerbytes == 0)
        {
            if(i1 < 27)
                return 0;
            if(data[i] != 79 || data[i + 1] != 103 || data[i + 2] != 103 || data[i + 3] != 83)
            {
                headerbytes = 0;
                bodybytes = 0;
                int k = 0;
                int i2 = 0;
                do
                {
                    if(i2 >= i1 - 1)
                        break;
                    if(data[i + 1 + i2] == 79)
                    {
                        k = i + 1 + i2;
                        break;
                    }
                    i2++;
                } while(true);
                if(k == 0)
                    k = fill;
                returned = k;
                return -(k - i);
            }
            int k1 = (data[i + 26] & 0xff) + 27;
            if(i1 < k1)
                return 0;
            for(int l1 = 0; l1 < (data[i + 26] & 0xff); l1++)
                bodybytes += data[i + 27 + l1] & 0xff;

            headerbytes = k1;
        }
        if(bodybytes + headerbytes > i1)
            return 0;
        byte abyte0[] = chksum;
        int l;
        System.arraycopy(((Object) (data)), i + 22, ((Object) (chksum)), 0, 4);
        data[i + 22] = 0;
        data[i + 23] = 0;
        data[i + 24] = 0;
        data[i + 25] = 0;
        Page page1 = pageseek;
        page1.header_base = data;
        page1.header = i;
        page1.header_len = headerbytes;
        page1.body_base = data;
        page1.body = i + headerbytes;
        page1.body_len = bodybytes;
        page1.checksum();
        if(chksum[0] == data[i + 22] && chksum[1] == data[i + 23] && chksum[2] == data[i + 24] && chksum[3] == data[i + 25])
            break MISSING_BLOCK_LABEL_554;
        System.arraycopy(((Object) (chksum)), 0, ((Object) (data)), i + 22, 4);
        headerbytes = 0;
        bodybytes = 0;
        l = 0;
        int j2 = 0;
        do
        {
            if(j2 >= i1 - 1)
                break;
            if(data[i + 1 + j2] == 79)
            {
                l = i + 1 + j2;
                break;
            }
            j2++;
        } while(true);
        if(l == 0)
            l = fill;
        returned = l;
        return -(l - i);

        int j = 0;
        if(page != null)
        {
            page.header_base = data;
            page.header = j;
            page.header_len = headerbytes;
            page.body_base = data;
            page.body = j + headerbytes;
            page.body_len = bodybytes;
        }
        unsynced = 0;
        int j1;
        returned += j1 = headerbytes + bodybytes;
        headerbytes = 0;
        bodybytes = 0;
        return j1;
    }

    public int pageout(Page page)
    {
        do
        {
            int i = pageseek(page);
            if(i > 0)
                return 1;
            if(i == 0)
                return 0;
        } while(unsynced != 0);
        unsynced = 1;
        return -1;
    }

    public int reset()
    {
        fill = 0;
        returned = 0;
        unsynced = 0;
        headerbytes = 0;
        bodybytes = 0;
        return 0;
    }

    public void init()
    {
    }

    public int getDataOffset()
    {
        return returned;
    }

    public int getBufferOffset()
    {
        return fill;
    }

    public byte data[];
    int storage;
    int fill;
    int returned;
    int unsynced;
    int headerbytes;
    int bodybytes;
    private Page pageseek;
    private byte chksum[];
}
