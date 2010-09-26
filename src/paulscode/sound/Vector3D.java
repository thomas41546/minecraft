// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) deadcode ansi safe 
// Source File Name:   SourceFile

package paulscode.sound;


public class Vector3D
{

    public Vector3D()
    {
        x = 0.0F;
        y = 0.0F;
        z = 0.0F;
    }

    public Vector3D(float f, float f1, float f2)
    {
        x = f;
        y = f1;
        z = f2;
    }

    public Vector3D clone()
    {
        return new Vector3D(x, y, z);
    }

    public Vector3D cross(Vector3D vector3d, Vector3D vector3d1)
    {
        return new Vector3D(vector3d.y * vector3d1.z - vector3d1.y * vector3d.z, vector3d.z * vector3d1.x - vector3d1.z * vector3d.x, vector3d.x * vector3d1.y - vector3d1.x * vector3d.y);
    }

    public Vector3D cross(Vector3D vector3d)
    {
        return new Vector3D(y * vector3d.z - vector3d.y * z, z * vector3d.x - vector3d.z * x, x * vector3d.y - vector3d.x * y);
    }

    public float dot(Vector3D vector3d, Vector3D vector3d1)
    {
        return vector3d.x * vector3d1.x + vector3d.y * vector3d1.y + vector3d.z * vector3d1.z;
    }

    public float dot(Vector3D vector3d)
    {
        return x * vector3d.x + y * vector3d.y + z * vector3d.z;
    }

    public Vector3D add(Vector3D vector3d, Vector3D vector3d1)
    {
        return new Vector3D(vector3d.x + vector3d1.x, vector3d.y + vector3d1.y, vector3d.z + vector3d1.z);
    }

    public Vector3D add(Vector3D vector3d)
    {
        return new Vector3D(x + vector3d.x, y + vector3d.y, z + vector3d.z);
    }

    public Vector3D subtract(Vector3D vector3d, Vector3D vector3d1)
    {
        return new Vector3D(vector3d.x - vector3d1.x, vector3d.y - vector3d1.y, vector3d.z - vector3d1.z);
    }

    public Vector3D subtract(Vector3D vector3d)
    {
        return new Vector3D(x - vector3d.x, y - vector3d.y, z - vector3d.z);
    }

    public void normalize()
    {
        double d = Math.sqrt(x * x + y * y + z * z);
        x = (float)((double)x / d);
        y = (float)((double)y / d);
        z = (float)((double)z / d);
    }

    public volatile Object clone()
    {
        return ((Object) (clone()));
    }

    public float x;
    public float y;
    public float z;
}
