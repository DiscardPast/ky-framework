package com.kunyuesoft.common.utils;

/**
 * UUIDGenerator
 *
 * @author kunyuesoft
 */
public class UUIDGenerator {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
