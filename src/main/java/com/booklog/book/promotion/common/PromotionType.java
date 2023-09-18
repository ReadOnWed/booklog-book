package com.booklog.book.promotion.common;

public enum PromotionType {
	TOP_RATED("top-rated", "topRatedBookInfoServiceImpl"),
	MOST_REVIEWED("most-reviewed", "mostReviewedBookInfoServiceImpl"),
	LATELY_REVIEWED("lately-reviewed", "latelyReviewedBookInfoServiceImpl");

	private final String type;
	private final String instanceName;
	PromotionType(String type, String instanceName){
		this.type = type;
		this.instanceName = instanceName;
	}

	public String getType(){
		return type;
	}

	public String getInstanceName(){
		return instanceName;
	}
}