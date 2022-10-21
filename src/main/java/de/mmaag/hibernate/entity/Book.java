package de.mmaag.hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "Books")
public class Book {
    @Id
    @Column(name = "Id", nullable = false)
    public UUID id;

    @Column(name = "AuthorId")
    public UUID authorId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Part")
    private int part;

    @Column(name = "Publisher")
    private String publisher;

    @Column(name = "Pages")
    private int pages;

    @Column(name = "Description")
    private String description;

    @Column(name = "IsRead")
    private boolean isRead;

    @Column(name = "ISBN10")
    private String isbn10;

    @Column(name = "ISBN13")
    private String isbn13;

    public Book() {

    }

    public Book(UUID id, UUID authorId, String title, String publisher, int pages, String description,
                boolean read, String isbn10, String isbn13) {
        this.setId(id);
        this.setAuthorId(authorId);
        this.setTitle(title);
        this.setPublisher(publisher);
        this.setPages(pages);
        this.setDescription(description);
        this.setRead(read);
        this.setIsbn10(isbn10);
        this.setIsbn13(isbn13);
    }
}
