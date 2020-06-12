package com.javafun.graphql.spqr.model;


import graphql.schema.GraphQLInputType;
import io.leangen.graphql.annotations.GraphQLInputField;


public class FilmMutationInput {

    public String getName() {
        return "filmMutationInput";
    }

    public String getFilmName() {
        return filmName;
    }

    String filmName;
    Integer id;

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
