package com.booklog.book.promotion.entity;

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
	private int rating;
	private LocalDate recentReviewDate;
	private String author;
	private String publisher;
	private String pubdate;
	private int totalReviewsCount;
}
