package com.booklog.book.book.repository;

import com.booklog.book.book.dto.BookInfoDto;

import java.util.List;

public interface SearchBookInfoRepository {
    List<BookInfoDto> findBookInfos(String term);
}
