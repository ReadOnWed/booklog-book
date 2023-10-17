package com.booklog.book.category.common;

import java.util.Arrays;
import java.util.Optional;

public enum MainCategoryEnum {
    GENERAL("0", "총류"),
    PHILOSOPHY("1", "철학"),
    THEOLOGY("2", "종교"),
    SOCIOLOGY("3", "사회"),
    NATURAL_SCIENCE("4", "자연과학"),
    TECHNOLOGY("5", "기술과학"),
    ARTS("6", "예술"),
    LINGUISTICS("7", "언어"),
    LITERATURE("8", "문학"),
    HISTORY("9", "역사");

    private final String category;
    private final String description;
    MainCategoryEnum(String category, String description){
        this.category = category;
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription(){
        return this.description;
    }

    // category 코드값을 입력으로 받아 적절한 description을 반환
    public static Optional<String> getDescriptionByCategory(String categoryCode) {
        return Arrays.stream(MainCategoryEnum.values())
                .filter(m -> m.category.equals(categoryCode))
                .map(MainCategoryEnum::getDescription)
                .findFirst();
    }
}
