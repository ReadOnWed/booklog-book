package com.booklog.book.search.service;

import com.booklog.book.search.common.SearchBookInfoServiceBeanName;
import com.booklog.book.bookinfo.dto.BookInfoDto;
import com.booklog.book.search.dto.BookInfoSearchTermDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchBookInfoFacadeServiceImpl implements SearchBookInfoFacadeService {
    private final Map<String, SearchBookInfoService> searchBookInfoServices;

    @Override
    public List<BookInfoDto> findBookInfos(BookInfoSearchTermDto searchTermDto) {
        Set<BookInfoDto> booksSet = new LinkedHashSet<>();

        for(Map.Entry<String, SearchBookInfoService> servicesEntry : searchBookInfoServices.entrySet()){
            String searchTerm = getSearchTermByStrategyType(searchTermDto, servicesEntry.getKey());
            if(StringUtils.isNotBlank(searchTerm)){
                log.info("call search book info by {}", servicesEntry.getKey());
                SearchBookInfoService searchBookInfoService = servicesEntry.getValue(); // 검색 조건에 맞는 검색 서비스 탐색
                booksSet.addAll(searchBookInfoService.findBookInfos(searchTerm));       // 검색 조건에 따른 검색 서비스 호출
            }
        }

        return new ArrayList<>(booksSet);
    }

    private String getSearchTermByStrategyType(BookInfoSearchTermDto searchTermDto, String strategyType) {
        return switch (strategyType) {
            case SearchBookInfoServiceBeanName.TITLE-> searchTermDto.getTitle();
            case SearchBookInfoServiceBeanName.CATEGORY -> searchTermDto.getCategory();
            case SearchBookInfoServiceBeanName.PUBLISHER -> searchTermDto.getPublisher();
            case SearchBookInfoServiceBeanName.AUTHOR -> searchTermDto.getAuthor();
            default -> null;
        };
    }
}
