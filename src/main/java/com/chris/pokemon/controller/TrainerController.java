package com.chris.pokemon.controller;

import com.chris.pokemon.domain.Trainer;
import com.chris.pokemon.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TrainerController {

    private final TrainerService trainerService;

    @GetMapping
    public ResponseEntity<List<Trainer>> findAllTrainers()
    {
        return new ResponseEntity<>(trainerService.findAllTrainers(), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<String> saveTrainer(@RequestBody Trainer trainer)
    {
        trainerService.save(trainer);
        return new ResponseEntity<>("ok", HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer)
    {
        return new ResponseEntity<>(trainerService.updateTrainer(trainer),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable("id") Long id)
    {
        trainerService.deleteTrainer(id);
        return new ResponseEntity<>("Deleted",HttpStatusCode.valueOf(200));
    }
}
