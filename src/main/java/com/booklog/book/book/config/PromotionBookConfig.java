package com.booklog.book.book.config;

import java.util.HashMap;
import java.util.Map;

import com.booklog.book.book.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booklog.book.book.common.PromotionType;
import com.booklog.book.book.repository.LatelyReviewedBookInfoRepository;
import com.booklog.book.book.repository.MostReviewedInMonthBookInfoRepository;
import com.booklog.book.book.repository.TopRatedBookInfoRepository;

@Configuration
@RequiredArgsConstructor
public class PromotionBookConfig {
	private final TopRatedBookInfoRepository topRatedBookInfoRepository;
	private final MostReviewedInMonthBookInfoRepository mostReviewedInMonthBookInfoRepository;
	private final LatelyReviewedBookInfoRepository latelyReviewedBookInfoRepository;
	/*
	* PromotionBookInfoServiceImpl 객체 생성시에 필요한 인자를 스프링 빈으로 등록
	* PromotionBookInfoServiceImpl 객체를 생성할때 스프링이 이 Map<PromotionType, BookInfoRepository> 타입의 빈을 찾아서 주입해준다.
	* */
	@Bean
	public Map<PromotionType, BookInfoRepository> repositoryMap() {
		Map<PromotionType, BookInfoRepository> factoryMap = new HashMap<>();
		factoryMap.put(PromotionType.TOP_RATED, topRatedBookInfoRepository);
		factoryMap.put(PromotionType.MOST_REVIEWED_IN_MONTH, mostReviewedInMonthBookInfoRepository);
		factoryMap.put(PromotionType.LATELY_REVIEWED, latelyReviewedBookInfoRepository);
		return factoryMap;
	}
}
