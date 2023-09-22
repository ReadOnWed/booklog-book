package com.booklog.book.search.service;

import com.booklog.book.like.service.BookLikeService;
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
    private final BookLikeService bookLikeService;

    @Override
    public List<BookInfo> findBookInfos(String title) {
        log.info("searching book by title : {} in book title service...", title);
        List<BookInfo> bookInfos = BookInfo.listOf(searchBookInfoRepository.findBookInfoByTitleRegex(title));
        bookInfos.forEach(bookInfo -> {
            bookInfo.countLikes(bookLikeService.countLikesByBookId(bookInfo.getId()));
        });

        return bookInfos;
    }
}
