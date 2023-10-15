package com.booklog.book.review.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklog.book.bookdetail.entity.BookEntity;

public interface ReviewUpdateRepository extends MongoRepository<BookEntity, String>, MongoTemplateBookReviewUpdateRepository {
    BookEntity findBookEntityByBookId(String bookId);
    BookEntity findBookEntityByBookIdAndReviews_Id(String bookId, String reviewId);
}
