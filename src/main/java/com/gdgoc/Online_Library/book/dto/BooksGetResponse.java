package com.gdgoc.Online_Library.book.dto;

import java.util.List;

public record BooksGetResponse(
        List<BookGetResponse> books
) {
    public static BooksGetResponse of(List<BookGetResponse> books) {
        return new BooksGetResponse(books);
    }
}
