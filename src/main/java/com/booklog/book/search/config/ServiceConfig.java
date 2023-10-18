package com.booklog.book.search.config;

import java.util.EnumMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booklog.book.search.common.SearchType;
import com.booklog.book.search.service.subsystem.SearchBookInfoByAuthorServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoByCategoryServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoByPublisherServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoByTitleServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoService;

@Configuration
public class ServiceConfig {

	@Bean
	public EnumMap<SearchType, SearchBookInfoService> searchBookInfoServiceEnumMap(
		SearchBookInfoByTitleServiceImpl searchBookInfoByTitleService,
		SearchBookInfoByCategoryServiceImpl searchBookInfoByCategoryService,
		SearchBookInfoByPublisherServiceImpl searchBookInfoByPublisherService,
		SearchBookInfoByAuthorServiceImpl searchBookInfoByAuthorService){

		return new EnumMap<>(SearchType.class) {{
			put(SearchType.TITLE, searchBookInfoByTitleService);
			put(SearchType.CATEGORY, searchBookInfoByCategoryService);
			put(SearchType.PUBLISHER, searchBookInfoByPublisherService);
			put(SearchType.AUTHOR, searchBookInfoByAuthorService);
		}};
	}
}
