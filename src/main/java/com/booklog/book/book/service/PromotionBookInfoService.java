package com.booklog.book.book.service;

import java.util.List;

import com.booklog.book.book.common.PromotionType;
import com.booklog.book.book.dto.BookInfoDto;

public interface PromotionBookInfoService {
	List<BookInfoDto> findBookInfos(PromotionType type);
}
