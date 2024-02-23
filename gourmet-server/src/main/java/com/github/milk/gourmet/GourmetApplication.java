package com.github.milk.gourmet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = {com.github.milk.gourmet.config.GourmetProperties.class})
public class GourmetApplication {
    public static void main(String[] args) {
        SpringApplication.run(GourmetApplication.class, args);
    }
}
