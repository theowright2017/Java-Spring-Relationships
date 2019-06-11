package com.codeclan.movies.Movies;

import com.codeclan.movies.Movies.models.Actor;
import com.codeclan.movies.Movies.models.Director;
import com.codeclan.movies.Movies.models.Film;
import com.codeclan.movies.Movies.models.GenreType;
import com.codeclan.movies.Movies.repositories.ActorRepository;
import com.codeclan.movies.Movies.repositories.DirectorRepository;
import com.codeclan.movies.Movies.repositories.FilmRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesApplicationTests {

	@Autowired
	FilmRepository filmRepository;

	@Autowired
	DirectorRepository directorRepository;

	@Autowired
	ActorRepository actorRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateFilmAndDirector(){
		Director director = new Director("Danny Boyle");
		directorRepository.save(director);
		Film film = new Film("Trainspotting", director, GenreType.COMEDY);
		filmRepository.save(film);
	}

	@Test
	public void findPirateBySalary(){
		List<Actor> results = actorRepository.findActorBySalary(250);

	}

}
