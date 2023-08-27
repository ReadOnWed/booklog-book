package com.booklog.book.bookinfo.service;

import java.util.List;

import com.booklog.book.bookinfo.common.PromotionType;
import com.booklog.book.bookinfo.dto.BookInfoDto;

public interface PromotionBookInfoService {
	List<BookInfoDto> findBookInfos(PromotionType type);
}
