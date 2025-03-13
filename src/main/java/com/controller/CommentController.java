package com.controller;

import com.dto.CommentRequestDto;
import com.dto.CommentResponseDto;
import com.mapper.CommentMapper;
import com.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/articles/{articleId}/comments")
@RequiredArgsConstructor
@Tag(name = "Comment Management", description = "APIs for managing article comments")
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @PostMapping
    @Operation(summary = "Add a comment to an article")
    public ResponseEntity<CommentResponseDto> addComment(
            @PathVariable Long articleId,
            @Valid @RequestBody CommentRequestDto commentDTO) {
        return new ResponseEntity<>(
            commentMapper.toDto(commentService.addComment(articleId, commentDTO)),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{commentId}")
    @Operation(summary = "Delete a comment from an article")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long articleId,
            @PathVariable Long commentId) {
        commentService.deleteComment(articleId, commentId);
        return ResponseEntity.noContent().build();
    }
}
