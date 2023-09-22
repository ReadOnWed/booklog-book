package com.booklog.book.like.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;

@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BookLikeResponseDto {
    private long likesCount;

    public static BookLikeResponseDto of(long likesCount){
        return BookLikeResponseDto.builder()
                .likesCount(likesCount)
                .build();
    }
}
