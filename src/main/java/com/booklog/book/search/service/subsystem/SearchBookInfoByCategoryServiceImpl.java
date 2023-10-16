package com.booklog.book.search.service.subsystem;

import com.booklog.book.category.common.MainCategoryEnum;
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
public class SearchBookInfoByCategoryServiceImpl implements SearchBookInfoService {
    private final SearchBookInfoRepository searchBookInfoRepository;
    private final BookLikeService bookLikeService;

    @Override
    public List<BookInfo> findBookInfos(String category) {
        if(StringUtils.isBlank(category)){
            return new ArrayList<>();
        }

        log.info("searching book by category : {} in book category service...", MainCategoryEnum.getDescriptionByCategory(category)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Category Code: " + category)));
        List<BookInfo> bookInfos = BookInfo.listOf(searchBookInfoRepository.findBookInfoByMainCategory(category));
        bookInfos.forEach(bookInfo -> bookInfo.countLikes(bookLikeService.countLikesByBookId(bookInfo.getId())));

        return bookInfos;
    }
}
