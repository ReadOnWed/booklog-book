package com.booklog.book.book.repository;

import com.booklog.book.book.dto.BookInfoDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchBookInfoByCategoryRepository implements SearchBookInfoRepository{
    @Override
    public List<BookInfoDto> findBookInfos(String category) {
        // TODO : docker 환경 세팅 후 db 접근하여 조회하도록 수정
        List<BookInfoDto> bookInfoList = new ArrayList<>();
        BookInfoDto book = BookInfoDto.builder()
                .id("1")
                .title("Searched Book By Category")
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
