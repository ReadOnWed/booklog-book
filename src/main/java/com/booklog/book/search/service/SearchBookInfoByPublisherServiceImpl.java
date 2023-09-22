package com.booklog.book.search.service;

import com.booklog.book.like.service.BookLikeService;
import com.booklog.book.search.common.SearchBookInfoServiceBeanName;
import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.repository.SearchBookInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(SearchBookInfoServiceBeanName.PUBLISHER)
@RequiredArgsConstructor
@Slf4j
public class SearchBookInfoByPublisherServiceImpl implements SearchBookInfoService {
    private final SearchBookInfoRepository searchBookInfoRepository;
    private final BookLikeService bookLikeService;

    @Override
    public List<BookInfo> findBookInfos(String publisher) {
        log.info("searching book by publisher : {} in book publisher service...", publisher);
        List<BookInfo> bookInfos = BookInfo.listOf(searchBookInfoRepository.findBookInfoByPublisherRegex(publisher));
        bookInfos.forEach(bookInfo -> {
            bookInfo.countLikes(bookLikeService.countLikesByBookId(bookInfo.getId()));
        });

        return bookInfos;
    }
}
