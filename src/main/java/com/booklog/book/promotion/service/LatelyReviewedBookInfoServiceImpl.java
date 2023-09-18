package com.booklog.book.promotion.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.booklog.book.promotion.dto.BookInfo;
import com.booklog.book.promotion.repository.PromotionBookInfoRepository;

import lombok.RequiredArgsConstructor;

@Service("latelyReviewedBookInfoServiceImpl")
@RequiredArgsConstructor
public class LatelyReviewedBookInfoServiceImpl implements PromotionBookInfoService {
	private final PromotionBookInfoRepository promotionBookInfoRepository;

	@Override
	public List<BookInfo> findBookInfos() {
		return BookInfo.listOf(promotionBookInfoRepository.findAll(
			PageRequest.of(0, 3, Sort.by("recentReviewDate").descending())
		));
	}
}