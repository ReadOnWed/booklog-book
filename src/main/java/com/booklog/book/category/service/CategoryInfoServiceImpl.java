package com.booklog.book.category.service;

import com.booklog.book.category.dto.Category;
import com.booklog.book.category.repository.CategoryInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryInfoServiceImpl implements CategoryInfoService{
    private final CategoryInfoRepository categoryInfoRepository;
    @Override
    public List<Category> findCategories() {
        return categoryInfoRepository.findCategories();
    }
}
