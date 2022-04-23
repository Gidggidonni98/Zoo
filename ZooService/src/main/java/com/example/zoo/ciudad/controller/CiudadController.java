package com.example.zoo.ciudad.controller;

import com.example.zoo.ciudad.model.Ciudad;
import com.example.zoo.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ciudad")
@CrossOrigin(origins = {"*"})
public class CiudadController {
    @Autowired
    CiudadService cServ;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return cServ.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return cServ.findById(id);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<Message> getByCiudad(@PathVariable("id") long id){
        return cServ.findByEstado(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveCiudad(@RequestBody CiudadDTO cDto){
        return cServ.save(new Ciudad(
                cDto.getDescripcion(),
                cDto.getEstado(),
                null
        ));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCiudad(@RequestBody CiudadDTO cDto){
        return cServ.update(new Ciudad(
                cDto.getId(),
                cDto.getDescripcion(),
                cDto.getEstado(),
                null
        ));
    }
}
