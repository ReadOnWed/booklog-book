package com.booklog.book.bookdetail.dto;

import com.booklog.book.bookdetail.entity.ReviewEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Review {
    private String id;
    private String reviewWriter;
    private String reviewTitle;
    private String reviewContent;
    private int rating;
    private String createdAt;
    private String updatedAt;
    private int likesCount;
    private int scrapsCount;
    private int viewsCount;

    public static Review of(ReviewEntity reviewEntity){
        return Review.builder()
            .id(reviewEntity.getId())
            .reviewWriter(reviewEntity.getReviewWriter())
            .reviewTitle(reviewEntity.getReviewTitle())
            .reviewContent(reviewEntity.getReviewContent())
            .rating(reviewEntity.getRating())
            .createdAt(reviewEntity.getCreatedAt())
            .updatedAt(reviewEntity.getUpdatedAt())
            .likesCount(toPrimitive(reviewEntity.getLikesCount()))
            .scrapsCount(toPrimitive(reviewEntity.getScrapsCount()))
            .viewsCount(toPrimitive(reviewEntity.getScrapsCount()))
            .build();
    }

    private static int toPrimitive(Integer integer){
        return integer == null ? 0 : integer;
    }
}

