/*** com/example/jni/JNIJava.java **/

package com.example.jni;

public class JNIJava {
    static {
         System.out.println("dll path: " + JNIJava.class.getResource("com_example_jni_JNIJava.so").getPath());
        System.load(JNIJava.class.getResource("com_example_jni_JNIJava.so").getPath());
       // System.loadLibrary("test.o");
    }

    // Obviously, native methods may not have a body defined in Java
    public native void printString(String name);
    public static native double average(int[] nums);

    public static void main(final String[] args) {
        JNIJava jniJava = new JNIJava();
        jniJava.printString("Invoked C++1 'printString' from Java");

        double d = average(new int[]{1, 2, 3, 4, 7});
        System.out.println("Got result from C++ 'average': " + d);
    }
}
