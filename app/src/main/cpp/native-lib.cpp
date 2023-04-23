#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_calculator_CalculatorViewModel_addFromJNI(
        JNIEnv* env,
        jobject,
        jint a,
        jint b) {
    int res = a + b;
    std::string result = std::to_string(res);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_calculator_CalculatorViewModel_minusFromJNI(
        JNIEnv* env,
        jobject,
        jint a,
        jint b) {
    int res = a - b;
    std::string result = std::to_string(res);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_calculator_CalculatorViewModel_multiplyFromJNI(
        JNIEnv* env,
        jobject,
        jint a,
        jint b) {
    int res = a * b;
    std::string result = std::to_string(res);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_calculator_CalculatorViewModel_divideFromJNI(
        JNIEnv* env,
        jobject,
        jint a,
        jint b) {
    int res = a / b;
    std::string result = std::to_string(res);
    return env->NewStringUTF(result.c_str());
}
