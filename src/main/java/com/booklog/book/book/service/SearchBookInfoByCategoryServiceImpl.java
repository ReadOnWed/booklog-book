package com.booklog.book.book.service;

import com.booklog.book.book.common.SearchBookInfoServiceBeanName;
import com.booklog.book.book.dto.BookInfoDto;
import com.booklog.book.book.repository.SearchBookInfoByCategoryRepository;
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
