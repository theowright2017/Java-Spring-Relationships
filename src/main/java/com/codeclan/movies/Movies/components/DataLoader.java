package com.codeclan.movies.Movies.components;


import com.codeclan.movies.Movies.models.Actor;
import com.codeclan.movies.Movies.models.Director;
import com.codeclan.movies.Movies.models.Film;
import com.codeclan.movies.Movies.models.GenreType;
import com.codeclan.movies.Movies.repositories.ActorRepository;
import com.codeclan.movies.Movies.repositories.DirectorRepository;
import com.codeclan.movies.Movies.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    DirectorRepository directorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Director tarantino = new Director("Quentin Tarantino");
        directorRepository.save(tarantino);
        Director speilberg = new Director("Steven Speilberg");
        directorRepository.save(speilberg);

        Film hatefulEight = new Film("Hateful Eight", tarantino, GenreType.THRILLER);
        filmRepository.save(hatefulEight);
        Film pulp = new Film("Pulp Fiction", tarantino, GenreType.THRILLER);
        filmRepository.save(pulp);
        Film diehard = new Film("Die Hard with Vengeance", speilberg, GenreType.THRILLER);
        filmRepository.save(diehard);

        Actor bruce = new Actor("Bruce Willis", 45, 250);
        actorRepository.save(bruce);
        Actor sam = new Actor("Samuel L. Jackson", 52, 300);
        actorRepository.save(sam);

        hatefulEight.addActor(sam);
        pulp.addActor(sam);
        pulp.addActor(bruce);
        diehard.addActor(sam);
        diehard.addActor(bruce);



    }
}
