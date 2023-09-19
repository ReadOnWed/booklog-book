package com.booklog.book.search.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.booklog.book.search.entity.BookInfoEntity;

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
	private int totalReviewsCount;

	public static List<BookInfo> listOf(List<BookInfoEntity> bookInfoEntities){
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
			.totalReviewsCount(bookInfoEntity.getTotalReviewsCount())
			.build();
	}

	private static String toString(LocalDate recentReviewDate){
		if(recentReviewDate == null){
			return "";
		}
		return recentReviewDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BookInfo)) {
			return false;
		}

		return Objects.equals(this.id, ((BookInfo)obj).getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
