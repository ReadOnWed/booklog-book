package com.booklog.book.review.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.book.bookdetail.dto.Review;
import com.booklog.book.review.dto.ReviewRequestDto;
import com.booklog.book.review.service.ReviewUpdateService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books/details")
@Slf4j
public class ReviewUpdateController {
	private final ReviewUpdateService reviewUpdateService;

	@PostMapping("/review")
	public void postReviewInfo(@RequestBody ReviewRequestDto reviewRequestDto){
		log.info("post review {} info to book {}",reviewRequestDto.getId(), reviewRequestDto.getBook().getId());
		reviewUpdateService.postReviewInfo(Review.of(reviewRequestDto));
	}

	@PutMapping("/review")
	public void editReviewInfo(@RequestBody ReviewRequestDto reviewRequestDto){
		log.info("edit review {} info to book {}", reviewRequestDto.getId(), reviewRequestDto.getBook().getId());
		reviewUpdateService.editReviewInto(Review.of(reviewRequestDto));
	}

	@DeleteMapping("/review")
	public void deleteReviewInfo(@RequestParam String reviewId, @RequestParam String bookId){
		log.info("delete review {} info to book {}", reviewId, bookId);
		reviewUpdateService.deleteReviewInfo(reviewId, bookId);
	}
}
