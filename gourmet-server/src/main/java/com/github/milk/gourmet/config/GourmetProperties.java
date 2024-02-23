package com.github.milk.gourmet.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Common config
 */
@Data
@ConfigurationProperties(prefix = "gourmet")
public class GourmetProperties {
    /**
     * where the data from , valid values: csv
     */
    private String repoType;
    /**
     * effective when repoType is csv
     */
    private String csvLocation;
}
