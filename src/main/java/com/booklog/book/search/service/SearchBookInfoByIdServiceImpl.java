package com.booklog.book.search.service;

import org.springframework.stereotype.Service;

import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.repository.SearchBookInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchBookInfoByIdServiceImpl implements SearchBookInfoByIdService{
	private final SearchBookInfoRepository searchBookInfoRepository;
	@Override
	public BookInfo findBookInfo(String bookId) {
		return BookInfo.of(searchBookInfoRepository.findBookInfoById(bookId))
			.describeMainCategory()
			.describeSubCategory();
	}
}
