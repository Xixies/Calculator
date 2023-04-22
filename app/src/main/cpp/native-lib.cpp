#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_calculator_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_calculator_MainActivity_addFromJNI(
        JNIEnv* env,
        jobject,
        jint a,
        jint b) {
    int res = a + b;
    std::string result = std::to_string(res);
    return env->NewStringUTF(result.c_str());
}
