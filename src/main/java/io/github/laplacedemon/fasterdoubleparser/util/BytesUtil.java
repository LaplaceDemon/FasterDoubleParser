package io.github.laplacedemon.fasterdoubleparser.util;

import sun.misc.Unsafe;

public class BytesUtil {

    private static final Unsafe UNSAFE;

    private static final long BYTES_FIRST_OFFSET;
    private static final long BYTES_ELEMENT_SIZE;

    static {
        UNSAFE = MyUnsafe.getUnsafe();
        BYTES_FIRST_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);
        BYTES_ELEMENT_SIZE = UNSAFE.arrayIndexScale(byte[].class);
    }

    public static long readLongFromByteArrayGet(byte[] str, int index) {
        return UNSAFE.getLong(str, BYTES_FIRST_OFFSET + BYTES_ELEMENT_SIZE * index);
    }
}
