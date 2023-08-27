package com.booklog.book.book.service;

import com.booklog.book.book.common.SearchBookInfoServiceBeanName;
import com.booklog.book.book.dto.BookInfoDto;
import com.booklog.book.book.repository.SearchBookInfoByTitleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(SearchBookInfoServiceBeanName.TITLE)
@RequiredArgsConstructor
@Slf4j
public class SearchBookInfoByTitleServiceImpl implements SearchBookInfoService {
    private final SearchBookInfoByTitleRepository searchBookInfoByTitleRepository;

    @Override
    public List<BookInfoDto> findBookInfos(String title) {
        log.info("searching book by title : {} in book title service...", title);
        return searchBookInfoByTitleRepository.findBookInfos(title);
    }
}
