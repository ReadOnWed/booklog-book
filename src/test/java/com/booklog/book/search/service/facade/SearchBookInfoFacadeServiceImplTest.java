package com.booklog.book.search.service.facade;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.booklog.book.category.common.MainCategoryEnum;
import com.booklog.book.search.common.SearchType;
import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.dto.BookInfoSearchTermDto;
import com.booklog.book.search.service.subsystem.SearchBookInfoByAuthorServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoByCategoryServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoByPublisherServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoByTitleServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoService;

@ExtendWith(MockitoExtension.class)
class SearchBookInfoFacadeServiceImplTest {
	@InjectMocks // @Mock 또는 @Spy 로 생성된 가짜 객체를 자동 주입
	private SearchBookInfoFacadeServiceImpl searchBookInfoFacadeService;

	@Mock
	private SearchBookInfoByTitleServiceImpl searchBookInfoByTitleService;

	@Mock
	private SearchBookInfoByCategoryServiceImpl searchBookInfoByCategoryService;

	@Mock
	private SearchBookInfoByPublisherServiceImpl searchBookInfoByPublisherService;

	@Mock
	private SearchBookInfoByAuthorServiceImpl searchBookInfoByAuthorService;

	private EnumMap<SearchType, SearchBookInfoService> searchBookInfoServiceEnumMap;

	@BeforeEach
	void setUp() {
		searchBookInfoServiceEnumMap = new EnumMap<>(SearchType.class);
		searchBookInfoServiceEnumMap.put(SearchType.TITLE, searchBookInfoByTitleService);
		searchBookInfoServiceEnumMap.put(SearchType.CATEGORY, searchBookInfoByCategoryService);
		searchBookInfoServiceEnumMap.put(SearchType.PUBLISHER, searchBookInfoByPublisherService);
		searchBookInfoServiceEnumMap.put(SearchType.AUTHOR, searchBookInfoByAuthorService);

		ReflectionTestUtils.setField(searchBookInfoFacadeService, "searchBookInfoServiceEnumMap",
			searchBookInfoServiceEnumMap);
	}

	@DisplayName("도서 제목별 검색")
	@Test
	void findBookInfosByTitle() {
		// given
		/** doReturn() : 가짜 객체가 특정한 값을 반환
		 * 1. when() 메서드의 파라미터로 전달된 가짜 객체가(= searchBookInfoServiceEnumMap.get())
		 * 2. when() 메서드에 체이딩된 메서드(= findBookInfos())를 호출했을때
		 * 3. 특정한 값인 doReturn() 메서드의 매개변수가 반환(bookInfos())됨을 정의
		 */
		final String searchTitle = "제목";
		doReturn(bookInfosByTitle()).when(searchBookInfoServiceEnumMap.get(SearchType.TITLE))
			.findBookInfos(searchTitle);

		// when
		BookInfoSearchTermDto bookInfoSearchTermDto = BookInfoSearchTermDto.builder()
			.title(searchTitle)
			.build();
		final List<BookInfo> resultBookInfos = searchBookInfoFacadeService.findBookInfos(bookInfoSearchTermDto);

		// then
		assertThat(resultBookInfos.size()).isEqualTo(2);
		// allSatisfy : 모든 조건을 충족
		assertThat(resultBookInfos).allSatisfy(resultBookInfo -> {
			assertThat(searchTitle).isSubstringOf(resultBookInfo.getTitle());
		});
	}

	private List<BookInfo> bookInfosByTitle() {
		List<BookInfo> bookInfos = List.of(
			BookInfo.builder()
				.id("test_book_id_1")
				.title("테스트 도서 제목")
				.build(),
			BookInfo.builder()
				.id("test_book_id_2")
				.title("테스트 도서 제목 2")
				.build()
		);

		return bookInfos;
	}

	@Test
	@DisplayName("도서 분류별 검색 테스트")
	void findBookInfosByCategory() {
		// given
		final String searchCategory = MainCategoryEnum.LINGUISTICS.getCategory();
		doReturn(bookInfosByCategory()).when(searchBookInfoServiceEnumMap.get(SearchType.CATEGORY))
			.findBookInfos(searchCategory);

		// when
		BookInfoSearchTermDto bookInfoSearchTermDto = BookInfoSearchTermDto.builder()
			.category(searchCategory)
			.build();
		List<BookInfo> resultBookInfos =
			searchBookInfoFacadeService.findBookInfos(bookInfoSearchTermDto);

		// then
		assertThat(resultBookInfos.size()).isEqualTo(1);
		assertThat(resultBookInfos).allSatisfy(resultBookInfo -> {
			assertThat(searchCategory).isEqualTo(resultBookInfo.getMainCategory());
		});
	}

