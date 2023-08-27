package com.booklog.book.book.repository;

import java.util.List;

import com.booklog.book.book.dto.BookInfoDto;

public interface BookInfoRepository {
	List<BookInfoDto> findBookInfos();
}
