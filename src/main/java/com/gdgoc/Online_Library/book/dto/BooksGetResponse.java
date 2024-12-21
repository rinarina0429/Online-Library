package com.gdgoc.Online_Library.book.dto;

import com.gdgoc.Online_Library.book.Book;
import java.util.List;
import java.util.stream.Collectors;

public record BooksGetResponse(
        List<BookGetResponse> books
) {
    public static BooksGetResponse of(List<Book> books) {
        List<BookGetResponse> bookResponses = books.stream()
                .map(BookGetResponse::of)
                .collect(Collectors.toList());
        return new BooksGetResponse(bookResponses);
    }
}
