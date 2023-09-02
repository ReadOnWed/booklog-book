package com.booklog.book.bookdetail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class BookDetail {
    private String bookId;
    private String title;
    private String subTitle;
    private String image;
    private int price;
    private String description;
    private String mainCategory;
    private String subCategory;
    private int viewsCount;
    private int likesCount;
    private int rating;
    private String recentReviewDate;
    private String author;
    private String publisher;
    private String publicationDate;
    private List<Review> reviews;
    private int totalReviewsCount;
}