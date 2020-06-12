package com.javafun.graphql.spqr.Repository;

import com.javafun.graphql.spqr.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ActorRepository extends JpaRepository<Actor,Integer> {

    public Actor findActorByFirstNameLike(String name);
}
