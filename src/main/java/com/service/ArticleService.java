package com.service;

import com.dto.ArticleRequestDto;
import com.model.Article;
import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article getArticle(Long id);
    Article createArticle(ArticleRequestDto articleDTO);
    Article updateArticle(Long id, ArticleRequestDto articleDTO);
    void deleteArticle(Long id);
}
