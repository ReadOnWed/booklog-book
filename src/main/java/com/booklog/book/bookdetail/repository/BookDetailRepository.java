package com.booklog.book.bookdetail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklog.book.bookdetail.entity.BookEntity;

public interface BookDetailRepository extends MongoRepository<BookEntity, String> {
    BookEntity findBookEntityByBookId(String bookId);
}
