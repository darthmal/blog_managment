package com.service;

import com.dto.CommentRequestDto;
import com.model.Comment;

public interface CommentService {
    Comment addComment(Long articleId, CommentRequestDto commentDTO);
    void deleteComment(Long articleId, Long commentId);
}
