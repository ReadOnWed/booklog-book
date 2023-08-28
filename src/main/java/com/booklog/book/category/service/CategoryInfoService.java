package com.booklog.book.category.service;

import com.booklog.book.category.dto.Category;

import java.util.List;

public interface CategoryInfoService {
    List<Category> findCategories();
}
