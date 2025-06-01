package com.badlyac.musicplayer.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class ResourcePackUtils {

    public static byte[] computeSha1(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] buffer = new byte[1024];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                sha1.update(buffer, 0, read);
            }
            return sha1.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
