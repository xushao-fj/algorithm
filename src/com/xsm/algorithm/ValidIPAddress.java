package com.xsm.algorithm;

/**
 * @author xsm
 * @date 2021/1/14
 * @Description 验证ip地址
 * https://leetcode-cn.com/problems/validate-ip-address/
 */
public class ValidIPAddress {

    public String validIPAddress(String ip) {
        // ip 字符长度限制
        if (ip.length() > 71) {
            return "Neither";
        }
        if (ip.contains(".") && !ip.contains("..")) {
            if (ip.startsWith(".") || ip.charAt(ip.length() - 1) == '.') {
                return "Neither";
            }
            String[] split = ip.split("\\.");
            if (split.length == 4) {
                return validIpv4(split);
            }
        }
        if (ip.contains(":")) {
            if (ip.startsWith(":") || ip.charAt(ip.length() - 1) == ':') {
                return "Neither";
            }
            String[] split1 = ip.split(":");
            if (split1.length == 8) {
                return validIpv6(split1);
            }
        }
        return "Neither";
    }

    private String validIpv4(String[] split) {
        for (String s : split) {
            if (s.startsWith("0") && s.length() > 1) {
                return "Neither";
            }
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return "Neither";
                }
            }
            if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private String validIpv6(String[] str) {
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > 4 || str[i].length() == 0) {
                return "Neither";
            }
            for (int j = 0; j < str[i].length(); j++) {
                if (str[i].charAt(j) >= '0' && str[i].charAt(j) <= '9'
                        || str[i].charAt(j) >= 'a' && str[i].charAt(j) <= 'f'
                        || str[i].charAt(j) >= 'A' && str[i].charAt(j) <= 'F') {
                    continue;
                }
                return "Neither";
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        ValidIPAddress ob = new ValidIPAddress();
        String s = ob.validIPAddress("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    }
}