package com.booklog.book.search.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class BookInfoSearchTermDto {
    private String title;
    private String category;
    private String publisher;
    private String author;
}
