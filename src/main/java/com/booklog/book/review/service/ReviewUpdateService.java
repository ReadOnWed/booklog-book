package com.booklog.book.review.service;

import com.booklog.book.bookdetail.dto.Review;

public interface ReviewUpdateService {
	void postReviewInfo(Review review);
	void editReviewInto(Review review);
	void deleteReviewInfo(String reviewId, String bookId);
}
