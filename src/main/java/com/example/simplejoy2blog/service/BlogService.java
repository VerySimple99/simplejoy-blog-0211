package com.example.simplejoy2blog.service;

import com.example.simplejoy2blog.domain.Article;
import com.example.simplejoy2blog.dto.AddArticleRequest;
import com.example.simplejoy2blog.dto.UpdateArticleRequest;
import com.example.simplejoy2blog.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
    public List<Article> findAll(){
        return blogRepository.findAll();
    }
    public Article findById(Long id) {
        return blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Not Found:"+id));
    }
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = findById(id);
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
