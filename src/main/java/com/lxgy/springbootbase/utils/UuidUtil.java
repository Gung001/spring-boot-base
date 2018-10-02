package com.lxgy.springbootbase.utils;

import java.util.UUID;

/**
 * @author Gryant
 */
public class UuidUtil {

    public static String get32Uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
