package com.example.zoo.zoologico.controller;

import com.example.zoo.utils.Message;
import com.example.zoo.zoologico.model.Zoologico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zoo")
@CrossOrigin( {"*"})
public class ZoologicoController {
    @Autowired
    ZoologicoService zServ;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return zServ.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return zServ.findById(id);
    }

    @GetMapping("/nombre/{id}")
    public ResponseEntity<Message> getByNombre(@PathVariable("id") String nombre){
        return zServ.findByNombre(nombre);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveNombre(@RequestBody ZoologicoDTO zDto){
        return zServ.save(new Zoologico(
                zDto.getNombre(),
                zDto.getTamanyo(),
                zDto.getPresupuesto(),
                zDto.getCiudad(),
                null
        ));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCiudad(@RequestBody ZoologicoDTO zDto){
        return zServ.update(new Zoologico(
                zDto.getId(),
                zDto.getNombre(),
                zDto.getTamanyo(),
                zDto.getPresupuesto(),
                zDto.getCiudad(),
                null
        ));
    }
}
