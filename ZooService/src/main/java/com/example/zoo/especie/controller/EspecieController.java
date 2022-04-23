package com.example.zoo.especie.controller;

import com.example.zoo.especie.model.Especie;
import com.example.zoo.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/especie")
@CrossOrigin(origins = {"*"})
public class EspecieController {
    @Autowired
    EspecieService eServ;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return eServ.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return eServ.findById(id);
    }

    @GetMapping("/comunName/{comunName}")
    public ResponseEntity<Message> getByNombreComun(@PathVariable("comunName") String nombreComun){
        return eServ.findByNombreComun(nombreComun);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveEspecie(@RequestBody EspecieDTO eDto){
        System.out.println(eDto.getFamilia()+" "+eDto.getNombreComun());
        return eServ.save(new Especie(
                eDto.getNombreComun(),
                eDto.getNombreCientifico(),
                eDto.getFamilia(),
                eDto.getPeligroExtincion(),
                eDto.getPais(),
                null
        ));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateEspecie(@RequestBody EspecieDTO eDto){
        return eServ.save(new Especie(
                eDto.getId(),
                eDto.getNombreComun(),
                eDto.getNombreCientifico(),
                eDto.getFamilia(),
                eDto.getPeligroExtincion(),
                eDto.getPais(),
                null
        ));
    }
}
