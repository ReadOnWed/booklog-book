package com.booklog.book.review.repository;

import com.booklog.book.bookdetail.entity.ReviewEntity;

public interface MongoTemplateBookReviewUpdateRepository {
	void updateEmbeddedReviewByBookIdAndReviewId(String bookId, ReviewEntity reviewEntity);
	void deleteEmbeddedReviewByBookIdAndReviewId(String bookId, String reviewId);
}
