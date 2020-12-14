package com.drama.core;

import java.io.*;
import java.util.Properties;

/**
 * @author Hu JunJie
 * @date 2020/12/14 19:32
 * @since
 */
public class PropertiesUtil {

    private static final String CONFIGURATION = "configuration.properties";

    public static String getConfiguraionProperty(String key, String defaultValue) {

        try {
            Properties properties = new Properties();
            properties.load(new BufferedInputStream(new FileInputStream(CONFIGURATION)));
            String value = properties.getProperty(key, defaultValue);
            return value;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    public static void main(String[] args) {
        String[][][][] strings = {{{{"a","b"}}}};
    }
}
