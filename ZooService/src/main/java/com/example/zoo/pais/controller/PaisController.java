package com.example.zoo.pais.controller;

import com.example.zoo.pais.model.Pais;
import com.example.zoo.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pais")
@CrossOrigin(origins = {"*"})
public class PaisController {
    @Autowired
    PaisService pServ;
    
    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return pServ.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return pServ.findById(id);
    }

    @GetMapping("/pais/{id}")
    public ResponseEntity<Message> getByDescripcion(@PathVariable("id") String descripcion){
        return pServ.findByDescripcion(descripcion);
    }

    @PostMapping("/")
    public ResponseEntity<Message> savePais(@RequestBody PaisDTO eDto){
        return pServ.save(new Pais(
                eDto.getDescripcion(),
                eDto.getContinente(),
                null
        ));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updatePais(@RequestBody PaisDTO eDto){
        return pServ.update(new Pais(
                eDto.getId(),
                eDto.getDescripcion(),
                eDto.getContinente(),
                null
        ));
    }
}
