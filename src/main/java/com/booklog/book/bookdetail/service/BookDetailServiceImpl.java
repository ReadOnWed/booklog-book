package com.booklog.book.bookdetail.service;

import com.booklog.book.bookdetail.dto.Book;
import com.booklog.book.bookdetail.repository.BookDetailRepository;
import com.booklog.book.like.service.BookLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookDetailServiceImpl implements BookDetailService{
    private final BookDetailRepository bookDetailRepository;
    private final BookLikeService bookLikeService;
    @Override
    public Book findBookDetailById(String bookId) {
        return Book.of(bookDetailRepository.findBookEntityByBookId(bookId))
            .countLikes(bookLikeService.countLikesByBookId(bookId));
    }
}
