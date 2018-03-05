package com.qianxin.cassandra.util;

public class DataFormatUtil {

    /**
     * 将二进制数据转换成Hex字符串
     * @return Hex字符串
     */
    public static String bytes2Hex(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[ i ] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toLowerCase();
        }
        return ret;
    }

}
