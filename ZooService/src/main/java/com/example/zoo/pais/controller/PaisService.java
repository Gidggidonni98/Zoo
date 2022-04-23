package com.example.zoo.pais.controller;

import com.example.zoo.pais.model.Pais;
import com.example.zoo.pais.model.PaisRepository;
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
public class PaisService {
    @Autowired
    PaisRepository pr;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok", false, pr.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(pr.existsById(id)){
            return new ResponseEntity<>(new Message("Encontrado", false, pr.findById(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("No encontrado", true, null), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findByDescripcion(String descripcion){
        if(pr.existsByDescripcion(descripcion)){
            return new ResponseEntity<>(new Message("Actualizado", false, pr.findByDescripcion(descripcion)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Error al actualizar", true, null), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Pais p){
        Optional<Pais> exist = pr.findByDescripcion(p.getDescripcion());
        if(exist.isPresent()){
            return new ResponseEntity<>(new Message("El registro ya existe", true, null), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(new Message("Registrado", false, pr.saveAndFlush(p)), HttpStatus.OK);
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Pais p){
        if(pr.existsById(p.getId())){
            return new ResponseEntity<>(new Message("Actualizado", false, pr.saveAndFlush(p)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Error al actualizar", true, null), HttpStatus.BAD_REQUEST);
        }
    }
}
