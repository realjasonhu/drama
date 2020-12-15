package com.drama.core;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Hu JunJie
 * @date 2020/12/14 19:32
 * @since
 */
@Slf4j
public class PropertiesUtil {

    private static final String CONFIGURATION = "configuration.properties";

    private static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            log.error("读取文件失败,fileName={},e={}", fileName, e);
        }
        return properties;
    }

    public static String getConfiguraionProperty(String key, String defaultValue) {
        Properties properties = loadProperties(CONFIGURATION);
        String value = properties.getProperty(key, defaultValue);
        if (!Objects.isNull(value))
            return value;
        return defaultValue;
    }
}
