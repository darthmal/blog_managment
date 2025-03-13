package com.controller;

import com.dto.ArticleRequestDto;
import com.dto.ArticleResponseDto;
import com.mapper.ArticleMapper;
import com.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
@Tag(name = "Article Management", description = "APIs for managing blog articles")
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @GetMapping
    @Operation(summary = "Get all articles")
    public ResponseEntity<List<ArticleResponseDto>> getAllArticles() {
        return ResponseEntity.ok(articleMapper.toDtoList(articleService.getAllArticles()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an article by ID")
    public ResponseEntity<ArticleResponseDto> getArticle(@PathVariable Long id) {
        return ResponseEntity.ok(articleMapper.toDto(articleService.getArticle(id)));
    }

    @PostMapping
    @Operation(summary = "Create a new article")
    public ResponseEntity<ArticleResponseDto> createArticle(@Valid @RequestBody ArticleRequestDto articleDTO) {
        return new ResponseEntity<>(articleMapper.toDto(articleService.createArticle(articleDTO)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing article")
    public ResponseEntity<ArticleResponseDto> updateArticle(@PathVariable Long id, @Valid @RequestBody ArticleRequestDto articleDTO) {
        return ResponseEntity.ok(articleMapper.toDto(articleService.updateArticle(id, articleDTO)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an article")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
