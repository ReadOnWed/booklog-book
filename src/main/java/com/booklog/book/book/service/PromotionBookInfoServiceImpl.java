package com.booklog.book.book.service;

import java.util.List;
import java.util.Map;

import com.booklog.book.book.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.booklog.book.book.common.PromotionType;
import com.booklog.book.book.dto.BookInfoDto;


@Service
@RequiredArgsConstructor
public class PromotionBookInfoServiceImpl implements PromotionBookInfoService {
	private final Map<PromotionType, BookInfoRepository> bookInfoRepositories;

	@Override
	public List<BookInfoDto> findBookInfos(PromotionType promotionType) {
		return bookInfoRepositories.get(promotionType).findBookInfos();
	}
}