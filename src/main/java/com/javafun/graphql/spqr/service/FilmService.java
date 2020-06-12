package com.javafun.graphql.spqr.service;

import com.javafun.graphql.spqr.Repository.FilmRepository;
import com.javafun.graphql.spqr.model.Actor;
import com.javafun.graphql.spqr.model.Film;
import com.javafun.graphql.spqr.model.FilmMutationInput;
import io.leangen.graphql.annotations.*;
import io.leangen.graphql.annotations.types.GraphQLType;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@GraphQLApi
public class FilmService {

    @Autowired
    private FilmRepository repository;


    public Film getFilm(Actor actor){
        return repository.findById(actor.getFilmId()).get();
    }


    @Transactional
    @GraphQLMutation
    public Film updateFilmName(@GraphQLArgument(name = "id") Integer id,@GraphQLArgument(name = "name") String name){
        Film film = repository.getOne(id);
        film.setName(name);
        repository.save(film);

        return film;
    }

    @Transactional
    @GraphQLMutation
    public Film updateFilmNameByInputObject(@GraphQLInputField(name = "filmMutation") FilmMutationInput input){
        Film film = repository.getOne(input.getId());
        film.setName(input.getFilmName());
        repository.save(film);
        return film;
    }






}
