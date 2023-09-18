package com.booklog.book.search.service;

import com.booklog.book.search.common.SearchBookInfoServiceBeanName;
import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.repository.SearchBookInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(SearchBookInfoServiceBeanName.AUTHOR)
@RequiredArgsConstructor
@Slf4j
public class SearchBookInfoByAuthorServiceImpl implements SearchBookInfoService {
    private final SearchBookInfoRepository searchBookInfoRepository;

    @Override
    public List<BookInfo> findBookInfos(String author) {
        log.info("searching book by author : {} in book author service...", author);
        return BookInfo.listOf(searchBookInfoRepository.findBookInfoByAuthorRegex(author));
    }
}
