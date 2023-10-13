package com.booklog.book.review.dto;

import java.time.LocalDateTime;

import com.booklog.book.bookdetail.dto.Book;

import lombok.Getter;

@Getter
public class ReviewRequestDto {
	private String id;
	private String userId;
	private String reviewWriter;
	private String reviewTitle;
	private int rating;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private int likesCount;
	private int scrapsCount;
	private int viewsCount;
	private Book book;
}
