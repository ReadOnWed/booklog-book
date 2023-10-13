package com.booklog.book.bookdetail.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.booklog.book.bookdetail.dto.Review;
import com.mongodb.lang.Nullable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection = "book")
public class ReviewEntity {
	private String id;
	private String reviewWriter;
	private String reviewTitle;
	private int rating;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	@Nullable
	private Integer likesCount;
	@Nullable
	private Integer scrapsCount;
	@Nullable
	private Integer viewsCount;

	public static ReviewEntity of(Review review){
		return ReviewEntity.builder()
			.id(review.getId())
			.reviewWriter(review.getReviewWriter())
			.reviewTitle(review.getReviewTitle())
			.rating(review.getRating())
			.createdAt(review.getCreatedAt())
			.updatedAt(review.getUpdatedAt())
			.likesCount(review.getLikesCount())
			.scrapsCount(review.getScrapsCount())
			.viewsCount(review.getViewsCount())
			.build();
	}
}
