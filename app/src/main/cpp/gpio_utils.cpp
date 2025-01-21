
#include <cstring>
#include <cstdio>
#include <jni.h>
#include <android/log.h>




extern "C"
JNIEXPORT jboolean JNICALL
Java_cn_com_dihealth_util_GpioUtils_setUsbPower(JNIEnv *env, jclass clazz, jboolean power_type) {
    FILE *usb1Power;
    usb1Power = fopen("/sys/class/gpio_class/usb1Power", "w+");
    FILE *usb2Power;
    usb2Power = fopen("/sys/class/gpio_class/usb2Power", "w+");
    FILE *usb3Power;
    usb3Power = fopen("/sys/class/gpio_class/usb3Power", "w+");

    if (usb1Power == nullptr || usb2Power == nullptr || usb3Power == nullptr) {
        if(usb1Power == nullptr){
            __android_log_print(ANDROID_LOG_INFO, "GPIO_NATIVE", "usb1Power is not exit");
        }else{
            __android_log_print(ANDROID_LOG_INFO, "GPIO_NATIVE", "usb1Power is  exit");
        }
        if(usb2Power == nullptr){
            __android_log_print(ANDROID_LOG_INFO, "GPIO_NATIVE", "usb2Power is not exit");
        }else{
            __android_log_print(ANDROID_LOG_INFO, "GPIO_NATIVE", "usb2Power is  exit");
        }
        if(usb3Power == nullptr){
            __android_log_print(ANDROID_LOG_INFO, "GPIO_NATIVE", "usb3Power is not exit");
        }else{
            __android_log_print(ANDROID_LOG_INFO, "GPIO_NATIVE", "usb3Power is  exit");
        }
        return false;
    }
    if(power_type){
        //后续优化一下，区分usb1 ,2 ,3 的单独打开，因为广播的发送问题（连续）
        fwrite("1", 1, 1, usb1Power);
        fwrite("1", 1, 1, usb2Power);
        fwrite("1", 1, 1, usb3Power);
    }else{
        fwrite("0", 1, 1, usb1Power);
        fwrite("0", 1, 1, usb2Power);
        fwrite("0", 1, 1, usb3Power);
    }
    fclose(usb1Power);
    fclose(usb2Power);
    fclose(usb3Power);
    return true;
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_cn_com_dihealth_util_GpioUtils_setTTyPower(JNIEnv *env, jclass clazz, jboolean power_type) {

    FILE *ttyPower;
    ttyPower = fopen("/sys/class/gpio_class/ttyPower", "w+");
    if (ttyPower == nullptr) {
        __android_log_print(ANDROID_LOG_INFO, "GPIO_NATIVE", "ttyPower is not exit");
        return false;
    }
    if(power_type){
        //后续优化一下，区分usb1 ,2 ,3 的单独打开，因为广播的发送问题（连续）
        fwrite("1", 1, 1, ttyPower);
    }else{
        fwrite("0", 1, 1, ttyPower);
    }
    fclose(ttyPower);
    return true;
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_cn_com_dihealth_util_GpioUtils_setUsb1Power(JNIEnv *env, jclass clazz, jboolean power_type) {
    FILE *usb1Power;
    usb1Power = fopen("/sys/class/gpio_class/usb1Power", "r+");
    if (usb1Power == nullptr ) {
        __android_log_print(ANDROID_LOG_INFO, "GPIO_NATIVE", "usb1Power is not exit");
        return false;
    }
    if(power_type){
        //后续优化一下，区分usb1 ,2 ,3 的单独打开，因为广播的发送问题（连续）
        fwrite("1", 1, 1, usb1Power);
    }else{
        fwrite("0", 1, 1, usb1Power);
    }
    fclose(usb1Power);
    return true;
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_cn_com_dihealth_util_GpioUtils_setUsb2Power(JNIEnv *env, jclass clazz, jboolean power_type) {
    FILE *usb2Power;
    usb2Power = fopen("/sys/class/gpio_class/usb2Power", "r+");
    if (usb2Power == nullptr ) {
        __android_log_print(ANDROID_LOG_INFO, "GPIO_NATIVE", "usb1Power is not exit");
        return false;
    }
    if(power_type){
        //后续优化一下，区分usb1 ,2 ,3 的单独打开，因为广播的发送问题（连续）
        fwrite("1", 1, 1, usb2Power);
    }else{
        fwrite("0", 1, 1, usb2Power);
    }
    fclose(usb2Power);
    return true;
}
extern "C"
JNIEXPORT jboolean JNICALL
Java_cn_com_dihealth_util_GpioUtils_setUsb3Power(JNIEnv *env, jclass clazz, jboolean power_type) {
    FILE *usb3Power;
    usb3Power = fopen("/sys/class/gpio_class/usb3Power", "r+");
    if (usb3Power == nullptr ) {
        __android_log_print(ANDROID_LOG_INFO, "GPIO_NATIVE", "usb1Power is not exit");
        return false;
    }
    if(power_type){
        //后续优化一下，区分usb1 ,2 ,3 的单独打开，因为广播的发送问题（连续）
        fwrite("1", 1, 1, usb3Power);
    }else{
        fwrite("0", 1, 1, usb3Power);
    }
    fclose(usb3Power);
    return true;
}