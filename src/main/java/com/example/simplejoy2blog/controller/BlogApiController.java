package com.example.simplejoy2blog.controller;

import com.example.simplejoy2blog.domain.Article;
import com.example.simplejoy2blog.dto.AddArticleRequest;
import com.example.simplejoy2blog.dto.ArticleResponse;
import com.example.simplejoy2blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/artices")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest article) {
        System.out.println(article);
        Article savedArticle=blogService.save(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> getAllArticles() {
        List<ArticleResponse> articles = blogService.findAll().stream().map(ArticleResponse::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(articles);
    }
}
