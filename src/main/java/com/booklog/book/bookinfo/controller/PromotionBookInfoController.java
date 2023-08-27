package com.booklog.book.bookinfo.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.book.bookinfo.common.PromotionType;
import com.booklog.book.bookinfo.dto.BookInfoDto;
import com.booklog.book.bookinfo.service.PromotionBookInfoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books/promotion")
@Slf4j
public class PromotionBookInfoController {
	private final PromotionBookInfoService promotionBookInfoService;

	@GetMapping("/top-rated")
 	public ResponseEntity<List<BookInfoDto>> getTopRatedBooks() {
		return getBooksInfos(PromotionType.TOP_RATED);
	}

	@GetMapping("/top-reviewed-in-month")
	public ResponseEntity<List<BookInfoDto>> getMostReviewedInMonthBooks() {
		return getBooksInfos(PromotionType.MOST_REVIEWED_IN_MONTH);
	}

	@GetMapping("/recent-reviewed")
	public ResponseEntity<List<BookInfoDto>> getLatelyReviewedBooks() {
		return getBooksInfos(PromotionType.LATELY_REVIEWED);
	}

	private ResponseEntity<List<BookInfoDto>> getBooksInfos(PromotionType promotionType){
		log.info("fetching {}-books...", promotionType.getType());
		List<BookInfoDto> books = promotionBookInfoService.findBookInfos(promotionType);
		log.info("successfully fetch {}-books...", promotionType.getType());
		if(books.isEmpty()){
			return new ResponseEntity<>(books, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
}
