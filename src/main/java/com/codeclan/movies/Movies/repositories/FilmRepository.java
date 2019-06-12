package com.codeclan.movies.Movies.repositories;

import com.codeclan.movies.Movies.models.Actor;
import com.codeclan.movies.Movies.models.Film;
import com.codeclan.movies.Movies.models.GenreType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> getFilmsByDirectorId(Long id);

    List<Film> getFilmsByGenre(GenreType genre);

}
