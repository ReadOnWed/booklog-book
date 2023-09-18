package com.booklog.book.search.service;

import com.booklog.book.category.common.MainCategoryEnum;
import com.booklog.book.search.common.SearchBookInfoServiceBeanName;
import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.repository.SearchBookInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(SearchBookInfoServiceBeanName.CATEGORY)
@RequiredArgsConstructor
@Slf4j
public class SearchBookInfoByCategoryServiceImpl implements SearchBookInfoService {
    private final SearchBookInfoRepository searchBookInfoRepository;

    @Override
    public List<BookInfo> findBookInfos(String category) {
        log.info("searching book by category : {} in book category service..."
                , MainCategoryEnum.getDescriptionByCategory(category)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid Category Code: " + category)));
        return BookInfo.listOf(searchBookInfoRepository.findBookInfoByMainCategory(category));
    }
}
