package com.gdgoc.Online_Library.book;

import static org.springframework.http.HttpStatus.OK;

import com.gdgoc.Online_Library.book.dto.BookGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{bookId}")
    public ResponseEntity<BookGetResponse> getBookInfo(@PathVariable Long bookId) {
        return ResponseEntity
                .status(OK)
                .body(bookService.getBookInfo(bookId));
    }

    @GetMapping("/search")
    public ResponseEntity<BooksGetResponse> searchBooks(@RequestParam String query,
                                                        @RequestParam String area) {
        switch (area) {
            case "title":
                return ResponseEntity
                        .status(OK)
                        .body(bookService.searchBookWithTitle(query));
            case "author":
                return ResponseEntity
                        .status(OK)
                        .body(bookService.searchBookWithAuthor(query));
            default:
                throw new IllegalArgumentException("Invalid search area. Must be 'title' or 'author'.");
        }
    }
}
