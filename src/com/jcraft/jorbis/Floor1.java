// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;

// Referenced classes of package com.jcraft.jorbis:
//            FuncFloor, Block, CodeBook, DspState, 
//            Info, Util, InfoMode

class Floor1 extends FuncFloor
{

    Floor1()
    {
    }

    void pack(Object obj, Buffer buffer)
    {
        InfoFloor1 infofloor1 = (InfoFloor1)obj;
        int i = 0;
        int k = infofloor1.postlist[1];
        int l = -1;
        buffer.write(infofloor1.partitions, 5);
        for(int i1 = 0; i1 < infofloor1.partitions; i1++)
        {
            buffer.write(infofloor1.partitionclass[i1], 4);
            if(l < infofloor1.partitionclass[i1])
                l = infofloor1.partitionclass[i1];
        }

        for(int j1 = 0; j1 < l + 1; j1++)
        {
            buffer.write(infofloor1.class_dim[j1] - 1, 3);
            buffer.write(infofloor1.class_subs[j1], 2);
            if(infofloor1.class_subs[j1] != 0)
                buffer.write(infofloor1.class_book[j1], 8);
            for(int l1 = 0; l1 < 1 << infofloor1.class_subs[j1]; l1++)
                buffer.write(infofloor1.class_subbook[j1][l1] + 1, 8);

        }

        buffer.write(infofloor1.mult - 1, 2);
        buffer.write(Util.ilog2(k), 4);
        int j = Util.ilog2(k);
        int k1 = 0;
        int i2 = 0;
        for(; k1 < infofloor1.partitions; k1++)
            for(i += infofloor1.class_dim[infofloor1.partitionclass[k1]]; i2 < i; i2++)
                buffer.write(infofloor1.postlist[i2 + 2], j);


    }

    Object unpack(Info info, Buffer buffer)
    {
        int i = 0;
        int j = -1;
        InfoFloor1 infofloor1 = new InfoFloor1();
        infofloor1.partitions = buffer.read(5);
        for(int l = 0; l < infofloor1.partitions; l++)
        {
            infofloor1.partitionclass[l] = buffer.read(4);
            if(j < infofloor1.partitionclass[l])
                j = infofloor1.partitionclass[l];
        }

        for(int i1 = 0; i1 < j + 1; i1++)
        {
            infofloor1.class_dim[i1] = buffer.read(3) + 1;
            infofloor1.class_subs[i1] = buffer.read(2);
            if(infofloor1.class_subs[i1] < 0)
            {
                infofloor1.free();
                return ((Object) (null));
            }
            if(infofloor1.class_subs[i1] != 0)
                infofloor1.class_book[i1] = buffer.read(8);
            if(infofloor1.class_book[i1] < 0 || infofloor1.class_book[i1] >= info.books)
            {
                infofloor1.free();
                return ((Object) (null));
            }
            for(int k1 = 0; k1 < 1 << infofloor1.class_subs[i1]; k1++)
            {
                infofloor1.class_subbook[i1][k1] = buffer.read(8) - 1;
                if(infofloor1.class_subbook[i1][k1] < -1 || infofloor1.class_subbook[i1][k1] >= info.books)
                {
                    infofloor1.free();
                    return ((Object) (null));
                }
            }

        }

        infofloor1.mult = buffer.read(2) + 1;
        int k = buffer.read(4);
        int j1 = 0;
        int l1 = 0;
        for(; j1 < infofloor1.partitions; j1++)
            for(i += infofloor1.class_dim[infofloor1.partitionclass[j1]]; l1 < i; l1++)
            {
                int i2 = infofloor1.postlist[l1 + 2] = buffer.read(k);
                if(i2 < 0 || i2 >= 1 << k)
                {
                    infofloor1.free();
                    return ((Object) (null));
                }
            }


        infofloor1.postlist[0] = 0;
        infofloor1.postlist[1] = 1 << k;
        return ((Object) (infofloor1));
    }

