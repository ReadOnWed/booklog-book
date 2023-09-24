package com.booklog.book.bookdetail.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.booklog.book.bookdetail.entity.BookEntity;
import com.booklog.book.bookdetail.entity.ReviewEntity;
import com.booklog.book.category.common.MainCategoryEnum;
import com.booklog.book.category.common.SubCategoryEnum;

@Getter
@Builder
public class Book {
    private String bookId;
    private String title;
    private String subTitle;
    private String image;
    private int price;
    private String description;
    private String mainCategoryCode;
    private String mainCategoryName;
    private String subCategoryCode;
    private String subCategoryName;
    private long likesCount;
    private int rating;
    private String recentReviewDate;
    private String author;
    private String publisher;
    private String publicationDate;
    private List<Review> reviews;
    private int totalReviewsCount;

    public static Book of(BookEntity bookEntity){
        return Book.builder()
            .bookId(bookEntity.getBookId())
            .title(bookEntity.getTitle())
            .subTitle(bookEntity.getSubTitle())
            .image(bookEntity.getBookId())
            .price(Integer.parseInt(bookEntity.getDiscount()))
            .description(bookEntity.getDescription())
            .mainCategoryCode(bookEntity.getMainCategory())
            .mainCategoryName(mainDescriptionOf(bookEntity.getMainCategory()))
            .subCategoryCode(bookEntity.getSubCategory())
            .subCategoryName(subDescriptionOf(bookEntity.getSubCategory()))
            .likesCount(bookEntity.getLikesCount())
            .rating(bookEntity.getRating())
            .recentReviewDate(bookEntity.getRecentReviewDate())
            .author(bookEntity.getAuthor())
            .publisher(bookEntity.getPublisher())
            .publicationDate(bookEntity.getPubdate())
            .reviews(reviewsOf(bookEntity.getReviews()))
            .totalReviewsCount(bookEntity.getTotalReviewsCount())
            .build();
    }

    private static String mainDescriptionOf(String mainCategory){
        return MainCategoryEnum.getDescriptionByCategory(mainCategory)
            .orElse("분류 없음");
    }

    private static String subDescriptionOf(String subCategory){
        return SubCategoryEnum.getDescriptionByCategory(subCategory)
            .orElse("분류 없음");

    }

    private static List<Review> reviewsOf(List<ReviewEntity> reviewEntities){
        if(reviewEntities == null){
            return new ArrayList<>();
        }

        return reviewEntities.stream()
            .map(Review::of)
            .collect(Collectors.toList());
    }

    public void countLikes(long likesCount){
        this.likesCount = likesCount;
    }
}