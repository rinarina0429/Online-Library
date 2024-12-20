package com.gdgoc.Online_Library.Book;

import static org.springframework.http.HttpStatus.OK;

import com.gdgoc.Online_Library.Book.dto.BookGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
