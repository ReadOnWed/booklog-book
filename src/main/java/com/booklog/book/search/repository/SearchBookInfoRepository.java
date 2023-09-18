package com.booklog.book.search.repository;

import com.booklog.book.promotion.dto.BookInfoDto;

import java.util.List;

public interface SearchBookInfoRepository {
    List<BookInfoDto> findBookInfos(String term);
}
