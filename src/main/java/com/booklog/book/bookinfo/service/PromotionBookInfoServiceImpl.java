package com.booklog.book.bookinfo.service;

import java.util.List;
import java.util.Map;

import com.booklog.book.bookinfo.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.booklog.book.bookinfo.common.PromotionType;
import com.booklog.book.bookinfo.dto.BookInfoDto;


@Service
@RequiredArgsConstructor
public class PromotionBookInfoServiceImpl implements PromotionBookInfoService {
	private final Map<PromotionType, BookInfoRepository> bookInfoRepositories;

	@Override
	public List<BookInfoDto> findBookInfos(PromotionType promotionType) {
		return bookInfoRepositories.get(promotionType).findBookInfos();
	}
}