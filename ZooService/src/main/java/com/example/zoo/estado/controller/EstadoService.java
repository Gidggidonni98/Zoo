package com.example.zoo.estado.controller;

import com.example.zoo.estado.model.Estado;
import com.example.zoo.estado.model.EstadoRepository;
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
public class EstadoService {
    @Autowired
    EstadoRepository er;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok", false, er.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(er.existsById(id)){
            return new ResponseEntity<>(new Message("Encontrado", false, er.findById(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("No encontrado", true, null), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findByDescripcion(String descripcion){
        if(er.existsByDescripcion(descripcion)){
            return new ResponseEntity<>(new Message("Actualizado", false, er.findByDescripcion(descripcion)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Error al actualizar", true, null), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Estado e){
        Optional<Estado> exist = er.findByDescripcion(e.getDescripcion());
        if(exist.isPresent()){
            return new ResponseEntity<>(new Message("El registro ya existe", true, null), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(new Message("Registrado", false, er.saveAndFlush(e)), HttpStatus.OK);
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Estado e){
        if(er.existsById(e.getId())){
            return new ResponseEntity<>(new Message("Actualizado", false, er.saveAndFlush(e)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Error al actualizar", true, null), HttpStatus.BAD_REQUEST);
        }
    }
}
