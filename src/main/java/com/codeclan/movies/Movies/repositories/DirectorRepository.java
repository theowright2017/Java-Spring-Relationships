package com.codeclan.movies.Movies.repositories;

import com.codeclan.movies.Movies.models.Actor;
import com.codeclan.movies.Movies.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}

