package com.booklog.book.book.service;

import java.util.List;

import com.booklog.book.book.dto.BookInfoDto;

public interface SearchBookInfoService {
    List<BookInfoDto> findBookInfos(String searchTerm);
}