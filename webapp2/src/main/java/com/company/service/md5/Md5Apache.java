package com.company.service.md5;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Apache {
    public static String md5Apache(String pass) {
        String md5Hex = DigestUtils.md5Hex(pass);
        return md5Hex;
    }
}
