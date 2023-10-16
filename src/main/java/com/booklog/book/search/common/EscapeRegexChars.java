package com.booklog.book.search.common;

public class EscapeRegexChars {
	private static final String specialRegex = "([.^$*+?{\\[\\]|()\\\\])";

	public static String escapeRegexChars(String input){
		return input.replaceAll(specialRegex, "\\\\$1");
	}
}
