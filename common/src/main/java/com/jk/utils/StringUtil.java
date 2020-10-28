package com.jk.utils;

public class StringUtil {

    /**
     * 判断字符串为空
     * @param str
     * @return
     */
    public static Boolean isEmpty(String str){
        if(str == null || "".equals(str) || str.length() <= 0 || str.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 判断字符串不为空
     * @param str
     * @return
     */
    public static Boolean isNotEmpty(String str) {
        if(!isEmpty(str)) {
            return true;
        }
        return false;
    }

}
