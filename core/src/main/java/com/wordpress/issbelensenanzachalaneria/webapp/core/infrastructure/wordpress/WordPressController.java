package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.wordpress;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/wordpress")
public class WordPressController {
    private final WordPressContentService wordPressService;

    public WordPressController(WordPressContentService service){
        this.wordPressService = service;
    }

    @GetMapping("/{slug}")
    public ResponseEntity<String> getPage(@PathVariable String slug){
        return ResponseEntity.ok(wordPressService.getPageBySlug(slug));
    }
}
