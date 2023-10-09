package com.booklog.book.search.service;

import com.booklog.book.search.dto.BookInfo;

public interface SearchBookInfoByIdService {
	BookInfo findBookInfo(String bookId);
}
