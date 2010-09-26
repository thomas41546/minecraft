// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jogg;


// Referenced classes of package com.jcraft.jogg:
//            Packet, Page

public class StreamState
{

    public StreamState()
    {
        header = new byte[282];
        init();
    }

    StreamState(int i)
    {
        this();
        init(i);
    }

    void init()
    {
        body_storage = 16384;
        body_data = new byte[body_storage];
        lacing_storage = 1024;
        lacing_vals = new int[lacing_storage];
        granule_vals = new long[lacing_storage];
    }

    public void init(int i)
    {
        if(body_data == null)
        {
            init();
        } else
        {
            for(int j = 0; j < body_data.length; j++)
                body_data[j] = 0;

            for(int k = 0; k < lacing_vals.length; k++)
                lacing_vals[k] = 0;

            for(int l = 0; l < granule_vals.length; l++)
                granule_vals[l] = 0L;

        }
        serialno = i;
    }

    public void clear()
    {
        body_data = null;
        lacing_vals = null;
        granule_vals = null;
    }

    void destroy()
    {
        clear();
    }

    void body_expand(int i)
    {
        if(body_storage <= body_fill + i)
        {
            body_storage += i + 1024;
            byte abyte0[] = new byte[body_storage];
            System.arraycopy(((Object) (body_data)), 0, ((Object) (abyte0)), 0, body_data.length);
            body_data = abyte0;
        }
    }

    void lacing_expand(int i)
    {
        if(lacing_storage <= lacing_fill + i)
        {
            lacing_storage += i + 32;
            int ai[] = new int[lacing_storage];
            System.arraycopy(((Object) (lacing_vals)), 0, ((Object) (ai)), 0, lacing_vals.length);
            lacing_vals = ai;
            long al[] = new long[lacing_storage];
            System.arraycopy(((Object) (granule_vals)), 0, ((Object) (al)), 0, granule_vals.length);
            granule_vals = al;
        }
    }

    public int packetin(Packet packet)
    {
        int i = packet.bytes / 255 + 1;
        if(body_returned != 0)
        {
            body_fill -= body_returned;
            if(body_fill != 0)
                System.arraycopy(((Object) (body_data)), body_returned, ((Object) (body_data)), 0, body_fill);
            body_returned = 0;
        }
        body_expand(packet.bytes);
        lacing_expand(i);
        System.arraycopy(((Object) (packet.packet_base)), packet.packet, ((Object) (body_data)), body_fill, packet.bytes);
        body_fill += packet.bytes;
        int j;
        for(j = 0; j < i - 1; j++)
        {
            lacing_vals[lacing_fill + j] = 255;
            granule_vals[lacing_fill + j] = granulepos;
        }

        lacing_vals[lacing_fill + j] = packet.bytes % 255;
        granulepos = granule_vals[lacing_fill + j] = packet.granulepos;
        lacing_vals[lacing_fill] |= 0x100;
        lacing_fill += i;
        packetno++;
        if(packet.e_o_s != 0)
            e_o_s = 1;
        return 0;
    }

    public int packetout(Packet packet)
    {
        int i = lacing_returned;
        if(lacing_packet <= i)
            return 0;
        if((lacing_vals[i] & 0x400) != 0)
        {
            lacing_returned++;
            packetno++;
            return -1;
        }
        int j = lacing_vals[i] & 0xff;
        int k = 0;
        packet.packet_base = body_data;
        packet.packet = body_returned;
        packet.e_o_s = lacing_vals[i] & 0x200;
        packet.b_o_s = lacing_vals[i] & 0x100;
        for(k += j; j == 255; k += j)
        {
            int l = lacing_vals[++i];
            j = l & 0xff;
            if((l & 0x200) != 0)
                packet.e_o_s = 512;
        }

        packet.packetno = packetno;
        packet.granulepos = granule_vals[i];
        packet.bytes = k;
        body_returned += k;
        lacing_returned = i + 1;
        packetno++;
        return 1;
    }

