package com.booklog.book.category.repository;

import com.booklog.book.category.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MongoTemplateCategoryInfoRepository implements CategoryInfoRepository{
    private final MongoTemplate mongoTemplate;

    @Override
    public List<String> findDistinctMainCategory(){
        // CategoryEntity.class에 매핑되는 Mongo Collection에서 mainCategory 필드만을 Distinct로 String 타입으로 반환
        return mongoTemplate.findDistinct("mainCategory", CategoryEntity.class, String.class);
    }
}
