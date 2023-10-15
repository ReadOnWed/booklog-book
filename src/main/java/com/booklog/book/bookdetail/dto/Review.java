package com.booklog.book.bookdetail.dto;

import java.time.LocalDateTime;

import com.booklog.book.bookdetail.entity.ReviewEntity;
import com.booklog.book.review.dto.ReviewRequestDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Review {
    private String id;
    private String reviewWriter;
    private String reviewTitle;
    private int rating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int likesCount;
    private int scrapsCount;
    private int viewsCount;
    private String bookId;

    public static Review of(ReviewEntity reviewEntity){
        return Review.builder()
            .id(reviewEntity.getId())
            .reviewWriter(reviewEntity.getReviewWriter())
            .reviewTitle(reviewEntity.getReviewTitle())
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

    public static Review of(ReviewRequestDto reviewRequestDto){
        return Review.builder()
            .id(reviewRequestDto.getId())
            .reviewWriter(reviewRequestDto.getReviewWriter())
            .reviewTitle(reviewRequestDto.getReviewTitle())
            .rating(reviewRequestDto.getRating())
            .createdAt(reviewRequestDto.getCreatedAt())
            .updatedAt(reviewRequestDto.getUpdatedAt())
            .likesCount(reviewRequestDto.getLikesCount())
            .scrapsCount(reviewRequestDto.getScrapsCount())
            .viewsCount(reviewRequestDto.getScrapsCount())
            .bookId(reviewRequestDto.getBook().getId())
            .build();
    }
}

