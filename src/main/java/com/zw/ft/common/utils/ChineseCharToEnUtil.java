package com.zw.ft.common.utils;


import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Oliver
 * @date 2021/1/25 10:54
 * @description
 */
public class ChineseCharToEnUtil {

    /**
     * 功能描述 : 获取中文拼音首字母，其他字符不变
     * @author Oliver 2021-1-25 11:02
     */
    public static String getShortPinyin(String str) {
        return getShortPinyin(str, true);
    }

    /**
     * 功能描述 : 获取中文拼音首字母
     * @param retain 为true保留其他字符
     * @author Oliver 2021-1-25 11:02
     */
    public static String getShortPinyin(String str, boolean retain) {
        return getPinyin(str, true, retain);
    }

    /**
     * 功能描述 : 获取中文拼音，其他字符不变
     * @author Oliver 2021-1-25 11:02
     */
    public static String getFullPinyin(String str) {
        return getFullPinyin(str, true);
    }

    /**
     * 功能描述 : 获取中文拼音
     * @author Oliver 2021-1-25 11:02
     */
    public static String getFullPinyin(String str, boolean retain) {
        return getPinyin(str, false, retain);
    }

    /**
     * 功能描述 : 获取中文拼音
     * @param shortPinyin 为true获取中文拼音首字母
     * @param retain 为true保留其他字符
     * @author Oliver 2021-1-25 11:02
     */
    private static String getPinyin(String str, boolean shortPinyin, boolean retain) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        StringBuilder pinyinBuffer = new StringBuilder();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            String[] temp = PinyinHelper.toHanyuPinyinStringArray(c);
            if (ArrayUtils.isNotEmpty(temp)) {
                if (StringUtils.isNotBlank(temp[0])) {
                    if (shortPinyin) {
                        pinyinBuffer.append(temp[0].charAt(0));
                    } else {
                        pinyinBuffer.append(temp[0].replaceAll("\\d", ""));
                    }
                }
            } else {
                if (retain) {
                    pinyinBuffer.append(c);
                }
            }
        }
        return pinyinBuffer.toString();
    }

    /*public static void main(String[] args) {
        String str = "中华人民共和国万岁！";
        System.out.println("例一：获取中文拼音首字母");
        System.out.println(str);
        System.out.println(getShortPinyin(str));
        str = "我爱你中国！";
        System.out.println("例二：获取中文拼音");
        System.out.println(str);
        System.out.println(getFullPinyin(str));
    }*/
}
