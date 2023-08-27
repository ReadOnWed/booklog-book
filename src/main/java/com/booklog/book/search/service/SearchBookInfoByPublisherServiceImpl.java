package com.booklog.book.search.service;

import com.booklog.book.search.common.SearchBookInfoServiceBeanName;
import com.booklog.book.bookinfo.dto.BookInfoDto;
import com.booklog.book.search.repository.SearchBookInfoByPublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(SearchBookInfoServiceBeanName.PUBLISHER)
@RequiredArgsConstructor
@Slf4j
public class SearchBookInfoByPublisherServiceImpl implements SearchBookInfoService {
    private final SearchBookInfoByPublisherRepository searchBookInfoByPublisherRepository;

    @Override
    public List<BookInfoDto> findBookInfos(String publisher) {
        log.info("searching book by publisher : {} in book publisher service...", publisher);
        return searchBookInfoByPublisherRepository.findBookInfos(publisher);
    }
}
