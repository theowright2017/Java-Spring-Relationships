package com.codeclan.movies.Movies.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "name")
    private String name;

    @OneToMany(mappedBy = "director")
    private List<Film> films;

    public Director(String name){
        this.name = name;
        this.films = new ArrayList<>(); // onetomany, dont need to new list
    }

    public Director() {
    }

    public void addFilm(Film film){
        this.films.add(film);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