	private List<BookInfo> bookInfosByCategory() {
		return List.of(
			BookInfo.builder()
				.mainCategory(MainCategoryEnum.LINGUISTICS.getCategory())
				.build());
	}

	@Test
	@DisplayName("도서 제목, 저자별 검색 테스트")
	void findBookInfosByTitleAndAuthor() {
		// given
		String searchTitle = "제목";
		String searchAuthor = "버핏";

		doReturn(bookInfosByTitleAndAuthor()).when(searchBookInfoServiceEnumMap.get(SearchType.TITLE))
			.findBookInfos(searchTitle);
		doReturn(bookInfosByTitleAndAuthor()).when(searchBookInfoServiceEnumMap.get(SearchType.AUTHOR))
			.findBookInfos(searchAuthor);

		// when
		BookInfoSearchTermDto searchTermDto = BookInfoSearchTermDto.builder()
			.title(searchTitle)
			.author(searchAuthor)
			.build();
		List<BookInfo> resultBookInfos = searchBookInfoFacadeService.findBookInfos(searchTermDto);

		// then
		assertThat(resultBookInfos.size()).isEqualTo(1);
		assertThat(resultBookInfos).allSatisfy(resultBookInfo -> {
			assertThat(searchTitle).isSubstringOf(resultBookInfo.getTitle());
			assertThat(searchAuthor).isSubstringOf(resultBookInfo.getAuthor());
		});
	}

	private List<BookInfo> bookInfosByTitleAndAuthor() {
		List<BookInfo> testBookInfos = new ArrayList<>();

		testBookInfos.add(
			BookInfo.builder()
				.id("book_test_1")
				.title("테스트 도서 제목")
				.author("워렌 버핏")
				.build()
		);

		return testBookInfos;
	}

	@Test
	@DisplayName("도서 제목, 분류, 출판사, 저자별 검색 테스트")
	void findBookInfosByTitleAndCategoryAndPublisherAndAuthor() {
		// given
		String title = "제목";
		doReturn(bookInfosByTitleOrCategory()).when(searchBookInfoServiceEnumMap.get(SearchType.TITLE))
			.findBookInfos(title);

		String category = MainCategoryEnum.SOCIOLOGY.getCategory();
		doReturn(bookInfosByTitleOrCategory()).when(searchBookInfoServiceEnumMap.get(SearchType.CATEGORY))
			.findBookInfos(category);

		String author = "버핏";
		doReturn(bookInfosByAuthorOrPublisher()).when(searchBookInfoServiceEnumMap.get(SearchType.AUTHOR))
			.findBookInfos(author);

		String publisher = "출판사";
		doReturn(bookInfosByAuthorOrPublisher()).when(searchBookInfoServiceEnumMap.get(SearchType.PUBLISHER))
			.findBookInfos(publisher);

		// when
		BookInfoSearchTermDto searchTermDto = BookInfoSearchTermDto.builder()
			.title(title)
			.category(category)
			.author(author)
			.publisher(publisher)
			.build();
		List<BookInfo> resultBookInfos = searchBookInfoFacadeService.findBookInfos(searchTermDto);

		// then
		assertThat(resultBookInfos.size()).isEqualTo(2);
		assertThat(resultBookInfos).allSatisfy(resultBookInfo -> {
			assertThat(resultBookInfo.getTitle().contains(title) ||
				resultBookInfo.getMainCategory().equals(category) ||
				resultBookInfo.getAuthor().contains(author) ||
				resultBookInfo.getPublisher().equals(publisher)).isTrue();
		});
	}

	private List<BookInfo> bookInfosByTitleOrCategory() {
		return List.of(BookInfo.builder()
			.id("test_book_id_1")
			.title("테스드 도서 제목")
			.mainCategory("3")
			.author("워렌 버핏")
			.publisher("테스트")
			.build()
		);
	}

	private List<BookInfo> bookInfosByAuthorOrPublisher() {
		return List.of(BookInfo.builder()
			.id("test_book_id_2")
			.title("테스드 도서")
			.mainCategory("1")
			.author("워렌 버핏")
			.publisher("테스트 출판사 1")
			.build()
		);
	}
}