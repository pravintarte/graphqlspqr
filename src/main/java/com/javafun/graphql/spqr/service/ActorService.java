package com.javafun.graphql.spqr.service;

import com.javafun.graphql.spqr.Repository.ActorRepository;
import com.javafun.graphql.spqr.Repository.FilmRepository;
import com.javafun.graphql.spqr.model.Actor;
import com.javafun.graphql.spqr.model.Film;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLDirective;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private FilmRepository filmRepository;

    @GraphQLQuery
    public Actor getActorById(@GraphQLArgument(name = "id") Integer id){
        return actorRepository.findById(id).get();
    }

    @GraphQLQuery
    public Actor getActorByFirstName(@GraphQLArgument(name = "actorName") String actorName){
        return actorRepository.findActorByFirstNameLike(actorName);
    }

    @GraphQLQuery
    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }

    @GraphQLQuery
    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    @GraphQLMutation
    public Actor updateAddress(@GraphQLArgument(name="id") Integer id,@GraphQLArgument(name="address")String address){
        Actor actor = actorRepository.findById(id).get();
        actor.setAddress(address);
        actorRepository.save(actor);
        return actor;
    }


    @GraphQLQuery
    public Actor tests(@GraphQLDirective(name = "directive") String directive){
        return actorRepository.getOne(1);
    }
}
