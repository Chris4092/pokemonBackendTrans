package com.chris.pokemon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pokemon {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String primaryType;
    private String secondaryType;
    private Integer level;
    private String nickname;
    @ManyToOne
    @JsonIgnoreProperties("pokemonList")
    private Trainer trainer;
}
