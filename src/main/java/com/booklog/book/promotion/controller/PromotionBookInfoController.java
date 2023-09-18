package com.booklog.book.promotion.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.book.promotion.common.PromotionType;
import com.booklog.book.promotion.dto.BookInfo;
import com.booklog.book.promotion.service.PromotionBookInfoFacadeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books/promotion")
@Slf4j
public class PromotionBookInfoController {
	private final PromotionBookInfoFacadeService promotionBookInfoFacadeService;

	@GetMapping("/top-rated")
 	public ResponseEntity<List<BookInfo>> getTopRatedBooks() {
		return getBooksInfos(PromotionType.TOP_RATED);
	}

	@GetMapping("/most-reviewed")
	public ResponseEntity<List<BookInfo>> getMostReviewedBooks() {
		return getBooksInfos(PromotionType.MOST_REVIEWED);
	}

	@GetMapping("/recent-reviewed")
	public ResponseEntity<List<BookInfo>> getLatelyReviewedBooks() {
		return getBooksInfos(PromotionType.LATELY_REVIEWED);
	}

	private ResponseEntity<List<BookInfo>> getBooksInfos(PromotionType promotionType){
		log.info("fetching {}-books...", promotionType.getType());
		List<BookInfo> books = promotionBookInfoFacadeService.findBookInfos(promotionType);
		log.info("successfully fetch {}-books...", promotionType.getType());
		if(books.isEmpty()){
			return new ResponseEntity<>(books, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
}
