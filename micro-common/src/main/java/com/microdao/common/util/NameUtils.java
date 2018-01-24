package com.microdao.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fudh on 2018/1/24.
 */
public class NameUtils {
    /**
     * 把sql filedName转为 filed_name
     * @param fileName
     * @return
     */
    public static String getColumNameByFiled(String fileName){
        String prefix="[A-Z]";
        Pattern compile = Pattern.compile(prefix);
        Matcher matcher = compile.matcher(fileName);
        while (matcher.find()) {
            String group = matcher.group(0);
            fileName = fileName.replaceFirst(group, "_" + group);
            System.out.println(fileName);

        }
        return fileName.toLowerCase();
    }


}
