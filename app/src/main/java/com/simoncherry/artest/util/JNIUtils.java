package com.simoncherry.artest.util;

/**
 * <pre>
 *     author : machenshuang
 * </pre>
 */
public class JNIUtils {

    static {
        System.loadLibrary("JNI_APP");
    }

    public static native int[] doGrayScale(int[] buf, int w, int h);

    public static native String doFaceSwap(String[] paths);
}
