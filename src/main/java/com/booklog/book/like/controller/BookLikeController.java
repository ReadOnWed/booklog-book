package com.booklog.book.like.controller;

import com.booklog.book.like.dto.BookLikeResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.book.like.dto.BookLikeRequestDto;
import com.booklog.book.like.dto.UserBookLike;
import com.booklog.book.like.service.BookLikeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class BookLikeController {
	private final BookLikeService bookLikeService;
	@PostMapping(value = "/like")
	public BookLikeResponseDto bookLike(@RequestBody BookLikeRequestDto bookLikeRequestDto){
		log.info("like book : {}, by user : {}", bookLikeRequestDto.getBookId(), bookLikeRequestDto.getUserId());
		return BookLikeResponseDto.of(bookLikeService.like(UserBookLike.of(bookLikeRequestDto)));
	}

	@PostMapping(value = "/unlike")
	public BookLikeResponseDto bookUnlike(@RequestBody BookLikeRequestDto bookLikeRequestDto){
		log.info("unlike book : {}, by user : {}", bookLikeRequestDto.getBookId(), bookLikeRequestDto.getUserId());
		return BookLikeResponseDto.of(bookLikeService.unlike(UserBookLike.of(bookLikeRequestDto)));
	}
}
