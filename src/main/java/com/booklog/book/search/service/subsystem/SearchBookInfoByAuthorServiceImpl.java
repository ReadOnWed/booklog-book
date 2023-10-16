package com.booklog.book.search.service.subsystem;

import static com.booklog.book.search.common.EscapeRegexChars.*;

import com.booklog.book.like.service.BookLikeService;
import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.repository.SearchBookInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchBookInfoByAuthorServiceImpl implements SearchBookInfoService {
    private final SearchBookInfoRepository searchBookInfoRepository;
    private final BookLikeService bookLikeService;

    @Override
    public List<BookInfo> findBookInfos(String author) {
        if(StringUtils.isBlank(author)){
            return new ArrayList<>();
        }

        log.info("searching book by author : {} in book author service...", author);
        List<BookInfo> bookInfos = BookInfo.listOf(
            searchBookInfoRepository.findBookInfoByAuthorRegex(escapeRegexChars(author))
        );
        bookInfos.forEach(bookInfo -> bookInfo.countLikes(bookLikeService.countLikesByBookId(bookInfo.getId())));

        return bookInfos;
    }
}
