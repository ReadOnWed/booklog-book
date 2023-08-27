package com.booklog.book.book.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.booklog.book.book.dto.BookInfoDto;

@Repository
public class LatelyReviewedBookInfoRepository implements BookInfoRepository{
	@Override
	public List<BookInfoDto> findBookInfos() {
		// TODO : docker 환경 세팅 후 db 접근하여 조회하도록 수정
		List<BookInfoDto> bookInfoList = new ArrayList<>();

		bookInfoList.add(
			BookInfoDto.builder()
				.id("1")
				.title("Lately Reviewed 1")
				.rating(45)
				.totalReviewsCount(30)
				.recentReviewDate("2022-01-01")
				.author("Author X")
				.publisher("Publisher A")
				.publicationDate("2022-01-01")
				.totalResults(10).build()
		);

		bookInfoList.add(
			BookInfoDto.builder()
				.id("2")
				.title("Lately Reviewed 2")
				.rating(45)
				.totalReviewsCount(30)
				.recentReviewDate("2022-01-01")
				.author("Author Y")
				.publisher("Publisher B")
				.publicationDate("2022-01-01")
				.totalResults(10).build()
		);

		bookInfoList.add(
			BookInfoDto.builder()
				.id("3")
				.title("Lately Reviewed 3")
				.rating(45)
				.totalReviewsCount(30)
				.recentReviewDate("2022-01-01")
				.author("Author Z")
				.publisher("Publisher C")
				.publicationDate("2022-01-01")
				.totalResults(10).build()
		);

		return bookInfoList;
	}
}
