package com.gdgoc.Online_Library.Book.dto;

import com.gdgoc.Online_Library.Book.Book;
import com.gdgoc.Online_Library.Common.Status;

public record BookGetResponse(
        String title,
        String author,
        String publisher,
        Status status
) {
    public static BookGetResponse of(Book book) {
        return new BookGetResponse(
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getStatus()
        );
    }
}
