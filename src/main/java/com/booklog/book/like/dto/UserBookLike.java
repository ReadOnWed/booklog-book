package com.booklog.book.like.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserBookLike {
	private String bookId;
	private String userId;

	public static UserBookLike of(BookLikeRequestDto bookLikeRequestDto){
		return UserBookLike.builder()
			.bookId(bookLikeRequestDto.getBookId())
			.userId(bookLikeRequestDto.getUserId())
			.build();
	}
}
