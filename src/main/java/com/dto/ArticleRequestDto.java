package com.dto;

import com.common.MandatoryField;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequestDto {
    @MandatoryField
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @MandatoryField
    @NotBlank(message = "Content cannot be blank")
    private String content;
}
