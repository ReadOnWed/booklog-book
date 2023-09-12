package com.booklog.book.category.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "category")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {
    @MongoId
    private ObjectId _id;
    private String mainCategory;
    private String mainCategoryName;
    private String subCategory;
    private String subCategoryName;
}
