package com.booklog.book.search.repository;

import com.booklog.book.bookinfo.dto.BookInfoDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchBookInfoByTitleRepository implements SearchBookInfoRepository{
    @Override
    public List<BookInfoDto> findBookInfos(String title) {
        // TODO : docker 환경 세팅 후 db 접근하여 조회하도록 수정
        List<BookInfoDto> bookInfoList = new ArrayList<>();
        BookInfoDto book = BookInfoDto.builder()
                .id("1")
                .title("Searched Book By Title")
                .rating(45)
                .totalReviewsCount(30)
                .recentReviewDate("2022-01-01")
                .author("Author X")
                .publisher("Publisher A")
                .publicationDate("2022-01-01")
                .totalResults(10)
                .build();


        bookInfoList.add(book);
        return bookInfoList;
    }
}
