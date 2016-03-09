package me.about.eguanlao.spring31andabove.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class PropertiesConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Configuration
    @PropertySource({
            "application-default.properties",
            "globalmessages.properties",
            "validationmessages.properties"
    })
    static class DefaultConfig {

    }

    @Configuration
    @Profile("nonprod")
    @PropertySource({
            "application-default.properties",
            "application-nonprod.properties",
            "globalmessages.properties",
            "validationmessages.properties"
    })
    static class NonProdConfig {
    }

    @Configuration
    @Profile("prod")
    @PropertySource({
            "application-default.properties",
            "application-prod.properties",
            "globalmessages.properties",
            "validationmessages.properties"
    })
    static class ProdConfig {
    }

}
