package com.kokoharry.common.util;
/**
 * Created by luyb on 2017/8/9.
 */
public class StringUtil {

    /**
     * ת��Ϊ�շ�
     *
     * @param underscoreName
     * @return
     */
    public static String camelCaseName(String underscoreName) {
        if(underscoreName.contains("temptable")){
            underscoreName = underscoreName.replace("temptable_","");
            underscoreName = underscoreName.substring(0,underscoreName.length()-36);
        }
        StringBuilder result = new StringBuilder();
        if (underscoreName != null && underscoreName.length() > 0) {
            boolean flag = false;
            for (int i = 0; i < underscoreName.length(); i++) {
                char ch = underscoreName.charAt(i);
                if ("_".charAt(0) == ch) {
                    flag = true;
                } else {
                    if (flag) {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                    } else {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }

    public static String upperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
