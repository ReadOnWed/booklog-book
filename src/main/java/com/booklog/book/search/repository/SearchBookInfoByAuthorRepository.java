package com.booklog.book.search.repository;

import com.booklog.book.promotion.dto.BookInfoDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchBookInfoByAuthorRepository implements SearchBookInfoRepository{
    @Override
    public List<BookInfoDto> findBookInfos(String author) {
        // TODO : docker 환경 세팅 후 db 접근하여 조회하도록 수정
        return new ArrayList<>();
    }
}
