package com.example.zoo.zoologico.controller;

import com.example.zoo.utils.Message;
import com.example.zoo.zoologico.model.Zoologico;
import com.example.zoo.zoologico.model.ZoologicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class ZoologicoService {
    @Autowired
    ZoologicoRepository zr;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok", false, zr.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(zr.existsById(id)){
            return new ResponseEntity<>(new Message("Encontrado", false, zr.findById(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("No encontrado", true, null), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findByNombre(String nombre){
        if(zr.existsByNombre(nombre)){
            return new ResponseEntity<>(new Message("Actualizado", false, zr.findByNombre(nombre)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Error al actualizar", true, null), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Zoologico z){
        Optional<Zoologico> exist = zr.findByNombre(z.getNombre());
        if(exist.isPresent()){
            return new ResponseEntity<>(new Message("El registro ya existe", true, null), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(new Message("Registrado", false, zr.saveAndFlush(z)), HttpStatus.OK);
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Zoologico z){
        if(zr.existsById(z.getId())){
            return new ResponseEntity<>(new Message("Actualizado", false, zr.saveAndFlush(z)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Error al actualizar", true, null), HttpStatus.BAD_REQUEST);
        }
    }
}
