package com.gdgoc.Online_Library.Book;

import com.gdgoc.Online_Library.Common.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String publisher;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ColumnDefault("'AVAILABLE'")
    private Status status;

    @Builder
    public Book(String title, String author, String publisher, Status status) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.status = status;
    }
}
