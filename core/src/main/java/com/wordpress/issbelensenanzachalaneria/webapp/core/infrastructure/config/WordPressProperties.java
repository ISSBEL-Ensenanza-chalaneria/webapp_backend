package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "wordpress")
public class WordPressProperties {
    private String apiUrl;
}
