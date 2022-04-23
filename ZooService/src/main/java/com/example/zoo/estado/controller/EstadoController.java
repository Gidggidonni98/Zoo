package com.example.zoo.estado.controller;

import com.example.zoo.estado.model.Estado;
import com.example.zoo.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estado")
@CrossOrigin(origins = {"*"})
public class EstadoController {
    @Autowired
    EstadoService eServ;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return eServ.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return eServ.findById(id);
    }

    @GetMapping("/estado/{id}")
    public ResponseEntity<Message> getByDescripcion(@PathVariable("id") String descripcion){
        return eServ.findByDescripcion(descripcion);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveEstado(@RequestBody EstadoDTO eDto){
        return eServ.save(new Estado(
                eDto.getDescripcion(),
                eDto.getPais(),
                null
        ));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateEstado(@RequestBody EstadoDTO eDto){
        return eServ.update(new Estado(
                eDto.getId(),
                eDto.getDescripcion(),
                eDto.getPais(),
                null
        ));
    }
}