    Object look(DspState dspstate, InfoMode infomode, Object obj)
    {
        int i = 0;
        int ai[] = new int[65];
        InfoFloor1 infofloor1 = (InfoFloor1)obj;
        LookFloor1 lookfloor1 = new LookFloor1();
        lookfloor1.vi = infofloor1;
        lookfloor1.n = infofloor1.postlist[1];
        for(int j = 0; j < infofloor1.partitions; j++)
            i += infofloor1.class_dim[infofloor1.partitionclass[j]];

        i += 2;
        lookfloor1.posts = i;
        for(int k = 0; k < i; k++)
            ai[k] = k;

        for(int i1 = 0; i1 < i - 1; i1++)
        {
            for(int j2 = i1; j2 < i; j2++)
                if(infofloor1.postlist[ai[i1]] > infofloor1.postlist[ai[j2]])
                {
                    int l = ai[j2];
                    ai[j2] = ai[i1];
                    ai[i1] = l;
                }

        }

        for(int j1 = 0; j1 < i; j1++)
            lookfloor1.forward_index[j1] = ai[j1];

        for(int k1 = 0; k1 < i; k1++)
            lookfloor1.reverse_index[lookfloor1.forward_index[k1]] = k1;

        for(int l1 = 0; l1 < i; l1++)
            lookfloor1.sorted_index[l1] = infofloor1.postlist[lookfloor1.forward_index[l1]];

        switch(infofloor1.mult)
        {
        case 1: // '\001'
            lookfloor1.quant_q = 256;
            break;

        case 2: // '\002'
            lookfloor1.quant_q = 128;
            break;

        case 3: // '\003'
            lookfloor1.quant_q = 86;
            break;

        case 4: // '\004'
            lookfloor1.quant_q = 64;
            break;

        default:
            lookfloor1.quant_q = -1;
            break;
        }
        for(int i2 = 0; i2 < i - 2; i2++)
        {
            int k2 = 0;
            int l2 = 1;
            int i3 = 0;
            int j3 = lookfloor1.n;
            int k3 = infofloor1.postlist[i2 + 2];
            for(int l3 = 0; l3 < i2 + 2; l3++)
            {
                int i4 = infofloor1.postlist[l3];
                if(i4 > i3 && i4 < k3)
                {
                    k2 = l3;
                    i3 = i4;
                }
                if(i4 < j3 && i4 > k3)
                {
                    l2 = l3;
                    j3 = i4;
                }
            }

            lookfloor1.loneighbor[i2] = k2;
            lookfloor1.hineighbor[i2] = l2;
        }

        return ((Object) (lookfloor1));
    }

    void free_info(Object obj)
    {
    }

    void free_look(Object obj)
    {
    }

    void free_state(Object obj)
    {
    }

    int forward(Block block, Object obj, float af[], float af1[], Object obj1)
    {
        return 0;
    }

    Object inverse1(Block block, Object obj, Object obj1)
    {
        LookFloor1 lookfloor1 = (LookFloor1)obj;
        InfoFloor1 infofloor1 = lookfloor1.vi;
        CodeBook acodebook[] = block.vd.fullbooks;
        if(block.opb.read(1) == 1)
        {
            int ai[] = null;
            if(obj1 instanceof int[])
                ai = (int[])(int[])obj1;
            if(ai == null || ai.length < lookfloor1.posts)
            {
                ai = new int[lookfloor1.posts];
            } else
            {
                for(int i = 0; i < ai.length; i++)
                    ai[i] = 0;

            }
            ai[0] = block.opb.read(Util.ilog(lookfloor1.quant_q - 1));
            ai[1] = block.opb.read(Util.ilog(lookfloor1.quant_q - 1));
            int j = 0;
            int l = 2;
            for(; j < infofloor1.partitions; j++)
            {
                int j1 = infofloor1.partitionclass[j];
                int l1 = infofloor1.class_dim[j1];
                int j2 = infofloor1.class_subs[j1];
                int l2 = 1 << j2;
                int j3 = 0;
                if(j2 != 0)
                {
                    j3 = acodebook[infofloor1.class_book[j1]].decode(block.opb);
                    if(j3 == -1)
                        return ((Object) (null));
                }
                for(int k3 = 0; k3 < l1; k3++)
                {
                    int l3 = infofloor1.class_subbook[j1][j3 & l2 - 1];
                    j3 >>>= j2;
                    if(l3 >= 0)
                    {
                        if((ai[l + k3] = acodebook[l3].decode(block.opb)) == -1)
                            return ((Object) (null));
                    } else
                    {
                        ai[l + k3] = 0;
                    }
                }

                l += l1;
            }

            for(int k = 2; k < lookfloor1.posts; k++)
            {
                int i1 = render_point(infofloor1.postlist[lookfloor1.loneighbor[k - 2]], infofloor1.postlist[lookfloor1.hineighbor[k - 2]], ai[lookfloor1.loneighbor[k - 2]], ai[lookfloor1.hineighbor[k - 2]], infofloor1.postlist[k]);
                int k1 = lookfloor1.quant_q - i1;
                int i2 = i1;
                int k2 = (k1 >= i2 ? i2 : k1) << 1;
                int i3 = ai[k];
                if(i3 != 0)
                {
                    if(i3 >= k2)
                    {
                        if(k1 > i2)
                            i3 -= i2;
                        else
                            i3 = -1 - (i3 - k1);
                    } else
                    if((i3 & 1) != 0)
                        i3 = -(i3 + 1 >>> 1);
                    else
                        i3 >>= 1;
                    ai[k] = i3 + i1;
                    ai[lookfloor1.loneighbor[k - 2]] &= 0x7fff;
                    ai[lookfloor1.hineighbor[k - 2]] &= 0x7fff;
                } else
                {
                    ai[k] = i1 | 0x8000;
                }
            }

            return ((Object) (ai));
        } else
        {
            return ((Object) (null));
        }
    }

