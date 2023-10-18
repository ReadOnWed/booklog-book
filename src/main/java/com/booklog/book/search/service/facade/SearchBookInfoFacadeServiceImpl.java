package com.booklog.book.search.service.facade;

import com.booklog.book.search.common.SearchType;
import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.dto.BookInfoSearchTermDto;
import com.booklog.book.search.service.subsystem.SearchBookInfoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchBookInfoFacadeServiceImpl implements SearchBookInfoFacadeService {
    private final EnumMap<SearchType, SearchBookInfoService> searchBookInfoServiceEnumMap;

    @Override
    public List<BookInfo> findBookInfos(BookInfoSearchTermDto searchTermDto) {
        Set<BookInfo> booksSet = new HashSet<>();

        searchBookInfoServiceEnumMap.forEach((searchType, searchBookInfoService) -> {
            String searchTerm = getSearchTerm(searchType, searchTermDto);
            if(StringUtils.isNotBlank(searchTerm)){
                log.info("call search book info by {}", searchTerm);
                booksSet.addAll(searchBookInfoService.findBookInfos(searchTerm));
            }
        });
        log.info("search book info successfully");

        return new ArrayList<>(booksSet);
    }


    private String getSearchTerm(SearchType searchType, BookInfoSearchTermDto searchTerm){
        return switch (searchType) {
            case TITLE -> searchTerm.getTitle();
            case CATEGORY -> searchTerm.getCategory();
            case PUBLISHER -> searchTerm.getPublisher();
            case AUTHOR -> searchTerm.getAuthor();
        };
    }
}
