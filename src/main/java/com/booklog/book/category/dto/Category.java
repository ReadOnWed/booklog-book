package com.booklog.book.category.dto;

import com.booklog.book.category.common.MainCategoryEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Builder
public class Category {
    private String value;
    private String label;

    public static List<Category> of(List<String> mainCategories){
        return mainCategories.stream()
                .flatMap(category -> MainCategoryEnum.getDescriptionByCategory(category)
                        .map(description -> Category.builder()
                                .value(category)
                                .label(description)
                                .build())
                        .stream())
                .collect(Collectors.toList());
    }
}