    public int pagein(Page page)
    {
        byte abyte0[] = page.header_base;
        int i = page.header;
        byte abyte1[] = page.body_base;
        int j = page.body;
        int k = page.body_len;
        int l = 0;
        int i1 = page.version();
        int j1 = page.continued();
        int k1 = page.bos();
        int l1 = page.eos();
        long l2 = page.granulepos();
        int i2 = page.serialno();
        int j2 = page.pageno();
        int k2 = abyte0[i + 26] & 0xff;
        int i3 = lacing_returned;
        int j3 = body_returned;
        if(j3 != 0)
        {
            body_fill -= j3;
            if(body_fill != 0)
                System.arraycopy(((Object) (body_data)), j3, ((Object) (body_data)), 0, body_fill);
            body_returned = 0;
        }
        if(i3 != 0)
        {
            if(lacing_fill - i3 != 0)
            {
                System.arraycopy(((Object) (lacing_vals)), i3, ((Object) (lacing_vals)), 0, lacing_fill - i3);
                System.arraycopy(((Object) (granule_vals)), i3, ((Object) (granule_vals)), 0, lacing_fill - i3);
            }
            lacing_fill -= i3;
            lacing_packet -= i3;
            lacing_returned = 0;
        }
        if(i2 != serialno)
            return -1;
        if(i1 > 0)
            return -1;
        lacing_expand(k2 + 1);
        if(j2 != pageno)
        {
            for(i3 = lacing_packet; i3 < lacing_fill; i3++)
                body_fill -= lacing_vals[i3] & 0xff;

            lacing_fill = lacing_packet;
            if(pageno != -1)
            {
                lacing_vals[lacing_fill++] = 1024;
                lacing_packet++;
            }
            if(j1 != 0)
            {
                k1 = 0;
                do
                {
                    if(l >= k2)
                        break;
                    int k3 = abyte0[i + 27 + l] & 0xff;
                    j += k3;
                    k -= k3;
                    if(k3 < 255)
                    {
                        l++;
                        break;
                    }
                    l++;
                } while(true);
            }
        }
        if(k != 0)
        {
            body_expand(k);
            System.arraycopy(((Object) (abyte1)), j, ((Object) (body_data)), body_fill, k);
            body_fill += k;
        }
        i3 = -1;
        do
        {
            if(l >= k2)
                break;
            int l3 = abyte0[i + 27 + l] & 0xff;
            lacing_vals[lacing_fill] = l3;
            granule_vals[lacing_fill] = -1L;
            if(k1 != 0)
            {
                lacing_vals[lacing_fill] |= 0x100;
                k1 = 0;
            }
            if(l3 < 255)
                i3 = lacing_fill;
            lacing_fill++;
            l++;
            if(l3 < 255)
                lacing_packet = lacing_fill;
        } while(true);
        if(i3 != -1)
            granule_vals[i3] = l2;
        if(l1 != 0)
        {
            e_o_s = 1;
            if(lacing_fill > 0)
                lacing_vals[lacing_fill - 1] |= 0x200;
        }
        pageno = j2 + 1;
        return 0;
    }

    public int flush(Page page)
    {
        int i1 = 0;
        int j1 = lacing_fill <= 255 ? lacing_fill : 255;
        int k1 = 0;
        int l1 = 0;
        long l2 = granule_vals[0];
        if(j1 == 0)
            return 0;
        if(b_o_s == 0)
        {
            l2 = 0L;
            i1 = 0;
            do
            {
                if(i1 >= j1)
                    break;
                if((lacing_vals[i1] & 0xff) < 255)
                {
                    i1++;
                    break;
                }
                i1++;
            } while(true);
        } else
        {
            for(i1 = 0; i1 < j1 && l1 <= 4096; i1++)
            {
                l1 += lacing_vals[i1] & 0xff;
                l2 = granule_vals[i1];
            }

        }
        System.arraycopy(((Object) ("OggS".getBytes())), 0, ((Object) (header)), 0, 4);
        header[4] = 0;
        header[5] = 0;
        if((lacing_vals[0] & 0x100) == 0)
            header[5] |= 1;
        if(b_o_s == 0)
            header[5] |= 2;
        if(e_o_s != 0 && lacing_fill == i1)
            header[5] |= 4;
        b_o_s = 1;
        for(int i = 6; i < 14; i++)
        {
            header[i] = (byte)(int)l2;
            l2 >>>= 8;
        }

        int i2 = serialno;
        for(int j = 14; j < 18; j++)
        {
            header[j] = (byte)i2;
            i2 >>>= 8;
        }

        if(pageno == -1)
            pageno = 0;
        i2 = pageno++;
        for(int k = 18; k < 22; k++)
        {
            header[k] = (byte)i2;
            i2 >>>= 8;
        }

        header[22] = 0;
        header[23] = 0;
        header[24] = 0;
        header[25] = 0;
        header[26] = (byte)i1;
        for(int l = 0; l < i1; l++)
        {
            header[l + 27] = (byte)lacing_vals[l];
            k1 += header[l + 27] & 0xff;
        }

        page.header_base = header;
        page.header = 0;
        page.header_len = header_fill = i1 + 27;
        page.body_base = body_data;
        page.body = body_returned;
        page.body_len = k1;
        lacing_fill -= i1;
        System.arraycopy(((Object) (lacing_vals)), i1, ((Object) (lacing_vals)), 0, lacing_fill * 4);
        System.arraycopy(((Object) (granule_vals)), i1, ((Object) (granule_vals)), 0, lacing_fill * 8);
        body_returned += k1;
        page.checksum();
        return 1;
    }

    public int pageout(Page page)
    {
        if(e_o_s != 0 && lacing_fill != 0 || body_fill - body_returned > 4096 || lacing_fill >= 255 || lacing_fill != 0 && b_o_s == 0)
            return flush(page);
        else
            return 0;
    }

    public int eof()
    {
        return e_o_s;
    }

    public int reset()
    {
        body_fill = 0;
        body_returned = 0;
        lacing_fill = 0;
        lacing_packet = 0;
        lacing_returned = 0;
        header_fill = 0;
        e_o_s = 0;
        b_o_s = 0;
        pageno = -1;
        packetno = 0L;
        granulepos = 0L;
        return 0;
    }

    byte body_data[];
    int body_storage;
    int body_fill;
    private int body_returned;
    int lacing_vals[];
    long granule_vals[];
    int lacing_storage;
    int lacing_fill;
    int lacing_packet;
    int lacing_returned;
    byte header[];
    int header_fill;
    public int e_o_s;
    int b_o_s;
    int serialno;
    int pageno;
    long packetno;
    long granulepos;
}
