package com.booklog.book.bookdetail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Review {
    private String id;
    private String reviewWriter;
    private String reviewTitle;
    private String reviewContent;
    private Integer rating;
    private String createdAt;
    private String updatedAt;
    private Integer likesCount;
    private Integer scrapsCount;
    private Integer viewsCount;
}

