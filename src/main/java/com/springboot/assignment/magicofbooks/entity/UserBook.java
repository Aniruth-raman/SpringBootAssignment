package com.springboot.assignment.magicofbooks.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "userbook")
@Getter @Setter @NoArgsConstructor
public class UserBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "is_favorite")
    private boolean isFavorite;

    @Column(name = "is_read_later")
    private boolean isReadLater;

}
