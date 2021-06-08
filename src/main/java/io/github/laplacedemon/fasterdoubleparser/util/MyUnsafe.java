package io.github.laplacedemon.fasterdoubleparser.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

class MyUnsafe {
    private final static Unsafe unsafe;

    static {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe u = null;
        try {
            u = (Unsafe) unsafeField.get(null);
        } catch (IllegalAccessException e) {
        }
        unsafe = u;
    }

    private MyUnsafe() {}

    static Unsafe getUnsafe() {
        return unsafe;
    }
}
