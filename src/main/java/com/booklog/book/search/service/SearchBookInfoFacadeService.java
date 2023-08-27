package com.booklog.book.search.service;

import com.booklog.book.bookinfo.dto.BookInfoDto;
import com.booklog.book.search.dto.BookInfoSearchTermDto;

import java.util.List;

public interface SearchBookInfoFacadeService {
    List<BookInfoDto> findBookInfos(BookInfoSearchTermDto searchTermDto);

}
