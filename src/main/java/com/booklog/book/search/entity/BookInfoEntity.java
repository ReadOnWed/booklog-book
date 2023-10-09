package com.booklog.book.search.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Document(collection = "book")
@Getter
public class BookInfoEntity {
	@Id
	private String id;
	private String title;
	private String mainCategory;
	private String subCategory;
	private int rating;
	private int totalReviewsCount;
	private LocalDate recentReviewDate;
	private String author;
	private String publisher;
	private String pubdate;
}
