package com.service;

import com.common.utils.EntityNotFoundException;
import com.dto.ArticleRequestDto;
import com.mapper.ArticleMapper;
import com.model.Article;
import com.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Transactional(readOnly = true)
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Article getArticle(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found with id: " + id));
    }

    @Transactional
    public Article createArticle(ArticleRequestDto articleDTO) {
        return articleRepository.save(articleMapper.toEntity(articleDTO));
    }

    @Transactional
    public Article updateArticle(Long id, ArticleRequestDto articleDTO) {
        Article target = getArticle(id);
        Article source = articleMapper.toEntity(articleDTO);
        return articleRepository.save(articleMapper.update(source, target));
    }

    @Transactional
    public void deleteArticle(Long id) {
        articleRepository.delete(getArticle(id));
    }
}
