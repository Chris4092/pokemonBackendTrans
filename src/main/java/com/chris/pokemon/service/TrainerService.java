package com.chris.pokemon.service;

import com.chris.pokemon.domain.Pokemon;
import com.chris.pokemon.domain.Trainer;
import com.chris.pokemon.repository.PokemonRepository;
import com.chris.pokemon.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final PokemonRepository pokemonRepository;

    public void save(Trainer trainer)
    {
        trainerRepository.save(trainer);
    }

    public void deleteTrainer(Long trainerId)
    {
        Optional<Trainer> trainerOptional = trainerRepository.findById(trainerId);
        trainerOptional.ifPresentOrElse((pokemonRepository::deleteAllByTrainer),() -> {throw new RuntimeException();});
        trainerRepository.deleteById(trainerId);
    }

    public List<Trainer> findAllTrainers()
    {
        return trainerRepository.findAll();
    }

    public Trainer updateTrainer(Trainer trainer)
    {
        return trainerRepository.save(trainer);
    }

    public Trainer findByName(String name){
        return trainerRepository.findByName(name);
    }

}
