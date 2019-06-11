package com.codeclan.movies.Movies.repositories;

import com.codeclan.movies.Movies.models.Actor;
import com.codeclan.movies.Movies.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
}
