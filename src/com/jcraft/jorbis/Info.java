// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;
import com.jcraft.jogg.Packet;

// Referenced classes of package com.jcraft.jorbis:
//            Comment, FuncFloor, FuncMapping, FuncResidue, 
//            FuncTime, InfoMode, PsyInfo, StaticCodeBook, 
//            Util

public class Info
{

    public Info()
    {
        blocksizes = new int[2];
        mode_param = null;
        map_type = null;
        map_param = null;
        time_type = null;
        time_param = null;
        floor_type = null;
        floor_param = null;
        residue_type = null;
        residue_param = null;
        book_param = null;
        psy_param = new PsyInfo[64];
    }

    public void init()
    {
        rate = 0;
    }

    public void clear()
    {
        for(int i = 0; i < modes; i++)
            mode_param[i] = null;

        mode_param = null;
        for(int j = 0; j < maps; j++)
            FuncMapping.mapping_P[map_type[j]].free_info(map_param[j]);

        map_param = null;
        for(int k = 0; k < times; k++)
            FuncTime.time_P[time_type[k]].free_info(time_param[k]);

        time_param = null;
        for(int l = 0; l < floors; l++)
            FuncFloor.floor_P[floor_type[l]].free_info(floor_param[l]);

        floor_param = null;
        for(int i1 = 0; i1 < residues; i1++)
            FuncResidue.residue_P[residue_type[i1]].free_info(residue_param[i1]);

        residue_param = null;
        for(int j1 = 0; j1 < books; j1++)
            if(book_param[j1] != null)
            {
                book_param[j1].clear();
                book_param[j1] = null;
            }

        book_param = null;
        for(int k1 = 0; k1 < psys; k1++)
            psy_param[k1].free();

    }

    int unpack_info(Buffer buffer)
    {
        version = buffer.read(32);
        if(version != 0)
            return -1;
        channels = buffer.read(8);
        rate = buffer.read(32);
        bitrate_upper = buffer.read(32);
        bitrate_nominal = buffer.read(32);
        bitrate_lower = buffer.read(32);
        blocksizes[0] = 1 << buffer.read(4);
        blocksizes[1] = 1 << buffer.read(4);
        if(rate < 1 || channels < 1 || blocksizes[0] < 8 || blocksizes[1] < blocksizes[0] || buffer.read(1) != 1)
        {
            clear();
            return -1;
        } else
        {
            return 0;
        }
    }

    int unpack_books(Buffer buffer)
    {
        books = buffer.read(8) + 1;
        if(book_param == null || book_param.length != books)
            book_param = new StaticCodeBook[books];
        for(int i = 0; i < books; i++)
        {
            book_param[i] = new StaticCodeBook();
            if(book_param[i].unpack(buffer) != 0)
            {
                clear();
                return -1;
            }
        }

        times = buffer.read(6) + 1;
        if(time_type == null || time_type.length != times)
            time_type = new int[times];
        if(time_param == null || time_param.length != times)
            time_param = new Object[times];
        for(int j = 0; j < times; j++)
        {
            time_type[j] = buffer.read(16);
            if(time_type[j] < 0 || time_type[j] >= 1)
            {
                clear();
                return -1;
            }
            time_param[j] = FuncTime.time_P[time_type[j]].unpack(this, buffer);
            if(time_param[j] == null)
            {
                clear();
                return -1;
            }
        }

        floors = buffer.read(6) + 1;
        if(floor_type == null || floor_type.length != floors)
            floor_type = new int[floors];
        if(floor_param == null || floor_param.length != floors)
            floor_param = new Object[floors];
        for(int k = 0; k < floors; k++)
        {
            floor_type[k] = buffer.read(16);
            if(floor_type[k] < 0 || floor_type[k] >= 2)
            {
                clear();
                return -1;
            }
            floor_param[k] = FuncFloor.floor_P[floor_type[k]].unpack(this, buffer);
            if(floor_param[k] == null)
            {
                clear();
                return -1;
            }
        }

        residues = buffer.read(6) + 1;
        if(residue_type == null || residue_type.length != residues)
            residue_type = new int[residues];
        if(residue_param == null || residue_param.length != residues)
            residue_param = new Object[residues];
        for(int l = 0; l < residues; l++)
        {
            residue_type[l] = buffer.read(16);
            if(residue_type[l] < 0 || residue_type[l] >= 3)
            {
                clear();
                return -1;
            }
            residue_param[l] = FuncResidue.residue_P[residue_type[l]].unpack(this, buffer);
            if(residue_param[l] == null)
            {
                clear();
                return -1;
            }
        }

        maps = buffer.read(6) + 1;
        if(map_type == null || map_type.length != maps)
            map_type = new int[maps];
        if(map_param == null || map_param.length != maps)
            map_param = new Object[maps];
        for(int i1 = 0; i1 < maps; i1++)
        {
            map_type[i1] = buffer.read(16);
            if(map_type[i1] < 0 || map_type[i1] >= 1)
            {
                clear();
                return -1;
            }
            map_param[i1] = FuncMapping.mapping_P[map_type[i1]].unpack(this, buffer);
            if(map_param[i1] == null)
            {
                clear();
                return -1;
            }
        }

        modes = buffer.read(6) + 1;
        if(mode_param == null || mode_param.length != modes)
            mode_param = new InfoMode[modes];
        for(int j1 = 0; j1 < modes; j1++)
        {
            mode_param[j1] = new InfoMode();
            mode_param[j1].blockflag = buffer.read(1);
            mode_param[j1].windowtype = buffer.read(16);
            mode_param[j1].transformtype = buffer.read(16);
            mode_param[j1].mapping = buffer.read(8);
            if(mode_param[j1].windowtype >= 1 || mode_param[j1].transformtype >= 1 || mode_param[j1].mapping >= maps)
            {
                clear();
                return -1;
            }
        }

        if(buffer.read(1) != 1)
        {
            clear();
            return -1;
        } else
        {
            return 0;
        }
    }

