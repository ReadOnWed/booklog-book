package com.booklog.book.book.service;

import com.booklog.book.book.dto.BookInfoDto;
import com.booklog.book.book.dto.BookInfoSearchTermDto;

import java.util.List;

public interface SearchBookInfoFacadeService {
    List<BookInfoDto> findBookInfos(BookInfoSearchTermDto searchTermDto);

}
