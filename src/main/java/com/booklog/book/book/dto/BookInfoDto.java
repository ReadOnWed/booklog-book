package com.booklog.book.book.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Builder
public class BookInfoDto {
	private String id;
	private String title;
	private int rating;
	private int totalReviewsCount;
	private String recentReviewDate;
	private String author;
	private String publisher;
	private String publicationDate;
	private int totalResults;
}
