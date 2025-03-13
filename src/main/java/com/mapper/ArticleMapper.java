package com.mapper;

import com.dto.ArticleRequestDto;
import com.dto.ArticleResponseDto;
import com.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public abstract class ArticleMapper {
    public abstract ArticleResponseDto toDto(Article article);

    public abstract List<ArticleResponseDto> toDtoList(List<Article> articles);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "createdAt", expression = "java(com.common.utils.DateTimeUtils.now())")
    @Mapping(target = "updatedAt", expression = "java(com.common.utils.DateTimeUtils.now())")
    @Mapping(target = "publicationDate", expression = "java(com.common.utils.DateTimeUtils.now())")
    public abstract Article toEntity(ArticleRequestDto articleDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "publicationDate", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(com.common.utils.DateTimeUtils.now())")
    @Mapping(target = "title", expression = "java(source.getTitle() != null && !source.getTitle().isEmpty() ? source.getTitle() : target.getTitle())")
    @Mapping(target = "content", expression = "java(source.getContent() != null && !source.getContent().isEmpty() ? source.getContent() : target.getContent())")
    public abstract Article update(Article source, @MappingTarget Article target);
}
