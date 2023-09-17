package com.booklog.book.promotion.service;

import java.util.List;

import com.booklog.book.promotion.common.PromotionType;
import com.booklog.book.promotion.dto.BookInfo;

public interface PromotionBookInfoFacadeService {
	List<BookInfo> findBookInfos(PromotionType promotionType);
}
