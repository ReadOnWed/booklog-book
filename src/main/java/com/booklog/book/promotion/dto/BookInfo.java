package com.booklog.book.promotion.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.booklog.book.promotion.entity.BookInfoEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookInfo {
	private String id;
	private String title;
	private int rating;
	private String recentReviewDate;
	private String author;
	private String publisher;
	private String publicationDate;
	private int reviewsCount;

	public static List<BookInfo> listOf(Page<BookInfoEntity> bookInfoEntities){
		return bookInfoEntities.stream()
			.map(BookInfo::of)
			.collect(Collectors.toList());
	}

	private static BookInfo of(BookInfoEntity bookInfoEntity){
		return BookInfo.builder()
			.id(bookInfoEntity.getId())
			.title(bookInfoEntity.getTitle())
			.rating(bookInfoEntity.getRating())
			.recentReviewDate(toString(bookInfoEntity.getRecentReviewDate()))
			.author(bookInfoEntity.getAuthor())
			.publisher(bookInfoEntity.getPublisher())
			.publicationDate(bookInfoEntity.getPubdate())
			.reviewsCount(bookInfoEntity.getReviewsCount())
			.build();
	}

	private static String toString(LocalDate recentReviewDate){
		if(recentReviewDate == null){
			return "";
		}
		return recentReviewDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
