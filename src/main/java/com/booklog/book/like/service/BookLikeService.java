package com.booklog.book.like.service;

import com.booklog.book.like.dto.UserBookLike;

public interface BookLikeService {
	long like(UserBookLike userBookLike);
	long unlike(UserBookLike userBookLike);
	long countLikesByBookId(String bookId);
}
