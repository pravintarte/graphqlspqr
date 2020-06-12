package com.javafun.graphql.spqr.Repository;

import com.javafun.graphql.spqr.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface FilmRepository extends JpaRepository<Film,Integer> {

}
