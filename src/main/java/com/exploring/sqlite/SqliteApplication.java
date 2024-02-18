package com.exploring.sqlite;

import com.exploring.sqlite.models.Hero;
import com.exploring.sqlite.repository.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SqliteApplication {

    private static final Logger log = LoggerFactory.getLogger(SqliteApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SqliteApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(HeroRepository repository) {
        return (args) -> {
            repository.save(new Hero("Deadpond", "Dive Wilson", 30));
            repository.save(new Hero("Spider-Boy", "Pedro Parqueador", 20));

            log.info("Heros found with findAll():");
            repository.findAll().forEach(hero -> log.info(hero.toString()));

            Optional<Hero> hero = repository.findById(1);
            log.info("Hero found with findById(1):");
            log.info(hero.toString());
        };
    }

}
