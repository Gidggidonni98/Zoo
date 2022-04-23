package com.example.zoo.animal.controller;

import com.example.zoo.animal.model.Animal;
import com.example.zoo.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animal")
@CrossOrigin(origins = {"*"})
public class AnimalController {
    @Autowired
    AnimalService aServ;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return aServ.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return aServ.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveAnimal(@RequestBody AnimalDTO aDto){
        return aServ.save(new Animal(
                aDto.getClaveAnimal(),
                aDto.getFechaNacimiento(),
                aDto.getZoologico(),
                aDto.getGenero(),
                aDto.getEspecie()
        ));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateAnimal(@RequestBody AnimalDTO aDto){
        return aServ.update(new Animal(
                aDto.getId(),
                aDto.getClaveAnimal(),
                aDto.getFechaNacimiento(),
                aDto.getZoologico(),
                aDto.getGenero(),
                aDto.getEspecie()
        ));
    }
}
