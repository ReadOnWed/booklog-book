package com.booklog.book.search.controller;

import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.dto.BookInfoSearchTermDto;
import com.booklog.book.search.service.SearchBookInfoByIdService;
import com.booklog.book.search.service.facade.SearchBookInfoFacadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books/search")
@Slf4j
public class SearchBookInfoController {
    private final SearchBookInfoFacadeService searchBookInfoFacadeService;
    private final SearchBookInfoByIdService searchBookInfoByIdService;

    @GetMapping("")
    public List<BookInfo> searchBookInfos(
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

        return searchBookInfoFacadeService.findBookInfos(searchTermDto);
    }

    @GetMapping("/book-id")
    public BookInfo searchBookInfoById(@RequestParam String bookId){
        log.info("fetching search book by {} ...", bookId);
        return searchBookInfoByIdService.findBookInfo(bookId);
    }
}