package com.booklog.book.like.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.*;

@Builder
@Getter
public class UserBookLikeEvent {
    private String bookId;
    private String userId;
    private String likedAt;

    public static UserBookLikeEvent of(UserBookLike userBookLike) {
        return UserBookLikeEvent.builder()
				.bookId(userBookLike.getBookId())
                .userId(userBookLike.getUserId())
                .likedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }
}
