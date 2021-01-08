package com.example.demo_2020_1211;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SystemConfig implements EnvironmentAware {

    private static Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        SystemConfig.environment = environment;
    }

    public static String getProperty(String key, String defaultval){
        if(environment.getProperty(key)==null||environment.getProperty(key).equals("")){
            return defaultval;
        }
        return environment.getProperty(key);
    }

    public static String getProperty(String key){
        return environment.getProperty(key);
    }
}