    private static int render_point(int i, int j, int k, int l, int i1)
    {
        k &= 0x7fff;
        l &= 0x7fff;
        int j1 = l - k;
        int k1 = j - i;
        int l1 = Math.abs(j1);
        int i2 = l1 * (i1 - i);
        int j2 = i2 / k1;
        if(j1 < 0)
            return k - j2;
        else
            return k + j2;
    }

    int inverse2(Block block, Object obj, Object obj1, float af[])
    {
        LookFloor1 lookfloor1 = (LookFloor1)obj;
        InfoFloor1 infofloor1 = lookfloor1.vi;
        int i = block.vd.vi.blocksizes[block.mode] / 2;
        if(obj1 != null)
        {
            int ai[] = (int[])(int[])obj1;
            int k = 0;
            int l = 0;
            int i1 = ai[0] * infofloor1.mult;
            for(int j1 = 1; j1 < lookfloor1.posts; j1++)
            {
                int l1 = lookfloor1.forward_index[j1];
                int i2 = ai[l1] & 0x7fff;
                if(i2 == ai[l1])
                {
                    i2 *= infofloor1.mult;
                    k = infofloor1.postlist[l1];
                    render_line(l, k, i1, i2, af);
                    l = k;
                    i1 = i2;
                }
            }

            for(int k1 = k; k1 < i; k1++)
                af[k1] *= af[k1 - 1];

            return 1;
        }
        for(int j = 0; j < i; j++)
            af[j] = 0.0F;

        return 0;
    }

    private static void render_line(int i, int j, int k, int l, float af[])
    {
        int i1 = l - k;
        int j1 = j - i;
        int k1 = Math.abs(i1);
        int l1 = i1 / j1;
        int i2 = i1 >= 0 ? l1 + 1 : l1 - 1;
        int j2 = i;
        int k2 = k;
        int l2 = 0;
        k1 -= Math.abs(l1 * j1);
        for(af[j2] *= FLOOR_fromdB_LOOKUP[k2]; ++j2 < j; af[j2] *= FLOOR_fromdB_LOOKUP[k2])
        {
            l2 += k1;
            if(l2 >= j1)
            {
                l2 -= j1;
                k2 += i2;
            } else
            {
                k2 += l1;
            }
        }

    }

