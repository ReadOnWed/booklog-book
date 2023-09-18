package com.booklog.book.promotion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklog.book.promotion.entity.BookInfoEntity;

public interface PromotionBookInfoRepository extends MongoRepository<BookInfoEntity, String> {
}
