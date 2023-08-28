package com.booklog.book.category.repository;

import com.booklog.book.category.dto.Category;

import java.util.List;

public interface CategoryInfoRepository {
    List<Category> findCategories();
}
