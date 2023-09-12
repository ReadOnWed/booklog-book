package com.booklog.book.category.repository;

import java.util.List;

public interface CategoryInfoRepository {
    List<String> findDistinctMainCategory();
}
