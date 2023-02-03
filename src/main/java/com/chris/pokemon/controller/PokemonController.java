package com.chris.pokemon.controller;

import com.chris.pokemon.domain.Pokemon;
import com.chris.pokemon.domain.Trainer;
import com.chris.pokemon.repository.PokemonRepository;
import com.chris.pokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PokemonController {
    private final PokemonService pokemonService;

    @GetMapping

    public ResponseEntity<List<Pokemon>> getAllPokemon()
    {
        return new ResponseEntity<>(pokemonService.findAllPokemon(), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<String> savePokemon(@RequestBody Pokemon pokemon)
    {
        pokemonService.save(pokemon);
        return new ResponseEntity<>("ok", HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePokemon(@RequestBody Pokemon pokemon)
    {
        pokemonService.delete(pokemon);
        return new ResponseEntity<>("ok", HttpStatusCode.valueOf(200));
    }

    @GetMapping
    @RequestMapping("/level/{level}")
    public ResponseEntity<List<Pokemon>> getPokemonByLevel(@PathVariable("level") String level)
    {
        return new ResponseEntity<>(pokemonService.findAllByLevel(level), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    @RequestMapping("/type/{type}")
    public ResponseEntity<List<Pokemon>> getPokemonByType(@PathVariable("type") String type)
    {
        return new ResponseEntity<>(pokemonService.findByType(type), HttpStatusCode.valueOf(200));
    }


}
