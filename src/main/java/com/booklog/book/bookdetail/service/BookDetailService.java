package com.booklog.book.bookdetail.service;

import com.booklog.book.bookdetail.dto.BookDetail;

public interface BookDetailService {
    BookDetail findBookDetailById(String bookId);
}
