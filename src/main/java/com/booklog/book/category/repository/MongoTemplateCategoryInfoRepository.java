package com.booklog.book.category.repository;

import com.booklog.book.category.dto.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MongoTemplateCategoryInfoRepository implements CategoryInfoRepository{
    @Override
    public List<Category> findCategories() {
        // TODO : 실제 DB 접속하여 조회하도록 수정
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("000", "수학"));
        categories.add(new Category("111", "과학"));
        categories.add(new Category("222", "역사"));

        return categories;
    }
}
