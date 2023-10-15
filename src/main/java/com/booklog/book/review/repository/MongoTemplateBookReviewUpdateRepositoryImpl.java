package com.booklog.book.review.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Repository;

import com.booklog.book.bookdetail.entity.BookEntity;
import com.booklog.book.bookdetail.entity.ReviewEntity;
import com.mongodb.BasicDBObject;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MongoTemplateBookReviewUpdateRepositoryImpl implements MongoTemplateBookReviewUpdateRepository {
	private final MongoTemplate mongoTemplate;

	@Override
	public void updateEmbeddedReviewByBookIdAndReviewId(String bookId, ReviewEntity reviewEntity) {
		Query query = new Query(Criteria.where("_id").is(bookId).and("reviews._id").is(reviewEntity.getId()));
		Update update = new Update()
			.set("reviews.$.reviewWriter", reviewEntity.getReviewWriter())
			.set("reviews.$.reviewTitle", reviewEntity.getReviewTitle())
			.set("reviews.$.updatedAt", reviewEntity.getUpdatedAt())
			.set("reviews.$.rating", reviewEntity.getRating())
			.set("reviews.$.likesCount", reviewEntity.getLikesCount())
			.set("reviews.$.scrapsCount", reviewEntity.getScrapsCount())
			.set("reviews.$.viewsCount", reviewEntity.getViewsCount());

		mongoTemplate.updateFirst(query, update, BookEntity.class);
	}

	@Override
	public void deleteEmbeddedReviewByBookIdAndReviewId(String bookId, String reviewId) {
		Query query = new Query(Criteria.where("_id").is(bookId));
		Update update = new Update().pull("reviews", new BasicDBObject("_id", new ObjectId(reviewId)));
		mongoTemplate.updateFirst(query, update, BookEntity.class);
	}
}
