package com.finki.backend.domain.dto;

import com.finki.backend.domain.enumeration.BookCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    private String name;
    private BookCategory category;
    private Long authorId;
    private Integer availableCopies;
}
