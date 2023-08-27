package com.booklog.book.bookinfo.common;

public enum PromotionType {
	TOP_RATED("top-rated"),
	MOST_REVIEWED_IN_MONTH("most-reviewed-in-month"),
	LATELY_REVIEWED("lately-reviewed");

	private final String type;
	PromotionType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}