    public int synthesis_headerin(Comment comment, Packet packet)
    {
        Buffer buffer = new Buffer();
        if(packet != null)
        {
            buffer.readinit(packet.packet_base, packet.packet, packet.bytes);
            byte abyte0[] = new byte[6];
            int i = buffer.read(8);
            buffer.read(abyte0, 6);
            if(abyte0[0] != 118 || abyte0[1] != 111 || abyte0[2] != 114 || abyte0[3] != 98 || abyte0[4] != 105 || abyte0[5] != 115)
                return -1;
            switch(i)
            {
            case 1: // '\001'
                if(packet.b_o_s == 0)
                    return -1;
                if(rate != 0)
                    return -1;
                else
                    return unpack_info(buffer);

            case 3: // '\003'
                if(rate == 0)
                    return -1;
                else
                    return comment.unpack(buffer);

            case 5: // '\005'
                if(rate == 0 || comment.vendor == null)
                    return -1;
                else
                    return unpack_books(buffer);
            }
        }
        return -1;
    }

    int pack_info(Buffer buffer)
    {
        buffer.write(1, 8);
        buffer.write(_vorbis);
        buffer.write(0, 32);
        buffer.write(channels, 8);
        buffer.write(rate, 32);
        buffer.write(bitrate_upper, 32);
        buffer.write(bitrate_nominal, 32);
        buffer.write(bitrate_lower, 32);
        buffer.write(Util.ilog2(blocksizes[0]), 4);
        buffer.write(Util.ilog2(blocksizes[1]), 4);
        buffer.write(1, 1);
        return 0;
    }

    int pack_books(Buffer buffer)
    {
        buffer.write(5, 8);
        buffer.write(_vorbis);
        buffer.write(books - 1, 8);
        for(int i = 0; i < books; i++)
            if(book_param[i].pack(buffer) != 0)
                return -1;

        buffer.write(times - 1, 6);
        for(int j = 0; j < times; j++)
        {
            buffer.write(time_type[j], 16);
            FuncTime.time_P[time_type[j]].pack(time_param[j], buffer);
        }

        buffer.write(floors - 1, 6);
        for(int k = 0; k < floors; k++)
        {
            buffer.write(floor_type[k], 16);
            FuncFloor.floor_P[floor_type[k]].pack(floor_param[k], buffer);
        }

        buffer.write(residues - 1, 6);
        for(int l = 0; l < residues; l++)
        {
            buffer.write(residue_type[l], 16);
            FuncResidue.residue_P[residue_type[l]].pack(residue_param[l], buffer);
        }

        buffer.write(maps - 1, 6);
        for(int i1 = 0; i1 < maps; i1++)
        {
            buffer.write(map_type[i1], 16);
            FuncMapping.mapping_P[map_type[i1]].pack(this, map_param[i1], buffer);
        }

        buffer.write(modes - 1, 6);
        for(int j1 = 0; j1 < modes; j1++)
        {
            buffer.write(mode_param[j1].blockflag, 1);
            buffer.write(mode_param[j1].windowtype, 16);
            buffer.write(mode_param[j1].transformtype, 16);
            buffer.write(mode_param[j1].mapping, 8);
        }

        buffer.write(1, 1);
        return 0;
    }

    public int blocksize(Packet packet)
    {
        Buffer buffer = new Buffer();
        buffer.readinit(packet.packet_base, packet.packet, packet.bytes);
        if(buffer.read(1) != 0)
            return -135;
        int j = 0;
        for(int k = modes; k > 1; k >>>= 1)
            j++;

        int i = buffer.read(j);
        if(i == -1)
            return -136;
        else
            return blocksizes[mode_param[i].blockflag];
    }

    public String toString()
    {
        return (new StringBuilder()).append("version:").append(((Object) (new Integer(version)))).append(", channels:").append(((Object) (new Integer(channels)))).append(", rate:").append(((Object) (new Integer(rate)))).append(", bitrate:").append(((Object) (new Integer(bitrate_upper)))).append(",").append(((Object) (new Integer(bitrate_nominal)))).append(",").append(((Object) (new Integer(bitrate_lower)))).toString();
    }

    private static final int OV_EBADPACKET = -136;
    private static final int OV_ENOTAUDIO = -135;
    private static byte _vorbis[] = "vorbis".getBytes();
    private static final int VI_TIMEB = 1;
    private static final int VI_FLOORB = 2;
    private static final int VI_RESB = 3;
    private static final int VI_MAPB = 1;
    private static final int VI_WINDOWB = 1;
    public int version;
    public int channels;
    public int rate;
    int bitrate_upper;
    int bitrate_nominal;
    int bitrate_lower;
    int blocksizes[];
    int modes;
    int maps;
    int times;
    int floors;
    int residues;
    int books;
    int psys;
    InfoMode mode_param[];
    int map_type[];
    Object map_param[];
    int time_type[];
    Object time_param[];
    int floor_type[];
    Object floor_param[];
    int residue_type[];
    Object residue_param[];
    StaticCodeBook book_param[];
    PsyInfo psy_param[];
    int envelopesa;
    float preecho_thresh;
    float preecho_clamp;

}
