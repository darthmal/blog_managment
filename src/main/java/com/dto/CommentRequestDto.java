package com.dto;

import com.common.MandatoryField;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {
    @MandatoryField
    @NotBlank(message = "Content cannot be blank")
    private String content;
}
