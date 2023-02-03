package com.chris.pokemon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trainer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    private List<Pokemon> pokemonList;

    public void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }
    public void deletePokemon(Pokemon pokemon) {
        pokemonList.removeIf((x) -> x.getId().longValue()==pokemon.getId().longValue());
    }
}
