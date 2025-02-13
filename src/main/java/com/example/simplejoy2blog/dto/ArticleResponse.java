package com.example.simplejoy2blog.dto;

import com.example.simplejoy2blog.domain.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {
    private String title;
    private String content;
    public ArticleResponse(Article article) {
        this.title=article.getTitle();
        this.content=article.getContent();
    }

}
