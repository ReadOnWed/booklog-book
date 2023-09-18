package com.booklog.book.promotion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booklog.book.promotion.common.PromotionType;
import com.booklog.book.promotion.dto.BookInfo;
import com.booklog.book.promotion.factory.PromotionBookInfoServiceFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromotionBookInfoFacadeServiceImpl implements PromotionBookInfoFacadeService{
	private final PromotionBookInfoServiceFactory promotionBookInfoServiceFactory;
	@Override
	public List<BookInfo> findBookInfos(PromotionType promotionType) {
		// Factory 로 부터 PromotionType 별로 적절한 Service class 조회 및 findBookInfos 메서드 호출
		return promotionBookInfoServiceFactory.getPromotionBookInfoService(promotionType)
			.findBookInfos();
	}
}
