package com.booklog.book.like.repository;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.booklog.book.like.dto.UserBookLikeEvent;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Repository
@RequiredArgsConstructor
public class BookLikeRedisRepository {
	private final RedisTemplate<String, Object> redisTemplate;
	private static final String KEY = "like:book:";

	public Boolean isLikedBookByUserId(String bookId, String userId){
		return redisTemplate.opsForHash().hasKey(KEY + bookId, userId);
	}

	public void putLikeForBook(UserBookLikeEvent userBookLikeEvent){
		redisTemplate.opsForHash().put(
				KEY + userBookLikeEvent.getBookId(),
				userBookLikeEvent.getUserId(),
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
	}

	public long deleteLikeForBookByUserId(String bookId, String userId){
		return redisTemplate.opsForHash().delete(KEY + bookId, userId);
	}
	public Long getLikesCountByBookId(String bookId){
		return redisTemplate.opsForHash().size(KEY + bookId);
	}
}
