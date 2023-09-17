package com.booklog.book.bookdetail.service;

import com.booklog.book.bookdetail.dto.Book;
import com.booklog.book.bookdetail.repository.BookDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookDetailServiceImpl implements BookDetailService{
    private final BookDetailRepository bookDetailRepository;
    @Override
    public Book findBookDetailById(String bookId) {
        return Book.of(bookDetailRepository.findBookEntityByBookId(bookId));
    }
}
