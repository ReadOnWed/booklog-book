package com.booklog.book.bookdetail.repository;

import com.booklog.book.bookdetail.dto.BookDetail;
import com.booklog.book.bookdetail.dto.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MongoTemplateBookDetailRepository implements BookDetailRepository{
    public BookDetail findBookDetailById(String id){
        // TODO : docker 환경 세팅하여 mongodb 에서 조회해도록 수정
        Review review1 = Review.builder()
                .id("615f934eef5267d434cbf3e1")
                .reviewWriter("writer1vjgjmghkjhjkkh")
                .reviewTitle("주식투자 어떡하지adsgfasfasdlfjasldkfjlaksjflkasjlkfgasjlfjalksjflasjflkjflkasjklfdjklas")
                .reviewContent("책을 읽고 어쩌고 저쩌고 생각했는데...")
                .rating(50)
                .createdAt("2023-05-02")
                .updatedAt("2023-05-02")
                .likesCount(1311111111)
                .scrapsCount(4353536)
                .viewsCount(245)
                .build();

        Review review2 = Review.builder()
                .id("12334")
                .reviewWriter("writer2")
                .reviewTitle("주식투자 어떡하지")
                .reviewContent("책을 읽고 어쩌고 저쩌고 생각했는데...")
                .rating(30)
                .createdAt("2023-05-05")
                .updatedAt("2023-05-07")
                .likesCount(10)
                .scrapsCount(1)
                .viewsCount(300)
                .build();

        List<Review> reviews = new ArrayList<>();
        reviews.add(review1);
        reviews.add(review2);

        return BookDetail.builder()
                .bookId(id)
                .title("객체지향의 사실과 오해")
                .subTitle("역할, 책임, 협력 관점에서본 객체지향")
                .image("images/${imageName}.png")
                .price(16000)
                .description("『객체지향의 사실과 오해』는 객체지향이란 무엇인가라는 원론적면서도 다소 위험한 질문에 답하기 위해 쓰여진 책이다."
                        + "안타깝게도 많은 사람들이 객체지향의 본질을 오해하고 있다. 가장 널리 퍼져있는 오해는 클래스가 객체지향 프로그래밍의 중심이라는 것이다. "
                        + "객체지향으로 향하는 첫 걸음은 클래스가 아니라 객체를 바라보는 것에서부터 시작한다.")
                .mainCategory("기술과학")
                .subCategory("전자/전기공학")
                .viewsCount(16)
                .likesCount(10)
                .reviews(reviews)
                .totalReviewsCount(reviews.size())
                .rating(42)
                .recentReviewDate("2023-08-01")
                .author("조영호")
                .publisher("위키북스")
                .publicationDate("2022-01-01").build();
    }
}
