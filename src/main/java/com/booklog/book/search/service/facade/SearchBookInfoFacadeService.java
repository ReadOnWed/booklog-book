package com.booklog.book.search.service.facade;

import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.dto.BookInfoSearchTermDto;

import java.util.List;

public interface SearchBookInfoFacadeService {
    List<BookInfo> findBookInfos(BookInfoSearchTermDto searchTermDto);

}
