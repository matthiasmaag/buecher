package de.mmaag.hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Author")
public class Author {
    @Id
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Column(name = "Name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "AuthorId")
    private List<Book> books;

    @Override
    public String toString() {
        return this.getName();
    }

    public Author() {
    }

    public Author(UUID id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }
}
