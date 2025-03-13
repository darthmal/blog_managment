package com.mapper;

import com.dto.CommentRequestDto;
import com.dto.CommentResponseDto;
import com.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CommentMapper {
    public abstract CommentResponseDto toDto(Comment comment);

    public abstract List<CommentResponseDto> toDtoList(List<Comment> comments);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "article", ignore = true)
    @Mapping(target = "createdAt", expression = "java(com.common.utils.DateTimeUtils.now())")
    @Mapping(target = "updatedAt", expression = "java(com.common.utils.DateTimeUtils.now())")
    public abstract Comment toEntity(CommentRequestDto commentDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "article", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(com.common.utils.DateTimeUtils.now())")
    @Mapping(target = "content", expression = "java(source.getContent() != null && !source.getContent().isEmpty() ? source.getContent() : target.getContent())")
    public abstract Comment update(Comment source, @MappingTarget Comment target);
}
