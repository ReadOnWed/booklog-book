package com.booklog.book.like.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booklog.book.like.dto.UserBookLike;
import com.booklog.book.like.dto.UserBookLikeEvent;
import com.booklog.book.like.repository.BookLikeRedisRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookLikeServiceImpl implements BookLikeService{
	private final BookLikeRedisRepository bookLikeRedisRepository;
	@Override
	public long like(UserBookLike userBookLike) {
		 if(bookLikeRedisRepository.isLikedBookByUserId(userBookLike.getBookId(), userBookLike.getUserId())){
		 	return bookLikeRedisRepository.getLikesCountByBookId(userBookLike.getBookId());
		 }

		bookLikeRedisRepository.putLikeForBook(UserBookLikeEvent.of(userBookLike));
		return bookLikeRedisRepository.getLikesCountByBookId(userBookLike.getBookId());
	}

	@Override
	public long unlike(UserBookLike userBookLike) {
		bookLikeRedisRepository.deleteLikeForBookByUserId(userBookLike.getBookId(), userBookLike.getUserId());
		return bookLikeRedisRepository.getLikesCountByBookId(userBookLike.getBookId());
	}

	@Override
	public long countLikesByBookId(String bookId){
		return bookLikeRedisRepository.getLikesCountByBookId(bookId);
	}
}
