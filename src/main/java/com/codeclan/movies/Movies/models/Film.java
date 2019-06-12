package com.codeclan.movies.Movies.models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING) // this returns genre as string, instead of object value
    private GenreType genre; // to pass in through insomnia, save as "HORROR"

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE) // repeat action for all sides of relationship,
    // using .ALL will also cascade delete everything, don't use ALL
    @JoinTable(
            name = "actors_films",   // is same name as join table in actor class
            joinColumns = { @JoinColumn(
                    name = "film_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "actor_id",
                    nullable = false,
                    updatable = false
            )}
    )
    private List<Actor> actors;


    public Film(String title, Director director, GenreType genre){
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.actors = new ArrayList<>();
    }

    public Film() {
    }



    public void addActor(Actor actor){
        this.actors.add(actor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Enum getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
