package com.exploring.sqlite.repository;

import com.exploring.sqlite.models.Hero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HeroRepository extends CrudRepository<Hero, Integer> {
    List<Hero> findBySecretName(String   secretName);
    Optional<Hero> findById(int id);
}
