package com.booklog.book.category.common;

import java.util.Arrays;
import java.util.Optional;

public enum SubCategoryEnum {
	STATISTICS("310", "통계"),
	ECONOMICS("320", "경제"),
	SOCIOLOGY("330", "사회"),
	POLITICS("340", "정치"),
	ADMINISTRATION("350", "행정"),
	LAW("360", "법률"),
	EDUCATION("370", "교육"),
	CULTURE("380", "문화"),
	MILITARY("390", "군사");

	private final String category;
	private final String description;
	SubCategoryEnum(String category, String description){
		this.category = category;
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	// category 코드값을 입력으로 받아 적절한 description을 반환
	public static Optional<String> getDescriptionByCategory(String categoryCode) {
		return Arrays.stream(SubCategoryEnum.values())
			.filter(m -> m.category.equals(categoryCode))
			.map(SubCategoryEnum::getDescription)
			.findFirst();
	}
}
