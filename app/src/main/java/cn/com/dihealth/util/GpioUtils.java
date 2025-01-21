package cn.com.dihealth.util;

public class GpioUtils {
    static {
        System.loadLibrary("gpio-utils");
    }

    public static native boolean setUsbPower(boolean powerType);

    public static native boolean setTTyPower(boolean powerType);

    public static native boolean setUsb1Power(boolean powerType);

    public static native boolean setUsb2Power(boolean powerType);

    public static native boolean setUsb3Power(boolean powerType);


}
