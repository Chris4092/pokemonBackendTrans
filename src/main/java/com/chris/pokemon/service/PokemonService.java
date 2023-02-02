package com.chris.pokemon.service;

import com.chris.pokemon.domain.Pokemon;
import com.chris.pokemon.domain.Trainer;
import com.chris.pokemon.repository.PokemonRepository;
import com.chris.pokemon.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    private final TrainerRepository trainerRepository;

    public void save(Pokemon pokemon)
    {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(pokemon.getId());
        if(pokemonOptional.isPresent())
        {
            throw new RuntimeException();
        }
        else
        {
            pokemonRepository.save(pokemon);
            Optional<Trainer>trainerOptional =  trainerRepository.findById(pokemon.getTrainer().getId());
            if(trainerOptional.isPresent())
            {
                Trainer trainer = trainerOptional.get();
                trainer.addPokemon(pokemon);
                trainerRepository.save(trainer);
            }
            else {
                throw new RuntimeException();
            }
        }
    }

    public void delete(Long id)
    {
        pokemonRepository.deleteById(id);
    }

    public Pokemon findById(Long id)
    {
        return pokemonRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Pokemon> findByType(String type)
    {
        return pokemonRepository.findAllByPrimaryTypeOrSecondaryType(type,type);
    }

    public List<Pokemon> findAllByLevel(String level)
    {
        int IntegerParsed = Integer.parseInt(String.valueOf(level.subSequence(1, level.length())));
        if(level.charAt(0) == '>')
        {
            Integer levelInteger = IntegerParsed;
            return pokemonRepository.findAllByLevelGreaterThan(levelInteger);
        }
        else if(level.charAt(0) == '<')
        {
            Integer levelInteger = IntegerParsed;
            return pokemonRepository.findAllByLevelLessThan(levelInteger);
        }
        else{
            return pokemonRepository.findAllByLevel(Integer.valueOf(level));
        }
    }

    public List<Pokemon> findAllByName(String name)
    {
        return pokemonRepository.findAllByName(name);
    }

    public List<Pokemon> findAllPokemon() {
        return pokemonRepository.findAll();
    }
}
