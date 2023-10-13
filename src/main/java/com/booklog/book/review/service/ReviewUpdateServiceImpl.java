package com.booklog.book.review.service;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.booklog.book.bookdetail.dto.Review;
import com.booklog.book.bookdetail.entity.BookEntity;
import com.booklog.book.bookdetail.entity.ReviewEntity;
import com.booklog.book.review.repository.ReviewUpdateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewUpdateServiceImpl implements ReviewUpdateService{
	private final ReviewUpdateRepository reviewUpdateRepository;
	@Override
	public void postReviewInfo(Review review) {
		BookEntity bookEntity = reviewUpdateRepository.findBookEntityByBookId(review.getBookId())
			.attachReviews(ReviewEntity.of(review))
			.reviewedRecentAt(review.getCreatedAt().format(DateTimeFormatter.ISO_DATE))
			.calculateRating(review.getRating())
			.updateReviewsCount(1);

		reviewUpdateRepository.save(bookEntity);
	}

	@Override
	public void editReviewInto(Review review) {
		// Embedded Review Document 업데이트
		reviewUpdateRepository.updateEmbeddedReviewByBookIdAndReviewId(review.getBookId(), ReviewEntity.of(review));

		// Book Document Review 관련 정보 업데이트
		BookEntity bookEntity = reviewUpdateRepository.findBookEntityByBookId(review.getBookId())
			.reCalculateRating(review.getRating());
		reviewUpdateRepository.save(bookEntity);
	}

	@Override
	public void deleteReviewInfo(String reviewId, String bookId) {
		// Embedded Review Document 제거
		BookEntity prevReviewInfo = reviewUpdateRepository.findBookEntityByBookIdAndReviews_Id(bookId, reviewId);
		reviewUpdateRepository.deleteEmbeddedReviewByBookIdAndReviewId(bookId, reviewId);

		// Book Document Review 관련 정보 업데이트
		BookEntity bookEntity = reviewUpdateRepository.findBookEntityByBookId(bookId)
			.updateRatingOnReviewDeletion(prevReviewInfo.getRating())
			.updateReviewsCount(-1);
		reviewUpdateRepository.save(bookEntity);
	}
}
