package com.nx.dynamic.ds.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.datasource.master")
@Component
@Data
public class DataBaseMastProperties {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
