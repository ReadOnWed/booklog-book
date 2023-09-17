package com.booklog.book.bookdetail.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Document(collection = "book")
@Getter
public class BookEntity {
	@Id
	private String bookId;
	private String isbn;
	private String title;
	private String subTitle;
	private String image;
	private String discount;
	private String description;
	private String mainCategory;
	private String subCategory;
	private int viewsCount;
	private int likesCount;
	private int rating;
	private String recentReviewDate;
	private String author;
	private String publisher;
	private String pubdate;
	private List<ReviewEntity> reviews;
	private int totalReviewsCount;
}
