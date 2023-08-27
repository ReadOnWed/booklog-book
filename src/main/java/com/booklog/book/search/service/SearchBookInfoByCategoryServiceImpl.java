package com.booklog.book.search.service;

import com.booklog.book.search.common.SearchBookInfoServiceBeanName;
import com.booklog.book.bookinfo.dto.BookInfoDto;
import com.booklog.book.search.repository.SearchBookInfoByCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(SearchBookInfoServiceBeanName.CATEGORY)
@RequiredArgsConstructor
@Slf4j
public class SearchBookInfoByCategoryServiceImpl implements SearchBookInfoService {
    private final SearchBookInfoByCategoryRepository searchBookInfoByCategoryRepository;

    @Override
    public List<BookInfoDto> findBookInfos(String category) {
        log.info("searching book by category : {} in book category service...",category);
        return searchBookInfoByCategoryRepository.findBookInfos(category);
    }
}