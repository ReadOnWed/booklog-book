package com.booklog.book.bookdetail.service;

import com.booklog.book.bookdetail.dto.Book;

public interface BookDetailService {
    Book findBookDetailById(String bookId);
}
