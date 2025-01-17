package com.gdgoc.Online_Library.book;

import com.gdgoc.Online_Library.book.dto.BookGetResponse;
import com.gdgoc.Online_Library.book.dto.BooksGetResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public Book getBookOrException(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + bookId));
    }

    @Transactional(readOnly = true)
    public BookGetResponse getBookInfo(Long bookId) {
        Book book = getBookOrException(bookId);
        return BookGetResponse.of(book);
    }

    @Transactional(readOnly = true)
    public BooksGetResponse searchBookWithTitle(String query) {
        List<Book> books = bookRepository.findByTitleContaining(query);
        return BooksGetResponse.of(books);
    }

    @Transactional(readOnly = true)
    public BooksGetResponse searchBookWithAuthor(String query) {
        List<Book> books = bookRepository.findByAuthorContaining(query);
        return BooksGetResponse.of(books);
    }
}
