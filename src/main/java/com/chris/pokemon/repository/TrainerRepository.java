package com.chris.pokemon.repository;

import com.chris.pokemon.domain.Trainer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    @Transactional
    Trainer findByName(String name);

}
