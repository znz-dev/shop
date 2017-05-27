package org.znz.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbin on 17-5-6.
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

    public static List RemoveAllNull(List list) {
        List e = new ArrayList(1);
        e.add(null);
        list.removeAll(e);
        return list;
    }
}
