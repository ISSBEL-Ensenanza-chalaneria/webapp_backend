package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.wordpress;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.config.WordPressProperties;

@Service
public class WordPressContentService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final WordPressProperties props;

    public WordPressContentService(WordPressProperties props){
        this.props = props;
    }

    public String getPageBySlug(String slug){
        String url = props.getApiUrl() + "/pages?slug=" + slug;
        return restTemplate.getForObject(url, String.class);
    }
}
