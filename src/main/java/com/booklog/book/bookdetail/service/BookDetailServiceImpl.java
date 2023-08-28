package com.booklog.book.bookdetail.service;

import com.booklog.book.bookdetail.dto.BookDetail;
import com.booklog.book.bookdetail.repository.BookDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookDetailServiceImpl implements BookDetailService{
    private final BookDetailRepository bookDetailRepository;
    @Override
    public BookDetail findBookDetailById(String bookId) {
        return bookDetailRepository.findBookDetailById(bookId);
    }
}
