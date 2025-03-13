package com.service;

import com.common.utils.EntityNotFoundException;
import com.dto.CommentRequestDto;
import com.mapper.CommentMapper;
import com.model.Article;
import com.model.Comment;
import com.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ArticleService articleService;
    private final CommentMapper commentMapper;

    @Transactional
    public Comment addComment(Long articleId, CommentRequestDto commentDTO) {
        Article article = articleService.getArticle(articleId);
        Comment comment = commentMapper.toEntity(commentDTO);
        comment.setArticle(article);
        return commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long articleId, Long commentId) {
        Comment comment = commentRepository.findByArticleIdAndId(articleId, commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found with id: " + commentId + " for article: " + articleId));
        commentRepository.delete(comment);
    }
}
