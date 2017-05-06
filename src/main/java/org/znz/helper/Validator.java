package org.znz.helper;

import java.util.List;

/**
 * Created by zhouxin on 17-5-6.
 */
public class Validator {
    public static boolean blank(String[] stringArray){
        for(String string : stringArray) {
            if(string == null || string.length() == 0) {
                return true;
            }
        }
        return false;
    }
}
