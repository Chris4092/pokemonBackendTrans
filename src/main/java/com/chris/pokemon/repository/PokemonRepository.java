package com.chris.pokemon.repository;

import com.chris.pokemon.domain.Pokemon;
import com.chris.pokemon.domain.Trainer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    @Transactional
    List<Pokemon> findAllByPrimaryTypeOrSecondaryType(String type,String type2);

    @Transactional
    List<Pokemon> findAllByLevel(Integer level);

    @Transactional
    List<Pokemon> findAllByLevelGreaterThan(Integer level);

    @Transactional
    List<Pokemon> findAllByLevelLessThan(Integer level);

    @Transactional
    List<Pokemon> findAllByName(String name);

    @Transactional
    void deleteAllByTrainer(Trainer trainer);

}
