package com.gdgoc.Online_Library.book.dto;

import com.gdgoc.Online_Library.book.Book;
import com.gdgoc.Online_Library.common.Status;

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
