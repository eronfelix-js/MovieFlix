package com.felixDev.movieFliex.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_movie")
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String tittle;
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;
    private double rating;

    @CreationTimestamp// é usada pelo Hibernate para preencher automaticamente o campo com a data e hora em que o registro foi criado
    @Column(name = "created_At")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_At")
    private LocalDateTime updateAt;


    @ManyToMany
    @JoinTable(name = "Movie_categories",
            joinColumns = @JoinColumn(name = "Movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name = "Movie_Streaming",
            joinColumns = @JoinColumn(name = "Movie_id"),
            inverseJoinColumns = @JoinColumn(name = "streaming_id")
    )
    private List<Streaming> streaming;


}
