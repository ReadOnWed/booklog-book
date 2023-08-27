package com.booklog.book.category.controller;

import com.booklog.book.category.dto.Category;
import com.booklog.book.category.service.CategoryInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/v1/books")
public class CategoryInfoController {
    private final CategoryInfoService categoryInfoService;
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        log.info("fetching book category list...");
        List<Category> categories = categoryInfoService.findCategories();
        log.info("successfully fetch book category list");

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
