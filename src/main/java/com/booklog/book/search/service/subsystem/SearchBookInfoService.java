package com.booklog.book.search.service.subsystem;

import java.util.List;

import com.booklog.book.search.dto.BookInfo;

public interface SearchBookInfoService {
    List<BookInfo> findBookInfos(String searchTerm);
}