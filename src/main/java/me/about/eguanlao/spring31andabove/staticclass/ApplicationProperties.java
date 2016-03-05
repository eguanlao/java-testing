package me.about.eguanlao.spring31andabove.staticclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class ApplicationProperties {

    private static Properties properties;

    public static String getProperty(final String key) {
        return properties.getProperty(key);
    }

    @Autowired
    public void setProperties(final Properties properties) {
        ApplicationProperties.properties = properties;
    }

}
