package com.booklog.book.bookdetail.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection = "book")
public class ReviewEntity {
	private String id;
	private String reviewWriter;
	private String reviewTitle;
	private String reviewContent;
	private int rating;
	private String createdAt;
	private String updatedAt;
	@Nullable
	private Integer likesCount;
	@Nullable
	private Integer scrapsCount;
	@Nullable
	private Integer viewsCount;
}
