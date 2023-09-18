package com.booklog.book.promotion.service;

import java.util.List;

import com.booklog.book.promotion.dto.BookInfo;

public interface PromotionBookInfoService {
	List<BookInfo> findBookInfos();
}
