package com.plunger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {

    @Value("${spring.evn.debug}")
    private boolean debug;

    @Bean
    public EnvConfig evnConfig() {
        return new EnvConfig();
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

}
