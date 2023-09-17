package com.booklog.book.promotion.service;

import java.util.List;

import com.booklog.book.promotion.repository.PromotionBookInfoRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.booklog.book.promotion.dto.BookInfo;

@Service("topRatedBookInfoServiceImpl")
@RequiredArgsConstructor
public class TopRatedBookInfoServiceImpl implements PromotionBookInfoService {
	private final PromotionBookInfoRepository promotionBookInfoRepository;

	@Override
	public List<BookInfo> findBookInfos() {
		return BookInfo.listOf(promotionBookInfoRepository.findAll(
			PageRequest.of(0, 3, Sort.by("rating").descending())
		));
	}
}