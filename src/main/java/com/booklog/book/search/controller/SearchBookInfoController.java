package com.booklog.book.search.controller;

import com.booklog.book.promotion.dto.BookInfoDto;
import com.booklog.book.search.dto.BookInfoSearchTermDto;
import com.booklog.book.search.service.SearchBookInfoFacadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
@Slf4j
public class SearchBookInfoController {
    private final SearchBookInfoFacadeService searchBookInfoFacadeService;

    @GetMapping("/search")
    public ResponseEntity<List<BookInfoDto>> searchBookInfos(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) String author
    ) {
        log.info("fetching search books...");
        log.debug("search by title : {}", title);
        log.debug("search by category : {}", category);
        log.debug("search by publisher : {}", publisher);
        log.debug("search by author : {}", author);

        BookInfoSearchTermDto searchTermDto = BookInfoSearchTermDto.builder()
                .title(title)
                .category(category)
                .publisher(publisher)
                .author(author)
                .build();

        List<BookInfoDto> books = searchBookInfoFacadeService.findBookInfos(searchTermDto);
        log.info("successfully fetch search books...");
        if(books.isEmpty()){
            return new ResponseEntity<>(books, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}