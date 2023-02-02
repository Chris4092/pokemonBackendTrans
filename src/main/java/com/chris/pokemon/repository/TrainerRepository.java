package com.chris.pokemon.repository;

import com.chris.pokemon.domain.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findByName(String name);
}
