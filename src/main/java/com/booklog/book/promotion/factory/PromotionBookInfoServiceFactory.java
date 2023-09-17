package com.booklog.book.promotion.factory;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.booklog.book.promotion.common.PromotionType;
import com.booklog.book.promotion.service.PromotionBookInfoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PromotionBookInfoServiceFactory {
	private final Map<String, PromotionBookInfoService> promotionBookInfoServiceMap;

	public PromotionBookInfoService getPromotionBookInfoService(PromotionType promotionType){
		return promotionBookInfoServiceMap.get(promotionType.getInstanceName());
	}
}
