package com.booklog.book.search.service;

import com.booklog.book.search.common.SearchBookInfoServiceBeanName;
import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.repository.SearchBookInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(SearchBookInfoServiceBeanName.TITLE)
@RequiredArgsConstructor
@Slf4j
public class SearchBookInfoByTitleServiceImpl implements SearchBookInfoService {
    private final SearchBookInfoRepository searchBookInfoRepository;

    @Override
    public List<BookInfo> findBookInfos(String title) {
        log.info("searching book by title : {} in book title service...", title);
        return BookInfo.listOf(searchBookInfoRepository.findBookInfoByTitleRegex(title));
    }
}
