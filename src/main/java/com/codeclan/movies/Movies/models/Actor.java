package com.codeclan.movies.Movies.models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    private int age;

    @Column
    private int salary;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "actors_films",
             joinColumns = { @JoinColumn(
                    name = "actor_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = { @JoinColumn(
                    name = "film_id",
                    nullable = false,
                    updatable = false
            )}
    )
    private List<Film> films;

    public Actor(String name, int age, int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this .films = new ArrayList<>();
    }

    public Actor() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
