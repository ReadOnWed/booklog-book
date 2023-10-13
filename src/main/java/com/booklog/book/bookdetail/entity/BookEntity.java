package com.booklog.book.bookdetail.entity;


import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Document(collection = "book")
@Getter
public class BookEntity {
	@Id
	private String bookId;
	private String isbn;
	private String title;
	private String subTitle;
	private String image;
	private String discount;
	private String description;
	private String mainCategory;
	private String subCategory;
	private int viewsCount;
	private int likesCount;
	private int rating;
	private String recentReviewDate;
	private String author;
	private String publisher;
	private String pubdate;
	private int reviewsCount;
	private List<ReviewEntity> reviews;

	public BookEntity attachReviews(ReviewEntity reviewEntity){
		if(Objects.isNull(this.reviews)){
			reviews = Collections.singletonList(reviewEntity);
			return this;
		}

		if(reviews.size() < 10){
			reviews.add(reviewEntity);
			return this;
		}

		reviews.subList(1, reviews.size())
			.add(reviewEntity);
		return this;
	}

	public BookEntity calculateRating(int rating){
		if(reviewsCount == 0) {
			this.rating = rating;
			return this;
		}

		int sumOfTotalRating = this.rating * reviewsCount;
		this.rating = (sumOfTotalRating + rating) / (reviewsCount + 1);

		return this;
	}

	public BookEntity reCalculateRating(int rating){
		int sumOfTotalRating = this.rating * reviewsCount;
		this.rating = (sumOfTotalRating - this.rating + rating) / reviewsCount;

		return this;
	}

	public BookEntity updateRatingOnReviewDeletion(int rating){
		int sumOfTotalRating = this.rating * (reviewsCount + 1);
		this.rating = (sumOfTotalRating - rating) / reviewsCount;

		return this;
	}


	public BookEntity reviewedRecentAt(String recentReviewDate){
		this.recentReviewDate = recentReviewDate;
		return this;
	}

	public BookEntity updateReviewsCount(long updateCount){
		this.reviewsCount += updateCount;
		return this;
	}
}
