// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;


// Referenced classes of package paulscode.sound:
//            Vector3D

public class ListenerData
{

    public ListenerData()
    {
        angle = 0.0F;
        position = new Vector3D(0.0F, 0.0F, 0.0F);
        lookAt = new Vector3D(0.0F, 0.0F, -1F);
        up = new Vector3D(0.0F, 1.0F, 0.0F);
        angle = 0.0F;
    }

    public ListenerData(float f, float f1, float f2, float f3, float f4, float f5, float f6, 
            float f7, float f8, float f9)
    {
        angle = 0.0F;
        position = new Vector3D(f, f1, f2);
        lookAt = new Vector3D(f3, f4, f5);
        up = new Vector3D(f6, f7, f8);
        angle = f9;
    }

    public ListenerData(Vector3D vector3d, Vector3D vector3d1, Vector3D vector3d2, float f)
    {
        angle = 0.0F;
        position = vector3d.clone();
        lookAt = vector3d1.clone();
        up = vector3d2.clone();
        angle = f;
    }

    public void setData(float f, float f1, float f2, float f3, float f4, float f5, float f6, 
            float f7, float f8, float f9)
    {
        position.x = f;
        position.y = f1;
        position.z = f2;
        lookAt.x = f3;
        lookAt.y = f4;
        lookAt.z = f5;
        up.x = f6;
        up.y = f7;
        up.z = f8;
        angle = f9;
    }

    public void setData(Vector3D vector3d, Vector3D vector3d1, Vector3D vector3d2, float f)
    {
        position.x = vector3d.x;
        position.y = vector3d.y;
        position.z = vector3d.z;
        lookAt.x = vector3d1.x;
        lookAt.y = vector3d1.y;
        lookAt.z = vector3d1.z;
        up.x = vector3d2.x;
        up.y = vector3d2.y;
        up.z = vector3d2.z;
        angle = f;
    }

    public void setData(ListenerData listenerdata)
    {
        position.x = listenerdata.position.x;
        position.y = listenerdata.position.y;
        position.z = listenerdata.position.z;
        lookAt.x = listenerdata.lookAt.x;
        lookAt.y = listenerdata.lookAt.y;
        lookAt.z = listenerdata.lookAt.z;
        up.x = listenerdata.up.x;
        up.y = listenerdata.up.y;
        up.z = listenerdata.up.z;
        angle = listenerdata.angle;
    }

    public void setPosition(float f, float f1, float f2)
    {
        position.x = f;
        position.y = f1;
        position.z = f2;
    }

    public void setPosition(Vector3D vector3d)
    {
        position.x = vector3d.x;
        position.y = vector3d.y;
        position.z = vector3d.z;
    }

    public void setOrientation(float f, float f1, float f2, float f3, float f4, float f5)
    {
        lookAt.x = f;
        lookAt.y = f1;
        lookAt.z = f2;
        up.x = f3;
        up.y = f4;
        up.z = f5;
    }

    public void setOrientation(Vector3D vector3d, Vector3D vector3d1)
    {
        lookAt.x = vector3d.x;
        lookAt.y = vector3d.y;
        lookAt.z = vector3d.z;
        up.x = vector3d1.x;
        up.y = vector3d1.y;
        up.z = vector3d1.z;
    }

    public void setAngle(float f)
    {
        angle = f;
        lookAt.x = -1F * (float)Math.sin(angle);
        lookAt.z = -1F * (float)Math.cos(angle);
    }

    public Vector3D position;
    public Vector3D lookAt;
    public Vector3D up;
    public float angle;
}
