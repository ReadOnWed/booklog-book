package com.booklog.book.search.service;

import java.util.List;

import com.booklog.book.promotion.dto.BookInfoDto;

public interface SearchBookInfoService {
    List<BookInfoDto> findBookInfos(String searchTerm);
}