    static final int floor1_rangedb = 140;
    static final int VIF_POSIT = 63;
    private static float FLOOR_fromdB_LOOKUP[] = {
        1.064986E-007F, 1.134195E-007F, 1.207901E-007F, 1.286398E-007F, 1.369995E-007F, 1.459025E-007F, 1.553841E-007F, 1.654818E-007F, 1.762357E-007F, 1.876886E-007F, 
        1.998856E-007F, 2.128753E-007F, 2.267091E-007F, 2.41442E-007F, 2.571322E-007F, 2.738421E-007F, 2.916379E-007F, 3.105902E-007F, 3.307741E-007F, 3.522697E-007F, 
        3.751621E-007F, 3.995423E-007F, 4.255068E-007F, 4.531586E-007F, 4.826074E-007F, 5.1397E-007F, 5.473706E-007F, 5.829419E-007F, 6.208247E-007F, 6.611694E-007F, 
        7.041359E-007F, 7.498946E-007F, 7.98627E-007F, 8.505263E-007F, 9.057983E-007F, 9.646621E-007F, 1.027351E-006F, 1.094114E-006F, 1.165216E-006F, 1.240938E-006F, 
        1.321582E-006F, 1.407465E-006F, 1.49893E-006F, 1.596339E-006F, 1.700079E-006F, 1.810559E-006F, 1.928219E-006F, 2.053526E-006F, 2.186976E-006F, 2.329098E-006F, 
        2.480456E-006F, 2.64165E-006F, 2.813319E-006F, 2.996144E-006F, 3.190851E-006F, 3.39821E-006F, 3.619045E-006F, 3.854231E-006F, 4.104701E-006F, 4.371447E-006F, 
        4.655528E-006F, 4.958071E-006F, 5.280274E-006F, 5.623416E-006F, 5.988857E-006F, 6.378047E-006F, 6.792528E-006F, 7.233945E-006F, 7.704048E-006F, 8.2047E-006F, 
        8.737888E-006F, 9.305725E-006F, 9.910464E-006F, 1.05545E-005F, 1.124039E-005F, 1.197086E-005F, 1.274879E-005F, 1.357728E-005F, 1.445961E-005F, 1.539927E-005F, 
        1.64E-005F, 1.746577E-005F, 1.860079E-005F, 1.980958E-005F, 2.109691E-005F, 2.246791E-005F, 2.3928E-005F, 2.548298E-005F, 2.713901E-005F, 2.890265E-005F, 
        3.078091E-005F, 3.278123E-005F, 3.491153E-005F, 3.718028E-005F, 3.959647E-005F, 4.216967E-005F, 4.491009E-005F, 4.78286E-005F, 5.093677E-005F, 5.424693E-005F, 
        5.77722E-005F, 6.152657E-005F, 6.552491E-005F, 6.978308E-005F, 7.431798E-005F, 7.914758E-005F, 8.429104E-005F, 8.976875E-005F, 9.560242E-005F, 0.0001018152F, 
        0.0001084317F, 0.0001154782F, 0.0001229827F, 0.0001309748F, 0.0001394862F, 0.0001485509F, 0.0001582045F, 0.0001684856F, 0.0001794347F, 0.0001910954F, 
        0.0002035138F, 0.0002167393F, 0.0002308242F, 0.0002458245F, 0.0002617995F, 0.0002788127F, 0.0002969316F, 0.0003162279F, 0.0003367781F, 0.0003586639F, 
        0.0003819719F, 0.0004067946F, 0.0004332304F, 0.0004613841F, 0.0004913675F, 0.0005232993F, 0.0005573062F, 0.0005935231F, 0.0006320936F, 0.0006731706F, 
        0.000716917F, 0.0007635063F, 0.0008131232F, 0.0008659646F, 0.0009222399F, 0.0009821722F, 0.001045999F, 0.001113974F, 0.001186367F, 0.001263463F, 
        0.00134557F, 0.001433013F, 0.001526138F, 0.001625315F, 0.001730937F, 0.001843423F, 0.00196322F, 0.002090801F, 0.002226673F, 0.002371374F, 
        0.00252548F, 0.002689599F, 0.002864385F, 0.003050529F, 0.003248769F, 0.003459892F, 0.003684736F, 0.003924191F, 0.004179207F, 0.004450795F, 
        0.004740033F, 0.005048067F, 0.005376119F, 0.005725489F, 0.006097564F, 0.006493818F, 0.006915823F, 0.007365251F, 0.007843887F, 0.008353627F, 
        0.008896492F, 0.009474637F, 0.01009035F, 0.01074608F, 0.01144442F, 0.01218814F, 0.0129802F, 0.01382373F, 0.01472207F, 0.01567879F, 
        0.01669769F, 0.0177828F, 0.01893842F, 0.02016915F, 0.02147985F, 0.02287574F, 0.02436233F, 0.02594553F, 0.02763162F, 0.02942728F, 
        0.03133963F, 0.03337625F, 0.03554523F, 0.03785516F, 0.0403152F, 0.04293511F, 0.04572527F, 0.04869676F, 0.05186135F, 0.05523159F, 
        0.05882085F, 0.06264336F, 0.06671428F, 0.07104975F, 0.07566696F, 0.08058423F, 0.08582105F, 0.09139818F, 0.09733775F, 0.1036633F, 
        0.1103999F, 0.1175743F, 0.125215F, 0.1333521F, 0.1420181F, 0.1512473F, 0.1610762F, 0.1715438F, 0.1826917F, 0.194564F, 
        0.2072079F, 0.2206734F, 0.235014F, 0.2502865F, 0.2665516F, 0.2838736F, 0.3023213F, 0.3219679F, 0.3428911F, 0.3651741F, 
        0.3889052F, 0.4141785F, 0.4410941F, 0.4697589F, 0.5002865F, 0.5327979F, 0.5674221F, 0.6042964F, 0.643567F, 0.6853896F, 
        0.72993F, 0.777365F, 0.8278826F, 0.8816831F, 0.9389798F, 1.0F
    };


