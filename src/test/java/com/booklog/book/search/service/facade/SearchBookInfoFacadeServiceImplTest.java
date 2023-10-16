package com.booklog.book.search.service.facade;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.booklog.book.search.common.SearchType;
import com.booklog.book.search.dto.BookInfo;
import com.booklog.book.search.dto.BookInfoSearchTermDto;
import com.booklog.book.search.service.subsystem.SearchBookInfoByAuthorServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoByCategoryServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoByPublisherServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoByTitleServiceImpl;
import com.booklog.book.search.service.subsystem.SearchBookInfoService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
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

		ReflectionTestUtils.setField(searchBookInfoFacadeService, "searchBookInfoServiceEnumMap", searchBookInfoServiceEnumMap);
	}


	@DisplayName("도서 제목별 검색")
	@Test
	void findBookInfosByTitle(){
		// given
		/** doReturn() : 가짜 객체가 특정한 값을 반환
		 * 1. when() 메서드의 파라미터로 전달된 가짜 객체가(= searchBookInfoServiceEnumMap.get())
		 * 2. when() 메서드에 체이딩된 메서드(= findBookInfos())를 호출했을때
		 * 3. 특정한 값인 doReturn() 메서드의 매개변수가 반환(bookInfos())됨을 정의
		 */
		final String searchTitle = "제목";
		doReturn(bookInfos()).when(searchBookInfoServiceEnumMap.get(SearchType.TITLE))
				.findBookInfos(searchTitle);

		// when
		BookInfoSearchTermDto bookInfoSearchTermDto = BookInfoSearchTermDto.builder()
			.title(searchTitle)
			.build();
		final List<BookInfo> resultBookInfos = searchBookInfoFacadeService.findBookInfos(bookInfoSearchTermDto);

		// then
		assertThat(resultBookInfos.size()).isEqualTo(1);
		assertThat(resultBookInfos).allSatisfy(bookInfo -> {
			assertThat(searchTitle).isSubstringOf(bookInfo.getTitle());
		});
	}

	private List<BookInfo> bookInfos() {
		List<BookInfo> bookInfos = new ArrayList<>();
		BookInfo bookInfo = BookInfo.builder()
			.title("테스트 도서 제목")
			.build();

		bookInfos.add(bookInfo);
		return bookInfos;
	}
	@Test
	@DisplayName("도서 분류별 검색 테스트")
	void findBookInfosByCategory(){


	}


	@Test
	@DisplayName("도서 제목, 분류별 검색 테스트")
	void findBookInfosByTitleAndCategory(){


	}


	@Test
	@DisplayName("도서 분류, 출판사, 저자별 검색 테스트")
	void findBookInfosByCategoryAndPublisherAndAuthor(){


	}


	@Test
	@DisplayName("도서 제목, 분류, 출판사, 저자별 검색 테스트")
	void findBookInfosByTitleAndCategoryAndPublisherAndAuthor(){


	}


	@AfterEach
	void tearDown() {
	}
}