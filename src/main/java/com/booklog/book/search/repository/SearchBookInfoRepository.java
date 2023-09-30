package com.booklog.book.search.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.booklog.book.search.entity.BookInfoEntity;


@Repository
public interface SearchBookInfoRepository extends MongoRepository<BookInfoEntity, String> {

	// book Collection에서 title field의 값이 ?0(= 첫번째 매개변수를 참조)를 포함하는 모든 Document를 조회
	// $options: 'i' : 대소문자를 구분하지 않고 조회
	@Query(value = "{'title':  {$regex :  ?0, $options:  'i'}}")
	List<BookInfoEntity> findBookInfoByTitleRegex(String title);

	@Query(value = "{'author':  {$regex :  ?0, $options:  'i'}}")
	List<BookInfoEntity> findBookInfoByAuthorRegex(String author);

	@Query(value = "{'publisher':  {$regex :  ?0, $options:  'i'}}")
	List<BookInfoEntity> findBookInfoByPublisherRegex(String publisher);

	List<BookInfoEntity> findBookInfoByMainCategory(String category);

	BookInfoEntity findBookInfoById(String bookId);
}