    private class InfoFloor1
    {

        void free()
        {
            partitionclass = null;
            class_dim = null;
            class_subs = null;
            class_book = null;
            class_subbook = (int[][])null;
            postlist = null;
        }

        Object copy_info()
        {
            InfoFloor1 infofloor1 = this;
            InfoFloor1 infofloor1_1 = new InfoFloor1();
            infofloor1_1.partitions = infofloor1.partitions;
            System.arraycopy(((Object) (infofloor1.partitionclass)), 0, ((Object) (infofloor1_1.partitionclass)), 0, 31);
            System.arraycopy(((Object) (infofloor1.class_dim)), 0, ((Object) (infofloor1_1.class_dim)), 0, 16);
            System.arraycopy(((Object) (infofloor1.class_subs)), 0, ((Object) (infofloor1_1.class_subs)), 0, 16);
            System.arraycopy(((Object) (infofloor1.class_book)), 0, ((Object) (infofloor1_1.class_book)), 0, 16);
            for(int i = 0; i < 16; i++)
                System.arraycopy(((Object) (infofloor1.class_subbook[i])), 0, ((Object) (infofloor1_1.class_subbook[i])), 0, 8);

            infofloor1_1.mult = infofloor1.mult;
            System.arraycopy(((Object) (infofloor1.postlist)), 0, ((Object) (infofloor1_1.postlist)), 0, 65);
            infofloor1_1.maxover = infofloor1.maxover;
            infofloor1_1.maxunder = infofloor1.maxunder;
            infofloor1_1.maxerr = infofloor1.maxerr;
            infofloor1_1.twofitminsize = infofloor1.twofitminsize;
            infofloor1_1.twofitminused = infofloor1.twofitminused;
            infofloor1_1.twofitweight = infofloor1.twofitweight;
            infofloor1_1.twofitatten = infofloor1.twofitatten;
            infofloor1_1.unusedminsize = infofloor1.unusedminsize;
            infofloor1_1.unusedmin_n = infofloor1.unusedmin_n;
            infofloor1_1.n = infofloor1.n;
            return ((Object) (infofloor1_1));
        }

        static final int VIF_POSIT = 63;
        static final int VIF_CLASS = 16;
        static final int VIF_PARTS = 31;
        int partitions;
        int partitionclass[];
        int class_dim[];
        int class_subs[];
        int class_book[];
        int class_subbook[][];
        int mult;
        int postlist[];
        float maxover;
        float maxunder;
        float maxerr;
        int twofitminsize;
        int twofitminused;
        int twofitweight;
        float twofitatten;
        int unusedminsize;
        int unusedmin_n;
        int n;
        final Floor1 this$0;

        InfoFloor1()
        {
            this$0 = Floor1.this;
            super();
            partitionclass = new int[31];
            class_dim = new int[16];
            class_subs = new int[16];
            class_book = new int[16];
            class_subbook = new int[16][];
            postlist = new int[65];
            for(int i = 0; i < class_subbook.length; i++)
                class_subbook[i] = new int[8];

        }
    }


    private class LookFloor1
    {

        void free()
        {
            sorted_index = null;
            forward_index = null;
            reverse_index = null;
            hineighbor = null;
            loneighbor = null;
        }

        static final int VIF_POSIT = 63;
        int sorted_index[];
        int forward_index[];
        int reverse_index[];
        int hineighbor[];
        int loneighbor[];
        int posts;
        int n;
        int quant_q;
        InfoFloor1 vi;
        int phrasebits;
        int postbits;
        int frames;
        final Floor1 this$0;

        LookFloor1()
        {
            this$0 = Floor1.this;
            super();
            sorted_index = new int[65];
            forward_index = new int[65];
            reverse_index = new int[65];
            hineighbor = new int[63];
            loneighbor = new int[63];
        }
    }

}
