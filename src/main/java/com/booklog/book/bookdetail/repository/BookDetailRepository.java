package com.booklog.book.bookdetail.repository;

import com.booklog.book.bookdetail.dto.BookDetail;

public interface BookDetailRepository {
    BookDetail findBookDetailById(String bookId);
}
