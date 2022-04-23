package com.example.zoo.ciudad.controller;

import com.example.zoo.ciudad.model.Ciudad;
import com.example.zoo.ciudad.model.CiudadRepository;
import com.example.zoo.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class CiudadService {
    @Autowired
    CiudadRepository cr;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok", false, cr.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(cr.existsById(id)){
            return new ResponseEntity<>(new Message("Encontrado", false, cr.findById(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("No encontrado", true, null), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findByEstado(long id){
        if(cr.existsByEstado_Id(id)){
            return new ResponseEntity<>(new Message("Actualizado", false, cr.findByEstado_Id(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Error al actualizar", true, null), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Ciudad c){
        Optional<Ciudad> exist = cr.findByDescripcion(c.getDescripcion());
        if(exist.isPresent()){
            return new ResponseEntity<>(new Message("El registro ya existe", true, null), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(new Message("Registrado", false, cr.saveAndFlush(c)), HttpStatus.OK);
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Ciudad c){
        if(cr.existsById(c.getId())){
            return new ResponseEntity<>(new Message("Actualizado", false, cr.saveAndFlush(c)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Error al actualizar", true, null), HttpStatus.BAD_REQUEST);
        }
    }
}
