package com.booklog.book.bookinfo.repository;

import java.util.List;

import com.booklog.book.bookinfo.dto.BookInfoDto;

public interface BookInfoRepository {
	List<BookInfoDto> findBookInfos();
}
