package com.booklog.book.bookdetail.controller;

import com.booklog.book.bookdetail.dto.Book;
import com.booklog.book.bookdetail.service.BookDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
@Slf4j
public class BookDetailController {
    private final BookDetailService bookDetailService;
    @GetMapping("/details")
    public ResponseEntity<Book> getBookDetailsById(@RequestParam String bookId) {
        log.info("fetching book detail by {}", bookId);
        Book bookDetail = bookDetailService.findBookDetailById(bookId);
        log.info("successfully fetch book detail");

        return new ResponseEntity<>(bookDetail, HttpStatus.OK);
    }
}
