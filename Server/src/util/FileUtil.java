package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
    
    private Properties properties;
    private static FileUtil instance;

    private FileUtil() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("db.properties"));
    }
    
    public static FileUtil getInstance() throws IOException {
        if (instance == null) {
            instance = new FileUtil();
        }
        return instance;
    }
    
    public String get(String key) {
        return properties.getProperty(key, "");
    }
}
